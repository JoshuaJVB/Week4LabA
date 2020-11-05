package com.groupa.week4laba.seleniumTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JoshSelTest {

    private WebDriver driver;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://Users/tremu/selenium/chromedriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to("http://localhost:8080");
    }

    @AfterEach
    void teardown(){
        driver.close();
    }

    @Test
    void getTitle(){
        assertEquals("Login", driver.getTitle());
    }

    @Test
    void createUser(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/form/input")).sendKeys("TestUser");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        assertEquals("Pick a Game", driver.getTitle());
    }

    @Test
    void getToSnakeEyes () throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/form/input")).sendKeys("TestUser");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/span[1]/button")));
        driver.findElement(By.xpath("/html/body/div/form/span[1]/button")).click();
        Thread.sleep(3000);
        assertEquals("Play",driver.getTitle());
    }

    @Test
    void getToTriScore() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/form/input")).sendKeys("TestUser");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/span[2]/button")));
        driver.findElement(By.xpath("/html/body/div/form/span[2]/button")).click();
        Thread.sleep(3000);
        assertEquals("Play",driver.getTitle());
    }

    @Test
    void getToRandom() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/form/input")).sendKeys("TestUser");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/span[3]/button")));
        driver.findElement(By.xpath("/html/body/div/form/span[3]/button")).click();
        Thread.sleep(3000);
        assertEquals("Play",driver.getTitle());
    }

    @Test
    void playSnakeEyes() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/form/input")).sendKeys("TestUser");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/span[1]/button")));
        driver.findElement(By.xpath("/html/body/div/form/span[1]/button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button")));
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Thread.sleep(3000);
        assertEquals("Game Results", driver.findElement(By.xpath("/html/body/div/h1")).getText());
    }

    @Test
    void playTriScore() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/form/input")).sendKeys("TestUser");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/span[2]/button")));
        driver.findElement(By.xpath("/html/body/div/form/span[2]/button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button")));
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Thread.sleep(3000);
        assertEquals("Game Results", driver.findElement(By.xpath("/html/body/div/h1")).getText());
    }

    @Test
    void playRandom() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/form/input")).sendKeys("TestUser");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/span[3]/button")));
        driver.findElement(By.xpath("/html/body/div/form/span[3]/button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button")));
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Thread.sleep(3000);
        assertEquals("Game Results", driver.findElement(By.xpath("/html/body/div/h1")).getText());
    }
}
