package com.eunhyung.review_apipractice_20220108.utils

import android.content.Context

class ContextUtil {

//    기능을 수행할때 Context를 필요로 하는 기능들을 모아두는 클래스
//    단순 기능 -> 어떤 객체(인스턴스)가 하던 관계없다
//    => 랜덤값 뽑기처럼, 어느 객체가 하던 결과만 랜덤으로 잘 나오면 됨.

//    => 클래스이름.기능() 형태로 코딩하는게 낫겠지?
    companion object {

//        일종의 메모장(SharedPreferences)에  여러 항목들을 저장 예정
//        => 메모장 파일의 이름이 필요하다

        val PREF_NAME = "APIPracticePref"   // 메모장 이름

//        항목의 키 값도 변수에 담아두자(오타 방지용)
//        저장기능/조회기능 2개가 필요한데, 둘의 키값을 통일해야 자동 동작
        val TOKEN = "TOKEN"

        fun setToken(context: Context, token : String) {

            val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)  // 메모장 파일 열기
            pref.edit().putString(TOKEN, token).apply()  // String하나 추가 기록해서 저장(apply)

        }


        fun getToken(context: Context) : String {

            val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)  // 메모장 파일 열기
            return pref.getString(TOKEN, "")!!   // 코틀린에서의 null관리 기법 : 절대 null이 아니라고 우겨서 return
        }

    }
}