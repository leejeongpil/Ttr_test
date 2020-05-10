package com.example.ttr_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.viewpager.widget.ViewPager
import com.example.ttr_test.Auth.LoginActivity
import com.example.ttr_test.Auth.MyCominActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom.*

class MainActivity : AppCompatActivity() {

    internal lateinit var viewpager: ViewPager

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val img = arrayOf(
            R.drawable.ai,
            R.drawable.css,
            R.drawable.id,
            R.drawable.jpg,
            R.drawable.js,
            R.drawable.mp4,
            R.drawable.pdf,
            R.drawable.php,
            R.drawable.png,
            R.drawable.psd,
            R.drawable.tiff
        )
        val img2 = arrayOf(
            R.drawable.tiff,
            R.drawable.psd,
            R.drawable.png,
            R.drawable.php,
            R.drawable.pdf,
            R.drawable.mp4,
            R.drawable.js,
            R.drawable.jpg,
            R.drawable.id,
            R.drawable.css,
            R.drawable.ai
        )

        val text = arrayOf(
            "ai",
            "css",
            "html",
            "id",
            "jpg",
            "js",
            "mp4",
            "pdf",
            "php",
            "png",
            "psd",
            "tiff"
        )
        val text2 = arrayOf(
            "tiff",
            "psd",
            "png",
            "php",
            "pdf",
            "mp4",
            "js",
            "jpg",
            "id",
            "html",
            "css",
            "ai"
        )

        val gridviewAdapter = GridviewAdapter(this, img, text)//conveying img and text to gridviewadapter
        gridview.adapter = gridviewAdapter

        discount_button.setOnClickListener {
            val gridviewAdapter = GridviewAdapter(this, img, text)//conveying img and text to gridviewadapter
            gridview.adapter = gridviewAdapter
        }
        restaurant_button.setOnClickListener {
            val gridviewAdapter = GridviewAdapter(this, img2, text2)//conveying img and text to gridviewadapter
            gridview.adapter = gridviewAdapter
        }

        gridview.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, LectureActivity::class.java)
            startActivity(intent)
        }



        viewpager = findViewById(R.id.viewpager) as ViewPager

        val adapter = ViewPagerAdapter(this)
        viewpager.adapter = adapter

        my_page.setOnClickListener {
            if(auth.currentUser == null){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else{
                val intent = Intent(this, MyCominActivity::class.java)
                startActivity(intent)
            }

        }

    }}
