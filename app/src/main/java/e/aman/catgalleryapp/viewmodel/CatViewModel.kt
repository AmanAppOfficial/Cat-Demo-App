package e.aman.catgalleryapp.viewmodel


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import e.aman.catgalleryapp.model.Cat
import e.aman.catgalleryapp.repository.CatRepo
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class CatViewModel @Inject constructor(private val catRepo: CatRepo): ViewModel() {

    val catList = mutableStateListOf<Cat>()


    // Hit API when app launched.
    init {
        getCatData()
    }

     private fun getCatData() {
        viewModelScope.launch {
            catRepo.getCatData().collect {
                catList.addAll(it)
            }
        }
    }
}