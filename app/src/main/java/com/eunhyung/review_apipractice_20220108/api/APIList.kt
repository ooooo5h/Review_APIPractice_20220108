package com.eunhyung.review_apipractice_20220108.api

import com.eunhyung.review_apipractice_20220108.models.BasicResponse
import retrofit2.Call
import retrofit2.http.*

interface APIList {

//    api.gudoc.in 서버의 기능들에 접근하는 기능들을 명시

//    * 로그인
    @FormUrlEncoded  // @Field에 데이터를 담으려면, 추가로 부착해야함
    @POST("/user")
    fun postRequestLogin(
        @Field("email") email : String,
        @Field("password") pw : String,
    ) : Call<BasicResponse>   // (특정 클래스=>BasicResponse 형태의 응답을 받는)API 호출 기능을 만들어냄


//    * 회원가입
    @FormUrlEncoded
    @PUT("/user")
    fun putRequestSignUp(
        @Field("email") email : String,
        @Field("password") pw : String,
        @Field("nick_name") nick : String,
        @Field("phone") phone : String,
    ) : Call<BasicResponse>


//    * 중복 검사
    @GET("/user/check")
    fun getRequestDuplCheck(
        @Query("type") type : String,
        @Query("value") value : String,
    ) : Call<BasicResponse>


//    * 리뷰 가져오기
    @GET("/review")
    fun getRequestAllReview() : Call<BasicResponse>

}