package com.symbio.dao;

import org.hibernate.Session;

import com.symbio.entity.TransactionDetail;

public interface TransactionDetailDao extends DaomianDao<TransactionDetail>{
	Session getCurrentSession();
	public TransactionDetail getTransactionDetail(Long membershipId);
}
