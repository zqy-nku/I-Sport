package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.User;

public class UserDaoImpl implements IUserDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;

	public UserDaoImpl() {
		super();
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		List<User> lstUser = new ArrayList<User>();
		String strSQL = "select * from user";
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[] {});
		// 获取查询结果
		try {
			while (resultSet.next()) {
				User user = new User();
				user.setUserid(resultSet.getInt(1));
				user.setRegid(resultSet.getInt(2));
				user.setSpordec(resultSet.getString(3));
				user.setSpornum(resultSet.getFloat(4));
				user.setRank(resultSet.getInt(5));
				user.setInteg(resultSet.getInt(6));
				user.setSportlabel(resultSet.getString(7));
				user.setIsaccepmsg(resultSet.getInt(8));
				user.setCollestatusid(resultSet.getString(9));
				user.setColletreasid(resultSet.getString(10));
				user.setUserpho(resultSet.getString(11));
				user.setUserstatus(resultSet.getInt(12));
				user.setMark(resultSet.getString(13));
				user.setActiid(resultSet.getString(14));
				user.setZanactiid(resultSet.getString(15));
				lstUser.add(user);

			}
			return lstUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public User selectUserById(int userid) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		String strSQL = "select * from user where userid=?";
		Object[] params = new Object[] { userid };
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		// 获取查询结果
		try {
			if (resultSet.next()) {
				User user = new User();
				user.setUserid(resultSet.getInt(1));
				user.setRegid(resultSet.getInt(2));
				user.setSpordec(resultSet.getString(3));
				user.setSpornum(resultSet.getFloat(4));
				user.setRank(resultSet.getInt(5));
				user.setInteg(resultSet.getInt(6));
				user.setSportlabel(resultSet.getString(7));
				user.setIsaccepmsg(resultSet.getInt(8));
				user.setCollestatusid(resultSet.getString(9));
				user.setColletreasid(resultSet.getString(10));
				user.setUserpho(resultSet.getString(11));
				user.setUserstatus(resultSet.getInt(12));
				user.setMark(resultSet.getString(13));
				user.setActiid(resultSet.getString(14));
				user.setZanactiid(resultSet.getString(15));
				return user;

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
	public int deleteUserById(int userid) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		String strSQL = "delete from user where userid=?";
		Object[] params = new Object[] { userid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();
		// 拆分属性
		int userid = user.getUserid();
		int regid = user.getRegid();
		String spordec = user.getSpordec();
		float spornum = user.getSpornum();
		int rank = user.getRank();
		int integ = user.getInteg();
		String sportlabel = user.getSportlabel();
		int isaccepmsg = user.getIsaccepmsg();
		String collestatusid = user.getCollestatusid();
		String colletreasid = user.getColletreasid();
		String userpho = user.getUserpho();
		int userstatus = user.getUserstatus();
		String mark = user.getMark();
		String actiid=user.getActiid();
		String zanactiiid=user.getZanactiid();

		String strSQL = "update user set regid=?, spordec=?,spornum=?,rank=?,integ=?,sportlabel=?,isaccepmsg=?,collestatusid=?,colletreasid=?,userpho=?,userstatus=?,mark=?,actiid=?,zanactiid=? where userid=?";
		Object[] params = new Object[] { regid, spordec, spornum, rank, integ,
				sportlabel, isaccepmsg, collestatusid, colletreasid, userpho,
				userstatus, mark,actiid,zanactiiid, userid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}
	
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();
		// 拆分属性
		//int userid = user.getUserid();
		int regid = user.getRegid();
		String spordec = user.getSpordec();
		float spornum = user.getSpornum();
		int rank = user.getRank();
		int integ = user.getInteg();
		String sportlabel = user.getSportlabel();
		int isaccepmsg = user.getIsaccepmsg();
		String collestatusid = user.getCollestatusid();
		String colletreasid = user.getColletreasid();
		String userpho = user.getUserpho();
		int userstatus = user.getUserstatus();
		String mark = user.getMark();
		String actiid=user.getActiid();
		String zanactiid=user.getZanactiid();

		String strSQL = "insert into user value(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { null,regid, spordec, spornum, rank, integ,
				sportlabel, isaccepmsg, collestatusid, colletreasid, userpho,
				userstatus, mark,actiid,zanactiid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}


	@Override
	public String findSportlabel(int userid) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		String strSQL = "select sportlabel from user where userid=?";
		Object[] params = new Object[] { userid };
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		// 获取查询结果
		try {
			if (resultSet.next()) {
				String soprtlabel = resultSet.getString(1);
				return soprtlabel;

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
	public User selectUserByRegid(int regid) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		String strSQL = "select * from user where regid=?";
		Object[] params = new Object[] { regid };
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		// 获取查询结果
		try {
			if (resultSet.next()) {
				User user = new User();
				user.setUserid(resultSet.getInt(1));
				user.setRegid(resultSet.getInt(2));
				user.setSpordec(resultSet.getString(3));
				user.setSpornum(resultSet.getFloat(4));
				user.setRank(resultSet.getInt(5));
				user.setInteg(resultSet.getInt(6));
				user.setSportlabel(resultSet.getString(7));
				user.setIsaccepmsg(resultSet.getInt(8));
				user.setCollestatusid(resultSet.getString(9));
				user.setColletreasid(resultSet.getString(10));
				user.setUserpho(resultSet.getString(11));
				user.setUserstatus(resultSet.getInt(12));
				user.setMark(resultSet.getString(13));
				user.setActiid(resultSet.getString(14));
				user.setZanactiid(resultSet.getString(15));
				return user;

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
	public List<User> selectMyfriend(int userid) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		List<User> lstUser = new ArrayList<User>();
		String strSQL = "select * from user where userid in (select fid from friendrelation where userid =?)";
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[] {userid});
		// 获取查询结果
		try {
			while (resultSet.next()) {
				User user = new User();
				user.setUserid(resultSet.getInt(1));
				user.setRegid(resultSet.getInt(2));
				user.setSpordec(resultSet.getString(3));
				user.setSpornum(resultSet.getFloat(4));
				user.setRank(resultSet.getInt(5));
				user.setInteg(resultSet.getInt(6));
				user.setSportlabel(resultSet.getString(7));
				user.setIsaccepmsg(resultSet.getInt(8));
				user.setCollestatusid(resultSet.getString(9));
				user.setColletreasid(resultSet.getString(10));
				user.setUserpho(resultSet.getString(11));
				user.setUserstatus(resultSet.getInt(12));
				user.setMark(resultSet.getString(13));
				lstUser.add(user);

			}
			return lstUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public List<User> selectOtherUser(int userid) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		List<User> lstUser = new ArrayList<User>();
		String strSQL = "select * from user where userid not in (select fid from friendrelation where userid =?) and userid <> ?";
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[] {userid,userid});
		// 获取查询结果
		try {
			while (resultSet.next()) {
				User user = new User();
				user.setUserid(resultSet.getInt(1));
				user.setRegid(resultSet.getInt(2));
				user.setSpordec(resultSet.getString(3));
				user.setSpornum(resultSet.getFloat(4));
				user.setRank(resultSet.getInt(5));
				user.setInteg(resultSet.getInt(6));
				user.setSportlabel(resultSet.getString(7));
				user.setIsaccepmsg(resultSet.getInt(8));
				user.setCollestatusid(resultSet.getString(9));
				user.setColletreasid(resultSet.getString(10));
				user.setUserpho(resultSet.getString(11));
				user.setUserstatus(resultSet.getInt(12));
				user.setMark(resultSet.getString(13));
				lstUser.add(user);

			}
			System.out.println("other:"+lstUser);
			return lstUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}


}
