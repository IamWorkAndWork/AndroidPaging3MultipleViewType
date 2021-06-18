package app.practice.androidpaging3multipleviewtype.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.practice.androidpaging3multipleviewtype.databinding.ItemLargeBannerBinding
import app.practice.androidpaging3multipleviewtype.domain.model.ItemViewType.LargeBannerModel

class LargeBannerViewHolder(private val binding: ItemLargeBannerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): LargeBannerViewHolder {
            val binding =
                ItemLargeBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LargeBannerViewHolder(binding)
        }
    }

    fun bind(item: LargeBannerModel) {
        binding.titleTextView.text = "large banner ID = " + item.shelfId
    }

}