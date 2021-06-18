package app.practice.androidpaging3multipleviewtype.data.repository

import javax.inject.Inject

interface DataRepository {
    fun dataSource(): DataSource
}

class DataRepositoryImpl @Inject constructor(
    private val dataSource: DataSource
) : DataRepository {

    override fun dataSource(): DataSource {
        return dataSource
    }

}

