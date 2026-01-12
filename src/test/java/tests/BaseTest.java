package tests;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.*;

import java.lang.reflect.Method;

public class BaseTest {

    public static WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;


    protected Logger logger;
    public String logFilePath;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // will maximize the window
        driver.get("https://opensource-demo.orangehrmlive.com/");

        String testName = method.getName();
        logFilePath = "logs/" + testName + "_" + System.currentTimeMillis() + ".log";
        logger = LoggerFactory.getLogger(testName);

        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(context);
        encoder.setPattern("[%d{yyyy-MM-dd HH:mm:ss}] %-5level %logger - %msg%n");
        encoder.start();

        FileAppender<ILoggingEvent> fileAppender = new FileAppender<>();
        fileAppender.setContext(context);
        fileAppender.setName("TestFileAppender");
        fileAppender.setFile(logFilePath);
        fileAppender.setEncoder(encoder);
        fileAppender.start();

        ch.qos.logback.classic.Logger rootLogger = context.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.addAppender(fileAppender);

        logger = LoggerFactory.getLogger(testName);

        createPageObjects();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void createPageObjects() {
    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver);


    }

}

