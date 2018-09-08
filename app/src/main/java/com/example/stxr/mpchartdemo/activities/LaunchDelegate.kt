package com.example.stxr.mpchartdemo.activities

import com.example.stxr.mpchartdemo.R
import com.example.stxr.mpchartdemo.chart.LinearChartActivity
import com.example.stxr.mpchartdemo.chart.ProgressBarActivity
import com.example.stxr.mpchartdemo.mylib.BaseFragment

/**
 * created on 2018/9/8
 * created by stxr
 * description:
 */
class LaunchDelegate :BaseFragment(){
    companion object {
        //入口
        fun newInstance():LaunchDelegate = LaunchDelegate()
    }

    override fun layout()= R.layout.activity_main

    override fun initView() {
        onClick()
    }
    private fun onClick() {
        btnLineChart.setOnClickListener { startActivity(Intent(this, LinearChartActivity::class.java)) }
        btnProgressBar.setOnClickListener { startActivity(Intent(this, ProgressBarActivity::class.java)) }
        btnMVVM.setOnClickListener { startActivity(Intent(this, ProgressBarActivity::class.java)) }
    }




}