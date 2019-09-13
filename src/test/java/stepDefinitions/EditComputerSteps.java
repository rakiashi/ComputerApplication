package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObject.ComputerDatabase;
import pageObject.ComputerForm;
import pageObject.CreateComputer;
import pageObject.EditComputer;

import java.io.IOException;
import java.util.List;

import static reusableHelpers.ElementHelpers.*;

public class EditComputerSteps {

    @Then("^I update computer details$")
    public void iUpdatedCanceledComputerDetails() {
        EditComputer.saveComputer.click();
        waitForElementToBeVisible(ComputerDatabase.searchbox);
    }

    @Then("^I cancel computer details$")
    public void iCancelCanceledComputerDetails() {
        CreateComputer.cancel.click();
        waitForElementToBeVisible(ComputerDatabase.searchbox);
    }

    @Then("^I delete computer details$")
    public void iDeleteCanceledComputerDetails() {
        EditComputer.deleteComputer.click();
        waitForElementToBeVisible(ComputerDatabase.searchbox);
    }


    @Then("^I see computer \"([^\"]*)\" details$")
    public void iShouldBeAbleToReadThoseComputerDetails(String ComputerName, List<String> expectedValues) throws IOException {
        waitForElementToBeVisible(ComputerDatabase.computerNameFirstItem);
        if (ComputerDatabase.computerNameFirstItem.getText().trim().equalsIgnoreCase(ComputerName)) {
            ComputerDatabase.computerNameFirstItem.click();
            waitForElementToBeVisible(ComputerForm.name);
            compareExpectedWithActual(expectedValues.get(0), getValueFromElement(ComputerForm.name));
            compareExpectedWithActual(expectedValues.get(1), getValueFromElement(ComputerForm.introduced));
            compareExpectedWithActual(expectedValues.get(2), getValueFromElement(ComputerForm.discontinued));
            compareExpectedWithActual(expectedValues.get(3), getFirstSelectedOption(ComputerForm.company));
        } else {
            Assert.fail();
        }
    }

    @And("^I update computer name with \"([^\"]*)\"$")
    public void iUpdateComputerNameWith(String valueToEnter) {
        enterValueInEditField(ComputerForm.name, valueToEnter);
    }

    @And("^I update computer introduced date with \"([^\"]*)\"$")
    public void iUpdateComputerIntroducedWith(String valueToEnter) {
        enterValueInEditField(ComputerForm.introduced, valueToEnter);
    }
}
