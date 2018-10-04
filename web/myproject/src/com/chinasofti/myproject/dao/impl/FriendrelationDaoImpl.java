package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IFriendrelationDao;
import com.chinasofti.myproject.po.Friendrelation;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;

public class FriendrelationDaoImpl implements IFriendrelationDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	public FriendrelationDaoImpl() {
		super();
		this.connectionManager = new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

	@Override
	public int insertFriendrelation(Friendrelation friendrelation) {
		// TODO Auto-generated method stub
		System.out.println(friendrelation.toString());
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//拆分传入的对象
		int userid = friendrelation.getUserid();
		int fid = friendrelation.getFid();
		System.out.println(userid+fid);
		//SQL语句
		String strSQL = "insert into friendrelation values(null,?,?)";
		System.out.println("hehhe");
		Object[] params = new Object[]{userid,fid};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		System.out.println(affectedRows);
		if(affectedRows>0) {
			TransactionManager.commit();
		} else{
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int updateFriendrelation(Friendrelation friendrelation) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//拆分传入的对象
		int relatid = friendrelation.getRelatid();
		int userid = friendrelation.getUserid();
		int fid = friendrelation.getFid();
		//SQL语句
		String strSQL = "update friendrelation set userid=?,fid=? where relatid=?";
		Object[] params = new Object[]{userid,fid,relatid};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectedRows>0) {
			TransactionManager.commit();
		} else{
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Friendrelation> selectAllFrienndrelation() {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//SQL语句
		String strSQL = "select * from friendrelation order by relatid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		//
		List<Friendrelation> lstFriendrelation = new ArrayList<Friendrelation>();
		try {
			while(resultSet.next()) {
				Friendrelation friendrelation = new Friendrelation();
				friendrelation.setRelatid(resultSet.getInt(1));
				friendrelation.setUserid(resultSet.getInt(2));
				friendrelation.setFid(resultSet.getInt(3));
				//返回输出
				lstFriendrelation.add(friendrelation);
			}
			return lstFriendrelation;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public Friendrelation selectFriendrelationById(int relatid) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//SQL语句
		String strSQL = "select * from friendrelation where relatid=?";
		Object[] params = new Object[]{relatid};
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()) {
				Friendrelation friendrelation = new Friendrelation();
				friendrelation.setRelatid(resultSet.getInt(1));
				friendrelation.setUserid(resultSet.getInt(2));
				friendrelation.setFid(resultSet.getInt(3));
				//返回输出
				return friendrelation;
			} else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);
		}

	}

	@Override
	public int deleteFriendrelationById(int relatid) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//SQL语句
		String strSQL = "delete from friendrelation where relatid=?";
		Object[] params = new Object[]{relatid};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectedRows>0) {
			TransactionManager.commit();
		} else{
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Friendrelation> selectByUserid(int userid) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//SQL语句
		String strSQL = "select * from friendrelation where userid=?";
		Object[] params=new Object[]{userid};
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		//
		List<Friendrelation> lstFriendrelation = new ArrayList<Friendrelation>();
		try {
			while(resultSet.next()) {
				Friendrelation friendrelation = new Friendrelation();
				friendrelation.setRelatid(resultSet.getInt(1));
				friendrelation.setUserid(resultSet.getInt(2));
				friendrelation.setFid(resultSet.getInt(3));
				//返回输出
				lstFriendrelation.add(friendrelation);
			}
			return lstFriendrelation;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	
	@Override
	public int deleteRelationByUserid(int uid, int fid) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//SQL语句
		String strSQL = "delete from friendrelation where userid =? and fid =?";
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, new Object[]{uid,fid});
		
		if(affectedRows>0) {
			TransactionManager.commit();
		} else{
			TransactionManager.rollback();
		}
		return affectedRows;
	}

}
