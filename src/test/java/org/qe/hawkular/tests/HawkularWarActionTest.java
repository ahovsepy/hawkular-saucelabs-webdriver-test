package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.Test;

public class HawkularWarActionTest extends HawkularSeleniumLocalWebDriver {

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
		selectAppServer.navigateTOLocalAppServer();
		selectAppServer.navigateTODeploymentsTab();
		return driver;
	}
	
	@Test
	public void hawkularLoginRemove() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();

		// INFO - hawkular global Action so far apply to all if none selected
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		testEnableWar.clickAllWarsAction();
		testEnableWar.clickToRemoveWar();
		testEnableWar.verfiySuccess();

		driver.quit();

	}
	
	@Test
	public void hawkularLoginRemoveAll() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();


		// INFO - hawkular global Action so far apply to all if none selected
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		testEnableWar.clickAllWarsAction();
		testEnableWar.clickToRemoveWar();
		testEnableWar.verfiySuccess();

		driver.quit();

	}

	@Test
	public void hawkularLoginEnableAll() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();

		// INFO - hawkular global Action so far apply to all if none selected
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		testEnableWar.clickAllWarsAction();
		testEnableWar.clickToEnableWar();
		testEnableWar.verfiySuccess();

		driver.quit();

	}

	@Test
	public void hawkularLoginDisableAll() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();

		HawkularDepoymentActionPage testDisableWar = new HawkularDepoymentActionPage(
				driver);
		// INFO - hawkular global Action so far apply to all if none selected
		testDisableWar.clickAllWarsAction();
		testDisableWar.clickToDisableFirstWar();
		testDisableWar.verfiySuccess(); // TODO - check if isnt 404 also
										// with/instead of verfiySuccess()
		driver.quit();
	}

	@Test
	public void hawkularLoginRedeploy() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();

		HawkularDepoymentActionPage testRedeploy = new HawkularDepoymentActionPage(
				driver);
		testRedeploy.clickFirstWarAction();
		testRedeploy.clickToRedeployFirstWar();
		testRedeploy.verfiySuccess();

		driver.quit();
	}

	@Test
	public void hawkularLoginEnable() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();

		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		testEnableWar.clickFirstWarAction();
		testEnableWar.clickToEnableWar();
		testEnableWar.verfiySuccess();

		driver.quit();

	}

	@Test
	public void hawkularLoginDisable() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();

		HawkularDepoymentActionPage testDisableWar = new HawkularDepoymentActionPage(
				driver);
		testDisableWar.clickFirstWarAction();
		testDisableWar.clickToDisableFirstWar();
		testDisableWar.verfiySuccess();

		driver.quit();
	}

}
