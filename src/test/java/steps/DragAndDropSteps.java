package steps;

import context.DriverContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DragAndDropPage;

public class DragAndDropSteps {
    private final DriverContext context;
    DragAndDropPage dragAndDropPage;

    public DragAndDropSteps(DriverContext context) {
        this.context = context;
    }

    @Given("the user is on the drag and drop page")
    public void userIsOnDragAndDropPage() {
        context.driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        dragAndDropPage = new DragAndDropPage(context.driver);
    }

    @When("the user drags the left column onto the right column")
    public void dragLeftOntoRight() {
        dragAndDropPage.dragLeftColumnOntoRight();
    }

    @When("the user drags the right column onto the left column")
    public void dragRightOntoLeft() {
        dragAndDropPage.dragRightColumnOntoLeft();
    }

    @When("the user drags the left column onto itself")
    public void dragLeftOntoItself() {
        dragAndDropPage.dragLeftColumnOntoItself();
    }

    @Then("the left column should contain {string} and the right column should contain {string}")
    public void columnsShouldContain(String expectedLeft, String expectedRight) {
        Assert.assertEquals(dragAndDropPage.getLeftColumnText(), expectedLeft, "Left column mismatch");
        Assert.assertEquals(dragAndDropPage.getRightColumnText(), expectedRight, "Right column mismatch");
    }
}
