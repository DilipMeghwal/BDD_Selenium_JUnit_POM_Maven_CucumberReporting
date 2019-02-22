package com.duke.stepDefinations;

import org.openqa.selenium.WebDriver;
import com.duke.pageObjectManager.PageObjectManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps{
	WebDriver driver ;
	PageObjectManager POM = new PageObjectManager(driver);
	
	@Given("User is on Home Page.")
	public void user_is_on_Home_Page() throws Exception {
		POM.getHomePage().checkHomePageOpened();
	}

	@When("User click on Search icon.")
	public void user_click_on_Search__icon() {
		POM.getHomePage().clickOnSearchIcon();
	}

	@Then("Verify an inputbox should be displayed with text \"([^\"]*)\".")
	public void verify_an_inputbox_should_be_displayed_with_text(String message){
		POM.getHomePage().verifySearchBoxText(message);
	}

	@When("User click on Search button.")
	public void user_click_on_Search_button() {
		POM.getHomePage().clickOnSearchButton();
	}

	@When("User enter (.*) and press enter button.")
	public void user_enter_and_press_enter_button(String keyword) {
		POM.getHomePage().enterSearchingKeyword(keyword);
		POM.getHomePage().pressEnterKey();
	}

	@Then("Verify search results displayed.")
	public void verify_search_results_displayed() throws Exception {
		POM.getSearchResult().verifySearchResultsDispayed();
	}

	@Then("Verify search results are displayed having total number of results.")
	public void verify_search_results_are_displayed_having_total_number_of_results() {
		POM.getSearchResult().getSearchResultCount();
	}
	
	@Then("Search box displayed with search results having text (.*).")
	public void search_box_displayed_with_search_results_having_text(String keyword) {
		POM.getSearchResult().verifySearchBoxTextOnResultPage(keyword);
	}
}
