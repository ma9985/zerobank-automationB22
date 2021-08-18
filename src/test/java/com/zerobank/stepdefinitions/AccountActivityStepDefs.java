package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class AccountActivityStepDefs {

    BasePage basePage = new BasePage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user navigates to {string} menu")
    public void the_user_navigates_to_menu(String tab) {
        basePage.getTab(tab);
    }

    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String expectedAccount) {
        Assert.assertEquals("expected account is not selected", expectedAccount,
                accountActivityPage.selectedOption());
    }

    @Then("Account drop down should have the following options")
    public void accountDropDownShouldHaveTheFollowingOptions(List<String> expectedOptions) {
        List<String> actualOptions = BrowserUtils.getElementsText(accountActivityPage.accountOptions());
        Assert.assertEquals("accounts do not match", expectedOptions, actualOptions);
    }

    @And("Transactions table should have column names")
    public void transactionsTableShouldHaveColumnNames(List<WebElement> expectedColumns) {
        List<String> actualColumns = BrowserUtils.getElementsText(accountActivityPage.accountColumnNames);
        Assert.assertEquals("columns do not match", expectedColumns, actualColumns);
    }

    @And("if user clicks on {string} link at AccountSummary Page")
    public void ifUserClicksOnLinkAtAccountSummaryPage(String account) {
        Driver.getDriver().findElement(By.linkText(account)).click();
        BrowserUtils.sleep(1);
    }
}

