package com.eunhyung.review_apipractice_20220108.models

// 서버의 응답(Response)을 분석(Parsing)해서 변수에 담아두는 역할

class BasicResponse(
    val code : Int,
    val message : String,
    val data : DataResponse,
) {
}