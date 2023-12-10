package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddToCart {
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
            System.out.println("Berhasil tampil halaman products");
        } else {
            System.out.println("Tetap dihalaman Login");
        }

        WebElement klikCart1 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        klikCart1.click();
        WebElement klikCart2 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
        klikCart2.click();
        //Klik Shopping Chart
        WebElement klikShopCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        klikShopCart.click();
        //Klik Checkout Product
        WebElement klikCo = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
        klikCo.click();
        //Cek halaman untuk isi data
        WebElement txtCo = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        String getTxtCo = txtCo.getText();
        if(getTxtCo.equals("Checkout: Your Information")){
            System.out.println("Halaman Isi informasi CO");
        } else {
            System.out.println("Bukan halaman isi informasi CO");
        }

        //input data
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement postalCode = driver.findElement(By.id("postal-code"));
        WebElement btnContinue = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        firstName.sendKeys("Astrin");
        lastName.sendKeys("Indah");
        postalCode.sendKeys("12345");
        btnContinue.click();
        // Step Validation
        WebElement txtData = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]"));
        String getTxtData = txtData.getText();
        if(getTxtData.equals("Checkout: Overview")){
            System.out.println("Berhasil input data dan tampil halaman overview");
        } else {
            System.out.println("Gagal input data dan tetap dihalaman yang sama");
        }
        //Finish Order
        WebElement klikFinish = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        klikFinish.click();

        //Back to Home
        WebElement klikHome = driver.findElement(By.xpath("//*[@id=\"back-to-products\"]"));
        klikHome.click();

        //Logout
        WebElement klikMenu = driver.findElement((By.xpath("//*[@id=\"react-burger-menu-btn\"]")));
        klikMenu.click();
        WebElement klikLogout = driver.findElement(By.id("logout_sidebar_link"));
        klikLogout.click();







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
