package com.fatec.tests;

/*
 *           ALUNOS: Henrique Souza Lima e Lucas Coelho dos Santos
 * 
 * REQ04. O sistema deve rejeitar entradas invalidas – entrada válida para RA no mínimo 4 e no máximo 4
 * caracteres, não deve permitir o cadastro de um RA já cadastrado, entrada válida para nome, e-mail entre 1 e 50
 * caracteres, entrada válida para CEP 8 caracteres.
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
public class REQ04RejeitarEntradasInvalidasTest {
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
public void REQ04ManterAluno() {
 driver.get("https://ts-scel.herokuapp.com/login");
 driver.manage().window().setSize(new Dimension(1346, 708));
 driver.findElement(By.name("username")).click();
 driver.findElement(By.name("username")).sendKeys("jose");
 driver.findElement(By.name("password")).click();
 driver.findElement(By.name("password")).sendKeys("123");
 driver.findElement(By.cssSelector("button")).click();
 driver.findElement(By.linkText("Alunos")).click();
 driver.findElement(By.id("ra")).click();
 driver.findElement(By.id("ra")).sendKeys("123");
 driver.findElement(By.id("nome")).sendKeys("Kobe");
 driver.findElement(By.id("email")).sendKeys("kobe");
 driver.findElement(By.id("cep")).sendKeys("08050740");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 driver.findElement(By.id("ra")).click();
 driver.findElement(By.id("ra")).sendKeys("12345");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 driver.findElement(By.id("ra")).click();
 driver.findElement(By.id("ra")).sendKeys("1234");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 driver.findElement(By.id("ra")).click();
 driver.findElement(By.id("ra")).sendKeys("1235");
 driver.findElement(By.id("nome")).click();
 driver.findElement(By.id("nome")).click();
 driver.findElement(By.id("nome")).sendKeys("Kobe Kobe KobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobe");
 driver.findElement(By.id("email")).click();
 driver.findElement(By.id("email")).sendKeys("kobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobeKobe");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 {
   WebElement element = driver.findElement(By.id("cep"));
   Actions builder = new Actions(driver);
   builder.moveToElement(element).clickAndHold().perform();
 }
 {
   WebElement element = driver.findElement(By.id("cep"));
   Actions builder = new Actions(driver);
   builder.moveToElement(element).perform();
 }
 {
   WebElement element = driver.findElement(By.id("cep"));
   Actions builder = new Actions(driver);
   builder.moveToElement(element).release().perform();
 }
 driver.findElement(By.id("cep")).click();
 driver.findElement(By.id("cep")).sendKeys("0805074055");
 driver.findElement(By.id("email")).click();
 driver.findElement(By.id("email")).sendKeys("Kobe");
 driver.findElement(By.id("nome")).click();
 driver.findElement(By.id("nome")).click();
 driver.findElement(By.id("nome")).sendKeys("Kobe");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 {
   WebElement element = driver.findElement(By.cssSelector(".btn:nth-child(1)"));
   Actions builder = new Actions(driver);
   builder.doubleClick(element).perform();
 }
}

public void espera() {
	  try {
	  Thread.sleep(2000);
	  } catch (InterruptedException e) {
	  e.printStackTrace();
	  }
	  }
}
