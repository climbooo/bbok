package com.bbok.restapi.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MENU")
@SequenceGenerator(
		name = "MENU_SEQ_GENERATOR",
		sequenceName = "SEQ_MENU_CODE",
		initialValue = 1, allocationSize = 1
)

public class Menu {

	@Id
	@Column(name = "MENU_CODE")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "MENU_SEQ_GENERATOR"
	)
	private int menuCode;
	
	@Column(name = "CATEGORY_CODE")
	private int categoryCode;
	
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
	
	public Menu() {
	}
	
	public Menu(int menuCode, int categoryCode, String menuName, int menuPrice, String menuDescription,
			String menuOrderable, String menuImage, int menuStock) {
		this.menuCode = menuCode;
		this.categoryCode = categoryCode;
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
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
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
		return "MenuDTO [menuCode=" + menuCode + ", categoryCode=" + categoryCode + ", menuName=" + menuName
				+ ", menuPrice=" + menuPrice + ", menuDescription=" + menuDescription + ", menuOrderable="
				+ menuOrderable + ", menuImage=" + menuImage + ", menuStock=" + menuStock + "]";
	}

}
