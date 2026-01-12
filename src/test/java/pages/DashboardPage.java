package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.html.HTMLInputElement;

public class DashboardPage extends BasePage {

    private final By DASHBOARD_TEXT= By.xpath("//h6[text()='Dashboard']");
    private final By ADMIN_BTN= By.xpath("//span[text()='Admin']");
    private final By ADMIN_HEADER_TEXT= By.xpath("//h6[text()='Admin']");
    private final By SYSTEM_USERNAME= By.xpath("//label[contains(text(),'Username')]/following::input[contains(@class,'oxd-input')]");
    private final By USER_ROLE_DROPDOWN = By.xpath("//label[contains(text(),'User Role')]/following::div[contains(@class,'oxd-select-text-input')][1]");
    private final By ADMIN_DROPDOWN_OPTION= By.xpath("//div[contains(@class,'oxd-select-option')]//span[text()='Admin']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getDashboardText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_TEXT)).getText();
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_TEXT)).isDisplayed();
    }
    public void clickAdminBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_BTN)).click();
    }
    public String getAdminHeaderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_HEADER_TEXT)).getText();
    }
    public void enterSystemUsername(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SYSTEM_USERNAME)).sendKeys("Testuser");
    }
    public void clickUserRoleDropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(USER_ROLE_DROPDOWN));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).click().perform();
        WebElement adminOption = wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_DROPDOWN_OPTION));
        actions.moveToElement(adminOption).click().perform();
    }

}


