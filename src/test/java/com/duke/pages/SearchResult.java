package com.duke.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.duke.base.BaseClass;

public class SearchResult extends BaseClass{
	public WebDriver driver = null;;
	public SearchResult(WebDriver driver) {
		this.driver = BaseClass.getDriver();
		PageFactory.initElements(driver, this);
	}
	By TEXTBOX_SEARCH = By.xpath("//input[@class='search-form-input']");
	
	By LABEL_SEARCH_RESULT_COUNT = By.xpath("//span[@class='object-hed-search-results-count']");
	
	By ARTICLE_COUNT = By.xpath("//*[@itemtype='http://schema.org/Article']");
	
	public void verifySearchResultsDispayed(){
		try {
			Assert.assertTrue(driver.findElements(ARTICLE_COUNT).size()>0);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getSearchResultCount() {
		Assert.assertTrue(getTextOfElement(LABEL_SEARCH_RESULT_COUNT).contains("results"));
	}
	
	public void verifySearchBoxTextOnResultPage(String keyword) {
		Assert.assertTrue(driver.findElement(TEXTBOX_SEARCH).getAttribute("value").contains("Youtube"));
	}
}
