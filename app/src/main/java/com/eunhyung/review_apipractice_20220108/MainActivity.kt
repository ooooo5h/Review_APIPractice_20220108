package com.eunhyung.review_apipractice_20220108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {

//            입력한 이메일과 비밀번호를 저장해서
            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()

        }
    }
}