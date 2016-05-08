package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularAlertFilterPage;
import org.qe.hawkular.page.HawkularAlertsSettingsPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Test case on alerts and alert settings
 *
 */

public class HawkularAlertsSettingsTest extends HawkularSeleniumLocalWebDriver {
    WebDriver driver = null;

    public WebDriver hawkularNavigateToAlertSettings() throws Exception {
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

    /**
     * Test case on edit alerts and verify if alert is being saved.
     *
     */

    @Test
    public void hawkularEditAlertTest() throws Exception {
        driver = hawkularNavigateToAlertSettings();

        HawkularAlertFilterPage alertSetting = new HawkularAlertFilterPage(
                driver);
        alertSetting.navigateToAlertCenter();
        alertSetting.filter("JVM Heap Used");
        alertSetting.navigateToViewDetails();

        HawkularAlertsSettingsPage page = new HawkularAlertsSettingsPage(driver);
        page.editAlertDefinition();
        page.verifyEditAlertSuccessMsg();
        page.navigateToAllDefinitions();
        alertSetting.filter("JVM Heap Used");
        alertSetting.navigateToViewDetails();
        page.verifyAlertSettingDetails();

    }

}
