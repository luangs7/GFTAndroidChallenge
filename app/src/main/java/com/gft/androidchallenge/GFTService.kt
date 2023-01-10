package com.gft.androidchallenge

import retrofit2.Call
import retrofit2.http.GET

interface GFTService {
    @GET("cart")
    fun getCart(): Call<List<Product>>
}