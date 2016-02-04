package org.qe.hawkular.driver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

/**
 * Selenium Local Driver to use when tests need to be executed locally and not on saucelabs.
 *
 */

public class HawkularSeleniumLocalWebDriver {
    protected static org.slf4j.Logger _logger = null;
    
    // Must be one of: "trace", "debug", "info", "warn", or "error"
    private static String logLevel = "info";
    
    @BeforeSuite
    public void setupLogger() {
        // Over-ride: ${MAVEN_HOME}/conf/logging/simplelogger.properties
        System.setProperty("org.slf4j.simpleLogger.showDateTime", "true");
        System.setProperty("org.slf4j.simpleLogger.dateTimeFormat", "dd-MM-yy HH:mm:ss");
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", logLevel);
        System.setProperty("org.slf4j.simpleLogger.showShortLogName", "false");

        _logger = org.slf4j.LoggerFactory.getLogger("");
    }
    
    public WebDriver createLocalDriver() throws MalformedURLException {
        WebDriver localDriver = new FirefoxDriver();
        localDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    return localDriver;
    }

}
