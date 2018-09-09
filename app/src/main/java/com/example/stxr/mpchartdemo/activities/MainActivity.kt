package com.example.stxr.mpchartdemo.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.stxr.mpchartdemo.R
import com.example.stxr.mpchartdemo.chart.LinearChartDelegate
import com.example.stxr.mpchartdemo.chart.ProgressBarDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClick()
    }

    private fun onClick() {
        btnLineChart.setOnClickListener { startActivity(Intent(this, LinearChartDelegate::class.java)) }
        btnProgressBar.setOnClickListener { startActivity(Intent(this, ProgressBarDelegate::class.java)) }
        btnMVVM.setOnClickListener { startActivity(Intent(this, ProgressBarDelegate::class.java)) }
    }

}
