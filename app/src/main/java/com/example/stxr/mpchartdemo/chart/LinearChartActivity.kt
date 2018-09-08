package com.example.stxr.mpchartdemo.chart

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.stxr.mpchartdemo.R
import com.example.stxr.mpchartdemo.R.id.lineChart
import com.example.stxr.mpchartdemo.Utils.log
import com.github.mikephil.charting.components.*
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.Utils
import kotlinx.android.synthetic.main.activity_chart_line.*

/**
 *
 */
class LinearChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_line)
        setData(18,0f,10f)
        //view要在设置数据之后设置才有效
        setView()
        lineChart.invalidate()
    }

    private fun setView() {

        lineChart?.apply {
            //不显示说明
            description.isEnabled = false
            //不显示
            legend.isEnabled = false
            //设置坐标可以左右拖动
            isDragEnabled = true
            //打印日志
            isLogEnabled = true
            //设置一屏幕最大显示的数值
            setVisibleXRangeMaximum(6f)
            //禁止缩放
            setScaleEnabled(false)


            xAxis.run {
                //x轴坐标置底
                position = XAxis.XAxisPosition.BOTTOM
                setDrawAxisLine(false)
                //只是设置横坐标格式
                setValueFormatter { value, _ -> "坐标$value" }
                //细粒化
                granularity = 1f
                setDrawGridLines(false)
                spaceMax = 0.8f
                mEntryCount.log()
                mEntries.forEach {
                    it.log()
                }
                
                val limitLine3=LimitLine(10f,"平")
                limitLine3.labelPosition = LimitLine.LimitLabelPosition.LEFT_BOTTOM
                addLimitLine(limitLine3)
            }

            axisLeft.run {
                isEnabled = false
                setDrawGridLines(false)
                setDrawAxisLine(false)
                setDrawLabels(true)
                axisMaximum=10.0f
                axisMinimum=0.0f
//                setValueFormatter { value, axis -> "" }
//                labelCount



                //设置限制线
                val limitLine1=LimitLine(5.5f)
                limitLine1.labelPosition = LimitLine.LimitLabelPosition.LEFT_BOTTOM
                val limitLine2=LimitLine(7.5f)
                limitLine2.labelPosition = LimitLine.LimitLabelPosition.LEFT_BOTTOM
                val limitLine3=LimitLine(10f)
                limitLine3.labelPosition = LimitLine.LimitLabelPosition.LEFT_BOTTOM


                val limitRange = LimitRange(limitLine1,limitLine2,"haahjjjh")
                val limitRange2 = LimitRange(7.5f,10f,"xixi")
                addRangeLimitLine(limitRange)
                addRangeLimitLine(limitRange2)
                mEntryCount.log()
            }

            axisRight.run {
                //取消右边的坐标
                isEnabled = true
                xOffset=20f
                setDrawGridLines(false)
                setDrawAxisLine(false)
                setValueFormatter { value, axis -> "" }

//                axisMaximum=10.0f
//                axisMinimum=0.0f
                //设置限制线
                val limitLine1=LimitLine(0.0f)
                val limitLine2=LimitLine(5.5f)
                val limitLine3=LimitLine(7.5f)
                val limitLine4=LimitLine(10f)


                val limitRange = LimitRange(limitLine1,limitLine2,"淡")
                val limitRange1 = LimitRange(limitLine2,limitLine3,"平")
                val limitRange2 = LimitRange(limitLine3,limitLine4,"旺")
                addRangeLimitLine(limitRange)
                addRangeLimitLine(limitRange1)
                addRangeLimitLine(limitRange2)
            }
        }?.invalidate()

    }

    private fun setData(count: Int = 5,min:Float = 0f,max:Float =10f) {
        val values = arrayListOf<Entry>()
        for (i in 0 until count) {
            //Entry(x,y)  x为横坐标 y为纵坐标
            values.add(Entry(i.toFloat(), (Math.random() * (max-min)+min).toFloat()))
        }
        val set = LineDataSet(values, "mockData")
        set.axisDependency = YAxis.AxisDependency.RIGHT
        //设置数据
        lineChart.data = LineData(set)
    }

}