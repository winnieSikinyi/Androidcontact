package com.example.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.model.Product
import com.example.myshop.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel(){
    var productsrepo = ProductRepository()
    var productsLiveData = MutableLiveData<List<Product>>()
    var errorLiveData = MutableLiveData<String>()

    fun fetchProducts(){

        viewModelScope.launch {
            val response = productsrepo.getProducts()
            if (response.isSuccessful){
                productsLiveData.postValue(response.body()?.products)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}