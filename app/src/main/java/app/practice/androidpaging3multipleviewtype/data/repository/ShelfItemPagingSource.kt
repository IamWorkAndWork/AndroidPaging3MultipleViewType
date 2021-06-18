package app.practice.androidpaging3multipleviewtype.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.practice.androidpaging3multipleviewtype.data.model.ItemResponse
import app.practice.androidpaging3multipleviewtype.domain.model.ShelfViewType
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ShelfItemPagingSource @Inject constructor(
    private val dataSource: DataSource,
    private val shelfViewTypeList: List<ShelfViewType>
) : PagingSource<Int, ItemResponse>() {

    override fun getRefreshKey(state: PagingState<Int, ItemResponse>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemResponse> {

        val position = params.key ?: 0

        val itemAfter = if (position == 0) {
            ShelfItemRepositoryImpl.SHELF_SIZE
        } else {
            params.loadSize - position
        } - 1

//        println("positionposition = " + position + " | itemAfter = " + itemAfter + " | size = " + params.loadSize)

        return try {

            val shelfViewType = shelfViewTypeList.get(position)
            val shelfId = shelfViewType.id

            val itemList = dataSource.getShelfItemById(id = shelfId)

            val nextKey = if (position == params.loadSize - 1) {
                null
            } else {
                position + 1
            }

            LoadResult.Page(
                data = listOf(itemList.first()),
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

}