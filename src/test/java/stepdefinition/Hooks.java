package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ScenarioContext;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks extends ScenarioContext {

    private ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }


    @Before
    public void initializeTest() {
        Properties prop = new Properties();
        try {
            //InputStream input = new FileInputStream("configuration/Config.properties");
            InputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/configuration/Config.properties");
            prop.load(input);
            if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
                scenarioContext.driver = new ChromeDriver();
            } else if (prop.getProperty("browser").equalsIgnoreCase("Firefox"))
                System.out.println("Firefox not initialized");

            scenarioContext.driver.manage().window().maximize();
            scenarioContext.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            scenarioContext.driver.get(prop.getProperty("url"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDownTest(Scenario scenario) {
        System.out.println("Transaction completed");
    }
}
