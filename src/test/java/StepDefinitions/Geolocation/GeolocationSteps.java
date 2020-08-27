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
}
