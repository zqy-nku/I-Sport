package com.chinasoft.isport.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.chinasoft.isport.internet.WebAccessUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TreasDetailActivity extends Activity {
	
	private TextView txtcollect, treasname, treascont;
	private int  treasid, userid;
	private String usercolletreasid;
	private ImageView sportimg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//鑾峰彇浼犺繃鏉ョ殑鏁版嵁
		Bundle bundle = getIntent().getExtras();
		SerializableMap serializableMap = (SerializableMap) bundle.get("treasure");
		Map<String,  Object> map = serializableMap.getMap();
		//缁戝畾甯冨眬
		this.setContentView(R.layout.treasureitem);
		//瀹炰緥鍖栧弬鏁�
		this.treasname = (TextView) findViewById(R.id.TreasTitle);
		this.treascont = (TextView) findViewById(R.id.TreasCont);
		this.txtcollect = (TextView) findViewById(R.id.Treascollect);
		this.sportimg = (ImageView) findViewById(R.id.sportimg);
		//		//鑾峰緱user鍏叡鏁版嵁
		SharedPreferences preferences = getSharedPreferences("publicData", MODE_WORLD_READABLE);
		this.usercolletreasid = preferences.getString("colletreasid", "");
		this.userid = preferences.getInt("userid", 0);
		//纭畾鏄惁涓烘敹钘�
		this.treasid = (Integer) map.get("treasid");
		if(usercolletreasid.indexOf(treasid)>0){
			txtcollect.setText("取消收藏");
		} else {
			txtcollect.setText("收藏");
		}
		//鏄剧ず鑾峰緱鐨勬暟鎹�
		sportimg.setBackgroundResource((Integer) map.get("sportimg"));
		treasname.setText((CharSequence) map.get("treastitle"));
		treascont.setText((CharSequence) map.get("treascont"));
		//
		this.txtcollect.setOnClickListener(new colleOcl());
	}
	
	class colleOcl implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// 姝ラ1-3锛氬簭鍒楀寲
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
			String userid = gson.toJson(TreasDetailActivity.this.userid);
			String treasid= gson.toJson(TreasDetailActivity.this.treasid);
			// 姝ラ2锛氳缃姹傚弬鏁伴泦鍚堝苟璋冪敤鏂规硶鍚戠綉缁滃彂閫佽姹傛暟鎹�		
			// 姝ラ2-1锛氬垱寤轰竴涓弬鏁伴泦鍚�
			List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
			lstNameValuePairs.add(new BasicNameValuePair("userId", userid));
			lstNameValuePairs.add(new BasicNameValuePair("treasId", treasid));
			if(v.getId() == R.id.Treascollect){
				if(TreasDetailActivity.this.txtcollect.getText().toString().equals("收藏") ){
					// 姝ラ2-2锛氳皟鐢ㄦ柟寮忓疄鐜拌姹傜殑鍙戦�
					String response = WebAccessUtils.httpRequest("AddColleServlet", lstNameValuePairs);				
					System.out.println("response="+response);
					// 姝ラ3锛氬鐞咼SON鏁版嵁
					// 姝ラ3-1锛氬弽搴忓垪鍖栨暟鎹皝瑁呮垚涓�釜瀵硅薄
					boolean flag = gson.fromJson(response, boolean.class);
					//鏍规嵁杩斿洖缁撴灉
					if(flag){
						txtcollect.setText("取消收藏");
					} else {
						Toast.makeText(getApplicationContext(), "出了点错，取消收藏失败了!", Toast.LENGTH_LONG).show();
					}
				} else if(TreasDetailActivity.this.txtcollect.getText().toString().equals("取消收藏") ){
					// 姝ラ2-2锛氳皟鐢ㄦ柟寮忓疄鐜拌姹傜殑鍙戦�
					String response = WebAccessUtils.httpRequest("DelColleServlet", lstNameValuePairs);				
					System.out.println("response="+response);
					// 姝ラ3锛氬鐞咼SON鏁版嵁
					// 姝ラ3-1锛氬弽搴忓垪鍖栨暟鎹皝瑁呮垚涓�釜瀵硅薄
					boolean flag = gson.fromJson(response, boolean.class);
					//鏍规嵁杩斿洖缁撴灉
					if(flag){
						txtcollect.setText("收藏");
					} else {
						Toast.makeText(getApplicationContext(), "出了点错，取消收藏失败了!", Toast.LENGTH_LONG).show();
					}
				}
			}
		}
		
	}
		
}
