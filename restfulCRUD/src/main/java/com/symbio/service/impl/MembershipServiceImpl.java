package com.symbio.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.dao.MemberTypeDao;
import com.symbio.dao.MembershipDao;
import com.symbio.dao.PointsAccountDao;
import com.symbio.dao.TransactionDetailDao;
import com.symbio.entity.MemberType;
import com.symbio.entity.Membership;
import com.symbio.entity.PointsAccount;
import com.symbio.entity.TransactionDetail;
import com.symbio.service.MembershipService;

@Service("MembershipService")
@WebService(endpointInterface = "com.symbio.service.MembershipService", targetNamespace = "http://service.symbio.com")
public class MembershipServiceImpl implements MembershipService {

	@Autowired
	private MembershipDao membershipDao;
	@Autowired
	private PointsAccountDao pointsAccountDao;
	@Autowired
	private TransactionDetailDao transactionDetailDao;
	@Autowired
	private MemberTypeDao memberTypeDao;

	// 创建一个会员同时创建一个积分账号
	@Transactional
	@Override
	public Boolean createMemebrship(Membership membership) {

		try {
			PointsAccount p = new PointsAccount();
			p.setMembership(membership);
			membershipDao.post(membership);
			pointsAccountDao.post(p);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 注销会员
	@Transactional
	@Override
	public Boolean cancelMembership(Long id) {
		try {
			membershipDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 更改会员信息
	@Transactional
	@Override
	public Boolean updateMembership(Membership membership) {
		System.out.println(membership);
		try {
			membershipDao.put(membership);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public List<Membership> getAllMembership() {

		return membershipDao.getAll();
	}

	// 通过会员ID查找会员
	@Transactional
	@Override
	public Membership findMembershipByMembershipId(Long memebrshipId) {

		return membershipDao.getById(memebrshipId);
	}

	// 通过会员ID关联查询当前的积分总额
	@Transactional
	@Override
	public Integer getPointsTotalByMembershipId(Long membershipId) {
		return pointsAccountDao.getPointsAccount(membershipId).getPointsTotal();
	}

	// 通过会员ID关联查询具体的消费账单
	@Transactional
	@Override
	public TransactionDetail getTransactionDetailByMembershipId(Long membershipId) {

		return transactionDetailDao.getTransactionDetail(membershipId);
	}

	// 通过会员ID查找当前会员的类型
	@Transactional
	@Override
	public MemberType getMemberTypeByMembershipId(Long membershipId) {
		Membership m = membershipDao.getById(membershipId);
		return memberTypeDao.getMemberType(m.getMemberTypeId());
	}

}
