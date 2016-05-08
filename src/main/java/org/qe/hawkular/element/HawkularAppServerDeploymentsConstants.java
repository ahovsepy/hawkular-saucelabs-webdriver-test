package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAppServerDeploymentsConstants {
	
    public static final By disableSingleDeploymentLocator = By.xpath("//div[contains(@class,'table-responsive')]//tbody/tr[2]//ul/li/a[./text()='Disable']");//("Disable");
    public static final By enableSingleDeploymentLocator = By.xpath("//div[contains(@class,'table-responsive')]//tbody/tr[2]//ul/li/a[./text()='Enable']");//("Disable");
    
    public static final By actionSingleDeploymentLocator = By.xpath("//div[contains(@class,'table-responsive')]//tbody/tr[2]/td[contains(@class,'actions')]//button");
    public static final By disabledSingleDeploymentLocator = By.xpath("//div[contains(@class,'table-responsive')]//tbody/tr[2]/td[contains(.,'Stopped')]");
}
