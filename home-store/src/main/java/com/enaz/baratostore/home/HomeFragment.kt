package com.enaz.baratostore.home

import android.content.Context
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.enaz.baratostore.adapter.HomeListAdapter
import com.enaz.baratostore.common.fragment.BaseFragment
import com.enaz.baratostore.common.util.MarginItemDecoration
import com.enaz.baratostore.home.databinding.HomeFragmentBinding
import com.enaz.baratostore.model.HomeProductItem
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
        //TODO: Do nothing as of the moment
    }

    override fun initViews() {
        homeListAdapter = HomeListAdapter(object : HomeListAdapter.HomeListAdapterListener {
            override fun onHomeProductSelect(homeProductItem: HomeProductItem) {
                mListener?.onHomeProductItemClicked(homeProductItem)
            }
        })

        with (homeProductRecyclerView) {
            layoutManager = GridLayoutManager(context, SPAN_COUNT)
            adapter = homeListAdapter
            addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.padding_16dp).toInt(), SPAN_COUNT))
        }

        homeSearchView.setOnQueryTextListener(this)

        homeSwipeToRefresh.setOnRefreshListener {
//            viewModel.searchMovie(null)
        }
    }

    override fun subscribeUi() {
        //TODO: Do nothing as of the moment
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
         * @param homeProductItem the selected product item
         * */
        fun onHomeProductItemClicked(homeProductItem: HomeProductItem)
    }

    companion object {
        const val SPAN_COUNT = 2
        fun newInstance() = HomeFragment()
    }
}
