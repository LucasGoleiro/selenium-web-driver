package com.fatec.tests;

/*
 *           ALUNOS: Henrique Souza Lima e Lucas Coelho dos Santos
 * 
 * REQ05. O sistema deve obter o endereço do aluno com base em um CEP válido cadastrado 
 *  na base dos correios.
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
public class REQ05ObterEnderecoTest {
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
public void REQ05ManterAluno() {
 driver.get("https://ts-scel.herokuapp.com/login");
 driver.manage().window().setSize(new Dimension(1346, 708));
 driver.findElement(By.name("username")).click();
 driver.findElement(By.name("username")).sendKeys("jose");
 driver.findElement(By.name("password")).click();
 driver.findElement(By.name("password")).sendKeys("123");
 driver.findElement(By.cssSelector("button")).click();
 driver.findElement(By.linkText("Alunos")).click();
 driver.findElement(By.id("ra")).click();
 driver.findElement(By.id("ra")).sendKeys("4321");
 driver.findElement(By.id("nome")).sendKeys("Jordan");
 driver.findElement(By.id("email")).sendKeys("jordan@email.com");
 driver.findElement(By.id("cep")).sendKeys("08050740");
 driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
 driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(6)")).click();
}

public void espera() {
	  try {
	  Thread.sleep(2000);
	  } catch (InterruptedException e) {
	  e.printStackTrace();
	  }
	  }
}
