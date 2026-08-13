package steps;

import context.DriverContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HorizontalSliderPage;

public class HorizontalSliderSteps {
    private final DriverContext context;
    HorizontalSliderPage horizontalSliderPage;

    public HorizontalSliderSteps(DriverContext context) {
        this.context = context;
    }

    @Given("the user is on the horizontal slider page")
    public void userIsOnHorizontalSliderPage() {
        context.driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        horizontalSliderPage = new HorizontalSliderPage(context.driver);
    }

    @When("the user moves the slider {int} steps to the right")
    public void moveSliderRight(int steps) {
        horizontalSliderPage.moveRight(steps);
    }

    @When("the user moves the slider {int} steps to the left")
    public void moveSliderLeft(int steps) {
        horizontalSliderPage.moveLeft(steps);
    }

    @Then("the slider value should be {string}")
    public void sliderValueShouldBe(String expectedValue) {
        Assert.assertEquals(horizontalSliderPage.getSliderValue(), expectedValue);
    }
}
