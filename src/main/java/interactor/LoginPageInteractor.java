package interactor;

import pages.LoginPageDefinition;
import utils.ScenarioContext;

public class LoginPageInteractor {

    public void enterUserName(ScenarioContext scenarioContext, String userName){
        LoginPageDefinition loginPageDefinition = new LoginPageDefinition(scenarioContext);
        loginPageDefinition.userName().sendKeys(userName);
    }

    public void enterPassword(ScenarioContext scenarioContext, String password){
        LoginPageDefinition loginPageDefinition = new LoginPageDefinition(scenarioContext);
        loginPageDefinition.password().sendKeys(password);
    }

    public void clickSubmit(ScenarioContext scenarioContext){
        LoginPageDefinition loginPageDefinition = new LoginPageDefinition(scenarioContext);
        loginPageDefinition.submit().click();
    }
}
