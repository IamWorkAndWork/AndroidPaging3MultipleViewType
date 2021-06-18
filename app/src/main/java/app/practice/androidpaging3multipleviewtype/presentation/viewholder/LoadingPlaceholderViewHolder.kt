package app.practice.androidpaging3multipleviewtype.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.practice.androidpaging3multipleviewtype.databinding.ItemLoadingPlaceHolderBinding

class LoadingPlaceholderViewHolder(private val binding: ItemLoadingPlaceHolderBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): LoadingPlaceholderViewHolder {
            val binding =
                ItemLoadingPlaceHolderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return LoadingPlaceholderViewHolder(binding)
        }
    }

    fun bind() {

    }

}