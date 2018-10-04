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
import com.chinasoft.myproject.po.Mydiary;
import com.chinasoft.myproject.po.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// ����1���̳и���Android.app.Activity
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class WriteDiaryActivity extends Activity {
	
	// ����4��������ҳ���еĽ��������
	private EditText diary_title, diary_content;
	private Button buttonwdiary;
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
		this.setContentView(R.layout.write_diary);
		//ȡ��sharedpreferene����
				SharedPreferences preferences = getSharedPreferences("user_data", MODE_WORLD_READABLE);
				String account = preferences.getString("account", "");
				userid = preferences.getInt("userid", 0);
				Toast.makeText(getApplicationContext(), account, Toast.LENGTH_LONG).show();
		// ����5��ʵ�������������
		this.diary_title = (EditText) this.findViewById(R.id.diary_title);
		this.diary_content = (EditText) this.findViewById(R.id.diary_content);
		this.buttonwdiary = (Button) this.findViewById(R.id.buttonwdiary);
		// ����7������󶨼�����
		this.buttonwdiary.setOnClickListener(new ViewOcl());
	}
	
	// ����6������һ���Զ�����ڲ��������Linstener
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			
			case R.id.buttonwdiary:
				
				// ����1����ȡ���ݲ���װ���󣬽�����������л���JSON��
				// ����1-1����ȡ���������
				String diarytitle = diary_title.getText().toString().trim();
				String diarycontent = diary_content.getText().toString().trim();
				Date datetime = new Date();
				
				// ����1-2�������װ
			
				Mydiary mydiary= new Mydiary();
				mydiary.setMdiaryname(diarytitle);
				mydiary.setMdiarycont(diarycontent);
		       mydiary.setMdiarytime(datetime);
		       mydiary.setMdiarystatus(1);
		      // Integer userId = new Integer(userid); 
		       mydiary.setUserid(userid);
				
				// ����1-3�����л�
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
				String diary_data = gson.toJson(mydiary);
				System.out.println("diarydata="+diary_data);
				// ����2����������������ϲ����÷��������緢����������			
				
				// ����2-1������һ����������
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("diary_data", diary_data));
				
				// ����2-2�����÷�ʽʵ������ķ���
				String response = WebAccessUtils.httpRequest("writeDiaryServlet", lstNameValuePairs);				
				System.out.println("response="+ gson.fromJson(response,Boolean.class));
				// ����3������JSON����
				// ����3-1�������л����ݷ�װ��һ������
				Boolean flag= gson.fromJson(response,Boolean.class);
				 
				if(flag){
         		for(int i = 0;i < 100;i++)
						Log.d("TAG", "Reah There");
					Intent intent = new Intent();
					intent.setClass(WriteDiaryActivity.this, MydiaryActivity.class);
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

