package com.chinasoft.isport.activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.chinasoft.isport.internet.WebAccessUtils;
import com.chinasoft.myproject.po.Activityinvitation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class PublishActivity extends Activity {
	private Button actibegdate,actibegtime,actienddate,actiendtime;
	private ImageButton btnreturn,btnok;
	private Spinner spSport=null;//运动标签
	private EditText edt_actiname,edt_actiplace,edt_acticont;

	private Date begtime,endtime,settime;
	private String name,place,count;
	private int sposition;
	private int y1,M1,d1,h1,m1;
	private int y2,M2,d2,h2,m2;
	private int userid;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 由于访问互联网，因此将网络访问放入到子线程中进行
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		// 设置布局文件
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		this.setContentView(R.layout.publish_acti);
		// 设置标题栏
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.titlebar_publishacti);
		// 取得sharedpreferene数据
		SharedPreferences preferences = getSharedPreferences("user_data",
				MODE_WORLD_READABLE);
		String account = preferences.getString("account", "");
		userid = preferences.getInt("userid", 0);
		Toast.makeText(getApplicationContext(), account, Toast.LENGTH_LONG)
				.show();

		//从布局文件中取得交互的变量,实例化操作类组件
		this.btnreturn=(ImageButton)super.findViewById(R.id.pubacti_return);
		this.btnok=(ImageButton)super.findViewById(R.id.pubacti_OK);
		this.actibegdate=(Button)super.findViewById(R.id.actibegdate);
		this.actibegtime=(Button)super.findViewById(R.id.actibegtime);
		this.actienddate=(Button)super.findViewById(R.id.actienddate);
		this.actiendtime=(Button)super.findViewById(R.id.actiendtime);
		this.spSport=(Spinner)super.findViewById(R.id.spSport);
		this.edt_acticont=(EditText)super.findViewById(R.id.edt_acticont);
		this.edt_actiname=(EditText)super.findViewById(R.id.edt_actiname);
	    this.edt_actiplace=(EditText)super.findViewById(R.id.edt_actiplace);
		// 设置适配器
		this.actibegdate.setOnClickListener(new DateListener());
		this.actienddate.setOnClickListener(new DateListener());
		this.actibegtime.setOnClickListener(new TimeListener());
		this.actiendtime.setOnClickListener(new TimeListener());
		//返回和确认发表的监听器
		this.btnok.setOnClickListener(new ChooseListener());
		this.btnreturn.setOnClickListener(new ChooseListener());
		this.spSport.setOnItemSelectedListener(new ItemSelectedListener());
	}
	private class ItemSelectedListener implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			PublishActivity.this.sposition=arg2;
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
			PublishActivity.this.sposition=0;
		}
		
	}
	private class DateListener implements OnClickListener {
		 
		@Override
		public void onClick(View view) {
			switch (view.getId()) {
			case R.id.actibegdate:
	      	Dialog dialog1 = new DatePickerDialog(PublishActivity.this,new DatePickerDialog.OnDateSetListener() {
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
					         PublishActivity.this.y1=year;
					         PublishActivity.this.M1=monthOfYear;
					         PublishActivity.this.d1=dayOfMonth;
							PublishActivity.this.actibegdate.setText( year + "-" + monthOfYear + "-" + dayOfMonth) ;
						} },2014,7,24) ; // 默认的年、月、日
					dialog1.show();	// 显示对话框
				break;
			case R.id.actienddate:
				Dialog dialog2=new DatePickerDialog(PublishActivity.this, new DatePickerDialog.OnDateSetListener() {
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
								PublishActivity.this.y2 = year;
								PublishActivity.this.M2 = monthOfYear;
								PublishActivity.this.d2 = dayOfMonth;
							PublishActivity.this.actienddate.setText( year + "-" + monthOfYear + "-" + dayOfMonth) ;
						} }, 2014, 7, 24);
				dialog2.show();
				break;
			default:
			    break;
			}	
		}
	}
	private class TimeListener implements OnClickListener {
		 
		@Override
		public void onClick(View view) {
			
			switch (view.getId()) {
			case R.id.actibegtime:
				Dialog dialog3 = new TimePickerDialog(PublishActivity.this,new TimePickerDialog.OnTimeSetListener() {
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						 PublishActivity.this.h1=hourOfDay;
				         PublishActivity.this.m1=minute;
				        
						PublishActivity.this.actibegtime.setText(hourOfDay + ":" + minute) ;
					}
				},19,20,true);
				dialog3.show() ;
				break;
			case R.id.actiendtime:
				Dialog dialog4 = new TimePickerDialog(PublishActivity.this,new TimePickerDialog.OnTimeSetListener() {
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						PublishActivity.this.h2=hourOfDay;
				        PublishActivity.this.m2=minute;
						PublishActivity.this.actiendtime.setText(hourOfDay + ":" + minute) ;
					}
				},19,20,true);
				dialog4.show() ;
				break;
			default:
			    break;
			}	
			
			
			
		}
		
	}
	private class ChooseListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.pubacti_OK:
             //处理数据,封装数据
	            
				
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss",Locale.CHINA);
				Date date1=new Date();
				Date date2=new Date();;
				try {
					date1 = format.parse("y1"+"M1"+"d1"+"h1"+"m1"+"00");
					date2=format.parse("y2"+"M2"+"d2"+"h2"+"m2"+"00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("时间转换失败");
				}
				 
				Activityinvitation activityinvitation=new Activityinvitation();
				activityinvitation.setUserid(userid);
				activityinvitation.setSportid(PublishActivity.this.sposition+1);
				
				activityinvitation.setActibegtime(date1);
				activityinvitation.setActiendtime(date2);
				activityinvitation.setActisettime(new Date());
				activityinvitation.setActiplace(PublishActivity.this.edt_actiplace.getText().toString());
				activityinvitation.setActiname(PublishActivity.this.edt_actiname.getText().toString());
				activityinvitation.setActicont(PublishActivity.this.edt_acticont.getText().toString());
				//测试封装数据
				System.out.println("封装的数据是"+activityinvitation.toString());
				// 步骤1-3：序列化
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
				String acti_data = gson.toJson(activityinvitation);
				// 步骤2：设置请求参数集合并调用方法向网络发送请求数据			
				// 步骤2-1：创建一个参数集合
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("acti_data", acti_data));
				// 步骤2-2：调用方式实现请求的发送
				System.out.println("要去发表的servlet了呢");
				String response = WebAccessUtils.httpRequest("pubActiServlet", lstNameValuePairs);	
				System.out.println("从servlet转换之后，是否成功："+response);
				
				boolean a=gson.fromJson(response, Boolean.class);
				if (a) {
					Toast.makeText(getApplicationContext(),
							"发表活动成功", Toast.LENGTH_LONG)
							.show();
					Intent intent = new Intent();
					intent.setClass(PublishActivity.this, MyActivityGroupDemo.class);
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(),
							"发表活动失败", Toast.LENGTH_LONG)
							.show();
				}
				break;
			case R.id.pubacti_return:
				// 界面跳转
				Intent intent = new Intent();
				intent.setClass(PublishActivity.this, MyActivityGroupDemo.class);
				startActivity(intent);
				break;
			default:
				break;
			}
			
		}
		
	}
	
	

}
