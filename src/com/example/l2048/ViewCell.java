package com.example.l2048;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

public class ViewCell extends View {
	private RectF r = new RectF();
	private int number;
	private Canvas canvas =new Canvas();
	private Paint paint = new Paint();
	public ViewCell(Context context,int iwidth,int iheight){
		super(context);
		setLayoutParams(new LayoutParams(iwidth, iheight));
		r.set(0, 0, this.getWidth(), this.getHeight());
		r.inset(2, 2);
		
	}
	public void setNumber(int number){
		onDrawNum(number);
		this.number=number;
	}
	public int getNumber(){
		return number;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		this.canvas=canvas;
		onDrawNum(number);
	}
	//设置边框
	private void onDrawBorder(Canvas canvas) {
		paint.setShader(null);
		paint.setStrokeWidth(10);
		paint.setColor(Color.WHITE);
		canvas.drawLine(0, 0, 0, this.getHeight(), paint);
		canvas.drawLine(0, 0, this.getWidth(), 0, paint);
		canvas.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight(), paint);
		canvas.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight(), paint);
	//在图上画直线，4个参数分别为起始x坐标，起始y坐标，终点x坐标，终点y坐标
	}
	public void onDrawNum(int number){
		
		String bgcolor;
		switch(number){
		case 0:
			bgcolor="#CCC0B3";
		//	paint.setTextSize(50);
			break;
		case 2:
			bgcolor="#EEE4DA";
			paint.setTextSize(80);
			break;
		case 4:
			bgcolor="#EDE0C8";
			paint.setTextSize(85);
			break;
		case 8:
			bgcolor="#F2B179";//#F2B179
			paint.setTextSize(90);
			break;
		case 16:
			bgcolor="#F49563";
			paint.setTextSize(95);
			break;
		case 32:
			bgcolor="#F5794D";
			paint.setTextSize(100);
			break;
		case 64:
			bgcolor="#F55D37";
			paint.setTextSize(105);
			break;
		case 128:
			bgcolor="#EEE863";
			paint.setTextSize(110);
			break;
		case 256:
			bgcolor="#EDB04D";
			paint.setTextSize(115);
			break;
		case 512:
			bgcolor="#ECB04D";
			paint.setTextSize(120);
			break;
		case 1024:
			bgcolor="#EB9437";
			paint.setTextSize(125);
			break;
		case 2048:
			bgcolor="#EA7821";
			paint.setTextSize(130);
			break;
		default:
			bgcolor="#EA7821";
			paint.setTextSize(140);
				break;
		}
		this.setBackgroundColor(Color.parseColor(bgcolor));
		paint.setShader(null);
		paint.setColor(Color.parseColor("#EA7821"));
		canvas.drawRect(r, paint);

		paint.setColor(Color.BLACK);
		paint.setTextAlign(Align.CENTER);//文字横向居中
		paint.setFakeBoldText(true);
		//paint.measureText((String)number);
		String snumber=number+"";
		if(number==0){
			snumber="";
		}
		//paint.measureText(snumber);
	final int x =  ((int) r.left + ((int) r.width() >> 1)
				+ (int)(paint.getTextSize()))+40;
//		final int x =  
//				((int) r.left+(int)paint.measureText(snumber)/2);
		final int y = (int) (this.getHeight()
				- (this.getHeight() - paint.getTextSize()) / 2 - paint
				.getFontMetrics().bottom);
		canvas.drawText(snumber, x, y, paint);//设置字体居中
		onDrawBorder(canvas);
	}
}
