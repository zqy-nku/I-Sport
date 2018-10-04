package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IActivityDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.po.Activity;
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
	
	public List<Activity> selectAll() {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Activity> lstActi = new ArrayList<Activity>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activity order by actiid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Activity activity=new Activity();
				activity.setActiid(resultSet.getInt(1));
				activity.setActiname(resultSet.getString(2));
				activity.setRegid(resultSet.getInt(3));
				activity.setNickname(resultSet.getString(4));
				activity.setSportid(resultSet.getInt(5));
				activity.setSportname(resultSet.getString(6));
				activity.setActiusercount(resultSet.getInt(7));
				activity.setActibegtime(resultSet.getDate(8));
				activity.setActiendtime(resultSet.getDate(9));
				activity.setActicont(resultSet.getString(10));
				activity.setActiplace(resultSet.getString(11));
				activity.setActidianzan(resultSet.getInt(12));
				activity.setActisettime(resultSet.getDate(13));
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
	public Activity selectByActiid(int actiid) {
		// TODO Auto-generated method stub
		
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activity where actiid=?";
		Object[] params = new Object[] { actiid };
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Activity activity=new Activity();
				activity.setActiid(resultSet.getInt(1));
				activity.setActiname(resultSet.getString(2));
				activity.setRegid(resultSet.getInt(3));
				activity.setNickname(resultSet.getString(4));
				activity.setSportid(resultSet.getInt(5));
				activity.setSportname(resultSet.getString(6));
				activity.setActiusercount(resultSet.getInt(7));
				activity.setActibegtime(resultSet.getDate(8));
				activity.setActiendtime(resultSet.getDate(9));
				activity.setActicont(resultSet.getString(10));
				activity.setActiplace(resultSet.getString(11));
				activity.setActidianzan(resultSet.getInt(12));
				activity.setActisettime(resultSet.getDate(13));
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
	public List<Activity> selectBySportname(String sportname) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Activity> lstActi = new ArrayList<Activity>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activity where sportname=?";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {sportname});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Activity activity=new Activity();
				activity.setActiid(resultSet.getInt(1));
				activity.setActiname(resultSet.getString(2));
				activity.setRegid(resultSet.getInt(3));
				activity.setNickname(resultSet.getString(4));
				activity.setSportid(resultSet.getInt(5));
				activity.setSportname(resultSet.getString(6));
				activity.setActiusercount(resultSet.getInt(7));
				activity.setActibegtime(resultSet.getDate(8));
				activity.setActiendtime(resultSet.getDate(9));
				activity.setActicont(resultSet.getString(10));
				activity.setActiplace(resultSet.getString(11));
				activity.setActidianzan(resultSet.getInt(12));
				activity.setActisettime(resultSet.getDate(13));
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
	public List<Activity> selectByActiname(String actiname) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Activity> lstActi = new ArrayList<Activity>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activity where actiname=?";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {actiname});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Activity activity=new Activity();
				activity.setActiid(resultSet.getInt(1));
				activity.setActiname(resultSet.getString(2));
				activity.setRegid(resultSet.getInt(3));
				activity.setNickname(resultSet.getString(4));
				activity.setSportid(resultSet.getInt(5));
				activity.setSportname(resultSet.getString(6));
				activity.setActiusercount(resultSet.getInt(7));
				activity.setActibegtime(resultSet.getDate(8));
				activity.setActiendtime(resultSet.getDate(9));
				activity.setActicont(resultSet.getString(10));
				activity.setActiplace(resultSet.getString(11));
				activity.setActidianzan(resultSet.getInt(12));
				activity.setActisettime(resultSet.getDate(13));
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
