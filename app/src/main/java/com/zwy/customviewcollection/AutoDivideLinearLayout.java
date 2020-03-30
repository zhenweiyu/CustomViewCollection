package com.zwy.customviewcollection;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

/**
 *  线性布局各子View间需要添加分割线，使用AutoDivideLinearLayout可避免
 */
public class AutoDivideLinearLayout extends LinearLayout {

    private float divideWidth = 1;

    @ColorInt
    private int divideColor = Color.BLACK;

    private Paint dividePaint;

    private int dividePadding = 0;

    public AutoDivideLinearLayout(Context context) {
        super(context);
        init(null);
    }

    public AutoDivideLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public AutoDivideLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        dividePaint = new Paint();
        dividePaint.setAntiAlias(true);
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.AutoDivideLinearLayout);
            divideWidth = typedArray.getDimensionPixelSize(R.styleable.AutoDivideLinearLayout_divideWidth, 1);
            dividePadding = typedArray.getDimensionPixelSize(R.styleable.AutoDivideLinearLayout_dividePadding, 0);
            divideColor = typedArray.getColor(R.styleable.AutoDivideLinearLayout_divideColor, Color.BLACK);
            typedArray.recycle();
        }
        dividePaint.setColor(divideColor);
        dividePaint.setStrokeWidth(divideWidth);
        dividePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int orientation = getOrientation();
        for (int index = 1; index < getChildCount() ; index++) {
            View child = getChildAt(index);
            if (child.getVisibility() == GONE) {
                continue;
            }
            if (orientation == HORIZONTAL) {
                int left = child.getLeft();
                canvas.drawLine(left, getTop() + dividePadding, left, getBottom() - dividePadding, dividePaint);
            }
            if (orientation == VERTICAL) {
                int top = child.getTop();
                canvas.drawLine(dividePadding, top, getRight() - dividePadding, top, dividePaint);
            }

        }
    }
}
