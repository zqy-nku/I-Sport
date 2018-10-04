package com.chinasoft.isport.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.chinasoft.isport.internet.WebAccessUtils;
import com.chinasoft.myproject.po.Person;
import com.chinasoft.myproject.po.Peruser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends Activity {

	private static Spinner spinPro, spinCity;
	@SuppressWarnings("rawtypes")
	static ArrayAdapter adapterPro, adapterCity;
	private Button regButton;
	private TextView txtregprotocal;
	private EditText txtaccount, txtnickname, txtpassword, txtrepsw;
	private RadioGroup radiogender;
	private CheckBox agreerule;
	//
	private String Gender = "男生", Province, City;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_reg);
		//瀹炰緥鍖�
		this.txtaccount = (EditText) findViewById(R.id.eml);
		this.txtnickname = (EditText) findViewById(R.id.nickname);
		this.txtpassword = (EditText) findViewById(R.id.password);
		this.txtrepsw = (EditText) findViewById(R.id.repassword);
		
		this.agreerule = (CheckBox) findViewById(R.id.agreerule);
		radiogender = (RadioGroup) findViewById(R.id.radiogender);
		//鎬у埆radio缁戝畾鐩戝惉鍣�
		radiogender.setOnCheckedChangeListener(new radioOcl());
		//
		agreerule = (CheckBox) findViewById(R.id.agreerule);
		//
		regButton = (Button) findViewById(R.id.btnRegister);
		regButton.setOnClickListener(new RegButtonListener());
		spinPro = (Spinner) findViewById(R.id.province);
		spinPro.setPrompt("璇烽�鎷�");
		spinCity = (Spinner) findViewById(R.id.city);
		spinCity.setPrompt("璇烽�鎷�");
		System.out.println(R.array.province);
			//
		adapterPro = ArrayAdapter.createFromResource(this, R.array.province,
				R.layout.spinner);
		adapterPro
				.setDropDownViewResource(R.layout.spinner_item);
		spinPro.setAdapter(adapterPro);
		spinPro.setOnItemSelectedListener(new SpinnerXMLSelectedListener());
		spinPro.setVisibility(View.VISIBLE);
	
		
	}

	class RegButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			// 闈炵┖鍒ゆ柇
			if (checkForm()) {
				String account = txtaccount.getText().toString();
				String nickname = txtnickname.getText().toString();
				String password = txtpassword.getText().toString();
				//
				Person person = new Person();
				person.setAccount(account);
				person.setNickname(nickname);
				person.setPassword(password);
				person.setRegaddr(RegActivity.this.Province + RegActivity.this.City);
				person.setReggender(RegActivity.this.Gender);
				person.setRegtime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss",
						Locale.CHINA).format(new Date()));
				//
				// 姝ラ1-3锛氬簭鍒楀寲
				Gson gson = new GsonBuilder().setDateFormat(
						"yyyy-MM-dd hh:mm:ss").create();
				String regperson = gson.toJson(person);
				System.out.println("regperson=" + regperson);
				// 姝ラ2锛氳缃姹傚弬鏁伴泦鍚堝苟璋冪敤鏂规硶鍚戠綉缁滃彂閫佽姹傛暟鎹�

				// 姝ラ2-1锛氬垱寤轰竴涓弬鏁伴泦鍚�
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("regperson",
						regperson));

				// 姝ラ2-2锛氳皟鐢ㄦ柟寮忓疄鐜拌姹傜殑鍙戦�
				String response = WebAccessUtils.httpRequest("RegisterServlet",
						lstNameValuePairs);
				System.out.println("response=" + response);
				// 姝ラ3锛氬鐞咼SON鏁版嵁
				// 姝ラ3-1锛氬弽搴忓垪鍖栨暟鎹皝瑁呮垚涓�釜瀵硅薄
				int flag = gson.fromJson(response, int.class);
				System.out.println("flag=" + flag);
				if (flag == 1) {
					//
					Toast.makeText(getApplicationContext(), "娉ㄥ唽鎴愬姛鍠�",
							Toast.LENGTH_LONG).show();
					// 璁插叕鍏变俊鎭斁鍏�
					@SuppressWarnings("deprecation")
					SharedPreferences.Editor editor = getSharedPreferences(
							"publicData", MODE_WORLD_WRITEABLE).edit();
					editor.putString("account", account);
					editor.commit();
					//
					Intent intent = new Intent();
					intent.setClass(RegActivity.this, LoginActivity.class);
					startActivity(intent);
				} else if (flag == -1) {
					Toast.makeText(getApplicationContext(), "閭鐢ㄨ繃浜�",
							Toast.LENGTH_LONG).show();
				} else if (flag == -2) {
					Toast.makeText(getApplicationContext(), "鏄电О鐢ㄨ繃浜�",
							Toast.LENGTH_LONG).show();
				}
			}
		}

	}
	
	//闈炵┖楠岃瘉鍑芥暟
	boolean checkForm(){
		if(txtaccount.getText().toString() == null || txtaccount.getText().toString().length() == 0 ){
			Toast.makeText(getApplicationContext(), "閭涓嶈兘涓虹┖锛�",Toast.LENGTH_LONG).show();
			return false;
		} else if(txtnickname.getText().toString() == null || txtnickname.getText().toString().length() == 0 ){
			Toast.makeText(getApplicationContext(), "瑕佷釜鏄电О鍚�",Toast.LENGTH_LONG).show();
			return false;
		}else if(txtpassword.getText().toString() == null || txtpassword.getText().toString().length() == 0 ){
			Toast.makeText(getApplicationContext(), "娌″瘑鐮佹�琛�",Toast.LENGTH_LONG).show();
			return false;
		}else if(!txtrepsw.getText().toString().equals(txtpassword.getText().toString()) ){
			Toast.makeText(getApplicationContext(), "涓ゆ瀵嗙爜灞呯劧涓嶄竴鑷�",Toast.LENGTH_LONG).show();
			return false;
		}else if(!agreerule.isChecked() ){
			Toast.makeText(getApplicationContext(), "涓嶅悓鎰忔潯娆惧悧",Toast.LENGTH_LONG).show();
			return false;
		} else{
			return true;
		}
		
	}
	
	
	class SpinnerXMLSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// adapterCity=ArrayAdapter.createFromResource(this,
			// R.array.class.getResource(ProCityMap.get(arg2)),
			// R.layout.spinner);

			switch (arg2) {
			case 0:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.beijing,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 1:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.tianjin,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 2:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.diaoyudao,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 3:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.chongqing,
						R.layout.spinner);
				adapterCity 
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 4:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.shanghai,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 5:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.hebei,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 6:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.shanxi,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 7:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.liaoning,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 8:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.jilin,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 9:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.heilongjiang,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 10:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.jiangsu,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 11:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.zhejiang,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 12:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.anhui,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 13:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.fujian,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 14:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.jiangxi,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 15:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.shandong,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 16:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.henan,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 17:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.hubei,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 18:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.hunan,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 19:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.guangdong,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 20:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.hainan,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 21:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.sichuan,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 22:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.guizhou,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 23:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.yunnan,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 24:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.sanxi,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 25:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.gansu,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 26:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.qinghai,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 27:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.taiwan,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 28:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.neimenggu,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 29:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.guangxi,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 30:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.xizang,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 31:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.ningxia,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 32:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.xinjiang,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 33:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.xianggang,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 34:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.aomen,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			case 35:
				adapterCity = ArrayAdapter.createFromResource(
						getApplicationContext(), R.array.riben,
						R.layout.spinner);
				adapterCity
						.setDropDownViewResource(R.layout.spinner_item);
				break;
			default:
				Toast.makeText(getApplicationContext(), "浣犻�鎷╀簡nothing锛侊紒Bitch !",
						Toast.LENGTH_LONG).show();
				break;
			}
			spinCity.setAdapter(adapterCity);
			spinCity.setOnItemSelectedListener(new SpinnerSelectedListener());
			spinPro.setOnItemSelectedListener(new SpinnerSelectedListener());
			spinCity.setVisibility(View.VISIBLE);

		}

		public void onNothingSelected(AdapterView<?> arg0) {

		}

	}

	class SpinnerSelectedListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			RegActivity.this.Province = (String) adapterPro.getItem(arg2);
			RegActivity.this.City = (String) adapterCity.getItem(arg2);
			return ;
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
		
	}
	
	class radioOcl implements RadioGroup.OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			int radiobtnId = arg0.getCheckedRadioButtonId();
			if (radiobtnId == R.id.femal) {
				RegActivity.this.Gender = "女生";
			} else {
				RegActivity.this.Gender = "男生";
			}
		}
	}
}
