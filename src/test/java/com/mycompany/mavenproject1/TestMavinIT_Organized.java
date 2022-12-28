/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */
package com.mycompany.mavenproject1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;

/**
 *
 * @author Ahmed Elrefaiy
 */
public class TestMavinIT_Organized {

    public TestMavinIT_Organized() {

    }

    @org.testng.annotations.BeforeTest
    public static void setUpClass() throws Exception {
        //initialize driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //to maximize browser window
    }

    @org.testng.annotations.AfterTest
    public static void tearDownClass() throws Exception {
        //Close the browser
        Thread.sleep(2000);
        driver.quit();
    }

    static WebDriver driver;

    @Test
    public void testForgotPasswordPage() {
        //click on the ‘Forgot your password’ link
        WebElement forgotPassword = driver.findElement(By.xpath("//div[@id='forgotPasswordLink']"));
        forgotPassword.click();

        //* Verify the text ‘Forgot Your Password?’
        WebElement VerifyText = driver.findElement(By.xpath("//div[@id='forgotPasswordLink']"));
        String actualTest = VerifyText.getText();
        String expectedTest = "Forgot your password?";
        Assert.assertEquals(expectedTest, actualTest);

    }

//    @Test
    @Test(dataProvider = "adminDataProvider")
    public void testLogin(UserData userData) throws Exception {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys(userData.getUserName());
        driver.findElement(By.name("password")).sendKeys(userData.getPassword());
        driver.findElement(By.className("orangehrm-login-button")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
//        Assert.assertEquals(driver.findElement(By.className("oxd-userdropdown-name")).getText(),"Paul Collings");
    }

    @Test
    public void testTabAdmin() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
//        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(),"User Management123");

    }

    @Test
    public void systemUsers() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Admin");

        //User Role
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]")).click();

        //Employee Name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")).sendKeys("Odis  Adalwin");

        //Status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[3]")).click();

        Thread.sleep(2000);
        //search
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
        Thread.sleep(2000);
        //assert
        assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]")).isDisplayed());
        Thread.sleep(2000);
    }

    @Test
    public void closeAndOpenLeftSideBar() throws Exception {
//        if(driver.findElement(By.className("oxd-icon bi-chevron-left")).isDisplayed()){
        driver.findElement(By.className("bi-chevron-left")).click();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.className("bi-chevron-right")).isDisplayed());

        driver.findElement(By.className("bi-chevron-right")).click();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.className("bi-chevron-left")).isDisplayed());
    }

    @Test
    public void testDeleteUser() throws Exception {

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div[1]/div[2]/div/div/button[1]")).click();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div[1]/div[2]/div/div/button[1]")).isDisplayed());
        Thread.sleep(2000);
    }

//    @Test
    @Test(dataProvider = "userDataProvider")
    public void testAddUser(UserData userData) throws Exception {

//        UserData userData = userDataProvider();

        //click Add button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();

        Thread.sleep(2000);

        // user Role
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]")).click();
//        assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]")).isDisplayed());

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")).click();
//        assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")).isDisplayed());

//        Thread.sleep(2000);
        //Employee Name
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("karuna sri bale");
//        assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).isDisplayed());

        //status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]")).click();
//        assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]")).isDisplayed());

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]")).click();
//        assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")).isDisplayed());

        Thread.sleep(2000);

        //username
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys(userData.getUserName());

        //password 1
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys(userData.getPassword());

        //password 2
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys(userData.getPassword());
        Thread.sleep(2000);

        //save button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
        Thread.sleep(3000);

//        assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).isDisplayed());
//        Assert.assertEquals(driver.findElement(By.className("(//input[@class='oxd-input oxd-input--active'])[3]")).getText(),"admin123");
//                Assert.assertEquals(driver.findElement(By.className("(//input[@class='oxd-input oxd-input--active'])[2]")).getText(),"admin123");
//        Assert.assertEquals(driver.findElement(By.className("(//input[@class='oxd-input oxd-input--active'])[2]")).getText(),"admin123");
//        driver.findElement(By.name("username")).sendKeys("Admin");
//        driver.findElement(By.cssSelector("[type='password']")).sendKeys("admin123");
//        assertTrue( driver.findElement(By.name("[type='password']")).isDisplayed());
//      driver.findElement(By.name("[type='password']")).sendKeys("3434");
//        assertTrue(driver.findElements(By.xpath("")).get(2).isDisplayed());
//        assertTrue(driver.findElements(By.cssSelector("[data-v-15df604d8]")).get(0).isDisplayed());
//        Select select = new Select(driver.findElement(By.cssSelector("[data-v-15df604d8]")));
//        select.selectByIndex(0);
//        System.out.println("select:"+select.getFirstSelectedOption());
//        assertTrue(select.getFirstSelectedOption()=="Amain"));
//        assertEquals(select.getFirstSelectedOption(), expected);
//        driver.findElements(By)
//        for (int i = 0; i < driver.findElements(By.cssSelector("[data-v-2fe357a6]")).size(); i++) {
//            System.out.println("index "+i);
//            assertTrue(driver.findElements(By.cssSelector("[data-v-2fe357a6]")).get(i).isDisplayed());
//            driver.findElements(By.cssSelector("[data-v-2fe357a6]")).get(i).click();
//            Select select = new Select(driver.findElement(By.cssSelector("[data-v-15df604d8]")));
//        select.selectByIndex(0);
//        System.out.println("select:"+select.getFirstSelectedOption());
//        }
    }

//    @Test
    @Test(dataProvider = "sideBarDataProvider")
    public void testTabToggle(SideBar sideBar) throws Exception {
//        List<SideBar> listSideBar = sideBarDataProvider();
//        for (int i = 0; i < listSideBar.size(); i++) {
//            Thread.sleep(5000);
//            System.out.println("name: " + listSideBar.get(i).getName());
//            driver.findElement(By.cssSelector(String.format(".oxd-main-menu-item[href='%s+']", listSideBar.get(i).getLink()))).click();
//        }
//            System.out.println("name: " + listSideBar.get(4).getName());
//            driver.findElement(By.cssSelector(String.format(".oxd-main-menu-item[href='%s+']", listSideBar.get(4).getLink()))).click();
//            Thread.sleep(5000);
        //                    driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/pim/viewMyDetails']")).click();

        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='" + sideBar.getLink() + "']")).click();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());

    }

    @Test
    public void testLogout() throws Exception {
        driver.findElement(By.className("oxd-userdropdown-name")).click();
        driver.findElement(By.cssSelector(".oxd-userdropdown-link[href='/web/index.php/auth/logout']")).click();
    }

    @Test

    public void testEditUser() throws Exception {
        //
        assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div[4]/div/div/div[1]/div[2]/div/div/button[2]")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div[4]/div/div/div[1]/div[2]/div/div/button[2]")).click();
        Thread.sleep(2000);
    }

    @DataProvider(name = "sideBarDataProvider")
    public Object[] sideBarDataProvider() {
        return new Object[]
            {
                new SideBar("Buzz", "web/index.php/buzz/viewBuzz"),
                new SideBar("Maintenance", "/web/index.php/maintenance/viewMaintenanceModule"),
                new SideBar("Directory", "/web/index.php/directory/viewDirectory"),
                new SideBar("Dashboard", "/web/index.php/dashboard/index"),
                new SideBar("Performance", "/web/index.php/performance/viewPerformanceModule"),
                new SideBar("My Info", "/web/index.php/pim/viewMyDetails"),
                new SideBar("Recruitment", "/web/index.php/recruitment/viewRecruitmentModule"),
                new SideBar("Time", "/web/index.php/time/viewTimeModule"),
                new SideBar("Leave", "/web/index.php/leave/viewLeaveModule"),
                new SideBar("PIM", "/web/index.php/pim/viewPimModule"),
                new SideBar("Admin", "/web/index.php/admin/viewAdminModule"),};
    }

    @DataProvider(name = "userDataProvider")
    public Object[][] userDataProvider() {
     return new Object[][]{{
//            new UserData("Mohamed", "0u9@&4SbxNSZ"),
//            new UserData("Gamal", "0u9@&4SbxNSZ"),
            new UserData("Ahmed", "0u9@&4SbxNSZ")
        }};
    }
    @DataProvider(name = "adminDataProvider")
    public Object[][] adminDataProvider() {
     return new Object[][]{{
            new UserData("Admin", "admin123")
        }};
    }

    public static void screenShot(String filename) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "C:\\Projects\\Collage\\Forth year\\Software Testing\\section\\mavenproject1\\screenShots";
        File filePath = new File(path + filename);
        try {
            FileUtils.copyFile(file, filePath);
        } catch (Exception e) {
        }
    }
}
