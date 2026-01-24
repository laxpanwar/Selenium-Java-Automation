package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class DashboardPage extends BasePage {

    private final By dashboardPage = By.xpath("//h6[text()='Dashboard']");
    private final By adminText = By.xpath("//span[text()='Admin']");
    private final By adminheaderText = By.xpath("//h6[text()='Admin']");
    private final By pimText = By.xpath("//span[text()='PIM']");
    private final By addBtn = By.xpath("//button[text()=' Add ']");
    private final By pimHeaderText = By.xpath("//h6[text()='PIM']");
    private final By profileImageUpload = By.xpath("//input[@type='file']");
    private final By employeeFirstName = By.name("firstName");
    private final By employeeLastName = By.name("lastName");
    private final By employeeHeaderText = By.xpath("//h6");

    private final By saveBtn = By.xpath("//button[@type='submit']");


    private final By systemUsername = By.xpath("//label[contains(text(),'Username')]/following::input[contains(@class,'oxd-input')]");
    private final By userRoleDropdown = By.xpath("//label[contains(text(),'User Role')]/following::div[contains(@class,'oxd-select-text-input')][1]");
    private final By adminDropdownOption = By.xpath("//div[contains(@class,'oxd-select-option')]//span[text()='Admin']");
    private final By empolyeeNameInputField = By.xpath("//input[contains(@placeholder,'Type for hints')]");
    private final By noRecordsText = By.xpath("//div[text()='No Records Found']");
    private final By suggestionsOptions = By.xpath("//div[contains(@class,'oxd-autocomplete-option')]");



    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getDashboardText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPage)).getText();
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPage)).isDisplayed();
    }

    public void clickAdminBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminText)).click();
    }

    public String getAdminHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(adminheaderText)).getText();
    }

    public void enterSystemUsername() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(systemUsername)).sendKeys("Testuser" + System.currentTimeMillis());
    }

    public void clickUserRoleDropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).click().perform();
        WebElement adminOption = wait.until(ExpectedConditions.visibilityOfElementLocated(adminDropdownOption));
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
                    ExpectedConditions.visibilityOfElementLocated(empolyeeNameInputField)
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
            if (driver.findElements(noRecordsText).size() > 0) {
                continue;
            }

            // If suggestions exist → select first & exit
            if (driver.findElements(suggestionsOptions).size() > 0) {
                driver.findElements(suggestionsOptions).get(0).click();
                return;
            }
        }

        throw new RuntimeException("No employee match found from provided test data");
    }

    public void clickPimText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimText)).click();
    }

    public void clickAddBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addBtn)).click();
    }

    public String getPimHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pimHeaderText)).getText();
    }

    public void uploadProfileImage() {
        String imagePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\images\\test.png";
        File file = new File(imagePath);
        System.out.println("File exists: " + file.exists());

        WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(profileImageUpload));
        uploadInput.sendKeys(imagePath);
    }

    public void createEmployee() {
        WebElement employeeFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(this.employeeFirstName));
        employeeFirstName.sendKeys("Testuser");
        WebElement employeeLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(this.employeeLastName));
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









