package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {super(driver);}

    private final By USER_NAME = By.name("username");
    private final By PASSWORD_FIELD = By.name("password");
    private final By LOGIN_BUTTON= By.xpath("//button[@type='submit']");

    @Step("Verify user can enter valid user name")
    public DashboardPage loginWithValidCredentials(String user, String pass) throws InterruptedException {
       wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME)).sendKeys(user);
       wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD)).sendKeys(pass);
       wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON)).click();
        return new DashboardPage(driver);
    }
}

