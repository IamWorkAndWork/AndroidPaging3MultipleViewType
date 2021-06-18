package app.practice.androidpaging3multipleviewtype.domain.mapper

import app.practice.androidpaging3multipleviewtype.data.model.ShelfItemResponse
import app.practice.androidpaging3multipleviewtype.domain.model.ShelfViewType

interface ShelfItemResponseToShelfViewTypeMapper {
    suspend fun transform(shelfItemResponse: ShelfItemResponse): ShelfViewType
}

class ShelfItemResponseToShelfViewTypeMapperImpl : ShelfItemResponseToShelfViewTypeMapper {

    override suspend fun transform(shelfItemResponse: ShelfItemResponse): ShelfViewType {
        return when (shelfItemResponse.viewType) {
            0 -> ShelfViewType.Banner(
                id = shelfItemResponse.id,
                name = shelfItemResponse.name
            )
            1 -> ShelfViewType.ArticleShelf(
                id = shelfItemResponse.id,
                title = shelfItemResponse.name,
                icon = shelfItemResponse.icon,
            )
            2 -> ShelfViewType.MovieShef(
                id = shelfItemResponse.id,
                title = shelfItemResponse.name,
                icon = shelfItemResponse.icon,
            )
            3 -> ShelfViewType.MusicShelf(
                id = shelfItemResponse.id,
                title = shelfItemResponse.name,
                icon = shelfItemResponse.icon,
            )
            else -> ShelfViewType.LargeBanner(
                id = shelfItemResponse.id,
                name = shelfItemResponse.name
            )
        }
    }

}
