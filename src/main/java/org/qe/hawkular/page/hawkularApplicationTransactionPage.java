package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAppServerPageConstants;
import org.qe.hawkular.element.HawkularApplicationOverviewConstants;
import org.qe.hawkular.element.hawkularApplicationTransactionConstatnts;
import org.qe.hawkular.util.HawkularUtils;

public class hawkularApplicationTransactionPage {
	
	public final WebDriver driver;

	public hawkularApplicationTransactionPage(WebDriver driver) {

	    this.driver = driver;

	}
	
    By ApplicationServerTab= HawkularApplicationOverviewConstants.ApplicationServerTab;
	
	By localWildfyServerLink= HawkularAppServerPageConstants.localWildfyServerLink;
	By appserverTransactionsTabLink= HawkularAppServerPageConstants.appserverTransactionsTabLink;
	
	By transactionMetrics=hawkularApplicationTransactionConstatnts.transactionMetrics;
	By transactionGraph=hawkularApplicationTransactionConstatnts.transactionGraph;
	By transactionsAlert=hawkularApplicationTransactionConstatnts.transactionsAlert;
	By transactionStatus=hawkularApplicationTransactionConstatnts.transactionStatus;
	
public void checkAppTransaction()
	
	{
		
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(ApplicationServerTab);
		utils.navigateTo(localWildfyServerLink);
		utils.navigateTo(appserverTransactionsTabLink);
		utils.waitForElementPresent(transactionMetrics);
	//	utils.waitForElementPresent(transactionGraph);
		utils.waitForElementPresent(transactionsAlert);
		utils.waitForElementPresent(transactionStatus);
		
	}
	


}
