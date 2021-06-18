package app.practice.androidpaging3multipleviewtype.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.practice.androidpaging3multipleviewtype.databinding.ItemBannerBinding
import app.practice.androidpaging3multipleviewtype.domain.model.ItemViewType.BannerModel

class BannerViewHolder(private val binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): BannerViewHolder {
            val binding =
                ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return BannerViewHolder(binding)
        }
    }

    fun bind(item: BannerModel) {
        binding.titleTextView.text = "banner ID = " + item.shelfId
    }

}