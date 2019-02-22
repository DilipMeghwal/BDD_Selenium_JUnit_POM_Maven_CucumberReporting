package com.duke.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.duke.base.BaseClass;

public class HomePage extends BaseClass{
	public WebDriver driver = null;;
	public HomePage(WebDriver driver) {
		this.driver = BaseClass.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	By HOME_PAGE_ = By.xpath("(//a[@title='Home']/span[@class='site-navigation__nav-item-label' and contains(text(), 'Home')])[1]");
	
	By ICON_SEARCH = By.xpath("//*[@id='js--nav-search']/span[@title='Search']/span[@class='site-navigation__nav-item-icon']");
	
	By BUTTON_SEARCH = By.xpath("//*[@id='js--nav-search']/span[@title='Search']/span[contains(text(),'Search')]");
	
	By TEXTBOX_SEARCH = By.xpath("//*[@id='form-digg-search-input']");
	
	public void checkHomePageOpened() throws Exception{
		Assert.assertTrue(isElementPresent(BUTTON_SEARCH));
		clickOnElement(HOME_PAGE_);
	}
	
	public void enterSearchingKeyword(String keyword){
		setInputBoxText(TEXTBOX_SEARCH, keyword);
	}
	
	public void clickOnSearchIcon() {
		clickOnElement(ICON_SEARCH);
	}
	
	public void clickOnSearchButton() {
		clickOnElement(BUTTON_SEARCH);
	}
	
	public void verifySearchBoxText(String message) {
		if(driver.findElement(TEXTBOX_SEARCH).getAttribute("placeholder").equals(message)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	public void pressEnterKey() {
		pressEnterKey(TEXTBOX_SEARCH);
	}
}
