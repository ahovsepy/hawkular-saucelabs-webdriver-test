package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularAppServerPage;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularAlertNotificationsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


/**
 * @author pyadav
 */

public class HawkularAlertNotificationsTest extends HawkularSeleniumLocalWebDriver {
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
		HawkularConsoleAddUrlPage clickAppServer = new HawkularConsoleAddUrlPage(
                driver);
        clickAppServer.navigateToAppServersMenu();

        HawkularAppServerPage selectAppServer = new HawkularAppServerPage(
                driver);

        selectAppServer.verifyLocalAppServerExists();
        selectAppServer.navigateToLocalAppServer();
        selectAppServer.navigateToJVMTab();

		return driver; 	
	

	}
	
	@AfterMethod
	public void closeSession() {
		driver.quit();
	}
	
	
	@Test
	public void hawkularAlertNotificationsTest() throws Exception {
		WebDriver driver = hawkularLogin();
		
		HawkularAlertNotificationsPage notify= new HawkularAlertNotificationsPage(driver);
		
		notify.verifyAlertNotification();
		notify.verfiyNavigationToAlertDefinition();
		
//		driver.close();
		
		
	}

}
