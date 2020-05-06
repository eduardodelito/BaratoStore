package com.enaz.baratostore.home

import android.content.Context
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.enaz.baratostore.adapter.HomeListAdapter
import com.enaz.baratostore.common.fragment.BaseFragment
import com.enaz.baratostore.common.util.MarginItemDecoration
import com.enaz.baratostore.common.util.setLabelWithVisibility
import com.enaz.baratostore.database.entity.ProductEntity
import com.enaz.baratostore.database.mapper.entityModelToProductItemList
import com.enaz.baratostore.database.model.ProductItem
import com.enaz.baratostore.home.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(),
    SearchView.OnQueryTextListener {

    @Inject
    override lateinit var viewModel: HomeViewModel

    private lateinit var homeListAdapter: HomeListAdapter

    private var mListener: OnHomeFragmentFragmentListener? = null

    override fun createLayout() = R.layout.home_fragment

    override fun getBindingVariable() = BR.viewModel

    override fun initData() {
        //Do nothing
    }

    override fun initViews() {
        setHasOptionsMenu(true)
        homeListAdapter = HomeListAdapter(object : HomeListAdapter.HomeListAdapterListener {
            override fun onHomeProductSelect(productItem: ProductItem) {
                mListener?.onHomeProductItemClicked(productItem)
            }
        })

        with (homeProductRecyclerView) {
            layoutManager = GridLayoutManager(context, SPAN_COUNT)
            adapter = homeListAdapter
            addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.padding_16dp).toInt(), SPAN_COUNT))
        }

        homeSearchView.setOnQueryTextListener(this)

        homeSwipeToRefresh.setOnRefreshListener {
            viewModel.refreshProducts()
        }
    }

    override fun subscribeUi() {
        with(viewModel) {
            isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
                homeSwipeToRefresh.isRefreshing = isLoading
            })

            getProducts().observe(viewLifecycleOwner, Observer<List<ProductEntity>> {
                with(it) {
                    invalidResultTextView.setLabelWithVisibility(isEmpty())
                    homeListAdapter.updateDataSet(entityModelToProductItemList())
                }
            })
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnHomeFragmentFragmentListener) {
            mListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onQueryTextSubmit(query: String?) = viewModel.handleQueryTextSubmit(query)

    override fun onQueryTextChange(newText: String?) = viewModel.handleQueryTextChange(newText)

    /**
     * Interface to handle callbacks
     * */
    interface OnHomeFragmentFragmentListener {
        /**
         * Function to handle list item clicked callback to class that implement it.
         *
         * @param productItem the selected product item
         * */
        fun onHomeProductItemClicked(productItem: ProductItem)
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_main, menu)

        //hide some items from this fragment (e.g. sort)
        menu.findItem(R.id.action_delete).isVisible = false
        menuInflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

    /**
     * Option menu to delete data list.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_delete -> {
                viewModel.deleteProducts()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val SPAN_COUNT = 3
        fun newInstance() = HomeFragment()
    }
}
