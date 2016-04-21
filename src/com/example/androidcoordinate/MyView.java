package com.example.androidcoordinate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View{

	//设置view的默认宽和高，在重写onMeasure中用到
	//注意哦  我们view的宽高设置的都是 30px
	private int defaultWidth = 100;
	private int defaultHeight = 100;
	Paint p = new Paint();
	
	public MyView(Context context){
		super(context);
	}
	public MyView(Context context, AttributeSet set) {
		super(context, set);
	}
	
	/**
	 * 重写onDraw方法
	 * 以控件中心点为中心，宽度的一半为半径画一个红色的圆
	 */
	@Override
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		p.setColor(Color.RED);
		int x = this.getLeft() + this.getWidth()/2;
		int y = this.getTop() + this.getHeight()/2;
		canvas.drawCircle(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, p);
	}
	
	/**
	 * 根据触点来打印MotionEvent的四个坐标值
	 * 注意view的触摸事件，只有触摸view的内容才会触发
	 */
	public boolean onTouchEvent(MotionEvent event){
		//Log.e("getLeft",""+this.getLeft());
		//Log.e("getTop",""+this.getTop());
		//Log.e("getBottom",""+this.getBottom());
		//Log.e("执行onTouchEvent","true");
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			Log.e("MotionEvent.getX()",""+event.getX());
			Log.e("MotionEvent.getY()",""+event.getY());
			Log.e("MotionEvent.getRawX()",""+event.getRawX());
			Log.e("MotionEvent.getRawY()",""+event.getRawY());
			break;
		}
		return true;
	}
	
	/**
	 * 这个地方我们重写onMeasure
	 * 根据View设置的宽度高度属性来给view分配width和height
	 */
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
		if(widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
			//设置宽高的方法
			setMeasuredDimension(defaultWidth,defaultHeight);
		}else if(widthSpecMode == MeasureSpec.AT_MOST){
			setMeasuredDimension(defaultWidth,heightSpecSize);
		}else if(heightSpecMode == MeasureSpec.AT_MOST){
			setMeasuredDimension(widthSpecSize, defaultHeight);
		}
	}
}
