/*
 *           ALUNOS: Henrique Souza Lima e Lucas Coelho dos Santos
 * 
 * REQ08. O sistema deve rejeitar o acesso, para usuários não autenticados, exigindo login para liberar as
funcionalidades (autenticação) – os usuários id “jose” e senha “123” e “maria” senha “456” estão cadastrados
 *  * 
 */

package com.fatec.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.util.*;


public class REQ08RejeitarAcessoTest {
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
  @Test
  public void rEQ08RejeitarAcessoTest() {
    driver.get("https://ts-scel.herokuapp.com/login");
    driver.manage().window().setSize(new Dimension(1366, 728));
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("12345");
    driver.findElement(By.name("password")).sendKeys("lucia");
    espera();
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("jose");
    driver.findElement(By.name("password")).sendKeys("9876");
    espera();
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.cssSelector("html")).click();
  }
  
  public void espera() {
	  try {
	  Thread.sleep(2000);
	  } catch (InterruptedException e) {
	  e.printStackTrace();
	  }
	  }
}
