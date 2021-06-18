package app.practice.androidpaging3multipleviewtype.domain.usecase

import androidx.paging.PagingData
import app.practice.androidpaging3multipleviewtype.data.model.ItemResponse
import app.practice.androidpaging3multipleviewtype.data.repository.ShelfItemRepository
import app.practice.androidpaging3multipleviewtype.domain.model.ItemViewType
import app.practice.androidpaging3multipleviewtype.domain.model.ShelfViewType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetShelfItemListUseCase {
    fun execute(shelfViewTypeList: List<ShelfViewType>): Flow<PagingData<ItemViewType>>
}

class GetShelfItemListUseCaseImpl @Inject constructor(private val shelfItemRepository: ShelfItemRepository) :
    GetShelfItemListUseCase {

    override fun execute(shelfViewTypeList: List<ShelfViewType>): Flow<PagingData<ItemViewType>> {
        return shelfItemRepository.execute(shelfViewTypeList = shelfViewTypeList)
    }

}