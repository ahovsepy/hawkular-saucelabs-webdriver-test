package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularApplicationOverviewConstants {
	
	public static final By ApplicationServerTab= By.linkText("Application Servers"); 
	public static final By ApplicationServer= By.xpath("//a[contains(@href,'/hawkular-ui/app/app-details/') and contains(@href,'Local/overview')]");
    public static final By OverviewTab= By.linkText("Overview");
    public static final By ServerDetails= By.xpath("//*[contains(text(),'Server Details')]");
    public static final By CommonTasks= By.xpath("//*[contains(text(),'Common Tasks')]");
    public static final By StatusOverview= By.xpath("//*[contains(text(),'Status Overview')]");
    public static final By ServerAlerts= By.xpath("//*[contains(text(),'Server Alerts')]");
}
