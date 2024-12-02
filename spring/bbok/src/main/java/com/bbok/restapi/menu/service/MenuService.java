package com.bbok.restapi.menu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bbok.restapi.common.Criteria;
import com.bbok.restapi.menu.dto.MenuDTO;
import com.bbok.restapi.menu.entity.Menu;
import com.bbok.restapi.menu.repository.MenuAndCategoryRepository;
import com.bbok.restapi.menu.repository.MenuRepository;

@Service
public class MenuService {
	
	private static final Logger log = LoggerFactory.getLogger(MenuService.class);
	private final MenuRepository menuRepository;
	private final MenuAndCategoryRepository menuAndCateogryRepository;
	private final ModelMapper modelMapper;
	
	@Value("${image.image-dir}")
	private String IMAGE_DIR;
	@Value("${image.image-url}")
	private String IMAGE_URL;
	
	
	@Autowired
	public MenuService(MenuRepository menuRepository, MenuAndCategoryRepository menuAndCateogryRepository,
			ModelMapper modelMapper) {
		this.menuRepository = menuRepository;
		this.menuAndCateogryRepository = menuAndCateogryRepository;
		this.modelMapper = modelMapper;
	}

	public int selectMenuTotal() {
		log.info("[MenuService] selectMenuTotal Start ================================");
		
		List<Menu> menuList = menuRepository.findByMenuOrderable("Y");
		
		log.info("MenuService] selectMenuTotal End =================================");
		
		return menuList.size();
	}
	
	public Object selectMenuListWithPaging(Criteria cri) {
		log.info("[MenuService] selectMenuListWithPaging Start ================================");
		
		int index = cri.getPageNum() - 1;
		int count = cri.getAmount();
		Pageable paging = PageRequest.of(index, count, Sort.by("menuCode").descending());
		
		Page<Menu> result = menuRepository.findByMenuOrderable("Y", paging);
		List<Menu> menuList = (List<Menu>)result.getContent();
		
		for(int i = 0 ; i < menuList.size() ; i++) {
			menuList.get(i).setMenuImage(IMAGE_URL + menuList.get(i).getMenuImage());
		}
		
		for(Menu menu : menuList) {
			if(menu.getMenuStock() <= 0) {
				menu.setMenuOrderable("N");
			}
		}
		
		log.info("[MenuService] selectMenuListWithPaging End ====================================");
		
		return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class));
	}
	
//	public Object selectKoreanListWithPaging(Criteria cri) {
//		log.info("[MenuService] selectKoreanListWithPaging Start ================================");
//		
//		int index = cri.getPageNum() - 1;
//		int count = cri.getAmount();
//		Pageable paging = PageRequest.of(index, count, Sort.by("menuCode").descending());
//		
//		log.info("[MenuService] selectKoreanListWithPaging paging: {}", paging);
//		Page<Menu> result = menuRepository.findByCategoryCode(1, paging);
////		Page<Menu> result = menuRepository.findByKoreanMenu(paging);
//		log.info("[MenuService] selectKoreanListWithPaging result: {}", result);
//		List<Menu> koreanList = (List<Menu>)result.getContent();
//		log.info("koreanList: {}", koreanList);
//		
//		
//		for(int i = 0 ; i < koreanList.size() ; i++) {
//			koreanList.get(i).setMenuImage(IMAGE_URL + koreanList.get(i).getMenuImage());
//		}
//		
//		log.info("[MenuService] selectKoreanListWithPaging End ====================================");
//		
//		return koreanList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class));
//	}
//	
//	public Object selectChineseListWithPaging(Criteria cri) {
//		log.info("[MenuService] selectKoreanListWithPaging Start ================================");
//		
//		int index = cri.getPageNum() - 1;
//		int count = cri.getAmount();
//		Pageable paging = PageRequest.of(index, count, Sort.by("menuCode").descending());
//		
//		log.info("[MenuService] selectChineseListWithPaging paging: {}", paging);
//		Page<Menu> result = menuRepository.findByCategoryCode(1, paging);
////		Page<Menu> result = menuRepository.findByChineseMenu(paging);
//		log.info("[MenuService] selectChineseListWithPaging result: {}", result);
//		List<Menu> chineseList = (List<Menu>)result.getContent();
//		log.info("chineseList: {}", chineseList);
//		
//		
//		for(int i = 0 ; i < chineseList.size() ; i++) {
//			chineseList.get(i).setMenuImage(IMAGE_URL + chineseList.get(i).getMenuImage());
//		}
//		
//		log.info("[MenuService] selectChineseListWithPaging End ====================================");
//		
//		return chineseList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class));
//	}

	public Object selectMenu(int menuCode) {
		log.info("[MenuService] selectMenu Start =================================");
		
		Menu menu = menuRepository.findById(menuCode).get();
		menu.setMenuImage(IMAGE_URL + menu.getMenuImage());
		
		log.info("[MenuService] selectMenu End =================================");
		
		return modelMapper.map(menu, Menu.class);
	}

	public Object selectSearchMenuList(String search) {
		log.info("[MenuService] selectSearchMenuList Start =============================");
		log.info("[MenuService] searchValue : " + search);
		
		List<Menu> menuListWithSearchValue = menuRepository.findByMenuNameContaining(search);
		
		log.info("[MenuService] menuListWithSearchValue : " + menuListWithSearchValue);
		
		for(int i = 0 ; i < menuListWithSearchValue.size() ; i++) {
			menuListWithSearchValue.get(i).setMenuImage(IMAGE_URL + menuListWithSearchValue.get(i).getMenuImage());
		}
		
		log.info("[MenuService] selectSearchMenuList End =============================");
		
		return menuListWithSearchValue.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
	}

//	public Object selectMenuListAboutKorean() {
//		log.info("[MenuService] selectMenuListAboutKorean Start====================================");
//		
//		List<Menu> menuListAboutKorean = menuRepository.findByCategoryCode(1);
//		
//		for(int i = 0 ; i < menuListAboutKorean.size() ; i++) {
//			menuListAboutKorean.get(i).setMenuImage(IMAGE_URL + menuListAboutKorean.get(i).getMenuImage());
//		}
//		
//		log.info("[MenuService] selectMenuListAboutKorean End====================================");
//		
//		return menuListAboutKorean.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
//	}
//
//	public Object selectMenuListAboutChinese() {
//		log.info("[MenuService] selectMenuListAboutChinese Start====================================");
//		
//		List<Menu> menuListAboutChinese = menuRepository.findByCategoryCode(2);
//		
//		for(int i = 0 ; i < menuListAboutChinese.size() ; i++) {
//			menuListAboutChinese.get(i).setMenuImage(IMAGE_URL + menuListAboutChinese.get(i).getMenuImage());
//		}
//		
//		log.info("[MenuService] selectMenuListAboutChinese End====================================");
//		
//		return menuListAboutChinese.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
//	}
//
//	public Object selectMenuListAboutJapanese() {
//		log.info("[MenuService] selectMenuListAboutJapanese Start====================================");
//		
//		List<Menu> menuListAboutJapanese = menuRepository.findByCategoryCode(3);
//		
//		for(int i = 0 ; i < menuListAboutJapanese.size() ; i++) {
//			menuListAboutJapanese.get(i).setMenuImage(IMAGE_URL + menuListAboutJapanese.get(i).getMenuImage());
//		}
//		
//		log.info("[MenuService] selectMenuListAboutJapanese End====================================");
//		
//		return menuListAboutJapanese.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
//	}
//
//	public Object selectMenuListAboutWestern() {
//		log.info("[MenuService] selectMenuListAboutWestern Start ========================================");
//		
//		List<Menu> menuListAboutWestern = menuRepository.findByCategoryCode(4);
//		
//		for(int i = 0 ; i < menuListAboutWestern.size() ; i++) {
//			menuListAboutWestern.get(i).setMenuImage(IMAGE_URL + menuListAboutWestern.get(i).getMenuImage());
//		}
//		
//		log.info("[MenuService] selectMenuListAboutWestern End ========================================");
//		
//		return menuListAboutWestern.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
//	}
//
//	public Object selectMenuListAboutDessert() {
//		log.info("[MenuService] selectMenuListAboutDessert Start ========================================");
//		
//		List<Menu> menuListAboutDessert = menuRepository.findByCategoryCode(5);
//		
//		for(int i = 0 ; i < menuListAboutDessert.size() ; i++) {
//			menuListAboutDessert.get(i).setMenuImage(IMAGE_URL + menuListAboutDessert.get(i).getMenuImage());
//		}
//		
//		log.info("[MenuService] selectMenuListAboutDessert End ========================================");
//		
//		return menuListAboutDessert.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
//	}
//
//	public Object selectMenuListAboutBeverage() {
//		log.info("[MenuService] selectMenuListAboutBeverage Start ========================================");
//		
//		List<Menu> menuListAboutBeverage = menuRepository.findByCategoryCode(6);
//		
//		for(int i = 0 ; i < menuListAboutBeverage.size() ; i++) {
//			menuListAboutBeverage.get(i).setMenuImage(IMAGE_URL + menuListAboutBeverage.get(i).getMenuImage());
//		}
//		
//		log.info("[MenuService] selectMenuListAboutBeverage End ========================================");
//		
//		return menuListAboutBeverage.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
//	}
//
//	public Object selectMenuListAboutEtc() {
//		log.info("[MenuService] selectMenuListAboutEtc Start ========================================");
//		
//		List<Menu> menuListAboutEtc = menuRepository.findByCategoryCode(7);
//		
//		for(int i = 0 ; i < menuListAboutEtc.size() ; i++) {
//			menuListAboutEtc.get(i).setMenuImage(IMAGE_URL + menuListAboutEtc.get(i).getMenuImage());
//		}
//		
//		log.info("[MenuService] selectMenuListAboutEtc End ========================================");
//		
//		return menuListAboutEtc.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
//	}

//	public int selectMenuTotalAboutKorean() {
//		log.info("[MenuService] selectMenuTotalAboutKorean Start ========================================");
//		
//		List<Menu> koreanList = menuRepository.findByCategoryCode(1);
//		
//		log.info("koreanList.size(): {}", koreanList.size());
//		
//		log.info("[MenuService] selectMenuTotalAboutKorean End ========================================");
//		
//		return koreanList.size();
//	}
//
//	public int selectMenuTotalAboutChinese() {
//		log.info("[MenuService] selectMenuTotalAboutChinese Start ========================================");
//		
//		List<Menu> chineseList = menuRepository.findByCategoryCode(2);
//		
//		log.info("[MenuService] selectMenuTotalAboutChinese End ========================================");
//		
//		return chineseList.size();
//	}
//
//	public int selectMenuTotalAboutJapanese() {
//		log.info("[MenuService] selectMenuTotalAboutJapanese Start ========================================");
//		
//		List<Menu> japnaeseList = menuRepository.findByCategoryCode(3);
//		
//		log.info("[MenuService] selectMenuTotalAboutJapanese End ========================================");
//		
//		return japnaeseList.size();
//	}
	
//	public int selectMenuTotalAboutWestern() {
//	log.info("[MenuService] selectMenuTotalAboutWestern Start ========================================");
//	
//	List<Menu> westernList = menuRepository.findByCategoryCode(4);
//	
//	log.info("[MenuService] selectMenuTotalAboutWestern End ========================================");
//	
//	return westernList.size();
//	}
//
//	public int selectMenuTotalAboutDessert(int i) {
//	log.info("[MenuService] selectMenuTotalAboutDessert Start ========================================");
//	
//	List<Menu> westernList = menuRepository.findByCategoryCode(i);
//	
//	log.info("[MenuService] selectMenuTotalAboutDessert End ========================================");
//	
//	return westernList.size();
//	}

	public int selectMenuTotalAboutCategory(int i) {
		log.info("[MenuService] selectMenuTotalAboutCategory Start ========================================");
		
		List<Menu> menuList = menuRepository.findByCategoryCode(i);
		
		log.info("menuList.size(): {} ", menuList.size());
		
		log.info("[MenuService] selectMenuTotalAboutCategory End ========================================");
		
		return menuList.size();
	}

	public Object selectMenuListWithCategoryAndPaging(int categoryCode, Criteria cri) {
		log.info("[MenuService] selectMenuListWithCategoryAndPaging Start ================================");
		
		int index = cri.getPageNum() - 1;
		int count = cri.getAmount();
		Pageable paging = PageRequest.of(index, count, Sort.by("menuCode").descending());
		
		log.info("[MenuService] selectJapaneseListWithPaging paging: {}", paging);
		Page<Menu> result = menuRepository.findByCategoryCode(categoryCode, paging);
//		Page<Menu> result = menuRepository.findByChineseMenu(paging);
		log.info("[MenuService] selectJapaneseListWithPaging result: {}", result);
		List<Menu> menuList = (List<Menu>)result.getContent();
		log.info("menuList: {}", menuList);
		
		
//		for (Menu menu : menuList) {
//		    if (menu.getMenuStock() <= 0) {
////		        menuStock.add(menu);
//		        menu.setMenuImage(IMAGE_URL + "nomenustock.png");
//		    } else {
//		        menu.setMenuImage(IMAGE_URL + menu.getMenuImage());
//		    }
//		}
		
		for (Menu menu : menuList) {
		    if (menu.getMenuStock() <= 0) {
		    	menu.setMenuOrderable("N");
		    } if (menu.getMenuOrderable() == "N") {
		    	menu.setMenuImage(IMAGE_URL + "nomenustock.png");
		    } else {
		    	menu.setMenuImage(IMAGE_URL + menu.getMenuImage());
		    }
		}
//		List<Menu> menuStock = menuList.stream().filter(menu -> menu.getMenuStock() <= 0).collect(Collectors.toList());
//		log.info("menuStock: {}", menuStock);
		
//		for(int i = 0 ; i < menuList.size() ; i++) {
//			menuList.get(i).setMenuImage(IMAGE_URL + menuList.get(i).getMenuImage());
//		}
//		
//		for(int i = 0 ; i < menuStock.size() ; i++) {
//			menuStock.get(i).setMenuImage(IMAGE_URL + "nomenustock.png");
//		}
//		Menu findMenu = menuList.get(0);
//		
//		log.info("findMenu: {}", findMenu);
		
//		int menuStock = findMenu.getMenuStock();
		
//		for(int i = 0 ; i < menuList.size() ; i++) {
//			if(menuList.stream().filter(menu -> menu.getMenuStock() <= 0).collect(Collectors.toList())) {
//				menuList.get(i).setMenuImage(IMAGE_URL + menuList.get(i).getMenuImage());
//				log.info("메뉴 수량 있음");
//			} else {
//				menuList.get(i).setMenuImage(IMAGE_URL + "/nomenustock.png");
//				log.info("메뉴 수량 없음");
//			}
//		}
		
//		for(int i = 0 ; i < menuList.size() ; i++) {
//			if(menuStock.) {
//				menuList.get(i).setMenuImage(IMAGE_URL + "/nomenustock.png");
//				log.info("메뉴 수량 없음");
//			} else {
//				menuList.get(i).setMenuImage(IMAGE_URL + menuList.get(i).getMenuImage());
//				log.info("메뉴 수량 있음");
//			}
//		}
		
		
		log.info("[MenuService] selectMenuListWithCategoryAndPaging End ====================================");
		
		return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class));
	}
}
