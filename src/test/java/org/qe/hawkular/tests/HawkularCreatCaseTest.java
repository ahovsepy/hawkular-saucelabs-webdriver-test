package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularCreateCasePage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRedHatAccessPage;
import org.testng.annotations.Test;

public class HawkularCreatCaseTest  extends HawkularSeleniumLocalWebDriver {

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
	public void hawkularCreateSupportcaseTest() throws Exception {
		WebDriver driver = hawkularLogin();
	
		HawkularCreateCasePage create = new HawkularCreateCasePage(driver);
		
		create.clickRedHatAccess();
		
		HawkularRedHatAccessPage rha = new HawkularRedHatAccessPage(driver);
		rha.switchFrameFocusCreateCase();
		rha.loginHere();
		rha.switchFrameFocus(true);

		create.switchFrameFocus();
		create.createSupportCase();
		create.issue("Test Ignore","Test Ignore");
		create.nextPage();
		rha.logoutHere();
		driver.close();
		
			
		
	}
}
