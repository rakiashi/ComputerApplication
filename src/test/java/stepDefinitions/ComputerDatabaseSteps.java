package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;
import pageObject.ComputerDatabase;

import java.io.IOException;

import static reusableHelpers.ElementHelpers.*;
import static reusableHelpers.JavaHelpers.dateFormat;
import static reusableHelpers.JavaHelpers.getComputerDetails;

public class ComputerDatabaseSteps {

    @Given("I launch computer data base application")
    public static void iLaunchComputerDataBaseApp() {
        browser.manage().deleteAllCookies();
        browser.get(prop.getProperty("URL"));
        compareExpectedWithActual("Computers database", browser.getTitle());
        waitForElementToBeVisible(ComputerDatabase.addComputer);
    }


    @Given("^I search for computer name as \"([^\"]*)\"$")
    public void iSearchForComputerNameAs(String computerName) {
        enterValueInEditField(ComputerDatabase.searchbox, computerName);
        ComputerDatabase.searchsubmit.click();
    }

    @Then("^I see computer has been (created|updated|deleted)$")
    public void iShouldSeeComputerHasBeenCreatedUpdatedDeleted(String expectedCondition) {
        Assert.assertTrue(expectedCondition, ComputerDatabase.alertMessage.getText().contains(expectedCondition));
    }

    @When("^I see nothing to display$")
    public void iSeeNothingToDisplayMessage() {
        waitForElementToBeVisible(ComputerDatabase.nothingToDisplay);
        verifyElementDisplayed(ComputerDatabase.nothingToDisplay);
    }


    @Then("^I see computer \"([^\"]*)\" listed in result table$")
    public void iSeeComputerListedInResultTable(String reference) throws IOException {
        waitForElementToBeVisible(ComputerDatabase.computerNameFirstItem);
        verifyElementDisplayed(ComputerDatabase.computerNameFirstItem);
        JSONObject computer = getComputerDetails(reference);
        if (ComputerDatabase.computerNameFirstItem.getText().trim().equalsIgnoreCase(reference)) {
            compareExpectedWithActual(computer.get("name").toString(), ComputerDatabase.computerNameFirstItem.getText().trim());
            compareExpectedWithActual(dateFormat(computer.get("introduced").toString().trim()), ComputerDatabase.introducedFirstItem.getText().trim());
            compareExpectedWithActual(dateFormat(computer.get("discontinued").toString().trim()), ComputerDatabase.discontinuedFirstItem.getText().trim());
            compareExpectedWithActual(computer.get("company").toString(), ComputerDatabase.companyFirstItem.getText().trim());
        } else {
            Assert.fail("Listed computed details is not matched with expected details");
        }
    }

    @Given("^I add an new computer$")
    public void iAddAnNewComputer() {
        ComputerDatabase.addComputer.click();
    }

    @Then("^I see redirecting to computer database$")
    public void iSeeRedirectingToComputerDatabase() {
        waitForElementToBeVisible(ComputerDatabase.searchbox);
        verifyElementDisplayed(ComputerDatabase.searchbox);
    }
}

