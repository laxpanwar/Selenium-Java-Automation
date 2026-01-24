package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    //private final By RADIO2_BUTTON = By.name("radioButton");
    private final By radio2Button = By.xpath("//input[@value='radio2']");
    private final By countryText = By.xpath("//input[@placeholder='Type to Select Countries']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify radio button Clickable")
    public void clickRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(radio2Button)).click();
    }

    @Step("Verify user can select country")
    public String enterCountry(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryText)).sendKeys("India");
        String s = "India";
        return s;
    }
}
