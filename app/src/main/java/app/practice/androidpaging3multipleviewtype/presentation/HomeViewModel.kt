package app.practice.androidpaging3multipleviewtype.presentation

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import app.practice.androidpaging3multipleviewtype.data.model.ItemResponse
import app.practice.androidpaging3multipleviewtype.domain.GetShelfListUseCase
import app.practice.androidpaging3multipleviewtype.domain.model.ShelfViewType
import app.practice.androidpaging3multipleviewtype.domain.usecase.GetShelfItemListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@FlowPreview
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getShelfListUseCase: GetShelfListUseCase,
    private val getShelfItemListUseCase: GetShelfItemListUseCase
) : ViewModel() {

    private val _showLoading = MutableStateFlow(true)

    val showLoading: StateFlow<Boolean> = _showLoading

    fun loadDataEachShelf(): Flow<PagingData<ItemResponse>> {
        return getShelfListUseCase.execute()
            .flatMapMerge { shelfViewTypeList ->
                getShelfItemListUseCase.execute(shelfViewTypeList = shelfViewTypeList)
            }
            .flowOn(Dispatchers.IO)
            .onStart {
                _showLoading.value = true
                println("loadDataEachShelf onStart")
            }
            .onEach {
                println("loadDataEachShelf onEach")
                _showLoading.value = false
            }
            .catch {
                _showLoading.value = false
                println("loadDataEachShelf catch : " + it.localizedMessage)
            }
    }

}