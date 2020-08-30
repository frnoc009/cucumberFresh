package StepDefinitions.Login;

import PageElements.Login.LoginElements;
import helpers.Browser;
import helpers.SeleniumHelper;
import io.cucumber.java.en.*;
import javafx.scene.paint.LinearGradient;
import org.openqa.selenium.By;


public class LoginSteps {

    public Browser browser;
    public SeleniumHelper waitHelper;

    public LoginSteps(Browser browser, SeleniumHelper waitHelper){
        this.browser  = browser;
        this.waitHelper = waitHelper;
    }

// Only Given functions will be set here
    @Given("the user is on the Login page")
    public void the_user_is_on_the_login_page() throws Throwable {

        System.out.println("Login page");
        browser.open_browser();
        browser.navigate("https://the-internet.herokuapp.com/login");
    }

    @Given("the user is in the Secure Area page")
    public void the_user_is_on_the_Secure_Area_page() throws Throwable {
        browser.open_browser();
        browser.navigate("https://the-internet.herokuapp.com/login");
        browser.setTextUI(LoginElements.LOGIN_USERNAME.getSelector(), "tomsmith");
        //browser.setTextUI(LoginElements.LOGIN_USERNAME.getQuery()).sendKeys("tomsmith");
        browser.setTextUI(LoginElements.LOGIN_PASSWORD.getSelector(), "SuperSecretPassword");
        //browser.getElements(LoginElements.LOGIN_PASSWORD.getSelector()).sendKeys("SuperSecretPassword!");
        browser.clickUI(LoginElements.LOGIN_BUTTON.getSelector());
        System.out.println("Secure Area page");
    }

// Only And functions will be set here
    @And("enters valid username and valid password")
    public void enters_valid_username_and_valid_password() throws Throwable {
        System.out.println("entered username and password");
        browser.setTextUI(LoginElements.LOGIN_USERNAME.getSelector(), "tomsmith");
        browser.setTextUI(LoginElements.LOGIN_PASSWORD.getSelector(), "SuperSecretPassword");
    }

    @And("enters invalid username and invalid password")
    public void enters_invalid_username_and_invalid_password() throws Throwable {
        System.out.println("entered username and password");
        browser.setTextUI(LoginElements.LOGIN_USERNAME.getSelector(), "Frno009");
        browser.setTextUI(LoginElements.LOGIN_PASSWORD.getSelector(), "Password");
    }

    @And("error message appears")
    public void error_message_appears() throws Throwable {
        System.out.println("Error Message Appeared");
        browser.getElements(LoginElements.LOGIN_ERR_MSG.getSelector());
        browser.close();
        browser.quit();
    }

// Only When functions will be set here
    @When("user clicks the login button")
    public void user_clicks_the_login_button() throws Throwable {
        System.out.println("Login Button clicked");
        browser.clickUI(LoginElements.LOGIN_BUTTON.getSelector());
    }

    @When("user clicks the logout button")
    public void user_clicks_the_logout_button() throws Throwable {
        System.out.println("Logout Button clicked");
        browser.clickUI(LoginElements.LOGOUT_BUTTON.getSelector());
    }

//Only Then functions will be set here
    @Then("the user is navigated to the Secure Area page")
    public void the_user_is_navigated_to_the_secure_area_page() throws Throwable {
        browser.getElements(LoginElements.LOGIN_MSG.getSelector());
        System.out.println("Logged in");
        browser.close();
        browser.quit();
    }

    @Then("the user is navigated to the Login page")
    public void the_user_is_navigated_to_the_login_page() throws Throwable {
        browser.getElements(LoginElements.LOGOUT_MSG.getSelector());
        System.out.println("Logged out");
        browser.close();
        browser.quit();
    }

    @Then("the user is not able to login")
    public void the_user_is_not_able_to_login() throws Throwable {
        System.out.println("Not Able to Login");
        System.out.println(browser.getCurrentUrl());
    }

//Only But functions will be set here
}
