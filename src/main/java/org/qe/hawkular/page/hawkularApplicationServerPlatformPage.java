package org.qe.hawkular.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.qe.hawkular.element.HawkularAppServerPageConstants;
import org.qe.hawkular.element.HawkularApplicationOverviewConstants;
import org.qe.hawkular.element.hawkularApplicationServerPlatformConstants;
import org.qe.hawkular.util.HawkularUtils;

/**
*
* @author Prachi Yadav
*/


public class hawkularApplicationServerPlatformPage {
	
	public final WebDriver driver;

	public hawkularApplicationServerPlatformPage(WebDriver driver) {

	    this.driver = driver;

	}
	
	By ApplicationServerTab= HawkularApplicationOverviewConstants.ApplicationServerTab;
	
	By localWildfyServerLink= HawkularAppServerPageConstants.localWildfyServerLink;
	By appserverPlatformTabLink= HawkularAppServerPageConstants.appserverPlatformTabLink;
	
	
	By platformMemoryUsageGraph= hawkularApplicationServerPlatformConstants.platformMemoryUsageGraph;
	By platformAlerts= hawkularApplicationServerPlatformConstants.platformAlerts;
	By platformCpuUsage= hawkularApplicationServerPlatformConstants.platformCpuUsage;
	By platformProcessor= hawkularApplicationServerPlatformConstants.platformProcessor;
	By platformFileSystemUsage= hawkularApplicationServerPlatformConstants.platformFileSystemUsage;
	
	public void checkAppPlatform()
	
	{
		
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(ApplicationServerTab);
		utils.navigateTo(localWildfyServerLink);
		utils.navigateTo(appserverPlatformTabLink);
	//	utils.waitForElementPresent(platformMemoryUsageGraph);
		utils.waitForElementPresent(platformAlerts);
	//	utils.waitForElementPresent(platformCpuUsage);
	//	utils.waitForElementPresent(platformProcessor);
		utils.waitForElementPresent(platformFileSystemUsage);
		
	}
	

}
