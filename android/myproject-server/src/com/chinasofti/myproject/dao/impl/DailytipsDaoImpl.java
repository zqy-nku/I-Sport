package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.dao.IDailytipsDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.po.Dailytips;

public class DailytipsDaoImpl implements IDailytipsDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	public DailytipsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Dailytips dailytip) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
				
		// 步骤3：拆分对向属性
		String tipcontext=dailytip.getTipcontext();
		String tipresid=dailytip.getTipresid();
		int tipstatus=dailytip.getTipstatus();
		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into dailytips values(null,?,?,?)";
		Object[] params = new Object[] { tipcontext, tipresid, tipstatus };
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
	public List<Dailytips> selectAll() {
		// TODO Auto-generated method stub
        // 步骤1：创建一个空的集合准备存放查询的结果
		List<Dailytips> lstDailytips = new ArrayList<Dailytips>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from dailytips order by tipid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Dailytips dailytips= new Dailytips();
				dailytips.setTipid(resultSet.getInt(1));
				dailytips.setTipcontext(resultSet.getString(2));
				dailytips.setTipresid(resultSet.getString(3));
				dailytips.setTipstatus(resultSet.getInt(4));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstDailytips.add(dailytips);
			}
			// 返回结果
			return lstDailytips;
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
	public int deleteById(int tipid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		
		// 步骤4：设置添加SQL语句模板
		String strSQL = "delete from dailytips where tipid=?";
		Object[] params = new Object[]{tipid};
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
	public Dailytips selectById(int tipid) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		Dailytips dailytips = new Dailytips();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from dailytips where tipid=?";
		Object[] params = new Object[] { tipid };
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				dailytips.setTipid(resultSet.getInt(1));
				dailytips.setTipcontext(resultSet.getString(2));
				dailytips.setTipresid(resultSet.getString(3));
				dailytips.setTipstatus(resultSet.getInt(4));
				return dailytips;
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
	public int update(Dailytips dailytip) {
		// TODO Auto-generated method stub
		this.conn=this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		//
		int tipid=dailytip.getTipid();
		String tipcontext=dailytip.getTipcontext();
		String tipresid=dailytip.getTipresid();
		int tipstatus=dailytip.getTipstatus();
		//
		String strSQL="update dailytips set tipcontext=?,tipresid=?,tipstatus=? where tipid=?";
		Object[] params=new Object[]{tipcontext,tipresid,tipstatus,tipid};
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
	public Dailytips selectByRand() {
		// TODO Auto-generated method stub
			// 步骤2：获取一个数据库的连接对象
			this.conn = connectionManager.openConnection();
			// 步骤3：创建查询语句的模板
			String strSQL = "select * from dailytips order by rand() limit 1";
			// 步骤4：使用dbutils方法实现查询操作
			ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
			// 步骤5：将resultSet结果集转换成List数据结构
			try {
				if (resultSet.next()) {
					// 步骤5-1：创建一个Customers对象
					Dailytips dailytips= new Dailytips();
					dailytips.setTipid(resultSet.getInt(1));
					dailytips.setTipcontext(resultSet.getString(2));
					dailytips.setTipresid(resultSet.getString(3));
					dailytips.setTipstatus(resultSet.getInt(4));
					return dailytips;
				}else{
					return null;
				}
				
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


