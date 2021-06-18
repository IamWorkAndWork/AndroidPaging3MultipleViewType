package app.practice.androidpaging3multipleviewtype.di

import app.practice.androidpaging3multipleviewtype.api.DataApi
import app.practice.androidpaging3multipleviewtype.api.FakeDataApi
import app.practice.androidpaging3multipleviewtype.data.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDataApi(): DataApi {
        return FakeDataApi()
    }

    @Provides
    @Singleton
    fun provideDataSource(dataApi: DataApi): DataSource {
        return DataSourceImpl(dataApi = dataApi)
    }

    @Provides
    @Singleton
    fun provideDataRepository(dataSource: DataSource): DataRepository {
        return DataRepositoryImpl(dataSource = dataSource)
    }

    @Provides
    @Singleton
    fun provideShelfItemRepository(dataSource: DataSource): ShelfItemRepository {
        return ShelfItemRepositoryImpl(dataSource = dataSource)
    }

}
