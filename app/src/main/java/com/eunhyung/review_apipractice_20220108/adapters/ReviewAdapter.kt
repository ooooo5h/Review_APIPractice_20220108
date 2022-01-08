package com.eunhyung.review_apipractice_20220108.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eunhyung.review_apipractice_20220108.R
import com.eunhyung.review_apipractice_20220108.models.ReviewData

class ReviewAdapter(
    val mContext : Context,
    val mList : List<ReviewData>) : RecyclerView.Adapter<ReviewAdapter.MyViewHolder>() {

    inner class MyViewHolder(val row : View) : RecyclerView.ViewHolder(row){

        val imgThumbnail = row.findViewById<ImageView>(R.id.imgThumbnail)
        val imgUserProfile = row.findViewById<ImageView>(R.id.imgUserProfile)
        val txtReviewTitle = row.findViewById<TextView>(R.id.txtReviewTitle)
        val txtUserNickname = row.findViewById<TextView>(R.id.txtUserNickname)

        fun bind(data: ReviewData) {

            txtUserNickname.text = data.user.nick_name
            txtReviewTitle.text = data.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.review_list_item, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}