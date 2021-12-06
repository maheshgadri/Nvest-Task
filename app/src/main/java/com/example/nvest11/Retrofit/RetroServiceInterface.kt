package com.example.nvest11.Retrofit

import com.example.nvest11.Data.Ecommodel
import com.example.nvest11.Data.Rating
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET("https://fakestoreapi.com/products/")
    fun getprodcuctList(): Call<List<Ecommodel>>


}