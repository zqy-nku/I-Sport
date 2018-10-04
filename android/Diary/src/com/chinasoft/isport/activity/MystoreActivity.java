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

import com.chinasoft.isport.activity.R;
import com.chinasoft.isport.internet.WebAccessUtils;
import com.chinasoft.myproject.po.Sporttreasure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MystoreActivity extends Activity {

	// 步骤1：声明集合对象以及ListView组件对象
	private List<Map<String, ?>> lstData;
	private ListView lstStore;
	// 步骤4：声明该页面中的交互类组件
	private Button btnphoto;
	private Button btndiary;
	private Button btnshuoshuo;
	private Button btninfo;
	private int userid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 扩展：隐藏该窗体的标题栏
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 窗体绑定布局文件
		this.setContentView(R.layout.store_detail);
		//取得sharedpreferene数据
				SharedPreferences preferences = getSharedPreferences("user_data", MODE_WORLD_READABLE);
				String account = preferences.getString("account", "");
				userid = preferences.getInt("userid", 0);
				Toast.makeText(getApplicationContext(), account, Toast.LENGTH_LONG).show();
		//实例化操作类组件
		this.btnphoto=(Button) this.findViewById(R.id.btnphoto);
		this.btndiary=(Button) this.findViewById(R.id.btndiary);
		this.btnshuoshuo=(Button) this.findViewById(R.id.btnshuoshuo);
		this.btninfo=(Button) this.findViewById(R.id.btninfo);
		//组件绑定监听器
		this.btnphoto.setOnClickListener(new ViewOcl());
		this.btndiary.setOnClickListener(new ViewOcl());
		this.btnshuoshuo.setOnClickListener(new ViewOcl());
		this.btninfo.setOnClickListener(new ViewOcl());
		// 步骤2：实例化列表视图组件
		this.lstStore = (ListView) this.findViewById(R.id.lstStore);
		// 步骤3：获取自定义列表组件中的数据
		this.lstData = fetchData();
		// 步骤4：将自定义的布局与获取到的列表数据进行绑定
		SimpleAdapter adapter = new SimpleAdapter(this, this.lstData,
				R.layout.listitem_store, new String[] { "imgUserpho",
						"txtCollectname", "txtCollectcontxt","txtTreasureauthname" }, new int[] {
						R.id.imgUserpho, R.id.txtCollectname, R.id.txtCollectcontxt,R.id.txtTreasureauthname
						});
		// 步骤5：列表组件绑定适配器
		this.lstStore.setAdapter(adapter);

		// 步骤7：将列表视图组件与事件监听器绑定
		this.lstStore.setOnItemClickListener(new ItemOcl());
		this.lstStore.setOnItemLongClickListener(new ItemLongOcl());
	}
	// 步骤6：创建一个自定义的内部类监听器Linstener
		private class ViewOcl implements View.OnClickListener{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
			
				case R.id.btnphoto:
					
						// 3. 响应动作
						Toast.makeText(getApplicationContext(), "欢迎来到相册界面", Toast.LENGTH_LONG).show();
						// 界面跳转
						Intent intent = new Intent();
						intent.setClass(MystoreActivity.this, MyphotoActivity.class);
						startActivity(intent);
					
					
					
					break;
               case R.id.btndiary:
					
					// 3. 响应动作
					Toast.makeText(getApplicationContext(), "欢迎来到日志浏览界面", Toast.LENGTH_LONG).show();
					// 界面跳转
					Intent intent1 = new Intent();
					intent1.setClass(MystoreActivity.this, MydiaryActivity.class);
					startActivity(intent1);
				break;
                case R.id.btnshuoshuo:
					
					// 3. 响应动作
					Toast.makeText(getApplicationContext(), "欢迎来到说说浏览界面", Toast.LENGTH_LONG).show();
					// 界面跳转
					Intent intent2 = new Intent();
					intent2.setClass(MystoreActivity.this, MyshuoshuoActivity.class);
					startActivity(intent2);
				break;
 case R.id.btninfo:
					
					// 3. 响应动作
					Toast.makeText(getApplicationContext(), "欢迎来到资料浏览界面", Toast.LENGTH_LONG).show();
					// 界面跳转
					Intent intent4 = new Intent();
					intent4.setClass(MystoreActivity.this, changeinfo.class);
					startActivity(intent4);
				break;
				default:
					break;
				}
			}
			
		}
	
	// 步骤4：自定义一个获取列表数据的方法
		private List<Map<String, ?>> fetchData() {
			// TODO Auto-generated method stub

			
			 // 步骤4-4：创建并实例化一个Gson对象
			Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();

			Integer userId = new Integer(userid); 
			String user_data=gson.toJson(userId);
			
		     
		
			
			// 步骤4-1：创建一个空集合对象
			List<Map<String, ?>> lst = new ArrayList<Map<String, ?>>();
			
			// 步骤4-2：创建一个列表中选项对象并实例化
			List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
			lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
			
			String response = WebAccessUtils.httpRequest("viewTreasureServlet",lstNameValuePairs);
			
			//步骤4-3：设置一个全新的类型Type
			Type ListMessages = new TypeToken<ArrayList<Sporttreasure>>() {
			}.getType();
			
			
		  
			// 步骤4-5：解析JSon数据
			List<Sporttreasure> lstMydiary =gson.fromJson(response, ListMessages);
			
			//步骤4-6：使用循环遍历集合对象
			for(Sporttreasure Sporttreasure:lstMydiary){
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("mid", Sporttreasure.getTreasid());
				//item.put("txtPublish", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA).format(Sporttreasure.getMdiarytime()));
				item.put("txtCollectname", Sporttreasure.getTreasname());
				item.put("txtCollectcontxt", Sporttreasure.getTreascont());
				item.put("txtTreasureauthname", Sporttreasure.getTreaauthname());
				item.put("imgUserpho", R.drawable.p1);
				//item.put("txtLabel", Sporttreasure.getSportlabel());
				//步骤4-7:将创建好的选项对象添加到集合中
				lst.add(item);
			}
			return lst;	
		}
		
	// 步骤6：自定义列表选项单击事件处理
	private class ItemOcl implements AdapterView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> adapter, View view, int position,
				long arg3) {
			// TODO Auto-generated method stub
			// 步骤6-1：使用该方法的position参数获取选中的选项对象并赋值到Map集合中
			Map<String, ?> selectedItem = lstData.get(position);
			// 测试
			Toast.makeText(getApplicationContext(), "您选中的是编号为:"+selectedItem.get("mid"), Toast.LENGTH_LONG).show();
		}
		
	}
	
	// 步骤7：自定义列表选项长点击事件处理
	private class ItemLongOcl implements AdapterView.OnItemLongClickListener{

		@Override
		public boolean onItemLongClick(AdapterView<?> adapter, View view,
				int position, long arg3) {
			// TODO Auto-generated method stub
			// 步骤7-1：使用该方法的position参数获取选中的选项对象并赋值到Map集合中
			Map<String, ?> selectedItem = lstData.get(position);
			// 测试
			Toast.makeText(getApplicationContext(), "放开我："+selectedItem.get("mid"), Toast.LENGTH_LONG).show();
			return true;
		}
		
	}

}

