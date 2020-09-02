package PageElements.AlertElements;

//import PageElements.CommonElements;
import org.openqa.selenium.By;
//import lombok.AllArgsConstructor;
//import lombok.Getter;

public enum AlertElements {
    ELEN(By.xpath("//i[@class='icon-2x icon-signout']"),"");

    private By selector;
    private String query;

    AlertElements(By selector, String query) {
        this.selector = selector;
        this.query = query;
    }

    public By getSelector() {
        return null;
    }

    public String getQuery() {
        return null;
    }
}
