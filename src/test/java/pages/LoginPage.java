package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {super(driver);}

    private final By USER_NAME = By.name("username");
    private final By PASSWORD_FIELD = By.name("password");
    private final By LOGIN_BUTTON= By.xpath("//button[@type='submit']");
    private final By DASHBOARD_TEXT= By.xpath("//h6");

    @Step("Verify user can enter valid user name")
    public void enterValidUsername() {
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(USER_NAME));
        username.sendKeys("Admin");

    }
    @Step("Verify user can enter valid password")
    public void enterValidPassword() {
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_FIELD));
        username.sendKeys("admin123");

    }
    @Step("Verify user click on login button")
    public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }
    @Step("Verify user is logged in")
    public String getDashBoardText(){
      WebElement text =  wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_TEXT));
        return text.getText();
    }
}

