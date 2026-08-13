package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage {

    private final Actions actions;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
    }

    // The columns are identified by id: the ids stay fixed while their content is swapped.
    By leftColumnLocator = By.id("column-a");
    By rightColumnLocator = By.id("column-b");

    public void dragLeftColumnOntoRight() {
        dragAndDrop(leftColumnLocator, rightColumnLocator);
    }

    public void dragRightColumnOntoLeft() {
        dragAndDrop(rightColumnLocator, leftColumnLocator);
    }

    public void dragLeftColumnOntoItself() {
        dragAndDrop(leftColumnLocator, leftColumnLocator);
    }

    public String getLeftColumnText() {
        return waitVisible(leftColumnLocator).getText();
    }

    public String getRightColumnText() {
        return waitVisible(rightColumnLocator).getText();
    }

    private void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = waitVisible(sourceLocator);
        WebElement target = waitVisible(targetLocator);
        actions.clickAndHold(source)
                .moveToElement(target)
                .release()
                .perform();
    }
}
