package tests;
import io.qameta.allure.Description;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    public static Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    @Description("Verify user can login using valid credentials")
    public void loginWithValidCredentials() {
        logger.info("The user is on orangehrm login Page");
        LoginPage loginpage = new LoginPage(driver);

        logger.info("entering a valid username");
        loginpage.enterValidUsername();

        logger.info("entering a valid password");
        loginpage.enterValidPassword();

        logger.info("clicking on the login button");
        loginpage.clickLoginButton();

        String actualDashboardText = loginPage.getDashBoardText();
        Assert.assertEquals(actualDashboardText, "Dashboard", "Dashboard text mismatch after login");

    }
}
