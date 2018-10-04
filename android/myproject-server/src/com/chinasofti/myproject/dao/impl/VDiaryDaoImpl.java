package com.chinasofti.myproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IVDiaryDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.po.VDiary;

public class VDiaryDaoImpl implements IVDiaryDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	
	public VDiaryDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}


	@Override
	public List<VDiary> select(int userid) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		
		String strSQL="select * from vdiary where userid=? order by mdiaryid  desc";
		Object[] params = new Object[] { userid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		
		List<VDiary> lstVDiary =new ArrayList<VDiary>();
		
		
		try {
			while(resultSet.next()){
				VDiary vdiary = new VDiary();
				vdiary.setMdiaryid(resultSet.getInt(1));
				vdiary.setUserid(resultSet.getInt(2));
				vdiary.setUserpho(resultSet.getString(3));
				vdiary.setSportlabel(resultSet.getString(4));
				vdiary.setMdiarytime(resultSet.getDate(5));
				vdiary.setMdiaryname(resultSet.getString(6));
				vdiary.setMdiarycont(resultSet.getString(7));
				lstVDiary.add(vdiary);
			}
			return lstVDiary;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}

	}
}