package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.en.Given;
import org.json.JSONObject;
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

}
