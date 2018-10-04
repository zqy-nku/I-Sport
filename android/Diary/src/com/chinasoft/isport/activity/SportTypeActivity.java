package com.chinasoft.isport.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

public class SportTypeActivity extends Activity {
	private EditText sporttype;
	private Button searchsporttype;
	private ImageView[] images;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//
		//requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		this.setContentView(R.layout.sporttype);
	   // getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.treastitle);
	  //
	    this.sporttype = (EditText) findViewById(R.id.searchsport);
	    this.searchsporttype = (Button) findViewById(R.id.btnsearchsport);
		images = new ImageView[3];
		images[0] = (ImageView) findViewById(R.id.football);
		images[1] = (ImageView) findViewById(R.id.golf);
		images[2] = (ImageView) findViewById(R.id.tennis);
		for(int i=0; i<3; i++){
			images[i].setOnClickListener(new MyImgOcl());
		}
	}
	
		private class MyImgOcl implements View.OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
			switch (v.getId()) {
			case R.id.football:
				Toast.makeText(getApplicationContext(), "足球", Toast.LENGTH_LONG).show();
				intent.setClass(SportTypeActivity.this, TreasureActivity.class);
				intent.putExtra("sportid", 1);
				startActivity(intent);
				break;
			case R.id.golf:
				break;
			case R.id.tennis:
				break;
			default:
				break;
			}
			}
			
		}
}
