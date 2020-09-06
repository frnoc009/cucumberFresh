package StepDefinitions.Geolocation;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class GeolocationSteps {

    WebDriver driver = null;

    public void disableNotificationBrowser() throws Throwable {
        String projectPath=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",
                projectPath+"/src/test/resources/driver/chromedriver");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-geolocation");
        option.addArguments("disable-notifications");
        System.out.println("Project path is: "+projectPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("User is on the geolocation page")
    public void user_is_on_the_geolocation_page() throws Throwable {
        disableNotificationBrowser();
        driver.navigate().to("https://the-internet.herokuapp.com/geolocation");
    }

    @When("Where am I button is clicked")
    public void where_am_i_button_is_clicked() throws InterruptedException {
        //driverWait.wait(3);
        driver.findElement(By.xpath("//button[contains(text(),'Where am I?')]")).click();
    }

    @Then("the Longitude and latitude are presented")
    public void the_longitude_and_latitude_are_presented() throws InterruptedException {
        //driverWait.wait(3);
        driver.findElement(By.xpath("//div[@id='lat-value']")).isDisplayed();
        String text1 = driver.findElement(By.xpath("//div[@id='lat-value']")).getText();
        System.out.println(text1);
        driver.findElement(By.xpath("//div[@id='long-value']")).isDisplayed();
        String text2 = driver.findElement(By.xpath("//div[@id='long-value']")).getText();
        System.out.println(text2);
        driver.close();
        driver.quit();
    }
}
