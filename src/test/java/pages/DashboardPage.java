package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class DashboardPage extends BasePage {

    private final By DASHBOARD_TEXT = By.xpath("//h6[text()='Dashboard']");
    private final By ADMIN_TEXT = By.xpath("//span[text()='Admin']");
    private final By ADMIN_HEADER_TEXT = By.xpath("//h6[text()='Admin']");
    private final By PIM_TEXT = By.xpath("//span[text()='PIM']");
    private final By ADD_BTN = By.xpath("//button[text()=' Add ']");
    private final By PIM_HEADER_TEXT = By.xpath("//h6[text()='PIM']");
    private final By PROFILE_IMAGE_UPLOAD = By.xpath("//input[@type='file']");
    private final By EMPLOYEE_FIRST_NAME = By.name("firstName");
    private final By EMPLOYEE_LAST_NAME = By.name("lastName");
    private final By EMPLOYEE_HEADER_TEXT = By.xpath("//h6");

    private final By SAVE_BTN = By.xpath("//button[@type='submit']");


    private final By SYSTEM_USERNAME = By.xpath("//label[contains(text(),'Username')]/following::input[contains(@class,'oxd-input')]");
    private final By USER_ROLE_DROPDOWN = By.xpath("//label[contains(text(),'User Role')]/following::div[contains(@class,'oxd-select-text-input')][1]");
    private final By ADMIN_DROPDOWN_OPTION = By.xpath("//div[contains(@class,'oxd-select-option')]//span[text()='Admin']");
    private final By EMPOLYEE_NAME_INPUT_FIELD = By.xpath("//input[contains(@placeholder,'Type for hints')]");
    private final By NO_RECORDS_TEXT = By.xpath("//div[text()='No Records Found']");
    private final By SUGGESTIONS_OPTIONS = By.xpath("//div[contains(@class,'oxd-autocomplete-option')]");



    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getDashboardText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_TEXT)).getText();
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_TEXT)).isDisplayed();
    }

    public void clickAdminBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_TEXT)).click();
    }

    public String getAdminHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_HEADER_TEXT)).getText();
    }

    public void enterSystemUsername() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SYSTEM_USERNAME)).sendKeys("Testuser" + System.currentTimeMillis());
    }

    public void clickUserRoleDropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(USER_ROLE_DROPDOWN));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).click().perform();
        WebElement adminOption = wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_DROPDOWN_OPTION));
        actions.moveToElement(adminOption).click().perform();
    }

    public void enterEmployeeNameUntilMatch() {
        List<String> employeeNames = List.of(
                "Shaun",
                "test",
                "Paul",
                "Admin",
                "Maria"
        );

        for (String name : employeeNames) {

            WebElement input = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(EMPOLYEE_NAME_INPUT_FIELD)
            );

            input.clear();
            input.sendKeys(name);

            // wait for suggestions to load
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // If "No Records Found" → try next name
            if (driver.findElements(NO_RECORDS_TEXT).size() > 0) {
                continue;
            }

            // If suggestions exist → select first & exit
            if (driver.findElements(SUGGESTIONS_OPTIONS).size() > 0) {
                driver.findElements(SUGGESTIONS_OPTIONS).get(0).click();
                return;
            }
        }

        throw new RuntimeException("No employee match found from provided test data");
    }

    public void clickPimText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PIM_TEXT)).click();
    }

    public void clickAddBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_BTN)).click();
    }

    public String getPimHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PIM_HEADER_TEXT)).getText();
    }

    public void uploadProfileImage() {
        String imagePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\images\\test.png";
        File file = new File(imagePath);
        System.out.println("File exists: " + file.exists());

        WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(PROFILE_IMAGE_UPLOAD));
        uploadInput.sendKeys(imagePath);
    }

    public void createEmployee() {
        WebElement employeeFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(EMPLOYEE_FIRST_NAME));
        employeeFirstName.sendKeys("Testuser");
        WebElement employeeLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(EMPLOYEE_LAST_NAME));
        employeeLastName.sendKeys("123");
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submitBtn.click();
    }

    public void getEmployeeHeaderText() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-spinner")));

        By employeeHeaderLocator = By.xpath("//h6[text()='" +   "']");
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeHeaderLocator));
        String headerText = header.getText();
        System.out.println("Header shows: " + headerText);
    }







}









