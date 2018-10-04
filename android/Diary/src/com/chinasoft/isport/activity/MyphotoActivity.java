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
	
	// 步骤1：声明集合对象以及ListView组件对象
	private List<Map<String, ?>> lstData;
	private ListView lstPhoto;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 扩展：隐藏该窗体的标题栏
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    this.setContentView(R.layout.photo_main);
	 // 步骤2：实例化列表视图组件
	    this.lstPhoto=(ListView) this.findViewById(R.id.lstPhoto);
	 // 步骤3：获取自定义列表组件中的数据
	 		this.lstData = fetchData();
	 // 步骤4：将自定义的布局与获取到的列表数据进行绑定
	 		SimpleAdapter adapter = new SimpleAdapter(this, this.lstData,
	 				R.layout.listphoto_main, new String[] { "txtPublishtime",
	 						"txtPublishtype", "imgPhoto_1", "imgPhoto_2","imgPhoto_3","imgPhoto_4","imgPhoto_5","imgPhoto_6", }, new int[] {
	 						R.id.txtPublishtime, R.id.txtPublishtype, R.id.imgPhoto_1,
	 						R.id.imgPhoto_2,R.id.imgPhoto_3,R.id.imgPhoto_4,R.id.imgPhoto_5,R.id.imgPhoto_6 });
	 	// 步骤5：列表组件绑定适配器
			this.lstPhoto.setAdapter(adapter);

			// 步骤7：将列表视图组件与事件监听器绑定
			this.lstPhoto.setOnItemClickListener(new ItemOcl());
			this.lstPhoto.setOnItemLongClickListener(new ItemLongOcl());
	}
	private List<Map<String, ?>> fetchData() {
		// TODO Auto-generated method stub
		// 步骤4-1：创建一个空集合对象
				List<Map<String, ?>> lst = new ArrayList<Map<String, ?>>();
				// 步骤4-2：创建一个列表中选项对象并实例化
				Map<String, Object> item01 = new HashMap<String, Object>();
				item01.put("mid", 1);
				item01.put("txtPublishtime", "2014-08-21 10:08");
				item01.put("txtPublishtype", "手机相册");
//				item01.put("imgPhoto_1",R.drawable.p2 );
//				item01.put("imgPhoto_2",R.drawable.p3 );
//				item01.put("imgPhoto_3",R.drawable.p4 );
//				item01.put("imgPhoto_4",R.drawable.p5 );
//				item01.put("imgPhoto_5",R.drawable.p6);
				item01.put("imgPhoto_6",R.drawable.more );
				
				Map<String, Object> item02 = new HashMap<String, Object>();
				item02.put("mid", 2);
				item02.put("txtPublishtime", "2014-08-21 10:08");
				item02.put("txtPublishtype", "手机相册");
//				item02.put("imgPhoto_1",R.drawable.p2 );
//				item02.put("imgPhoto_2",R.drawable.p3 );
//				item02.put("imgPhoto_3",R.drawable.p4 );
//				item02.put("imgPhoto_4",R.drawable.p5 );
//				item02.put("imgPhoto_5",R.drawable.p6);
				item02.put("imgPhoto_6",R.drawable.more );
				
				Map<String, Object> item03 = new HashMap<String, Object>();
				item03.put("mid", 3);
				item03.put("txtPublishtime", "2014-08-21 10:08");
				item03.put("txtPublishtype", "手机相册");
//				item03.put("imgPhoto_1",R.drawable.p2 );
//				item03.put("imgPhoto_2",R.drawable.p3 );
//				item03.put("imgPhoto_3",R.drawable.p4 );
//				item03.put("imgPhoto_4",R.drawable.p5 );
//				item03.put("imgPhoto_5",R.drawable.p6);
				item03.put("imgPhoto_6",R.drawable.more );
				
				
				Map<String, Object> item04 = new HashMap<String, Object>();
				item04.put("mid", 4);
				item04.put("txtPublishtime", "2014-08-21 10:08");
				item04.put("txtPublishtype", "手机相册");
//				item04.put("imgPhoto_1",R.drawable.p2 );
//				item04.put("imgPhoto_2",R.drawable.p3 );
//				item04.put("imgPhoto_3",R.drawable.p4 );
//				item04.put("imgPhoto_4",R.drawable.p5 );
//				item04.put("imgPhoto_5",R.drawable.p6);
				item04.put("imgPhoto_6",R.drawable.more );
				
				
				Map<String, Object> item05 = new HashMap<String, Object>();
				item05.put("mid", 5);
				item05.put("txtPublishtime", "2014-08-21 10:08");
				item05.put("txtPublishtype", "手机相册");
				item05.put("imgPhoto_1",R.drawable.p2 );
//				item05.put("imgPhoto_2",R.drawable.p3 );
//				item05.put("imgPhoto_3",R.drawable.p4 );
//				item05.put("imgPhoto_4",R.drawable.p5 );
//				item05.put("imgPhoto_5",R.drawable.p6);
				item05.put("imgPhoto_6",R.drawable.more );
				
				
				Map<String, Object> item06 = new HashMap<String, Object>();
				item06.put("mid", 6);
				item06.put("txtPublishtime", "2014-08-21 10:08");
				item06.put("txtPublishtype", "手机相册");
				item06.put("imgPhoto_1",R.drawable.p2 );
//				item06.put("imgPhoto_2",R.drawable.p3 );
//				item06.put("imgPhoto_3",R.drawable.p4 );
//				item06.put("imgPhoto_4",R.drawable.p5 );
//				item06.put("imgPhoto_5",R.drawable.p6);
				item06.put("imgPhoto_6",R.drawable.more );
				// 步骤4-3：将创建好的选项对象添加到集合中
				lst.add(item01);
				lst.add(item02);
				lst.add(item03);
				lst.add(item04);
				lst.add(item05);
				lst.add(item06);
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
