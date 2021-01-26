package com.example.tictactoe.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameApi{

    companion object {
        private const val baseUrl = "http://192.168.0.111:3000/"


        fun createApi(): GameApiService {
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()

            val gameApi = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return gameApi.create(GameApiService::class.java)
        }
    }

}