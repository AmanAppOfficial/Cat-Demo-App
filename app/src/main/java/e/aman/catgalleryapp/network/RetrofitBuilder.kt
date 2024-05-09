package e.aman.catgalleryapp.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * author: Aman Srivastava
 * Created on: 09/05/2024
 * Singleton Provider for Retrofit objects.
 * */
@Module
@InstallIn(SingletonComponent::class)
object RetrofitBuilder {

    @Provides
    @Singleton
    fun builder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/images/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService= retrofit.create(ApiService::class.java)
}