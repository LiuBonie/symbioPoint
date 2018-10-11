package com.symbio.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.dao.MemberTypeDao;
import com.symbio.dao.MembershipDao;
import com.symbio.entity.MemberType;
import com.symbio.entity.Membership;
import com.symbio.entity.PointsAccount;

@Repository("MemberTypeDao")
public class MemberTypeImpl implements MemberTypeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }
	//新建
	@Override
		public int post(MemberType entity) {
			 Session session = this.getCurrentSession();
		    	int num  = (int)session.save(entity); 

				return num; 
		}

		//更新
	@Override
		public void put(MemberType entity) {
			Session session = this.getCurrentSession();
	    	session.update(entity);
	    	session.flush();
		}
		//获取所有信息

		@SuppressWarnings("unchecked")
		@Override
		public List<MemberType> getAll() {
			return this.getCurrentSession().createQuery("from MemberType").setCacheable(true).list();
			
		}

		//根据ID获取信息
		@Override
		public MemberType getById(Long id) {
			Session session = this.getCurrentSession();
			MemberType memberType  =  (MemberType)session.get(MemberType.class,id);

	        return memberType;
		}
		//删除
		@Override
		public void delete(Long id) {
			Session session = this.getCurrentSession();
	        String hql = "delete from MemberType where MEMBERTYPE_ID = :id";
	    	Query query = session.createQuery(hql);
	    	query.setParameter("id",id);
	    	query.executeUpdate();

			
		}
		
		@Override
		public MemberType getMemberType(Long id) {
			Session session = this.getCurrentSession();
			 String hql = "from MemberType where MEMBERSHIP_TYPE_ID = :id";
		    	
			 MemberType memberType= (MemberType)session.createQuery(hql)
		    	        .setParameter("id", id)
		    	        .uniqueResult();
	
				return memberType;
		}

}
