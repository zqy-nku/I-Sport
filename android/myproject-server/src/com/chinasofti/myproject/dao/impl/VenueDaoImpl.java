package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IVenueDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Venue;

public class VenueDaoImpl implements IVenueDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	

	public VenueDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Venue venue) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		// 步骤3：拆分对向属性
		String venuename=venue.getVenuename();
		float vencomgrade=venue.getVencomgrade();
		String vencontext=venue.getVencontext();
		String venplace=venue.getVenplace();
		float venprice = venue.getVenprice();
		int vensportid=venue.getVensportid();
		String venimage=venue.getVenimage();
		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into venue values(null,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {venuename, vencomgrade,vencontext,venplace,venprice,vensportid,venimage};
		// 步骤5：使用dbutils方法实现添加操作
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤6：提交事务
		if (affectedRows > 0) {
			// 提交事务
			TransactionManager.commit();
		} else {
			// 回滚事务
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Venue> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Venue> lstVenue= new ArrayList<Venue>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from venue order by venueid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Venue venue=new Venue();
				venue.setVenueid(resultSet.getInt(1));
				venue.setVenuename(resultSet.getString(2));
				venue.setVencomgrade(resultSet.getLong(3));
				venue.setVencontext(resultSet.getString(4));
				venue.setVenplace(resultSet.getString(5));
				venue.setVenprice(resultSet.getFloat(6));
				venue.setVensportid(resultSet.getInt(7));
				venue.setVenimage(resultSet.getString(8));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstVenue.add(venue);
			}
			// 返回结果
			return lstVenue;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);
		}

	}

	@Override
	public int deleteById(int venueid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		// 步骤4：设置添加SQL语句模板
		String strSQL = "delete from venue where venueid=?";
		Object[] params = new Object[] { venueid };
		// 步骤5：使用dbutils方法实现添加操作
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤6：提交事务
		if (affectedRows > 0) {
			// 提交事务
			TransactionManager.commit();
		} else {
			// 回滚事务
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public Venue selectById(int venueid) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		Venue venue=new Venue();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from venue where venueid=?";
		Object[] params = new Object[] {venueid};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				venue.setVenueid(resultSet.getInt(1));
				venue.setVenuename(resultSet.getString(2));
				venue.setVencomgrade(resultSet.getLong(3));
				venue.setVencontext(resultSet.getString(4));
				venue.setVenplace(resultSet.getString(5));
				venue.setVenprice(resultSet.getFloat(6));
				venue.setVensportid(resultSet.getInt(7));
				venue.setVenimage(resultSet.getString(8));
				return venue;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int update(Venue venue) {
		// TODO Auto-generated method stub
		this.conn=this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		//
		int venueid=venue.getVenueid();
		String venuename=venue.getVenuename();
		float vencomgrade=venue.getVencomgrade();
		String vencontext=venue.getVencontext();
		String venplace=venue.getVenplace();
		float venprice = venue.getVenprice();
		int vensportid=venue.getVensportid();
		String venimage=venue.getVenimage();
		//
		String strSQL="update venue set venuename=?,vencomgrade=?,vencontext=?,venplace=?,venprice=?,vensportid=?,venimage=?where venueid=?";
		Object[] params=new Object[]{venuename,vencomgrade,vencontext,venplace,venprice,vensportid,venimage,venueid};
		//
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		if(affectRows > 0){
			// 提交事务
			TransactionManager.commit();
		}else{
			// 回滚事务
			TransactionManager.rollback();
		}
	    return affectRows;
	
	}

	@Override
	public List<Venue> selectByVenuename(String venuename) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
				List<Venue> lstVenue= new ArrayList<Venue>();
				// 步骤2：获取一个数据库的连接对象
				this.conn = connectionManager.openConnection();
				// 步骤3：创建查询语句的模板
				String strSQL = "select * from venue where venuename=?";
				// 步骤4：使用dbutils方法实现查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {venuename});
				// 步骤5：将resultSet结果集转换成List数据结构
				try {
					while (resultSet.next()) {
						// 步骤5-1：创建一个Customers对象
						Venue venue=new Venue();
						venue.setVenueid(resultSet.getInt(1));
						venue.setVenuename(resultSet.getString(2));
						venue.setVencomgrade(resultSet.getLong(3));
						venue.setVencontext(resultSet.getString(4));
						venue.setVenplace(resultSet.getString(5));
						venue.setVenprice(resultSet.getFloat(6));
						venue.setVensportid(resultSet.getInt(7));
						venue.setVenimage(resultSet.getString(8));
						// 步骤5-2：将封装好的对象添加到List集合中
						lstVenue.add(venue);
					}
					// 返回结果
					return lstVenue;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 步骤6：关闭数据库连接
					this.connectionManager.closeConnection(conn);
				}
	}

	@Override
	public List<Venue> sortByVenPrice(List<Venue> lstVenue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venue> sortByVencomgrade(List<Venue> lstVenue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venue> selectByVensportid(int vensportid) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Venue> lstVenue= new ArrayList<Venue>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from venue where vensportid=?";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {vensportid});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Venue venue=new Venue();
				venue.setVenueid(resultSet.getInt(1));
				venue.setVenuename(resultSet.getString(2));
				venue.setVencomgrade(resultSet.getLong(3));
				venue.setVencontext(resultSet.getString(4));
				venue.setVenplace(resultSet.getString(5));
				venue.setVenprice(resultSet.getFloat(6));
				venue.setVensportid(resultSet.getInt(7));
				venue.setVenimage(resultSet.getString(8));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstVenue.add(venue);
			}
			// 返回结果
			return lstVenue;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);
		}
	}

}
