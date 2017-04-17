package com.kp.testproject.cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;

import com.kp.testproject.cucumber.model.ListingItem;
import com.kp.testproject.cucumber.pages.HomePage;
import com.kp.testproject.cucumber.pages.SearchResultsPage;

public class UserSteps extends ScenarioSteps {

    HomePage homePage;
    SearchResultsPage searchResultsPage;


    @Step
    public void opens_home_page() {
        homePage.open();
    }

    @Step
    public void searches_by_keyword(String keyword) {
        //homePage.enterSearchTerms(keyword);
        homePage.search();
        homePage.dismissLocationMessage();
    }

    @Step
    public void should_see_results_summary_containing(String keyword) {
        assertThat(searchResultsPage.getSearchHeader()).containsIgnoringCase(keyword);
    }

    @Step
    public void searches_for_shop_called(String shopName, String lastname, String email, String selectIndex) {
        homePage.searchForShopCalled(shopName,lastname, email,selectIndex);
    }

    @Step
    public void should_see_shop_search_result_summary_of(int count, String shopName) {
        assertThat(searchResultsPage.getResultSummary()).containsIgnoringCase(String.valueOf(count)).containsIgnoringCase(shopName);
    }

    @Step
    public ListingItem selects_listing(int articleNumber) {
        return searchResultsPage.selectListing(articleNumber);
    }

    @Step
    public void filters_by_local_region() {
        searchResultsPage.filterByLocalRegion();
    }

    @Step
	public void should_see_submit_button_enabled() {
		// TODO Auto-generated method stub
		homePage.checkForSubmitButtonEnabled();
	}
}
