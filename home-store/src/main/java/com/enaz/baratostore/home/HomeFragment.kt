package com.enaz.baratostore.home

import com.enaz.baratostore.common.fragment.BaseFragment
import com.enaz.baratostore.home.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {

    @Inject
    override lateinit var viewModel: HomeViewModel

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun createLayout() = R.layout.home_fragment

    override fun getBindingVariable() = BR.viewModel

    override fun initData() {
        //TODO: Do nothing as of the moment
    }

    override fun initViews() {
        //TODO: Do nothing as of the moment
    }

    override fun subscribeUi() {
        with(viewModel) {
            homeTextView.text = text.value
        }
    }
}
