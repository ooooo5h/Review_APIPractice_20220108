package com.eunhyung.review_apipractice_20220108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunhyung.review_apipractice_20220108.models.BasicResponse
import com.eunhyung.review_apipractice_20220108.models.ReviewData
import kotlinx.android.synthetic.main.activity_view_reivew.*
import kotlinx.android.synthetic.main.review_list_item.*
import kotlinx.android.synthetic.main.review_list_item.txtReviewTitle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewReviewActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_reivew)

        val reviewData = intent.getSerializableExtra("review") as ReviewData

        apiList.getRequestReviewDetail(reviewData.id).enqueue(object : Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful){
                    val br = response.body()!!
                    val newReviewData = br.data.review
                    txtReviewTitle.text = newReviewData.title
                    txtReviewContent.text = newReviewData.content
                }

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }


        })


    }
}