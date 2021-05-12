package com.fatec.tests;

/*
 *           ALUNOS: Henrique Souza Lima e Lucas Coelho dos Santos
 * 
 * REQ02. O sistema deve rejeitar entradas invalidas – entrada válida para ISBN no mínimo 4 e no máximo 4
 * caracteres, não deve permitir o cadastro de um ISBN já cadastrado, entrada válida para autor e título entre 1 e 50
 * caracteres.
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
public class REQ02RejeitarEntradasInvalidasTest {
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
public void REQ02ManterLivros() {
 driver.get("https://ts-scel.herokuapp.com/login");
 driver.manage().window().setSize(new Dimension(1346, 708));
 driver.findElement(By.name("username")).click();
 driver.findElement(By.name("username")).sendKeys("jose");
 driver.findElement(By.name("password")).click();
 driver.findElement(By.name("password")).sendKeys("123");
 driver.findElement(By.cssSelector("button")).click();
 espera();
 driver.findElement(By.linkText("Livros")).click();
 driver.findElement(By.id("isbn")).click();
 driver.findElement(By.id("isbn")).sendKeys("123");
 driver.findElement(By.id("autor")).click();
 driver.findElement(By.id("autor")).sendKeys("Paulo Coelho");
 driver.findElement(By.id("titulo")).click();
 driver.findElement(By.id("titulo")).sendKeys("O alquimista");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 espera();
 driver.findElement(By.id("isbn")).click();
 driver.findElement(By.id("isbn")).sendKeys("12345");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 espera();
 driver.findElement(By.id("isbn")).click();
 driver.findElement(By.id("isbn")).sendKeys("1234");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 espera();
 driver.findElement(By.id("autor")).click();
 driver.findElement(By.id("autor")).click();
 driver.findElement(By.id("autor")).sendKeys("Paulo Coelho Paulo Coelho Paulo Coelho Paulo Coelho Paulo Coelho Paulo Coelho Paulo Coelho");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 espera();
}

public void espera() {
	  try {
	  Thread.sleep(2000);
	  } catch (InterruptedException e) {
	  e.printStackTrace();
	  }
	  }
}

