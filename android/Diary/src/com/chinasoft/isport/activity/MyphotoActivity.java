package com.chinasoft.isport.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import com.chinasoft.isport.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MyphotoActivity extends Activity {
	
	// ����1���������϶����Լ�ListView�������
	private List<Map<String, ?>> lstData;
	private ListView lstPhoto;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ��չ�����ظô���ı�����
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    this.setContentView(R.layout.photo_main);
	 // ����2��ʵ�����б���ͼ���
	    this.lstPhoto=(ListView) this.findViewById(R.id.lstPhoto);
	 // ����3����ȡ�Զ����б�����е�����
	 		this.lstData = fetchData();
	 // ����4�����Զ���Ĳ������ȡ�����б����ݽ��а�
	 		SimpleAdapter adapter = new SimpleAdapter(this, this.lstData,
	 				R.layout.listphoto_main, new String[] { "txtPublishtime",
	 						"txtPublishtype", "imgPhoto_1", "imgPhoto_2","imgPhoto_3","imgPhoto_4","imgPhoto_5","imgPhoto_6", }, new int[] {
	 						R.id.txtPublishtime, R.id.txtPublishtype, R.id.imgPhoto_1,
	 						R.id.imgPhoto_2,R.id.imgPhoto_3,R.id.imgPhoto_4,R.id.imgPhoto_5,R.id.imgPhoto_6 });
	 	// ����5���б������������
			this.lstPhoto.setAdapter(adapter);

			// ����7�����б���ͼ������¼���������
			this.lstPhoto.setOnItemClickListener(new ItemOcl());
			this.lstPhoto.setOnItemLongClickListener(new ItemLongOcl());
	}
	private List<Map<String, ?>> fetchData() {
		// TODO Auto-generated method stub
		// ����4-1������һ���ռ��϶���
				List<Map<String, ?>> lst = new ArrayList<Map<String, ?>>();
				// ����4-2������һ���б���ѡ�����ʵ����
				Map<String, Object> item01 = new HashMap<String, Object>();
				item01.put("mid", 1);
				item01.put("txtPublishtime", "2014-08-21 10:08");
				item01.put("txtPublishtype", "�ֻ����");
//				item01.put("imgPhoto_1",R.drawable.p2 );
//				item01.put("imgPhoto_2",R.drawable.p3 );
//				item01.put("imgPhoto_3",R.drawable.p4 );
//				item01.put("imgPhoto_4",R.drawable.p5 );
//				item01.put("imgPhoto_5",R.drawable.p6);
				item01.put("imgPhoto_6",R.drawable.more );
				
				Map<String, Object> item02 = new HashMap<String, Object>();
				item02.put("mid", 2);
				item02.put("txtPublishtime", "2014-08-21 10:08");
				item02.put("txtPublishtype", "�ֻ����");
//				item02.put("imgPhoto_1",R.drawable.p2 );
//				item02.put("imgPhoto_2",R.drawable.p3 );
//				item02.put("imgPhoto_3",R.drawable.p4 );
//				item02.put("imgPhoto_4",R.drawable.p5 );
//				item02.put("imgPhoto_5",R.drawable.p6);
				item02.put("imgPhoto_6",R.drawable.more );
				
				Map<String, Object> item03 = new HashMap<String, Object>();
				item03.put("mid", 3);
				item03.put("txtPublishtime", "2014-08-21 10:08");
				item03.put("txtPublishtype", "�ֻ����");
//				item03.put("imgPhoto_1",R.drawable.p2 );
//				item03.put("imgPhoto_2",R.drawable.p3 );
//				item03.put("imgPhoto_3",R.drawable.p4 );
//				item03.put("imgPhoto_4",R.drawable.p5 );
//				item03.put("imgPhoto_5",R.drawable.p6);
				item03.put("imgPhoto_6",R.drawable.more );
				
				
				Map<String, Object> item04 = new HashMap<String, Object>();
				item04.put("mid", 4);
				item04.put("txtPublishtime", "2014-08-21 10:08");
				item04.put("txtPublishtype", "�ֻ����");
//				item04.put("imgPhoto_1",R.drawable.p2 );
//				item04.put("imgPhoto_2",R.drawable.p3 );
//				item04.put("imgPhoto_3",R.drawable.p4 );
//				item04.put("imgPhoto_4",R.drawable.p5 );
//				item04.put("imgPhoto_5",R.drawable.p6);
				item04.put("imgPhoto_6",R.drawable.more );
				
				
				Map<String, Object> item05 = new HashMap<String, Object>();
				item05.put("mid", 5);
				item05.put("txtPublishtime", "2014-08-21 10:08");
				item05.put("txtPublishtype", "�ֻ����");
				item05.put("imgPhoto_1",R.drawable.p2 );
//				item05.put("imgPhoto_2",R.drawable.p3 );
//				item05.put("imgPhoto_3",R.drawable.p4 );
//				item05.put("imgPhoto_4",R.drawable.p5 );
//				item05.put("imgPhoto_5",R.drawable.p6);
				item05.put("imgPhoto_6",R.drawable.more );
				
				
				Map<String, Object> item06 = new HashMap<String, Object>();
				item06.put("mid", 6);
				item06.put("txtPublishtime", "2014-08-21 10:08");
				item06.put("txtPublishtype", "�ֻ����");
				item06.put("imgPhoto_1",R.drawable.p2 );
//				item06.put("imgPhoto_2",R.drawable.p3 );
//				item06.put("imgPhoto_3",R.drawable.p4 );
//				item06.put("imgPhoto_4",R.drawable.p5 );
//				item06.put("imgPhoto_5",R.drawable.p6);
				item06.put("imgPhoto_6",R.drawable.more );
				// ����4-3���������õ�ѡ�������ӵ�������
				lst.add(item01);
				lst.add(item02);
				lst.add(item03);
				lst.add(item04);
				lst.add(item05);
				lst.add(item06);
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
