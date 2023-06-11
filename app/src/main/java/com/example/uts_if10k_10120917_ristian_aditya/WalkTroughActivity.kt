package com.example.uts_if10k_10120917_ristian_aditya

//nama : Ristian Aditya
//NIM  : 10120917
//Kelas : IF10K
//TGL Pengerjaan : 29 Mei 2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.uts_if10k_10120917_ristian_aditya.adapters.ViewPagerAdapter
import com.example.uts_if10k_10120917_ristian_aditya.models.ItemSliderWalkthrough
import me.relex.circleindicator.CircleIndicator

class WalkTroughActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk_trough)
        val viewPager = findViewById<ViewPager>(R.id.SlideViewPager)
        val indicator = findViewById<CircleIndicator>(R.id.indicator)
        val buttonNext = findViewById<ImageView>(R.id.buttonNext)
        val buttonBack = findViewById<ImageView>(R.id.buttonBack)
        val buttonStarted = findViewById<ImageView>(R.id.buttonGetStarted)
        val buttonSkip = findViewById<Button>(R.id.buttonSkip)

        val dataWalkthrough = listOf(
            ItemSliderWalkthrough(resources.getString(R.string.titleSlider1) , resources.getString(R.string.bodySlider1), R.drawable.portofolio),
            ItemSliderWalkthrough(resources.getString(R.string.titleSlider2) , resources.getString(R.string.bodySlider2), R.drawable.story),
            ItemSliderWalkthrough(resources.getString(R.string.titleSlider3) , resources.getString(R.string.bodySlider3), R.drawable.contact)
        )

        val viewPagerAdapter = ViewPagerAdapter(dataWalkthrough, this)
        viewPager.adapter = viewPagerAdapter
        indicator.setViewPager(viewPager)
        buttonValidation(viewPager)
        buttonNext.setBackgroundResource(R.drawable.button_next_selector)
        buttonBack.setBackgroundResource(R.drawable.button_back_selector)
        buttonStarted.setBackgroundResource(R.drawable.button_started_selector)

        buttonStarted.setOnClickListener {
            val intent = Intent(this@WalkTroughActivity, BottomNavigationActivity::class.java)
            startActivity(intent)
        }

        buttonSkip.setOnClickListener {
            val intent = Intent(this@WalkTroughActivity, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun buttonValidation(viewPager : ViewPager){
        val buttonNext = findViewById<ImageView>(R.id.buttonNext)
        val buttonBack = findViewById<ImageView>(R.id.buttonBack)
        val buttonStarted = findViewById<ImageView>(R.id.buttonGetStarted)

        buttonNext.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
            if(viewPager.currentItem >= 1){
                buttonBack.visibility = View.VISIBLE
            }else{
                buttonBack.visibility = View.GONE
            }
            if(viewPager.currentItem > 1){
                buttonNext.visibility = View.GONE
                buttonStarted.visibility = View.VISIBLE
            }
        }

        buttonBack.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem - 1, true)

            if(viewPager.currentItem == 0){
                buttonBack.visibility = View.GONE
                buttonNext.visibility = View.VISIBLE
            }else{
                buttonNext.visibility = View.VISIBLE
                buttonStarted.visibility = View.GONE            }
        }
    }
}

