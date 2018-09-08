package com.github.mikephil.charting.components;

/**
 * created on 2018/9/1
 * created by stxr
 * description: 在线形图或者柱状图上划分一个区域
 * 效果图：
 *
 *       |---------------------------- topLimit
 *       |
 *      A|
 *       |
 *       |---------------------------- bottomLimit
 *       |
 *      B|
 *       |____________________________
 *
 *
 *
 */
public class LimitRange extends ComponentBase {
    private LimitLine topLimit;
    private LimitLine bottomLimit;
    private String label;
    private int FilledColor;

    public LimitRange(LimitLine topLimit, LimitLine bottomLimit, String label) {
        this.topLimit = topLimit;
        this.bottomLimit = bottomLimit;
        this.label =label;
    }

    public LimitRange(float bottom,float top,String label){
        topLimit = new LimitLine(top);
        bottomLimit = new LimitLine(bottom);
        this.label = label;
    }

    public LimitLine getBottomLimit() {
        return bottomLimit;
    }

    public void setBottomLimit(LimitLine bottomLimit) {
        this.bottomLimit = bottomLimit;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LimitLine getTopLimit() {
        return topLimit;
    }

    public void setTopLimit(LimitLine topLimit) {
        this.topLimit = topLimit;
    }

    public int getFilledColor() {
        return FilledColor;
    }

    public void setFilledColor(int filledColor) {
        FilledColor = filledColor;
    }
}

