package stepdefinition;

import interactor.HomePageInteractor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ScenarioContext;

import java.io.IOException;

public class HomePageStepDefinition extends ScenarioContext{

    private ScenarioContext scenarioContext;

    public HomePageStepDefinition(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    HomePageInteractor homePageInteractor=new HomePageInteractor();

    @Given("user search for the mobile products")
    public void theUserSearchForTheMobileProducts() throws IOException {
        homePageInteractor.searchProduct(scenarioContext,scenarioContext.getCellValue("C:\\Users\\775930\\Automation\\practice\\src\\test\\resources\\input_data\\flipkart_product_list.xlsx",0, 1, 0));
    }

    @Then("user able to find and get the product price amount")
    public void userAbleToFindAndGetTheProductPriceAmount() throws IOException {
        homePageInteractor.getPriceAmount(scenarioContext);
    }

    @When("user clear the cell value")
    public void userClearTheCellValue() throws IOException {
        scenarioContext.setCellValue("C:\\Users\\775930\\Automation\\practice\\src\\test\\resources\\input_data\\flipkart_product_list.xlsx",0,1,1,null);
    }
}
