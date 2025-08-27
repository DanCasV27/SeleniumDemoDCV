package com.example.seleniumdemodcv.tests;

import com.codeborne.selenide.Selenide;
import com.example.seleniumdemodcv.pages.HomePage;
import com.example.seleniumdemodcv.pages.LoginPage;
import com.example.seleniumdemodcv.utils.EnvUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    @BeforeMethod
    public void beforeMethod() {
        Selenide.open(BASE_URL+"/login");
        loginPage = new LoginPage();
    }
    @Test
    public void loginTestPositive() {
        loginPage.fillLoginWithValidCredentiasl(EnvUtils.getProperty(("E2E_USERNAME")), EnvUtils.getProperty("E2E_PASSWORD"));
        HomePage homePage = new HomePage();
        homePage.verifyLoggedUser();
    }

}
