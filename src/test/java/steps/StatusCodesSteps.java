package steps;

import context.DriverContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.StatusCodesPage;

import java.io.IOException;

public class StatusCodesSteps {
    private final DriverContext context;
    StatusCodesPage statusCodesPage;

    public StatusCodesSteps(DriverContext context) {
        this.context = context;
    }

    @Given("the user is on the status codes page")
    public void userIsOnStatusCodesPage() {
        statusCodesPage = new StatusCodesPage(context.driver);
        statusCodesPage.open();
    }

    @Then("the {string} link should return HTTP status {int}")
    public void linkShouldReturnStatus(String linkText, int expectedStatus) throws IOException {
        String url = statusCodesPage.getLinkUrl(linkText);
        Assert.assertEquals(statusCodesPage.getStatusCode(url), expectedStatus,
                "Unexpected status code for link '" + linkText + "' (" + url + ")");
    }

    @Then("the {string} link should be reported as broken")
    public void linkShouldBeBroken(String linkText) throws IOException {
        String url = statusCodesPage.getLinkUrl(linkText);
        Assert.assertTrue(statusCodesPage.isBroken(url),
                "Expected link '" + linkText + "' to be broken");
    }

    @Then("the {string} link should not be reported as broken")
    public void linkShouldNotBeBroken(String linkText) throws IOException {
        String url = statusCodesPage.getLinkUrl(linkText);
        Assert.assertFalse(statusCodesPage.isBroken(url),
                "Expected link '" + linkText + "' not to be broken");
    }

    @When("the user clicks the {string} status code link")
    public void userClicksStatusCodeLink(String linkText) {
        statusCodesPage.clickLink(linkText);
    }

    @Then("the page should state that it returned status {string}")
    public void pageShouldStateStatus(String statusCode) {
        String expectedText = "This page returned a " + statusCode + " status code";
        Assert.assertTrue(statusCodesPage.getPageContent().contains(expectedText),
                "Page content did not mention status " + statusCode);
    }
}
