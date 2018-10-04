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

// 步骤1：继承父类Android.app.Activity
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class WriteShuoshuoActivity extends Activity {
	
	// 步骤4：声明该页面中的交互类组件
	private EditText shuoshuo_content;
	private Button buttonwriteshuoshuo;
	private int userid;
	

	// 步骤2：重写父类中的一个方法OnCreate()  Ctrl+Shift+S,V	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 由于访问互联网，因此将网络访问放入到子线程中进行
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		// 扩展：隐藏该窗体的标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 步骤3：将窗体与相应的布局文件进行绑定
		this.setContentView(R.layout.write_shuoshuo);
		//取得sharedpreferene数据
				SharedPreferences preferences = getSharedPreferences("user_data", MODE_WORLD_READABLE);
				String account = preferences.getString("account", "");
				userid = preferences.getInt("userid", 0);
				Toast.makeText(getApplicationContext(), account, Toast.LENGTH_LONG).show();
		// 步骤5：实例化操作类组件
		
		this.shuoshuo_content = (EditText) this.findViewById(R.id.shuoshuo_content);
		this.buttonwriteshuoshuo = (Button) this.findViewById(R.id.buttonwriteshuoshuo);
		// 步骤7：组件绑定监听器
		this.buttonwriteshuoshuo.setOnClickListener(new ViewOcl());
	}
	
	// 步骤6：创建一个自定义的内部类监听器Linstener
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			
			case R.id.buttonwriteshuoshuo:
				
				// 步骤1：获取数据并封装对象，将对象进行序列化（JSON）
				// 步骤1-1：获取标题和内容
			
				String shuoshuocontent = shuoshuo_content.getText().toString().trim();
				Date datetime = new Date();
				
				// 步骤1-2：对象封装
			
				Publishstatus shuoshuo= new Publishstatus();
				shuoshuo.setStacontext(shuoshuocontent);
				shuoshuo.setStapubtime(datetime);
				shuoshuo.setStastatus(1);
		      // Integer userId = new Integer(userid); 
		       shuoshuo.setUserid(userid);
				
				// 步骤1-3：序列化
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
				String shuoshuo_data = gson.toJson(shuoshuo);
				System.out.println("shuoshuodata="+shuoshuo_data);
				// 步骤2：设置请求参数集合并调用方法向网络发送请求数据			
				
				// 步骤2-1：创建一个参数集合
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("shuoshuo_data", shuoshuo_data));
				
				// 步骤2-2：调用方式实现请求的发送
				String response = WebAccessUtils.httpRequest("writeShuoshuoServlet", lstNameValuePairs);				
				System.out.println("response="+ gson.fromJson(response,Boolean.class));
				// 步骤3：处理JSON数据
				// 步骤3-1：反序列化数据封装成一个对象
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
					Toast.makeText(getApplicationContext(), "发送失败!", Toast.LENGTH_LONG).show();
				}
				
				
				break;
			default:
				break;
			}
		}
		
	}

	
	
	
}

