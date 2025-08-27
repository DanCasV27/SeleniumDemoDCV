package com.example.seleniumdemodcv.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginemailInput = $("[data-qa='login-email']");
    private SelenideElement loginPasswordInput= $("[data-qa='login-password']");
    private SelenideElement loginButton = $("[data-qa='login-button']");
    private SelenideElement signUpEmailInput = $("[data-qa='signup-email']");
    private SelenideElement signUpNameInput = $("[data-qa='signup-name']");
    private SelenideElement signUpButton = $("[data-qa='signup-button']");

    public void fillLoginWithValidCredentiasl(String email,String password){
        loginemailInput.setValue(email);
        loginPasswordInput.setValue(password);
        loginButton.click();
    }
    public void fillSignUpEmailValidCredential(){
        signUpEmailInput.setValue("email");
    }
    public void fillSignUpNameValidCredential(){
        signUpNameInput.setValue("");
    }
    public void clickLoginButton(){
        loginButton.click();
    }




}
