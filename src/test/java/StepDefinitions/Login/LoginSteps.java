package StepDefinitions.Login;

import PageElements.Login.LoginElements;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver = null;
    public void browser() throws Throwable {
        String projectPath=System.getProperty("user.dir");
        System.out.println("Project path is: "+projectPath);
        System.setProperty("webdriver.chrome.driver",
                projectPath+"/src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

// Only Given functions will be set here
    @Given("the user is on the Login page")
    public void the_user_is_on_the_login_page() throws Throwable {
        System.out.println("Login page");
        browser();
        driver.navigate().to("https://the-internet.herokuapp.com/login");

    }

    @Given("the user is in the Secure Area page")
    public void the_user_is_on_the_Secure_Area_page() throws Throwable {
        browser();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        System.out.println("Secure Area page");
    }

// Only And functions will be set here
    @And("enters valid username and valid password")
    public void enters_valid_username_and_valid_password() throws Throwable {
        System.out.println("entered username and password");
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
    }

    @And("enters invalid username and invalid password")
    public void enters_invalid_username_and_invalid_password() throws Throwable {
        System.out.println("entered username and password");
        driver.findElement(By.cssSelector("#username")).sendKeys("Frno009");
        driver.findElement(By.cssSelector("#password")).sendKeys("Password");
    }

    @And("error message appears")
    public void error_message_appears() throws Throwable {
        System.out.println("Error Message Appeared");
        driver.findElement(By.xpath("//div[contains(text(),'Your username is invalid!')]"));
        driver.close();
        driver.quit();
    }

// Only When functions will be set here
    @When("user clicks the login button")
    public void user_clicks_the_login_button() throws Throwable {
        System.out.println("Login Button clicked");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
    }

    @When("user clicks the logout button")
    public void user_clicks_the_logout_button() throws Throwable {
        System.out.println("Logout Button clicked");
        driver.findElement(By.xpath("//a/i[@class='icon-2x icon-signout' and contains(text(),'Logout')]")).click();
    }

//Only Then functions will be set here
    @Then("the user is navigated to the Secure Area page")
    public void the_user_is_navigated_to_the_secure_area_page() throws Throwable {
        driver.findElement(By.xpath("//div[contains(text(),'You logged into a secure area!')]"));
        System.out.println("Logged in");
        driver.close();
        driver.quit();
    }

    @Then("the user is navigated to the Login page")
    public void the_user_is_navigated_to_the_login_page() throws Throwable {
        driver.findElement(By.xpath("//div[contains(text(),'You logged out of the secure area!')]"));
        System.out.println("Logged out");
        driver.close();
        driver.quit();
    }

    @Then("the user is not able to login")
    public void the_user_is_not_able_to_login() throws Throwable {
        System.out.println("Not Able to Login");
        System.out.println(driver.getCurrentUrl());
    }

//Only But functions will be set here
}
