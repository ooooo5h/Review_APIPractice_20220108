package com.eunhyung.review_apipractice_20220108.models

import java.io.Serializable

class UserData(
    val id : Int,
    val nick_name : String,
    val profile_img : String,
    val email : String,
    val phone : String,
) : Serializable {
}