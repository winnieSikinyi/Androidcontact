package com.example.myshop.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import com..myshop.databinding.ProductListItemsBinding
import com.example.myshop.databinding.ProductListItemBinding
//import com.example.myshop.databinding.ProductListItemBinding

import com.squareup.picasso.Picasso
//import jp.wasabeef.picasso.transformations.CropCircleTransformation


class  ProductAdapter (var productList:List<Product>):RecyclerView.Adapter<ProductViewHolder>(){

//    fun updateProducts(newProducts: List<Product>) {
//        productList = newProducts
//        notifyDataSetChanged()
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ProductListItemBinding .inflate(LayoutInflater.from(parent.context),parent ,false)
        return ProductViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct =productList[position]
        val  binding=holder.binding
        binding.tvId.text=currentProduct.id.toString()
        binding.tvTitle.text=currentProduct.title.toString()
        binding.tvDescription.text=currentProduct.description.toString()
        binding.tvPrice.text=currentProduct.price.toString()
        binding.tvRating.text=currentProduct.rating.toString()
        binding.tvStock.text=currentProduct.stock.toString()
        binding.tvCategory.text=currentProduct.category.toString()
        Picasso
            .get()
            .load(currentProduct.thumbnail)
            .resize(494,350)
            .centerCrop()
//            .transform(CropCircleTransformation())
            .into(binding.ivImage)



    }
    override fun getItemCount(): Int {
        return productList.size
    }
}
class ProductViewHolder(var binding: ProductListItemBinding) : RecyclerView.ViewHolder(binding.root)
