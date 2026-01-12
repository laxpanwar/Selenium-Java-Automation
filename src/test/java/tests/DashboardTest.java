package tests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {
    protected DashboardPage dashboardPage;
    @BeforeMethod
    public void loginsetup() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginWithValidCredentials("Admin", "admin123");
    }

    @Test
    @Description("Usr is on dashboard page")
    public void verifyDashboardText() {
        Assert.assertEquals(dashboardPage.getDashboardText(), "Dashboard");
    }

    @Test
    @Description("Clicking on the admin button from the menu")
    public void verifyClickAdminBtn() throws InterruptedException {
        dashboardPage.clickAdminBtn();
        Assert.assertEquals(dashboardPage.getAdminHeaderText(), "Admin", "actual text is not matching with expected text");
        dashboardPage.enterSystemUsername();
        dashboardPage.clickUserRoleDropdown();

    }

}
