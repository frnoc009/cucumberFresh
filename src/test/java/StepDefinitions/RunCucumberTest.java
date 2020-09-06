package StepDefinitions;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue={"StepDefinitions"},
        monochrome=true, plugin={"pretty","json:target/JSONReports/report.json", "html:target/HtmlReports",
        "junit:target/JUnitReports/report.xml"}, tags="@SmokeRegression")

public class RunCucumberTest {

}
