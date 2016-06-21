package com.example.l2048;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class BestScode {
	
	private SharedPreferences sp;
	//SharedPreferencesΪ��׿�е�һ���洢�࣬�����洢���ã�����activity֮���ͨ������������
	public BestScode(Context context){
		sp = context.getSharedPreferences("bestscode", context.MODE_PRIVATE);
		//ΪĬ�ϲ���ģʽ,������ļ���˽������,ֻ�ܱ�Ӧ�ñ������,�ڸ�ģʽ��,д������ݻḲ��ԭ�ļ�������
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
