package com.bbok.restapi.menu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbok.restapi.common.Criteria;
import com.bbok.restapi.common.PageDTO;
import com.bbok.restapi.common.PagingResponseDTO;
import com.bbok.restapi.common.ResponseDTO;
import com.bbok.restapi.menu.service.MenuService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class MenuController {

	private static final Logger log = LoggerFactory.getLogger(MenuController.class);
	
	private final MenuService menuService;

	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@Operation(summary = "메뉴 리스트 조회 요청", description = "메뉴 조회 및 페이징 처리가 진행됩니다.", tags = { "MenuController" })
	@GetMapping("/menus")
	public ResponseEntity<ResponseDTO> selectMenuListWithPaging(@RequestParam(name = "offset", defaultValue = "1") String offset) {
		
		log.info("[MenuController] selectMenuListWithPaging : " + offset);
		
		int total = menuService.selectMenuTotal();
		
		Criteria cri = new Criteria(Integer.valueOf(offset), 10);
		PagingResponseDTO pagingResponseDTO = new PagingResponseDTO();
		
		pagingResponseDTO.setData(menuService.selectMenuListWithPaging(cri));
		
		pagingResponseDTO.setPageInfo(new PageDTO(cri, total));
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", pagingResponseDTO));
	}
	
	@Operation(summary = "메뉴 상세 조회 요청", description = "메뉴의 상세 페이지 처리가 진행됩니다.", tags = { "MenuController" })
	@GetMapping("/menus/{menuCode}")
	public ResponseEntity<ResponseDTO> selectMenuDetail(@PathVariable int menuCode) {
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "메뉴 상세 정보 조회 성공", menuService.selectMenu(menuCode)));
	}
	
	@Operation(summary = "검색 메뉴 리스트 조회 요청", description = "검색어에 해당되는 메뉴 리스트 조회가 진행됩니다. ", tags = { "MenuController" })
	@GetMapping("/menus/search")
	public ResponseEntity<ResponseDTO> selectSearchMenuList(@RequestParam(name = "s", defaultValue = "all") String search) {
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", menuService.selectSearchMenuList(search)));
	}
	
	@Operation(summary = "한식 리스트 조회 요청", description = "한식 카테고리에 해당하는 메뉴 리스트가 조회가 진행됩니다.", tags = { "MenuController" })
	@GetMapping("/menus/korean")
	public ResponseEntity<ResponseDTO> selectMenuListAboutKorean(@RequestParam(name = "offset", defaultValue = "1") String offset) {
		log.info("[MenuController] selectMenuListWithPaging : " + offset);
		
		int total = menuService.selectMenuTotalAboutKorean();
		
		Criteria cri = new Criteria(Integer.valueOf(offset), 10);
		PagingResponseDTO pagingResponseDTO = new PagingResponseDTO();
		
		pagingResponseDTO.setData(menuService.selectKoreanListWithPaging(cri));
		
		pagingResponseDTO.setPageInfo(new PageDTO(cri, total));
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", pagingResponseDTO));
	}
	
//	@Operation(summary = "한식 리스트 조회 요청", description = "한식 카테고리에 해당하는 메뉴 리스트가 조회가 진행됩니다.", tags = { "MenuController" })
//	@GetMapping("/menus/korean")
//	public ResponseEntity<ResponseDTO> selectMenuListAboutKorean() {
//		
//		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", menuService.selectMenuListAboutKorean()));
//	}
	
	@Operation(summary = "중식 리스트 조회 요청", description = "중식 카테고리에 해당하는 메뉴 리스트가 조회가 진행됩니다.", tags = { "MenuController" })
	@GetMapping("/menus/chinese")
	public ResponseEntity<ResponseDTO> selectMenuListAboutChinese() {
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", menuService.selectMenuListAboutChinese()));
	}
	
	@Operation(summary = "일식 리스트 조회 요청", description = "일식 카테고리에 해당하는 메뉴 리스트가 조회가 진행됩니다.", tags = { "MenuController" })
	@GetMapping("/menus/japanese")
	public ResponseEntity<ResponseDTO> selectMenuListAboutJapanese() {
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", menuService.selectMenuListAboutJapanese()));
	}
	
	@Operation(summary = "양식 리스트 조회 요청", description = "양식 카테고리에 해당하는 메뉴 리스트가 조회가 진행됩니다.", tags = { "MenuController" })
	@GetMapping("/menus/Western")
	public ResponseEntity<ResponseDTO> selectMenuListAboutWestern() {
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", menuService.selectMenuListAboutWestern()));
	}
	
	@Operation(summary = "디저트 리스트 조회 요청", description = "디저트 카테고리에 해당하는 메뉴 리스트가 조회가 진행됩니다.", tags = { "MenuController" })
	@GetMapping("/menus/dessert")
	public ResponseEntity<ResponseDTO> selectMenuListAboutDessert() {
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", menuService.selectMenuListAboutDessert()));
	}
	
	@Operation(summary = "음료 리스트 조회 요청", description = "음료 카테고리에 해당하는 메뉴 리스트가 조회가 진행됩니다.", tags = { "MenuController" })
	@GetMapping("/menus/beverage")
	public ResponseEntity<ResponseDTO> selectMenuListAboutBeverage() {
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", menuService.selectMenuListAboutBeverage()));
	}
	
	@Operation(summary = "기타 리스트 조회 요청", description = "기타 카테고리에 해당하는 메뉴 리스트가 조회가 진행됩니다.", tags = { "MenuController" })
	@GetMapping("/menus/etc")
	public ResponseEntity<ResponseDTO> selectMenuListAboutEtc() {
		
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", menuService.selectMenuListAboutEtc()));
	}
}
