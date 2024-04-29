package com.example.inspirehubtask

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.graphics.ColorUtils

class RGBLayout : AppCompatActivity() {
    private lateinit var redSeekBar: SeekBar
    private lateinit var greenSeekBar: SeekBar
    private lateinit var blueSeekBar: SeekBar
    private lateinit var colorValueTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rgblayout)



        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val colorValueTxt = findViewById<TextView>(R.id.colorValueTxt)
        val inStartTxt = findViewById<TextView>(R.id.inStart)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update TextView with SeekBar progress
                colorValueTxt.text = progress.toString()

                // Calculate the color based on SeekBar progress (assuming it's for red color)
                val color = ColorUtils.setAlphaComponent(-0x100, progress)

                // Set text color of inStartTxt with the calculated color
                inStartTxt.setBackgroundColor(color)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Called when the user starts touching the SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Called when the user stops touching the SeekBar
            }
        })

    }}

