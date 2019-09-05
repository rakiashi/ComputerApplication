package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.AddEdit;
import reusableHelpers.GenericHelpers;
import java.io.IOException;
import java.util.List;

public class EditComputerPage extends GenericHelpers {

    //--------------- Edit Computer locators -------------------------------------------------------
    @FindBy(id = AddEdit.name)
    public static WebElement name;

    @FindBy(id = AddEdit.introduced)
    public static WebElement introduced;

    @FindBy(id = AddEdit.discontinued)
    public static WebElement discontinued;

    @FindBy(id = AddEdit.company)
    public static WebElement company;

    @FindBy(css = AddEdit.createSave)
    public static WebElement saveComputer;

    @FindBy(linkText = AddEdit.cancel)
    public static WebElement cancel;

    @FindBy(css = AddEdit.delete)
    public static WebElement deleteComputer;

    // -------------------------------------------------------------------------------

    public static void initEditPage_Steps() {
        PageFactory.initElements(browser, EditComputerPage.class);
    }

    @And("^I update computer \"([^\"]*)\" with \"([^\"]*)\"$")
    public void iUpdateComputerWith(String fieldName, String valueToEnter) {
        WebElement fieldNameElement = browser.findElement(By.id(fieldName));
        enterValueInEditField(fieldNameElement, valueToEnter);
    }

    @Then("^I (updated|canceled|deleted) computer details$")
    public void iUpdatedCanceledComputerDetails(String expectedCondition) {
        switch (expectedCondition) {
            case "updated":
                saveComputer.click();
                break;
            case "canceled":
                cancel.click();
                break;
            case "deleted":
                deleteComputer.click();
                break;
            default:
        }
        waitForElementToBeVisible(ComputerDatabasePage.searchbox);
    }

    @Then("^I see computer \"([^\"]*)\" details$")
    public void iShouldBeAbleToReadThoseComputerDetails(String ComputerName, List<String> expectedValues) throws IOException {
        waitForElementToBeVisible(ComputerDatabasePage.selectFirstItem);
        if (ComputerDatabasePage.selectFirstItem.getText().trim().equalsIgnoreCase(ComputerName)) {
            ComputerDatabasePage.selectFirstItem.click();
            waitForElementToBeVisible(name);
            compareExpectedWithActual(expectedValues.get(0), getValueFromElement(name));
            compareExpectedWithActual(expectedValues.get(1), getValueFromElement(introduced));
            compareExpectedWithActual(expectedValues.get(2), getValueFromElement(discontinued));
            compareExpectedWithActual(expectedValues.get(3), getFirstSelectedOption(company));
        }else{
            Assert.fail();
        }
    }
}
