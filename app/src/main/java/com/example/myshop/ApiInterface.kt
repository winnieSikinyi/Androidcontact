package com.example.myshop

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/product")
    fun getProducts(): Call<ProductResponse>
    @GET("/product/{id}")
    fun getProduct(@Path("id)")productsid:Int)

}