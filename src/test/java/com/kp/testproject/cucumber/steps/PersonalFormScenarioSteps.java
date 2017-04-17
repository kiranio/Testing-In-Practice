package com.kp.testproject.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.Inflector;

import java.text.ParseException;

import com.kp.testproject.cucumber.steps.serenity.UserSteps;

public class PersonalFormScenarioSteps {
    @Steps
    UserSteps user;

    @Given("I (?:want|would like) to buy (.*)")
    public void buyerWantsToBuy(String article) {
        user.opens_home_page();
    }

    @When("I search for '(.*)'")
    public void searchByKeyword(String keyword) {
        user.searches_by_keyword(keyword);
    }

    @Then("I should see only articles related to '(.*)'")
    public void resultsForACategoryAndKeywordInARegion(String keyword) throws ParseException {
        user.should_see_results_summary_containing(keyword);
    }

    @Given("^I am logged in as an user$")
    public void givenIWantToSeeArticlesFromAParticularShop() {
        user.opens_home_page();
    }

    @When("^I fill the form with the details as '(.*)' and '(.*)' and '(.*)' and '(.*)'")
    public void whenISearchByShopFor(String shopName,String lastname, String email, String selectIndex) {
       // buyer.should_see_nonexistant_field();
        user.searches_for_shop_called(shopName,lastname, email,selectIndex);
    }
    

    @Then("I should find (\\d+) (?:shop|shops) called '(.*)'")
    public void thenIShouldFindShopsCall(int count, String shopName) {
        user.should_see_shop_search_result_summary_of(count, shopName);
    }

    @Then("^I should find submit button enabled$")
    public void i_should_find_submit_button_enabled() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    	 user.should_see_submit_button_enabled();
    }

    private String pluralized(int count, String word) {
        return Inflector.getInstance().pluralize(word, count);

    }
}


