package steps;

import context.DriverContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import pages.LoginPage;

public class LoginSteps {

    private final DriverContext context;
    LoginPage loginPage;

    public LoginSteps(DriverContext context) {
        this.context = context;
    }

    @Given("the user is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage = new LoginPage(context.driver);
        context.driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("the user enters username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("the displayed message should be {string}")
    public void theDisplayedMessageShouldBe(String expectedMessage) {
        String actualMessage = loginPage.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message to contain: '" + expectedMessage + "' but was: '" + actualMessage + "'");
    }

}
