package com.binarial.moviesapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PeliculasServiceImpl {
    fun peliculasService(): PeliculasService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
//            .addInterceptor {
//                val newRequest = it.request().newBuilder()
//                    .addHeader("Authorization", "Bearer " + "d07046f8117f883981f167bdd7d8e97a")
//                    .build()
//                     it.proceed(newRequest)
//            }
            .build()
        return Retrofit.Builder()
            .baseUrl(PeliculasService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(PeliculasService::class.java)
    }
}