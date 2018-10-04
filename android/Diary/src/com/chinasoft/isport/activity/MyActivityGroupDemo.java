package com.chinasoft.isport.activity;

import com.chinasoft.isport.adapter.MenuImageAdapter;
import com.chinasoft.isport.adapter.PopupMenuTitleAdapter;
import com.chinasoft.isport.adapter.PopupMenuBodyAdapter;
import com.chinasoft.isport.adapter.PopupMenu;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MyActivityGroupDemo extends ActivityGroup {
	private GridView gridviewToolbar; // 
	private MenuImageAdapter menu = null; 
	private LinearLayout content = null; 	
	private int menu_img[] = new int[] { R.drawable.menu_main,
			R.drawable.menu_news, R.drawable.menu_more, R.drawable.menu_sms,
			R.drawable.menu_exit };
	private int width = 0; 
	private int height = 0; 
	private Intent intent = null;
	private boolean isShow = false ;
	private int choosemenu=0;
	
	
	
	private int commonItemIds[] = new int[] { R.drawable.shuoshuo,
			R.drawable.diary, R.drawable.pushactivity };
	
	private int setItemIds[] = new int[] { R.drawable.search,
			R.drawable.myfriend, R.drawable.myinfo,
			R.drawable.logoff};
	
	
	private int titleIds[] = new int[] { R.string.popmenu_common,
			R.string.popmenu_set};
	private PopupMenu popMenu = null ;
	private PopupMenuBodyAdapter commonAdapter = null ;
	private PopupMenuBodyAdapter setAdapter = null ;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//super.requestWindowFeature(Window.FEATURE_NO_TITLE); // 鍙栨秷鏍囬
		super.setContentView(R.layout.main);
		this.gridviewToolbar = (GridView) super.findViewById(R.id.gridviewbar);
		this.content = (LinearLayout) super.findViewById(R.id.content);

		// 锟斤拷锟藉工锟斤拷锟斤拷锟斤拷一些锟斤拷息锟斤拷示
		this.gridviewToolbar.setNumColumns(this.menu_img.length); // 锟斤拷锟斤拷锟斤拷员锟斤拷锟侥革拷锟斤拷
		this.gridviewToolbar.setSelector(new ColorDrawable(Color.TRANSPARENT));
		this.gridviewToolbar.setGravity(Gravity.CENTER);
		this.gridviewToolbar.setVerticalSpacing(0);

		this.width = super.getWindowManager().getDefaultDisplay().getWidth()
				/ this.menu_img.length;
		this.height = super.getWindowManager().getDefaultDisplay().getHeight() / 12;

		this.menu = new MenuImageAdapter(this, this.menu_img, this.width,
				this.height, R.drawable.menu_selected);
		this.gridviewToolbar.setAdapter(this.menu);
		this.switchActivity(0); // 锟斤拷一锟斤拷锟斤拷选锟斤拷
		this.gridviewToolbar
				.setOnItemClickListener(new OnItemClickListenerImpl());
		
		this.popMenu = new PopupMenu(this, this.titleIds, 0x55FFFFFF, new PopupTitleOnItemClickListenerCallback(),
				new PopupBodyOnItemClickListenerCallback());
		this.commonAdapter = new PopupMenuBodyAdapter(this, this.commonItemIds);
		this.setAdapter = new PopupMenuBodyAdapter(this, this.setItemIds);
		
		
		this.popMenu.setPopupMenuBodyAdapter(this.commonAdapter) ;
		this.popMenu.setPopTitleSelected(0) ;
	}

	private class OnItemClickListenerImpl implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			MyActivityGroupDemo.this.switchActivity(position);
		}
	}

	private void switchActivity(int id) { // 锟叫伙拷选锟叫的诧拷锟斤拷
		this.menu.setFocus(id); // 锟斤拷锟斤拷选锟斤拷图片锟侥憋拷锟斤拷
		this.content.removeAllViews(); // 删锟斤拷锟斤拷锟叫碉拷锟斤拷锟斤拷
		switch (id) {
		case 0:
			this.intent = new Intent(MyActivityGroupDemo.this,MainActivity.class );
			break;
		case 1:
			this.intent = new Intent(MyActivityGroupDemo.this, SportTypeActivity.class);
			break;
		case 2:
			this.showPopupMenu() ;
			break;
		case 3:
			
			break;
		case 4:
			this.intent = new Intent(MyActivityGroupDemo.this, MydiaryActivity.class);
			break;
		}
		this.intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		Window subActivity = super.getLocalActivityManager().startActivity(
				"subActivity", this.intent);
		this.content.addView(subActivity.getDecorView(),
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
	}

	private void exitDialog() {
		Dialog dialog = new AlertDialog.Builder(this).setIcon(R.drawable.pic_m)
				.setTitle("推出吗？ ").setMessage("您确定退出吗？")
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						MyActivityGroupDemo.this.finish() ;
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						MyActivityGroupDemo.this.switchActivity(0);
					}
				}).create();

		dialog.show();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			this.exitDialog() ;
		}
		return false ;
	}

	private void showPopupMenu() {
		if (this.isShow) { // 锟窖撅拷锟斤拷示锟斤拷
			this.popMenu.dismiss();
			this.isShow = false;
		} else {
			this.popMenu.showAtLocation(
					MyActivityGroupDemo.this.gridviewToolbar, Gravity.BOTTOM,
					0, this.height);
			this.isShow = true;
		}
	}

	private class PopupBodyOnItemClickListenerCallback implements
			OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			MyActivityGroupDemo.this.popMenu.setPopBodySelected(position, Color.GRAY) ;
			Toast.makeText(MyActivityGroupDemo.this, "您点击了" +position , Toast.LENGTH_SHORT).show() ;
			Intent intent1=new Intent();
			if(choosemenu == 0){
				switch (position) {
				case 0:
					intent1.setClass(MyActivityGroupDemo.this, WriteShuoshuoActivity.class);
    				 startActivity(intent1);
					break;
                 case 1:
                	 intent1.setClass(MyActivityGroupDemo.this, WriteDiaryActivity.class);
     				 startActivity(intent1);
					break;
                 case 2:
                	 System.out.println("开始跳转到发布活动页面");
                	 intent1.setClass(MyActivityGroupDemo.this, PublishActivity.class);
     				 startActivity(intent1);
 					break;
				default:
					break;
				}
			}
			else if(choosemenu == 1){
				switch (position) {
				case 0:
					
					break;
                 case 1:
					
					break;
                 case 2:
                	 intent1.setClass(MyActivityGroupDemo.this, changeinfo.class);
    				 startActivity(intent1);
 					break;
                 case 3:
  					MyActivityGroupDemo.this.exitDialog();
  					break;
				default:
					break;
				}
				
			}
			
			
			
		}
	}
	private class PopupTitleOnItemClickListenerCallback implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			MyActivityGroupDemo.this.popMenu.setPopTitleSelected(position) ;
			switch(position) {
			case 0:
				choosemenu=0;
				MyActivityGroupDemo.this.popMenu
						.setPopupMenuBodyAdapter(MyActivityGroupDemo.this.commonAdapter);
				break;
			case 1:
				choosemenu=1;
				MyActivityGroupDemo.this.popMenu
						.setPopupMenuBodyAdapter(MyActivityGroupDemo.this.setAdapter);
				break;
			
			}
		}}
}