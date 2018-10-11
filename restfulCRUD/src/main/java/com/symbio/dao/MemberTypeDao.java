package com.symbio.dao;

import org.hibernate.Session;

import com.symbio.entity.MemberType;



public interface MemberTypeDao extends DaomianDao<MemberType>{
	Session getCurrentSession();
	public MemberType getMemberType(Long id);
}
