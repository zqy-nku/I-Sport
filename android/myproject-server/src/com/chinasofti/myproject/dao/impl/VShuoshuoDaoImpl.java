package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IVShuoshuoDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.po.Vshuoshuo;

public class VShuoshuoDaoImpl implements IVShuoshuoDao {
	
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	

	public VShuoshuoDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}



	@Override
	public List<Vshuoshuo> select(int userid) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		
		String strSQL="select * from vshuoshuo where userid=? order by staid  desc";
		Object[] params = new Object[] { userid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		
		List<Vshuoshuo> lstVshuoshuo =new ArrayList<Vshuoshuo>();
		
		try {
			while(resultSet.next()){
				Vshuoshuo vshuoshuo = new Vshuoshuo();
				//vdiary.setMdiaryid(resultSet.getInt(1));
				vshuoshuo.setStaid(resultSet.getInt(1));
				vshuoshuo.setUserid(resultSet.getInt(2));
				vshuoshuo.setNickname(resultSet.getString(3));
				vshuoshuo.setSportlabel(resultSet.getString(4));
				vshuoshuo.setUserpho(resultSet.getString(5));
				vshuoshuo.setStacontext(resultSet.getString(6));
				vshuoshuo.setStapubtime(resultSet.getDate(7));
				lstVshuoshuo.add(vshuoshuo);
			}
			return lstVshuoshuo;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}

	}
		
		
	}


