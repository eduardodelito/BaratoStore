package com.enaz.baratostore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.enaz.baratostore.database.model.ProductItem
import com.enaz.baratostore.home.R
import com.enaz.baratostore.home.databinding.HomeProductItemBinding

/**
 * Created by eduardo.delito on 4/29/20.
 */
class HomeListAdapter(val homeListAdapterListener: HomeListAdapterListener) : RecyclerView.Adapter<HomeListAdapter.HomeProductViewHolder>() {

    private var list: List<ProductItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductViewHolder {
        val binding: HomeProductItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.home_product_item, parent, false)
        return HomeProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeProductViewHolder, position: Int) {
        holder.productItemBinding.productItem = list[position]
        holder.productItemBinding.executePendingBindings()
        holder.productItemBinding.homeCardView.setOnClickListener {
            homeListAdapterListener.onHomeProductSelect(list[position])
        }
    }

    /**
     * Function to update the track item list data
     *
     * @param list the new set of data
     */
    fun updateDataSet(list: List<ProductItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class HomeProductViewHolder(val productItemBinding: HomeProductItemBinding) : RecyclerView.ViewHolder(productItemBinding.root)

    interface HomeListAdapterListener {
        fun onHomeProductSelect(productItem: ProductItem)
    }
}
