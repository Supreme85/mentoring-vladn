package ca.simple.automation;

import ca.simple.automation.enums.BrowserTypes;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import static ca.simple.automation.enums.BrowserTypes.CHROME;
import static org.openqa.selenium.ie.InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS;

/**
 * Created by Roman_Iovlev on 1/22/2018.
 */
public class DriverManager {
    public static WebDriver getDriver() { return getDriver(CHROME); }
    public static WebDriver getDriver(BrowserTypes driverType) {
        switch (driverType) {
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver();
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            case IE:
                InternetExplorerDriverManager.getInstance().setup();
                InternetExplorerOptions cap = new InternetExplorerOptions();
                cap.setCapability(INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                cap.setCapability("ignoreZoomSetting", true);
                return new InternetExplorerDriver(cap);
            default:
                throw new RuntimeException("Unknown driver: " + driverType);
        }

    }
}
