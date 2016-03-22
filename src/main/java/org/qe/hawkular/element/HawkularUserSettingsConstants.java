package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author vprusa
 */
public class HawkularUserSettingsConstants {

    /* Email Notification */
    public static final By userSettingsLink = By.id("userSettingsOption");
    public static final By emailFieldLocator = By.id("email");
    public static final String userEmail = "jdoe@acme.com";
//    public static final By saveButtonLocator =  By.xpath("//button[text()='Save']");
    public static final By saveButtonLocator =  By
            .xpath("//button[@ng-disabled='!form.$valid || !form.$dirty' and contains(text(),'Save')]");
    public static final By verifySuccessMsg = By.xpath("//*[text()='User settings successfully updated.']");
    

}