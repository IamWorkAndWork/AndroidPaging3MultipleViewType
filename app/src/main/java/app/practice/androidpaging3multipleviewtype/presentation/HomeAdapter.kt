package app.practice.androidpaging3multipleviewtype.presentation

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.practice.androidpaging3multipleviewtype.R
import app.practice.androidpaging3multipleviewtype.domain.model.ItemViewType
import app.practice.androidpaging3multipleviewtype.domain.model.ItemViewType.*
import app.practice.androidpaging3multipleviewtype.presentation.viewholder.*

class HomeAdapter : PagingDataAdapter<ItemViewType, RecyclerView.ViewHolder>(diffItem) {

    companion object {
        val diffItem = object : DiffUtil.ItemCallback<ItemViewType>() {
            override fun areItemsTheSame(oldItem: ItemViewType, newItem: ItemViewType): Boolean {
                return oldItem.shelfId == newItem.shelfId
            }

            override fun areContentsTheSame(oldItem: ItemViewType, newItem: ItemViewType): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item) {
            is BannerModel -> {
                R.layout.item_banner
            }
            is LargeBannerModel -> {
                R.layout.item_large_banner
            }
            is ArticleModel -> {
                R.layout.item_article
            }
            is MusicModel -> {
                R.layout.item_music
            }
            is MovieModel -> {
                R.layout.item_movie
            }
            else -> {
                R.layout.item_loading_place_holder
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_banner -> {
                BannerViewHolder.create(parent = parent)
            }
            R.layout.item_large_banner -> {
                LargeBannerViewHolder.create(parent = parent)
            }
            R.layout.item_article -> {
                ArticleViewHolder.create(parent = parent)
            }
            R.layout.item_movie -> {
                MovieViewHolder.create(parent = parent)
            }
            R.layout.item_music -> {
                MusicViewHolder.create(parent = parent)
            }
            else -> {
                LoadingPlaceholderViewHolder.create(parent = parent)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position = position)

        when (item) {
            is BannerModel -> {
                (holder as? BannerViewHolder)?.bind(item)
            }
            is LargeBannerModel -> {
                (holder as? LargeBannerViewHolder)?.bind(item)
            }
            is ArticleModel -> {
                (holder as? ArticleViewHolder)?.bind(item)
            }
            is MusicModel -> {
                (holder as? MusicViewHolder)?.bind(item)
            }
            is MovieModel -> {
                (holder as? MovieViewHolder)?.bind(item)
            }
            else -> {
                (holder as? LoadingPlaceholderViewHolder)?.bind()
            }
        }
    }

}

