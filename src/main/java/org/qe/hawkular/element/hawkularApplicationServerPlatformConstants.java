package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
*
* @author Prachi Yadav
*/

public class hawkularApplicationServerPlatformConstants {
	
	public static final By platformMemoryUsageGraph = By.xpath(".//*[@id='hk-platform-metrics']/div[2]/div[1]/div[3]/div/hawkular-chart/svg");
    public static final By platformAlerts = By.xpath(".//*[@id='hk-platform-metrics']/div[2]/div[2]/div/div[1]/h2");
    public static final By platformCpuUsage= By.xpath(".//*[@id='hk-platform-metrics']/div[2]/div[1]/div[4]/div[1]/hawkular-chart/svg");
    public static final By platformProcessor = By.xpath(".//*[@id='hk-platform-metrics']/div[2]/div[1]/div[4]/div[2]/div/div[1]/span[1]/hawkular-chart/svg/g/g[2]/rect[1]");
    public static final By platformFileSystemUsage= By.xpath(".//*[@id='hk-platform-metrics']/div[2]/div[1]/div[5]/div/h2");

}
