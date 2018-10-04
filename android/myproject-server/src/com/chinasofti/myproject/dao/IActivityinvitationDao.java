package com.chinasofti.myproject.dao;

import java.util.Date;
import java.util.List;

import com.chinasofti.myproject.po.Activityinvitation;

public interface IActivityinvitationDao {

	public abstract int insertActivityinvitation(final Activityinvitation activityinvitation);
	public abstract int updateActivityinvitation(final  Activityinvitation activityinvitation);
	public abstract List<Activityinvitation> selectAllActivityinvitation();
	public abstract Activityinvitation selectActivityinvitationById(final int actiid);
	public abstract int deleteActivityinvitationById(final int actiid);
	public abstract List<Activityinvitation> selectByActiname(final String actiname);
	public abstract List<Activityinvitation> selectBySportid(final int sportid);
	public abstract List<Activityinvitation> selectByUserid(final int userid);
	public abstract List<Activityinvitation> selectByActibegtime(final Date actibegtime);
	public abstract List<Activityinvitation> selectByActiuserid(final int actiuserid);
	public abstract List<Activityinvitation> sortByActiusercountAsc(final List<Activityinvitation> lstActiinvi);
	public abstract List<Activityinvitation> sortByActiusercountDesc(final List<Activityinvitation> lstActiinvi);

}
