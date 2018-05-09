package com.xenia.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get("https://www.gdeetotdom.ru/");
    driver.findElement(By.xpath("//div[@id='menu-block']/div/div/div/ul/li[3]/a/span/span")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='loginPopup']/div/div/div/div/span/a/span/span")).click();
    driver.findElement(By.xpath("//form[@id='RegistrationFormView']/ul/li/label/span")).click();
    driver.findElement(By.name("email")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=email | ]]
    driver.findElement(By.xpath("//form[@id='RegistrationFormView']/div/div[2]")).click();
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("1234");
    driver.findElement(By.id("reg_captcha")).click();
    driver.findElement(By.id("reg_captcha")).clear();
    driver.findElement(By.id("reg_captcha")).sendKeys("trhr");
    driver.findElement(By.xpath("//span[@id='js-agreed']/span")).click();
    driver.findElement(By.xpath("//form[@id='RegistrationFormView']/div/div[4]/div/div/button")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
