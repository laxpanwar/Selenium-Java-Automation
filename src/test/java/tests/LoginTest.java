package tests;
import io.qameta.allure.Description;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    public static Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    @Description("Verify user can login using valid credentials")
    public static void verifyLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.loginWithValidCredentials("Admin", "admin123");
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }
}
