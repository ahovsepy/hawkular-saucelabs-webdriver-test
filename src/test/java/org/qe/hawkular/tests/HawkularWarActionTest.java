package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Test case to test enable/disable/redeploy actions for app server deployments.
 *
 */

public class HawkularWarActionTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;

	@AfterMethod
	public void closeSession() {
		driver.quit();
	}
	
	public WebDriver hawkularLoginToDeployments() throws Exception {
		WebDriver driver = createLocalDriver();

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
		selectAppServer.navigateToDeploymentsTab();
		return driver;
	}

	public void verifyAndQuit(HawkularDepoymentActionPage test, WebDriver driver) {
		test.verfiySuccess();
		// driver.quit();
	}

	@Test
	public void hawkularRedeployWarTest() throws Exception {
		driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testRedeploy = new HawkularDepoymentActionPage(
				driver);
		testRedeploy.checkFirstWar();
		testRedeploy.clickWarAction();
		testRedeploy.clickToRedeployWar();
		
		verifyAndQuit(testRedeploy, driver);

	}

	@Test
	public void hawkularEnableWarTest() throws Exception {
		driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		testEnableWar.checkFirstWar();
		testEnableWar.clickWarAction();
		testEnableWar.clickToEnableWar();
		
		verifyAndQuit(testEnableWar, driver);
	}

	@Test
	public void hawkularDisableWarTest() throws Exception {
		driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testDisableWar = new HawkularDepoymentActionPage(
				driver);
		testDisableWar.checkFirstWar();
		testDisableWar.clickWarAction();
		testDisableWar.clickToDisableWar();
		
		verifyAndQuit(testDisableWar, driver);
	}

	@Test
	public void hawkularRemoveWarTest() throws Exception {
		driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		testEnableWar.checkFirstWar();
		testEnableWar.clickWarAction();
		testEnableWar.clickToRemoveWar();
		
		verifyAndQuit(testEnableWar, driver);
	}

	@Test
	public void hawkularRemoveMultipleWars() throws Exception {
		driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		testEnableWar.clickAllWarsAction();
		testEnableWar.clickToRemoveWar();
		
		verifyAndQuit(testEnableWar, driver);
	}

	@Test
	public void hawkularEnableMultipleWarsTest() throws Exception {
		driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		
		testEnableWar.clickAllWarsAction();
		testEnableWar.clickToEnableWar();
		
		verifyAndQuit(testEnableWar, driver);
	}

	@Test
	public void hawkularDisableMultipleWarsTest() throws Exception {
		driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testDisableWar = new HawkularDepoymentActionPage(
				driver);

		testDisableWar.clickAllWarsAction();
		testDisableWar.clickToDisableWar();
		
		verifyAndQuit(testDisableWar, driver);
	}

	@Test
	public void hawkularRedeployMultipleWarsTest() throws Exception {
		driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testDisableWar = new HawkularDepoymentActionPage(
				driver);
		
//		testDisableWar.clickAllWarsAction();
		testDisableWar.clickWarAction();
		testDisableWar.clickToRedeployWar();

		verifyAndQuit(testDisableWar, driver);
	}

}
