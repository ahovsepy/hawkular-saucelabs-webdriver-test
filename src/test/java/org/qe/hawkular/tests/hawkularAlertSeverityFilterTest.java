package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.hawkularAlertSeverityFilterPage;
import org.testng.annotations.Test;

/**
 * @author pyadav
 */

public class hawkularAlertSeverityFilterTest  extends HawkularSeleniumLocalWebDriver {

	public WebDriver hawkularLogin() throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username,
				HawkularRegistrationPageConstants.password);

		return driver; 	
	

	}
	
	@Test
	public void hawkularAlertSevFilterTest() throws Exception {
		WebDriver driver = hawkularLogin();
		
		hawkularAlertSeverityFilterPage filter= new hawkularAlertSeverityFilterPage(driver);
		filter. navigateToAlertCenter();
		filter.filter("High");
		filter.verfiySeverity();
		
		
		driver.close();
		
	}
	
	@Test
	public void hawkularAlertDescriptionFilterTest() throws Exception {
		WebDriver driver = hawkularLogin();
		
		hawkularAlertSeverityFilterPage filter= new hawkularAlertSeverityFilterPage(driver);
		filter. navigateToAlertCenter();
		filter.filter("Available Connection");
		filter.verfiySeverity();
		filter.verifyDescription();
		
		driver.close();
		
	}
}
