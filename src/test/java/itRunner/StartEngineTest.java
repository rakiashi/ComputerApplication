package itRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import pageObject.ComputerDatabase;
import pageObject.ComputerForm;
import pageObject.CreateComputer;
import pageObject.EditComputer;
import reusableHelpers.JavaHelpers;
import reusableHelpers.SeleniumHelpers;

import java.io.IOException;

import static itRunner.InitConstants.browser;
import static itRunner.InitConstants.prop;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, dryRun = false,
        features = {"src/test/java/features/"},
        glue = {"stepDefinitions"},
        plugin = {"html:target/site/cucumber-pretty", "json:target/cucumber.json"},
        tags = "@test")

public class StartEngineTest {

    // This BeforeClass executes before every scenario to initialize elements of respective pages
    @BeforeClass
    public static void beforeAll() throws IOException {
        try {
            prop = JavaHelpers.getProperties();
            SeleniumHelpers.initiateBrowser();
            ComputerDatabase.initComputerDatabase_Steps();
            ComputerForm.initComputerForm_Steps();
            CreateComputer.initCreateComputer_Steps();
            EditComputer.initEditComputer_Steps();
        } catch (Exception e) {
            Assert.fail("Initializing Error" + e.getMessage());
        }
    }

    // This AfterClass method executes after each scenario to close the browser
    @AfterClass
    public static void afterAll() {
        browser.close();
    }
}