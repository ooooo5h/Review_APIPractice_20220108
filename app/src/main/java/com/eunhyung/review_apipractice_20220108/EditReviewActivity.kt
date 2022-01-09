package com.eunhyung.review_apipractice_20220108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.eunhyung.review_apipractice_20220108.models.BasicResponse
import com.eunhyung.review_apipractice_20220108.models.ProductData
import kotlinx.android.synthetic.main.activity_edit_review.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditReviewActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_review)

//        이전 화면에서 넘겨준 데이터 받아오기
        val product = intent.getSerializableExtra("product") as ProductData

        btnSubmitReview.setOnClickListener {

            val inputTitle = edtTitle.text.toString()
            val inputContent = edtContent.text.toString()
            val inputScore = ratingBar.rating


//            서버에 전달하자(POST/review)
            apiList.postRequestSubmitReview(product.id, inputTitle, inputContent, inputScore, "")
                .enqueue(object : Callback<BasicResponse>{
                    override fun onResponse(
                        call: Call<BasicResponse>,
                        response: Response<BasicResponse>
                    ) {
                        if (response.isSuccessful){
                            Toast.makeText(mContext, "리뷰 등록 성공", Toast.LENGTH_SHORT).show()
                            finish()
                        }


                    }

                    override fun onFailure(call: Call<BasicResponse>, t: Throwable) {



                    }


                })


        }

    }
}