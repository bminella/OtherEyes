package com.bminella.othereyes.api

import com.bminella.othereyes.Model.UnsplashQueryResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

        @GET("/search/photos?client_id=JinGHWRBNeNXFo-qP5y2Z0UkvyLwKQwZ4Ux-ZGrqvMc&query=horse")
        fun getPhotosBySearch() : Call<UnsplashQueryResult>

        companion object {

            var BASE_URL = "https://api.unsplash.com/"

            fun create() : com.bminella.othereyes.api.ApiInterface {

                val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                return retrofit.create(ApiInterface::class.java)

            }
        }
    }