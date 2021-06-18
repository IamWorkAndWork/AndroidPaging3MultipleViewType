package app.practice.androidpaging3multipleviewtype.presentation

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.practice.androidpaging3multipleviewtype.R
import app.practice.androidpaging3multipleviewtype.domain.model.*
import app.practice.androidpaging3multipleviewtype.presentation.view.*

class HomeAdapter : PagingDataAdapter<ItemViewType, RecyclerView.ViewHolder>(diffItem) {

    companion object {
        val diffItem = object : DiffUtil.ItemCallback<ItemViewType>() {
            override fun areItemsTheSame(oldItem: ItemViewType, newItem: ItemViewType): Boolean {
                return oldItem.shelfId == newItem.shelfId
            }

            override fun areContentsTheSame(oldItem: ItemViewType, newItem: ItemViewType): Boolean {
                return when {
                    oldItem is BannerModel && newItem is BannerModel -> {
                        oldItem.shelfId == newItem.shelfId
                    }
                    oldItem is LargeBannerModel && newItem is LargeBannerModel -> {
                        oldItem.shelfId == newItem.shelfId
                    }
                    oldItem is ArticleModel && newItem is ArticleModel -> {
                        oldItem.items == newItem.items
                    }
                    oldItem is MovieModel && newItem is MovieModel -> {
                        oldItem.items == newItem.items
                    }
                    oldItem is MusicModel && newItem is MusicModel -> {
                        oldItem.items == newItem.items
                    }
                    else -> {
                        false
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item) {
            is BannerModel -> {
                R.layout.view_banner
            }
            is LargeBannerModel -> {
                R.layout.view_large_banner
            }
            is ArticleModel -> {
                R.layout.view_article
            }
            is MusicModel -> {
                R.layout.view_music
            }
            is MovieModel -> {
                R.layout.view_movie
            }
            else -> {
                R.layout.view_loading_place_holder
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = when (viewType) {
            R.layout.view_banner -> {
                ViewBanner(parent.context)
            }
            R.layout.view_large_banner -> {
                ViewLargeBanner(parent.context)
            }
            R.layout.view_article -> {
                ViewArticle(parent.context)
            }
            R.layout.view_movie -> {
                ViewMovie(parent.context)
            }
            R.layout.view_music -> {
                ViewMusic(parent.context)
            }
            else -> {
                ViewLoadingPlaceholder(parent.context)
            }
        }
        return ItemViewHolder(view = view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position = position)

        when (item) {
            is BannerModel -> {
                (holder.itemView as? ViewBanner)?.bind(item)
            }
            is LargeBannerModel -> {
                (holder.itemView as? ViewLargeBanner)?.bind(item)
            }
            is ArticleModel -> {
                (holder.itemView as? ViewArticle)?.bind(item)
            }
            is MusicModel -> {
                (holder.itemView as? ViewMusic)?.bind(item)
            }
            is MovieModel -> {
                (holder.itemView as? ViewMovie)?.bind(item)
            }
            else -> {
                (holder.itemView as? ViewLoadingPlaceholder)?.bind(item)
            }
        }

    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
}

