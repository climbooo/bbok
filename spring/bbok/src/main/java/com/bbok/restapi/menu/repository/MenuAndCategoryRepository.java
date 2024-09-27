package com.bbok.restapi.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbok.restapi.menu.entity.MenuAndCategory;

public interface MenuAndCategoryRepository extends JpaRepository<MenuAndCategory, Integer>{

}
