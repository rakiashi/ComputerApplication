package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.AddEdit;
import reusableHelpers.GenericHelpers;

import java.io.IOException;

public class AddComputerPage extends GenericHelpers {

    //--------------- Add Computer locators -------------------------------------------------------

    @FindBy(id = AddEdit.name)
    public static WebElement name;

    @FindBy(id = AddEdit.introduced)
    public static WebElement introduced;

    @FindBy(id = AddEdit.discontinued)
    public static WebElement discontinued;

    @FindBy(id = AddEdit.company)
    public static WebElement company;

    @FindBy(css = AddEdit.createSave)
    public static WebElement createComputer;

    @FindBy(css = AddEdit.fieldError)
    public static WebElement fieldError;

    // -------------------------------------------------------------------------------

    @AfterStep
    public static void afterEachScenario(Scenario scenario) {
//        if (scenario.isFailed()) {
        byte[] screenshot = ((TakesScreenshot) browser).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/jpeg");
//        }
    }

    public static void initAddComputer_Steps() {
        PageFactory.initElements(browser, AddComputerPage.class);
    }

    @Given("^I add an new computer as \"([^\"]*)\" name")
    public void iAddAnNewComputerAsDetails(String reference) throws IOException {
        waitForElementToBeVisible(ComputerDatabasePage.addComputer);
        ComputerDatabasePage.addComputer.click();
        JSONObject computer = getComputerDetails(reference);
        waitForElementToBeVisible(name);
        enterValueInEditField(name, computer.get("name").toString());
        enterValueInEditField(introduced, computer.get("introduced").toString());
        enterValueInEditField(discontinued, computer.get("discontinued").toString());
        selectValueInGivenElement(company, computer.get("company").toString());
        createComputer.click();
        waitForElementToBeVisible(ComputerDatabasePage.searchbox);
    }

    @When("^I tried to create computer and i see name is required$")
    public void iCreateComputerDetails() {
        waitForElementToBeVisible(name);
        createComputer.click();
        verifyElementDisplayed(fieldError);
        compareExpectedWithActual("Computer name\n" +
                "Required", fieldError.getText());
    }

    @And("^I enter computer \"([^\"]*)\" as \"([^\"]*)\"$")
    public void iEnterComputerWith(String fieldName, String valueToEnter) {
        WebElement fieldNameElement = browser.findElement(By.id(fieldName));
        enterValueInEditField(fieldNameElement, valueToEnter);
    }

    @When("^I tried to create computer and i see date format is incorrect$")
    public void iTriedToCreateComputerAndISeeDateFormatIsIncorrect(){
        waitForElementToBeVisible(name);
        createComputer.click();
        verifyElementDisplayed(fieldError);
        compareExpectedWithActual("Introduced date\n" +
                "Date ('yyyy-MM-dd')", fieldError.getText());
    }
}
