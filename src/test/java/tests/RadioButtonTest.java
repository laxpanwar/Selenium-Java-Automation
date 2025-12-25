package tests;

import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RadioButtonPage;

import java.io.IOException;

public  class RadioButtonTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(RadioButtonTest.class);

@Test
@Description("Verify user can click add and remove button")
public void clickRadioButton() throws InterruptedException, IOException {
    try {
        logger.info("The user is on Practice Page");
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickRadioButton();
        logger.info("Test passed");
    } catch (Exception e) {
        logger.error("Test failed -> {}", e.getMessage());
        throw e;
    } catch (AssertionError e) {
        logger.error("Test failed due to assertion error -> {}", e.getMessage());
        throw e;
    }
}
    }