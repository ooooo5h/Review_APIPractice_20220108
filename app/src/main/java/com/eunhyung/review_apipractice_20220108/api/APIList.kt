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


//    * 내 정보 가져오기(토큰값 첨부)
    @GET("/user")
    fun getRequestMyInfo(): Call<BasicResponse>


//    * 상품 목록 가져오기
    @GET("/product")
    fun getRequestAllProduct() : Call<BasicResponse>


//    * 리뷰 등록하기
    @FormUrlEncoded
    @POST("/review")
    fun postRequestSubmitReview(
        @Field("product_id") productId : Int,
        @Field("title") title : String,
        @Field("content") content : String,
        @Field("score") score : Float,
        @Field("tag_list") tag : String,
    ) : Call<BasicResponse>


//    * 특정 리뷰 상세보기
    @GET("/review/{review_id}")   // {review_id}는, 몇 번 리뷰를 보고싶은지 숫자를 적어줄 공간으로 세팅
    fun getRequestReviewDetail(
        @Path("review_id") id:Int,
    ) : Call<BasicResponse>
}