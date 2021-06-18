package app.practice.androidpaging3multipleviewtype.domain

import app.practice.androidpaging3multipleviewtype.data.model.ShelfResponse
import app.practice.androidpaging3multipleviewtype.data.repository.DataRepository
import app.practice.androidpaging3multipleviewtype.data.repository.ShelfItemRepository
import app.practice.androidpaging3multipleviewtype.data.repository.ShelfItemRepositoryImpl
import app.practice.androidpaging3multipleviewtype.domain.mapper.ShelfItemResponseToShelfViewTypeMapper
import app.practice.androidpaging3multipleviewtype.domain.model.ShelfViewType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetShelfListUseCase {
    fun execute(): Flow<List<ShelfViewType>>
}

class GetShelfListUseCaseImpl @Inject constructor(
    private val dataRepository: DataRepository,
    private val shelfItemResponseToShelfViewTypeMapper: ShelfItemResponseToShelfViewTypeMapper
) : GetShelfListUseCase {

    override fun execute(): Flow<List<ShelfViewType>> {
        return dataRepository.dataSource().getShelfList(shelfSize = ShelfItemRepositoryImpl.SHELF_SIZE)
            .map(::ToShelfViewTypeList)
    }

    suspend fun ToShelfViewTypeList(shelfResponse: ShelfResponse): List<ShelfViewType> {
        return shelfResponse.shelfList.map { shelfItemResponse ->
            shelfItemResponseToShelfViewTypeMapper.transform(shelfItemResponse = shelfItemResponse)
        }
    }

}