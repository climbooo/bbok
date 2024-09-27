package com.bbok.restapi.member.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MemberDTO implements UserDetails{

	private int memberCode;
	private String memberName;
	private String memberId;
	private String memberPassword;
	private String memberEmail;
	private List<MemberRoleDTO> memberRole;
	
	public MemberDTO() {
	}

	public MemberDTO(int memberCode, String memberName, String memberId, String memberPassword, String memberEmail,
			List<MemberRoleDTO> memberRole) {
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

	public List<MemberRoleDTO> getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(List<MemberRoleDTO> memberRole) {
		this.memberRole = memberRole;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberCode=" + memberCode + ", memberName=" + memberName + ", memberId=" + memberId
				+ ", memberPassword=" + memberPassword + ", memberEmail=" + memberEmail + ", memberRole=" + memberRole
				+ "]";
	}

	/* 이하 코드들을 UserDetails로부터 물려받는 추상메소드들을 오버라이딩 한 것이다.(필요한 것만 작성하자) */
	/* MemberDTO는 Member와 매핑 될 DTO이자 UserDetails로써 속성을 추가로 가짐 */
	private Collection<GrantedAuthority> authorities; 
	
	/* setter 추가할 것 */
	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	@Override
	public String getPassword() {
		return this.memberPassword;
	}
	@Override
	public String getUsername() {
		return this.memberId;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
