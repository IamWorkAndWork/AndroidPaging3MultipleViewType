package app.practice.androidpaging3multipleviewtype.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.practice.androidpaging3multipleviewtype.data.model.ItemResponse
import app.practice.androidpaging3multipleviewtype.domain.model.*
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ShelfItemPagingSource @Inject constructor(
    private val dataSource: DataSource,
    private val shelfViewTypeList: List<ShelfViewType>
) : PagingSource<Int, ItemViewType>() {

    override fun getRefreshKey(state: PagingState<Int, ItemViewType>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemViewType> {

        val position = params.key ?: 0

        val itemAfter = if (position == 0) {
            ShelfItemRepositoryImpl.SHELF_SIZE
        } else {
            params.loadSize - position
        } - 1

//        println("positionposition = " + position + " | itemAfter = " + itemAfter + " | size = " + params.loadSize)

        return try {

            val shelfViewType = shelfViewTypeList.get(position)

            val itemViewTypeModel = when (shelfViewType) {
                is ShelfViewType.Banner -> {
                    getItemViewTypeBanner(shelfViewType)
                }
                is ShelfViewType.ArticleShelf -> {
                    getItemViewTypeArticle(shelfViewType)
                }
                is ShelfViewType.MusicShelf -> {
                    getItemViewTypeMusic(shelfViewType)
                }
                is ShelfViewType.MovieShef -> {
                    getItemViewTypeMovie(shelfViewType)
                }
                is ShelfViewType.LargeBanner -> {
                    getItemViewTypeLargeBanner(shelfViewType)
                }
            }

            val response = listOf(itemViewTypeModel)

            val nextKey = if (position == params.loadSize - 1) {
                null
            } else {
                position + 1
            }

            LoadResult.Page(
                data = response,
                prevKey = if (position == 0) null else position - 1,
                nextKey = nextKey,
                itemsAfter = itemAfter
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }

    }

    private suspend fun getItemViewTypeMovie(shelfViewType: ShelfViewType.MovieShef): ItemViewType {
        val shelfId = shelfViewType.id
        val movieItemList = dataSource.getMovie(shelfId = shelfId)
        return MovieModel(
            shelfId = shelfId,
            shelftTtle = shelfViewType.title,
            shelfIcon = shelfViewType.icon,
            items = movieItemList.map { item ->
                MovieItemModel(
                    id = item.id,
                    title = item.title,
                    icon = item.icon,
                    description = item.description
                )
            }
        )
    }

    private suspend fun getItemViewTypeMusic(shelfViewType: ShelfViewType.MusicShelf): MusicModel {
        val shelfId = shelfViewType.id
        val musicItemList = dataSource.getMusic(shelfId = shelfId)
        return MusicModel(
            shelfId = shelfId,
            shelftTtle = shelfViewType.title,
            shelfIcon = shelfViewType.icon,
            items = musicItemList.map { item ->
                MusicItemModel(
                    id = item.id,
                    title = item.title,
                    icon = item.icon,
                    artist = item.artist
                )
            }
        )
    }

    private suspend fun getItemViewTypeArticle(shelfViewType: ShelfViewType.ArticleShelf): ArticleModel {
        val shelfId = shelfViewType.id
        val articleItemList = dataSource.getArticle(shelfId = shelfId)
        return ArticleModel(
            shelfId = shelfId,
            shelftTtle = shelfViewType.title,
            shelfIcon = shelfViewType.icon,
            items = articleItemList.map { item ->
                ArticleItemModel(
                    id = item.id,
                    title = item.title,
                    description = item.description,
                    channel = item.channel,
                    icon = item.icon
                )
            }
        )
    }

    private suspend fun getItemViewTypeLargeBanner(shelfViewType: ShelfViewType.LargeBanner): LargeBannerModel {
        val shelfId = shelfViewType.id
        val largeBanner = dataSource.getLargeBanner(shelfId = shelfId)
        return LargeBannerModel(
            shelfId = largeBanner.bannerId,
            icon = largeBanner.bannerIcon,
            description = largeBanner.bannerDescription
        )
    }

    private suspend fun getItemViewTypeBanner(shelfViewType: ShelfViewType.Banner): BannerModel {
        val shelfId = shelfViewType.id
        val banner = dataSource.getBanner(shelfId = shelfId)
        return BannerModel(
            shelfId = banner.bannerId,
            icon = banner.bannerIcon
        )
    }

}