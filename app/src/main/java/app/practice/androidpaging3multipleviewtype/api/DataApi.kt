package app.practice.androidpaging3multipleviewtype.api

import app.practice.androidpaging3multipleviewtype.data.model.ItemResponse
import app.practice.androidpaging3multipleviewtype.data.model.ShelfItemResponse
import app.practice.androidpaging3multipleviewtype.data.model.ShelfResponse
import retrofit2.http.GET
import kotlin.random.Random

interface DataApi {

    @GET("shelfList")
    suspend fun getShelfList(shelfSize: Int): ShelfResponse

    @GET("shelfItemById")
    suspend fun getShelfItemById(id: String): List<ItemResponse>

}

class FakeDataApi : DataApi {

    override suspend fun getShelfList(shelfSize: Int): ShelfResponse {

        val shelfItemResponseList = mutableListOf<ShelfItemResponse>()

        for (i in 0..shelfSize) {

            val randomType = Random.nextInt(0, 4)

            shelfItemResponseList.add(
                ShelfItemResponse(id = i.toString(), name = "Shelf ${i + 1}", viewType = randomType)
            )

        }

        return ShelfResponse(
            shelfList = shelfItemResponseList
        )

    }

    override suspend fun getShelfItemById(id: String): List<ItemResponse> {

        val itemResponseList = mutableListOf<ItemResponse>()

        for (i in 0 until 20) {
            itemResponseList.add(
                ItemResponse(
                    id = i.toString(),
                    title = "title ${i + 1}",
                    description = "description ${i + 1}",
                    channel = "Chanel ${i + 1}",
                    artist = "Artist ${i + 1}",
                    shelfId = id
                )
            )
        }

        return itemResponseList

    }

}