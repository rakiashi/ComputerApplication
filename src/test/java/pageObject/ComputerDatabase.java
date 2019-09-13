package pageObject;

import itRunner.InitConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerDatabase {

    //--------------- ComputerDatabaseSteps WebElements -------------------------------------------------------

    @FindBy(id = "searchbox")
    public static WebElement searchbox;

    @FindBy(id = "searchsubmit")
    public static WebElement searchsubmit;

    @FindBy(css = "#main > table > tbody > tr:nth-child(1) > td:nth-child(1) > a")
    public static WebElement computerNameFirstItem;

    @FindBy(css = "#main > table > tbody > tr:nth-child(1) > td:nth-child(2) ")
    public static WebElement introducedFirstItem;

    @FindBy(css = "#main > table > tbody > tr:nth-child(1) > td:nth-child(3) ")
    public static WebElement discontinuedFirstItem;

    @FindBy(css = "#main > table > tbody > tr:nth-child(1) > td:nth-child(4) ")
    public static WebElement companyFirstItem;

    @FindBy(css = "section [class='alert-message warning']")
    public static WebElement alertMessage;

    @FindBy(css = "section [class=well]")
    public static WebElement nothingToDisplay;

    @FindBy(id = "add")
    public static WebElement addComputer;


    public static void initComputerDatabase_Steps() {
        PageFactory.initElements(InitConstants.browser, ComputerDatabase.class);
    }
    // -------------------------------------------------------------------------------

}

