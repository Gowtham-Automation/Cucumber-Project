package interactor;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePageDefinition;
import utils.ScenarioContext;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class HomePageInteractor {

    static Logger log = Logger.getLogger(HomePageInteractor.class);

    public void searchProduct(ScenarioContext scenarioContext, String product) {
        Actions action = new Actions(scenarioContext.driver);
        HomePageDefinition homePageDefinition = new HomePageDefinition(scenarioContext);
        action.moveToElement(homePageDefinition.getSearchBar()).click()
                .sendKeys(homePageDefinition.getSearchBar(), product)
                .sendKeys(Keys.ENTER)
                .build().perform();
        log.info("Product has searched");
    }

    public void getPriceAmount(ScenarioContext scenarioContext) throws IOException {
        HomePageDefinition homePageDefinition = new HomePageDefinition(scenarioContext);
        homePageDefinition.getProduct().click();
        Set<String> window = scenarioContext.driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String homePage = it.next();
        String detailsPage = it.next();
        scenarioContext.driver.switchTo().window(detailsPage);
        scenarioContext.getPropertyTransfer().put("Product Price", homePageDefinition.getPrice());
        scenarioContext.driver.close();
        scenarioContext.driver.switchTo().window(homePage);
        scenarioContext.setCellValue("C:\\Users\\775930\\Automation\\practice\\src\\test\\resources\\input_data\\flipkart_product_list.xlsx",0,1,1,scenarioContext.getPropertyTransfer().get("Product Price"));
        log.info("The Product price is " + scenarioContext.getPropertyTransfer().get("Product Price"));
    }

}
