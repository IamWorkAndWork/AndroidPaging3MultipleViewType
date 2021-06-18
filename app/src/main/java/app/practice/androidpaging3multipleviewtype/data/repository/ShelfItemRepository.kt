package app.practice.androidpaging3multipleviewtype.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.practice.androidpaging3multipleviewtype.data.model.ItemResponse
import app.practice.androidpaging3multipleviewtype.domain.model.ItemViewType
import app.practice.androidpaging3multipleviewtype.domain.model.ShelfViewType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ShelfItemRepository {
    fun execute(shelfViewTypeList: List<ShelfViewType>): Flow<PagingData<ItemViewType>>
}

class ShelfItemRepositoryImpl @Inject constructor(
    private val dataSource: DataSource
) : ShelfItemRepository {

    companion object {
        const val SHELF_SIZE = 50
    }

    override fun execute(shelfViewTypeList: List<ShelfViewType>): Flow<PagingData<ItemViewType>> {

        return Pager(
            config = PagingConfig(
                pageSize = SHELF_SIZE,
                enablePlaceholders = true,
//                maxSize = SHELF_SIZE,
//                prefetchDistance = 10
            ),
            pagingSourceFactory = {
                ShelfItemPagingSource(
                    dataSource = dataSource,
                    shelfViewTypeList = shelfViewTypeList
                )
            }
        ).flow

    }

}