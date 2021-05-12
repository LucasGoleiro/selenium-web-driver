package com.fatec.tests;

/*
 *           ALUNOS: Henrique Souza Lima e Lucas Coelho dos Santos
 * 
 * REQ07. O sistema deve registrar a data da devolução do livro emprestado.
 *   
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class REQ07RegistraDataDevolucaoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  @BeforeEach
  public void setUp() {
	  System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void REQ06ManterEmprestimo() {
    driver.get("https://ts-scel.herokuapp.com/login");
    driver.manage().window().setSize(new Dimension(1366, 728));
    espera();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("jose");
    driver.findElement(By.name("password")).sendKeys("123");
    driver.findElement(By.cssSelector("button")).click();
    espera();
    driver.findElement(By.linkText("Empréstimo")).click();
    driver.findElement(By.id("isbn")).click();
    driver.findElement(By.id("isbn")).sendKeys("1234");
    driver.findElement(By.id("ra")).sendKeys("1234");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
    vars.put("win1260", waitForWindow(2000));
    driver.switchTo().window(vars.get("win1260").toString());
    driver.findElement(By.cssSelector("tbody > tr")).click();
    espera();
    driver.findElement(By.cssSelector("td:nth-child(3)")).click();
    driver.findElement(By.cssSelector("td:nth-child(4)")).click();
    driver.findElement(By.cssSelector("td:nth-child(5)")).click();
    driver.findElement(By.cssSelector("td:nth-child(6)")).click();
    driver.findElement(By.linkText("Devolver")).click();
  }
  
  public void espera() {
	  try {
	  Thread.sleep(2000);
	  } catch (InterruptedException e) {
	  e.printStackTrace();
	  }
	  }
  
}
