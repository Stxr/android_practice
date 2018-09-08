package com.example.stxr.mpchartdemo.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.stxr.mpchartdemo.R
import com.example.stxr.mpchartdemo.chart.LinearChartActivity
import com.example.stxr.mpchartdemo.chart.ProgressBarActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClick()
    }

    private fun onClick() {
        btnLineChart.setOnClickListener { startActivity(Intent(this, LinearChartActivity::class.java)) }
        btnProgressBar.setOnClickListener { startActivity(Intent(this, ProgressBarActivity::class.java)) }
        btnMVVM.setOnClickListener { startActivity(Intent(this, ProgressBarActivity::class.java)) }
    }

}
