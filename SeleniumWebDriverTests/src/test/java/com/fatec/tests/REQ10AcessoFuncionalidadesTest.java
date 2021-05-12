package com.fatec.tests;

/*
 *           ALUNOS: Henrique Souza Lima e Lucas Coelho dos Santos
 * 
 * REQ10. O usuário com id “maria” tem acesso as funcionalidades mantem aluno, mantem livro e registrar
 * empréstimo (autorização).
 *   
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class REQ10AcessoFuncionalidadesTest{
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
  public void REQ10AcessoFuncionalidadesTest() {
    driver.get("https://ts-scel.herokuapp.com/login");
    driver.manage().window().setSize(new Dimension(1366, 728));
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("maria");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("456");
    driver.findElement(By.cssSelector("button")).click();
    espera();
    driver.findElement(By.linkText("Alunos")).click();
    driver.findElement(By.id("ra")).click();
    driver.findElement(By.id("ra")).sendKeys("0002");
    driver.findElement(By.id("nome")).sendKeys("Lucas Ribeiro");
    driver.findElement(By.id("email")).sendKeys("lucas@email.com");
    driver.findElement(By.id("cep")).sendKeys("03317080");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    espera();
    driver.findElement(By.id("ra")).click();
    driver.findElement(By.id("ra")).sendKeys("1111");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    driver.findElement(By.linkText("Voltar")).click();
    driver.findElement(By.linkText("Livros")).click();
    driver.findElement(By.id("isbn")).click();
    driver.findElement(By.id("isbn")).sendKeys("2222");
    driver.findElement(By.id("autor")).sendKeys("Machado de Assis");
    driver.findElement(By.id("titulo")).sendKeys("Dom Casmurro");
    driver.findElement(By.cssSelector(".focus-visible")).click();
    driver.findElement(By.linkText("Voltar")).click();
    driver.findElement(By.linkText("Empréstimo")).click();
    driver.findElement(By.id("isbn")).click();
    driver.findElement(By.id("isbn")).sendKeys("2222");
    driver.findElement(By.id("ra")).sendKeys("2222");
    driver.findElement(By.cssSelector(".focus-visible")).click();
    driver.findElement(By.cssSelector(".my-5")).click();
    driver.findElement(By.id("isbn")).sendKeys("0002");
    driver.findElement(By.id("ra")).sendKeys("0002");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    driver.findElement(By.id("ra")).click();
    driver.findElement(By.id("ra")).click();
    driver.findElement(By.id("ra")).sendKeys("1234");
    driver.findElement(By.cssSelector(".row:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".card-body")).click();
    driver.findElement(By.id("isbn")).sendKeys("0001");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".my-5")).click();
    driver.findElement(By.id("ra")).sendKeys("0001");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
    vars.put("win1698", waitForWindow(2000));
    driver.switchTo().window(vars.get("win1698").toString());
    driver.findElement(By.cssSelector("tr:nth-child(5)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(5) .btn")).click();
  }
  public void espera() {
	  try {
	  Thread.sleep(2000);
	  } catch (InterruptedException e) {
	  e.printStackTrace();
	  }
	  }
  
}
