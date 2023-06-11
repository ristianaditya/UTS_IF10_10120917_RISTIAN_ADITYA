package com.example.uts_if10k_10120917_ristian_aditya.adapters

//nama : Ristian Aditya
//NIM  : 10120917
//Kelas : IF10K
//TGL Pengerjaan : 29 Mei 2023

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_if10k_10120917_ristian_aditya.R
import com.example.uts_if10k_10120917_ristian_aditya.models.GalleryModel

class GalleryAdapter(
    private val courseList: ArrayList<GalleryModel>,
    private val context: Context
) : RecyclerView.Adapter<GalleryAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GalleryAdapter.CourseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_gallery,
            parent, false
        )
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GalleryAdapter.CourseViewHolder, position: Int) {
        holder.courseIV.setImageResource(courseList[position].courseImg)
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseIV: ImageView = itemView.findViewById(R.id.idivcourse)
    }
}