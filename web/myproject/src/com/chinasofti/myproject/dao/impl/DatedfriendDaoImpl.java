package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IDatedfriendDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Datedfriend;

public class DatedfriendDaoImpl implements IDatedfriendDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	

	public DatedfriendDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Datedfriend datedfriend) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		// 步骤3：拆分对向属性
		int userid=datedfriend.getUserid() ;
		int friendid=datedfriend.getFriendid();
		String datedtime=datedfriend.getDatedtime();
		int datedtype=datedfriend.getDatedtype();
		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into datedfriend values(null,?,?,?,?)";
		Object[] params = new Object[] { userid,friendid, datedtime,datedtype };
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
	public List<Datedfriend> selectAll() {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Datedfriend> lstDatedfriend= new ArrayList<Datedfriend>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from datedfriend order by datefrirelaid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Datedfriend datedfriend= new Datedfriend();
				datedfriend.setDatefrirelaid(resultSet.getInt(1));
				datedfriend.setUserid(resultSet.getInt(2));
				datedfriend.setFriendid(resultSet.getInt(3));
				datedfriend.setDatedtime(resultSet.getString(4));
				datedfriend.setDatedtype(resultSet.getInt(5));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstDatedfriend.add(datedfriend);
			}
			// 返回结果
			return lstDatedfriend;
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
	public int deleteById(int datefrirelaid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		
		// 步骤4：设置添加SQL语句模板
		String strSQL = "delete from datedfriend where datefrirelaid=?";
		Object[] params = new Object[]{datefrirelaid};
		// 步骤5：使用dbutils方法实现添加操作
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤6：提交事务
		if(affectedRows > 0){
			// 提交事务
			TransactionManager.commit();
		}else{
			// 回滚事务
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public Datedfriend selectById(int datefrirelaid) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		Datedfriend datedfriend= new Datedfriend();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from datedfriend where datefrirelaid=?";
		Object[] params = new Object[] {datefrirelaid};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				datedfriend.setDatefrirelaid(resultSet.getInt(1));
				datedfriend.setUserid(resultSet.getInt(2));
				datedfriend.setFriendid(resultSet.getInt(3));
				datedfriend.setDatedtime(resultSet.getString(4));
				datedfriend.setDatedtype(resultSet.getInt(5));
				return datedfriend;
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
	public int update(Datedfriend datedfriend) {
		// TODO Auto-generated method stub
		this.conn=this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		//
		int datefrirelaid=datedfriend.getDatefrirelaid();
		int userid=datedfriend.getUserid() ;
		int friendid=datedfriend.getFriendid();
		String datedtime=datedfriend.getDatedtime();
		int datedtype=datedfriend.getDatedtype();
		//
		String strSQL="update datedfriend set userid=?,friendid=?,datedtime=?,datedtype=?where datefrirelaid=?";
		Object[] params=new Object[]{userid,friendid,datedtime,datedtype,datefrirelaid};
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
	public List<Datedfriend> selectByUserid(int userid) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Datedfriend> lstDatedfriend= new ArrayList<Datedfriend>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from datedfriend where userid=?";
		Object[] params=new Object[]{userid};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Datedfriend datedfriend= new Datedfriend();
				datedfriend.setDatefrirelaid(resultSet.getInt(1));
				datedfriend.setUserid(resultSet.getInt(2));
				datedfriend.setFriendid(resultSet.getInt(3));
				datedfriend.setDatedtime(resultSet.getString(4));
				datedfriend.setDatedtype(resultSet.getInt(5));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstDatedfriend.add(datedfriend);
			}
			// 返回结果
			return lstDatedfriend;
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
	public List<Datedfriend> selectByDatedType(int datedtype) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
			List<Datedfriend> lstDatedfriend= new ArrayList<Datedfriend>();
			// 步骤2：获取一个数据库的连接对象
			this.conn = connectionManager.openConnection();
			// 步骤3：创建查询语句的模板
			String strSQL = "select * from datedfriend where datedtype=?";
			Object[] params=new Object[]{datedtype};
			// 步骤4：使用dbutils方法实现查询操作
			ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
			// 步骤5：将resultSet结果集转换成List数据结构
			try {
				while (resultSet.next()) {
					// 步骤5-1：创建一个Customers对象
					Datedfriend datedfriend= new Datedfriend();
					datedfriend.setDatefrirelaid(resultSet.getInt(1));
					datedfriend.setUserid(resultSet.getInt(2));
					datedfriend.setFriendid(resultSet.getInt(3));
					datedfriend.setDatedtime(resultSet.getString(4));
					datedfriend.setDatedtype(resultSet.getInt(5));
					// 步骤5-2：将封装好的对象添加到List集合中
					lstDatedfriend.add(datedfriend);
				}
				// 返回结果
				return lstDatedfriend;
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
	public List<Datedfriend> selectByFriendid(int friendid) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
			List<Datedfriend> lstDatedfriend= new ArrayList<Datedfriend>();
			// 步骤2：获取一个数据库的连接对象
			this.conn = connectionManager.openConnection();
			// 步骤3：创建查询语句的模板
			String strSQL = "select * from datedfriend where friendid=?";
			Object[] params=new Object[]{friendid};
			// 步骤4：使用dbutils方法实现查询操作
			ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
			// 步骤5：将resultSet结果集转换成List数据结构
			try {
				while (resultSet.next()) {
					// 步骤5-1：创建一个Customers对象
					Datedfriend datedfriend= new Datedfriend();
					datedfriend.setDatefrirelaid(resultSet.getInt(1));
					datedfriend.setUserid(resultSet.getInt(2));
					datedfriend.setFriendid(resultSet.getInt(3));
					datedfriend.setDatedtime(resultSet.getString(4));
					datedfriend.setDatedtype(resultSet.getInt(5));
					// 步骤5-2：将封装好的对象添加到List集合中
					lstDatedfriend.add(datedfriend);
				}
				// 返回结果
				return lstDatedfriend;
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
