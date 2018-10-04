package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinasofti.myproject.dao.IVenuecommentDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Venuecomment;

public class VenuecommentDaoImpl implements IVenuecommentDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	

	public VenuecommentDaoImpl() {
		super();
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Venuecomment> selectAllVenuecomment() {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		List<Venuecomment> lstVenuecomment = new ArrayList<Venuecomment>();
		String strSQL = "select * from venuecomment";
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[]{});
		// 获取查询结果
		try {
			while (resultSet.next()) {
				Venuecomment venuecomment = new Venuecomment();
				venuecomment.setVencomid(resultSet.getInt(1));
				venuecomment.setVenueid(resultSet.getInt(2));
				venuecomment.setUserid(resultSet.getInt(3));
				venuecomment.setVencomcont(resultSet.getString(4));
				venuecomment.setVencomstar(resultSet.getInt(5));
				venuecomment.setVencomresid(resultSet.getString(6));
				venuecomment.setVencomtime(resultSet.getDate(7));
				lstVenuecomment.add(venuecomment);

			}
			return lstVenuecomment;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public Venuecomment selectVenuecommentById(int vencomid) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		String strSQL = "select * from venuecomment where vencomid=?";
		Object[] params = new Object[] { vencomid };
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		// 获取查询结果
		try {
			if (resultSet.next()) {
				Venuecomment venuecomment = new Venuecomment();
				venuecomment.setVencomid(resultSet.getInt(1));
				venuecomment.setVenueid(resultSet.getInt(2));
				venuecomment.setUserid(resultSet.getInt(3));
				venuecomment.setVencomcont(resultSet.getString(4));
				venuecomment.setVencomstar(resultSet.getInt(5));
				venuecomment.setVencomresid(resultSet.getString(6));
				venuecomment.setVencomtime(resultSet.getDate(7));
				return venuecomment;

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
	public int deleteVenuecommentById(int vencomid) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		String strSQL = "delete from venuecomment where vencomid=?";
		Object[] params = new Object[] { vencomid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int updateVenuecomment(Venuecomment venuecomment) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();
		// 拆分属性
		int vencomid = venuecomment.getVencomid();
		int venueid = venuecomment.getVenueid();
		int userid = venuecomment.getUserid();
		String vencomcont = venuecomment.getVencomcont();
		int vencomstar = venuecomment.getVencomstar();
		String vencomresid = venuecomment.getVencomresid();
		Date vencomtime = venuecomment.getVencomtime();

		String strSQL = "update message set venueid=?,userid=?,vencomcont=?,vencomstar=?,vencomresid=?,vencomtime=? where vencomid=?";
		Object[] params = new Object[] { venueid, userid, vencomcont,
				vencomstar, vencomresid, vencomtime, vencomid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int insertVenuecomment(Venuecomment venuecomment) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();
		// 拆分属性
		//int vencomid = venuecomment.getVencomid();
		int venueid = venuecomment.getVenueid();
		int userid = venuecomment.getUserid();
		String vencomcont = venuecomment.getVencomcont();
		int vencomstar = venuecomment.getVencomstar();
		String vencomresid = venuecomment.getVencomresid();
		Date vencomtime = venuecomment.getVencomtime();

		String strSQL = "insert into  venuecomment value(null,?,?,?,?,?,?)";
		Object[] params = new Object[] { venueid, userid, vencomcont,
				vencomstar, vencomresid, vencomtime };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Venuecomment> selectByVenueid(int venueid) {
		// TODO Auto-generated method stub
		// 获取链接对象
				Connection conn = this.connectionManager.openConnection();
				TransactionManager.conn = conn;
				// 开始事务管理
				TransactionManager.beginTransaction();

				List<Venuecomment> lstVenuecomment = new ArrayList<Venuecomment>();
				String strSQL = "select * from venuecomment where venueid=?";
				ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[]{venueid});
				// 获取查询结果
				try {
					while (resultSet.next()) {
						Venuecomment venuecomment = new Venuecomment();
						venuecomment.setVencomid(resultSet.getInt(1));
						venuecomment.setVenueid(resultSet.getInt(2));
						venuecomment.setUserid(resultSet.getInt(3));
						venuecomment.setVencomcont(resultSet.getString(4));
						venuecomment.setVencomstar(resultSet.getInt(5));
						venuecomment.setVencomresid(resultSet.getString(6));
						venuecomment.setVencomtime(resultSet.getDate(7));
						lstVenuecomment.add(venuecomment);

					}
					return lstVenuecomment;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					this.connectionManager.closeConnection(conn);
				}
	}

}
