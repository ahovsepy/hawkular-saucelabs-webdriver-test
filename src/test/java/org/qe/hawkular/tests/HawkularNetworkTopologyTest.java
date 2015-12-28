package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularNetworkTopologyPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @author pyadav
 */

public class HawkularNetworkTopologyTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;
	
	@AfterMethod
	public void closeSession() {
		driver.quit();
	}

	@Test
	public void hawkularNavigateNetworkTopologyTest() throws Exception {
		driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username2,
				HawkularRegistrationPageConstants.password2);
		HawkularNetworkTopologyPage topology= new HawkularNetworkTopologyPage(driver);
		topology. navigateToTopology();
		
	}
	
}
