package StepDefinitions.Dynamic;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @And("Checkbox is marked checked")
    public void checkbox_is_marked_checked() throws Throwable {
        if (!driver.findElement(By.xpath("//div[@id='checkbox']//input")).isSelected() )
        {
            driver.findElement(By.xpath("//div[@id='checkbox']//input")).click();
        }
        System.out.println("Checkbox is checked");
    }

    @When("user clicks the Remove button")
    public void user_clicks_the_remove_button() throws Throwable {
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
        driver.findElement(By.xpath("//div[@id='loading']")).isDisplayed();
        driver.findElement(By.xpath("//p[@id='message']")).isDisplayed();
        Thread.sleep(2000);
        System.out.println("It's gone");
    }

    @Then("user adds check box")
    public void user_adds_check_box() throws Throwable {
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        driver.findElement(By.xpath("//p[@id='message']")).isDisplayed();
        System.out.println("Checkbox is back");
    }

    @And("checkbox will be rechecked")
    public void checkbox_will_be_rechecked() throws Throwable {
        if (!driver.findElement(By.xpath("//input[@id='checkbox']")).isSelected())
        {
            driver.findElement(By.xpath("//input[@id='checkbox']")).click();
        }
        System.out.println("Checkbox is re-checked");
        driver.close();
        driver.quit();

    }

    @When("enable button is clicked")
    public void enable_button_is_clicked() throws Throwable {
//        WebElement enable_btn = driver.findElement(By.xpath("//button[contains (text(),'Enable')]"));
//        WebElement disable_btn = driver.findElement(By.xpath("//button[contains (text(),'Disable')]"));
//        if (disable_btn.isEnabled()){
//            disable_btn.click();
//        }else if (enable_btn.isEnabled()) {
//            enable_btn.click();
//        }
        driver.findElement(By.xpath("//button[contains (text(),'Enable')]")).click();
        driver.findElement(By.xpath("//p[@id='message']")).isDisplayed();
        System.out.println("Enable button clicked");
    }

    @Then("the text field is enabled and text can be entered")
    public void the_text_field_is_enabled_and_text_can_be_entered() throws Throwable {
        driver.findElement(By.xpath("//form[@id='input-example']//input")).sendKeys("Test Field");
        System.out.println("Enter text");
    }
}
