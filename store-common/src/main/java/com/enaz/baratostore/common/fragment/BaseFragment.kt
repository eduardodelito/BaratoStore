package com.enaz.baratostore.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.enaz.baratostore.common.viewmodel.BaseViewModel
import dagger.android.support.DaggerFragment
import java.lang.reflect.ParameterizedType

/**
 * Base Fragment Class that will handle shared events/transactions to all fragments that will subclass this
 *
 * Created by eduardo.delito on 4/23/20.
 */
abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : DaggerFragment() {
    private lateinit var viewDataBinding: T

    protected abstract val viewModel: V

    /**
     * Abstract function to set fragment layout
     *
     * @return the layout id
     */
    abstract fun createLayout(): Int

    /**
     * Abstract function to set binding variable
     *
     * @return the binding variable id
     */
    abstract fun getBindingVariable(): Int

    /**
     * Abstract function to initialize variables/objects
     */
    abstract fun initData()

    /**
     * Abstract function to initialize views
     */
    abstract fun initViews()

    /**
     * Abstract function to subscribe to live data of view model
     */
    abstract fun subscribeUi()

    /**
     * Function to get the data binding of the current fragment
     *
     * @return the data binding of the current fragment
     */
    fun getBinding() = viewDataBinding

    /**
     * Function to get the viewModel class
     *
     * @return the viewModel class
     */
    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClass() =
        (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<V>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
        initViews()
        subscribeUi()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (::viewDataBinding.isInitialized.not()) {
            viewDataBinding = DataBindingUtil.inflate(inflater, createLayout(), container, false)
            viewDataBinding.apply {
                setVariable(getBindingVariable(), viewModel)
                lifecycleOwner = viewLifecycleOwner
                executePendingBindings()
            }
        }
        return viewDataBinding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onStop() {
        super.onStop()
        viewModel.onStop()
    }
}
