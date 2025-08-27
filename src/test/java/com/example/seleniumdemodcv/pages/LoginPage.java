package com.example.seleniumdemodcv.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement loginemailInput = $("[data-qa='login-email']");
    private SelenideElement loginPasswordInput= $("[data-qa='login-password']");
    private SelenideElement loginButton = $("[data-qa='login-button']");
    private SelenideElement signUpEmailInput = $("[data-qa='signup-email']");
    private SelenideElement signUpNameInput = $("[data-qa='signup-name']");
    private SelenideElement signUpButton = $("[data-qa='signup-button']");
    private SelenideElement invalidCredentialsMessage = $x("//p[normalize-space()='Your email or password is incorrect!']\n");

    //Metodos
    public void fillLoginEmailInput(String email){
        loginemailInput.setValue(email);
    }
    public void fillLoginPasswordInput(String password){
        loginPasswordInput.setValue(password);
    }
    public void verifyInvalidCredentialsMessage(){
        invalidCredentialsMessage.shouldBe(Condition.visible);
        invalidCredentialsMessage.shouldHave(text("Your email or password is incorrect!"));
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
