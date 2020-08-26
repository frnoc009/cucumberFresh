package StepDefinitions.Dynamic;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class DynamicSteps {

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

    @Given("the user is on the Dynamic Controls page")
    public void the_user_is_on_the_dynamic_controls_page() throws Throwable {
        System.out.println("Dynamic page");
        browser();
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @When("user clicks the checkbox")
    public void user_clicks_the_checkbox() throws Throwable {
        if ( !driver.findElement(By.xpath("//div[@id='checkbox']//input")).isSelected() )
        {
            driver.findElement(By.xpath("//div[@id='checkbox']//input")).click();
        }
        System.out.println("Checkbox is checked");
    }

    @Then("check box has been checked")
    public void check_box_has_been_checked() throws Throwable {
        driver.findElement(By.xpath("//div[@id='checkbox']//input")).isSelected();
        System.out.println("Checkbox marked verified");
        driver.close();
        driver.quit();
    }
}
