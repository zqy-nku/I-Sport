package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.ISporttreasureDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Sporttreasure;

public class SporttreasureDaoImpl implements ISporttreasureDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;

	public SporttreasureDaoImpl() {
		super();
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Sporttreasure selectById(int id) {
		// TODO Auto-generated method stub
		Connection connection = this.connectionManager.openConnection();
		String strSQL = "select * from sporttreasure where treasid =?";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { id });

		try {
			if (resultSet.next()) {
				Sporttreasure sporttreasure = new Sporttreasure();
				sporttreasure.setTreasid(resultSet.getInt(1));
				sporttreasure.setSportid(resultSet.getInt(2));
				sporttreasure.setTreaauthname(resultSet.getString(3));
				sporttreasure.setTreasname(resultSet.getString(4));
				sporttreasure.setTreaspubtime(resultSet.getString(5));
				sporttreasure.setTreascollecount(resultSet.getInt(6));
				sporttreasure.setTreasviewcount(resultSet.getInt(7));
				sporttreasure.setTreascont(resultSet.getString(8));
				sporttreasure.setTrearespath(resultSet.getString(9));

				return sporttreasure;
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
	public List<Sporttreasure> selectBySportid(int id) {
		// TODO Auto-generated method stub
		Connection connection = this.connectionManager.openConnection();
		String strSQL = "select * from sporttreasure where treasid =?";
		List<Sporttreasure> lstTreasure = new ArrayList<Sporttreasure>();
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { id });

		try {
			while (resultSet.next()) {
				Sporttreasure sporttreasure = new Sporttreasure();
				sporttreasure.setTreasid(resultSet.getInt(1));
				sporttreasure.setSportid(resultSet.getInt(2));
				sporttreasure.setTreaauthname(resultSet.getString(3));
				sporttreasure.setTreasname(resultSet.getString(4));
				sporttreasure.setTreaspubtime(resultSet.getString(5));
				sporttreasure.setTreascollecount(resultSet.getInt(6));
				sporttreasure.setTreasviewcount(resultSet.getInt(7));
				sporttreasure.setTreascont(resultSet.getString(8));
				sporttreasure.setTrearespath(resultSet.getString(9));

				lstTreasure.add(sporttreasure);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return lstTreasure;
	}

	@Override
	public List<Sporttreasure> selectByTreasureName(String treasurename) {
		// TODO Auto-generated method stub
		Connection connection = this.connectionManager.openConnection();
		String strSQL = "select * from sporttreasure where treasname =?";
		List<Sporttreasure> lstTreasure = new ArrayList<Sporttreasure>();
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { treasurename });

		try {
			while (resultSet.next()) {
				Sporttreasure sporttreasure = new Sporttreasure();
				sporttreasure.setTreasid(resultSet.getInt(1));
				sporttreasure.setSportid(resultSet.getInt(2));
				sporttreasure.setTreaauthname(resultSet.getString(3));
				sporttreasure.setTreasname(resultSet.getString(4));
				sporttreasure.setTreaspubtime(resultSet.getString(5));
				sporttreasure.setTreascollecount(resultSet.getInt(6));
				sporttreasure.setTreasviewcount(resultSet.getInt(7));
				sporttreasure.setTreascont(resultSet.getString(8));
				sporttreasure.setTrearespath(resultSet.getString(9));

				lstTreasure.add(sporttreasure);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return lstTreasure;

	}

	@Override
	public int insertSporttreasure(Sporttreasure sporttreasure) {
		// TODO Auto-generated method stub
		Connection connection = this.connectionManager.openConnection();
		String strSQL = "insert into sporttreasure value(null,?,?,?,?,?,?,?,?,?)";
		TransactionManager.conn = connection;
		TransactionManager.beginTransaction();

		Object[] params = new Object[] { sporttreasure.getSportid(),
				sporttreasure.getTreaauthname(), sporttreasure.getTreasname(),
				sporttreasure.getTreaspubtime(),
				sporttreasure.getTreascollecount(),
				sporttreasure.getTreasviewcount(),
				sporttreasure.getTreascont(), sporttreasure.getTrearespath() };
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
			return affectedRows;
		} else {
			TransactionManager.rollback();
			return 0;
		}
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		Connection connection = this.connectionManager.openConnection();
		TransactionManager.conn = connection;
		String strSQL = "delete from sporttreasure where treasid=?";

		TransactionManager.beginTransaction();
		int affectedRows = this.dbUtils.execOthers(connection, strSQL,
				new Object[] { id });
		if (affectedRows > 0) {
			TransactionManager.commit();
			return affectedRows;
		} else {
			TransactionManager.rollback();
			return 0;
		}
	}

	@Override
	public int updateSporttreasure(Sporttreasure sporttreasure) {
		// TODO Auto-generated method stub
		Connection connection = this.connectionManager.openConnection();
		TransactionManager.conn = connection;
		String strSQL = "update sporttreasure set sportid=?, treaauthname=?, treasname=?, treaspubtime=? ,treascollecount=?,"
				+ " treasviewcount=?, treascont=?, treasrespath=? where treasid=?";
		Object[] params = new Object[] { sporttreasure.getSportid(),
				sporttreasure.getTreaauthname(), 
				sporttreasure.getTreasname(),
				sporttreasure.getTreaspubtime(),
				sporttreasure.getTreascollecount(),
				sporttreasure.getTreasviewcount(),
				sporttreasure.getTreascont(), sporttreasure.getTrearespath(),
				sporttreasure.getTreasid() };

		TransactionManager.beginTransaction();
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
			return affectedRows;
		} else {
			TransactionManager.rollback();
			return 0;
		}
	}

	@Override
	public List<Sporttreasure> selectAll() {
		// TODO Auto-generated method stub
		Connection connection = this.connectionManager.openConnection();
		String strSQL = "select * from sporttreasure order by treasid";
		List<Sporttreasure> lstTreasure = new ArrayList<Sporttreasure>();
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] {});

		try {
			while (resultSet.next()) {
				Sporttreasure sporttreasure = new Sporttreasure();
				sporttreasure.setTreasid(resultSet.getInt(1));
				sporttreasure.setSportid(resultSet.getInt(2));
				sporttreasure.setTreaauthname(resultSet.getString(3));
				sporttreasure.setTreasname(resultSet.getString(4));
				sporttreasure.setTreaspubtime(resultSet.getString(5));
				sporttreasure.setTreascollecount(resultSet.getInt(6));
				sporttreasure.setTreasviewcount(resultSet.getInt(7));
				sporttreasure.setTreascont(resultSet.getString(8));
				sporttreasure.setTrearespath(resultSet.getString(9));

				lstTreasure.add(sporttreasure);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return lstTreasure;
	}

	@Override
	public List<Sporttreasure> selectByKeyword(String keyword) {
		// TODO Auto-generated method stub
		Connection connection = this.connectionManager.openConnection();
//		String newkeyword = "'%"+keyword+"%'";
		String strSQL = "select * from sporttreasure where treasname like '%"+keyword+"%' ";
//		String strSQL = "select * from sporttreasure where treasname like ? ";
		List<Sporttreasure> lstTreasure = new ArrayList<Sporttreasure>();
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { });

		try {
			while (resultSet.next()) {
				Sporttreasure sporttreasure = new Sporttreasure();
				sporttreasure.setTreasid(resultSet.getInt(1));
				sporttreasure.setSportid(resultSet.getInt(2));
				sporttreasure.setTreaauthname(resultSet.getString(3));
				sporttreasure.setTreasname(resultSet.getString(4));
				sporttreasure.setTreaspubtime(resultSet.getString(5));
				sporttreasure.setTreascollecount(resultSet.getInt(6));
				sporttreasure.setTreasviewcount(resultSet.getInt(7));
				sporttreasure.setTreascont(resultSet.getString(8));
				sporttreasure.setTrearespath(resultSet.getString(9));

				lstTreasure.add(sporttreasure);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		System.out.println("dao结果是"+lstTreasure);
		if(lstTreasure.size() >0){
			System.out.println(">0");
		}else{
			System.out.println("<0");
		}
		return lstTreasure;
	}

}
