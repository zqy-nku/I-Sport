package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IMessageDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Message;

public class MessageDaoImpl implements IMessageDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;

	public MessageDaoImpl() {
		super();
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Message> selectAllMessage() {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		List<Message> lstMessage = new ArrayList<Message>();
		String strSQL = "select * from message order by msgid";
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[] {});
		// 获取查询结果
		try {
			while (resultSet.next()) {
				Message message = new Message();
				message.setMsgid(resultSet.getInt(1));
				message.setUserid(resultSet.getInt(2));
				message.setTouserid(resultSet.getInt(3));
				message.setMsgtime(resultSet.getString(4));
				message.setMsgcontext(resultSet.getString(5));
				message.setMsgresid(resultSet.getString(6));
				lstMessage.add(message);

			}
			return lstMessage;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public Message selectMessageById(long msgid) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		String strSQL = "select * from message where msgid=?";
		Object[] params = new Object[] { msgid };
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		// 获取查询结果
		try {
			if (resultSet.next()) {
				Message message = new Message();
				message.setMsgid(resultSet.getInt(1));
				message.setUserid(resultSet.getInt(2));
				message.setTouserid(resultSet.getInt(3));
				message.setMsgtime(resultSet.getString(4));
				message.setMsgcontext(resultSet.getString(5));
				message.setMsgresid(resultSet.getString(6));
				return message;

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
	public int deleteMessageById(long msgid) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();

		String strSQL = "delete from message where msgid=?";
		Object[] params = new Object[] { msgid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int updateMessage(Message message) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();
		// 拆分属性
		long msgid = message.getMsgid();
		int userid = message.getUserid();
		int touserid = message.getTouserid();
		String msgtime = message.getMsgtime();
		String msgcontext = message.getMsgcontext();
		String msgresid = message.getMsgresid();

		String strSQL = "update message set userid=?,touserid=?,msgtime=?,msgcontext=?,msgresid=? where msgid=?";
		Object[] params = new Object[] { userid, touserid, msgtime, msgcontext,
				msgresid, msgid };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int insertMessage(Message message) {
		// TODO Auto-generated method stub
		// 获取链接对象
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		// 开始事务管理
		TransactionManager.beginTransaction();
		// 拆分属性
//		long msgid = message.getMsgid();
		int userid = message.getUserid();
		int touserid = message.getTouserid();
		String msgtime = message.getMsgtime();
		String msgcontext = message.getMsgcontext();
		String msgresid = message.getMsgresid();
		int msgstatus = message.getMsgstatus();

		String strSQL = "insert into message values(null,?,?,?,?,?,?)";
		Object[] params = new Object[] { userid, touserid, msgtime, msgcontext,
				msgresid, msgstatus };
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Message> selectByUserFridid(int userid, int fid) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		String strSQL = "(select * from message where userid=? and touserid=?) "
				+ "    union all (select * from message where userid=? and touserid=?)  order by msgid desc ";
		Object[] params = new Object[] { userid, fid,fid, userid};
		List<Message> lstMessage = new ArrayList<Message>();
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		// 获取查询结果
		try {
			while(resultSet.next()) {
				Message message = new Message();
				message.setMsgid(resultSet.getInt(1));
				message.setUserid(resultSet.getInt(2));
				message.setTouserid(resultSet.getInt(3));
				message.setMsgtime(resultSet.getString(4));
				message.setMsgcontext(resultSet.getString(5));
				message.setMsgresid(resultSet.getString(6));
				message.setMsgstatus(resultSet.getInt(7));
				lstMessage.add(message);

			} return lstMessage;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

}
