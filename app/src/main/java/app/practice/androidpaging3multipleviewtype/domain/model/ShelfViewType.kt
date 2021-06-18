package app.practice.androidpaging3multipleviewtype.domain.model

sealed class ShelfViewType {

    abstract val id: String

    data class Banner(override val id: String, val name: String) : ShelfViewType()

    data class LargeBanner(override val id: String, val name: String) : ShelfViewType()

    data class MovieShef(
        override val id: String,
        val title: String,
        val icon: String
    ) : ShelfViewType()

    data class MusicShelf(
        override val id: String,
        val title: String,
        val icon: String
    ) : ShelfViewType()

    data class ArticleShelf(
        override val id: String,
        val title: String,
        val icon: String
    ) : ShelfViewType()

}