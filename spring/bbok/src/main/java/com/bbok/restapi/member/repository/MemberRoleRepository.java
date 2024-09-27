package com.bbok.restapi.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbok.restapi.member.entity.MemberRole;
import com.bbok.restapi.member.entity.MemberRolePk;

public interface MemberRoleRepository extends JpaRepository<MemberRole, MemberRolePk>{

}
