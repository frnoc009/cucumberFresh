package PageElements.Login;

//import PageElements.CommonElements;
import org.openqa.selenium.By;
import java.lang.String;
import lombok.AllArgsConstructor;
import lombok.Getter;

public enum LoginElements {

    LOGIN_USERNAME(By.cssSelector("#username"),""),
    LOGIN_PASSWORD(By.cssSelector("#password"),""),
    LOGIN_BUTTON(By.xpath("//i[@class='fa fa-2x fa-sign-in']"),""),
    LOGOUT_BUTTON(By.xpath("//a/i[@class='icon-2x icon-signout' and contains(text(),'Logout')]"),""),
    LOGIN_ERR_MSG(By.xpath("//div[contains(text(),'Your username is invalid!')]"),""),
    LOGIN_MSG(By.xpath("//div[contains(text(),'You logged into a secure area!')]"),""),
    LOGOUT_MSG(By.xpath("//div[contains(text(),'You logged out of the secure area!')]"),"");


    By selector;
    String query;

    LoginElements(By selector, String query) {
        this.selector = selector;
        this.query = query;
    }

    public By getSelector() {
        return selector;
    }

    public String getQuery() {
        return query;
    }

}
