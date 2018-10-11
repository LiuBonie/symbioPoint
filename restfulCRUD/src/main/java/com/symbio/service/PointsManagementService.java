package com.symbio.service;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.symbio.entity.PointsAccount;

@WebService(name = "PointsManagementService")
public interface PointsManagementService {

	@WebMethod
	public Boolean pointsDeposit(Integer pointsNum, Long memershipId);// 添加积分

	@WebMethod
	public Boolean pointSpend(Integer pointsNum, Long memershipId);// 花费积分

	@WebMethod
	public Boolean transferPoints(Integer pointsNum, Long memershipId1, Long memershipId2);// 转让积分

	@WebMethod
	public Boolean cancelDeposit(Long memershipId);// 用户取消订单，导致积分回滚 (Cancel order and rollback points)

	@WebMethod
	public Boolean cacelSpend(Long memershipId);// 用户取消订单，导致积分回滚 (Cancel order and rollback points)

	@WebMethod
	public Boolean cleanPoints(Date beginDate, Date endDate);// 清空过期的积 (Empty expired points)

	@WebMethod
	public List<PointsAccount> getPointsDetailByDate(Date beginDate, Date endDate);// 获取某个时间段的积分明细 Get points detail by
																					// some period of time
}
