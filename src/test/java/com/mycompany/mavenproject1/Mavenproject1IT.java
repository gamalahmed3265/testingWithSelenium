/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */
package com.mycompany.mavenproject1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 *
 * @author Ahmed Elrefaiy
 */
public class Mavenproject1IT {
    
    
    @Ignore
    public void testSimple() throws Exception {
        //System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize(); //to maximize browser window

        // And now use this to visit NetBeans
        driver.get("http://www.netbeans.org");
        Thread.sleep(2000);

        Assert.assertTrue(driver.getTitle().contains("NetBeans"));
        // Check the title of the page
        // Wait for the page to load, timeout after 10 seconds
        /*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("NetBeans");
            }
        });*/

        //Close the browser
        driver.quit();
    }
    
    @Test
    public void testLogin() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize(); //to maximize browser window
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("orangehrm-login-button")).click();
        Thread.sleep(2000);
        //Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.className("oxd-userdropdown-name")).getText(),"Paul Collings");

        Thread.sleep(2000);
        //Close the browser
        driver.quit();
    }
}
