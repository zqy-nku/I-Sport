package com.chinasofti.myproject.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.dao.IDatedfriendDao;
import com.chinasofti.myproject.dao.IFriendrelationDao;
import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.IPeruserDao;
import com.chinasofti.myproject.dao.ISportDao;
import com.chinasofti.myproject.dao.ISporttreasureDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.DatedfriendDaoImpl;
import com.chinasofti.myproject.dao.impl.FriendrelationDaoImpl;
import com.chinasofti.myproject.dao.impl.PersonDaoImpl;
import com.chinasofti.myproject.dao.impl.PeruserDaoImpl;
import com.chinasofti.myproject.dao.impl.SportDaoImpl;
import com.chinasofti.myproject.dao.impl.SporttreasureDaoImpl;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Datedfriend;
import com.chinasofti.myproject.po.Friendrelation;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Peruser;
import com.chinasofti.myproject.po.Sport;
import com.chinasofti.myproject.po.Sporttreasure;
import com.chinasofti.myproject.po.User;

public class UserBizImpl implements IUserBiz {
	private IUserDao userDao;
	private IPersonDao personDao;
	private ISportDao sportDao;
	private IPeruserDao peruserDao;
	private IFriendrelationDao friendrelationDao;
	
	public UserBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.userDao = new UserDaoImpl();
		this.personDao=new PersonDaoImpl();
		this.sportDao=new SportDaoImpl();
		this.peruserDao=new PeruserDaoImpl();
		this.friendrelationDao=new FriendrelationDaoImpl();
	}

	@Override
	public String findSportlabel(int userid) {
		// TODO Auto-generated method stub
		return this.userDao.findSportlabel(userid);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateUser(user)>0?true:false;
	}

	@Override
	public User findByRegid(int regid) {
		// TODO Auto-generated method stub
		return this.userDao.selectUserByRegid(regid);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.insertUser(user)>0?true:false;
	}

	public List<String> showMylabel(int userid) {
		// TODO Auto-generated method stub
		String sportlabel=this.userDao.findSportlabel(userid);
		List<String> lstSport=new ArrayList<String>();
		String[] slabel=sportlabel.split("/");
		for (int i = 0; i < slabel.length; i++) {
			int sid=Integer.parseInt(slabel[i]);
			String sportname=sportDao.selectById(sid);
			lstSport.add(sportname);
			
			
			
		}
		return lstSport;
	}

	@Override
	public List<Sporttreasure> showMyCollect(int userid) {
		// TODO Auto-generated method stub
		List<Sporttreasure> lstSporttreasures=new ArrayList<Sporttreasure>();
		User user=this.userDao.selectUserById(userid);
		String coll=user.getColletreasid();
		String[] colltr=coll.split("/");
		for (int i = 0; i < colltr.length; i++) {
			ISporttreasureDao sporttreasureDao=new SporttreasureDaoImpl();
			Sporttreasure sporttreasure=sporttreasureDao.selectById(Integer.parseInt(colltr[i]));
			lstSporttreasures.add(sporttreasure);
			
			
		}
		return lstSporttreasures;
		
	}

	@Override
	public List<Peruser> tuiFriend(int userid,int offset,int pageSize) {
		// TODO Auto-generated method stub
		User user=this.userDao.selectUserByRegid(userid);
		List<User> lstuser=this.userDao.selectAllUser();
		List<Peruser> tuifri=new ArrayList<>();
		List<Friendrelation> lstFr=this.friendrelationDao.selectByUserid(userid);
		List<Integer> li=new ArrayList<Integer>();
		for(Friendrelation fr:lstFr){
			int i=fr.getFid();
			li.add(i);
		}
		System.out.println("所有的 好友编号"+li);
		String sportlabel=user.getSportlabel();
		if (sportlabel!=null) {
			String[] slabel=sportlabel.split("/");
			for (int i = 0; i < slabel.length; i++) {
				out: for (User ur:lstuser) {
					String s=ur.getSportlabel();
					String[] sl=s.split("/");
					for (int j = 0; j < sl.length; j++) {
					 if (sl[j].equals(slabel[i])) {
						if(ur.getUserid()==userid){break out;}
						Peruser peruser=new Peruser();
						peruser.setUserid(ur.getUserid());
						Person person=this.personDao.selectPersonById(ur.getRegid());
						peruser.setNickname(person.getNickname());
						peruser.setUserpho(ur.getUserpho());
						peruser.setSportlabel(sl[j]);
						tuifri.add(peruser);
					}
						
					}
				}
				
			}
		}
		List<Peruser> resfri=new ArrayList<>();
		for(int i = 0;i<tuifri.size() && (i < offset+pageSize);i++){
			if(i < offset)
				continue;
			 Peruser peruser=tuifri.get(i);
			 resfri.add(peruser);
			 for(int j = 0;j < resfri.size();j++)
					System.out.println(resfri.get(j));
			
		}
		return resfri;
	}

	@Override
	public List<Peruser> allFriend(int userid,int offset,int pageSize) {
		// TODO Auto-generated method stub
		List<Friendrelation> lstFr=this.friendrelationDao.selectByUserid(userid);
		System.out.println(lstFr.toString());
		List<Peruser> lstPerusers=new ArrayList<Peruser>();
		Peruser peruser=new Peruser();
		if(lstFr!=null){
		out: for (Friendrelation fr:lstFr) {
			int fid=fr.getFid();
			for(Peruser pa:lstPerusers){
				if(fid==pa.getUserid()){
					break out;
				}
			}
			if(fid == userid){break out;}
			peruser=this.peruserDao.selectById(fid);
			System.out.println(peruser);
			lstPerusers.add(peruser);
			
		}
		}
		List<Peruser> resfri=new ArrayList<>();
		for(int i = 0;i<lstPerusers.size() && (i < offset+pageSize);i++){
			if(i < offset)
				continue;
			 peruser=lstPerusers.get(i);
			 resfri.add(peruser);
			 for(int j = 0;j < resfri.size();j++)
					System.out.println(resfri.get(j));
			
		}
		return resfri;
		
	}

	@Override
	public List<Peruser> datedFriend(int userid) {
		// TODO Auto-generated method stub
		IDatedfriendDao datedfriendDao=new DatedfriendDaoImpl();
		List<Datedfriend> lstFri1=datedfriendDao.selectByUserid(userid);
		List<Peruser> lstPerson=new ArrayList<Peruser>();
		if (lstFri1!=null) {
			for(Datedfriend df:lstFri1){
				Peruser peruser=new Peruser();
				peruser.setUserid(df.getFriendid());
				Person person=this.personDao.selectPersonById(df.getFriendid());
				User user=this.userDao.selectUserById(df.getFriendid());
				peruser.setNickname(person.getNickname());
				peruser.setUserpho(user.getUserpho());
				Sport sport=this.sportDao.selectBySportid(df.getDatedtype());
				peruser.setSportlabel(sport.getSportname());
				lstPerson.add(peruser);
			}
		}
		return lstPerson;
	}

	@Override
	public boolean addFriend(Friendrelation friendrelation) {
		// TODO Auto-generated method stub
		IFriendrelationDao friendrelationDao=new FriendrelationDaoImpl();
		return friendrelationDao.insertFriendrelation(friendrelation)>0?true:false;
	}

	@Override
	public List<Peruser> sameFriend(int userid, int fid, int offset,
			int pageSize) {
		// TODO Auto-generated method stub
		List<Friendrelation> lstFr1=this.friendrelationDao.selectByUserid(userid);
		System.out.println(lstFr1.toString());
		List<Friendrelation> lstFr2=this.friendrelationDao.selectByUserid(fid);
		System.out.println(lstFr2.toString());
		List<Peruser> lstPerusers=new ArrayList<Peruser>();
		Peruser peruser=new Peruser();
		if((lstFr1!=null)&&(lstFr2!=null)){
			for(Friendrelation fr1:lstFr1){
				int f1=fr1.getFid();
				for(Friendrelation fr2:lstFr2 ){
					int f2=fr2.getFid();
					if(f1 == f2){
						if((f1!=userid)&&(f1!=fid)){
						peruser=this.peruserDao.selectById(f1);
						System.out.println(peruser);
						lstPerusers.add(peruser);
						}
					}
				}
			}
		}
		List<Peruser> resfri=new ArrayList<>();
		for(int i = 0;i<lstPerusers.size() && (i < offset+pageSize);i++){
			if(i < offset)
				continue;
			 peruser=lstPerusers.get(i);
			 resfri.add(peruser);
			 for(int j = 0;j < resfri.size();j++)
					System.out.println(resfri.get(j));
			
		}
		
		return resfri;
	}

	@Override
	public boolean praise(int userid,int pra) {
		// TODO Auto-generated method stub
		User user=this.userDao.selectUserById(userid);
		int rank=user.getRank();
		int integ=user.getInteg()+pra;
		if(integ>100){
			rank=rank+1;
			integ=integ-100;
		}
		user.setRank(rank);
		user.setInteg(integ);
		int flag=this.userDao.updateUser(user);
		return flag>0?true:false;
	}

	@Override
	public boolean delFriend(int uid, int fid) {
		// TODO Auto-generated method stub
		IFriendrelationDao friendrelationDao=new FriendrelationDaoImpl();
		return friendrelationDao.deleteRelationByUserid(uid, fid)>0?true:false;
	}

	@Override
	public List<Peruser> recomFriend(int userid) {
		// TODO Auto-generated method stub
		User user=this.userDao.selectUserByRegid(userid);
		List<User> lstuser=this.userDao.selectOtherUser(userid);
		List<Peruser> recomfriend=new ArrayList<Peruser>();
		//List<Friendrelation> lstFr=this.friendrelationDao.selectByUserid(userid);
		String sportlabel=user.getSportlabel();
		if(sportlabel != null){
		String[] mylabel = sportlabel.split("/");
		for (User ur:lstuser) {
			String s=ur.getSportlabel();
			for (int i = 0; i < mylabel.length; i++) {
			 if (s.indexOf(mylabel[i])>0) {					
				Peruser peruser=new Peruser();
				peruser.setUserid(ur.getUserid());
				Person person=this.personDao.selectPersonById(ur.getRegid());
				peruser.setNickname(person.getNickname());
				peruser.setUserpho(ur.getUserpho());
				peruser.setSportlabel(ur.getSportlabel());
				peruser.setGender(person.getReggender());
				recomfriend.add(peruser);
				break;
			}
				
		 }
	   }return recomfriend;
	  }else {
		  return null;
		  } 
	}

	@Override
	public List<Peruser> findMyfriend(int userid) {
		// TODO Auto-generated method stub
		List<User> lstuser = this.userDao.selectMyfriend(userid);
		List<Peruser> lstPeruser = new ArrayList<Peruser>();
		if(lstuser != null){
		for (User ur:lstuser) {						
				Peruser peruser=new Peruser();
				Person person=this.personDao.selectPersonById(ur.getRegid());
				//
				peruser.setUserid(ur.getUserid());
				peruser.setNickname(person.getNickname());
				peruser.setUserpho(ur.getUserpho());
				peruser.setSportlabel(ur.getSportlabel());
				peruser.setGender(person.getReggender());
				lstPeruser.add(peruser);			
		 }return lstPeruser;
		}else {
			return null;
		}
	}
}


