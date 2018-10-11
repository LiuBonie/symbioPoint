package com.symbio.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.symbio.entity.MemberType;
import com.symbio.entity.Membership;
import com.symbio.entity.PointsAccount;
import com.symbio.entity.TransactionDetail;

@WebService(name = "MembershipService")
public interface MembershipService {
	@WebMethod
	Boolean createMemebrship(Membership membership);

	@WebMethod
	Boolean cancelMembership(Long id);

	@WebMethod
	Boolean updateMembership(Membership membership);

	@WebMethod
	List<Membership> getAllMembership();

	@WebMethod
	Membership findMembershipByMembershipId(Long id);

	@WebMethod
	Integer getPointsTotalByMembershipId(Long membershipId);

	@WebMethod
	TransactionDetail getTransactionDetailByMembershipId(Long membershipId);

	@WebMethod
	MemberType getMemberTypeByMembershipId(Long membershipId);
}
