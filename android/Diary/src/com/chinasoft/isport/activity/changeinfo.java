package com.chinasoft.isport.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.chinasoft.isport.activity.R;
import com.chinasoft.isport.internet.WebAccessUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class changeinfo extends Activity {
	private List labelList = new ArrayList();
	private ListView listView;
	
	private Button button1;//全选
	private Button button2;//反选
	private Button button3;//取值
	private Button btnchangedeclaration;//运动宣言保存；
	private Button btnchangenickname;//昵称保存；
	private Button btnchangeaddress;//城市保存；
	private EditText txtdeclaration;
	private EditText txtNickname;
	private EditText txtAddress;
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
			this.setContentView(R.layout.info_detail);
			//取得sharedpreferene数据
					SharedPreferences preferences = getSharedPreferences("user_data", MODE_WORLD_READABLE);
					String account = preferences.getString("account", "");
					userid = preferences.getInt("userid", 0);
					Toast.makeText(getApplicationContext(), account, Toast.LENGTH_LONG).show();
		
		this.listView=(ListView) this.findViewById(R.id.listView1);
		this.button1=(Button) this.findViewById(R.id.button1);
		this.button2=(Button) this.findViewById(R.id.button2);
		this.button3=(Button) this.findViewById(R.id.button3);
		this.btnchangedeclaration=(Button) this.findViewById(R.id.btnchangedeclaration);
		this.btnchangenickname=(Button) this.findViewById(R.id.btnchangenickname);
		this.btnchangeaddress=(Button) this.findViewById(R.id.btnchangeaddress);
		this.txtdeclaration=(EditText) this.findViewById(R.id.txtdeclaration);
		this.txtNickname=(EditText) this.findViewById(R.id.txtNickname);
		this.txtAddress=(EditText) this.findViewById(R.id.txtAddress);
		// 步骤7：组件绑定监听器
		this.btnchangedeclaration.setOnClickListener(new ViewOcl());
		this.btnchangenickname.setOnClickListener(new ViewOcl());
		this.btnchangeaddress.setOnClickListener(new ViewOcl());
	
		final boolean[] isCheckedArray= new boolean[8];
		isCheckedArray[0] = false;
		isCheckedArray[1]=true;
		isCheckedArray[2]=false;
		isCheckedArray[3]=true;
		isCheckedArray[4]=false;
		isCheckedArray[5]=true;
		isCheckedArray[6]=false;
		isCheckedArray[7]=true;
		
		labelList.add("足球");
		labelList.add("羽毛球");
		labelList.add("篮球");
		labelList.add("高尔夫");
		labelList.add("钓鱼");
		labelList.add("乒乓球");
		labelList.add("游泳");
		labelList.add("广场舞");
		
		ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,labelList);
		
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> arg0,View arg1,int arg2,
					long arg3){
				Log.v("----------",""+((TextView)arg1).getText());
			}
			
		});
		
		//赋初始值
		for(int i=0;i<isCheckedArray.length;i++){
			listView.setItemChecked(i, isCheckedArray[i]);
		}
		button1.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				Log.v("点击了全选", "单击了全选");
				
				for (int i=0;i<isCheckedArray.length;i++){
					listView.setItemChecked(i, true);
				}
			}
		});
		//反选
		button2.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				Log.v("单击了反选", "单击了反选");
				
				SparseBooleanArray sparseBooleanArrayRef=listView.getCheckedItemPositions();
				for(int i=0;i<sparseBooleanArrayRef.size();i++){
					if(sparseBooleanArrayRef.get(i)==true){
						listView.setItemChecked(i, false);
					}else{
						listView.setItemChecked(i, true);
					}
				}
				
			}
		});
		//取值
		button3.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				Log.v("单击了取值", "单击了取值");
				
				SparseBooleanArray sparseBooleanArrayRef=listView.getCheckedItemPositions();
				for(int i=0;i<sparseBooleanArrayRef.size();i++){
					if(sparseBooleanArrayRef.get(i)==true){
						Log.v("值为：",""+listView.getAdapter().getItemId(i)+""+listView.getAdapter().getItem(i));
					}
				}
			}
		});
		
	}
	
		// 步骤6：创建一个自定义的内部类监听器Linstener
		private class ViewOcl implements View.OnClickListener{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.btnchangedeclaration:
					// 步骤1：获取数据并封装对象，将对象进行序列化（JSON）
					// 步骤1-1：获取宣言内容
					String declaration=txtdeclaration.getText().toString().trim();
					// 步骤1-3：序列化
					Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
					String declar_data = gson.toJson(declaration);
					String user_data=gson.toJson(userid);
					// 步骤2-1：创建一个参数集合
					List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
					lstNameValuePairs.add(new BasicNameValuePair("declar_data", declar_data));
					lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
					// 步骤2-2：调用方式实现请求的发送
					String response = WebAccessUtils.httpRequest("changeDeclarationServlet", lstNameValuePairs);				
					System.out.println("response="+ gson.fromJson(response,Boolean.class));
					
					// 步骤3：处理JSON数据
					// 步骤3-1：反序列化数据封装成一个对象
					Boolean flag= gson.fromJson(response,Boolean.class);
					 
					if(flag){
	         		for(int i = 0;i < 100;i++)
							Log.d("TAG", "Reah There");
	         		Toast.makeText(getApplicationContext(), "修改成功!", Toast.LENGTH_LONG).show();
						
					}else{
						Toast.makeText(getApplicationContext(), "修改失败!", Toast.LENGTH_LONG).show();
					}
					
					
					break;
				case R.id.btnchangenickname:
					// 步骤1：获取数据并封装对象，将对象进行序列化（JSON）
					// 步骤1-1：获取宣言内容
					String nickname=txtNickname.getText().toString().trim();
					// 步骤1-3：序列化
					Gson gson1 = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
					String nickname_data = gson1.toJson(nickname);
					String user1_data=gson1.toJson(userid);
					// 步骤2-1：创建一个参数集合
					List<NameValuePair> lstNameValuePairs1 = new ArrayList<NameValuePair>();
					lstNameValuePairs1.add(new BasicNameValuePair("nickname_data", nickname_data));
					lstNameValuePairs1.add(new BasicNameValuePair("user1_data", user1_data));
					// 步骤2-2：调用方式实现请求的发送
					String response1 = WebAccessUtils.httpRequest("changeNicknameServlet", lstNameValuePairs1);				
					System.out.println("response1="+ gson1.fromJson(response1,Boolean.class));
					
					// 步骤3：处理JSON数据
					// 步骤3-1：反序列化数据封装成一个对象
					Boolean flag1= gson1.fromJson(response1,Boolean.class);
					 
					if(flag1){
	         		for(int i = 0;i < 100;i++)
							Log.d("TAG", "Reah There");
	         		Toast.makeText(getApplicationContext(), "修改成功!", Toast.LENGTH_LONG).show();
						
					}else{
						Toast.makeText(getApplicationContext(), "修改失败!", Toast.LENGTH_LONG).show();
					}
						break;
				case R.id.btnchangeaddress:
					// 步骤1：获取数据并封装对象，将对象进行序列化（JSON）
					// 步骤1-1：获取宣言内容
					String address=txtAddress.getText().toString().trim();
					// 步骤1-3：序列化
					Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
					String address_data = gson2.toJson(address);
					String user2_data=gson2.toJson(userid);
					// 步骤2-1：创建一个参数集合
					List<NameValuePair> lstNameValuePairs2 = new ArrayList<NameValuePair>();
					lstNameValuePairs2.add(new BasicNameValuePair("address_data", address_data));
					lstNameValuePairs2.add(new BasicNameValuePair("user2_data", user2_data));
					// 步骤2-2：调用方式实现请求的发送
					String response2 = WebAccessUtils.httpRequest("changeAddressServlet", lstNameValuePairs2);				
					System.out.println("response2="+ gson2.fromJson(response2,Boolean.class));
					
					// 步骤3：处理JSON数据
					// 步骤3-1：反序列化数据封装成一个对象
					Boolean flag2= gson2.fromJson(response2,Boolean.class);
					 
					if(flag2){
	         		for(int i = 0;i < 100;i++)
							Log.d("TAG", "Reah There");
	         		Toast.makeText(getApplicationContext(), "修改成功!", Toast.LENGTH_LONG).show();
						
					}else{
						Toast.makeText(getApplicationContext(), "修改失败!", Toast.LENGTH_LONG).show();
					}
						break;
				default:
					break;
					
				}
			}
		}
	

}
