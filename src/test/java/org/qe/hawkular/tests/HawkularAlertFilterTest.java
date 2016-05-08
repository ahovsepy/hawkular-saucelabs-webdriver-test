package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularAlertsSettingsPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularAlertFilterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @author pyadav
 */

public class HawkularAlertFilterTest extends HawkularSeleniumLocalWebDriver {
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
    public void hawkularAlertSeverityFilterTest() throws Exception {
        driver = hawkularLogin();

        HawkularAlertFilterPage filter = new HawkularAlertFilterPage(driver);
        filter.navigateToAlertCenter();
        filter.filter("Medium");
        filter.verfiySeverity();

        // driver.close();

    }

    @Test
    public void hawkularAlertDescriptionFilterTest() throws Exception {
        driver = hawkularLogin();

        HawkularAlertFilterPage filter = new HawkularAlertFilterPage(driver);
        filter.navigateToAlertCenter();
        filter.filter("JVM");
        filter.verifyDescription();

        // driver.close();

    }

    @Test
    public void hawkularAlertChangeStateTest() throws Exception {
        driver = hawkularLogin();

        HawkularAlertFilterPage alertpage = new HawkularAlertFilterPage(driver);
        alertpage.navigateToAlertCenter();
        alertpage.filter("JVM Heap Used");
        alertpage.navigateToViewDetails();

        HawkularAlertsSettingsPage alertSetting = new HawkularAlertsSettingsPage(
                driver);
        alertSetting.editAlertDefinition();
        alertSetting.verifyEditAlertSuccessMsg();
        alertSetting.navigateToAllDefinitions();
        alertpage.navigateToAlertTab();
        alertpage.navigateToHeapUsedAlert();
        alertpage.acknowledgeAlert();
        alertpage.verifyAcknowledgedAlert();
        alertpage.ResolveAlert();
        alertpage.verifyResolvededAlert();

    }

}
