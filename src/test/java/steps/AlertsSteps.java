package steps;

import context.DriverContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AlertsPage;

public class AlertsSteps {
    private final DriverContext context;
    AlertsPage alertsPage;

    public AlertsSteps(DriverContext context) {
        this.context = context;
    }

    @Given("the user is on the JavaScript alerts page")
    public void userIsOnAlertsPage() {
        context.driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        alertsPage = new AlertsPage(context.driver);
    }

    @When("the user triggers the JS alert")
    public void triggerAlert() {
        alertsPage.triggerAlert();
    }

    @When("the user triggers the JS confirm")
    public void triggerConfirm() {
        alertsPage.triggerConfirm();
    }

    @When("the user triggers the JS prompt")
    public void triggerPrompt() {
        alertsPage.triggerPrompt();
    }

    @When("the user accepts the dialog")
    public void acceptDialog() {
        alertsPage.acceptDialog();
    }

    @When("the user dismisses the dialog")
    public void dismissDialog() {
        alertsPage.dismissDialog();
    }

    @When("the user enters {string} in the prompt and accepts")
    public void enterPromptText(String text) {
        alertsPage.enterPromptTextAndAccept(text);
    }

    @Then("the result should be {string}")
    public void resultShouldBe(String expected) {
        Assert.assertEquals(alertsPage.getResult(), expected);
    }
}
