package com.symbio.service.impl;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.dao.PointsAccountDao;
import com.symbio.entity.PointsAccount;
import com.symbio.service.PointsManagementService;

@Service("PointsManagementService")
@WebService(endpointInterface = "com.symbio.service.PointsManagementService", targetNamespace = "http://service.symbio.com")
public class PointsManagementServiceImpl implements PointsManagementService {

	@Autowired
	private PointsAccountDao pointsAccountDao;

	@Transactional
	@Override
	public Boolean pointsDeposit(Integer pointsNum, Long memershipId) {
		try {
			PointsAccount pointsAccount = pointsAccountDao.getPointsAccount(memershipId);
			/*
			 * if(pointsAccount.getPointsTotal()==0) {
			 * 
			 * }
			 */
			Integer PointsTotal = pointsAccount.getPointsTotal();
			PointsTotal = PointsTotal + pointsNum;
			pointsAccount.setAddPointsNum(pointsNum);
			pointsAccount.setPointsTotal(PointsTotal);
			pointsAccountDao.put(pointsAccount);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public Boolean pointSpend(Integer pointsNum, Long memershipId) {
		try {
			PointsAccount pointsAccount = pointsAccountDao.getPointsAccount(memershipId);
			Integer PointsTotal = pointsAccount.getPointsTotal();
			PointsTotal = PointsTotal - pointsNum;
			pointsAccount.setPointsTotal(PointsTotal);
			pointsAccount.setDePointsNum(pointsNum);
			pointsAccountDao.put(pointsAccount);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public Boolean transferPoints(Integer pointsNum, Long memershipId1, Long memershipId2) {
		try {
			PointsAccount pointsAccount1 = pointsAccountDao.getPointsAccount(memershipId1);
			Integer PointsTotal1 = pointsAccount1.getPointsTotal();
			PointsTotal1 = PointsTotal1 - pointsNum;
			pointsAccount1.setPointsTotal(PointsTotal1);
			pointsAccountDao.put(pointsAccount1);
			PointsAccount pointsAccount2 = pointsAccountDao.getPointsAccount(memershipId2);
			Integer PointsTotal2 = pointsAccount2.getPointsTotal();
			PointsTotal2 = PointsTotal2 + pointsNum;
			pointsAccount2.setPointsTotal(PointsTotal2);
			pointsAccountDao.put(pointsAccount2);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public Boolean cancelDeposit(Long memershipId) {
		try {
			PointsAccount pointsAccount = pointsAccountDao.getPointsAccount(memershipId);
			Integer addPointsNum = pointsAccount.getAddPointsNum();
			Integer pointsTotal = pointsAccount.getPointsTotal() - addPointsNum;
			pointsAccount.setPointsTotal(pointsTotal);
			pointsAccountDao.put(pointsAccount);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	@Override
	public Boolean cacelSpend(Long memershipId) {
		try {
			PointsAccount pointsAccount = pointsAccountDao.getPointsAccount(memershipId);
			Integer delPointsNum = pointsAccount.getDePointsNum();
			Integer pointsTotal = pointsAccount.getPointsTotal() + delPointsNum;
			pointsAccount.setPointsTotal(pointsTotal);
			pointsAccountDao.put(pointsAccount);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public Boolean cleanPoints(Date beginDate, Date endDate) {
		try {
			pointsAccountDao.cleanPointsAccount(beginDate, endDate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	@Override
	public List<PointsAccount> getPointsDetailByDate(Date beginDate, Date endDate) {
		return pointsAccountDao.getPointsDetailByDate(beginDate, endDate);
	}

}
