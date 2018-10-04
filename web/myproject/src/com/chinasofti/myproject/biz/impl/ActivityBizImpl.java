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
import com.chinasofti.myproject.po.Activity;
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

	public List<Activity> showAJacti(int userid) {
		// TODO Auto-generated method stub
		IActivityinvitationDao activitiDao=new ActivityinvitationDaoImpl();
		List<Activityinvitation> lstActi=activitiDao.selectAllActivityinvitation();
		List<Activity> joinedActi=new ArrayList<Activity>();
		Activity acti=new Activity();
		out: for(Activityinvitation activity:lstActi){
			String actiuserid=activity.getActiuserid();
			if(actiuserid!=null){
			String[] auid=actiuserid.split("/");
			for (int i = 0; i < auid.length; i++) {
			 String uid=String.valueOf(userid);
			
			if(auid[i].equals(uid)){
				 for(Activity at:joinedActi){
					 if(activity.getActiid() == at.getActiid()){ break out;}
				 }
				acti.setActibegtime(activity.getActibegtime());
				acti.setActicont(activity.getActicont());
				acti.setActidianzan(activity.getActidianzan());
				acti.setActiendtime(activity.getActiendtime());
				acti.setActiid(activity.getActiid());
				acti.setActiname(activity.getActiname());
				acti.setActiplace(activity.getActiplace());
				acti.setActisettime(activity.getActisettime());
				acti.setActiusercount(activity.getActiusercount());
				acti.setRegid(activity.getUserid());
				acti.setSportid(activity.getSportid());
				ISportDao sportDao=new SportDaoImpl();
				Sport sport=sportDao.selectBySportid(activity.getSportid());
				acti.setSportname(sport.getSportname());
				IPersonDao personDao=new PersonDaoImpl();
				Person person=personDao.selectPersonById(activity.getUserid());
				acti.setNickname(person.getNickname());
				joinedActi.add(acti);
			}
			}
		  }
        }
		
		return joinedActi;
	}

	@Override
	public List<Activity> searchActiBySname(String sportname) {
		// TODO Auto-generated method stub
		return activityDao.selectBySportname(sportname);
	}

	@Override
	public List<Activity> searchActiByAname(String actiname) {
		// TODO Auto-generated method stub
		return activityDao.selectByActiname(actiname);
	}

	@Override
	public List<Activity> TuiActivity(int userid) {
		// TODO Auto-generated method stub
		List<Activity> lstActi=activityDao.selectAll();
		List<Activity> tuiActi=new ArrayList<Activity>();
		IUserDao userDao=new UserDaoImpl();
		String sportlable=userDao.selectUserById(userid).getSportlabel();
		String[] slable=sportlable.split("/");
		for(Activity acti:lstActi){
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
	public List<Activity> HotActivity() {
		// TODO Auto-generated method stub
		List<Activity> lstActi=activityDao.selectAll();
	    Comparator<Activity> comparator=new Comparator<Activity>(){

		
			public int compare(Activity a1, Activity a2) {
				// TODO Auto-generated method stub
				//count
				if(a1.getActiusercount()!=a2.getActiusercount()){
					return a1.getActiusercount()-a2.getActiusercount();
				}else{
					if(!a1.getActiname().equals(a2.getActiname())){
						return a1.getActiname().compareTo(a2.getActiname());
					}else{
						return a1.getSportname().compareTo(a2.getSportname());
					}
				}
			}
	    
	    	};
	    Collections.sort(lstActi,comparator);
	    List<Activity> lstActi1=new ArrayList<Activity>();
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
	public List<Activity> JoinedActivity(int userid) {
		// TODO Auto-generated method stub
		User user=this.userDao.selectUserById(userid);
		String acti=user.getActiid();
		List<Activity> resList=new ArrayList<Activity>();
		Activity activity=new Activity();
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
