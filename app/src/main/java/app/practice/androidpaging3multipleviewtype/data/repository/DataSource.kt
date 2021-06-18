package app.practice.androidpaging3multipleviewtype.data.repository

import app.practice.androidpaging3multipleviewtype.api.DataApi
import app.practice.androidpaging3multipleviewtype.data.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import kotlin.random.Random

interface DataSource {
    fun getShelfList(shelfSize: Int): Flow<ShelfResponse>

    suspend fun getBanner(shelfId: String): BannerResponse

    suspend fun getLargeBanner(shelfId: String): LargeBannerResponse

    suspend fun getMovie(shelfId: String): List<MovieItemResponse>

    suspend fun getArticle(shelfId: String): List<ArticleItemResponse>

    suspend fun getMusic(shelfId: String): List<MusicItemResponse>
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

    override suspend fun getBanner(shelfId: String): BannerResponse {
        delay(Random.nextLong(200, 1800))
        return dataApi.getBanner(shelfId = shelfId)
    }

    override suspend fun getLargeBanner(shelfId: String): LargeBannerResponse {
        delay(Random.nextLong(200, 1800))
        return dataApi.getLargeBanner(shelfId = shelfId)
    }

    override suspend fun getMovie(shelfId: String): List<MovieItemResponse> {
        delay(Random.nextLong(200, 1800))
        return dataApi.getMovie(shelfId = shelfId)
    }

    override suspend fun getArticle(shelfId: String): List<ArticleItemResponse> {
        delay(Random.nextLong(200, 1800))
        return dataApi.getArticle(shelfId = shelfId)
    }

    override suspend fun getMusic(shelfId: String): List<MusicItemResponse> {
        delay(Random.nextLong(200, 1800))
        return dataApi.getMusic(shelfId = shelfId)
    }

}