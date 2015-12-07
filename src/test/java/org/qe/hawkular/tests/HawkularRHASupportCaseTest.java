package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Test case to list and view the details of support case.
 *
 * @author Sunil Kondkar
 */

public class HawkularRHASupportCaseTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;

	public WebDriver hawkularLogin() throws Exception {
		WebDriver driver = createLocalDriver();

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
	public void hawkularListSupportcaseTest() throws Exception {
		driver = hawkularLogin();
		HawkularRHASupportCasePage rhaSupport = new HawkularRHASupportCasePage(driver);

		rhaSupport.navigateToRHATab();
		rhaSupport.navigateToRHASupportmyCasesTab();

		HawkularRedHatAccessPage rha = new HawkularRedHatAccessPage(driver);
		rha.switchFrameFocusMyCases();
		rha.loginHere();
		rha.switchFrameFocus(true);
		rhaSupport.switchFrameFocus();
		rhaSupport.searchOpenTickets("Test");
		rhaSupport.verifyOpenCaseSearchResults();

//		rha.logoutHere(); 
	}

	@Test
	public void hawkularViewSupportcaseTest() throws Exception {
		driver = hawkularLogin();
		HawkularRHASupportCasePage rhaSupport = new HawkularRHASupportCasePage(driver);

		rhaSupport.navigateToRHATab();
		rhaSupport.navigateToRHASupportmyCasesTab();

		HawkularRedHatAccessPage rha = new HawkularRedHatAccessPage(driver);
		rha.switchFrameFocusMyCases();
		rha.loginHere();
		rha.switchFrameFocus(true);
		rhaSupport.switchFrameFocus();
		rhaSupport.searchOpenandClosedTickets("01504304");
		rhaSupport.verifyOpenAndClosedSearchResult();
		rhaSupport.verifyCaseDetails();

//		rha.logoutHere();
	}

}
