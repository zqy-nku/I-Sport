package com.chinasoft.isport.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.chinasoft.isport.internet.WebAccessUtils;
import com.chinasoft.myproject.po.Person;
import com.chinasoft.myproject.po.Peruser;
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
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class LoginActivity extends Activity {

	private EditText txtAccount, txtPassword;
	private Button btnReg, btnLogin;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 鐢变簬璁块棶浜掕仈缃戯紝鍥犳灏嗙綉缁滆闂斁鍏ュ埌瀛愮嚎绋嬩腑杩涜
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		//
		super.onCreate(savedInstanceState);
		//
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.activity_login);
		//
		this.txtAccount = (EditText) this.findViewById(R.id.txtAccount);
		this.txtPassword = (EditText) this.findViewById(R.id.txtPassword);
		this.btnReg = (Button) this.findViewById(R.id.btnReg);
		this.btnLogin = (Button) this.findViewById(R.id.btnLogin);
		//缁戝畾鐩戝惉鍣�
		this.btnReg.setOnClickListener(new ViewOcl());
		this.btnLogin.setOnClickListener(new ViewOcl());
		//鑾峰彇鍏叡鏁版嵁
		SharedPreferences preferences = getSharedPreferences("publicData", MODE_WORLD_READABLE);
		String eml = preferences.getString("account", "");
		this.txtAccount.setText(eml);
	}

	private class ViewOcl implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			switch (v.getId()) {
			case R.id.btnReg:
				intent.setClass(LoginActivity.this, RegActivity.class);
				startActivity(intent);
				break;
			case R.id.btnLogin:
				// 鍏堥獙璇侀潪绌�
				if (checkForm()) {
					// 鑾峰彇鏁版嵁
					String getaccount = txtAccount.getText().toString().trim();
					String getpassword = txtPassword.getText().toString()
							.trim();
					// 姝ラ1-2锛氬璞″皝瑁�
					Person person = new Person();
					person.setAccount(getaccount);
					person.setPassword(getpassword);
					// 姝ラ1-3锛氬簭鍒楀寲
					Gson gson = new GsonBuilder().setDateFormat(
							"yyyy-MM-dd hh:mm:ss").create();
					String user_data = gson.toJson(person);
					System.out.println("user_data=" + user_data);
					// 姝ラ2锛氳缃姹傚弬鏁伴泦鍚堝苟璋冪敤鏂规硶鍚戠綉缁滃彂閫佽姹傛暟鎹�

					// 姝ラ2-1锛氬垱寤轰竴涓弬鏁伴泦鍚�
					List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
					lstNameValuePairs.add(new BasicNameValuePair("user_data",
							user_data));

					// 姝ラ2-2锛氳皟鐢ㄦ柟寮忓疄鐜拌姹傜殑鍙戦�
					String response = WebAccessUtils.httpRequest(
							"loginServlet", lstNameValuePairs);
					System.out.println("response=" + response);
					// 姝ラ3锛氬鐞咼SON鏁版嵁
					// 姝ラ3-1锛氬弽搴忓垪鍖栨暟鎹皝瑁呮垚涓�釜瀵硅薄
					Peruser p = gson.fromJson(response, Peruser.class);
					System.out.println("p=" + p);
					if (p != null) {
						// 璁插叕鍏变俊鎭斁鍏�
						@SuppressWarnings("deprecation")
						SharedPreferences.Editor editor = getSharedPreferences(
								"publicData", MODE_WORLD_WRITEABLE).edit();
						editor.putInt("userid", p.getUserid());
						editor.putString("colletreasid", p.getColletreasid());
						editor.commit();
						intent.setClass(LoginActivity.this,MyActivityGroupDemo.class);
						startActivity(intent);
					} else {
						Toast.makeText(getApplicationContext(), "璐﹀彿鎴栧瘑鐮侀敊璇�",
								Toast.LENGTH_LONG).show();
					}
				}
				break;
			default:
				break;
			}
		}

	}
		boolean checkForm(){
			if(this.txtAccount.getText() == null || this.txtAccount.getText().length() == 0)
			{
				Toast.makeText(getApplicationContext(), "璐﹀彿娌″～鍝︼紒浜�", Toast.LENGTH_LONG).show();
				return false;
			}else if(this.txtPassword.getText().toString() == null || this.txtPassword.getText().toString().length() == 0)
			{
				Toast.makeText(getApplicationContext(), "娌″啓瀵嗙爜鍢烇紒", Toast.LENGTH_LONG).show();
				return false;
			} else {
				return true;
			}
		}
}
