package pageObject;

import itRunner.InitConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateComputer extends ComputerForm {

    @FindBy(css = "input[class='btn primary']")
    public static WebElement createComputer;

    @FindBy(linkText = "Cancel")
    public static WebElement cancel;


    public static void initCreateComputer_Steps() {
        PageFactory.initElements(InitConstants.browser, CreateComputer.class);
    }
}
