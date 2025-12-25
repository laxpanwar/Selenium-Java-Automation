package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    //private final By RADIO2_BUTTON = By.name("radioButton");
    private final By RADIO2_BUTTON = By.xpath("//input[@value='radio2']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify add element is Clickable")
    public void clickRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(RADIO2_BUTTON)).click();
    }
}
