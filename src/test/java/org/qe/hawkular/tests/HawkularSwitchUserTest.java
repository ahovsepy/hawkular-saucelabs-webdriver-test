package org.qe.hawkular.tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularManageOrganizationsPage;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.Assert;
import org.testng.annotations.*;

public class HawkularSwitchUserTest extends HawkularSeleniumLocalWebDriver {
    WebDriver driver = null;
    HawkularLoginPage loginPage = null;
    HawkularManageOrganizationsPage orgPage = null;
    HawkularConsoleAddUrlPage url = null;
    HawkularUtils util = null;
    
	@BeforeMethod
    public void createBrowserInstance() throws MalformedURLException {
        driver = createLocalDriver();
        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
    	
        loginPage = new HawkularLoginPage(driver);
        orgPage = new HawkularManageOrganizationsPage(driver);
        url = new HawkularConsoleAddUrlPage(driver);
        util = new HawkularUtils(driver);
    	
        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                          HawkularRegistrationPageConstants.password2);
    }
    
    @AfterMethod
    public void closeSession() {
        driver.quit();
    }
    
    @Test
    public void switchUserTest() throws InterruptedException, NoSuchFieldException, IOException {
    	
        // Create new Organization, and add a URL to that new Org
        orgPage.toManageOrganizationsTab();
        orgPage._createOrganization();
        orgPage.navigateToNewOrg();
        url.navigateToURLsMenu();
        url.typeURL(HawkularManagementConsolePageConstants.testURL2);
        url.submitURLAndWaitToBeAdded(HawkularManagementConsolePageConstants.testURL2);
        Assert.assertTrue(util.isTextOnPage(HawkularManagementConsolePageConstants.testURL2));
	  
        // Validate that on JDoe Org, the URL that was added to "New Org" is not present
        orgPage.navigateToJDoeUser(); 
        url.navigateToURLsMenu();
        Assert.assertFalse(util.isTextOnPage(HawkularManagementConsolePageConstants.testURL2));
    }
}
