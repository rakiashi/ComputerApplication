package pageObject;

import itRunner.InitConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerForm  {

    //--------------- Add Computer locators -------------------------------------------------------

    @FindBy(id = "name")
    public static WebElement name;

    @FindBy(id = "introduced")
    public static WebElement introduced;

    @FindBy(id = "discontinued")
    public static WebElement discontinued;

    @FindBy(id = "company")
    public static WebElement company;

    @FindBy(css = "form [class='clearfix error']")
    public static WebElement fieldError;


    public static void initComputerForm_Steps() {
        PageFactory.initElements(InitConstants.browser, ComputerForm.class);
    }
    // ------------------------------------------------------------------------------------------
}
