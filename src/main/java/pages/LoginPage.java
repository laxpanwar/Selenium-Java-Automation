package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {super(driver);}

    private final By userName = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    @Step("Verify user can enter valid user name")
    public DashboardPage loginWithValidCredentials(String user, String pass) throws InterruptedException {
       wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).sendKeys(user);
       wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(pass);
       wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
        return new DashboardPage(driver);
    }
}

