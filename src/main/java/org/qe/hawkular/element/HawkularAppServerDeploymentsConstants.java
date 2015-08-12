package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAppServerDeploymentsConstants {
	
    //public static final By disableSingleDeploymentLocator = By.xpath("//x:div[contains(@class,'table-responsive')]//x:tbody/x:tr[2]//x:ul/x:li/x:a[./text()='Disable']");//("Disable");
    public static final By disableSingleDeploymentLocator = By.xpath("//div[contains(@class,'table-responsive')]//tbody/tr[2]//ul/li/a[./text()='Disable']");//("Disable");
    public static final By enableSingleDeploymentLocator = By.xpath("//div[contains(@class,'table-responsive')]//tbody/tr[2]//ul/li/a[./text()='Enable']");//("Disable");
    
    public static final By actionSingleDeploymentLocator = By.xpath("//div[contains(@class,'table-responsive')]//tbody/tr[2]/td[contains(@class,'actions')]//button");
    public static final By disabledSingleDeploymentLocator = By.xpath("//div[contains(@class,'table-responsive')]//tbody/tr[2]/td[contains(.,'Stopped')]");
    //public static final By disableSingleDeploymentLocator = By.xpath("//div[contains(@class,'table-responsive')]//tbody/tr[1]//ul/li/a[./text()='Disable']");
    
    /*public static final By usernameLocator = By.id("username");
    public static final By passwordLocator = By.id("password");
    public static final By loginButtonLocator = By.id("kc-login");
    public static final By cancelButtonLocator = By.id("kc-cancel");
    public static final String loginTitle = "Log in to hawkular";
    public static final String login = "hawkularqe";
    public static final String password = "H@wkular123";
    public static final By registrationLink = By.linkText("Register");
    public static final By logoutDropdown = By.xpath("/html/body/nav/div[2]/div[2]/ul/li/a");
    public static final By logoutLink = By.id("logout");
    
    public static final By invalidUsernamePasswordError = By.xpath("//*[text()='Invalid username or password.']");
    */
}
