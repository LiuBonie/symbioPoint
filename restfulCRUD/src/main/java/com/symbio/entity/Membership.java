package com.symbio.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "Membership")
@XmlRootElement
@XmlType(name = "Membership", namespace = "http://membership.symbio.com")
public class Membership implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBERSHIP_ID")
	private Long membershipId;

	@Temporal(TemporalType.DATE)
	@Column(name = "INITIAL_DTTM", nullable = false)
	private Date initialDttm; // 会员开始日期

	@Column(name = "MEMBERSHIP_NUM", nullable = false)
	private String membershipNum;// 会员号码

	@Column(name = "STATUS_ID", nullable = false)
	private int statusId;// 会员状态

	@Column(name = "LAST_UPDATED_BY_ID", nullable = false)
	private String lastUpdateById;// 谁update 了记录

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_DTTM", nullable = false)
	private Date lastUpdateDttm;// update时间

	@Column(name = "CREATED_BY_ID", nullable = false)
	private String createdbyId;// 谁创建的记录

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DTTM", nullable = false)
	private Date createdDttm;// 什么时候创建的

	@Column(name = "ENTERPRISE_CD", nullable = false)
	private String enterpriseCd;// 企业代码

	@Column(name = "PRODUCT_LINE_ID", nullable = false)
	private int productLineId;// 产品代码id

	@Column(name = "EXTERNAL_MEMBERSHIP_ID")
	private String externalMembershipId;// 第三方公司会员id

	@Column(name = "MEMBER_TYPE_ID")
	private int memberTypeId;// 会员类型

	@Column(name = "SOURCE_COMPANY_ID")
	private int sourceCompanyId;// 第三方公司id

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Column(name = "CELL_PHONE", nullable = false)
	private String cellPhone;

	public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}

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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
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

	public int getProductLineId() {
		return productLineId;
	}

	public void setProductLineId(int productLineId) {
		this.productLineId = productLineId;
	}

	public String getExternalMembershipId() {
		return externalMembershipId;
	}

	public void setExternalMembershipId(String externalMembershipId) {
		this.externalMembershipId = externalMembershipId;
	}

	public Long getMemberTypeId() {
		return (long) memberTypeId;
	}

	public void setMemberTypeId(int memberTypeId) {
		this.memberTypeId = memberTypeId;
	}

	public int getSourceCompanyId() {
		return sourceCompanyId;
	}

	public void setSourceCompanyId(int sourceCompanyId) {
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
