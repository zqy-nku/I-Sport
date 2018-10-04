package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.ICoachcommentDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Coachcomment;

public class CoachcommentDaoImpl implements ICoachcommentDao {
	
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public CoachcommentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insertCoachcomment(Coachcomment coachcomment) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		int coachid = coachcomment.getCoachid();
		int userid = coachcomment.getUserid();
		String coacomcont = coachcomment.getCoacomcont();
		String coacomresid = coachcomment.getCoacomresid();
		Date coacomtime = coachcomment.getCoacomtime();
		int coacomstar = coachcomment.getCoacomstar();

		String strSQL = "insert into Coachcomment values(null,?,?,?,?,?,?)";
		Object[] params = new Object[] {   coachid,  userid,
				 coacomcont,  coacomresid,  coacomtime,
				coacomstar };

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
	public List<Coachcomment> selectAllCoachcomment() {
		// TODO Auto-generated method stub
		//
		List<Coachcomment> lstCoachcomment = new ArrayList<Coachcomment>();
		//
		this.conn = connectionManager.openConnection();
		//
		String strSQL = "select * from Coachcomment order by coacomid";
		//
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		//
		try {
			while (resultSet.next()) {
				// ����5-1������һ��Customers����
				Coachcomment coachcomment = new Coachcomment();
				coachcomment.setCoachid(resultSet.getInt(1));
				coachcomment.setUserid(resultSet.getInt(2));
				coachcomment.setCoacomcont(resultSet.getString(3));
				coachcomment.setCoacomresid(resultSet.getString(4));
				coachcomment.setCoacomtime(resultSet.getDate(5));
				coachcomment.setCoacomstar(resultSet.getInt(6));
			
				
				
				// ����5-2������װ�õĶ�����ӵ�List������
				lstCoachcomment.add(coachcomment);

			}
			return lstCoachcomment;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteCoachcommentById(int coacomid) {
		// TODO Auto-generated method stub
		// ����1����ȡһ����ݿ����Ӷ���
				this.conn = this.connectionManager.openConnection();
				// ����2����������
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				// ����3������SQL���ģ��
				String strSQL = "delete from Coachcomment where coacomid=?";
				Object[] params = new Object[] { coacomid };
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
	public Coachcomment selectCoachcommentById(int coacomid) {
		// TODO Auto-generated method stub
		// ����1����ȡһ����ݿ����Ӷ���
				this.conn = this.connectionManager.openConnection();
				// ����2������SQL���ģ��
				String strSQL = "select * from Coachcomment  where coacomid=?";
				Object[] params = new Object[] { coacomid };
				// ����4������dbutils�еķ�����ɶ���ݿ�Ĳ�ѯ����
				ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
				// ����5����ȡ���ϲ���װ��һ������
				try {
					if (resultSet.next()) {
						// ����6������һ��Customers����
						Coachcomment coachcomment = new Coachcomment();
						coachcomment.setCoachid(resultSet.getInt(1));
						coachcomment.setUserid(resultSet.getInt(2));
						coachcomment.setCoacomcont(resultSet.getString(3));
						coachcomment.setCoacomresid(resultSet.getString(4));
						coachcomment.setCoacomtime(resultSet.getDate(5));
						coachcomment.setCoacomstar(resultSet.getInt(6));
					

						// ����7�����ض���
						return coachcomment;
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
	public int updateCoachcomment(Coachcomment coachcomment) {
		// TODO Auto-generated method stub
		// ����1����ȡһ����ݿ����Ӷ���
				this.conn = this.connectionManager.openConnection();
				// ����2����������
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				// ����3������SQL���ģ��
				String strSQL = "update Coachcomment coacomid=?,  coachid=?,  userid=?,coacomcont=?, coacomresid=?, coacomtime?, coacomstar=? where  coacomid=?";
				Object[] params = new Object[] {
				coachcomment.getCoachid(),
				coachcomment.getUserid(),
				coachcomment.getCoacomcont(),
				coachcomment.getCoacomresid(),
				coachcomment.getCoacomtime(),
				coachcomment.getCoacomstar()
			};
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
	public List<Coachcomment> selectByCoaid(int coachid) {
		// TODO Auto-generated method stub
		List<Coachcomment> lstCoachcomment = new ArrayList<Coachcomment>();
		//
		this.conn = connectionManager.openConnection();
		//
		String strSQL = "select * from Coachcomment where coachid=?";
		//
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {coachid});
		//
		try {
			while (resultSet.next()) {
				// ����5-1������һ��Customers����
				Coachcomment coachcomment = new Coachcomment();
				coachcomment.setCoachid(resultSet.getInt(1));
				coachcomment.setUserid(resultSet.getInt(2));
				coachcomment.setCoacomcont(resultSet.getString(3));
				coachcomment.setCoacomresid(resultSet.getString(4));
				coachcomment.setCoacomtime(resultSet.getDate(5));
				coachcomment.setCoacomstar(resultSet.getInt(6));
			
				
				
				// ����5-2������װ�õĶ�����ӵ�List������
				lstCoachcomment.add(coachcomment);

			}
			return lstCoachcomment;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	}


