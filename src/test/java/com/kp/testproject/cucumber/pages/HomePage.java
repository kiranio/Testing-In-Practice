package com.kp.testproject.cucumber.pages;

import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://demos.scotch.io/angular-formly-car-rental/demos/")
public class HomePage extends PageObject {

    @FindBy(xpath="//button[@type='submit']")
    WebElementFacade submitButton;

    private final static String SHOP_SUGGESTION = "//div[@id='search-suggestions']//div[@class='as-suggestion']//*[contains(.,'find shop names containing')]";
    private final static String SHOP_SUGGESTION_SHOP_NAME = "//div[@id='search-suggestions']//div[@class='as-suggestion']/span[2]";
    
    public void enterSearchTerms(String keyword, String lastname,  String email,String selectIndex) {
    	$("#formly_1_input_first_name_0").type(keyword);
    	$("#formly_1_input_last_name_1").type(lastname);
    	$("#formly_1_input_email_2").type(email);
    	//$("#formly_1_select_province_4").selectByValue("Ontario");	
    	$("#formly_1_select_province_4").selectByVisibleText(selectIndex);
    	$("#formly_1_input_license_5").type("A1234-12345-12345");	
    }

    private void waitForKeywordToBeUpdatedTo(String keyword) {
        waitForCondition()
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(250,TimeUnit.MILLISECONDS)
                .until(keywordFieldIsUpdatedTo(keyword));
    }

    private Function<? super WebDriver, Boolean> keywordFieldIsUpdatedTo(String keyword) {
        return webDriver -> $("#search-query").getValue().equalsIgnoreCase(keyword);
    }

    public void search() {
        submitButton.click();
    }

    public void searchForShopCalled(String shopName, String lastname,  String email,String selectIndex) {
        enterSearchTerms(shopName, lastname, email, selectIndex);
       // $(SHOP_SUGGESTION_SHOP_NAME).click();
    }
    
    public void checkForSubmitButtonEnabled() {
    	//submitButton.waitUntilEnabled();
    	submitButton.shouldBeEnabled();
    }

    public void dismissLocationMessage() {
        if (!findAll(By.cssSelector("input[value='Okay']")).isEmpty()) {
            find(By.cssSelector("input[value='Okay']")).click();
        }
    }
}
