package app.practice.androidpaging3multipleviewtype.data.model

data class ItemResponse(
    val artist: String,
    val channel: String,
    val description: String,
    val icon: String = "",
    val id: String,
    val title: String,
    val shelfId: String
)

data class BannerResponse(
    val bannerId: String,
    val bannerSize: Int,
    val bannerIcon: String = ""
)

data class LargeBannerResponse(
    val bannerId: String,
    val bannerSize: Int,
    val bannerIcon: String = "",
    val bannerDescription: String
)

data class MovieItemResponse(
    val description: String,
    val icon: String = "",
    val id: String,
    val title: String,
)

data class ArticleItemResponse(
    val channel: String,
    val description: String,
    val icon: String = "",
    val id: String,
    val title: String,
)

data class MusicItemResponse(
    val artist: String,
    val description: String,
    val icon: String = "",
    val id: String,
    val title: String,
)