package com.qa19.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
    wd = new ChromeDriver();
     wd.get("https://trello.com/");

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        clickLoginButton();

        login("korsarushka@yandex.ru", "vasabi2018");

    }

    public void submitBoardCreation() {
        click(By.cssSelector("[type=submit]"));
    }

    public void typeBoardName() {
        type(By.cssSelector("[placeholder='Добавить заголовок доски']"), "new");
    }

    public void initBoardCreationFromHeader() {
        clickOnPlusButtonOnHeader();
        click(By.className("js-new-board"));
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[aria-label='Создать доску или организацию']"));
    }

    @AfterClass
    public void tearDown(){

        wd.quit();
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);

        type(By.id("password"), password);

        click(By.id("login"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void clickLoginButton() {
        click(By.cssSelector("[href='/login']"));
    }
}
