package com.winnie.myshop
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.ProductListItemBinding
import com.squareup.picasso.Picasso
//import com.winnie.myshop.databinding.ProductsListItemsBinding
import jp.wasabeef.picasso.transformations.CropCircleTransformation


class ProductAdapter (val productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct = productList.get(position)
        var binding = holder.binding
        binding.tvId.text = currentProduct.id.toString()
        binding.tvTitle.text = currentProduct.title
        binding.tvDescription.text = currentProduct.description
        binding.tvPrice.text =currentProduct.price.toString()
        binding.tvRating.text =currentProduct.rating.toString()
        binding.tvStock.text = currentProduct.stock.toString()
        binding.tvBrand.text = currentProduct.brand
        binding.tvCategory.text = currentProduct.category

        Picasso
            .get()
            .load(currentProduct.thumbnail)
            .transform(CropCircleTransformation())
            .into(binding.imageView)
    }


    override fun getItemCount(): Int {
        return productList.size
    }
    class ProductViewHolder(var binding: ProductListItemBinding) : RecyclerView.ViewHolder(binding.root)

}