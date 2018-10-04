package com.chinasoft.isport.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class PopupMenu extends PopupWindow {
	private GridView popTitle ;	// 锟斤拷示锟斤拷锟斤拷
	private GridView popBody ;	// 锟斤拷锟斤拷锟斤拷锟斤拷
	private PopupMenuTitleAdapter titleAdapter = null ;
	private LinearLayout layout = null ;

	public PopupMenu(Context context, int titleIds[],int backgroundColor,
			OnItemClickListener titleCallback, OnItemClickListener bodyCallback) {
		super(context); // 锟斤拷锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		this.titleAdapter = new PopupMenuTitleAdapter(context, titleIds,
				0xFF222222, 16, 0xffeeede9, Color.WHITE);
		this.layout = new LinearLayout(context) ;
		this.layout.setOrientation(LinearLayout.VERTICAL) ;
		this.popTitle = new GridView(context);
		this.popTitle.setLayoutParams(new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT)); 
		this.popTitle.setNumColumns(titleIds.length) ;
		this.popTitle.setHorizontalSpacing(1) ;
		this.popTitle.setVerticalSpacing(1) ;
		this.popTitle.setStretchMode(GridView.STRETCH_COLUMN_WIDTH); // 锟斤拷锟斤拷锟叫匡拷
		this.popTitle.setAdapter(this.titleAdapter) ;
		this.popTitle.setOnItemClickListener(titleCallback) ;
		
		this.popBody = new GridView(context) ;
		this.popBody.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		this.popBody.setNumColumns(5) ;
		this.popBody.setHorizontalSpacing(1) ;
		this.popBody.setVerticalSpacing(1) ;
		this.popBody.setPadding(10, 10, 10, 10) ;
		this.popBody.setGravity(Gravity.CENTER) ;
		this.popBody.setStretchMode(GridView.STRETCH_COLUMN_WIDTH); // 锟斤拷锟斤拷锟叫匡拷
		this.popBody.setOnItemClickListener(bodyCallback) ;
		
		this.layout.addView(this.popTitle) ;
		this.layout.addView(this.popBody) ;
		super.setContentView(this.layout) ;
		super.setWidth(LayoutParams.FILL_PARENT) ;
		super.setHeight(LayoutParams.WRAP_CONTENT) ;
		super.setBackgroundDrawable(new ColorDrawable(backgroundColor)) ;
		super.setFocusable(true) ;	// 锟斤拷锟斤拷锟矫斤拷锟斤拷
	}
	
	public void setPopupMenuBodyAdapter(PopupMenuBodyAdapter adapter) {
		this.popBody.setAdapter(adapter) ;
	}
	
	public void setPopTitleSelected(int postion) {
		this.popTitle.setSelection(postion) ;
		this.titleAdapter.setFocus(postion) ;
	}
	
	public void setPopBodySelected(int position,int selectedColor) {	// 锟斤拷锟斤拷选锟叫猴拷锟斤拷锟缴�
		int count = this.popBody.getChildCount() ;
		for (int x = 0; x < count; x++) {
			if (x != position) {
				ImageView img = (ImageView) this.popBody.getChildAt(x) ;
				img.setBackgroundColor(Color.TRANSPARENT) ;
			}
		}
		ImageView img = (ImageView) this.popBody.getChildAt(position) ;
		img.setBackgroundColor(selectedColor) ;
	}
}
