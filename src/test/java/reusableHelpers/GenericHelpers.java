package reusableHelpers;

import ITrunner.InitConstants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class GenericHelpers extends InitConstants {

    public static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(FilenameUtils.normalize("src/test/resources/application.properties")));
        return prop;
    }

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

    protected static void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(browser, timeout).until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue("Element is not displayed after waitForElementToBeVisible Method", element.isDisplayed());
    }

    public static JSONObject getJsonData(String fileName) throws IOException {
        String filepath = (prop.getProperty("jsonData") + fileName + ".json");
        File file = new File(filepath);
        String JSONdata = FileUtils.readFileToString(file, "utf-8");
        return new JSONObject(JSONdata);
    }

    public static JSONObject getComputerDetails(String userReference) throws JSONException, IOException {
        return getJsonData("testData").getJSONObject("computerDetails").getJSONObject(userReference);
    }

    public static String getFirstSelectedOption(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText().trim();
    }

    public static String getValueFromElement(WebElement element) {
        return element.getAttribute("value").trim();
    }

    public static String dateFormat(String dateFormat) {
        try {
            DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = srcDf.parse(dateFormat);
            DateFormat destDf = new SimpleDateFormat("dd MMM yyyy");
            String formatDate = destDf.format(date);
            return formatDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat;
    }
}

