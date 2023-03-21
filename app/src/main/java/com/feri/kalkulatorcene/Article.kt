package com.feri.kalkulatorcene

class Article(var name: String, var price: Double, var storeName: String) {
    override fun toString(): String {
        return "$name $price €"
    }
}