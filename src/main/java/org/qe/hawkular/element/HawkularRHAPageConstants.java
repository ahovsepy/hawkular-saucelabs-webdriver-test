package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularRHAPageConstants {
	
    public static final By usernameLocator = By.id("rha-login-user-id");//("rha-login-user-id");
    public static final By passwordLocator = By.id("rha-login-password");
    public static final By signinLocator = By.xpath("//button[text()='Sign in']");
    public static final By rhaiframeLocator = By.xpath("//iframe[@src='/support.html#/search']");

}
