package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @author skondkar
 */
public class HawkularUserSettingsTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;

    public WebDriver hawkularLogin() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        loginPage.verifyLoginTitle();

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);

        return driver;
    }
    
    @AfterMethod
	public void closeSession() {
		driver.quit();
	}

    @Test
    public void hawkularUserSettingsTest() throws Exception {
        WebDriver driver = hawkularLogin();
        HawkularUserSettingsPage page = new HawkularUserSettingsPage(driver);

        page.navigateToUserSettings();
        page.addEmailNotification();
//        driver.quit();
    }    

}