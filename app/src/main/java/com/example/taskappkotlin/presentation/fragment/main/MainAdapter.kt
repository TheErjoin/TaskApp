package com.example.taskappkotlin.presentation.fragment.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.ShopItem
import com.example.taskappkotlin.databinding.ItemShopEnabledBinding

class MainAdapter :
    ListAdapter<ShopItem, MainAdapter.ShopItemEnabledViewHolder>(ShopItemDiffCallBack()) {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainAdapter.ShopItemEnabledViewHolder {
        return ShopItemEnabledViewHolder(
            ItemShopEnabledBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.ShopItemEnabledViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ShopItemDiffCallBack : DiffUtil.ItemCallback<ShopItem>() {
        override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean = oldItem == newItem
    }

    inner class ShopItemEnabledViewHolder(private val binding: ItemShopEnabledBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ShopItem) {
            binding.tvName.text = item.name
            binding.tvCount.text = item.count.toString()

            binding.root.setOnClickListener {
                onShopItemClickListener?.invoke(getItem(absoluteAdapterPosition))
            }
            binding.root.setOnLongClickListener {
                onShopItemLongClickListener?.invoke(getItem(absoluteAdapterPosition))
                true
            }
        }
    }
}
