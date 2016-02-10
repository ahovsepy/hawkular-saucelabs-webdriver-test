package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularAddDeploymentPage;
import org.qe.hawkular.page.HawkularAlertFilterPage;
import org.qe.hawkular.page.HawkularAlertsSettingsPage;
import org.qe.hawkular.page.HawkularAppServerPage;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularManageOrganizationsPage;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test case for adding deployment to the app server.
 *
 */

public class HawkularAddDeploymentTest extends HawkularSeleniumLocalWebDriver {
    WebDriver driver = null;
    HawkularLoginPage loginPage = null;
    HawkularConsoleAddUrlPage url = null;
    HawkularAppServerPage appserverPage = null;
    HawkularAddDeploymentPage adddeployment = null;
    HawkularUtils util = null;
    HawkularAlertFilterPage alertFilter = null;

    @BeforeMethod
    public void createBrowserInstance() throws MalformedURLException {

        driver = createLocalDriver();
        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());

        loginPage = new HawkularLoginPage(driver);
        appserverPage = new HawkularAppServerPage(driver);
        adddeployment = new HawkularAddDeploymentPage(driver);
        url = new HawkularConsoleAddUrlPage(driver);
        util = new HawkularUtils(driver);
        alertFilter = new HawkularAlertFilterPage(driver);

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);
        appserverPage.verifyLocalAppServerExists();
        appserverPage.navigateToLocalAppServer();
        appserverPage.navigateToDeploymentsTab();
    }

    @AfterMethod
    public void closeSession() {
        driver.quit();
    }

    @Test
    public void hawkularAddDeploymentTest() throws Exception {
        _logger.info("Deploy a war file in app server deployment tab");
        adddeployment.addDeploymentTab();
        adddeployment.uploadApplicationFile();
        adddeployment.deployApplication();
        adddeployment.verfiySuccess();
        // TODO check successful upload after fix of
        // https://issues.jboss.org/browse/HAWKULAR-678
        // driver.quit();
    }

    /**
     * Test to verify adding a deployment from 'OverView' tab of the app server.
     */
    
    @Test
    public void hawkularOverviewAddDeploymentTest() throws Exception {
        _logger.info("Deploy a war file from app server overview tab");
        appserverPage.navigateToOverviewTab();
        appserverPage.navigateToOverviewAddDeployment();
        adddeployment.overviewUploadApplicationFile();
        adddeployment.deployApplication();
        adddeployment.verfiySuccess();

    }

    /**
     * Test to verify if the alert settings for failed deployment alert exists.
     */
    @Test
    public void hawkularDeploymentAlertTest() throws Exception {
        _logger.info("Verifying alert settings/details for failed deployment alerts");
        adddeployment.verifyDeploymentAlertDetails();
        adddeployment.verifyDefinitionsLink();
        alertFilter.filter("Deployment Failure");
        alertFilter.verifyFailedDeploymentAlertExists();
        alertFilter.navigateToViewDetails();
        alertFilter.verifyFailedDeploymentAlertDetails();

    }

}
