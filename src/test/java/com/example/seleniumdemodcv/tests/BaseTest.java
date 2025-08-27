package com.example.seleniumdemodcv.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.seleniumdemodcv.utils.EnvUtils;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.codeborne.selenide.Configuration;


public abstract class BaseTest {
    protected static String BASE_URL;
    @BeforeSuite
    public void beforeSuite(){
        //Leer el BASE_URL Seteado en el .env
        BASE_URL = EnvUtils.getProperty("BASE_URL");

        //Configuraciones Globales para Selenide
        Configuration.baseUrl = BASE_URL;
        Configuration.browser="chrome";
        Configuration.browserSize="1440x900";
        Configuration.timeout=10000;
        Configuration.headless=false;
        //Interaccion con Allure
        SelenideLogger.addListener("allure", new AllureSelenide());

    }
    @BeforeMethod
    public void beforeMethod(){
        Selenide.open("/");
    }
    @AfterMethod
    public void afterMethod(){
        Selenide.closeWebDriver();
    }
    @AfterSuite
    public void afterSuite(){

    }
    protected void takeScreenshot(String name) {
        Selenide.screenshot(name);
    }
}
