package app.practice.androidpaging3multipleviewtype.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.practice.androidpaging3multipleviewtype.databinding.ItemMovieBinding
import app.practice.androidpaging3multipleviewtype.domain.model.ItemViewType.MovieModel

class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): MovieViewHolder {
            val binding =
                ItemMovieBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return MovieViewHolder(binding)
        }
    }

    fun bind(item: MovieModel) {
        binding.titleTextView.text = item.shelftTitle + " | items : ${item.items.size}"
    }

}