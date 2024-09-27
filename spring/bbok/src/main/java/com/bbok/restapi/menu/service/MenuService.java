package com.bbok.restapi.menu.service;

import java.util.List;
import java.util.stream.Collectors;

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
		Pageable paging = PageRequest.of(index, count, Sort.by("MenuCode").descending());
		
		Page<Menu> result = menuRepository.findByMenuOrderable("Y", paging);
		List<Menu> menuList = (List<Menu>)result.getContent();
		
		for(int i = 0 ; i < menuList.size() ; i++) {
			menuList.get(i).setMenuImage(IMAGE_URL + menuList.get(i).getMenuImage());
		}
		
		log.info("[MenuService] selectMenuListWithPaging End ====================================");
		
		return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class));
	}

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

	public Object selectMenuListAboutKorean() {
		log.info("[MenuService] selectMenuListAboutKorean Start====================================");
		
		List<Menu> menuListAboutKorean = menuRepository.findByCategoryCode(1);
		
		for(int i = 0 ; i < menuListAboutKorean.size() ; i++) {
			menuListAboutKorean.get(i).setMenuImage(IMAGE_URL + menuListAboutKorean.get(i).getMenuImage());
		}
		
		log.info("[MenuService] selectMenuListAboutKorean End====================================");
		
		return menuListAboutKorean.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
	}

	public Object selectMenuListAboutChinese() {
		log.info("[MenuService] selectMenuListAboutChinese Start====================================");
		
		List<Menu> menuListAboutChinese = menuRepository.findByCategoryCode(2);
		
		for(int i = 0 ; i < menuListAboutChinese.size() ; i++) {
			menuListAboutChinese.get(i).setMenuImage(IMAGE_URL + menuListAboutChinese.get(i).getMenuImage());
		}
		
		log.info("[MenuService] selectMenuListAboutChinese End====================================");
		
		return menuListAboutChinese.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
	}

	public Object selectMenuListAboutJapanese() {
		log.info("[MenuService] selectMenuListAboutJapanese Start====================================");
		
		List<Menu> menuListAboutJapanese = menuRepository.findByCategoryCode(3);
		
		for(int i = 0 ; i < menuListAboutJapanese.size() ; i++) {
			menuListAboutJapanese.get(i).setMenuImage(IMAGE_URL + menuListAboutJapanese.get(i).getMenuImage());
		}
		
		log.info("[MenuService] selectMenuListAboutJapanese End====================================");
		
		return menuListAboutJapanese.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
	}

	public Object selectMenuListAboutWestern() {
		log.info("[MenuService] selectMenuListAboutWestern Start ========================================");
		
		List<Menu> menuListAboutWestern = menuRepository.findByCategoryCode(4);
		
		for(int i = 0 ; i < menuListAboutWestern.size() ; i++) {
			menuListAboutWestern.get(i).setMenuImage(IMAGE_URL + menuListAboutWestern.get(i).getMenuImage());
		}
		
		log.info("[MenuService] selectMenuListAboutWestern End ========================================");
		
		return menuListAboutWestern.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
	}

	public Object selectMenuListAboutDessert() {
		log.info("[MenuService] selectMenuListAboutDessert Start ========================================");
		
		List<Menu> menuListAboutDessert = menuRepository.findByCategoryCode(5);
		
		for(int i = 0 ; i < menuListAboutDessert.size() ; i++) {
			menuListAboutDessert.get(i).setMenuImage(IMAGE_URL + menuListAboutDessert.get(i).getMenuImage());
		}
		
		log.info("[MenuService] selectMenuListAboutDessert End ========================================");
		
		return menuListAboutDessert.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
	}

	public Object selectMenuListAboutBeverage() {
		log.info("[MenuService] selectMenuListAboutBeverage Start ========================================");
		
		List<Menu> menuListAboutBeverage = menuRepository.findByCategoryCode(6);
		
		for(int i = 0 ; i < menuListAboutBeverage.size() ; i++) {
			menuListAboutBeverage.get(i).setMenuImage(IMAGE_URL + menuListAboutBeverage.get(i).getMenuImage());
		}
		
		log.info("[MenuService] selectMenuListAboutBeverage End ========================================");
		
		return menuListAboutBeverage.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
	}

	public Object selectMenuListAboutEtc() {
		log.info("[MenuService] selectMenuListAboutEtc Start ========================================");
		
		List<Menu> menuListAboutEtc = menuRepository.findByCategoryCode(7);
		
		for(int i = 0 ; i < menuListAboutEtc.size() ; i++) {
			menuListAboutEtc.get(i).setMenuImage(IMAGE_URL + menuListAboutEtc.get(i).getMenuImage());
		}
		
		log.info("[MenuService] selectMenuListAboutEtc End ========================================");
		
		return menuListAboutEtc.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
	}

}
