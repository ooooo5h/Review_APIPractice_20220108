package com.eunhyung.review_apipractice_20220108.models

import java.io.Serializable

class ReviewData(
    val id : Int,
    val title : String,
    val content : String,
    val score : Float,
    val thumbnail_img : String,
    val user : UserData,
) : Serializable {
}