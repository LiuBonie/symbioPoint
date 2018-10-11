package com.symbio.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.dao.MembershipDao;
import com.symbio.entity.Membership;

@Repository("MembershipDao")
public class MembershipImpl implements MembershipDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }
	//新建
	@Override
		public int post(Membership entity) {
			 Session session = this.getCurrentSession();
		    	int num  = (int)session.save(entity); 
		    	session.close();
				return num; 
		}

		//更新
	@Override
		public void put(Membership entity) {
			Session session = this.getCurrentSession();
	    	session.update(entity);
	    	session.flush();
	    	session.close();
		}
		//获取所有信息

		@SuppressWarnings("unchecked")
		@Override
		public List<Membership> getAll() {
			return this.getCurrentSession().createQuery("from Membership").setCacheable(true).list();
			
		}

		//根据ID获取信息
		@Override
		public Membership getById(Long id) {
			Session session = this.getCurrentSession();
			Membership membership  =  (Membership)session.get(Membership.class,id);
	    	session.close();
	        return membership;
		}
		//删除
		@Override
		public void delete(Long id) {
			Session session = this.getCurrentSession();
	        String hql = "delete from Membership where MEMBERSHIP_ID = :id";
	    	Query query = session.createQuery(hql);
	    	query.setParameter("id",id);
	    	query.executeUpdate();
	    	session.close();
			
		}


}
