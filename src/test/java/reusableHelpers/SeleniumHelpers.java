package reusableHelpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import ITrunner.InitConstants;
import java.io.IOException;

public class SeleniumHelpers extends InitConstants {

    public static void initiateBrowser() throws IOException {
        operatingSystem=prop.getProperty("os");
        browserName = prop.getProperty("browser");
        headLess = Boolean.parseBoolean(prop.getProperty("headLess"));
        switch (operatingSystem){
            case "Win":
                browser = windowsBrowserConfiguration(browserName);
                break;
            case "Mac":
                browser = macBrowserConfiguration(browserName);
                break;
        }
    }

    private static WebDriver windowsBrowserConfiguration(String browserName) {
        WebDriver browserToOpen = null;
        if (browserName.toLowerCase().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(headLess);
            browserToOpen = new FirefoxDriver(options);
        } else if (browserName.toLowerCase().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(headLess);
            options.addArguments("--window-size=1280,1700");
            browserToOpen = new ChromeDriver(options);
        } else if (browserName.toLowerCase().equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.ignoreZoomSettings();
            options.destructivelyEnsureCleanSession();
            options.enablePersistentHovering();
            options.introduceFlakinessByIgnoringSecurityDomains();
            options.requireWindowFocus();
            browserToOpen = new InternetExplorerDriver(options);
        } else if (browserName.toLowerCase().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            browserToOpen = new EdgeDriver(options);
        }
        return browserToOpen;
    }

    private static WebDriver macBrowserConfiguration(String browserName) {
        WebDriver browserToOpen = null;
        if (browserName.toLowerCase().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(headLess);
            browserToOpen = new FirefoxDriver(firefoxOptions);
        } else if (browserName.toLowerCase().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(headLess);
            options.addArguments("--window-size=1280,1700");
            browserToOpen = new ChromeDriver(options);
        } else if (browserName.toLowerCase().equalsIgnoreCase("safari")) {
            SafariOptions option = new SafariOptions();
            browserToOpen = new SafariDriver(option);
        }
        return browserToOpen;
    }
}

