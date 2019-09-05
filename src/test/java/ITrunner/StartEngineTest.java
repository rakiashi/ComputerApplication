package ITrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import reusableHelpers.GenericHelpers;
import reusableHelpers.SeleniumHelpers;
import stepDefinitions.AddComputerPage;
import stepDefinitions.ComputerDatabasePage;
import stepDefinitions.EditComputerPage;

import java.io.IOException;

import static ITrunner.InitConstants.browser;
import static ITrunner.InitConstants.prop;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, dryRun = false,
        features = {"src/test/java/features/"},
        glue = {"stepDefinitions"},
        plugin = {"html:target/site/cucumber-pretty", "json:target/cucumber.json"},
        tags = "@test")

public class StartEngineTest {

    @BeforeClass
    public static void beforeAll() throws IOException {
        try {
            prop = GenericHelpers.getProperties();
            SeleniumHelpers.initiateBrowser();
            AddComputerPage.initAddComputer_Steps();
            ComputerDatabasePage.initHomePage_Steps();
            EditComputerPage.initEditPage_Steps();
        } catch (Exception e) {
            Assert.fail("Initializing Error" + e.getMessage());
        }
    }

    @AfterClass
    public static void afterAll() {
        browser.close();
    }
}