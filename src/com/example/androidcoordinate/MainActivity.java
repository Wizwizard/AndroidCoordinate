package com.example.androidcoordinate;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这句话来去掉默认的title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        //通知栏高度
        Log.e("通知栏高度",""+getStatusBarHeight());
    }
    
    public int getStatusBarHeight(){
    	int result = 0;
    	int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
    	if (resourceId > 0) {
    	    result = getResources().getDimensionPixelSize(resourceId);
    	}
    	return result;
    }


}
