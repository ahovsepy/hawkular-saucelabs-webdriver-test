package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularManageOrganizationsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @author vprusa
 */
public class HawkularOrganizationsTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;

    public WebDriver hawkularLogin() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());

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
    public void hawkularCreateNewOrgTest() throws Exception {
        driver = hawkularLogin();
        HawkularManageOrganizationsPage page = new HawkularManageOrganizationsPage(driver);

        page.toManageOrganizationsTab();
        page.createOrganization();

//        driver.quit();
    }

    @Test
    public void hawkularDeleteOrgTest() throws Exception {
        driver = hawkularLogin();
        HawkularManageOrganizationsPage page = new HawkularManageOrganizationsPage(driver);

        page.toManageOrganizationsTab();
        page.removeOrganization(0);

 //       driver.quit();
    }
    
    @Test
    public void hawkularListUserOrgTest() throws Exception {
        driver = hawkularLogin();
        HawkularManageOrganizationsPage page = new HawkularManageOrganizationsPage(driver);

        page.toManageOrganizationsTab();
        page.createOrganization();
        page.listOrganization();
        page.removeOrganization(0);

//        driver.quit();
    }
    
    @Test
	public void hawkularInviteUserToOrgTest() throws Exception {
		driver = hawkularLogin();
	
		HawkularManageOrganizationsPage page = new HawkularManageOrganizationsPage(driver);
		page.toManageOrganizationsTab();
		page.createOrganization();
		page.invitePeople();
		page.enterEmail("jdoe@acme.com");
		page.verfiySuccess();
		page.navigateToAllOrganizations();
		page.removeOrganization(0);
				
//		driver.quit();
	}

}
