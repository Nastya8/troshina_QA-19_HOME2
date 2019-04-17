package com.qa19.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTest {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
    wd = new ChromeDriver();
     wd.get("https://trello.com/");

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    wd.findElement(By.cssSelector("[href='/login']")).click();

    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("korsarushka@yandex.ru");

    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys("vasabi2018");

    wd.findElement(By.id("login")).click();

    }
    @Test
    public void createBoardTest(){
    wd.findElement(By.cssSelector("[aria-label='Создать доску или организацию']")).click();
    wd.findElement(By.className("js-new-board")).click();

    wd.findElement(By.cssSelector("[placeholder='Добавить заголовок доски']")).click();
    wd.findElement(By.cssSelector("[placeholder='Добавить заголовок доски']")).clear();
    wd.findElement(By.cssSelector("[placeholder='Добавить заголовок доски']")).sendKeys("new");

    wd.findElement(By.cssSelector("[type=submit]")).click();
    }
    @AfterClass
    public void tearDown(){
wd.quit();
    }
}
