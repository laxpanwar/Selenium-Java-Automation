package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void enterText(By locator, String txt) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(txt);
    }
}