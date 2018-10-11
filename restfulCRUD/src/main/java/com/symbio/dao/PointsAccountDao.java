package com.symbio.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.symbio.entity.Membership;
import com.symbio.entity.PointsAccount;

public interface PointsAccountDao extends DaomianDao<PointsAccount>{
	Session getCurrentSession();
	public PointsAccount getPointsAccount(Long membershipId);
	public void cleanPointsAccount(Date beginDate,Date  endDate);
	public List<PointsAccount> getPointsDetailByDate(Date beginDate,Date endDate);
}
