package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class StatusCodesPage extends BasePage {

    public StatusCodesPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL = "https://the-internet.herokuapp.com/status_codes";

    By pageContent = By.cssSelector("#content");

    public void open() {
        driver.get(URL);
    }

    /**
     * Each status code is exposed as a link whose text is the code itself,
     * so the code can be used directly to locate it.
     */
    private By linkFor(String statusCode) {
        return By.linkText(statusCode);
    }

    public String getLinkUrl(String statusCode) {
        return waitVisible(linkFor(statusCode)).getAttribute("href");
    }

    public void clickLink(String statusCode) {
        waitClickable(linkFor(statusCode)).click();
    }

    public String getPageContent() {
        return waitVisible(pageContent).getText();
    }

    public int getStatusCode(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        connection.setInstanceFollowRedirects(false);
        try {
            connection.connect();
            return connection.getResponseCode();
        } finally {
            connection.disconnect();
        }
    }

    public boolean isBroken(String url) throws IOException {
        return getStatusCode(url) >= 400;
    }
}
