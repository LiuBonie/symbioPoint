package com.symbio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;


@Entity
@Table(appliesTo = "PointsAccount")
@XmlRootElement    
@XmlType(name = "PointsAccount", namespace = "http://pointsAccount.symbio.com")  
public class PointsAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "POINTS_ACCOUNT_ID")
	private int pointsAccountID;
	
	@Column(name = "PROGRAM_ID",nullable=false)
	private int progamId;// 参加的积分项目
	
	@OneToOne
	@JoinColumn(name="MEMBERSHIP_ID",unique=true)
	private Membership membership;
	
	@Temporal(TemporalType.DATE) 
	@Column(name = "ACCOUNT_START_DTTM")
	private Date accountStartDttm;//积分账号开始时间
	
	@Column(name = "CREATED_BY_ID",nullable=false)
	private String createdById;//   谁创建的记录
	
	@Temporal(TemporalType.DATE) 
	@Column(name = "CREATED_DTTM",nullable=false)
	private Date createDttm;//什么时候创建的
	
	@Column(name = "LAST_UPDATED_BY_ID",nullable=false)
	private String lastUpdateById;//谁update 了记录
	
	@Temporal(TemporalType.DATE) 
	@Column(name = "LAST_UPDATED_DTTM",nullable=false)
	private Date lastUpdateDttm;//update时间
	
	@Column(name = "STATUS_ID",nullable=false)
	private int statusId;//账户状态表示
	
	@Column(name = "PARTNER_MEMBERSHIP_ID")
	private String partnerMembershipId;//会员在第三方公司的id
	
	@Column(name = "PARTNER_COMPANY_ID")
	private  int partnerCompanyId;//第三方公司id
	
	@Column(name = "POINTS_ACCOUNT_TYPE_CD",nullable=false)
	private String pointsAccountTypeCd;//账户类型，譬如是个人账户还是公司账户
	
	@Column(name = "ADD_POINTS_NUM",columnDefinition = "INT default 0")
	private int addPointsNum; //上一次增加积分数
	
	@Column(name = "DE_POINTS_NUM",columnDefinition = "INT default 0")
	private int dePointsNum; //上一次扣除积分数
	
	@Column(name = "POINTS_TOTAL",columnDefinition = "INT default 0")
	private int pointsTotal; //当前积分总额

	public int getPointsAccountID() {
		return pointsAccountID;
	}

	public void setPointsAccountID(int pointsAccountID) {
		this.pointsAccountID=pointsAccountID;
	}
	public Membership getMembership() {
		return membership;
	}


	public void setMembership(Membership membership) {
		this.membership = membership;
	}


	public int getProgamId() {
		return progamId;
	}

	public void setProgamId(int progamId) {
		this.progamId = progamId;
	}

	public Date getAccountStartDttm() {
		return accountStartDttm;
	}

	public void setAccountStartDttm(Date accountStartDttm) {
		this.accountStartDttm = accountStartDttm;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public Date getCreateDttm() {
		return createDttm;
	}

	public void setCreateDttm(Date createDttm) {
		this.createDttm = createDttm;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getPartnerMembershipId() {
		return partnerMembershipId;
	}

	public void setPartnerMembershipId(String partnerMembershipId) {
		this.partnerMembershipId = partnerMembershipId;
	}

	public int getPartnerCompanyId() {
		return partnerCompanyId;
	}

	public void setPartnerCompanyId(int partnerCompanyId) {
		this.partnerCompanyId = partnerCompanyId;
	}

	public String getPointsAccountTypeCd() {
		return pointsAccountTypeCd;
	}

	public void setPointsAccountTypeCd(String pointsAccountTypeCd) {
		this.pointsAccountTypeCd = pointsAccountTypeCd;
	}


	public int getAddPointsNum() {
		return addPointsNum;
	}

	public void setAddPointsNum(int addPointsNum) {
		this.addPointsNum = addPointsNum;
	}

	public int getDePointsNum() {
		return dePointsNum;
	}

	public void setDePointsNum(int dePointsNum) {
		this.dePointsNum = dePointsNum;
	}

	public int getPointsTotal() {
		return pointsTotal;
	}


	public void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
	}


	
	


	

	
}
