package com.symbio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "TransactionDetail")
@XmlRootElement
@XmlType(name = "TransactionDetail", namespace = "http://transactionDetail.symbio.com")
public class TransactionDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRANSACTION_ID")
	private int transactionId;

	@Temporal(TemporalType.DATE)
	@Column(name = "TRANS_DETAIL_DTTM", nullable = false)
	private Date transDetailDttm;

	@OneToOne
	@JoinColumn(name = "MEMBERSHIP_ID", unique = true)
	private Membership membershipId;

	@Column(name = "TRANS_TYPE_ID", nullable = false)
	private int transTypeId;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "BATCH_HEADER_ID")
	private int batchHeaderId;

	@Column(name = "REFERENCE_TRANS_DETAIL_ID")
	private int ReferenceTransDetailId;

	@Column(name = "CURRENCY_ID")
	private int currencyId;

	@Column(name = "FEE_AMT", nullable = false)
	private float feeAmt;

	@Column(name = "DISCOUNT_AMT")
	private float discountAmt;

	@Column(name = "TAX_AMT")
	private float taxAmt;

	@Column(name = "NET_AMT", nullable = false)
	private float netAmt;

	@Column(name = "OVERRIDE_AMT")
	private float overrideAmt;

	@Column(name = "OVERRIDE_REASON_CD")
	private String overrideReasonCd;

	@Column(name = "CREATED_BY_ID", nullable = false)
	private String createdById;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DTTM", nullable = false)
	private Date createdDttm;

	@Column(name = "LAST_UPDATED_BY_ID", nullable = false)
	private String lastUpdateById;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_DTTM", nullable = false)
	private Date lastUpdateDttm;

	@Column(name = "PRORATED_AMT")
	private float proratedAmt;

	@Column(name = "TRANS_COMPANY_ID")
	private int transCompanyid;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransDetailDttm() {
		return transDetailDttm;
	}

	public void setTransDetailDttm(Date transDetailDttm) {
		this.transDetailDttm = transDetailDttm;
	}

	public Membership getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Membership membershipId) {
		this.membershipId = membershipId;
	}

	public int getTransTypeId() {
		return transTypeId;
	}

	public void setTransTypeId(int transTypeId) {
		this.transTypeId = transTypeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBatchHeaderId() {
		return batchHeaderId;
	}

	public void setBatchHeaderId(int batchHeaderId) {
		this.batchHeaderId = batchHeaderId;
	}

	public int getReferenceTransDetailId() {
		return ReferenceTransDetailId;
	}

	public void setReferenceTransDetailId(int referenceTransDetailId) {
		ReferenceTransDetailId = referenceTransDetailId;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public float getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(float feeAmt) {
		this.feeAmt = feeAmt;
	}

	public float getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(float discountAmt) {
		this.discountAmt = discountAmt;
	}

	public float getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}

	public float getNetAmt() {
		return netAmt;
	}

	public void setNetAmt(float netAmt) {
		this.netAmt = netAmt;
	}

	public float getOverrideAmt() {
		return overrideAmt;
	}

	public void setOverrideAmt(float overrideAmt) {
		this.overrideAmt = overrideAmt;
	}

	public String getOverrideReasonCd() {
		return overrideReasonCd;
	}

	public void setOverrideReasonCd(String overrideReasonCd) {
		this.overrideReasonCd = overrideReasonCd;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public Date getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(Date createdDttm) {
		this.createdDttm = createdDttm;
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

	public float getProratedAmt() {
		return proratedAmt;
	}

	public void setProratedAmt(float proratedAmt) {
		this.proratedAmt = proratedAmt;
	}

	public int getTransCompanyid() {
		return transCompanyid;
	}

	public void setTransCompanyid(int transCompanyid) {
		this.transCompanyid = transCompanyid;
	}

}