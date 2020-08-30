package PageElements.DynamicElements;

import PageElements.DynamicElements.DynamicElements;
import PageElements.CommonElements;
import org.openqa.selenium.By;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum DynamicElements implements CommonElements{

    MARK_CHECKBOX(By.xpath("//div[@id='checkbox']//input"), ""),
    REMARK_CHECKBOX(By.xpath("//input[@id='checkbox']\""), ""),
    TEXT_FIELD_DISABLED(By.xpath("//form[@id='input-example']//input"), ""),
    ENABLE_BUTTON(By.xpath("//button[contains (text(),'Enable')]"), ""),
    ENABLE_MSG(By.xpath("//p[@id='message']"), ""),
    TEXT_FIELD_ENABLED(By.xpath("//form[@id='input-example']//input"), "");


    private By selector;
    private String query;
}