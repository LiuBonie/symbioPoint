package com.symbio.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Table;


public class MembershipVo {
	

	private Date initialDttm; //会员开始日期
	
	private String membershipNum;//会员号码
	
	private String statusId;//会员状态
	
	private String lastUpdateById;//谁update 了记录

	private Date lastUpdateDttm;//update时间

	private String createdbyId;//   谁创建的记录

	private Date createdDttm;//什么时候创建的
	
	private String enterpriseCd;//企业代码
	
	private String productLineId;// 产品代码id
	
	private String externalMembershipId;//第三方公司会员id
	
	private String memberTypeId ;//会员类型
	
	private String sourceCompanyId;//第三方公司id
	
	private String lastName   ;
	
	private String firstName ;
	
	private String email;
	
	private String address ;

	private String cellPhone ;

	public Date getInitialDttm() {
		return initialDttm;
	}

	public void setInitialDttm(Date initialDttm) {
		this.initialDttm = initialDttm;
	}

	public String getMembershipNum() {
		return membershipNum;
	}

	public void setMembershipNum(String membershipNum) {
		this.membershipNum = membershipNum;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getLastUpdateById() {
		return lastUpdateById;
	}

	public void setLastUpdateById(String lastUpdateById) {
		this.lastUpdateById = lastUpdateById;
	}

	public Date getLastUpdateDttm() {
		return lastUpdateDttm;
	}

	public void setLastUpdateDttm(Date lastUpdateDttm) {
		this.lastUpdateDttm = lastUpdateDttm;
	}

	public String getCreatedbyId() {
		return createdbyId;
	}

	public void setCreatedbyId(String createdbyId) {
		this.createdbyId = createdbyId;
	}

	public Date getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(Date createdDttm) {
		this.createdDttm = createdDttm;
	}

	public String getEnterpriseCd() {
		return enterpriseCd;
	}

	public void setEnterpriseCd(String enterpriseCd) {
		this.enterpriseCd = enterpriseCd;
	}

	public String getProductLineId() {
		return productLineId;
	}

	public void setProductLineId(String productLineId) {
		this.productLineId = productLineId;
	}

	public String getExternalMembershipId() {
		return externalMembershipId;
	}

	public void setExternalMembershipId(String externalMembershipId) {
		this.externalMembershipId = externalMembershipId;
	}

	public String getMemberTypeId() {
		return memberTypeId;
	}

	public void setMemberTypeId(String memberTypeId) {
		this.memberTypeId = memberTypeId;
	}

	public String getSourceCompanyId() {
		return sourceCompanyId;
	}

	public void setSourceCompanyId(String sourceCompanyId) {
		this.sourceCompanyId = sourceCompanyId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	
}
