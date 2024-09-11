package com.bbok.restapi.member.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MEMBER")
@SequenceGenerator(
		name = "MEMBER_SEQ_GENERATOR",
		sequenceName = "SEQ_MEMBER_CODE",
		initialValue = 1, allocationSize = 1
)
public class Member {

	@Id
	@Column(name = "MEMBER_CODE")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "MEMBER_SEQ_GENERATOR"
	)
	private int memberCode;
	
	@Column(name = "MEMBER_NAME")
	private String memberName;
	
	@Column(name = "MEMBER_ID")
	private String memberId;
	
	@Column(name = "MEMBER_PASSWORD")
	private String memberPassword;
	
	@Column(name = "MEMBER_EMAIL")
	private String memberEmail;
	
	@OneToMany
	@JoinColumn(name = "MEMBER_CODE")
	private List<MemberRole> memberRole;
	
	public Member() {
	}

	public Member(int memberCode, String memberName, String memberId, String memberPassword, String memberEmail,
			List<MemberRole> memberRole) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.memberRole = memberRole;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public List<MemberRole> getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(List<MemberRole> memberRole) {
		this.memberRole = memberRole;
	}

	@Override
	public String toString() {
		return "Member [memberCode=" + memberCode + ", memberName=" + memberName + ", memberId=" + memberId
				+ ", memberPassword=" + memberPassword + ", memberEmail=" + memberEmail + ", memberRole=" + memberRole
				+ "]";
	}

		
}
