package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.qe.hawkular.util.HawkularRedHatAccess;
import org.testng.annotations.Test;

public class HawkularRHASupportCaseTest extends HawkularSeleniumLocalWebDriver {

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

	@Test
	public void hawkularListSupportcaseTest() throws Exception {
		WebDriver driver = hawkularLogin();
		HawkularRHASupportCasePage rhaSupport = new HawkularRHASupportCasePage(driver);

		rhaSupport.navigateToRHATab();
		rhaSupport.navigateToRHASupportmyCasesTab();

		HawkularRedHatAccess rha = new HawkularRedHatAccess(driver);
		rha.switchFrameFocusMyCases();
		rha.loginHere();
		rha.switchFrameFocus(true);
		rhaSupport.switchFrameFocus();
		rhaSupport.searchOpenTickets("Test");
		rhaSupport.verifyOpenCaseSearchResults();

		rha.logoutHere();
		driver.close();
	}

	@Test
	public void hawkularViewSupportcaseTest() throws Exception {
		WebDriver driver = hawkularLogin();
		HawkularRHASupportCasePage rhaSupport = new HawkularRHASupportCasePage(driver);

		rhaSupport.navigateToRHATab();
		rhaSupport.navigateToRHASupportmyCasesTab();

		HawkularRedHatAccess rha = new HawkularRedHatAccess(driver);
		rha.switchFrameFocusMyCases();
		rha.loginHere();
		rha.switchFrameFocus(true);
		rhaSupport.switchFrameFocus();
		rhaSupport.searchOpenandClosedTickets("01504304");
		rhaSupport.verifyOpenAndClosedSearchResult();
		rhaSupport.verifyCaseDetails();

		rha.logoutHere();
		driver.close();
	}

}
