package com.example.seleniumdemodcv.tests;

import com.codeborne.selenide.Selenide;
import com.example.seleniumdemodcv.pages.HomePage;
import com.example.seleniumdemodcv.pages.LoginPage;
import com.example.seleniumdemodcv.utils.CSVUtils;
import com.example.seleniumdemodcv.utils.EnvUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    @BeforeMethod
    public void beforeMethod() {
        Selenide.open(BASE_URL+"/login");
        loginPage = new LoginPage();
    }
    @DataProvider(name="negativeLoginData")
    public Object[][] negativeLoginData(){
        return CSVUtils.readCSV("data/login_negative.csv");
    }
    @Test
    public void loginTestPositive() {
        loginPage.fillLoginEmailInput(EnvUtils.getProperty(("E2E_EMAIL")));
        loginPage.fillLoginPasswordInput(EnvUtils.getProperty(("E2E_PASSWORD")));
        loginPage.clickLoginButton();
        HomePage homePage = new HomePage();
        homePage.verifyLoggedUser();
    }
    @Test(dataProvider = "negativeLoginData")
    public void loginTestNegative(String username, String password) {
        loginPage.fillLoginEmailInput(username);
        loginPage.fillLoginPasswordInput(password);
        loginPage.clickLoginButton();
        loginPage.verifyInvalidCredentialsMessage();
    }

}
