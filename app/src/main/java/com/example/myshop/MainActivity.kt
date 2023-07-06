package com.example.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.myshop.databinding.ActivityMainBinding
import com.winnie.myshop.Product
import com.winnie.myshop.ProductAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var list:List<Product>=emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ProductAdapter=ProductAdapter(emptyList())

    }

    override fun onResume() {
        super.onResume()
        getProducts()
    }
    fun getProducts(){
        val apiClient = Apiclient.buildClient(ApiInterface::class.java)
        val request = apiClient.getProducts()
        request.enqueue(object : Callback <ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
            if (response.isSuccessful){
                var products = response.body()?.product
                Toast.makeText(baseContext,"fetched ${products?.size} products",Toast.LENGTH_LONG).show()

            }
            else{
                Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
            }

            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })

    }
}