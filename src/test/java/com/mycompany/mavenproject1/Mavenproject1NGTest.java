/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.mycompany.mavenproject1;

import static org.testng.Assert.*;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 *
 * @author Ahmed Elrefaiy
 */
public class Mavenproject1NGTest {

    public Mavenproject1NGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of IsEven method, of class Mavenproject1.
     *
     * @param x
     * @param y
     */
    @org.testng.annotations.Test
    @Parameters({"xparam","yparam"})
    public void testIsEven(@Optional("10") int x, @Optional("11") int y) {
        System.out.println("IsEven");
        System.out.println(x);
        Mavenproject1 instance = new Mavenproject1();
        boolean expResult = x % 2 == 0;
        boolean result = instance.IsEven(x);
        assertEquals(result, expResult);
    }

}
