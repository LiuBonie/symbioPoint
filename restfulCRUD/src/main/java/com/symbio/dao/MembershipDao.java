package com.symbio.dao;

import org.hibernate.Session;

import com.symbio.entity.Membership;

public interface MembershipDao extends DaomianDao<Membership>{
	Session getCurrentSession();
}
