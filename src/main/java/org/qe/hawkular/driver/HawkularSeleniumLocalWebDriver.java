package org.qe.hawkular.driver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

/**
 * Selenium Local Driver to use when tests need to be executed locally and not on saucelabs.
 *
 */

public class HawkularSeleniumLocalWebDriver {
    public static String LOGGER_HAWKULAR_QE_UI = "hawkular.qe.ui";
    protected static Logger _logger = LoggerFactory.getLogger(LOGGER_HAWKULAR_QE_UI);
    
    public WebDriver createLocalDriver() throws MalformedURLException {
        WebDriver localDriver = new FirefoxDriver();
        localDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    return localDriver;
    }

}
