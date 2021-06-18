package app.practice.androidpaging3multipleviewtype.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.practice.androidpaging3multipleviewtype.R
import app.practice.androidpaging3multipleviewtype.data.model.ItemResponse
import app.practice.androidpaging3multipleviewtype.databinding.ItemPlaceHolderBinding
import app.practice.androidpaging3multipleviewtype.databinding.ItemShelfBinding

class HomeAdapter : PagingDataAdapter<ItemResponse, RecyclerView.ViewHolder>(diffItem) {

    companion object {
        val diffItem = object : DiffUtil.ItemCallback<ItemResponse>() {
            override fun areItemsTheSame(oldItem: ItemResponse, newItem: ItemResponse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ItemResponse, newItem: ItemResponse): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        if (getItem(position) != null) {
            return R.layout.item_shelf
        } else {
            return R.layout.item_place_holder
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_shelf -> {
                val binding =
                    ItemShelfBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ItemTextViewHolder(binding)
            }
            else -> {
                val binding =
                    ItemPlaceHolderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return PlaceholderViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        getItem(position)?.let { item ->
            (holder as? ItemTextViewHolder)?.bind(item)
        } ?: (holder as? PlaceholderViewHolder)?.bind()

    }

    inner class ItemTextViewHolder(private val binding: ItemShelfBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemResponse?) {
            binding.titleTextView.text = item?.title
        }

    }

    inner class PlaceholderViewHolder(private val binding: ItemPlaceHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
        }

    }

}