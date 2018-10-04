package com.chinasoft.isport.adapter;
import java.util.List;
import java.util.Map;

import com.chinasoft.isport.activity.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyBaseAdapter01 extends BaseAdapter{

	private LayoutInflater mInflater;
	private List<Map<String, Object>> mData;
	public OnClickListener onClickListener;
	public MyBaseAdapter01(Context context,List list){
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
			convertView = mInflater.inflate(R.layout.treasureitem, null);
			holder.sportimg = (ImageView)convertView.findViewById(R.id.sportimg);
			holder.treastitle = (TextView)convertView.findViewById(R.id.TreasTitle);
			holder.treascont = (TextView)convertView.findViewById(R.id.TreasCont);
			holder.treascollect = (TextView)convertView.findViewById(R.id.Treascollect);
			//
			convertView.setTag(holder);
		}else{
			
			holder = (ViewHolder)convertView.getTag();
		}
		    int treasid=(Integer)map.get("treasid");
		    String treastitle = (String)map.get("treastitle");
			String treascont = (String)map.get("treascont");
			String treascollect = (String)map.get("treascollect");
			
			
			holder.sportimg.setBackgroundResource((Integer)map.get("sportimg"));
			holder.treastitle.setText(treastitle);
			holder.treascont.setText(treascont);
			
			//
			holder.treastitle.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					System.out.println("鍦╞aseadapter閲岀偣鍑讳簡鏍囬");
					onClickListener.OnClick(holder.treastitle, 1, map);
				}
			});
			holder.treascollect.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					System.out.println("鍦╞aseadapter閲岀偣鍑讳簡鏀惰棌");
					onClickListener.OnClick(holder.treascollect, 1, map);
				}
			});
			//鑾峰彇鏁翠釜user鐨勪俊鎭�
			//String joinacti=user.get;
			//joinacti.indexOf(id)>0,鍙傚姞杩囥�
			
/*			//鐐硅禐绠楁硶锛岃缃産utton涓婃樉绀虹殑鏂囧瓧锛屽垽鏂畻娉�
			if (actiNickName.equals("1鍙�)) {
				holder.actiZan.setText("鍔涜禐");
				holder.actiZan.setOnClickListener(new View.OnClickListener() {
				
					@Override
					public void onClick(View v) {
						onBtnClickListener.OnBtnClick(holder.actiZan, 1, map);
					}
				});
			} else  {
				holder.actiZan.setText("娑堣禐");
				holder.actiZan.setOnClickListener(new View.OnClickListener() {
				
					@Override
					public void onClick(View v) {
						onBtnClickListener.OnBtnClick(holder.actiZan, 2, map);
					}
				});
			} 
			//鍙傚姞 绠楁硶锛屽垽鏂寜閽笂鐨勬枃瀛楁樉绀�
			if (actiNickName.equals("1鍙�)) {
				holder.actiJoin.setText("鍚屾剰鍙傚姞");
				holder.actiJoin.setOnClickListener(new View.OnClickListener() {
				
					@Override
					public void onClick(View v) {
						onBtnClickListener.OnBtnClick(holder.actiJoin, 1, map);
					}
				});
			} else{
				holder.actiJoin.setText("鍙栨秷鍙傚姞");
				holder.actiJoin.setOnClickListener(new View.OnClickListener() {
				
					@Override
					public void onClick(View v) {
						onBtnClickListener.OnBtnClick(holder.actiJoin, 2, map);
					}
				});
			} */
			
			
		return convertView;
	}
	
	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

	public interface OnClickListener{
		public void OnClick(View view, int opt, Map<String,Object> map);
	}
	public final class ViewHolder{
		public ImageView sportimg;
		public TextView treastitle, treascont, treascollect;
	}

	
}
