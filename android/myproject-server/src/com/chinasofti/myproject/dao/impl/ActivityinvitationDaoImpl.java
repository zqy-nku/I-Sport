package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Activityinvitation;


public class ActivityinvitationDaoImpl implements IActivityinvitationDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public ActivityinvitationDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insertActivityinvitation(Activityinvitation activityinvitation) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		//
		int sportid = activityinvitation.getSportid();
		int userid = activityinvitation.getUserid();
		String actiname = activityinvitation.getActiname();
		Date actibegtime = activityinvitation.getActibegtime();
		int actiissucc = activityinvitation.getActiissucc();
		Date actisettime = activityinvitation.getActisettime();
		int actiusercount = activityinvitation.getActiusercount();
		String acticont = activityinvitation.getActicont();
		String actiplace = activityinvitation.getActiplace();
		Date actiendtime = activityinvitation.getActiendtime();
		int actizancount=activityinvitation.getActizancount();
		
		if(actiname==null){
			TransactionManager.rollback();
			return 0;
		}

		//
		String strSQL = "insert into activityinvitation values(null,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { sportid, userid, actiname,
				actibegtime, actiissucc, actisettime, 
				actiusercount, acticont, actiplace, actiendtime,actizancount};

		//
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		//
		if (affectedRows > 0) {
			//
			TransactionManager.commit();
		} else
			//
			TransactionManager.rollback();
		return affectedRows;
	}

	@Override
	public int updateActivityinvitation(Activityinvitation activityinvitation) {
		// TODO Auto-generated method stub
		// ����1����ȡһ����ݿ����Ӷ���
		this.conn = this.connectionManager.openConnection();
		// ����2����������
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// ����3������SQL���ģ��
		String strSQL = "update activityinvitation set sportid=?, userid=?, actiname=?,actibegtime=?,actiissucc=?, actisettime=?,actiusercount=?, acticont=?, actiplace=?, actiendtime=?,actizancount=? where actiid=?";
		Object[] params = new Object[] { activityinvitation.getSportid(),
				activityinvitation.getUserid(),
				activityinvitation.getActiname(),
				activityinvitation.getActibegtime(),
				activityinvitation.getActiissucc(),
				activityinvitation.getActisettime(),
				activityinvitation.getActiusercount(),
				activityinvitation.getActicont(),
				activityinvitation.getActiplace(),
				activityinvitation.getActiendtime(),
				activityinvitation.getActizancount(),
		        activityinvitation.getActiid()		
		};
		// ����4������dbutils�еķ�����ɶ���ݿ��ɾ�����
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		// ����5����ݲ���4�Ĳ�������ύ��ع�����
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		// ����6������Ӱ������
		return affectedRwos;

	}

	@Override
	public List<Activityinvitation> selectAllActivityinvitation() {
		// TODO Auto-generated method stub
		//
		List<Activityinvitation> lstActivityinvitation = new ArrayList<Activityinvitation>();
		//
		this.conn = connectionManager.openConnection();
		//
		String strSQL = "select * from Activityinvitation order by actiid desc";
		//
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		//
		try {
			while (resultSet.next()) {
				// ����5-1������һ��Customers����
				Activityinvitation activityinvitation = new Activityinvitation();
				activityinvitation.setActiid(resultSet.getInt(1));
				activityinvitation.setSportid(resultSet.getInt(2));
				activityinvitation.setUserid(resultSet.getInt(3));
				activityinvitation.setActiname(resultSet.getString(4));
				activityinvitation.setActibegtime(resultSet.getDate(5));
				activityinvitation.setActiissucc(resultSet.getInt(6));
				activityinvitation.setActisettime(resultSet.getDate(7));
				activityinvitation.setActiusercount(resultSet.getInt(8));
				activityinvitation.setActicont(resultSet.getString(9));
				activityinvitation.setActiplace(resultSet.getString(10));
				activityinvitation.setActiendtime(resultSet.getDate(11));
                activityinvitation.setActizancount(resultSet.getInt(12));
				// ����5-2������װ�õĶ�����ӵ�List������
				lstActivityinvitation.add(activityinvitation);

			}
			return lstActivityinvitation;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public Activityinvitation selectActivityinvitationById(int actiid) {
		// TODO Auto-generated method stub
		// ����1����ȡһ����ݿ����Ӷ���
		this.conn = this.connectionManager.openConnection();
		// ����2������SQL���ģ��
		String strSQL = "select * from activityinvitation where actiid=? order by actiid desc";
		Object[] params = new Object[] { actiid };
		// ����4������dbutils�еķ�����ɶ���ݿ�Ĳ�ѯ����
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// ����5����ȡ���ϲ���װ��һ������
		try {
			if (resultSet.next()) {
				// ����6������һ��Customers����
				Activityinvitation activityinvitation = new Activityinvitation();
				activityinvitation.setActiid(resultSet.getInt(1));
				activityinvitation.setSportid(resultSet.getInt(2));
				activityinvitation.setUserid(resultSet.getInt(3));
				activityinvitation.setActiname(resultSet.getString(4));
				activityinvitation.setActibegtime(resultSet.getDate(5));
				activityinvitation.setActiissucc(resultSet.getInt(6));
				activityinvitation.setActisettime(resultSet.getDate(7));
				activityinvitation.setActiusercount(resultSet.getInt(8));
				activityinvitation.setActicont(resultSet.getString(9));
				activityinvitation.setActiplace(resultSet.getString(10));
				activityinvitation.setActiendtime(resultSet.getDate(11));
                activityinvitation.setActizancount(resultSet.getInt(12));
				// ����7�����ض���
				return activityinvitation;
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
	public int deleteActivityinvitationById(int actiid) {
		// TODO Auto-generated method stub
		// ����1����ȡһ����ݿ����Ӷ���
		this.conn = this.connectionManager.openConnection();
		// ����2����������
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// ����3������SQL���ģ��
		String strSQL = "delete from activityinvitation where actiid=? ";
		Object[] params = new Object[] { actiid };
		// ����4������dbutils�еķ�����ɶ���ݿ��ɾ�����
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// ����5����ݲ���4�Ĳ�������ύ��ع�����
		if (affectedRows > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		// ����6������Ӱ������
		return affectedRows;

	}

	@Override
	public List<Activityinvitation> selectByActiname(String actiname) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		 List<Activityinvitation> lstActiinvi = new ArrayList<Activityinvitation>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activityinvitation where actiname=? order by actiid desc";
		Object[] params=new Object[] {actiname};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Activityinvitation activityinvitation = new Activityinvitation();
				activityinvitation.setActiid(resultSet.getInt(1));
				activityinvitation.setSportid(resultSet.getInt(2));
				activityinvitation.setUserid(resultSet.getInt(3));
				activityinvitation.setActiname(resultSet.getString(4));
				activityinvitation.setActibegtime(resultSet.getDate(5));
				activityinvitation.setActiissucc(resultSet.getInt(6));
				activityinvitation.setActisettime(resultSet.getDate(7));
				activityinvitation.setActiusercount(resultSet.getInt(8));
				activityinvitation.setActicont(resultSet.getString(9));
				activityinvitation.setActiplace(resultSet.getString(10));
				activityinvitation.setActiendtime(resultSet.getDate(11));
                activityinvitation.setActizancount(resultSet.getInt(12));
				lstActiinvi.add(activityinvitation);
			}
			// 返回结果
			return lstActiinvi;
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
	public List<Activityinvitation> selectBySportid(int sportid) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		 List<Activityinvitation> lstActiinvi = new ArrayList<Activityinvitation>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activityinvitation where sportid=? order by actiid desc";
		Object[] params=new Object[] {sportid};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Activityinvitation activityinvitation = new Activityinvitation();
				activityinvitation.setActiid(resultSet.getInt(1));
				activityinvitation.setSportid(resultSet.getInt(2));
				activityinvitation.setUserid(resultSet.getInt(3));
				activityinvitation.setActiname(resultSet.getString(4));
				activityinvitation.setActibegtime(resultSet.getDate(5));
				activityinvitation.setActiissucc(resultSet.getInt(6));
				activityinvitation.setActisettime(resultSet.getDate(7));
				activityinvitation.setActiusercount(resultSet.getInt(8));
				activityinvitation.setActicont(resultSet.getString(9));
				activityinvitation.setActiplace(resultSet.getString(10));
				activityinvitation.setActiendtime(resultSet.getDate(11));
                activityinvitation.setActizancount(resultSet.getInt(12));
				lstActiinvi.add(activityinvitation);
			}
			// 返回结果
			return lstActiinvi;
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
	public List<Activityinvitation> selectByUserid(int userid) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		 List<Activityinvitation> lstActiinvi = new ArrayList<Activityinvitation>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activityinvitation where userid=? order by actiid desc";
		Object[] params=new Object[] {userid};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Activityinvitation activityinvitation = new Activityinvitation();
				activityinvitation.setActiid(resultSet.getInt(1));
				activityinvitation.setSportid(resultSet.getInt(2));
				activityinvitation.setUserid(resultSet.getInt(3));
				activityinvitation.setActiname(resultSet.getString(4));
				activityinvitation.setActibegtime(resultSet.getDate(5));
				activityinvitation.setActiissucc(resultSet.getInt(6));
				activityinvitation.setActisettime(resultSet.getDate(7));
				activityinvitation.setActiusercount(resultSet.getInt(8));
				activityinvitation.setActicont(resultSet.getString(9));
				activityinvitation.setActiplace(resultSet.getString(10));
				activityinvitation.setActiendtime(resultSet.getDate(11));
                activityinvitation.setActizancount(resultSet.getInt(12));
				lstActiinvi.add(activityinvitation);
			}
			// 返回结果
			return lstActiinvi;
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
	public List<Activityinvitation> selectByActibegtime(Date actibegtime) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		 List<Activityinvitation> lstActiinvi = new ArrayList<Activityinvitation>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from activityinvitation where actibegtime=? order by actiid desc";
		Object[] params=new Object[] {actibegtime};
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个Customers对象
				Activityinvitation activityinvitation = new Activityinvitation();
				activityinvitation.setActiid(resultSet.getInt(1));
				activityinvitation.setSportid(resultSet.getInt(2));
				activityinvitation.setUserid(resultSet.getInt(3));
				activityinvitation.setActiname(resultSet.getString(4));
				activityinvitation.setActibegtime(resultSet.getDate(5));
				activityinvitation.setActiissucc(resultSet.getInt(6));
				activityinvitation.setActisettime(resultSet.getDate(7));
				activityinvitation.setActiusercount(resultSet.getInt(8));
				activityinvitation.setActicont(resultSet.getString(9));
				activityinvitation.setActiplace(resultSet.getString(10));
				activityinvitation.setActiendtime(resultSet.getDate(11));
                activityinvitation.setActizancount(resultSet.getInt(12));
				lstActiinvi.add(activityinvitation);
			}
			// 返回结果
			return lstActiinvi;
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
	public List<Activityinvitation> selectByActiuserid(int actiuserid) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		 List<Activityinvitation> lstActiinvi = new ArrayList<Activityinvitation>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		return lstActiinvi ;

	}

	@Override
	public List<Activityinvitation> sortByActiusercountAsc(List<Activityinvitation> lstActiinvi) {
		// TODO Auto-generated method stub
		 // 步骤1：创建一个空的集合准备存放查询的结果
		 List<Activityinvitation> result = new ArrayList<Activityinvitation>();
	     return result;


	}

	@Override
	public List<Activityinvitation> sortByActiusercountDesc(
			List<Activityinvitation> lstActiinvi) {
		// TODO Auto-generated method stub
		List<Activityinvitation> result = new ArrayList<Activityinvitation>();
	     return result;
}
}
