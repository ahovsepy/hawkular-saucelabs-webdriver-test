package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularAppServerPage;
import org.qe.hawkular.page.HawkularApplicationOverviewPage;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Prachi Yadav
 */

public class HawkularApplicationOverviewTest extends
        HawkularSeleniumLocalWebDriver {
    WebDriver driver = null;

    public WebDriver hawkularNavigateTOAppOverviewTab() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

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
    public void hawkularApplicationOverviewTest() throws Exception {
        WebDriver driver = hawkularNavigateTOAppOverviewTab();
        HawkularApplicationOverviewPage overview = new HawkularApplicationOverviewPage(
                driver);
        overview.accessApplicationOverview();

    }

}
