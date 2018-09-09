package com.example.stxr.mpchartdemo.activities

import android.os.Bundle
import android.widget.FrameLayout
import com.example.stxr.mpchartdemo.R
import com.example.stxr.mpchartdemo.mylib.BaseFragment
import com.example.stxr.mpchartdemo.mylib.SingleFragmentActivity

/**
 * created on 2018/9/8
 * created by stxr
 * description:
 */
abstract class BaseActivity: SingleFragmentActivity(){
    abstract fun createFragment():BaseFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val layout = FrameLayout(this)
//        layout.id = R.id.root_fragment
        setContentView(R.layout.activity_single_fragment)
        loadRootFragment(R.id.fragment_container,createFragment())
    }
}