package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        System.out.println("Open Browser");
        // Login Function
        // Test Case Positive
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();

        // Step Validation
        WebElement txtDashboard = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        String getTxtDashboard = txtDashboard.getText();
        if(getTxtDashboard.equals("Products")){
            System.out.println("Passes");
        } else {
            System.out.println("Failed");
        }











        delay(3);
        driver.quit();
        System.out.println("Close Browser");
    } // method main

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    // karena blm menggunakan TestNG
    // custom Assert, 2 parameter actual, expected
    static void assertEquals(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Passes");
        } else {
            System.out.println("Failed");
        }
    }

}
