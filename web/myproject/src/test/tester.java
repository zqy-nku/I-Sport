package test;

import com.chinasofti.myproject.dao.ICoachDao;
import com.chinasofti.myproject.dao.impl.CoachDaoImpl;
import com.chinasofti.myproject.po.Coach;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICoachDao coachDao=new CoachDaoImpl();
		Coach coach=coachDao.selectByCoaname("ann");
		System.out.println(coach.toString());

	}

}
