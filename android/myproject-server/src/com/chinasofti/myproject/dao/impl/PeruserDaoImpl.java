package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IPeruserDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Peruser;

public class PeruserDaoImpl implements IPeruserDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public PeruserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public Peruser selectById(int userid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from peruser where userid=?";
		Object[] params = new Object[] { userid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个Person对象
				Peruser peruser = new Peruser();
				peruser.setUserid(resultSet.getInt(1));
				peruser.setNickname(resultSet.getString(2));
				peruser.setUserpho(resultSet.getString(3));
				peruser.setSportlabel(resultSet.getString(4));
				// 步骤7：返回对象
				return peruser;
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
	public List<Peruser> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		List<Peruser> lstPeruser=new ArrayList<Peruser>();
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from peruser order by userid";
		Object[] params = new Object[] {};
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			while (resultSet.next()) {
				// 步骤6：创建一个Person对象
				Peruser peruser = new Peruser();
				peruser.setUserid(resultSet.getInt(1));
				peruser.setNickname(resultSet.getString(2));
				peruser.setUserpho(resultSet.getString(3));
				peruser.setSportlabel(resultSet.getString(4));
				// 步骤7：返回对象
				lstPeruser.add(peruser);
				
			} 
			return lstPeruser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public List<Peruser> selectByName(String nickname) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		List<Peruser> lstPeruser = new ArrayList<Peruser>();
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from peruser where nickname=?";
		Object[] params = new Object[] {nickname};
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			while (resultSet.next()) {
				// 步骤6：创建一个Person对象
				Peruser peruser = new Peruser();
				peruser.setUserid(resultSet.getInt(1));
				peruser.setNickname(resultSet.getString(2));
				peruser.setUserpho(resultSet.getString(3));
				peruser.setSportlabel(resultSet.getString(4));
				// 步骤7：返回对象
				lstPeruser.add(peruser);

			}
			return lstPeruser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	
	
	public List<Peruser> selectPeruserForpage(int offset,int pageSize)
	{
		// 步骤1：获取一个数据库连接对象
				List<Peruser> lstPeruser=new ArrayList<Peruser>();
				this.conn = this.connectionManager.openConnection();
				// 步骤2：创建SQL语句模板
				String strSQL = "select * from peruser";
				Object[] params = new Object[] {};
				// 步骤4：调用dbutils中的方法完成对数据库的查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
				// 步骤5：获取结果集合并封装成一个对象
				try {
					for(int i = 0;resultSet.next() && (i < offset+pageSize);i++){
						if(i < offset)
							continue;
						Peruser peruser = new Peruser();
						peruser.setUserid(resultSet.getInt(1));
						peruser.setNickname(resultSet.getString(2));
						peruser.setUserpho(resultSet.getString(3));
						peruser.setSportlabel(resultSet.getString(4));
						// 步骤7：返回对象
						lstPeruser.add(peruser);
						for(int j = 0;j < lstPeruser.size();j++)
							System.out.println(lstPeruser.get(j));
					}
					return lstPeruser;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					this.connectionManager.closeConnection(conn);
				}
	}

}
