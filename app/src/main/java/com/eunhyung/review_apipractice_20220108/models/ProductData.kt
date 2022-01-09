package com.eunhyung.review_apipractice_20220108.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProductData(
    val id : Int,
    val name : String,
    val price : Int,
    @SerializedName("image_url")
    val imageURL : String,
    val store : StoreData,
) : Serializable {
}