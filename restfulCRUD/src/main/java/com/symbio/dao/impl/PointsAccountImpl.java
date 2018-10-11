package com.symbio.dao.impl;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.dao.PointsAccountDao;
import com.symbio.entity.PointsAccount;


@Repository("PointsAccountDao") 
public  class PointsAccountImpl implements PointsAccountDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }
	//新建
	@Override
	public int post(PointsAccount entity) {
		 Session session = this.getCurrentSession();
	    	int num  = (int)session.save(entity);
	    	session.close();
			return num; 
	}

	//更新
	@Override
	public void put(PointsAccount entity) {
		Session session = this.getCurrentSession();
    	Transaction tx = session.beginTransaction();
    	session.update(entity);
    	tx.commit();
		
	}
	//获取所有信息
	@Override
	@SuppressWarnings("unchecked")
	public List<PointsAccount> getAll() {
		return this.getCurrentSession().createQuery("from Points_account").setCacheable(true).list();
		
	}
	//根据ID获取信息
	@Override
	public PointsAccount getById(Long id) {
		Session session = this.getCurrentSession();
		PointsAccount PointsAccount  =  (PointsAccount)session.get(PointsAccount.class,id);
    	session.close();
        return PointsAccount;
	}
	//删除
	@Override
	public void delete(Long id) {
		Session session = this.getCurrentSession();
        String hql = "delete from PointsAccount where PROGRAM_ID = :id";
    	Query query = session.createQuery(hql);
    	query.setParameter("id",id);
    	query.executeUpdate();
		
	}
	//根据会员id获取PointsAccount
	@Override
	public PointsAccount getPointsAccount(Long membershipId) {
		Session session = this.getCurrentSession();
		 String hql = "from PointsAccount where MEMBERSHIP_ID = :id";
	    	
	    	PointsAccount pointsAccountint= (PointsAccount)session.createQuery(hql)
	    	        .setParameter("id", membershipId)
	    	        .uniqueResult();	    
			return pointsAccountint;
	}
	
	//根据beginDate和endDate删除LAST_UPDATED_DTTM在这之间的PointsAccount
	@Override
	public void cleanPointsAccount(Date beginDate,Date endDate) {
		Session session = this.getCurrentSession();
		String hql = "delete from PointsAccount where LAST_UPDATED_DTTM between :beginDate and :endDate";
		Query query = session.createQuery(hql);
    	query.setParameter("beginDate", beginDate);
    	query.setParameter("endDate", endDate);
    	query.executeUpdate();
	}
	//根据beginDate和endDate获取LAST_UPDATED_DTTM在这之间的PointsAccount
	@Override
	@SuppressWarnings("unchecked")
	public List<PointsAccount> getPointsDetailByDate(Date beginDate,Date endDate){
		Session session = this.getCurrentSession();
		String hql = "from PointsAccount where LAST_UPDATED_DTTM between :beginDate and :endDate";
		return session.createQuery(hql).setParameter("beginDate", beginDate)
    								   .setParameter("endDate", endDate)
    								   .list();	
		
		
	}
}
