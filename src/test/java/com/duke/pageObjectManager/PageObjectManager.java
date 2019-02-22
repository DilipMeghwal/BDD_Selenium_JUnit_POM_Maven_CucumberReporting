package com.duke.pageObjectManager;

import org.openqa.selenium.WebDriver;

import com.duke.base.BaseClass;
import com.duke.pages.HomePage;
import com.duke.pages.SearchResult;

public class PageObjectManager{
	private WebDriver driver = null;
	public static HomePage homePage = null;
	public static SearchResult searchResult = null;

	public PageObjectManager(WebDriver driver) {
		this.driver = BaseClass.getDriver();
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public SearchResult getSearchResult() {
		return (searchResult == null) ? searchResult = new SearchResult(driver) : searchResult;
	}
}
