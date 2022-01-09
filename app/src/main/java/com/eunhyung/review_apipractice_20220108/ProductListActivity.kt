package com.eunhyung.review_apipractice_20220108

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eunhyung.review_apipractice_20220108.adapters.ProductAdapter
import com.eunhyung.review_apipractice_20220108.models.BasicResponse
import com.eunhyung.review_apipractice_20220108.models.ProductData
import kotlinx.android.synthetic.main.activity_product_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductListActivity : BaseActivity() {

    val mProductList = ArrayList<ProductData>()

    lateinit var mAdapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        apiList.getRequestAllProduct().enqueue(object : Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful){

                    val br = response.body()!!
                    mProductList.addAll( br.data.products)

                    mAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }


        })

        mAdapter = ProductAdapter(mContext, mProductList)
        productRecyclerView.adapter = mAdapter
        productRecyclerView.layoutManager = LinearLayoutManager(mContext)



    }
}