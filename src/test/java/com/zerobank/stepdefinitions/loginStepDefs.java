package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class loginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("singin_button")).click();
    }
    @Then("the user enters credentials and logs in")
    public void the_user_enters_credentials_and_logs_in() {
        loginPage.username.sendKeys("username");
        loginPage.password.sendKeys("password");
        loginPage.loginButton.click();
       //BrowserUtils.sleep(1);
        loginPage.resolveUnsecureConnections();
    }
}
