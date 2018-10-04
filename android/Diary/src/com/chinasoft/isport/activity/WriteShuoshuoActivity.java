package com.chinasoft.isport.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.chinasoft.isport.activity.R;

import android.R.id;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chinasoft.isport.internet.WebAccessUtils;
import com.chinasoft.myproject.po.Person;
import com.chinasoft.myproject.po.Publishstatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// ����1���̳и���Android.app.Activity
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class WriteShuoshuoActivity extends Activity {
	
	// ����4��������ҳ���еĽ��������
	private EditText shuoshuo_content;
	private Button buttonwriteshuoshuo;
	private int userid;
	

	// ����2����д�����е�һ������OnCreate()  Ctrl+Shift+S,V	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// ���ڷ��ʻ���������˽�������ʷ��뵽���߳��н���
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		// ��չ�����ظô���ı�����
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// ����3������������Ӧ�Ĳ����ļ����а�
		this.setContentView(R.layout.write_shuoshuo);
		//ȡ��sharedpreferene����
				SharedPreferences preferences = getSharedPreferences("user_data", MODE_WORLD_READABLE);
				String account = preferences.getString("account", "");
				userid = preferences.getInt("userid", 0);
				Toast.makeText(getApplicationContext(), account, Toast.LENGTH_LONG).show();
		// ����5��ʵ�������������
		
		this.shuoshuo_content = (EditText) this.findViewById(R.id.shuoshuo_content);
		this.buttonwriteshuoshuo = (Button) this.findViewById(R.id.buttonwriteshuoshuo);
		// ����7������󶨼�����
		this.buttonwriteshuoshuo.setOnClickListener(new ViewOcl());
	}
	
	// ����6������һ���Զ�����ڲ��������Linstener
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			
			case R.id.buttonwriteshuoshuo:
				
				// ����1����ȡ���ݲ���װ���󣬽�����������л���JSON��
				// ����1-1����ȡ���������
			
				String shuoshuocontent = shuoshuo_content.getText().toString().trim();
				Date datetime = new Date();
				
				// ����1-2�������װ
			
				Publishstatus shuoshuo= new Publishstatus();
				shuoshuo.setStacontext(shuoshuocontent);
				shuoshuo.setStapubtime(datetime);
				shuoshuo.setStastatus(1);
		      // Integer userId = new Integer(userid); 
		       shuoshuo.setUserid(userid);
				
				// ����1-3�����л�
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
				String shuoshuo_data = gson.toJson(shuoshuo);
				System.out.println("shuoshuodata="+shuoshuo_data);
				// ����2����������������ϲ����÷��������緢����������			
				
				// ����2-1������һ����������
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("shuoshuo_data", shuoshuo_data));
				
				// ����2-2�����÷�ʽʵ������ķ���
				String response = WebAccessUtils.httpRequest("writeShuoshuoServlet", lstNameValuePairs);				
				System.out.println("response="+ gson.fromJson(response,Boolean.class));
				// ����3������JSON����
				// ����3-1�������л����ݷ�װ��һ������
				Boolean flag= gson.fromJson(response,Boolean.class);
				 
				if(flag){
//					SharedPreferences.Editor editor = getSharedPreferences(
//							"user_data", MODE_WORLD_WRITEABLE).edit();
//					editor.putString("account", txtAccount.getText().toString());
//					editor.putInt("userid", p.getRegid());
//					editor.commit();
					for(int i = 0;i < 100;i++)
						Log.d("TAG", "Reah There");
					Intent intent = new Intent();
					intent.setClass(WriteShuoshuoActivity.this, MyshuoshuoActivity.class);
					startActivity(intent);
				}else{
					Toast.makeText(getApplicationContext(), "����ʧ��!", Toast.LENGTH_LONG).show();
				}
				
				
				break;
			default:
				break;
			}
		}
		
	}

	
	
	
}

