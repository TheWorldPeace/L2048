package com.example.l2048;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class BestScode {
	
	private SharedPreferences sp;
	//SharedPreferences为安卓中的一个存储类，用来存储配置，两个activity之间可通过它传输数据
	public BestScode(Context context){
		sp = context.getSharedPreferences("bestscode", context.MODE_PRIVATE);
		//为默认操作模式,代表该文件是私有数据,只能被应用本身访问,在该模式下,写入的内容会覆盖原文件的内容
	}
	public int getBestScode(){
		int bestscode = sp.getInt("bestscode", 0);
		return bestscode;
	}
	public void setBestScode(int bestScode){
		Editor editor = sp.edit();
		editor.putInt("bestscode", bestScode);

		editor.commit();
	}
}
