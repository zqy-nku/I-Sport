package test;

import java.util.Date;

import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl;
import com.chinasofti.myproject.po.Activityinvitation;

public class testacti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activityinvitation activityinvitation=new Activityinvitation();
		activityinvitation.setUserid(1);
		activityinvitation.setSportid(2);
		activityinvitation.setActibegtime(new Date());
		activityinvitation.setActiendtime(new Date());
		activityinvitation.setActisettime(new Date());
		activityinvitation.setActiplace("天津");
		activityinvitation.setActiname("啦啦啦");
		activityinvitation.setActicont("hello");
		IActivityinvitationDao dao=new ActivityinvitationDaoImpl();
		int a=dao.insertActivityinvitation(activityinvitation);
		if (a>0) {
			System.out.println("success");
		}else{
			System.out.println("wrong");
		}

	}

}
