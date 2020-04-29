package com.enaz.baratostore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.enaz.baratostore.home.R
import com.enaz.baratostore.home.databinding.HomeProductItemBinding
import com.enaz.baratostore.model.HomeProductItem

/**
 * Created by eduardo.delito on 4/29/20.
 */
class HomeListAdapter(val homeListAdapterListener: HomeListAdapterListener) : RecyclerView.Adapter<HomeListAdapter.HomeProductViewHolder>() {

    private var list: List<HomeProductItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductViewHolder {
        val binding: HomeProductItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.home_product_item, parent, false)
        return HomeProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeProductViewHolder, position: Int) {
        holder.homeProductItemBinding.productItem = list[position]
        holder.homeProductItemBinding.executePendingBindings()
//        holder.binding.trackCardView.setOnClickListener {
//            homeListAdapterListener.onHomeProductSelect(list[position])
//        }
    }

    /**
     * Function to update the track item list data
     *
     * @param list the new set of data
     */
    fun updateDataSet(list: List<HomeProductItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class HomeProductViewHolder(val homeProductItemBinding: HomeProductItemBinding) : RecyclerView.ViewHolder(homeProductItemBinding.root)

    interface HomeListAdapterListener {
        fun onHomeProductSelect(homeProductItem: HomeProductItem)
    }
}
