package com.symbio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "MemberType")
@XmlRootElement
@XmlType(name = "MemberType", namespace = "http://memberType.symbio.com")
public class MemberType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBERTYPE_ID")
	private Integer memberTypeId;

	@Column(name = "MEMBERSHIP_TYPE_ID", nullable = false, unique = true)
	private Integer membershipTypeId;

	@Column(name = "MEMBERTYPE", nullable = false)
	private String memberType;

	public Integer getMemberTypeId() {
		return memberTypeId;
	}

	public void setMemberTypeId(Integer memberTypeId) {
		this.memberTypeId = memberTypeId;
	}

	public Integer getMembershipTypeId() {
		return membershipTypeId;
	}

	public void setMembershipTypeId(Integer membershipTypeId) {
		this.membershipTypeId = membershipTypeId;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
}
