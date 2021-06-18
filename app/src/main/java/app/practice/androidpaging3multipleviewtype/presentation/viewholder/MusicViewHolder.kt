package app.practice.androidpaging3multipleviewtype.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.practice.androidpaging3multipleviewtype.databinding.ItemMusicBinding
import app.practice.androidpaging3multipleviewtype.domain.model.ItemViewType.MusicModel

class MusicViewHolder(private val binding: ItemMusicBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): MusicViewHolder {
            val binding =
                ItemMusicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return MusicViewHolder(binding)
        }
    }

    fun bind(item: MusicModel) {
        binding.titleTextView.text = item.shelftTtle + " | items : ${item.items.size}"
    }

}