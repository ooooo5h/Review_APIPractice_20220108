package com.eunhyung.review_apipractice_20220108.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class StoreData(
    val id : Int,
    val name : String,
    @SerializedName("logo_url")
    val logoURL : String,
) : Serializable{
}