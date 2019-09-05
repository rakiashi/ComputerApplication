package ITrunner;

import com.aventstack.extentreports.service.ExtentService;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import reusableHelpers.GenericHelpers;
import reusableHelpers.SeleniumHelpers;
import stepDefinitions.AddComputerPage;
import stepDefinitions.EditComputerPage;
import stepDefinitions.ComputerDatabasePage;

import java.io.IOException;

import static ITrunner.InitConstants.*;

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
            Assert.fail();
        }
    }

    @AfterClass
    public static void afterAll() {
        browser.close();
    }
}