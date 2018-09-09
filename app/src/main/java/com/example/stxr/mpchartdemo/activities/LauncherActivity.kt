package com.example.stxr.mpchartdemo.activities

import com.example.stxr.mpchartdemo.mylib.BaseFragment

/**
 * created on 2018/9/8
 * created by stxr
 * description:
 */
class LauncherActivity : BaseActivity() {
    override fun createFragment() = LaunchDelegate.newInstance()
}