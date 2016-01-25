package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularApplicationOverviewConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularApplicationOverviewPage {
	public final WebDriver driver;

	public HawkularApplicationOverviewPage(WebDriver driver) {

	    this.driver = driver;

	}
	
	By ApplicationServerTab= HawkularApplicationOverviewConstants.ApplicationServerTab;
	By ApplicationServer= HawkularApplicationOverviewConstants.ApplicationServer;
	By OverviewTab= HawkularApplicationOverviewConstants.OverviewTab;
	By ServerDetails= HawkularApplicationOverviewConstants.ServerDetails;
	By CommonTasks= HawkularApplicationOverviewConstants.CommonTasks;
	By StatusOverview= HawkularApplicationOverviewConstants.StatusOverview;
	By ServerAlerts= HawkularApplicationOverviewConstants.ServerAlerts;
	
	
	public void accessApplicationOverview(){
		
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(ApplicationServerTab);
		utils.waitForElementPresent(ApplicationServer);
		utils.navigateTo(ApplicationServer);
		utils.waitForElementPresent(OverviewTab);
		utils.navigateTo(OverviewTab);
		utils.waitForElementPresent(ServerDetails);
		utils.waitForElementPresent(CommonTasks);
		utils.waitForElementPresent(StatusOverview);
		utils.waitForElementPresent(ServerAlerts);
		
		
	}
	
	

}
