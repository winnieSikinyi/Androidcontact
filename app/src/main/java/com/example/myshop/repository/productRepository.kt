package com.example.myshop.repository

import com.example.myshop.api.ApiInterface
import com.example.myshop.api.Apiclient
import com.example.myshop.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductRepository {


    val  apiClient = Apiclient.buildClient(ApiInterface::class.java)

    suspend fun getProducts():Response<ProductResponse>{
    return withContext(Dispatchers.IO){
        apiClient.getProducts()


        }
    }
}