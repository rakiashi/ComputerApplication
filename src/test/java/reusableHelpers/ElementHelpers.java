package reusableHelpers;

import itRunner.InitConstants;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelpers extends InitConstants {

//    ---Element Helpers ---------------------------------------------------------------------------------------------------

    public static void enterValueInEditField(WebElement element, String valueToEnter) {
        element.clear();
        element.sendKeys(valueToEnter);
    }

    public static void selectValueInGivenElement(WebElement element, String valueToSelect) {
        Select select = new Select(element);
        select.selectByVisibleText(valueToSelect);
    }

    public static void compareExpectedWithActual(String ExpectedValue, String ActualValue) {
        Assert.assertEquals("Compare", ExpectedValue, ActualValue);
    }

    public static void verifyElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is Not enabled in verifyElementDisplayed Method", element.isEnabled());
        Assert.assertTrue("Element is Not displayed after verifyElementDisplayed Method", element.isDisplayed());
    }

    public static void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(browser, timeout).until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue("Element is not displayed after waitForElementToBeVisible Method", element.isDisplayed());
    }

    public static String getFirstSelectedOption(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText().trim();
    }

    public static String getValueFromElement(WebElement element) {
        return element.getAttribute("value").trim();
    }

    //    ---Element Helpers ---------------------------------------------------------------------------------------------------


}

