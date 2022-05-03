package com.example.taskappkotlin.presentation.fragment.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.ShopItem
import com.example.taskappkotlin.databinding.ItemShopDisabledBinding
import com.example.taskappkotlin.databinding.ItemShopEnabledBinding

class MainAdapter :
    ListAdapter<ShopItem, RecyclerView.ViewHolder>(ShopItemDiffCallback()) {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    private var newList = mutableListOf<ShopItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ENABLE) {
            ShopItemDisableViewHolder(
                ItemShopDisabledBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            ShopItemEnabledViewHolder(
                ItemShopEnabledBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    private fun changeShopItem(position: Int) {
        newList = ArrayList(currentList)
        newList[position] = newList[position].copy(enabled = !getItem(position).enabled)
        submitList(newList)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == VIEW_TYPE_ENABLE) {
            holder as ShopItemDisableViewHolder
            holder.onBind(getItem(position))
        } else {
            holder as ShopItemEnabledViewHolder
            holder.onBind(getItem(position))
        }
        holder.itemView.setOnLongClickListener {
            changeShopItem(holder.absoluteAdapterPosition)
            true
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            VIEW_TYPE_ENABLE
        } else {
            VIEW_TYPE_DISABLE
        }
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

    inner class ShopItemDisableViewHolder(private val binding: ItemShopDisabledBinding) :
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

    companion object {
        const val VIEW_TYPE_ENABLE = 100
        const val VIEW_TYPE_DISABLE = 101
    }


}
