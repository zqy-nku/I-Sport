package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Person;

public class PersonDaoImpl implements IPersonDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	public PersonDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	
	public int insertPerson(final Person person){
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：开启一个事务
				com.chinasofti.myproject.db.TransactionManager.conn = this.conn;
				com.chinasofti.myproject.db.TransactionManager.beginTransaction();
				// 步骤3：拆分对向属性
				String personaccount = person.getAccount();
				String personpassword = person.getPassword();
				String personnickname = person.getNickname();
				String personregtime = person.getRegtime();
				String personregaddr = person.getRegaddr();
				String personreggender = person.getReggender();
				
				// 步骤4：设置添加SQL语句模板
				String strSQL = "insert into person values(null,?,?,?,?,?,?)";
				Object[] params = new Object[] { personaccount, personpassword, personnickname,personregtime,personregaddr,personreggender };
				
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
		public int deletePersonById(int regid) {
			// TODO Auto-generated method stub
			// 步骤1：获取一个数据库连接对象
			this.conn = this.connectionManager.openConnection();
			// 步骤2：开启事务
			TransactionManager.conn = this.conn;
			TransactionManager.beginTransaction();
			// 步骤3：创建SQL语句模板
			String strSQL = "delete from person where regid=?";
			Object[] params = new Object[] { regid };
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
		public Person selectPersonById(int regid) {
			// TODO Auto-generated method stub
			// 步骤1：获取一个数据库连接对象
			this.conn = this.connectionManager.openConnection();
			// 步骤2：创建SQL语句模板
			String strSQL = "select * from person where regid=?";
			Object[] params = new Object[] { regid };
			// 步骤4：调用dbutils中的方法完成对数据库的查询操作
			ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
			// 步骤5：获取结果集合并封装成一个对象
			try {
				if (resultSet.next()) {
					// 步骤6：创建一个Person对象
					Person person = new Person();
					person.setRegid(resultSet.getInt(1));
					person.setAccount(resultSet.getString(2));
					person.setPassword(resultSet.getString(3));
					person.setNickname(resultSet.getString(4));
					person.setRegtime(resultSet.getString(5));
					person.setRegaddr(resultSet.getString(6));
					person.setReggender(resultSet.getString(7));
					// 步骤7：返回对象
					return person;
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
		public int updatePerson(Person person) {
			// TODO Auto-generated method stub
			// 步骤1：获取一个数据库连接对象
			this.conn = this.connectionManager.openConnection();
			// 步骤2：开启事务
			TransactionManager.conn = this.conn;
			TransactionManager.beginTransaction();
			// 步骤3：创建SQL语句模板
			String strSQL = "update person set account=?, password=?, nickname=?,regtime=?,regaddr=?,reggender=? where regid=?";
			Object[] params = new Object[] { person.getAccount(), person.getPassword(),person.getNickname(),person.getRegtime(),person.getRegaddr(),person.getReggender(),person.getRegid() };
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
		public List<Person> selectAllPerson() {
			// TODO Auto-generated method stub
			// 步骤1：创建一个空的集合准备存放查询的结果
			List<Person> lstPerson = new ArrayList<Person>();
			// 步骤2：获取一个数据库的连接对象
			this.conn = connectionManager.openConnection();
			// 步骤3：创建查询语句的模板
			String strSQL = "select * from person order by regid";
			// 步骤4：使用dbutils方法实现查询操作
			ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
					new Object[] {});
			// 步骤5：将resultSet结果集转换成List数据结构
			try {
				while (resultSet.next()) {
					// 步骤5-1：创建一个Person对象
					Person person = new Person();
					person.setRegid(resultSet.getInt(1));
					person.setAccount(resultSet.getString(2));
					person.setPassword(resultSet.getString(3));
					person.setNickname(resultSet.getString(4));
					person.setRegtime(resultSet.getString(5));
					person.setRegaddr(resultSet.getString(6));
					person.setReggender(resultSet.getString(7));
					// 步骤5-2：将封装好的对象添加到List集合中
					lstPerson.add(person);
				}
				// 返回结果
				return lstPerson;
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
		public Person selectPersonByAccount(String account) {
			// TODO Auto-generated method stub
			// 步骤1：获取一个数据库连接对象
			this.conn = this.connectionManager.openConnection();
			// 步骤2：创建SQL语句模板
			String strSQL = "select * from person where account=?";
			Object[] params = new Object[] { account };
			// 步骤4：调用dbutils中的方法完成对数据库的查询操作
			ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
			// 步骤5：获取结果集合并封装成一个对象
			try {
				if (resultSet.next()) {
					// 步骤6：创建一个Person对象
					Person person = new Person();
					person.setRegid(resultSet.getInt(1));
					person.setAccount(resultSet.getString(2));
					person.setPassword(resultSet.getString(3));
					person.setNickname(resultSet.getString(4));
					person.setRegtime(resultSet.getString(5));
					person.setRegaddr(resultSet.getString(6));
					person.setReggender(resultSet.getString(7));
					// 步骤7：返回对象
					return person;
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
		public Person selectPersonByNickname(String nickname) {
			// TODO Auto-generated method stub
			// 步骤1：获取一个数据库连接对象
			this.conn = this.connectionManager.openConnection();
			// 步骤2：创建SQL语句模板
			String strSQL = "select * from person where nickname=?";
			Object[] params = new Object[] { nickname };
			// 步骤4：调用dbutils中的方法完成对数据库的查询操作
			ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
			// 步骤5：获取结果集合并封装成一个对象
			try {
				if (resultSet.next()) {
					// 步骤6：创建一个Person对象
					Person person = new Person();
					person.setRegid(resultSet.getInt(1));
					person.setAccount(resultSet.getString(2));
					person.setPassword(resultSet.getString(3));
					person.setNickname(resultSet.getString(4));
					person.setRegtime(resultSet.getString(5));
					person.setRegaddr(resultSet.getString(6));
					person.setReggender(resultSet.getString(7));
					// 步骤7：返回对象
					return person;
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
		public Person selectByObject(String account, String password) {
			// TODO Auto-generated method stub
			// 步骤1：获取一个数据库连接对象
			this.conn = this.connectionManager.openConnection();
			// 步骤2：创建SQL语句模板
			String strSQL = "select * from person where account=? and password=?";
			Object[] params = new Object[] { account,password };
			// 步骤4：调用dbutils中的方法完成对数据库的查询操作
			ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
			// 步骤5：获取结果集合并封装成一个对象
			try {
				if (resultSet.next()) {
					// 步骤6：创建一个Person对象
					Person person = new Person();
					person.setRegid(resultSet.getInt(1));
					person.setAccount(resultSet.getString(2));
					person.setPassword(resultSet.getString(3));
					person.setNickname(resultSet.getString(4));
					person.setRegtime(resultSet.getString(5));
					person.setRegaddr(resultSet.getString(6));
					person.setReggender(resultSet.getString(7));
					// 步骤7：返回对象
					return person;
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
}
