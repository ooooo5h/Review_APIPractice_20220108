package com.eunhyung.review_apipractice_20220108

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.eunhyung.review_apipractice_20220108.adapters.ReviewAdapter
import com.eunhyung.review_apipractice_20220108.models.BasicResponse
import com.eunhyung.review_apipractice_20220108.models.ReviewData
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    val mReviewList = ArrayList<ReviewData>()

    lateinit var mReviewAdatper : ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().token.addOnCompleteListener {

            if (it.isSuccessful){

                val deviceToken = it.result!!
                Log.d("FCM토큰", deviceToken)


            }

        }


        btnViewProduct.setOnClickListener {

            val myIntent = Intent(mContext, ProductListActivity::class.java)
            startActivity(myIntent)
        }

        btnMyProfile.setOnClickListener {

            val myIntent = Intent(mContext, MyProfileActivity::class.java)
            startActivity(myIntent)

        }

        apiList.getRequestAllReview().enqueue(object : Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful){

                    val br = response.body()!!

//                    서버가 주는 응답에서 data -> reviews 목록 전체를 mReviewList에 추가
                    mReviewList.addAll(br.data.reviews)

//                    리싸이클러뷰 세팅 완료 이후에 데이터를 추가한다면, 자동 반영이 안된다.
//                    어댑터의 내용 변경이 있다면 반영해달라고 어댑터에게 요청해야함
                    mReviewAdatper.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }


        })

        mReviewAdatper = ReviewAdapter(mContext, mReviewList)
        reviewRecyclerview.adapter = mReviewAdatper
        reviewRecyclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)



    }
}