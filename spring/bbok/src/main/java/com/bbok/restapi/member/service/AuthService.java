package com.bbok.restapi.member.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bbok.restapi.exception.DuplicatedMemberEmailException;
import com.bbok.restapi.exception.LoginFailedException;
import com.bbok.restapi.jwt.TokenProvider;
import com.bbok.restapi.member.dto.MemberDTO;
import com.bbok.restapi.member.dto.TokenDTO;
import com.bbok.restapi.member.entity.Member;
import com.bbok.restapi.member.entity.MemberRole;
import com.bbok.restapi.member.repository.MemberRepository;
import com.bbok.restapi.member.repository.MemberRoleRepository;

@Service
public class AuthService {

	private static final Logger log = LoggerFactory.getLogger(AuthService.class);
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenProvider tokenProvider;
	private final ModelMapper modelMapper;
	private final MemberRoleRepository memberRoleRepository;
	
	@Autowired
	public AuthService(MemberRepository memberRepository, PasswordEncoder passwordEncoder
					 , TokenProvider tokenProvider, ModelMapper modelMapper
					 , MemberRoleRepository memberRoleRepository) {
		this.memberRepository = memberRepository;
		this.passwordEncoder = passwordEncoder;
		this.tokenProvider = tokenProvider;
		this.modelMapper = modelMapper;
		this.memberRoleRepository = memberRoleRepository;
	}
	
	public Object login(MemberDTO memberDTO) {
		log.info("[AuthService] Login Start ======================================");
//		log.info("[AuthService] " + memberDTO);
		log.info("[AuthService] {}", memberDTO);
		
		/* 1. 아이디 조회 */
		Member member = memberRepository.findByMemberId(memberDTO.getMemberId());
		
		if(member == null) {
			throw new LoginFailedException(memberDTO.getMemberId() + "를 찾을 수 없습니다.");
		}
		
		/* 2. 비밀번호 매칭(BCrypt 암호화 라이브러리 bean을 의존성 주입받아 처리하는 부분부터 security 설정 부분을 추가해 보자.) */
		/* matches(평문, 다이제스트) */
		if(!passwordEncoder.matches(memberDTO.getMemberPassword(), member.getMemberPassword())) {
			log.info("[AuthService] Password Match Fail!!!");
			throw new LoginFailedException("잘못된 비밀번호 입니다.");
		}
		
		/* 3. 토큰 발급 */
		TokenDTO tokenDTO = tokenProvider.generateTokenDTO(member);
		log.info("[AuthService] tokenDTO {}", tokenDTO);
		
		log.info("[AuthService] Login End ======================================");
		return tokenDTO;
	}

	@Transactional			// DML 작업은 Transactional 어노테이션 추가
	public MemberDTO signup(MemberDTO memberDTO) {
		log.info("[AuthService] Signup Start ==================================");
		log.info("[AuthService] memberDTO {}", memberDTO);
		
		/* 이메일 중복 유효성 검사(선택적) */
		if(memberRepository.findByMemberEmail(memberDTO.getMemberEmail()) != null) {
			log.info("[AuthService] 이메일이 중복됩니다.");
			throw new DuplicatedMemberEmailException("이메일이 중복됩니다.");
		}
		
		/* 우선 repository를 통해 쿼리를 날리기 전에 DTO에 담긴 값을 Entity로 옮기자. */
		Member registMember = modelMapper.map(memberDTO, Member.class);
		
		/* 1. TBL_MEMBER 테이블에 회원 insert */
		/* 비밀번호 암호화 후 insert */
		registMember.setMemberPassword(passwordEncoder.encode(registMember.getMemberPassword()));
		log.info("암호화 테스트: {}", passwordEncoder.encode("1234"));
		Member result1 = memberRepository.save(registMember);		// 반환형이 int값이 아님
		
		/* 2. TBL_MEMBER_ROLE 테이블에 회원별 권한 insert(현재 엔티티에는 회원가입 후 pk값이 없음) */
		/* 2-1. 일반 권한의 회원을 추가(AuthorityCode값이 2번) */
		/* 
		 * 2-2. 엔티티에는 추가 할 회원의 pk값이 아직 없으므로 기존 회원의 마지막 회원 번호를 조회
		 *      (하지만 jpql에 의해 앞선 save와 jpql이 flush()로 쿼리와 함께 날아가고 회원이 이미 sequence객체 값
		 *       증가와 함께 insert가 되 버린다. -> 결론은, maxMemberCode가 현재 가입하는 회원의 번호이다.) 
		 * */
		int maxMemberCode = memberRepository.maxMemberCode();	// jpql을 활용해서 회원번호 max값 추출
		
		MemberRole registMemberRole = new MemberRole(maxMemberCode, 2);
		
		MemberRole result2 = memberRoleRepository.save(registMemberRole);

		log.info("[AuthService] Member Insert Result {}", 
								(result1 != null && result2 != null) ? "회원 가입 성공" : "회원 가입 실패");
		
		log.info("[AuthService] Signup End ==================================");
		return memberDTO;
	}
}
