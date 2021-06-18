package app.practice.androidpaging3multipleviewtype.domain.model

interface ItemViewType {
    val shelfId: String
}

data class BannerModel(
    override val shelfId: String,
    val icon: String,
) : ItemViewType


data class LargeBannerModel(
    override val shelfId: String,
    val description: String,
    val icon: String
) : ItemViewType


data class MovieModel(
    override val shelfId: String,
    val shelftTtle: String,
    val shelfIcon: String,
    val items: List<MovieItemModel>,
) : ItemViewType

data class MovieItemModel(
    val id: String,
    val title: String,
    val description: String,
    val icon: String
)


data class MusicModel(
    override val shelfId: String,
    val shelftTtle: String,
    val shelfIcon: String,
    val items: List<MusicItemModel>
) : ItemViewType

data class MusicItemModel(
    val id: String,
    val title: String,
    val artist: String,
    val icon: String
)


data class ArticleModel(
    override val shelfId: String,
    val shelftTtle: String,
    val shelfIcon: String,
    val items: List<ArticleItemModel>
) : ItemViewType


data class ArticleItemModel(
    val id: String,
    val title: String,
    val description: String,
    val channel: String,
    val icon: String
)