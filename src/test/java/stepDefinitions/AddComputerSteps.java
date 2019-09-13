package stepDefinitions;

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
import pageObject.ComputerDatabase;
import pageObject.CreateComputer;

import java.io.IOException;

import static pageObject.ComputerForm.*;
import static reusableHelpers.ElementHelpers.*;
import static reusableHelpers.JavaHelpers.getComputerDetails;

public class AddComputerSteps{

    // This After Step executes after each scenario to capture screenshot if any failed steps
    @AfterStep
    public static void afterEachScenario(Scenario scenario) {
        if (scenario.isFailed()) {
        byte[] screenshot = ((TakesScreenshot) browser).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/jpeg");
        }
    }

    @Given("^I add an new computer as \"([^\"]*)\" name")
    public void iAddAnNewComputerAsDetails(String reference) throws IOException {
        waitForElementToBeVisible(ComputerDatabase.addComputer);
        ComputerDatabase.addComputer.click();
        JSONObject computer = getComputerDetails(reference);
        waitForElementToBeVisible(name);
        enterValueInEditField(name, computer.get("name").toString());
        enterValueInEditField(introduced, computer.get("introduced").toString());
        enterValueInEditField(discontinued, computer.get("discontinued").toString());
        selectValueInGivenElement(company, computer.get("company").toString());
        CreateComputer.createComputer.click();
        waitForElementToBeVisible(ComputerDatabase.searchbox);
    }

    @When("^I tried to create computer and i see name is required$")
    public void iCreateComputerDetails() {
        waitForElementToBeVisible(name);
        CreateComputer.createComputer.click();
        verifyElementDisplayed(CreateComputer.fieldError);
        compareExpectedWithActual("Computer name\n" +
                "Required", CreateComputer.fieldError.getText());
    }

    @And("^I enter computer \"([^\"]*)\" as \"([^\"]*)\"$")
    public void iEnterComputerWith(String fieldName, String valueToEnter) {
        WebElement fieldNameElement = browser.findElement(By.id(fieldName));
        enterValueInEditField(fieldNameElement, valueToEnter);
    }

    @When("^I tried to create computer and i see date format is incorrect$")
    public void iTriedToCreateComputerAndISeeDateFormatIsIncorrect(){
        waitForElementToBeVisible(name);
        CreateComputer.createComputer.click();
        verifyElementDisplayed(CreateComputer.fieldError);
        compareExpectedWithActual("Introduced date\n" +
                "Date ('yyyy-MM-dd')", CreateComputer.fieldError.getText());
    }
}
