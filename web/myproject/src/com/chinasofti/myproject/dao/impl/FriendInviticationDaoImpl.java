package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IFriendInviticationDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Friendinvitation;

public class FriendInviticationDaoImpl implements IFriendInviticationDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	

	public FriendInviticationDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Friendinvitation friendinvitation) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		// 步骤3：拆分对向属性
		int userid=friendinvitation.getUserid();
		int sportid=friendinvitation.getSportid();
		String invibegtime=friendinvitation.getInvibegtime();
		String inviendtime=friendinvitation.getInvibegtime();
		String invicont=friendinvitation.getInvicont();
		String invipubtime=friendinvitation.getInvipubtime();
		String partuserid=friendinvitation.getPartuserid();
		int partusercount=friendinvitation.getPartusercount();
		String inviplace=friendinvitation.getInviplace();
		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into friendinvitation values(null,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { userid, sportid, invibegtime, inviendtime,invicont,invipubtime,partuserid,partusercount,inviplace};
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
	public List<Friendinvitation> selectAll() {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Friendinvitation> lstFriendinvitation = new ArrayList<Friendinvitation>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from friendinvitation  order by inviid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Friendinvitation friendinvitation= new Friendinvitation();
				friendinvitation.setInviid(resultSet.getInt(1));
				friendinvitation.setUserid(resultSet.getInt(2));
				friendinvitation.setSportid(resultSet.getInt(3));
				friendinvitation.setInvibegtime(resultSet.getString(4));
				friendinvitation.setInviendtime(resultSet.getString(5));
				friendinvitation.setInvicont(resultSet.getString(6));
				friendinvitation.setInvipubtime(resultSet.getString(7));
				friendinvitation.setPartuserid(resultSet.getString(8));
				friendinvitation.setPartusercount(resultSet.getInt(9));
				friendinvitation.setInviplace(resultSet.getString(10));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstFriendinvitation.add(friendinvitation);
			}
			// 返回结果
			return lstFriendinvitation;
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
	public int deleteById(int inviid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		
		// 步骤4：设置添加SQL语句模板
		String strSQL = "delete from friendinvitation where inviid=?";
		Object[] params = new Object[]{inviid};
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
	public Friendinvitation selectById(int inviid) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		Friendinvitation friendinvitation = new Friendinvitation();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from friendinvitation where inviid=?";
		Object[] params = new Object[] { inviid};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				friendinvitation.setInviid(resultSet.getInt(1));
				friendinvitation.setUserid(resultSet.getInt(2));
				friendinvitation.setSportid(resultSet.getInt(3));
				friendinvitation.setInvibegtime(resultSet.getString(4));
				friendinvitation.setInviendtime(resultSet.getString(5));
				friendinvitation.setInvicont(resultSet.getString(6));
				friendinvitation.setInvipubtime(resultSet.getString(7));
				friendinvitation.setPartuserid(resultSet.getString(8));
				friendinvitation.setPartusercount(resultSet.getInt(9));
				friendinvitation.setInviplace(resultSet.getString(10));
				return friendinvitation;
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
	public int update(Friendinvitation friendinvitation) {
		// TODO Auto-generated method stub
		this.conn=this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		//
		int inviid=friendinvitation.getInviid();
		int userid=friendinvitation.getUserid();
		int sportid=friendinvitation.getSportid();
		String invibegtime=friendinvitation.getInvibegtime();
		String inviendtime=friendinvitation.getInvibegtime();
		String invicont=friendinvitation.getInvicont();
		String invipubtime=friendinvitation.getInvipubtime();
		String partuserid=friendinvitation.getPartuserid();
		int partusercount=friendinvitation.getPartusercount();
		String inviplace=friendinvitation.getInviplace();
		//
		String strSQL="update friendinvitation set userid=?,sportid=?,invibegtime=?,inviendtime=?,invicont=?,invipubtime=?,partuserid=?,partusercount=?,inviplace=?where inviid=?";
		Object[] params=new Object[]{userid,sportid,invibegtime,inviendtime,invicont,invipubtime,partuserid,partusercount,inviplace,inviid};
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
	public List<Friendinvitation> selectByUserid(int userid) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Friendinvitation> lstFriendinvitation = new ArrayList<Friendinvitation>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from friendinvitation where userid=?";
		Object[] params=new Object[]{userid};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Friendinvitation friendinvitation= new Friendinvitation();
				friendinvitation.setInviid(resultSet.getInt(1));
				friendinvitation.setUserid(resultSet.getInt(2));
				friendinvitation.setSportid(resultSet.getInt(3));
				friendinvitation.setInvibegtime(resultSet.getString(4));
				friendinvitation.setInviendtime(resultSet.getString(5));
				friendinvitation.setInvicont(resultSet.getString(6));
				friendinvitation.setInvipubtime(resultSet.getString(7));
				friendinvitation.setPartuserid(resultSet.getString(8));
				friendinvitation.setPartusercount(resultSet.getInt(9));
				friendinvitation.setInviplace(resultSet.getString(10));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstFriendinvitation.add(friendinvitation);
			}
			// 返回结果
			return lstFriendinvitation;
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
	public List<Friendinvitation> selectBySportid(int sportid) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Friendinvitation> lstFriendinvitation = new ArrayList<Friendinvitation>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from friendinvitation where sportid=?";
		Object[] params=new Object[]{sportid};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Friendinvitation friendinvitation= new Friendinvitation();
				friendinvitation.setInviid(resultSet.getInt(1));
				friendinvitation.setUserid(resultSet.getInt(2));
				friendinvitation.setSportid(resultSet.getInt(3));
				friendinvitation.setInvibegtime(resultSet.getString(4));
				friendinvitation.setInviendtime(resultSet.getString(5));
				friendinvitation.setInvicont(resultSet.getString(6));
				friendinvitation.setInvipubtime(resultSet.getString(7));
				friendinvitation.setPartuserid(resultSet.getString(8));
				friendinvitation.setPartusercount(resultSet.getInt(9));
				friendinvitation.setInviplace(resultSet.getString(10));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstFriendinvitation.add(friendinvitation);
			}
			// 返回结果
			return lstFriendinvitation;
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
	public List<Friendinvitation> selectByInvibegtime(String invibegtime) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		List<Friendinvitation> lstFriendinvitation = new ArrayList<Friendinvitation>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from friendinvitation where invibegtime=?";
		Object[] params=new Object[]{invibegtime};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Friendinvitation friendinvitation= new Friendinvitation();
				friendinvitation.setInviid(resultSet.getInt(1));
				friendinvitation.setUserid(resultSet.getInt(2));
				friendinvitation.setSportid(resultSet.getInt(3));
				friendinvitation.setInvibegtime(resultSet.getString(4));
				friendinvitation.setInviendtime(resultSet.getString(5));
				friendinvitation.setInvicont(resultSet.getString(6));
				friendinvitation.setInvipubtime(resultSet.getString(7));
				friendinvitation.setPartuserid(resultSet.getString(8));
				friendinvitation.setPartusercount(resultSet.getInt(9));
				friendinvitation.setInviplace(resultSet.getString(10));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstFriendinvitation.add(friendinvitation);
			}
			// 返回结果
			return lstFriendinvitation;
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
	public List<Friendinvitation> selectByPartuserid(int partuserid) {
		// TODO Auto-generated method stub
		return null;
	}

}
