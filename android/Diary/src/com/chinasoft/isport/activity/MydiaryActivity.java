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

import com.chinasoft.isport.internet.WebAccessUtils;
import com.chinasoft.myproject.po.VDiary;
import com.chinasoft.isport.activity.R;

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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MydiaryActivity extends Activity {

	// ����1���������϶����Լ�ListView�������
	private List<Map<String, ?>> lstData;
	private ListView lstDiary;
	// ����4��������ҳ���еĽ��������
	private Button btnphoto;
	private Button btndiary;
	private Button btnshuoshuo;
	private Button btnstore;
	private Button btninfo;
	private Button btnfriend;
	private int userid;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ��չ�����ظô���ı�����
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
		// ����󶨲����ļ�
		this.setContentView(R.layout.diary_detail);
		//ȡ��sharedpreferene����
		SharedPreferences preferences = getSharedPreferences("user_data", MODE_WORLD_READABLE);
		String account = preferences.getString("account", "");
		userid = preferences.getInt("userid", 0);
		Toast.makeText(getApplicationContext(), account, Toast.LENGTH_LONG).show();
		//ʵ�������������
				this.btnphoto=(Button) this.findViewById(R.id.btnphoto);
				this.btndiary=(Button) this.findViewById(R.id.btndiary);
				this.btnshuoshuo=(Button) this.findViewById(R.id.btnshuoshuo);
				this.btnstore=(Button) this.findViewById(R.id.btnstore);
				this.btninfo=(Button) this.findViewById(R.id.btninfo);
				this.btnfriend=(Button) this.findViewById(R.id.btnfriend);
				//����󶨼�����
				this.btnphoto.setOnClickListener(new ViewOcl());
				this.btndiary.setOnClickListener(new ViewOcl());
				this.btnshuoshuo.setOnClickListener(new ViewOcl());
				this.btnstore.setOnClickListener(new ViewOcl());
				this.btninfo.setOnClickListener(new ViewOcl());
				this.btnfriend.setOnClickListener(new ViewOcl());
				
		// ����2��ʵ�����б���ͼ���
				
		this.lstDiary = (ListView) this.findViewById(R.id.lstDiary);
		// ����3����ȡ�Զ����б�����е�����
		this.lstData = fetchData();
		// ����4�����Զ���Ĳ������ȡ�����б����ݽ��а�
		SimpleAdapter adapter = new SimpleAdapter(this, this.lstData,
				R.layout.listitem_diary, new String[] { "imgPhoto",
						"txtTitle", "txtPublish", "txtMessage","txtNickName","txtLabel" }, new int[] {
						R.id.imgPhoto, R.id.txtTitle, R.id.txtPublish,
						R.id.txtMessage,R.id.txtNickname,R.id.txtLabel });
		// ����5���б������������
		this.lstDiary.setAdapter(adapter);

		// ����7�����б���ͼ������¼���������
		this.lstDiary.setOnItemClickListener(new ItemOcl());
		this.lstDiary.setOnItemLongClickListener(new ItemLongOcl());
	}
	// ����6������һ���Զ�����ڲ��������Linstener
		private class ViewOcl implements View.OnClickListener{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
			
				case R.id.btnphoto:
					
					// 3. ��Ӧ����
					Toast.makeText(getApplicationContext(), "��ӭ����������", Toast.LENGTH_LONG).show();
					// ������ת
					Intent intent = new Intent();
					intent.setClass(MydiaryActivity.this, WriteDiaryActivity.class);
					startActivity(intent);
	break;
			case R.id.btndiary:
				
				// 3. ��Ӧ����
				Toast.makeText(getApplicationContext(), "��ӭ������־�������", Toast.LENGTH_LONG).show();
				// ������ת
				Intent intent1 = new Intent();
				intent1.setClass(MydiaryActivity.this, MydiaryActivity.class);
				startActivity(intent1);
			break;
            case R.id.btnshuoshuo:
				
				// 3. ��Ӧ����
				Toast.makeText(getApplicationContext(), "��ӭ����˵˵�������", Toast.LENGTH_LONG).show();
				// ������ת
				Intent intent2 = new Intent();
				intent2.setClass(MydiaryActivity.this, MyshuoshuoActivity.class);
				startActivity(intent2);
			break;
            case R.id.btnstore:
				
				// 3. ��Ӧ����
				Toast.makeText(getApplicationContext(), "��ӭ�����ղ��������", Toast.LENGTH_LONG).show();
				// ������ת
				Intent intent3 = new Intent();
				intent3.setClass(MydiaryActivity.this, MystoreActivity.class);
				startActivity(intent3);
			break;
            case R.id.btninfo:
				
				// 3. ��Ӧ����
				Toast.makeText(getApplicationContext(), "��ӭ���������������", Toast.LENGTH_LONG).show();
				// ������ת
				Intent intent4 = new Intent();
				intent4.setClass(MydiaryActivity.this, changeinfo.class);
				startActivity(intent4);
			break;
           case R.id.btnfriend:
				
				// 3. ��Ӧ����
				Toast.makeText(getApplicationContext(), "��ӭ�������ѹ������", Toast.LENGTH_LONG).show();
				// ������ת
				Intent intent5 = new Intent();
				intent5.setClass(MydiaryActivity.this, WriteShuoshuoActivity.class);
				startActivity(intent5);
			break;
				default:
					break;
				}
			}
			
		}
	
	// ����4���Զ���һ����ȡ�б����ݵķ���
	private List<Map<String, ?>> fetchData() {
		// TODO Auto-generated method stub

		
		 // ����4-4��������ʵ����һ��Gson����
		Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();

		Integer userId = new Integer(userid); 
		String user_data=gson.toJson(userId);
		
	     
	
		
		// ����4-1������һ���ռ��϶���
		List<Map<String, ?>> lst = new ArrayList<Map<String, ?>>();
		
		// ����4-2������һ���б���ѡ�����ʵ����
		List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
		lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
		
		String response = WebAccessUtils.httpRequest("viewDiaryServlet",lstNameValuePairs);
		
		//����4-3������һ��ȫ�µ�����Type
		Type ListMessages = new TypeToken<ArrayList<VDiary>>() {
		}.getType();
		
		
	  
		// ����4-5������JSon����
		List<VDiary> lstMydiary =gson.fromJson(response, ListMessages);
		
		//����4-6��ʹ��ѭ���������϶���
		for(VDiary vdiary:lstMydiary){
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("mid", vdiary.getMdiaryid());
			item.put("txtPublish", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA).format(vdiary.getMdiarytime()));
			item.put("txtMessage", vdiary.getMdiarycont());
			item.put("txtTitle", vdiary.getMdiaryname());
			//item.put("txtLabel", vdiary.getSportlabel());
			//����4-7:�������õ�ѡ�������ӵ�������
			lst.add(item);
		}
		return lst;	
	}
	
	// ����6���Զ����б�ѡ����¼�����
	private class ItemOcl implements AdapterView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> adapter, View view, int position,
				long arg3) {
			// TODO Auto-generated method stub
			// ����6-1��ʹ�ø÷�����position������ȡѡ�е�ѡ����󲢸�ֵ��Map������
			Map<String, ?> selectedItem = lstData.get(position);
			// ����
			Toast.makeText(getApplicationContext(), "��ѡ�е��Ǳ��Ϊ:"+selectedItem.get("mid"), Toast.LENGTH_LONG).show();
		}
		
	}
	
	// ����7���Զ����б�ѡ�����¼�����
	private class ItemLongOcl implements AdapterView.OnItemLongClickListener{

		@Override
		public boolean onItemLongClick(AdapterView<?> adapter, View view,
				int position, long arg3) {
			// TODO Auto-generated method stub
			// ����7-1��ʹ�ø÷�����position������ȡѡ�е�ѡ����󲢸�ֵ��Map������
			Map<String, ?> selectedItem = lstData.get(position);
			// ����
			Toast.makeText(getApplicationContext(), "�ſ��ң�"+selectedItem.get("mid"), Toast.LENGTH_LONG).show();
			return true;
		}
		
	}

}
