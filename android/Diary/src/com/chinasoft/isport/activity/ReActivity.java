package com.chinasoft.isport.activity;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;

import com.chinasoft.myproject.po.Actihuo;
import com.chinasoft.isport.adapter.MyBaseAdapter;
import com.chinasoft.isport.adapter.MyBaseAdapter.OnBtnClickListener;
import com.chinasoft.isport.internet.WebAccessUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.FeatureInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ReActivity extends ListActivity {

	//
	private List<Map<String, ?>> lstData;
	private ImageButton goback;
    private int userid;
	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 设置标题栏
	   	requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	   	//setContentView(R.layout.re_acti);
	   	getListView();
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titlebar_reacti);
		// 取得sharedpreferene数据
		SharedPreferences preferences = getSharedPreferences("user_data",
				MODE_WORLD_READABLE);
		String account = preferences.getString("account", "");
		userid = preferences.getInt("userid", 0);
		Toast.makeText(getApplicationContext(), account, Toast.LENGTH_LONG)
				.show();
		this.lstData = fetchData();
		this.goback=(ImageButton)super.findViewById(R.id.reacti_return);
		// 设置适配器
		MyBaseAdapter mba = new MyBaseAdapter(this, lstData);
		setListAdapter(mba);
		mba.setOnBtnClickListener(new OnBtnClickListener() {
			@Override
			public void OnBtnClick(View view, int opt, Map map) {
				int actiid = (Integer)map.get("actiid");
				String flag=null;
				//封装上传活动和user的数据
				int userid=1;
				// 步骤1-3：序列化
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
				String user_data = gson.toJson(userid);
				String acti_data= gson.toJson(actiid);
				// 步骤2：设置请求参数集合并调用方法向网络发送请求数据			
				// 步骤2-1：创建一个参数集合
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
				lstNameValuePairs.add(new BasicNameValuePair("acti_data", acti_data));
				
				switch (view.getId()) {
				
				case R.id.actiJoin:
					Button but = (Button) view;
					CharSequence aj = but.getText();
					if (aj.equals("同意参加")) {
						
						
						// 步骤2-2：调用方式实现请求的发送
						String response = WebAccessUtils.httpRequest("joinServlet", lstNameValuePairs);				
						boolean a=gson.fromJson(response, Boolean.class);
						// 步骤3：处理JSON数据
						// 步骤3-1：反序列化数据封装成一个对象
						//根据返回结果做出判断
						if (a) {
							Toast.makeText(getApplicationContext(),
									"参加活动" + actiid + "成功", Toast.LENGTH_LONG)
									.show();
							but.setText("取消参加");
						} else {
							Toast.makeText(getApplicationContext(),
									"参加活动" + actiid + "失败", Toast.LENGTH_LONG)
									.show();
						}
						
					} else {

						// 步骤2-2：调用方式实现请求的发送
						String response = WebAccessUtils.httpRequest("cancelJoinServlet", lstNameValuePairs);				
						boolean b=gson.fromJson(response, Boolean.class);
						// 步骤3：处理JSON数据
						// 步骤3-1：反序列化数据封装成一个对象
						//根据返回结果做出判断
						if (b) {
							Toast.makeText(getApplicationContext(),
									"取消活动" + actiid + "成功", Toast.LENGTH_LONG)
									.show();
							but.setText("同意参加");
						} else {
							Toast.makeText(getApplicationContext(),
									"取消活动" + actiid + "失败", Toast.LENGTH_LONG)
									.show();
						}
						
					}

					break;
               case R.id.actiZan:
            	   Button but1 = (Button) view;
				   CharSequence az = but1.getText();
					if (az.equals("力赞")) {
						// 步骤2-2：调用方式实现请求的发送
						System.out.println(lstNameValuePairs.toString());
						System.out.println("要去点赞的servlet了呢。");
						String response = WebAccessUtils.httpRequest("dianZanServlet", lstNameValuePairs);
						System.out.println("response:"+response);
						boolean a=gson.fromJson(response, Boolean.class);
						System.out.println("布尔值"+a);
						// 步骤3：处理JSON数据
						// 步骤3-1：反序列化数据封装成一个对象
						//根据返回结果做出判断
						if (a) {
							Toast.makeText(getApplicationContext(),
									"力赞" + actiid + "成功", Toast.LENGTH_LONG)
									.show();
							but1.setText("消赞");
						} else {
							Toast.makeText(getApplicationContext(),
									"力赞" + actiid + "失败", Toast.LENGTH_LONG)
									.show();
						}
						
						
					} else {
						// 步骤2-2：调用方式实现请求的发送
						String response = WebAccessUtils.httpRequest("cancelZanServlet", lstNameValuePairs);				
						boolean b=gson.fromJson(response, Boolean.class);
						// 步骤3：处理JSON数据
						// 步骤3-1：反序列化数据封装成一个对象
						//根据返回结果做出判断
						if (b) {
							Toast.makeText(getApplicationContext(),
									"消赞" + actiid + "成功", Toast.LENGTH_LONG)
									.show();
							but1.setText("力赞");
						} else {
							Toast.makeText(getApplicationContext(),
									"消赞" + actiid + "失败", Toast.LENGTH_LONG)
									.show();
						}
						
					}

					break;
				default:
					break;
				}
				
			}
		});
		
	//
		this.goback.setOnClickListener(new GobackListener());
	
		
	}
	
	
	
	// 获取数据
		private List<Map<String, ?>> fetchData() {
			// TODO Auto-generated method stub
			// 建立空的List接收数据
			List<Map<String, ?>> lst = new ArrayList<Map<String, ?>>();
					
			// 从网络端获取数据
			// 步骤4-2：调用方法实现对网络服务的请求
			String response = WebAccessUtils.httpRequest("reActiServlet");
			System.out.println("response="+response);
			// 步骤4-3：设置一个全新的类型Type
			Type ListMessages = new TypeToken<ArrayList<Actihuo>>() {
			}.getType();

			// 步骤4-4：创建并实例化一个Gson对象
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss")
					.create();
			// 步骤4-5：解析JSon数据
			List<Actihuo> lstActi = gson.fromJson(response, ListMessages);

			// 步骤4-6：使用循环遍历集合对象
			for (Actihuo acti: lstActi) {
				Map<String, Object> item01 = new HashMap<String, Object>();
				item01.put("userid", ReActivity.this.userid);
				item01.put("actiid", acti.getActiid());
				item01.put("actiPhoto", R.drawable.p2);
				item01.put("actiNickName", acti.getNickname());
				item01.put("actiRank", acti.getRank()+"级");
				item01.put("actiPublish",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA).format(acti.getActisettime()));
				item01.put("actiName", acti.getActiname());
				item01.put("actiSport", acti.getSportname());
				item01.put("actiBegtime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA).format(acti.getActibegtime()));
				item01.put("actiEndtime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA).format(acti.getActiendtime()));
				item01.put("actiPlace", acti.getActiplace());
				item01.put("actiCont", acti.getActicont());
				item01.put("actiUsercount", "已有"+acti.getActiusercount()+"人参加");
				// 步骤4-7：将创建好的选项对象添加到集合中
				lst.add(item01);
			}

			
			return lst;
		}
	private class GobackListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//界面跳转
			// 界面跳转
			Intent intent = new Intent();
			intent.setClass(ReActivity.this, MainActivity.class);
			startActivity(intent);
			
		}
		
	}

}
