package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinasofti.myproject.dao.IPublishstatusDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Publishstatus;

public class PublishstatusDaoImpl implements IPublishstatusDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	public PublishstatusDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	
	public int insertPublishstatus(final Publishstatus publishstatus){
		// 姝ラ1锛氳幏鍙栦竴涓暟鎹簱杩炴帴瀵硅薄
				this.conn = this.connectionManager.openConnection();
				// 姝ラ2锛氬紑鍚竴涓簨鍔�
				com.chinasofti.myproject.db.TransactionManager.conn = this.conn;
				com.chinasofti.myproject.db.TransactionManager.beginTransaction();
				// 姝ラ3锛氭媶鍒嗗鍚戝睘鎬�
				int userid = publishstatus.getUserid();
				int followid = publishstatus.getFollowid();
				String stacontext = publishstatus.getStacontext();
				int staviewcount = publishstatus.getStaviewcount();
				int starepcount = publishstatus.getStarepcount();
				int stapracount = publishstatus.getStapracount();
				String staresid = publishstatus.getStaresid();
				Date stapubtime = publishstatus.getStapubtime();
				int stastatus = publishstatus.getStastatus();
				
				// 姝ラ4锛氳缃坊鍔燬QL璇彞妯℃澘
				String strSQL = "insert into publishstatus values(null,?,?,?,?,?,?,?,?,?)";
				Object[] params = new Object[] { userid, followid, stacontext,staviewcount,starepcount,stapracount,staresid,stapubtime,stastatus };
				
				// 姝ラ5锛氫娇鐢╠butils鏂规硶瀹炵幇娣诲姞鎿嶄綔
				int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
				
				// 姝ラ6锛氭彁浜や簨鍔�
				if (affectedRows > 0) {
					// 鎻愪氦浜嬪姟
					TransactionManager.commit();
				} else {
					// 鍥炴粴浜嬪姟
					TransactionManager.rollback();
				}
				return affectedRows;
	}
	//鍒犻櫎鏁版嵁閮ㄥ垎
			public int deletePublishstatusById(int staid) {
				// TODO Auto-generated method stub
				// 姝ラ1锛氳幏鍙栦竴涓暟鎹簱杩炴帴瀵硅薄
				this.conn = this.connectionManager.openConnection();
				// 姝ラ2锛氬紑鍚簨鍔�
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				// 姝ラ3锛氬垱寤篠QL璇彞妯℃澘
				String strSQL = "delete from publishstatus where staid=?";
				Object[] params = new Object[] { staid };
				// 姝ラ4锛氳皟鐢╠butils涓殑鏂规硶瀹屾垚瀵规暟鎹簱鐨勫垹闄ゆ搷浣�
				int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
				// 姝ラ5锛氭牴鎹楠�鐨勬搷浣滅粨鏋滄彁浜ゆ垨鍥炴粴浜嬪姟
				if (affectedRwos > 0) {
					TransactionManager.commit(); // 浜嬪姟鎻愪氦
				} else {
					TransactionManager.rollback(); // 浜嬪姟鐨勫洖婊�
				}
				// 姝ラ6锛氳繑鍥炲奖鍝嶈鏁�
				return affectedRwos;
			}
			//鏌ヨ鏁版嵁
			public Publishstatus selectPublishstatusById(int staid) {
				// TODO Auto-generated method stub
				// 姝ラ1锛氳幏鍙栦竴涓暟鎹簱杩炴帴瀵硅薄
				this.conn = this.connectionManager.openConnection();
				// 姝ラ2锛氬垱寤篠QL璇彞妯℃澘
				String strSQL = "select * from publishstatus where staid=?";
				Object[] params = new Object[] { staid };
				// 姝ラ4锛氳皟鐢╠butils涓殑鏂规硶瀹屾垚瀵规暟鎹簱鐨勬煡璇㈡搷浣�
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
				// 姝ラ5锛氳幏鍙栫粨鏋滈泦鍚堝苟灏佽鎴愪竴涓璞�
				try {
					if (resultSet.next()) {
						// 姝ラ6锛氬垱寤轰竴涓狿ublishstatus瀵硅薄
						Publishstatus publishstatus = new Publishstatus();
						publishstatus.setStaid(resultSet.getInt(1));
						publishstatus.setUserid(resultSet.getInt(2));
						publishstatus.setFollowid(resultSet.getInt(3));
						publishstatus.setStacontext(resultSet.getString(4));
						publishstatus.setStaviewcount(resultSet.getInt(5));
						publishstatus.setStarepcount(resultSet.getInt(6));
						publishstatus.setStapracount(resultSet.getInt(7));
						publishstatus.setStaresid(resultSet.getString(8));
						publishstatus.setStapubtime(resultSet.getDate(9));
						publishstatus.setStastatus(resultSet.getInt(10));
						
						// 姝ラ7锛氳繑鍥炲璞�
						return publishstatus;
					} else {
						return null;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					this.connectionManager.closeConnection(conn);
				}
			}
			//鏇存柊鏁版嵁
			public int updatePublishstatus(Publishstatus publishstatus) {
				// TODO Auto-generated method stub
				// 姝ラ1锛氳幏鍙栦竴涓暟鎹簱杩炴帴瀵硅薄
				this.conn = this.connectionManager.openConnection();
				// 姝ラ2锛氬紑鍚簨鍔�
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				// 姝ラ3锛氬垱寤篠QL璇彞妯℃澘
				String strSQL = "update publishstatus set userid=?, followid=?, stacontext=?,staviewcount=?,starepcount=?,stapracount=?,staresid=?,stapubtime=?,stastatus=? where staid=?";
				Object[] params = new Object[] { publishstatus.getUserid(), publishstatus.getFollowid(),publishstatus.getStacontext(),publishstatus.getStaviewcount(),publishstatus.getStarepcount(),publishstatus.getStapracount(),publishstatus.getStaresid(),publishstatus.getStapubtime(),publishstatus.getStastatus(),publishstatus.getStaid() };
				// 姝ラ4锛氳皟鐢╠butils涓殑鏂规硶瀹屾垚瀵规暟鎹簱鐨勫垹闄ゆ搷浣�
				int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
				// 姝ラ5锛氭牴鎹楠�鐨勬搷浣滅粨鏋滄彁浜ゆ垨鍥炴粴浜嬪姟
				if (affectedRwos > 0) {
					TransactionManager.commit(); // 浜嬪姟鎻愪氦
				} else {
					TransactionManager.rollback(); // 浜嬪姟鐨勫洖婊�
				}
				// 姝ラ6锛氳繑鍥炲奖鍝嶈鏁�
				return affectedRwos;
			}
			//鏌ヨ鍏ㄩ儴
			public List<Publishstatus> selectAllPublishstatus() {
				// TODO Auto-generated method stub
				// 姝ラ1锛氬垱寤轰竴涓┖鐨勯泦鍚堝噯澶囧瓨鏀炬煡璇㈢殑缁撴灉
				List<Publishstatus> lstPublishstatus = new ArrayList<Publishstatus>();
				// 姝ラ2锛氳幏鍙栦竴涓暟鎹簱鐨勮繛鎺ュ璞�
				this.conn = connectionManager.openConnection();
				// 姝ラ3锛氬垱寤烘煡璇㈣鍙ョ殑妯℃澘
				String strSQL = "select * from publishstatus order by staid";
				// 姝ラ4锛氫娇鐢╠butils鏂规硶瀹炵幇鏌ヨ鎿嶄綔
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
						new Object[] {});
				// 姝ラ5锛氬皢resultSet缁撴灉闆嗚浆鎹㈡垚List鏁版嵁缁撴瀯
				try {
					while (resultSet.next()) {
						// 姝ラ5-1锛氬垱寤轰竴涓狿ublishstatus瀵硅薄
						Publishstatus publishstatus = new Publishstatus();
						publishstatus.setStaid(resultSet.getInt(1));
						publishstatus.setUserid(resultSet.getInt(2));
						publishstatus.setFollowid(resultSet.getInt(3));
						publishstatus.setStacontext(resultSet.getString(4));
						publishstatus.setStaviewcount(resultSet.getInt(5));
						publishstatus.setStarepcount(resultSet.getInt(6));
						publishstatus.setStapracount(resultSet.getInt(7));
						publishstatus.setStaresid(resultSet.getString(8));
						publishstatus.setStapubtime(resultSet.getDate(9));
						publishstatus.setStastatus(resultSet.getInt(10));
						// 姝ラ5-2锛氬皢灏佽濂界殑瀵硅薄娣诲姞鍒癓ist闆嗗悎涓�
						lstPublishstatus.add(publishstatus);
					}
					// 杩斿洖缁撴灉
					return lstPublishstatus;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 姝ラ6锛氬叧闂暟鎹簱杩炴帴
					this.connectionManager.closeConnection(conn);
				}
			}

			@Override
			public List<Publishstatus> selectByUserid(int userid) {
				// TODO Auto-generated method stub
				// 姝ラ1锛氬垱寤轰竴涓┖鐨勯泦鍚堝噯澶囧瓨鏀炬煡璇㈢殑缁撴灉
				List<Publishstatus> lstPublishstatus = new ArrayList<Publishstatus>();
				// 姝ラ2锛氳幏鍙栦竴涓暟鎹簱鐨勮繛鎺ュ璞�
				this.conn = connectionManager.openConnection();
				// 姝ラ3锛氬垱寤烘煡璇㈣鍙ョ殑妯℃澘
				String strSQL = "select * from publishstatus where userid=?";
				Object[] params=new Object[] {userid};
				// 姝ラ4锛氫娇鐢╠butils鏂规硶瀹炵幇鏌ヨ鎿嶄綔
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
						params);
				// 姝ラ5锛氬皢resultSet缁撴灉闆嗚浆鎹㈡垚List鏁版嵁缁撴瀯
				try {
					while (resultSet.next()) {
						// 姝ラ5-1锛氬垱寤轰竴涓狿ublishstatus瀵硅薄
						Publishstatus publishstatus = new Publishstatus();
						publishstatus.setStaid(resultSet.getInt(1));
						publishstatus.setUserid(resultSet.getInt(2));
						publishstatus.setFollowid(resultSet.getInt(3));
						publishstatus.setStacontext(resultSet.getString(4));
						publishstatus.setStaviewcount(resultSet.getInt(5));
						publishstatus.setStarepcount(resultSet.getInt(6));
						publishstatus.setStapracount(resultSet.getInt(7));
						publishstatus.setStaresid(resultSet.getString(8));
						publishstatus.setStapubtime(resultSet.getDate(9));
						publishstatus.setStastatus(resultSet.getInt(10));
						// 姝ラ5-2锛氬皢灏佽濂界殑瀵硅薄娣诲姞鍒癓ist闆嗗悎涓�
						lstPublishstatus.add(publishstatus);
					}
					// 杩斿洖缁撴灉
					return lstPublishstatus;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 姝ラ6锛氬叧闂暟鎹簱杩炴帴
					this.connectionManager.closeConnection(conn);
				}
			}
}
