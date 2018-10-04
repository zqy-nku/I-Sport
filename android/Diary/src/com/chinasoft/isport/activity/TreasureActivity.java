package com.chinasoft.isport.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.chinasoft.isport.adapter.MyBaseAdapter01;
import com.chinasoft.isport.adapter.MyBaseAdapter01.OnClickListener;
import com.chinasoft.isport.internet.WebAccessUtils;
import com.chinasoft.myproject.po.Sporttreasure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;







import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class TreasureActivity extends ListActivity {
	// 澹版槑闆嗗悎瀵硅薄浠ュ強ListView缁勪欢瀵硅薄
	private List<Map<String, ?>> lstTreasure;
	private SearchView searchView;
	private ListView listView;
	private TextView txtcollect, treasname;
	private int sportid, userid;
	private String usercolletreasid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 缁戝畾绐楀彛甯冨眬
		//requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		this.setContentView(R.layout.treasure);	
		getListView();
	    //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.treastitle);
		//鑾峰緱user鍏叡鏁版嵁
		SharedPreferences preferences = getSharedPreferences("publicData", MODE_WORLD_READABLE);
		this.usercolletreasid = preferences.getString("colletreasid", "");
		this.userid = preferences.getInt("userid", 0);
		//鑾峰緱浼犲叆鐨刬ntent
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		sportid = bundle.getInt("sportid");
		Toast.makeText(getApplicationContext(), "sportid="+sportid, Toast.LENGTH_LONG).show();
		
		// 瀹炰緥鍖栧璞�
		// this.searchView = (SearchView) findViewById(R.id.textSearchTreas);
		//this.listView = (ListView) findViewById(R.id.listTreas);
		this.txtcollect = (TextView) findViewById(R.id.Treascollect);
		this.treasname = (TextView) findViewById(R.id.TreasTitle);
		// 鍙栧緱鏁版嵁
		this.lstTreasure = fetchTreas();
		
		// 甯冨眬涓庢暟鎹垪琛ㄧ粦瀹�
		//璁剧疆閫傞厤鍣�
		MyBaseAdapter01 mba = new MyBaseAdapter01(this, lstTreasure);
		setListAdapter(mba);
	/*	SimpleAdapter simpleAdapter = new SimpleAdapter(this, lstTreasure,
				R.layout.treasureitem, new String[] { "sportimg", "treasname",
						"treascont" }, new int[] { R.id.sportimg,
						R.id.TreasTitle, R.id.TreasCont });
		
		// 鍒楄〃缁勪欢缁戝畾閫傞厤鍣�
		this.listView.setAdapter(simpleAdapter);
		
		// 鍒楄〃璇曞浘缁勪欢涓庝簨浠剁洃鍚櫒缁戝畾
	//	this.txtcollect.setOnClickListener(new collectOcl());
		this.listView.setOnItemClickListener(new TreasOcl());
		this.listView.setOnItemLongClickListener(new TreasOlcl());*/
		mba.setOnClickListener(new OnClickListener() {
			
			public void OnClick(View view, int opt, Map<String, Object> map) {
				// TODO Auto-generated method stub
				int treasId = (Integer)map.get("treasid");
				String treastitle = (String)map.get("treastitle");
				//
				System.out.println("treasid====="+treasId);
				System.out.println("treastitle====="+treastitle);
				// 姝ラ1-3锛氬簭鍒楀寲
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
				String userid = gson.toJson(TreasureActivity.this.userid);
				String treasid= gson.toJson(treasId);
				// 姝ラ2锛氳缃姹傚弬鏁伴泦鍚堝苟璋冪敤鏂规硶鍚戠綉缁滃彂閫佽姹傛暟鎹�		
				// 姝ラ2-1锛氬垱寤轰竴涓弬鏁伴泦鍚�
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("userId", userid));
				lstNameValuePairs.add(new BasicNameValuePair("treasId", treasid));
				//鐢ㄦ潵璺宠浆椤甸潰鐨刬ntent
				Intent treasintent = new Intent();
				switch (view.getId()){
				case R.id.TreasTitle:
					//
					System.out.println("鍦╝ctivity閲岀偣鍑讳簡鏍囬");
					//Toast.makeText(getApplicationContext(), "鐐瑰嚮浜嗘爣棰�", Toast.LENGTH_LONG).show();
					treasintent.setClass(TreasureActivity.this, TreasDetailActivity.class);
					//鑷畾涔夌殑鎺ュ彛绫荤敤浜庤map
					SerializableMap serializableMap = new SerializableMap();
					serializableMap.setMap(map);
					Bundle trebundle  = new Bundle();
					//璁瞞ap浼犺緭鍒板彟涓�釜activity
					trebundle.putSerializable("treasure", serializableMap);
					treasintent.putExtras(trebundle);
					startActivity(treasintent);
					break;
				case R.id.Treascollect:
					System.out.println("鍦╝ctivity閲岀偣鍑讳簡鏀惰棌");
					//Toast.makeText(getApplicationContext(), "鐐瑰嚮鏀惰棌", Toast.LENGTH_LONG).show();
					TextView Txtcolle = (TextView) view;
					//TreasureActivity.this.txtcollect.getText().toString();////
					System.out.println(Txtcolle.getText().toString());
					if(Txtcolle.getText().toString().equals("收藏") ){
						// 姝ラ2-2锛氳皟鐢ㄦ柟寮忓疄鐜拌姹傜殑鍙戦�
						String response = WebAccessUtils.httpRequest("AddColleServlet", lstNameValuePairs);				
						System.out.println("response="+response);
						// 姝ラ3锛氬鐞咼SON鏁版嵁
						// 姝ラ3-1锛氬弽搴忓垪鍖栨暟鎹皝瑁呮垚涓�釜瀵硅薄
						boolean flag = gson.fromJson(response, boolean.class);
						//鏍规嵁杩斿洖缁撴灉
						if(flag){
							Txtcolle.setText("取消收藏");
						} else {
							Toast.makeText(getApplicationContext(), "出了点错，收藏失败了!", Toast.LENGTH_LONG).show();
						}
					} else if(Txtcolle.getText().toString().equals("取消收藏") ){
						// 姝ラ2-2锛氳皟鐢ㄦ柟寮忓疄鐜拌姹傜殑鍙戦�
						String response = WebAccessUtils.httpRequest("DelColleServlet", lstNameValuePairs);				
						System.out.println("response="+response);
						// 姝ラ3锛氬鐞咼SON鏁版嵁
						// 姝ラ3-1锛氬弽搴忓垪鍖栨暟鎹皝瑁呮垚涓�釜瀵硅薄
						boolean flag = gson.fromJson(response, boolean.class);
						//鏍规嵁杩斿洖缁撴灉
						if(flag){
							Txtcolle.setText("收藏");
						} else {
							Toast.makeText(getApplicationContext(), "出了点错，取消收藏失败了!!", Toast.LENGTH_LONG).show();
						}
					}
					break;
					default:
						break;
				}
			}
		});

	}

	// 鑷畾涔夊彇寰楁暟鎹殑鏂规硶
	@SuppressLint("UseValueOf")
	private List<Map<String, ?>> fetchTreas() {
		// 鍒涘缓绌哄垪琛ㄩ泦鍚�
		List<Map<String, ?>> lstTreas = new ArrayList<Map<String, ?>>();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
		Integer Sportid  = new Integer(sportid);
		String sportid = gson.toJson(Sportid);

		// 姝ラ2锛氳缃姹傚弬鏁伴泦鍚堝苟璋冪敤鏂规硶鍚戠綉缁滃彂閫佽姹傛暟鎹�		
		
		// 姝ラ2-1锛氬垱寤轰竴涓弬鏁伴泦鍚�
		List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
		lstNameValuePairs.add(new BasicNameValuePair("sportid", sportid));
		
		// 姝ラ2-2锛氳皟鐢ㄦ柟寮忓疄鐜拌姹傜殑鍙戦�
		String response = WebAccessUtils.httpRequest("SelectTreasureServlet", lstNameValuePairs);	
		
		// 姝ラ4-3锛氳缃竴涓叏鏂扮殑绫诲瀷Type
		Type ListTreasure = new TypeToken<ArrayList<Sporttreasure>>() {
		}.getType();
		
		// 姝ラ4-5锛氳В鏋怞Son鏁版嵁
		List<Sporttreasure> lstTreasure = gson.fromJson(response, ListTreasure);
		
		System.out.println(lstTreasure);
		// 姝ラ4-6锛氫娇鐢ㄥ惊鐜亶鍘嗛泦鍚堝璞�
		for (Sporttreasure treasure : lstTreasure) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("treasid", treasure.getTreasid());
			System.out.println("treasure.getTreasid() = ="+treasure.getTreasid());
			// 鏍规嵁杩愬姩绉嶇被閫夋嫨鍥炬爣
			switch (treasure.getSportid()) {
			case 1:
				item.put("sportimg", R.drawable.football1);
				break;
			case 2:
				item.put("sportimg", R.drawable.golf1);
				break;
			case 3:
				item.put("sportimg", R.drawable.tennis1);
				break;
			default:
				break;
			}
			//item.put("sportimg", R.drawable.logo1);
			item.put("treastitle", treasure.getTreasname());
			item.put("treascont", treasure.getTreascont());
			//鏍规嵁user宸叉敹钘弔reasid鏉ユ樉绀烘敹钘弔rxtview鐨勫�
			if(TreasureActivity.this.usercolletreasid.indexOf(treasure.getTreasid())>0 ){
				item.put("treascollect", "取消收藏");
			} else {
				item.put("treascollect", "收藏");		
			}
			// 姝ラ4-7锛氬皢鍒涘缓濂界殑閫夐」瀵硅薄娣诲姞鍒伴泦鍚堜腑
			lstTreas.add(item);			
		}
		return lstTreas;
	}

	private class TreasOcl implements AdapterView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int position,
				long arg3) {
			// TODO Auto-generated method stub
			Map<String, ?> selectItem = lstTreasure.get(position);
			//Toast.makeText(getApplicationContext(),
					//"鐐瑰嚮缂栧彿涓猴細" + selectItem.get("treasid"), Toast.LENGTH_LONG).show();
		}
	}

	private class TreasOlcl implements AdapterView.OnItemLongClickListener {
		@Override
		public boolean onItemLongClick(AdapterView<?> arg0,
				android.view.View view, int position, long arg3) {
			// TODO Auto-generated method stub
			Map<String, ?> selectItem = lstTreasure.get(position);
			Toast.makeText(getApplicationContext(), "闀跨偣鍑荤紪鍙蜂负:" + selectItem.get("treasid"),
					Toast.LENGTH_LONG);
			return true;
		}

	}

	//
	/*private class collectOcl implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.Treascollect:
			TextView txtcolle = (TextView) findViewById(R.id.Treascollect);
			if(txtcolle.getText().equals("鏀惰棌")){
				txtcolle.setText("鍙栨秷鏀惰棌");
			}
				else{
					txtcolle.setText("鏀惰棌");
				}

			}
		}
		
	}*/
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// TODO Auto-generated method stub
//		//鍔ㄦ�寮曞叆璇enu鑿滃崟鐨勫竷灞�枃浠�
//		MenuInflater inflater = getMenuInflater();
//		//浣跨敤inflater涓殑inflate鏂规硶閿佸畾甯冨眬鏂囦欢
//		inflater.inflate(R.menu.treasback1, menu);
//		return true;
//	}
	//瀹炵幇閫夐」鍗曞嚮浜嬩欢锛岄噸鍐欑埗绫绘柟娉昽nOptionsItemSelected()

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// TODO Auto-generated method stub
//		switch (item.getItemId()) {
//		case R.id.treasback1:
//			Intent intent = new Intent();
//			intent.setClass(TreasureActivity.this, LoginActivity.class);
//			startActivity(intent);
//			//
//			finish();
//			break;
//		default:
//			break;
//		}
//		return true;
//	}
	
}
