package com.example.stxr.mpchartdemo.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.stxr.mpchartdemo.R

class CustomProgressBar : View {
    //进度条的画笔
    val pPaint:Paint = Paint()
    //背景颜色画笔
    val bPaint:Paint = Paint()
    var size =0
    lateinit var rect: RectF

    constructor(context: Context) : super(context)
    constructor(context: Context,attributeSet: AttributeSet,defStyleAttr:Int): super(context,attributeSet,defStyleAttr)

    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet){
        initView(context,attributeSet)
    }

    private fun initView(context: Context,attributeSet: AttributeSet) {
        //圆形头
        pPaint.strokeCap = Paint.Cap.ROUND
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomProgressBar)
        val pColor = typedArray.getColor(R.styleable.CustomProgressBar_progressColor, Color.BLUE)
        val bColor = typedArray.getColor(R.styleable.CustomProgressBar_backgroundColor,Color.CYAN)
        pPaint.color = pColor
        pPaint.isAntiAlias = true
        pPaint.style = Paint.Style.STROKE

        bPaint.color = bColor
        bPaint.isAntiAlias = true
        bPaint.style = Paint.Style.STROKE

        setPaintStyle(pPaint,pColor)
        setPaintStyle(bPaint,bColor)

        typedArray.recycle()

    }

    private fun setPaintStyle(paint: Paint,color: Int) {
        paint.color = color
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
//        paint.strokeWidth =
    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = setMeasure(widthMeasureSpec)
        val height = setMeasure(heightMeasureSpec)
        setMeasuredDimension(width,height)
    }

    @SuppressLint("DrawAllocation")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        size = Math.min(right-left,bottom-top)
        pPaint.strokeWidth = size.toFloat()/20
        bPaint.strokeWidth = pPaint.strokeWidth
        rect = RectF(size*0.1f,size*0.1f,size*0.9f,size*0.9f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawArc(rect,270f,360f,false,bPaint)
        canvas?.drawArc(rect,270f,20f,false,pPaint)
        invalidate()
    }

    private fun setMeasure(measure:Int):Int{
        val mode = MeasureSpec.getMode(measure)
        val size = MeasureSpec.getSize(measure)
        return when(mode){
            MeasureSpec.EXACTLY -> size
            MeasureSpec.AT_MOST ->Math.max(size,50)
            MeasureSpec.UNSPECIFIED ->size
            else -> 50
        }
    }
}