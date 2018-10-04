package com.chinasoft.isport.adapter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;




import com.chinasoft.isport.activity.R;
import com.chinasoft.isport.internet.WebAccessUtils;
import com.chinasoft.myproject.po.Actihuo;
import com.chinasoft.myproject.po.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter{

	private LayoutInflater mInflater;
	private List<Map<String, Object>> mData;
	public OnBtnClickListener onBtnClickListener;
	
	public MyBaseAdapter(Context context,List list){
		this.mInflater = LayoutInflater.from(context);
		this.mData = list;
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		final Map<String, Object> map = mData.get(position);
		if(convertView == null){
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.listitem_main, null);
			holder.actiPhoto = (ImageView)convertView.findViewById(R.id.actiPhoto);
			holder.actiNickName = (TextView)convertView.findViewById(R.id.actiNickName);
			holder.actiRank = (TextView)convertView.findViewById(R.id.actiRank);
			holder.actiPublish = (TextView)convertView.findViewById(R.id.actiPublish);
			holder.actiName = (TextView)convertView.findViewById(R.id.actiName);
			holder.actiSport = (TextView)convertView.findViewById(R.id.actiSport);
			holder.actiBegtime = (TextView)convertView.findViewById(R.id.actiBegtime);
			holder.actiEndtime = (TextView)convertView.findViewById(R.id.actiEndtime);
			holder.actiPlace = (TextView)convertView.findViewById(R.id.actiPlace);
			holder.actiCont = (TextView)convertView.findViewById(R.id.actiCont);
			holder.actiUsercount = (TextView)convertView.findViewById(R.id.actiUsercount);
			holder.actiJoin = (Button)convertView.findViewById(R.id.actiJoin);
			holder.actiZan=(Button)convertView.findViewById(R.id.actiZan);
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder)convertView.getTag();
		}
		    int userid=(Integer)map.get("userid");
		    int actiid=(Integer)map.get("actiid");
			String actiNickName = (String)map.get("actiNickName");
			String actiRank = (String)map.get("actiRank");
			String actiPublish = (String)map.get("actiPublish");
			String actiName = (String)map.get("actiName");
			String actiSport = (String)map.get("actiSport");
			String actiBegtime = (String)map.get("actiBegtime");
			String actiEndtime = (String)map.get("actiEndtime");
			String actiPlace = (String)map.get("actiPlace");
			String actiCont = (String)map.get("actiCont");
			String actiUsercount = (String)map.get("actiUsercount");
			
			
			holder.actiPhoto.setBackgroundResource((Integer)map.get("actiPhoto"));
			holder.actiNickName.setText(actiNickName);
			holder.actiRank.setText(actiRank);
			holder.actiPublish.setText(actiPublish);
			holder.actiName.setText(actiName);
			holder.actiSport.setText(actiSport);
			holder.actiBegtime.setText(actiBegtime);
			holder.actiEndtime.setText(actiEndtime);
			holder.actiPlace.setText(actiPlace);
			holder.actiCont.setText(actiCont);
			holder.actiUsercount.setText(actiUsercount);
			//获取整个user的信息
			// 步骤1-3：序列化
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
			String user_data = gson.toJson(userid);
			// 步骤2：设置请求参数集合并调用方法向网络发送请求数据			
			// 步骤2-1：创建一个参数集合
			List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
			lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
			// 步骤2-2：调用方式实现请求的发送
			String response = WebAccessUtils.httpRequest("userInfoServlet", lstNameValuePairs);				
			System.out.println("response="+response);
			// 步骤3：处理JSON数据
		  // 步骤4-5：解析JSon数据
		   User user = gson.fromJson(response, User.class);
           System.out.println("获取到的用户信息是"+user);
		   String zanacti=user.getZanactiid();
		   String joinacti=user.getActiid();
			//joinacti.indexOf(id)>0,参加过。
			
			
			//点赞算法，设置button上显示的文字，判断算法
			if (zanacti.indexOf(actiid)<0) {
				holder.actiZan.setText("力赞");
				holder.actiZan.setOnClickListener(new View.OnClickListener() {
				
					@Override
					public void onClick(View v) {
						onBtnClickListener.OnBtnClick(holder.actiZan, 1, map);
					}
				});
			} else {
				holder.actiZan.setText("消赞");
				holder.actiZan.setOnClickListener(new View.OnClickListener() {
				
					@Override
					public void onClick(View v) {
						onBtnClickListener.OnBtnClick(holder.actiZan, 2, map);
					}
				});
			} 
			//参加 算法，判断按钮上的文字显示
			if (joinacti.indexOf(actiid)<0) {
				holder.actiJoin.setText("同意参加");
				holder.actiJoin.setOnClickListener(new View.OnClickListener() {
				
					@Override
					public void onClick(View v) {
						onBtnClickListener.OnBtnClick(holder.actiJoin, 1, map);
					}
				});
			} else  {
				holder.actiJoin.setText("取消参加");
				holder.actiJoin.setOnClickListener(new View.OnClickListener() {
				
					@Override
					public void onClick(View v) {
						onBtnClickListener.OnBtnClick(holder.actiJoin, 2, map);
					}
				});
			} 
			
			
		return convertView;
	}
	
	public void setOnBtnClickListener(OnBtnClickListener onBtnClickListener) {
		this.onBtnClickListener = onBtnClickListener;
	}

	public interface OnBtnClickListener{
		public void OnBtnClick(View view, int opt, Map<String,Object> map);
	}
	public final class ViewHolder{
		public ImageView actiPhoto;
		public TextView actiNickName,actiRank,actiPublish,actiName;
		public TextView actiSport,actiBegtime,actiEndtime,actiPlace,actiCont,actiUsercount;
		public Button actiZan,actiJoin;
	}
	
}
