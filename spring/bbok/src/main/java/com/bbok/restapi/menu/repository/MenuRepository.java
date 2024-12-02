package com.bbok.restapi.menu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bbok.restapi.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

	List<Menu> findByMenuOrderable(String string);

	Page<Menu> findByMenuOrderable(String string, Pageable paging);

	List<Menu> findByMenuNameContaining(String search);

	List<Menu> findByCategoryCode(int i);

//	@Query(value = "SELECT * FROM TBL_MENU A WHERE A.CATEGORY_CODE = 1 AND A.MENU_ORDERABLE = 'Y'", nativeQuery = true)
//	List<Menu> findByKoreanMenu();

//	@Query(value = "SELECT * FROM TBL_MENU A WHERE A.CATEGORY_CODE = 1 AND A.MENU_ORDERABLE = 'N'", nativeQuery = true)
//	Page<Menu> findByKoreanMenu(Pageable paging);

	Page<Menu> findByCategoryCode(int i, Pageable paging);

//	@Query(value = "SELECT a.* FROM TBL_MENU a WHERE a.CATEGORY_CODE = 2", nativeQuery = true)
//	List<Menu> findByKoreanMenu();

	@Query(value = "SELECT m FROM Menu m WHERE m.categoryCode = 1")
	Page<Menu> findByKoreanMenu(Pageable paging);

	@Query(value = "SELECT m FROM Menu m WHERE m.categoryCode = 2")
	Page<Menu> findByChineseMenu(Pageable paging);





	
}
