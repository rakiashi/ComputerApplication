package pageObject;

import itRunner.InitConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditComputer extends ComputerForm {

    @FindBy(css = "input[class='btn primary']")
    public static WebElement saveComputer;

    @FindBy(css = "#main > form.topRight > input")
    public static WebElement deleteComputer;


    public static void initEditComputer_Steps() {
        PageFactory.initElements(InitConstants.browser, EditComputer.class);
    }
}
