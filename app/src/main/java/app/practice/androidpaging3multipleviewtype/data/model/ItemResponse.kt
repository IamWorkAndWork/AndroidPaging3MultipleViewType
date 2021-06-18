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

