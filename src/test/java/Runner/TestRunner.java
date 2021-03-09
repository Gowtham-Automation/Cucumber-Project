package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/features/login.feature"},
        glue = {"src/test/java/stepdefinition"},
        plugin = {"json:target/cucumber.json"})


public class TestRunner {
}
