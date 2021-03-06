package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ScenarioContext;

public class LoginPageDefinition extends ScenarioContext {
    private ScenarioContext scenarioContext;

    public LoginPageDefinition(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }
    public WebElement userName(){
        return scenarioContext.driver.findElement(By.xpath("//*[@class='_2IX_2- VJZDxU']"));
    }
    public WebElement password(){
        return scenarioContext.driver.findElement(By.xpath("//*[@type='password']"));
    }
    public WebElement submit(){
        return scenarioContext.driver.findElement(By.xpath("//*[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
    }
}
