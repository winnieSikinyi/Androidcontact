package com.example.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.api.ApiInterface
import com.example.myshop.api.Apiclient
import com.example.myshop.databinding.ActivityMainBinding
import com.example.myshop.model.Product
import com.example.myshop.model.ProductAdapter
import com.example.myshop.model.ProductResponse
import com.example.myshop.viewmodel.ProductsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    val productsViewModel: ProductsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    //    lateinit var productAdapter: ProductAdapter
//    var products: List<Product> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onResume() {
        super.onResume()
        productsViewModel.fetchProducts()
        productsViewModel.productsLiveData.observe(this, Observer { productsList ->
            var productsAdapter = ProductAdapter(productsList ?: emptyList())
            binding.rvRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvRecycler.adapter = productsAdapter

            Toast.makeText(baseContext, "fetched ${productsList?.size} products", Toast.LENGTH_LONG)
                .show()
        })
        productsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()

        })
    }


}








//package com.example.myshop.ui
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.viewModels
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.myshop.api.ApiInterface
//import com.example.myshop.api.Apiclient
//import com.example.myshop.databinding.ActivityMainBinding
//import com.example.myshop.model.Product
//import com.example.myshop.model.ProductAdapter
//import com.example.myshop.model.ProductResponse
//import com.example.myshop.viewmodel.ProductsViewModel
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response

//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//    private val productsViewModel: ProductsViewModel by viewModels()
//    private lateinit var productAdapter: ProductAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        productAdapter = ProductAdapter(emptyList())
//        binding.rvRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
//        binding.rvRecycler.adapter = productAdapter
//
//        observeProductData()
//    }
//
//    private fun observeProductData() {
//        productsViewModel.productsLiveData.observe(this, Observer { productsList ->
//            productsList?.let {
//                productAdapter.updateProducts(it)
//                Toast.makeText(baseContext, "Fetched ${it.size} products", Toast.LENGTH_LONG).show()
//            }
//        })
//
//        productsViewModel.errorLiveData.observe(this, Observer { error ->
//            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//        })
//    }
//
//    override fun onResume() {
//        super.onResume()
//        productsViewModel.fetchProducts()
//    }
//}
