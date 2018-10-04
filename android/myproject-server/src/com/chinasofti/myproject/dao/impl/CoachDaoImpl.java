package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.ICoachDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Coach;

public class CoachDaoImpl implements ICoachDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public CoachDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insertCoach(Coach coach) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		String coaname = coach.getCoaname();
		String coagender = coach.getCoagender();
		int coatypeid = coach.getCoatypeid();
		String coaphon = coach.getCoaphon();
		float coamark = coach.getCoamark();
		String coacontext = coach.getCoacontext();
		String coaimage=coach.getCoaimage();

		String strSQL = "insert into coach values(null,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { coaname, coagender, coatypeid,
				coaphon, coamark, coacontext,coaimage };

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
	public List<Coach> selectAllCoach() {
		// TODO Auto-generated method stub
		List<Coach> lstCoach = new ArrayList<Coach>();
		//
		this.conn = connectionManager.openConnection();
		//
		String strSQL = "select * from Coach order by coachid";
		//
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		//
		try {
			while (resultSet.next()) {
				// ����5-1������һ��Customers����
				Coach coach = new Coach();
				coach.setCoachid(resultSet.getInt(1));
				coach.setCoaname(resultSet.getString(2));
				coach.setCoagender(resultSet.getString(3));
				coach.setCoatypeid(resultSet.getInt(4));
				coach.setCoaphon(resultSet.getString(5));
				coach.setCoamark(resultSet.getFloat(6));
				coach.setCoacontext(resultSet.getString(7));
                coach.setCoaimage(resultSet.getString(8));
				// ����5-2������װ�õĶ�����ӵ�List������
				lstCoach.add(coach);

			}
			return lstCoach;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			this.connectionManager.closeConnection(conn);
		}

	}

	@Override
	public int deleteCoachById(int coachid) {
		// TODO Auto-generated method stub
		// ����1����ȡһ����ݿ����Ӷ���
		this.conn = this.connectionManager.openConnection();
		// ����2����������
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// ����3������SQL���ģ��
		String strSQL = "delete from coach where coachid=?";
		Object[] params = new Object[] { coachid };
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
	public Coach selectCoachById(int coachid) {
		// TODO Auto-generated method stub
		// ����1����ȡһ����ݿ����Ӷ���
		this.conn = this.connectionManager.openConnection();
		// ����2������SQL���ģ��
		String strSQL = "select * from coach  where coachid=?";
		Object[] params = new Object[] { coachid };
		// ����4������dbutils�еķ�����ɶ���ݿ�Ĳ�ѯ����
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// ����5����ȡ���ϲ���װ��һ������
		try {
			if (resultSet.next()) {
				// ����6������һ��Customers����
				Coach coach = new Coach();
				coach.setCoachid(resultSet.getInt(1));
				coach.setCoaname(resultSet.getString(2));
				coach.setCoagender(resultSet.getString(3));
				coach.setCoatypeid(resultSet.getInt(4));
				coach.setCoaphon(resultSet.getString(5));
				coach.setCoamark(resultSet.getFloat(6));
				coach.setCoacontext(resultSet.getString(7));
				 coach.setCoaimage(resultSet.getString(8));
				// ����7�����ض���
				return coach;
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
	public int updateCoach(Coach coach) {
		// TODO Auto-generated method stub
		// ����1����ȡһ����ݿ����Ӷ���
		this.conn = this.connectionManager.openConnection();
		// ����2����������
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// ����3������SQL���ģ��
		String strSQL = "update activityinvitation coaname =?, coagender=?, coatypeid=?,coaphon=?,  coamark=?, coacontext=?,coaimage=? where  coachid=?";
		Object[] params = new Object[] { coach.getCoaname(),
				coach.getCoagender(), coach.getCoatypeid(), coach.getCoaphon(),
				coach.getCoamark(), coach.getCoacontext(),coach.getCoaimage()};
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
	public Coach selectByCoaname(String coaname) {
		// TODO Auto-generated method stub
		System.out.println("Coach Dao");
		this.conn = connectionManager.openConnection();
		//
		String strSQL = "select * from Coach where coaname=?";
		Object[] params=new Object[]{coaname};
		//
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		//
		try {
			if (resultSet.next()) {
				// ����6������һ��Customers����
				Coach coach = new Coach();
				coach.setCoachid(resultSet.getInt(1));
				coach.setCoaname(resultSet.getString(2));
				coach.setCoagender(resultSet.getString(3));
				coach.setCoatypeid(resultSet.getInt(4));
				coach.setCoaphon(resultSet.getString(5));
				coach.setCoamark(resultSet.getFloat(6));
				coach.setCoacontext(resultSet.getString(7));
				 coach.setCoaimage(resultSet.getString(8));
				// ����7�����ض���
				return coach;
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
	public List<Coach> selectByCoagender(String coagender) {
		// TODO Auto-generated method stub
		List<Coach> lstCoach = new ArrayList<Coach>();
		//
		this.conn = connectionManager.openConnection();
		//
		String strSQL = "select * from Coach where coagender=?";
		Object[] params=new Object[]{coagender};
		//
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		//
		try {
			while (resultSet.next()) {
				// ����5-1������һ��Customers����
				Coach coach = new Coach();
				coach.setCoachid(resultSet.getInt(1));
				coach.setCoaname(resultSet.getString(2));
				coach.setCoagender(resultSet.getString(3));
				coach.setCoatypeid(resultSet.getInt(4));
				coach.setCoaphon(resultSet.getString(5));
				coach.setCoamark(resultSet.getFloat(6));
				coach.setCoacontext(resultSet.getString(7));
				 coach.setCoaimage(resultSet.getString(8));
				// ����5-2������װ�õĶ�����ӵ�List������
				lstCoach.add(coach);

			}
			return lstCoach;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public List<Coach> selectByCoatypeid(int coatypeid) {
		// TODO Auto-generated method stub
		List<Coach> lstCoach = new ArrayList<Coach>();
		//
		this.conn = connectionManager.openConnection();
		//
		String strSQL = "select * from Coach where coatypeid=?";
		Object[] params=new Object[]{coatypeid};
		//
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		//
		try {
			while (resultSet.next()) {
				// ����5-1������һ��Customers����
				Coach coach = new Coach();
				coach.setCoachid(resultSet.getInt(1));
				coach.setCoaname(resultSet.getString(2));
				coach.setCoagender(resultSet.getString(3));
				coach.setCoatypeid(resultSet.getInt(4));
				coach.setCoaphon(resultSet.getString(5));
				coach.setCoamark(resultSet.getFloat(6));
				coach.setCoacontext(resultSet.getString(7));
				 coach.setCoaimage(resultSet.getString(8));
				// ����5-2������װ�õĶ�����ӵ�List������
				lstCoach.add(coach);

			}
			return lstCoach;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	

}
