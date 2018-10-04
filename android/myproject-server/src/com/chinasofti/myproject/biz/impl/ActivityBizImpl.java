package com.chinasofti.myproject.biz.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.chinasofti.myproject.biz.IActivityBiz;
import com.chinasofti.myproject.dao.IActivityDao;
import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.ISportDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.ActivityDaoImpl;
import com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl;
import com.chinasofti.myproject.dao.impl.PersonDaoImpl;
import com.chinasofti.myproject.dao.impl.SportDaoImpl;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Actihuo;
import com.chinasofti.myproject.po.Activityinvitation;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Sport;
import com.chinasofti.myproject.po.User;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

public class ActivityBizImpl implements IActivityBiz { 
	private IActivityDao activityDao;
	private IUserDao userDao;
	
	
	
	public ActivityBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.activityDao=new ActivityDaoImpl();
		this.userDao=new UserDaoImpl();
	}

	
	@Override
	public List<Actihuo> searchActiBySname(String sportname) {
		// TODO Auto-generated method stub
		return activityDao.selectBySportname(sportname);
	}

	@Override
	public List<Actihuo> searchActiByAname(String actiname) {
		// TODO Auto-generated method stub
		return activityDao.selectByActiname(actiname);
	}

	@Override
	public List<Actihuo> TuiActivity(int userid) {
		// TODO Auto-generated method stub
		List<Actihuo> lstActi=activityDao.selectAll();
		List<Actihuo> tuiActi=new ArrayList<Actihuo>();
		IUserDao userDao=new UserDaoImpl();
		String sportlable=userDao.selectUserById(userid).getSportlabel();
		String[] slable=sportlable.split("/");
		for(Actihuo acti:lstActi){
		String sportid=String.valueOf(acti.getSportid());
		for(int i=0;i<slable.length;i++){
			if(slable[i].equals(sportid)){
				tuiActi.add(acti);
			}
		}
			
		}
		return tuiActi;
		
		
	}

	@Override
	public List<Actihuo> HotActivity() {
		// TODO Auto-generated method stub
		List<Actihuo> lstActi=activityDao.selectAll();
	    Comparator<Actihuo> comparator=new Comparator<Actihuo>(){

		
			public int compare(Actihuo a1, Actihuo a2) {
				// TODO Auto-generated method stub
				//count
				if(a1.getActiusercount()!=a2.getActiusercount()){
					return a2.getActiusercount()-a1.getActiusercount();
				}else{
					if(!a1.getActiname().equals(a1.getActiname())){
						return a2.getActiname().compareTo(a1.getActiname());
					}else{
						return a2.getSportname().compareTo(a1.getSportname());
					}
				}
			}
	    
	    	};
	    Collections.sort(lstActi,comparator);
	    List<Actihuo> lstActi1=new ArrayList<Actihuo>();
	    /*
	    for(int i=0;i<lstActi.size();i++)
	    {
	    	int j=lstActi.size()-i-1;
	    	lstActi1.
	    	lstActi1.add(j, lstActi.get(i));
	    }*/
	    return lstActi;
		
	}

	@Override
	public List<Actihuo> JoinedActivity(int userid) {
		// TODO Auto-generated method stub
		User user=this.userDao.selectUserById(userid);
		String acti=user.getActiid();
		List<Actihuo> resList=new ArrayList<Actihuo>();
		Actihuo activity=new Actihuo();
		if(acti!=null){
		  String[] actiid=acti.split("/");
		  for (int i = 0; i < actiid.length; i++) {
			int aid=Integer.parseInt(actiid[i]);
			activity=this.activityDao.selectByActiid(aid);
			resList.add(activity);
		}
		}
		return resList;
	}

	

}
