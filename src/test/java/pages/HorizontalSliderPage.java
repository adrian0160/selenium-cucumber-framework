package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage extends BasePage {

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    By sliderLocator = By.cssSelector("input[type='range']");
    By sliderValueLocator = By.id("range");

    public void moveRight(int steps) {
        pressKey(Keys.ARROW_RIGHT, steps);
    }

    public void moveLeft(int steps) {
        pressKey(Keys.ARROW_LEFT, steps);
    }

    public String getSliderValue() {
        return waitVisible(sliderValueLocator).getText();
    }

    private void pressKey(Keys key, int times) {
        WebElement slider = waitVisible(sliderLocator);
        for (int i = 0; i < times; i++) {
            slider.sendKeys(key);
        }
    }
}
