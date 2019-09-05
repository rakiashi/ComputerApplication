package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.ComputerDatabase;
import reusableHelpers.GenericHelpers;


public class ComputerDatabasePage extends GenericHelpers {

    //--------------- ComputerDatabasePage WebElements -------------------------------------------------------

    @FindBy(id = ComputerDatabase.searchbox)
    public static WebElement searchbox;

    @FindBy(id = ComputerDatabase.searchsubmit)
    public static WebElement searchsubmit;

    @FindBy(css = ComputerDatabase.selectFirstItem)
    public static WebElement selectFirstItem;

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
    public void iSeeComputerListedInResultTable(String computerName){
        waitForElementToBeVisible(selectFirstItem);
        compareExpectedWithActual(computerName, selectFirstItem.getText().trim());
        verifyElementDisplayed(selectFirstItem);
    }
}
