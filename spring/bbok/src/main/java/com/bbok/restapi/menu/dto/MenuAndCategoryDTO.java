package com.bbok.restapi.menu.dto;

public class MenuAndCategoryDTO {

	private int menuCode;
	private CategoryDTO category;
	private String menuName;
	private int menuPrice;
	private String menuDescription;
	private String menuOrderable;
	private String menuImage;
	private int menuStock;
	
	public MenuAndCategoryDTO() {
	}

	public MenuAndCategoryDTO(int menuCode, CategoryDTO category, String menuName, int menuPrice,
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

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
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
