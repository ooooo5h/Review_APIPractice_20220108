package com.eunhyung.review_apipractice_20220108

import android.os.Bundle
import com.eunhyung.review_apipractice_20220108.models.BasicResponse
import com.eunhyung.review_apipractice_20220108.models.ProductData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductListActivity : BaseActivity() {

    val mProductList = ArrayList<ProductData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        apiList.getRequestAllProduct().enqueue(object : Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }


        })



    }
}