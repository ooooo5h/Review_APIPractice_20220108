package com.eunhyung.review_apipractice_20220108.models

class DataResponse(
    val user : UserData,
    val token : String,
    val reviews : List<ReviewData>,
    val products : List<ProductData>
) {
}