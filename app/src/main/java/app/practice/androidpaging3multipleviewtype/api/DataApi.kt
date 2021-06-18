package app.practice.androidpaging3multipleviewtype.api

import app.practice.androidpaging3multipleviewtype.data.model.*
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.random.Random

interface DataApi {

    @GET("shelfList")
    suspend fun getShelfList(shelfSize: Int): ShelfResponse

    @GET("getBanner")
    suspend fun getBanner(@Query("shelfId") shelfId: String): BannerResponse

    @GET("getBanner")
    suspend fun getLargeBanner(@Query("shelfId") shelfId: String): LargeBannerResponse

    @GET("getMovie")
    suspend fun getMovie(@Query("shelfId") shelfId: String): List<MovieItemResponse>

    @GET("getArticle")
    suspend fun getArticle(@Query("shelfId") shelfId: String): List<ArticleItemResponse>

    @GET("getMusic")
    suspend fun getMusic(@Query("shelfId") shelfId: String): List<MusicItemResponse>

}

class FakeDataApi : DataApi {

    override suspend fun getShelfList(shelfSize: Int): ShelfResponse {

        val shelfItemResponseList = mutableListOf<ShelfItemResponse>()

        for (i in 0..shelfSize) {

            val randomType = Random.nextInt(0, 5)

            shelfItemResponseList.add(
                ShelfItemResponse(id = i.toString(), name = "Shelf Title ${i + 1}", viewType = randomType)
            )

        }

        return ShelfResponse(
            shelfList = shelfItemResponseList
        )

    }

    override suspend fun getBanner(id: String): BannerResponse {
        return BannerResponse(
            bannerId = "1",
            bannerSize = 100,
        )
    }

    override suspend fun getLargeBanner(id: String): LargeBannerResponse {
        return LargeBannerResponse(
            bannerId = "1",
            bannerSize = 100,
            bannerDescription = "bannerDescription"
        )
    }

    override suspend fun getMovie(id: String): List<MovieItemResponse> {
        val itemList = mutableListOf<MovieItemResponse>()
        for (i in 0 until 30) {
            MovieItemResponse(
                description = "description $i",
                id = i.toString(),
                title = "title $i"
            ).also { model ->
                itemList.add(model)
            }
        }
        return itemList
    }

    override suspend fun getArticle(id: String): List<ArticleItemResponse> {
        val itemList = mutableListOf<ArticleItemResponse>()
        for (i in 0 until 30) {
            ArticleItemResponse(
                description = "description $i",
                id = i.toString(),
                title = "title $i",
                channel = "channel $i"
            ).also { model ->
                itemList.add(model)
            }
        }
        return itemList
    }

    override suspend fun getMusic(id: String): List<MusicItemResponse> {
        val itemList = mutableListOf<MusicItemResponse>()
        for (i in 0 until 30) {
            MusicItemResponse(
                description = "description $i",
                id = i.toString(),
                title = "title $i",
                artist = "artist $i"
            ).also { model ->
                itemList.add(model)
            }
        }
        return itemList
    }

}