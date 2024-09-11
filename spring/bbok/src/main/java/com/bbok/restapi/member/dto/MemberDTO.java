package com.bbok.restapi.member.dto;

public class MemberDTO {

	private int memberCode;
	private String memberName;
	private String memberId;
	private String memberPassword;
	private String memberEmail;
	
	public MemberDTO() {
	}

	public MemberDTO(int memberCode, String memberName, String memberId, String memberPassword, String memberEmail) {
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
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

	@Override
	public String toString() {
		return "MemberDTO [memberCode=" + memberCode + ", memberName=" + memberName + ", memberId=" + memberId
				+ ", memberPassword=" + memberPassword + ", memberEmail=" + memberEmail + "]";
	}
	
	
}
