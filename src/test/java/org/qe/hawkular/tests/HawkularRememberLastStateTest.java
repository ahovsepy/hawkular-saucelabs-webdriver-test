package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularManageOrganizationsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HawkularRememberLastStateTest extends HawkularSeleniumLocalWebDriver {
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
	    
	    // Test to verify if last state before login is remembered after relogin.
	    //To-do also with changing the persona and checking if it remembers the last state.
	    
	    @Test
	    public void hawkularRememberLastState() throws Exception {
	        driver = hawkularLogin();
	        HawkularManageOrganizationsPage page = new HawkularManageOrganizationsPage(driver);

	        page.toManageOrganizationsTab();
	        page.navigateToURLsPage();	               
	        
	        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

			loginPage.logout();
			
			loginPage.loginAs(HawkularRegistrationPageConstants.username2,
					HawkularRegistrationPageConstants.password2);
			page.verfiyURLsPage();


	    }
	    

}
