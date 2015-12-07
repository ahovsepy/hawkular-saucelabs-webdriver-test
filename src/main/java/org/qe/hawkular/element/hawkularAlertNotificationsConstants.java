package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author pyadav
 */

public class hawkularAlertNotificationsConstants {
	
	public static final By clickApplicationServer= By.xpath("html/body/nav/div[2]/div[2]/hawkular-topbar/ul/li[3]/a");
	public static final By clickAppServer= By.xpath("html/body/div[1]/div/div/div/div[2]/div[3]/table/tbody/tr[2]/td[2]/a[1]");
	public static final By verifyAlert= By.xpath(".//*[@id='hk-jvm-metrics']/div[2]/div[2]/div/div/div/div[1]/h2");
	public static final By nevigateDefinition=By.xpath(".//*[@id='hk-jvm-metrics']/div[2]/div[2]/div/div/div/div[1]/p/a");
	public static final By verifyDefinition= By.xpath("html/body/div[1]/div/div/div/hawkular-subtab/div/div/div[3]/div/ul/li[2]/a");
	
}

