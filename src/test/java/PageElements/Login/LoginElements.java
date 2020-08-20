package PageElements.Login;

import PageElements.CommonElements;
import org.openqa.selenium.By;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum LoginElements implements CommonElements {

    LOGIN_USERNAME(By.cssSelector("#username"),""),
    LOGIN_PASSWORD(By.cssSelector("#password"),""),
    LOGIN_BUTTON(By.cssSelector("button.radius:nth-child(3)"),""),
    LOGOUT_BUTTON(By.xpath("//i[@class='icon-2x icon-signout']"),"");


    private By selector;
    private String query;

}
