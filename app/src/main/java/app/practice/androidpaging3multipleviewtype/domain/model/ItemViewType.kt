package app.practice.androidpaging3multipleviewtype.domain.model

interface ItemViewType {
    val id: String
}

data class BannerModel(
    override val id: String,
    val name: String
) : ItemViewType

data class LargeBannerModel(
    override val id: String,
    val name: String
) : ItemViewType

data class MovieModel(
    override val id: String,
    val shelf: ShelfViewType.MovieShef,
    val title: String,
    val description: String,
    val icon: String
) : ItemViewType

data class MusicModel(
    override val id: String,
    val shelf: ShelfViewType.MusicShelf,
    val title: String,
    val artist: String,
    val icon: String
) : ItemViewType

data class ArticleModel(
    override val id: String,
    val shelf: ShelfViewType.ArticleShelf,
    val title: String,
    val description: String,
    val channel: String,
    val icon: String
) : ItemViewType