package com.example.stxr.mpchartdemo.mylib

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.stxr.mpchartdemo.R

/**
 * created on 2018/9/8
 * created by stxr
 * description: 只有一个fragment的activity
 */
abstract class SingleFragmentActivity : AppCompatActivity() {

    /**
     * 设置根fragment
     * id:fragment的容器
     * fragment:根fragment
     */
    protected fun loadRootFragment(id: Int, fragment: Fragment) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        var fragmentById = supportFragmentManager.findFragmentById(id)
        if (fragmentById == null) {
            fragmentById = fragment
            beginTransaction.add(id, fragmentById)
                    .show(fragmentById)
                    .commitAllowingStateLoss()
        }
    }
}