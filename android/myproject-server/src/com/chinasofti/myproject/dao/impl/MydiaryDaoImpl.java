package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinasofti.myproject.dao.IMydiaryDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.po.Mydiary;
import com.chinasofti.myproject.db.TransactionManager;

public class MydiaryDaoImpl implements IMydiaryDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;

	public MydiaryDaoImpl() {
		super();
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Mydiary> selectAllMydiary() {
		// TODO Auto-generated method stub
		
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		
		TransactionManager.beginTransaction();

		List<Mydiary> lstMydiary = new ArrayList<Mydiary>();
		String strSQL = "select * from mydiary order by mdiaryid";
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while (resultSet.next()) {
				Mydiary mydiary = new Mydiary();
				mydiary.setMdiaryid(resultSet.getInt(1));
				mydiary.setUserid(resultSet.getInt(2));
				mydiary.setMdiarytime(resultSet.getDate(3));
				mydiary.setMdiaryname(resultSet.getString(4));
				mydiary.setMdiarycont(resultSet.getString(5));
				mydiary.setMdiarystatus(resultSet.getInt(6));
				mydiary.setMdiaryresid(resultSet.getString(7));
				lstMydiary.add(mydiary);

			}
			return lstMydiary;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public Mydiary selectMydiaryById(int mdiaryid) {
		// TODO Auto-generated method stub
		
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
	
		TransactionManager.beginTransaction();

		String strSQL = "select * from mydiary where mdiaryid=?";
		Object[] params = new Object[] { mdiaryid };
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				Mydiary mydiary = new Mydiary();
				mydiary.setMdiaryid(resultSet.getInt(1));
				mydiary.setUserid(resultSet.getInt(2));
				mydiary.setMdiarytime(resultSet.getDate(3));
				mydiary.setMdiaryname(resultSet.getString(4));
				mydiary.setMdiarycont(resultSet.getString(5));
				mydiary.setMdiarystatus(resultSet.getInt(6));
				mydiary.setMdiaryresid(resultSet.getString(7));
				return mydiary;

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

	@Override
	public int deleteMydiaryById(int mdiaryid) {
		// TODO Auto-generated method stub
		
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		
		TransactionManager.beginTransaction();

		String strSQL = "delete from mydiary where mdiaryid=?";
		Object[] params = new Object[] { mdiaryid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int updateMydiary(Mydiary mydiary) {
		// TODO Auto-generated method stub
		
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
	
		TransactionManager.beginTransaction();
		
		int mydiaryid = mydiary.getMdiaryid();
		int userid = mydiary.getUserid();
		Date mdiarytime = mydiary.getMdiarytime();
		String mdiaryname = mydiary.getMdiaryname();
		String mdiarycont = mydiary.getMdiarycont();
		int mdiarystatus = mydiary.getMdiarystatus();
		String mdiaryresid = mydiary.getMdiaryresid();

		String strSQL = "update mydiary set userid=?,mdiarytime=?,mdiaryname=?,mdiarycont=?,mdiarystatus=?,mdiaryresid=? where mydiaryid=?";
		Object[] params = new Object[] { userid, mdiarytime, mdiaryname,
				mdiarycont, mdiarystatus, mdiaryresid, mydiaryid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int insertMydiary(Mydiary mydiary) {
		// TODO Auto-generated method stub
		
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		
		TransactionManager.beginTransaction();
		
		int userid = mydiary.getUserid();
		Date mdiarytime = mydiary.getMdiarytime();
		String mdiaryname = mydiary.getMdiaryname();
		String mdiarycont = mydiary.getMdiarycont();
		int mdiarystatus = mydiary.getMdiarystatus();
		String mdiaryresid = mydiary.getMdiaryresid();

		String strSQL = "insert into mydiary values(null,?,?,?,?,?,?)";
		Object[] params = new Object[] { userid, mdiarytime, mdiaryname,
				mdiarycont, mdiarystatus, mdiaryresid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Mydiary> selectByUserid(int userid) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		
		TransactionManager.beginTransaction();

		List<Mydiary> lstMydiary = new ArrayList<Mydiary>();
		String strSQL = "select * from mydiary where userid=?";
		Object[] params=new Object[]{userid};
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL,params );
		
		try {
			while (resultSet.next()) {
				Mydiary mydiary = new Mydiary();
				mydiary.setMdiaryid(resultSet.getInt(1));
				mydiary.setUserid(resultSet.getInt(2));
				mydiary.setMdiarytime(resultSet.getDate(3));
				mydiary.setMdiaryname(resultSet.getString(4));
				mydiary.setMdiarycont(resultSet.getString(5));
				mydiary.setMdiarystatus(resultSet.getInt(6));
				mydiary.setMdiaryresid(resultSet.getString(7));
				lstMydiary.add(mydiary);

			}
			return lstMydiary;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

}
