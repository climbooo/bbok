package com.bbok.restapi.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bbok.restapi.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

	Member findByMemberId(String memberId);

	Object findByMemberEmail(String memberEmail);
	
	@Query("SELECT MAX(a.memberCode) FROM Member a")
	int maxMemberCode();


}
