package com.example.inspirehubtask

import FragmentDetails
import android.annotation.SuppressLint
import android.app.Fragment
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val arrayList:ArrayList<Data> = ArrayList()

//
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView=findViewById<TextView>(R.id.story)
        textView.paintFlags = textView.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        val hyperLink=findViewById<TextView>(R.id.hyperLink)
        hyperLink.setOnClickListener{
            Toast.makeText(this@MainActivity,"تم الضغط" ,Toast.LENGTH_LONG).show()
        }
     // Dark mode
        val switch=findViewById<SwitchCompat>(R.id.switch1)
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(!isChecked){

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

            }
        }
//    val btn = findViewById<Button>(R.id.btn)
//    val pdfView = findViewById<com.github.barteksc.pdfviewer.PDFView>(R.id.pdfView)
//
//    btn.setOnClickListener {
//        pdfView.recycle() // Recycle the PDFView before loading a new PDF file
//        pdfView.fromAsset("Data mining paper 1 Business.pdf").load()
//    }
        arrayList.add(Data("الحمامتان والسلحفاة",
    "غاندي وفردة الحذاء",
    "الحسود والبخيل",
    "نعل الملك","الأحمق والصبي","درهم في الصحراء","الإعلان والأعمى","حكاية النسر","القناعة كنز لا يفنى"))
        val recyclerView: RecyclerView = findViewById(R.id.id_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = Adapter(arrayList)
        recyclerView.adapter = adapter


        val fragmentDetails:FragmentDetails= FragmentDetails()
        val fragmentTransaction:FragmentTransaction=supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.id_task,fragmentDetails).commit()


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.id_bottomnavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.color -> {
                    val intent= Intent(this@MainActivity,RGBLayout::class.java)
                    startActivity(intent)

                    true
                }

                else -> false
            }
        }


    }
}