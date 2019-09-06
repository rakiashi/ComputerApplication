package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.ComputerDatabase;
import reusableHelpers.GenericHelpers;

import java.io.IOException;


public class ComputerDatabasePage extends GenericHelpers {

    //--------------- ComputerDatabasePage WebElements -------------------------------------------------------

    @FindBy(id = ComputerDatabase.searchbox)
    public static WebElement searchbox;

    @FindBy(id = ComputerDatabase.searchsubmit)
    public static WebElement searchsubmit;

    @FindBy(css = ComputerDatabase.computerNameFirstItem)
    public static WebElement computerNameFirstItem;

    @FindBy(css = ComputerDatabase.introducedFirstItem)
    public static WebElement introducedFirstItem;

    @FindBy(css = ComputerDatabase.discontinuedFirstItem)
    public static WebElement discontinuedFirstItem;

    @FindBy(css = ComputerDatabase.companyFirstItem)
    public static WebElement companyFirstItem;

    @FindBy(css = ComputerDatabase.alertMessage)
    public static WebElement alertMessage;

    @FindBy(css = ComputerDatabase.nothingToDisplay)
    public static WebElement nothingToDisplay;

    @FindBy(id = ComputerDatabase.add)
    public static WebElement addComputer;
    // -------------------------------------------------------------------------------

    public static void initHomePage_Steps() {
        PageFactory.initElements(browser, ComputerDatabasePage.class);
    }

    @Given("I launch computer data base application")
    public static void iLaunchComputerDataBaseApp() {
        browser.manage().deleteAllCookies();
        browser.get(prop.getProperty("URL"));
        compareExpectedWithActual("Computers database", browser.getTitle());
        waitForElementToBeVisible(addComputer);
    }


    @Given("^I search for computer name as \"([^\"]*)\"$")
    public void iSearchForComputerNameAs(String computerName) {
        enterValueInEditField(searchbox, computerName);
        searchsubmit.click();
    }

    @Then("^I see computer has been (created|updated|deleted)$")
    public void iShouldSeeComputerHasBeenCreatedUpdatedDeleted(String expectedCondition) {
        Assert.assertTrue(expectedCondition, alertMessage.getText().contains(expectedCondition));
    }

    @When("^I see nothing to display$")
    public void iSeeNothingToDisplayMessage() {
        waitForElementToBeVisible(nothingToDisplay);
        verifyElementDisplayed(nothingToDisplay);
    }


    @Then("^I see computer \"([^\"]*)\" listed in result table$")
    public void iSeeComputerListedInResultTable(String reference) throws IOException {
        waitForElementToBeVisible(computerNameFirstItem);
        verifyElementDisplayed(computerNameFirstItem);
        JSONObject computer = getComputerDetails(reference);
        if (computerNameFirstItem.getText().trim().equalsIgnoreCase(reference)) {
            compareExpectedWithActual(computer.get("name").toString(), computerNameFirstItem.getText().trim());
            compareExpectedWithActual(dateFormat(computer.get("introduced").toString().trim()), introducedFirstItem.getText().trim());
            compareExpectedWithActual(dateFormat(computer.get("discontinued").toString().trim()), discontinuedFirstItem.getText().trim());
            compareExpectedWithActual(computer.get("company").toString(), companyFirstItem.getText().trim());
        } else {
            Assert.fail("Listed computed details is not matched with expected details");
        }
    }

    @Given("^I add an new computer$")
    public void iAddAnNewComputer(){
        addComputer.click();
    }

    @Then("^I see redirecting to computer database$")
    public void iSeeRedirectingToComputerDatabase(){
        waitForElementToBeVisible(searchbox);
        verifyElementDisplayed(searchbox);
    }
}

