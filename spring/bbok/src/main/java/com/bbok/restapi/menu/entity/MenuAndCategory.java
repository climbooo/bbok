package com.bbok.restapi.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TBL_MENU")
public class MenuAndCategory {

	@Id
	@Column(name = "MENU_CODE")
	private int menuCode;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_CODE")
	private Category category;
	
	@Column(name = "MENU_NAME")
	private String menuName;
	
	@Column(name = "MENU_PRICE")
	private int menuPrice;
	
	@Column(name = "MENU_DESCRIPTION")
	private String menuDescription;
	
	@Column(name = "MENU_ORDERABLE")
	private String menuOrderable;
	
	@Column(name = "MENU_IMAGE")
	private String menuImage;
	
	@Column(name = "MENU_STOCK")
	private int menuStock;
	
	public MenuAndCategory() {
	}

	public MenuAndCategory(int menuCode, Category category, String menuName, int menuPrice,
			String menuDescription, String menuOrderable, String menuImage, int menuStock) {
		this.menuCode = menuCode;
		this.category = category;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuDescription = menuDescription;
		this.menuOrderable = menuOrderable;
		this.menuImage = menuImage;
		this.menuStock = menuStock;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public String getMenuOrderable() {
		return menuOrderable;
	}

	public void setMenuOrderable(String menuOrderable) {
		this.menuOrderable = menuOrderable;
	}

	public String getMenuImage() {
		return menuImage;
	}

	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}

	public int getMenuStock() {
		return menuStock;
	}

	public void setMenuStock(int menuStock) {
		this.menuStock = menuStock;
	}

	@Override
	public String toString() {
		return "MenuAndCategoryDTO [menuCode=" + menuCode + ", category=" + category + ", menuName=" + menuName
				+ ", menuPrice=" + menuPrice + ", menuDescription=" + menuDescription + ", menuOrderable="
				+ menuOrderable + ", menuImage=" + menuImage + ", menuStock=" + menuStock + "]";
	}

}
