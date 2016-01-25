package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HawkularDatasourcesTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;
	
    public WebDriver hawkularLoginToDeployments() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        loginPage.verifyLoginTitle();

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);

        HawkularConsoleAddUrlPage clickAppServer = new HawkularConsoleAddUrlPage(
                driver);
        clickAppServer.navigateToAppServersMenu();

        HawkularAppServerPage selectAppServer = new HawkularAppServerPage(
                driver);

        selectAppServer.verifyLocalAppServerExists();
        selectAppServer.navigateToLocalAppServer();
        selectAppServer.navigateToDatasourcesTab();

        return driver;
    }
    
    @AfterMethod
	public void closeSession() {
		driver.quit();
	}
    
    @Test
    public void hawkularAddJDBCDriversTest() throws Exception {
        driver = hawkularLoginToDeployments();
        HawkularDatasourcesPage page = new HawkularDatasourcesPage(
                driver);
        page.navigateAddDriverTab();
        page.loadDriverFile();
        page.defineDriverParams();
        page.addDriverSubmit();
        // TODO check successful upload after fix of https://issues.jboss.org/browse/HAWKULAR-674
//        driver.quit();
    }

    @Test
    public void hawkularExportJDRTest() throws Exception {
        driver = hawkularLoginToDeployments();
        HawkularDatasourcesPage page = new HawkularDatasourcesPage(
                driver);
        page.exportJDR();
        // TODO check successful download after fix of https://issues.jboss.org/browse/HAWKULAR-674
//        driver.quit();
    }
    
    /**
     * Test to verify JDR export from 'OverView' tab of the app server.
     */
@Test
    public void hawkularOverviewExportJDRTest() throws Exception {
        driver = hawkularLoginToDeployments();
        HawkularAppServerPage appserverPage = new HawkularAppServerPage(
                driver);
        appserverPage.navigateToOverviewTab();
        HawkularDatasourcesPage page = new HawkularDatasourcesPage(
                driver);
        page.overviewExportJDR();
        // TODO check successful download with handling of file download dialog box
//        driver.quit();
    }
    
    @Test
    public void hawkularAddDataSourceTest() throws Exception {
        driver = hawkularLoginToDeployments();
        HawkularDatasourcesPage page = new HawkularDatasourcesPage(
                driver);
        page.addDatasourceType();
        page.addDatasourceAttribute();
        page.addDatasourceDriverParams();
        page.addDatasourceConnSettings();
        page.datasourceAdd();
        page.addDatasourceVerifySuccess();
 //       driver.quit();
        
    }
     
    /**
     * Test to verify adding a datasource from 'OverView' tab of the app server.
     */
    @Test
    public void hawkularOverviewAddDataSourceTest() throws Exception {
        driver = hawkularLoginToDeployments();
        HawkularAppServerPage appserverPage = new HawkularAppServerPage(
                driver);
        appserverPage.navigateToOverviewTab();
        appserverPage.navigateToOverviewAddDatasource();
        HawkularDatasourcesPage page = new HawkularDatasourcesPage(
                driver);
        page.overviewAddDatasourceType();
        page.overviewAddDatasourceAttribute();
        page.addDatasourceDriverParams();
        page.addDatasourceConnSettings();
        page.datasourceAdd();
        page.addDatasourceVerifySuccess();
 //       driver.quit();
        
    }
    
    @Test
    public void hawkularDeleteDataSourceTest() throws Exception {
        driver = hawkularLoginToDeployments();
        HawkularDatasourcesPage page = new HawkularDatasourcesPage(
                driver);
        page.deleteDatasource();
        page.verifyDeleteDatasource();
 //        driver.quit();
 // TODO Test datasource deletion from UI after disable and delete the datasource. Disable datasource seems not yet implemented.
    }

}
