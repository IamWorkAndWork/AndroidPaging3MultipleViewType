package app.practice.androidpaging3multipleviewtype.di

import app.practice.androidpaging3multipleviewtype.data.repository.DataRepository
import app.practice.androidpaging3multipleviewtype.data.repository.ShelfItemRepository
import app.practice.androidpaging3multipleviewtype.domain.GetShelfListUseCase
import app.practice.androidpaging3multipleviewtype.domain.GetShelfListUseCaseImpl
import app.practice.androidpaging3multipleviewtype.domain.mapper.ShelfItemResponseToShelfViewTypeMapper
import app.practice.androidpaging3multipleviewtype.domain.mapper.ShelfItemResponseToShelfViewTypeMapperImpl
import app.practice.androidpaging3multipleviewtype.domain.usecase.GetShelfItemListUseCase
import app.practice.androidpaging3multipleviewtype.domain.usecase.GetShelfItemListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideShelfItemResponseToShelfViewTypeMapper(): ShelfItemResponseToShelfViewTypeMapper {
        return ShelfItemResponseToShelfViewTypeMapperImpl()
    }

    @Provides
    @Singleton
    fun provideGetShelfListUseCase(
        dataRepository: DataRepository,
        shelfItemResponseToShelfViewTypeMapper: ShelfItemResponseToShelfViewTypeMapper
    ): GetShelfListUseCase {
        return GetShelfListUseCaseImpl(
            dataRepository = dataRepository,
            shelfItemResponseToShelfViewTypeMapper = shelfItemResponseToShelfViewTypeMapper
        )
    }

    @Provides
    @Singleton
    fun provideGetShelfItemListUseCase(shelfItemRepository: ShelfItemRepository): GetShelfItemListUseCase {
        return GetShelfItemListUseCaseImpl(shelfItemRepository = shelfItemRepository)
    }

}