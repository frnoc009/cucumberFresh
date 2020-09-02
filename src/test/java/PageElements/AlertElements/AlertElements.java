package PageElements.AlertElements;

import PageElements.CommonElements;
import org.openqa.selenium.By;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlertElements implements CommonElements{

    LOGOUT_BUTTON(By.xpath("//i[@class='icon-2x icon-signout']"),"");

    private By selector;
    private String query;
}
