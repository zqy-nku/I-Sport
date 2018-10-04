package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IActivityDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.po.Actihuo;
import com.chinasofti.myproject.po.Dailytips;

public class ActivityDaoImpl implements IActivityDao {
  
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	
	public ActivityDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	@Override
	
	public List<Actihuo> selectAll() {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Actihuo> lstActi = new ArrayList<Actihuo>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from actihuo order by actiid desc";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Actihuo activity=new Actihuo();
				activity.setActiid(resultSet.getInt(1));
				activity.setActiname(resultSet.getString(2));
				activity.setUserid(resultSet.getInt(3));
				activity.setNickname(resultSet.getString(4));
				activity.setUserpho(resultSet.getString(5));
				activity.setRank(resultSet.getInt(6));
				activity.setSportid(resultSet.getInt(7));
				activity.setSportname(resultSet.getString(8));
				activity.setActiusercount(resultSet.getInt(9));
				activity.setActibegtime(resultSet.getDate(10));
				activity.setActiendtime(resultSet.getDate(11));
				activity.setActicont(resultSet.getString(12));
				activity.setActiplace(resultSet.getString(13));
				activity.setActizancount(resultSet.getInt(14));
				activity.setActisettime(resultSet.getDate(15));
				lstActi.add(activity);
			}
			// 返回结果
			return lstActi;
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
	public Actihuo selectByActiid(int actiid) {
		// TODO Auto-generated method stub
		
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from actihuo where actiid=?";
		Object[] params = new Object[] { actiid };
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Actihuo activity=new Actihuo();
				activity.setActiid(resultSet.getInt(1));
				activity.setActiname(resultSet.getString(2));
				activity.setUserid(resultSet.getInt(3));
				activity.setNickname(resultSet.getString(4));
				activity.setUserpho(resultSet.getString(5));
				activity.setRank(resultSet.getInt(6));
				activity.setSportid(resultSet.getInt(7));
				activity.setSportname(resultSet.getString(8));
				activity.setActiusercount(resultSet.getInt(9));
				activity.setActibegtime(resultSet.getDate(10));
				activity.setActiendtime(resultSet.getDate(11));
				activity.setActicont(resultSet.getString(12));
				activity.setActiplace(resultSet.getString(13));
				activity.setActizancount(resultSet.getInt(14));
				activity.setActisettime(resultSet.getDate(15));
				return activity;
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
	public List<Actihuo> selectBySportname(String sportname) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Actihuo> lstActi = new ArrayList<Actihuo>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from actihuo where sportname=? order by actiid desc";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {sportname});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Actihuo activity=new Actihuo();
				activity.setActiid(resultSet.getInt(1));
				activity.setActiname(resultSet.getString(2));
				activity.setUserid(resultSet.getInt(3));
				activity.setNickname(resultSet.getString(4));
				activity.setUserpho(resultSet.getString(5));
				activity.setRank(resultSet.getInt(6));
				activity.setSportid(resultSet.getInt(7));
				activity.setSportname(resultSet.getString(8));
				activity.setActiusercount(resultSet.getInt(9));
				activity.setActibegtime(resultSet.getDate(10));
				activity.setActiendtime(resultSet.getDate(11));
				activity.setActicont(resultSet.getString(12));
				activity.setActiplace(resultSet.getString(13));
				activity.setActizancount(resultSet.getInt(14));
				activity.setActisettime(resultSet.getDate(15));
				lstActi.add(activity);
			}
			// 返回结果
			return lstActi;
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
	public List<Actihuo> selectByActiname(String actiname) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Actihuo> lstActi = new ArrayList<Actihuo>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from actihuo where actiname=? order by actiid desc";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {actiname});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Actihuo activity=new Actihuo();
				activity.setActiid(resultSet.getInt(1));
				activity.setActiname(resultSet.getString(2));
				activity.setUserid(resultSet.getInt(3));
				activity.setNickname(resultSet.getString(4));
				activity.setUserpho(resultSet.getString(5));
				activity.setRank(resultSet.getInt(6));
				activity.setSportid(resultSet.getInt(7));
				activity.setSportname(resultSet.getString(8));
				activity.setActiusercount(resultSet.getInt(9));
				activity.setActibegtime(resultSet.getDate(10));
				activity.setActiendtime(resultSet.getDate(11));
				activity.setActicont(resultSet.getString(12));
				activity.setActiplace(resultSet.getString(13));
				activity.setActizancount(resultSet.getInt(14));
				activity.setActisettime(resultSet.getDate(15));
				lstActi.add(activity);
			}
			// 返回结果
			return lstActi;
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
