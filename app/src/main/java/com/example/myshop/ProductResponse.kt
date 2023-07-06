package com.example.myshop

data class ProductResponse (
    var product: List <product>,
    var total : Int,
    var skip: Int,
    var limit : Int
)

