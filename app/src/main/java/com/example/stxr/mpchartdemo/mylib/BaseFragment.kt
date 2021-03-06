package com.example.stxr.mpchartdemo.mylib

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stxr.mpchartdemo.R
import kotlinx.android.synthetic.main.activity_single_fragment.view.*

/**
 * created on 2018/9/8
 * created by stxr
 * description:
 */
abstract class BaseFragment : Fragment() {
    abstract fun layout(): Any
    open fun initView(){

    }
    private var manager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manager = fragmentManager
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return when (layout()) {
            is Int -> LayoutInflater.from(activity).inflate(layout() as Int, container, false)
            is View -> layout() as View
            else -> throw Exception("The type of layout() must be Int or View!")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /**
     * 跳转到指定fragment
     */
    fun start(fragment: BaseFragment) {
        manager?.beginTransaction()?.run {
            add(R.id.fragment_container, fragment)
            show(fragment)
            hide(this@BaseFragment)
            addToBackStack(fragment.javaClass.simpleName)

        }?.commitAllowingStateLoss()

    }

    /**
     * 跳转到指定fragment，并弹出当前fragment
     */
    fun startWithPop(fragment: BaseFragment) {
        //todo:未完成
        manager?.beginTransaction()?.run {
            replace(R.id.fragment_container, fragment)
        }?.commitAllowingStateLoss()

    }
}