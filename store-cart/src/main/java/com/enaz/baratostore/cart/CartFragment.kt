package com.enaz.baratostore.cart

import com.enaz.baratostore.cart.databinding.CartFragmentBinding
import com.enaz.baratostore.common.fragment.BaseFragment
import kotlinx.android.synthetic.main.cart_fragment.*
import javax.inject.Inject

class CartFragment : BaseFragment<CartFragmentBinding, CartViewModel>() {

    @Inject
    override lateinit var viewModel: CartViewModel

    override fun createLayout() = R.layout.cart_fragment

    override fun getBindingVariable() = BR.cartViewModel

    override fun initData() {
        //TODO: Do nothing as of the moment
    }

    override fun initViews() {
        //TODO: Do nothing as of the moment
    }

    override fun subscribeUi() {
        with(viewModel) {
            cartTextView.text = text.value
        }
    }

    companion object {
        fun newInstance() = CartFragment()
    }
}
