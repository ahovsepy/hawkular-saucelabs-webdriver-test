package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author pyadav
 */

public class HawkularAlertNotificationsConstants {
	
	public static final By alertNotificationLocator= By.xpath("//*[contains(text(),'JVM Alerts')]");
	public static final By navigateAlertDefinition=By.linkText("Definitions");
	public static final By alertDefinitionlocator= By.xpath("//*[contains(text(),'Triggers')]");
	
}

