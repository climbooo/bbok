package com.bbok.restapi.menu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bbok.restapi.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

	List<Menu> findByMenuOrderable(String string);

	Page<Menu> findByMenuOrderable(String string, Pageable paging);

	List<Menu> findByMenuNameContaining(String search);

	List<Menu> findByCategoryCode(int i);
	
}
