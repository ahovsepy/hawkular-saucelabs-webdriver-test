package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularManagementConsolePageConstants {

   public static final By consoleImageAltLocator = By.xpath("//*[contains(attribute::alt, 'RED HAT JBOSS HAWKULAR Management Console')]");
   public static final String testURL = "http://www.redhat.com";
   public static final String testURL2 = "http://www.google.com";
   public static final By urlLocator = By.name("resourceUrl");
   public static final By addButtonLocator = By.cssSelector("button.btn.btn-primary");
   public static final By homePageImgLocator = By.id("hawkularLogo");
   public static final By urlsMenuLocator = By.linkText("URLs");
   public static final By appServersMenuLocator = By.linkText("Application Servers");
   public static final By appServersListLocator = By.xpath("//*[text()='Application Servers']");
   public static final By urlHeadingLocator = By.xpath("//div[contains(.,'"+testURL+"')]");
   public static final By addUrlMsg = By.xpath("//*[text()='Your data is being collected. Please be patient (should be about another minute).']");
   public static final By deleteButtonLocator =  By.xpath("//*[text() = '"+testURL+"']/../..//button");
   public static final By confirmDelete =  By.xpath("//button[text()='Delete']");
   public static final By errorAlert =  By.xpath("//*[@class='toast-message']");
   public static final By urlIPLocator = By.xpath("//*[contains(text(),'IP:')]");
   public static final By urlTraits =  By.xpath("//*[text() = '"+testURL+"']/../..//span");
   public static final String testanotherURL = "http://doesnotexist.in";
   public static final By url2HeadingLocator = By.xpath("//div[contains(.,'"+testanotherURL+"')]");
   public static final By selectNameDropdown =  By.xpath("//button[contains(@tooltip,'Filter by')]");
   public static final By selectNameOption = By.xpath("//a[contains(text(),'Name')]");
   public static final By searchbox = By.xpath("//input[contains(@placeholder,'Containts text')]");
   public static final By selectStateOption = By.xpath("//a[contains(text(),'State')]");
   public static final By selectFilterByStateDropdown =  By.xpath("//button[@title='Filter by State']");
   public static final By selectStateUpOption = By.xpath("//a[contains(.,'Up')]");
   public static final By selectStateDownOption = By.xpath("//a[contains(.,'Down')]");
}
