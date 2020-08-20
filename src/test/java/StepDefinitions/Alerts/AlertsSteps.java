package StepDefinitions.Alerts;

import org.openqa.selenium.Alert;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class AlertsSteps {

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
    @Given("the user is on the JavaScript Alerts page")
    public void the_user_is_on_the_java_script_alerts_page() throws Throwable {
        System.out.println("Java Script Alert page");
        browser();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
    }

// Only When functions will be set here
    @When("user clicks JS Alert button")
    public void user_clicks_js_alert_button() throws Throwable {
        System.out.println("JS Alert Button clicked");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
    }

    @When("user clicks JS Confirm button")
    public void user_clicks_js_confirm_button() throws Throwable {
        System.out.println("JS Confirm Button clicked");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
    }

    @When("user clicks JS Prompt button")
    public void user_clicks_js_prompt_button() throws Throwable {
        System.out.println("JS Prompt Button clicked");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
    }

//Only Then functions will be set here
    @Then("a JS alert box is displayed")
    public void a_JS_alert_box_is_displayed() throws Throwable {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.xpath("//p[@id='result' and text()='You successfuly clicked an alert']"));
        driver.getPageSource().contains("You successfuly clicked an alert");
        System.out.println("Text is present");
        driver.close();
        driver.quit();
    }

    @Then("a JS Confirm box is displayed")
    public void a_JS_Confirm_box_is_displayed() throws Throwable {
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        driver.findElement(By.xpath("//p[@id='result' and text()='You clicked: Cancel']"));
        driver.getPageSource().contains("You clicked: Cancel");
        System.out.println("Text is present");
        driver.close();
        driver.quit();
    }

    @Then("a JS Prompt box is displayed")
    public void a_JS_Prompt_box_is_displayed() throws Throwable {
        Alert alert=driver.switchTo().alert();
        driver.switchTo().alert().sendKeys("Available for Hire");
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.xpath("//p[@id='result' and text()='You entered: Available for Hire']"));
        driver.getPageSource().contains("You clicked: Available for Hire");
        System.out.println("Text is present");
        driver.close();
        driver.quit();
    }
// Only And functions will be set here

//Only But functions will be set here

}
