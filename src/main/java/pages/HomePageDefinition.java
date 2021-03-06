package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ScenarioContext;

public class HomePageDefinition extends ScenarioContext {

    private ScenarioContext scenarioContext;

    public HomePageDefinition(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    public String getAccountScreenName() {
        return scenarioContext.driver.findElement(By.xpath("//*[contains(text(),'My Account')]")).getText();
    }

    public WebElement getSearchBar() {
        return scenarioContext.driver.findElement(By.xpath("//*[@title='Search for products, brands and more']"));
    }

    public WebElement getProduct() {
        return scenarioContext.driver.findElement(By.xpath("//*[@class='col col-7-12']//*[contains(text(),'Redmi Note 7 Pro (Blue, 64 GB)')]"));
    }

    public String getPrice() {
        return scenarioContext.driver.findElement(By.xpath("//*[@class='_30jeq3 _16Jk6d']")).getText();
    }
}
