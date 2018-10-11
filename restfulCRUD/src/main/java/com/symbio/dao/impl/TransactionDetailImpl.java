package com.symbio.dao.impl;


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

import com.symbio.dao.DaomianDao;
import com.symbio.dao.PointsAccountDao;
import com.symbio.dao.TransactionDetailDao;
import com.symbio.entity.PointsAccount;
import com.symbio.entity.TransactionDetail;


@Repository("TransactionDetailDao")
public  class TransactionDetailImpl implements TransactionDetailDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }
	//新建
	@Override
	public int post(TransactionDetail entity) {
		 Session session = this.getCurrentSession();
	    	int num  = (int)session.save(entity);
	    	session.close();
			return num; 
	}

	//更新
	@Override
	public void put(TransactionDetail entity) {
		Session session = this.getCurrentSession();
    	Transaction tx = session.beginTransaction();
    	session.update(entity);
    	tx.commit();
		
	}
	//获取所有信息
	@Override
	@SuppressWarnings("unchecked")
	public List<TransactionDetail> getAll() {
		return this.getCurrentSession().createQuery("from TransactionDetail").setCacheable(true).list();
		
	}
	//根据ID获取信息
	@Override
	public TransactionDetail getById(Long id) {
		Session session = this.getCurrentSession();
		TransactionDetail TransactionDetail  =  (TransactionDetail)session.get(TransactionDetail.class,id);
    	session.close();
        return TransactionDetail;
	}
	//删除
	@Override
	public void delete(Long id) {
		Session session = this.getCurrentSession();
        String hql = "delete from TransactionDetail where TRANSACTION_ID = :id";
    	Query query = session.createQuery(hql);
    	query.setParameter("id",id);
    	query.executeUpdate();
    	session.close();
		
	}
	//通过会员ID关联查询具体的消费账单
	@Override
	public TransactionDetail getTransactionDetail(Long membershipId) {
		Session session = this.getCurrentSession();
		 String hql = "from TransactionDetail where MEMBERSHIP_ID = :id";
		 TransactionDetail transactionDetail= (TransactionDetail)session.createQuery(hql)
	    	        .setParameter("id", membershipId)
	    	        .uniqueResult();
	    	session.close();
		return transactionDetail;
		
	}


}
