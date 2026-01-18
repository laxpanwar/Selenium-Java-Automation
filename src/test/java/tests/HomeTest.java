package tests;

import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.HomePage;

public  class HomeTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(HomeTest.class);

    @Test
    @Description("Verify user can click on radio2 button")
    public void clickRadioButton()  {
        try {
            logger.info("The user is on Practice Page");
            HomePage homePage = new HomePage(driver);
            homePage.clickRadioButton();
            logger.info("Test passed");
        } catch (Exception e) {
            logger.error("Test failed -> {}", e.getMessage());
            throw e;
        } catch (AssertionError e) {
            logger.error("Test failed due to assertion error -> {}", e.getMessage());
            throw e;
        }
    }

    @Test
    @Description("Verify user can select country")
    public void enterCountry() {
        try {
            logger.info("The user is on Practice Page");
            HomePage homePage = new HomePage(driver);
            homePage.enterCountry();
        } catch (Exception e) {
            logger.error("Test failed -> {}", e.getMessage());
            throw e;
        } catch (AssertionError e) {
            logger.error("Test failed due to assertion error -> {}", e.getMessage());
            throw e;
        }
    }
}