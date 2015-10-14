package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularAddDeploymentPage;
import org.qe.hawkular.page.HawkularAppServerPage;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.testng.annotations.Test;

public class HawkularAddDeploymentTest extends HawkularSeleniumLocalWebDriver {

    public WebDriver hawkularLoginToDeployments() throws Exception {
        WebDriver driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username3,
                HawkularRegistrationPageConstants.password3);

        HawkularConsoleAddUrlPage clickAppServer = new HawkularConsoleAddUrlPage(
                driver);
        clickAppServer.navigateToAppServersMenu();

        HawkularAppServerPage selectAppServer = new HawkularAppServerPage(
                driver);

        selectAppServer.verifyLocalAppServerExists();
        selectAppServer.navigateToLocalAppServer();
        selectAppServer.navigateToDeploymentsTab();
        

        return driver;
    }

    @Test
    public void hawkularAddJDBCDriversTest() throws Exception {
        WebDriver driver = hawkularLoginToDeployments();
        HawkularAddDeploymentPage adddeployment = new HawkularAddDeploymentPage(
                driver);
        adddeployment.addDeploymentTab();
        adddeployment.uploadApplicationFile();
        adddeployment.deployApplication();
        adddeployment.verfiySuccess();
        // TODO check successful upload after fix of https://issues.jboss.org/browse/HAWKULAR-34
        driver.quit();
    }
}
