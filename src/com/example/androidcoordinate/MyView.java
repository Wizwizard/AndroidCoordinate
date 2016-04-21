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

	//����view��Ĭ�Ͽ�͸ߣ�����дonMeasure���õ�
	//ע��Ŷ  ����view�Ŀ�����õĶ��� 30px
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
	 * ��дonDraw����
	 * �Կؼ����ĵ�Ϊ���ģ���ȵ�һ��Ϊ�뾶��һ����ɫ��Բ
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
	 * ���ݴ�������ӡMotionEvent���ĸ�����ֵ
	 * ע��view�Ĵ����¼���ֻ�д���view�����ݲŻᴥ��
	 */
	public boolean onTouchEvent(MotionEvent event){
		//Log.e("getLeft",""+this.getLeft());
		//Log.e("getTop",""+this.getTop());
		//Log.e("getBottom",""+this.getBottom());
		//Log.e("ִ��onTouchEvent","true");
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
	 * ����ط�������дonMeasure
	 * ����View���õĿ�ȸ߶���������view����width��height
	 */
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
		if(widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
			//���ÿ�ߵķ���
			setMeasuredDimension(defaultWidth,defaultHeight);
		}else if(widthSpecMode == MeasureSpec.AT_MOST){
			setMeasuredDimension(defaultWidth,heightSpecSize);
		}else if(heightSpecMode == MeasureSpec.AT_MOST){
			setMeasuredDimension(widthSpecSize, defaultHeight);
		}
	}
}
