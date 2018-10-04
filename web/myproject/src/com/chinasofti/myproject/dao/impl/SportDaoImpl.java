package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.ISportDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Sport;

public class SportDaoImpl implements ISportDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;

	public SportDaoImpl() {
		super();
		this.dbUtils=new DBUtils();
		this.connectionManager=new ConnectionManager();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insertSport(Sport sport) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		String strSQL="insert into sport values(null,?)";
		TransactionManager.conn=connection;
		TransactionManager.beginTransaction();
		int affectedRows=this.dbUtils.execOthers(connection, strSQL, new Object[]{sport.getSportname()});
		
		if(affectedRows>0){
			TransactionManager.commit();
			return affectedRows;
		}else{
			TransactionManager.rollback();
			return 0;
		}
	}

	@Override
	public int insertSportList(List<Sport> lstSport) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		TransactionManager.conn=connection;
		TransactionManager.beginTransaction();
		String strSQL="insert into sport values(null,?)";
		for(int i=0;i<lstSport.size();i++){
			if(this.dbUtils.execOthers(connection, strSQL, new Object[]{lstSport.get(i)})==0){
				TransactionManager.rollback();
				return 0;
			}
		}
		TransactionManager.commit();
		return lstSport.size();
	}

	@Override
	public  Sport selectByName(String name) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		String strSQL="select * from sport where sportname=?";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL, new Object[]{name});
		try {
			if(resultSet.next()) {
			  Sport sport = new Sport();
			  sport.setSportid(resultSet.getInt(1));
			  sport.setSportname(resultSet.getString(2));
			  return sport;
			} else{
			return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Sport> selectAll() {
		// TODO Auto-generated method stub
		Connection connection =this.connectionManager.openConnection();
		String strSQL="select * from sport";
		ResultSet resultSet=this.dbUtils.execQuery(connection, strSQL, new Object[]{});
		List<Sport> lstSport =new ArrayList<Sport>();
		try {
			while(resultSet.next()){
				Sport sport=new Sport();
				sport.setSportid(resultSet.getInt(1));
				sport.setSportname(resultSet.getString(2));
				lstSport.add(sport);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return lstSport;
	}

	@Override
	public int deleteSportById(int id) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		TransactionManager.conn=connection;
		TransactionManager.beginTransaction();
		String strSQL="delete from sport where sportid=?";
		int affectedRows=this.dbUtils.execOthers(connection, strSQL, new Object[]{id});
		if(affectedRows>0){
			TransactionManager.commit();
			return affectedRows;
		}else{
			TransactionManager.rollback();
			return 0;
		}
	}

	@Override
	public int deleteSportByName(String name) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		TransactionManager.conn=connection;
		TransactionManager.beginTransaction();
		String strSQL="delete from sport where sportname=?";
		int affectedRows=this.dbUtils.execOthers(connection, strSQL, new Object[]{name});
		if(affectedRows>0){
			TransactionManager.commit();
			return affectedRows;
		}else{
			TransactionManager.rollback();
			return 0;
		}
	}

	@Override
	public int deleteSportAll() {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		TransactionManager.conn=connection;
		TransactionManager.beginTransaction();
		String strSQL="delete from sport";
		int affectedRows=this.dbUtils.execOthers(connection, strSQL, new Object[]{});
		if(affectedRows>0){
			TransactionManager.commit();
			return affectedRows;
		}else{
			TransactionManager.rollback();
			return 0;
		}
	}

	@Override
	public Sport selectBySportid(int sportid) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		String strSQL="select * from sport where sportid=?";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL, new Object[]{sportid});
		try {
			if(resultSet.next()) {
			  Sport sport = new Sport();
			  sport.setSportid(resultSet.getInt(1));
			  sport.setSportname(resultSet.getString(2));
			  return sport;
			} else{
			return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String selectById(int id) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		String strSQL="select sportname from sport where sportid=?";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL, new Object[]{id});
		try {
			if(resultSet.next()) {
			 String sportname = resultSet.getString(1);
			  return sportname;
			} else{
			return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	}

	

}
