package com.enaz.baratostore.feed

import com.enaz.baratostore.common.fragment.BaseFragment
import com.enaz.baratostore.feed.databinding.FeedFragmentBinding
import kotlinx.android.synthetic.main.feed_fragment.*
import javax.inject.Inject

class FeedFragment : BaseFragment<FeedFragmentBinding, FeedViewModel>() {

    @Inject
    override lateinit var viewModel: FeedViewModel

    override fun createLayout() = R.layout.feed_fragment

    override fun getBindingVariable() = BR.feedViewModel

    override fun initData() {
        //TODO: Do nothing as of the moment
    }

    override fun initViews() {
        //TODO: Do nothing as of the moment
    }

    override fun subscribeUi() {
        with(viewModel) {
            feedTextView.text = text.value
        }
    }

    companion object {
        fun newInstance() = FeedFragment()
    }
}