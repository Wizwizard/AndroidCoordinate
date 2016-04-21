package com.example.androidcoordinate;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * 
 * @author ������
 * �����Զ���һ��viewGroup���̳�RelativeLayout
 * ����������ڣ��ô������һ�������Զ����MyView
 */

public class MyViewGroup extends RelativeLayout{

	//����һ�������Զ���� MyView
	private MyView myView  = null;
	
	//ͨ��LayoutParams������MyView�ڸ�ViewGroup�еĲ���
	private LayoutParams layoutParams = null;

	public MyViewGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
		myView = new MyView(context);
		
		//����myView�Ŀ�߾�Ϊwrap_content
		layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		
		//����myView�Ĳ���λ��Ϊ��ViewGroup�����Ͻǣ��������Ǳȶ�����
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,TRUE);
		
		//����myView�ı���Ϊ��ɫ������۲�myView��������Χ
		myView.setBackgroundColor(Color.BLUE);
		
		// �����myView��layoutPrams��ӵ�MyViewGroup��
		addView(myView,layoutParams);
		
		//����ֱ���ڹ��췽�������ӡ������Ϊ��ʱ�򲼾ֻ�û�����ɣ����Դ�ӡ��������0
		//display();
	}
	
	//ͬ��Ҳ��ViewGroup����д�˴����¼�
		@Override
		public boolean onTouchEvent(MotionEvent event){
			switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:
				//��ӡ�������λ��
				Log.e("MotionEvent.getX()",""+event.getX());
				Log.e("MotionEvent.getY()",""+event.getY());
				Log.e("MotionEvent.getRawX()",""+event.getRawX());
				Log.e("MotionEvent.getRawY()",""+event.getRawY());
				//��ӡmyView��λ��
				display();
				break;
			}
			return true;
		}
		
	//�������������ʾmyView�ĸ����������ķ���
	//���Ű�����������view���õ���wrap_content�µ�Ĭ�Ͽ����100 100
	private void display(){
		
		//��ӡmyView��viewGroup�е�λ��
		Log.e("myView.getLeft()",""+myView.getLeft());
		Log.e("myView.getRight()",""+myView.getRight());
		Log.e("myView.getTop()",""+myView.getTop());
		Log.e("myView.getBottom",""+myView.getBottom());
		
		//��ӡmyView��window�е�λ��
		int[] location1 = new int[2];
		myView.getLocationInWindow(location1);
		int viewX1 = location1[0];
		int viewY1 = location1[1];
		Log.e("myView.getLocationInWindow","InWindow x����"+viewX1);
		Log.e("myView.getLocationInWindow","InWindow y����"+viewY1);
		
		//��ӡmyView��screen�е�λ��
		int[] location2 = new int[2];
		myView.getLocationOnScreen(location2);
		int viewX2 = location2[0];
		int viewY2 = location2[1];
		Log.e("myView.getLocationOnScreen","OnScreen x����"+viewX2);
		Log.e("myView.getLocationOnScreen","OnScreen y����"+viewY2);
	}
	
	

}

