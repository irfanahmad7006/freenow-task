package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/featureFiles"},
        glue = {"com.typicode.jsonplaceholder.stepDefinitions"}, //specify hooks location if not present in the same package as step defs
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/reports/cucumber.html"},
        monochrome = true,
        publish = true
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}

