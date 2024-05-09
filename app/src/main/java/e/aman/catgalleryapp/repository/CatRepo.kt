package e.aman.catgalleryapp.repository

import e.aman.catgalleryapp.network.ApiService
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

/**
 * author: Aman Srivastava
 * Created on: 09/05/2024
 * Repository for data.
 * */
class CatRepo @Inject constructor(private val apiService: ApiService) {
    companion object {
        const val LIMIT = 10
    }

    // used flow to send data to view model.
    fun getCatData() = flow {
        emit(apiService.getCatList(LIMIT))
    }
}