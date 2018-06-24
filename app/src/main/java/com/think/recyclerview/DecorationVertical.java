package com.think.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by think on 2017/12/8.
 * 列表的分割线.
 */

public class DecorationVertical extends RecyclerView.ItemDecoration {
    //采用系统内置的风格的分割线
    private static final int[] attrs = new int[]{android.R.attr.listDivider};
    private Drawable mDivider;

    private int orientation;

    public DecorationVertical(Context context, int orientation) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();
        this.orientation = orientation;
    }

    //绘制的操作在此方法中执行.
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (OrientationHelper.VERTICAL == orientation) {
            drawVDeraction(c, parent);
        } else {
            drawHDeraction(c,parent);
        }
    }

    /**
     * 绘制竖线.
     * @param c
     * @param parent
     */
    private void drawHDeraction(Canvas c, RecyclerView parent) {
        //获取竖线顶部边界
        int top = parent.getPaddingTop();
        //竖线底部边界
//        int bottom = parent.getHeight()-parent.getPaddingBottom();
        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams=(RecyclerView.LayoutParams)child.getLayoutParams();
            int bottom = child.getHeight();
            int left=child.getRight()+layoutParams.rightMargin;
            int right=left+mDivider.getIntrinsicWidth();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    //绘制横线
    private void drawVDeraction(Canvas c, RecyclerView parent) {

        //绘制横线的起始位置.
        int left = parent.getPaddingLeft();
        //绘制横向的终止位置.
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            //获取条目view.
            View child = parent.getChildAt(i);
            //获取布局参数.
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            //绘制横线顶部位置.
            int top = child.getBottom() + layoutParams.bottomMargin;
            //绘制横线底部的位置.
            int bottom = top + mDivider.getIntrinsicHeight();//线的高度.
            //int left, int top, int right, int bottom
            //左,上,右,下.
            mDivider.setBounds(left, top, right, bottom);
            //在画板上绘制横线.
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (OrientationHelper.VERTICAL == orientation) {
            //纵向列表
            outRect.set(0, 0, 0,mDivider.getIntrinsicHeight());
        } else {
            //横向
            //左,上,右,下.
            outRect.set(0, 0, mDivider.getIntrinsicWidth(),0);
        }
    }
}
