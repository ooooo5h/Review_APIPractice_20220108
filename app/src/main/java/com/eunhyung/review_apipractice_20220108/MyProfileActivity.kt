package com.eunhyung.review_apipractice_20220108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.eunhyung.review_apipractice_20220108.models.BasicResponse
import com.eunhyung.review_apipractice_20220108.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_my_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)


//        서버에 내 정보를 요청하자(저장된 토큰값을 활용해서, 내가 누구인지 서버에 알려주자)

//        ContextUtil로 저장해둔 토큰을 가져오자
        apiList.getRequestMyInfo(ContextUtil.getToken(mContext)).enqueue(object : Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful) {

                    val br = response.body()!!

//                    사용자가 누구인지 변수에 담자
                    val myInfo = br.data.user

//                    UI에 닉네임/프사 등 반영
                    txtMyNickname.text = myInfo.nick_name
                    Glide.with(mContext).load(myInfo.profile_img).into(imgMyProfile)

                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })

    }
}