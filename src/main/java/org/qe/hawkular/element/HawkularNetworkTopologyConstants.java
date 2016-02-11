package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author pyadav
 */

public class HawkularNetworkTopologyConstants {
	
	public static final By clickTopology = By.linkText("Topology");
	public static final By imageServers = By.id("vertex-Server");
	public static final By imageApps = By.id("vertex-App");
	public static final By imageDatasources= By.id("vertex-DataSource");
	public static final By datasourceTopology = By.xpath("//*[text()='Datasource [HawkularDS]']");
	public static final By deploymentTopology= By.xpath("//*[text()='Deployment [hawkular-console.war]']");
	public static final By verifyDeployment= By.xpath("html/body/div[1]/div/div/div/hawkular-subtab/div/div/div[3]/div/ul/li[3]/a");
	

}
