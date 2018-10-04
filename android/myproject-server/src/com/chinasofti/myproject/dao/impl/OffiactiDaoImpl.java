package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.po.Offiacti;
import com.chinasofti.myproject.dao.IOffiactiDao;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;

public class OffiactiDaoImpl implements IOffiactiDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	public OffiactiDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	
	public int insertOffiacti(final Offiacti offiacti){
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：开启一个事务
				com.chinasofti.myproject.db.TransactionManager.conn = this.conn;
				com.chinasofti.myproject.db.TransactionManager.beginTransaction();
				// 步骤3：拆分对向属性
				String offiactiname = offiacti.getOffiactiname();
				String offiactitime = offiacti.getOffiactitime();
				String offiactiplace = offiacti.getOffiactiplace();
				int offiactitype = offiacti.getOffiactitype();
				String offiactisimpintr = offiacti.getOffiactisimpintr();
				int offiactistatus = offiacti.getOffiactistatus();
				String offiactires = offiacti.getOffiactires();
				
				// 步骤4：设置添加SQL语句模板
				String strSQL = "insert into offiacti values(null,?,?,?,?,?,?,?now())";
				Object[] params = new Object[] { offiactiname, offiactitime, offiactiplace,offiactitype,offiactisimpintr,offiactistatus,offiactires };
				
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
	//删除数据部分
	public int deleteOffiactiById(int offiactiid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from offiacti where offiactiid=?";
		Object[] params = new Object[] { offiactiid };
		// 步骤4：调用dbutils中的方法完成对数据库的删除操作
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤5：根据步骤4的操作结果提交或回滚事务
		if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
		// 步骤6：返回影响行数
		return affectedRwos;
		}
	//查询数据
	public Offiacti selectOffiactiById(int offiactiid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from offiacti where offiactiid=?";
		Object[] params = new Object[] { offiactiid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个Offiacti对象
				Offiacti offiacti = new Offiacti();
				offiacti.setOffiactiid(resultSet.getInt(1));
				offiacti.setOffiactiname(resultSet.getString(2));
				offiacti.setOffiactitime(resultSet.getString(3));
				offiacti.setOffiactiplace(resultSet.getString(4));
				offiacti.setOffiactitype(resultSet.getInt(5));
				offiacti.setOffiactisimpintr(resultSet.getString(6));
				offiacti.setOffiactistatus(resultSet.getInt(7));
				offiacti.setOffiactires(resultSet.getString(8));
				// 步骤7：返回对象
				return offiacti;
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
	//更新数据
	public int updateOffiacti(Offiacti offiacti) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update offiacti set offiactiname=?, offiactitime=?, offiactiplace=?,offiactitype=?,offiactisimpintr=?,offiactistatus=?,offiactires=? where offiactiid=?";
		Object[] params = new Object[] { offiacti.getOffiactiname(), offiacti.getOffiactitime(), offiacti.getOffiactiplace(), offiacti.getOffiactitype(),offiacti.getOffiactisimpintr(),offiacti.getOffiactistatus(),offiacti.getOffiactires(),offiacti.getOffiactiid() };
		// 步骤4：调用dbutils中的方法完成对数据库的删除操作
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤5：根据步骤4的操作结果提交或回滚事务
		if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
		// 步骤6：返回影响行数
		return affectedRwos;
	}
	//查询全部
	public List<Offiacti> selectAllOffiacti() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Offiacti> lstOffiacti = new ArrayList<Offiacti>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from offiacti order by offiactiid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Offiacti对象
				Offiacti offiacti = new Offiacti();
				offiacti.setOffiactiid(resultSet.getInt(1));
				offiacti.setOffiactiname(resultSet.getString(2));
				offiacti.setOffiactitime(resultSet.getString(3));
				offiacti.setOffiactiplace(resultSet.getString(4));
				offiacti.setOffiactitype(resultSet.getInt(5));
				offiacti.setOffiactisimpintr(resultSet.getString(6));
				offiacti.setOffiactistatus(resultSet.getInt(7));
				offiacti.setOffiactires(resultSet.getString(8));
				// 步骤5-2：将封装好的对象添加到List集合中
				lstOffiacti.add(offiacti);
			}
			// 返回结果
			return lstOffiacti;
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
	public List<Offiacti> selectByOffiactiname(String offiactiname) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
				List<Offiacti> lstOffiacti = new ArrayList<Offiacti>();
				// 步骤2：获取一个数据库的连接对象
				this.conn = connectionManager.openConnection();
				// 步骤3：创建查询语句的模板
				String strSQL = "select * from offiacti where offiactiname=?";
				Object[] params=new Object[] {offiactiname};
				// 步骤4：使用dbutils方法实现查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
				// 步骤5：将resultSet结果集转换成List数据结构
				try {
					while (resultSet.next()) {
						// 步骤5-1：创建一个Offiacti对象
						Offiacti offiacti = new Offiacti();
						offiacti.setOffiactiid(resultSet.getInt(1));
						offiacti.setOffiactiname(resultSet.getString(2));
						offiacti.setOffiactitime(resultSet.getString(3));
						offiacti.setOffiactiplace(resultSet.getString(4));
						offiacti.setOffiactitype(resultSet.getInt(5));
						offiacti.setOffiactisimpintr(resultSet.getString(6));
						offiacti.setOffiactistatus(resultSet.getInt(7));
						offiacti.setOffiactires(resultSet.getString(8));
						// 步骤5-2：将封装好的对象添加到List集合中
						lstOffiacti.add(offiacti);
					}
					// 返回结果
					return lstOffiacti;
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
	public List<Offiacti> selectByOffiactitype(int offiactitype) {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
				List<Offiacti> lstOffiacti = new ArrayList<Offiacti>();
				// 步骤2：获取一个数据库的连接对象
				this.conn = connectionManager.openConnection();
				// 步骤3：创建查询语句的模板
				String strSQL = "select * from offiacti where offiactitype=?";
				Object[] params=new Object[] {offiactitype};
				// 步骤4：使用dbutils方法实现查询操作
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
				// 步骤5：将resultSet结果集转换成List数据结构
				try {
					while (resultSet.next()) {
						// 步骤5-1：创建一个Offiacti对象
						Offiacti offiacti = new Offiacti();
						offiacti.setOffiactiid(resultSet.getInt(1));
						offiacti.setOffiactiname(resultSet.getString(2));
						offiacti.setOffiactitime(resultSet.getString(3));
						offiacti.setOffiactiplace(resultSet.getString(4));
						offiacti.setOffiactitype(resultSet.getInt(5));
						offiacti.setOffiactisimpintr(resultSet.getString(6));
						offiacti.setOffiactistatus(resultSet.getInt(7));
						offiacti.setOffiactires(resultSet.getString(8));
						// 步骤5-2：将封装好的对象添加到List集合中
						lstOffiacti.add(offiacti);
					}
					// 返回结果
					return lstOffiacti;
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
