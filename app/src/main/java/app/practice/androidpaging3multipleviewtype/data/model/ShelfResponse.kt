package app.practice.androidpaging3multipleviewtype.data.model

data class ShelfResponse(
    val shelfList: List<ShelfItemResponse>
)

data class ShelfItemResponse(
    val id: String,
    val name: String,
    val viewType: Int,
    val icon: String = ""
)