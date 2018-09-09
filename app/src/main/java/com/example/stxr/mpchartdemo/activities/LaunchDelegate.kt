package com.example.stxr.mpchartdemo.activities

import android.content.Intent
import com.example.stxr.mpchartdemo.R
import com.example.stxr.mpchartdemo.chart.LinearChartDelegate
import com.example.stxr.mpchartdemo.chart.ProgressBarDelegate
import com.example.stxr.mpchartdemo.mylib.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

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
        btnLineChart.setOnClickListener { start(LinearChartDelegate()) }
        btnProgressBar.setOnClickListener { start(ProgressBarDelegate()) }
        btnMVVM.setOnClickListener { start(MVVMPracticeDelegate()) }
    }




}