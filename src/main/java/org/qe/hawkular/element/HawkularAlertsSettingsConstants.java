package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAlertsSettingsConstants {

    public static final By allAlertsLink = By.linkText("All Alerts");
    public static final By alertsSettingsLink = By.linkText("Alert Settings");
    public static final By emailField = By.id("email");
    public static final By responseTimeField = By.id("time");
    public static final By heapGreaterThanField = By.id("usage-greater");
    public static final By heapLessThanField = By.id("usage-less");
    public static final By everyTimeRadioButton = By.id("every-time-heap");
    public static final By saveButton = By.xpath("//button[contains(@ng-click,'tc.save()')]");
    public static final By editAlertSuccessMsg = By.xpath("//div[@class='toast-message']");
    public static final By allDefinitionsLink = By.linkText("« All Definitions");    
    
    
}
