package com.enaz.baratostore.add

import android.content.Context
import com.enaz.baratostore.add.databinding.AddFragmentBinding
import com.enaz.baratostore.common.fragment.BaseFragment
import com.enaz.baratostore.database.model.ProductItem
import kotlinx.android.synthetic.main.add_fragment.*
import javax.inject.Inject

class AddFragment : BaseFragment<AddFragmentBinding, AddViewModel>() {

    @Inject
    override lateinit var viewModel: AddViewModel

    override fun createLayout() = R.layout.add_fragment

    override fun getBindingVariable() = BR.addViewModel

    private var listener: OnAddFragmentListener? = null

    override fun initData() {
        //TODO: Do nothing as of the moment
    }

    override fun initViews() {
        post_button.setOnClickListener {
            viewModel.addProduct(product_name.text.toString(), product_description.text.toString(), listener)
        }
    }

    override fun subscribeUi() {
        with(viewModel) {

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAddFragmentListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * Interface to handle callbacks
     * */
    interface OnAddFragmentListener {
        /**
         * Display home menu once adding product is completed.
         * */
        fun setSelectedAddMenu()
    }

    companion object {
        fun newInstance() = AddFragment()
    }
}
