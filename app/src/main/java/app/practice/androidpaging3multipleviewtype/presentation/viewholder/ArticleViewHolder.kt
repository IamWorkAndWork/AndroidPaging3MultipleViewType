package app.practice.androidpaging3multipleviewtype.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.practice.androidpaging3multipleviewtype.databinding.ItemArticleBinding
import app.practice.androidpaging3multipleviewtype.domain.model.ItemViewType.ArticleModel

class ArticleViewHolder(private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): ArticleViewHolder {
            val binding =
                ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ArticleViewHolder(binding)
        }
    }

    fun bind(item: ArticleModel) {
        binding.titleTextView.text = item.shelftTitle + " | items : ${item.items.size}"
    }

}