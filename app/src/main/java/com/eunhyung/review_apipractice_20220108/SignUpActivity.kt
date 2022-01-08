package com.eunhyung.review_apipractice_20220108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.eunhyung.review_apipractice_20220108.api.APIList
import com.eunhyung.review_apipractice_20220108.api.ServerAPI
import com.eunhyung.review_apipractice_20220108.models.BasicResponse
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSignUp.setOnClickListener {

            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()
            val inputNickname = edtNickname.text.toString()
            val inputPhoneNum = edtPhone.text.toString()

//            API 호출(회원가입) => ServerAPI + APIList 조합
            val retrofit = ServerAPI.getRetrofit()
            val apiList = retrofit.create(APIList::class.java)

            apiList.putRequestSignUp(inputEmail, inputPw, inputNickname, inputPhoneNum)
                .enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {

//                    회원가입 요청 => DB에 가입 => 서버가 내려준 응답이 돌아왔을 때 실행하는 부분
//                    response.isSuccessful => 코드값이 200인가?
                    if (response.isSuccessful){

//                        BasicResponse 형태로 자동 분석된 응답은 200으로 돌아왔을때만 정상 동작함
                        val br = response.body()!!  // BasicResponse를 추출

//                         회원가입 성공처리만 br변수를 이용해서 진행
                        val signUpNickname = br.data.user.nick_name
                        Toast.makeText(this@SignUpActivity, "${signUpNickname}님 회원가입을 축하합니다!!", Toast.LENGTH_SHORT).show()

                        finish()  // 로그인 화면으로 복귀
                    }
                    else {

//                        문제 발생 ! => BasicResponse 정상 응답 제공 X
                        val testStr = response.errorBody()!!.string() // 에러의 경우는, 별도로 에러 본문을 확인
                        Log.d("문제응답", testStr)

                    }

                }
                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }

            })
        }

        btnEmailCheck.setOnClickListener {

            val inputEmail = edtEmail.text.toString()

            val retrofit = ServerAPI.getRetrofit()
            val apiList = retrofit.create(APIList::class.java)

            apiList.getRequestDuplCheck("EMAIL", inputEmail).enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if (response.isSuccessful){
                        txtEmailCheckResult.text = "사용해도 좋습니다."
                    }
                    else {
                        txtEmailCheckResult.text = "중복입니다."
                    }
                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }


            })
        }
    }
}