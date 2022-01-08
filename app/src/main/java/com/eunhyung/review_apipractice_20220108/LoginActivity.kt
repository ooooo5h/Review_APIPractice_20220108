package com.eunhyung.review_apipractice_20220108

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.eunhyung.review_apipractice_20220108.api.APIList
import com.eunhyung.review_apipractice_20220108.api.ServerAPI
import com.eunhyung.review_apipractice_20220108.models.BasicResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

//            입력한 이메일과 비밀번호를 저장해서
            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()

//            실제 로그인 기능 호출(Request를 날린다)
            apiList.postRequestLogin(inputEmail, inputPw).enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {

//                    로그인의 성공/실패던 응답 자체가 돌아온 경우(서버 정상 동작)
//                    성공/실패의 경우가 나뉨
                    if (response.isSuccessful) {
//                        로그인 성공 => 아이디와 비밀번호 모두 일치
//                        Toast.makeText(this@MainActivity, "로그인 성공", Toast.LENGTH_SHORT).show()

//                        ~~님 환영합니다! 토스트 출력
                        val br = response.body()!!   // 서버의 응답 본문(body)을 자동 분석된 BasicResponse형태로 저장
                        val loginUserNick = br.data.user.nick_name

                        Toast.makeText(this@LoginActivity, "${loginUserNick}님, 환영합니다!", Toast.LENGTH_SHORT).show()
                    }
                   else {
//                        로그인 실패 => 아이디나 비밀번호가 틀림
                        Toast.makeText(this@LoginActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

//                    서버 연결 자체를 물리적으로 실패한 경우
                }


            })
        }

        btnSignUp.setOnClickListener {

            val myIntent = Intent(this, SignUpActivity::class.java)
            startActivity(myIntent)
        }
    }
}