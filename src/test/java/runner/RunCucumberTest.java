package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions(monochrome = false, plugin = { "html:target/cucumber-html-report.html", "json:target/cucumber.json",
        "pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
        "junit:target/cucumber-results.xml" }, features = "src/test/resources/features", glue = { "utils.steps" })

public class RunCucumberTest {
}