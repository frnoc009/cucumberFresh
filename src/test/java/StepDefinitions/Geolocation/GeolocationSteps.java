package StepDefinitions.Geolocation;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class GeolocationSteps {

    WebDriver driver = null;
    public void browser() throws Throwable {
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
        browser();
        driver.navigate().to("https://the-internet.herokuapp.com/geolocation");
    }

    @When("Where am I button is clicked")
    public void where_am_i_button_is_clicked() {
        driver.findElement(By.xpath("//button[contains(text(),'Where am I?')]")).click();
    }

    @Then("the Longitude and latitude are presented")
    public void the_longitude_and_latitude_are_presented() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
