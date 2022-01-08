package com.eunhyung.review_apipractice_20220108.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPI {

//    서버 통신을 하게 도와주는 클래스(Retrofit)를 객체로 만들어주는 기능
//    함수 한번만 호출하면 어디서든 편하게 가져다 쓸 수 있게 함수로 만들기위해서
//    클래스이름.기능()  => 파이썬의 @classmethod에 대응되는 기능을 활용할꺼임
    companion object {

//        이 클래스 내부에서만 사용할 예정 => private 처리
        private val BASE_URL = "https://api.gudoc.in"
        private var retrofit : Retrofit? = null  // 서버 연결을 전담하는 변수인데, 기본적으로 안만든 상태(null)처리

//        retrofit 변수에 환경설정 + 객체화해서 다른 곳에서는 쉽게 가져다 쓸 수 있게 함수를 만들자
        fun getRetrofit() : Retrofit {
            
//            retrofit변수가 null이라면 새 객체를 만들어주고, 그게 아니라면 있는 객체를 사용하자
//            하나의 객체를 계속 재활용하게 유도하는 디자인 패턴을 싱글톤 패턴이라고 함
            if (retrofit == null){

//                토큰의 경우, 여러 API 함수에서 사용해야하고 매번 같은 토큰값이 입력된다(ContextUtil.getToken())
//                  =>  자동화하면 편하겠찌? => 레트로핏 객체 생성전에, 토큰에 관련된 세팅을 직접 해둠으로써!

                
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)  // 어느 서버안에서 움직일거니?
                    .addConverterFactory(GsonConverterFactory.create())  // 서버가 내려주는 응답은 JSON인데, 자동으로 분석해주는 도구 설치
                    .build()
            }
    
//             return대는 retrofit은 절대 null일 리 없다고 명시
            return retrofit!!

        }



    }
}