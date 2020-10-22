package ru.rstqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.rstqa.pft.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {


  protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }



  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();

  }



}
