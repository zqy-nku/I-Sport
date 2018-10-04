package com.chinasoft.isport.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MenuImageAdapter extends BaseAdapter {
	private ImageView[] menuImg; // 锟斤拷锟斤拷锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷锟�
	private Context context = null; // 锟斤拷锟斤拷锟侥讹拷锟斤拷
	private int selectedMenuImg; // 选锟叫碉拷锟斤拷锟斤拷

	public MenuImageAdapter(Context context, int imgIds[], int width,
			int height, int selectedMenuImg) {
		this.context = context;
		this.selectedMenuImg = selectedMenuImg;
		this.menuImg = new ImageView[imgIds.length]; // 锟斤拷锟斤拷锟铰碉拷锟斤拷锟斤拷
		for (int x = 0; x < imgIds.length; x++) {
			this.menuImg[x] = new ImageView(this.context); // 实锟斤拷ImageView
			this.menuImg[x].setLayoutParams(new GridView.LayoutParams(width,
					height));	// 锟斤拷锟斤拷图片锟侥达拷小
			this.menuImg[x].setAdjustViewBounds(false); // 锟斤拷锟斤拷锟斤拷呓锟斤拷锟绞�
			this.menuImg[x].setPadding(3, 3, 3, 3);// 锟斤拷锟矫硷拷锟�
			this.menuImg[x].setImageResource(imgIds[x]);// 锟斤拷锟斤拷锟斤拷示图片
		}
	}

	@Override
	public int getCount() {
		return this.menuImg.length;
	}

	@Override
	public Object getItem(int position) {
		return this.menuImg[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imgView = null ;
		if(convertView == null) {
			imgView = this.menuImg[position] ; 
		} else {
			imgView = (ImageView) convertView ;
		}
		return imgView;
	}

	public void setFocus(int selId) {	// 锟斤拷锟斤拷选锟叫碉拷锟斤拷示
		for (int x = 0; x < this.menuImg.length; x++) {
			if (x != selId) {	// 没锟斤拷选锟叫碉拷
				this.menuImg[x].setBackgroundResource(0) ;	// 锟斤拷锟斤拷锟矫憋拷锟斤拷图片
			}
		}
		this.menuImg[selId].setBackgroundResource(this.selectedMenuImg) ;
	}
}
