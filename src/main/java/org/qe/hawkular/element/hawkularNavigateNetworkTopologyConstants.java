package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author pyadav
 */

public class hawkularNavigateNetworkTopologyConstants {
	
	public static final By clickTopology = By.xpath("html/body/nav/div[2]/div[2]/hawkular-topbar/ul/li[4]/a");
	public static final By imageServers = By.xpath("html/body/div[1]/div/div/div/div[3]/div/div[1]/label");
	public static final By imageApps = By.xpath("html/body/div[1]/div/div/div/div[3]/div/div[2]/label");
	public static final By imageDatasources= By.xpath("html/body/div[1]/div/div/div/div[3]/div/div[3]/label");
	public static final By datasourceTopology = By.xpath("//*[text()='Datasource [HawkularDS]']");
	public static final By deploymentTopology= By.xpath("//*[text()='Deployment [hawkular-console.war]']");
	public static final By verifyDeployment= By.xpath("html/body/div[1]/div/div/div/hawkular-subtab/div/div/div[3]/div/ul/li[3]/a");
	

}
