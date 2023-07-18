package com.example.myshop.api

import com.example.myshop.model.ProductResponse
import com.example.myshop.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
interface ApiInterface {
    @GET("/product")
    suspend fun getProducts(): Response<ProductResponse>

    @GET("/product/{id}")
    suspend fun getProductById(@Path("id") productId: Int): Response<Product>
}
