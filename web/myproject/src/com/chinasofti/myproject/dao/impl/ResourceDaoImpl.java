package com.chinasofti.myproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.dao.IResourceDao;
import com.chinasofti.myproject.db.ConnectionManager;
import com.chinasofti.myproject.db.DBUtils;
import com.chinasofti.myproject.db.TransactionManager;
import com.chinasofti.myproject.po.Resource;

import java.sql.*;

public class ResourceDaoImpl implements IResourceDao {
	
	private DBUtils dbUtils;
	private ConnectionManager connectionManager;
	
	public ResourceDaoImpl() {
		super();
		this.dbUtils=new DBUtils();
		this.connectionManager=new ConnectionManager();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int insertResource(Resource resource) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		TransactionManager.conn=connection;
		TransactionManager.beginTransaction();
		String strSQL="insert into resource values(null,?,?,?,?,?)";
		Object[] params=new Object[]{resource.getUserid(),resource.getRestype(),
				resource.getRestime(),resource.getResdesc(),resource.getReslocation()};
		int affectedRows=this.dbUtils.execOthers(connection, strSQL, params);
		if(affectedRows>0){
			TransactionManager.commit();
			return affectedRows;
		}else{
			TransactionManager.rollback();
			return 0;
		}
	}

	

	
	public List<Resource> selectAll() {
		// TODO Auto-generated method stub
		Connection connection =this.connectionManager.openConnection();
		String strSQL="select * from resource order by resid";
		List<Resource> lstResource =new ArrayList<Resource>();
		ResultSet resultSet=this.dbUtils.execQuery(connection, strSQL, new Object[]{});
		try {
			while(resultSet.next()){
				Resource res=new Resource();
				res.setResid(resultSet.getInt(1));
				res.setUserid(resultSet.getInt(2));
				res.setRestype(resultSet.getString(3));
				res.setRestime(resultSet.getDate(4));
				res.setResdesc(resultSet.getString(5));
				res.setReslocation(resultSet.getString(6));
				
				lstResource.add(res);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}

		return lstResource;
	}

	@Override
	public int deleteResourceById(int id) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		TransactionManager.conn=connection;
		TransactionManager.beginTransaction();
		String strSQL="delete from resource where resid=?";
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
	public int updateResource(Resource resource) {
		// TODO Auto-generated method stub
		Connection connection=this.connectionManager.openConnection();
		TransactionManager.conn=connection;
		TransactionManager.beginTransaction();
		String strSQL="update resource set suerid=? restype=? restime=? resdesc=? reslocation=? where resid=?";
		Object[] params=new Object[]{resource.getUserid(),resource.getRestype(),resource.getRestime(),resource.getResdesc(),resource.getReslocation()};
		int affectedRows=this.dbUtils.execOthers(connection, strSQL, params);
		if(affectedRows==1){
			TransactionManager.commit();
			return affectedRows;
		}else{
			TransactionManager.rollback();
			return 0;
		}
		
	}
	@Override
	public List<Resource> selectByUserid(int userid) {
		// TODO Auto-generated method stub
		Connection connection =this.connectionManager.openConnection();
		String strSQL="select * from resource where userid=?";
		List<Resource> lstResource =new ArrayList<Resource>();
		ResultSet resultSet=this.dbUtils.execQuery(connection, strSQL, new Object[]{userid});
		try {
			while(resultSet.next()){
				Resource res=new Resource();
				res.setResid(resultSet.getInt(1));
				res.setUserid(resultSet.getInt(2));
				res.setRestype(resultSet.getString(3));
				res.setRestime(resultSet.getDate(4));
				res.setResdesc(resultSet.getString(5));
				res.setReslocation(resultSet.getString(6));
				
				lstResource.add(res);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}

		return lstResource;
	}
	@Override
	public List<Resource> selectByRestype(String restype) {
		// TODO Auto-generated method stub
		Connection connection =this.connectionManager.openConnection();
		String strSQL="select * from resource where restype=?";
		List<Resource> lstResource =new ArrayList<Resource>();
		ResultSet resultSet=this.dbUtils.execQuery(connection, strSQL, new Object[]{restype});
		try {
			while(resultSet.next()){
				Resource res=new Resource();
				res.setResid(resultSet.getInt(1));
				res.setUserid(resultSet.getInt(2));
				res.setRestype(resultSet.getString(3));
				res.setRestime(resultSet.getDate(4));
				res.setResdesc(resultSet.getString(5));
				res.setReslocation(resultSet.getString(6));
				
				lstResource.add(res);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}

		return lstResource;
	}
	@Override
	public Resource selectById(int resid) {
		// TODO Auto-generated method stub
		Resource res=new Resource();
		Connection connection =this.connectionManager.openConnection();
		String strSQL="select * from resource order by resid";
		ResultSet resultSet=this.dbUtils.execQuery(connection, strSQL, new Object[]{});
		try {
			if (resultSet.next()) {
				res.setResid(resultSet.getInt(1));
				res.setUserid(resultSet.getInt(2));
				res.setRestype(resultSet.getString(3));
				res.setRestime(resultSet.getDate(4));
				res.setResdesc(resultSet.getString(5));
				res.setReslocation(resultSet.getString(6));
				return res;
			} else {
				return null;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
