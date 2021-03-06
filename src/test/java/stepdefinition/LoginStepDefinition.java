package stepdefinition;

import assertion.AssertValidation;
import interactor.LoginPageInteractor;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageDefinition;
import utils.ScenarioContext;

import java.util.List;
import java.util.Map;

public class LoginStepDefinition extends ScenarioContext{

    private ScenarioContext scenarioContext;
    public LoginStepDefinition(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    LoginPageInteractor loginPageInteractor= new LoginPageInteractor();
    AssertValidation assertValidation = new AssertValidation();

    @Given("the user launch the flipkart application")
    public void the_user_launch_the_flipkart_application() {
        System.out.println("Launched application");
    }

    @When("user enter the Username and Password")
    public void user_enter_username_and_password(DataTable credentials) {
        List<Map<String, String>> credential = credentials.asMaps(String.class, String.class);
        Map<String, String> credentialLabel = credential.get(0);
        loginPageInteractor.enterUserName(scenarioContext,credentialLabel.get("UserName"));
        loginPageInteractor.enterPassword(scenarioContext,credentialLabel.get("Password"));
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        loginPageInteractor.clickSubmit(scenarioContext);
    }

    @Then("verify the user able to view the Home screen")
    public void verify_the_user_able_to_view_the_home_screen() {
        HomePageDefinition homePageDefinition = new HomePageDefinition(scenarioContext);
        assertValidation.textAssert(homePageDefinition.getAccountScreenName(),"My Account");
    }

    @Given("the user login to the Flipkart application")
    public void theUserLoginToTheFlipkartApplication() throws InterruptedException {
        loginPageInteractor.enterUserName(scenarioContext,"9629913995");
        loginPageInteractor.enterPassword(scenarioContext,"sWADIKA123");
        Thread.sleep(1000);
        loginPageInteractor.clickSubmit(scenarioContext);
    }
}

