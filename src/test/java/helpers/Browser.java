package helpers;

import helpers.SeleniumHelper;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;

public class Browser {

    public WebDriver webDriver;
    public SeleniumHelper seleniumWait;


    public Browser(WebDriver webDriver, SeleniumHelper seleniumWait) {
        this.webDriver = webDriver;
        this.seleniumWait = seleniumWait;
    }

    public void open_browser() throws Throwable {
        String projectPath=System.getProperty("user.dir");
        System.out.println("Project path is: "+projectPath);
        System.setProperty("webdriver.chrome.driver",
                projectPath+"/src/test/resources/driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    public void back() {
        webDriver.navigate().back();
    }

    public void forward() {
        webDriver.navigate().forward();
    }

    public void navigate(String url){
        webDriver.navigate().to(url);
    }

    public List<WebElement> getElements(By selector) {
        return webDriver.findElements(selector);
    }

    public void close() {
        webDriver.close();
    }

    public void quit() {
        webDriver.quit();
    }

    public String getCurrentUrl() {
        String current_url = webDriver.getCurrentUrl();
        System.out.println(current_url);
        return current_url;
    }

    public void clickUI(By locator) {
        //defaultWait.untilElementClickable(locator);
        webDriver.findElement(locator).click();
    }

    public void setTextUI(By locator, String input) {
        WebElement webElement = seleniumWait.untilElementClickable(locator);
        webElement.sendKeys(input);
    }

}
