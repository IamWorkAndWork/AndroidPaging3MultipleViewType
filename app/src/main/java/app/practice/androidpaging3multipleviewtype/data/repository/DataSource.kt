package app.practice.androidpaging3multipleviewtype.data.repository

import app.practice.androidpaging3multipleviewtype.api.DataApi
import app.practice.androidpaging3multipleviewtype.data.model.ItemResponse
import app.practice.androidpaging3multipleviewtype.data.model.ShelfResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.random.Random

interface DataSource {
    fun getShelfList(shelfSize: Int): Flow<ShelfResponse>
    suspend fun getShelfItemById(id: String): List<ItemResponse>
}

class DataSourceImpl @Inject constructor(
    private val dataApi: DataApi
) : DataSource {

    override fun getShelfList(shelfSize: Int): Flow<ShelfResponse> {
        return flow {
            delay(2000L)
            emit(
                dataApi.getShelfList(shelfSize = shelfSize)
            )
        }
    }

    override suspend fun getShelfItemById(id: String): List<ItemResponse> {
        delay(Random.nextLong(300, 1500))
        return dataApi.getShelfItemById(id = id)
    }

}