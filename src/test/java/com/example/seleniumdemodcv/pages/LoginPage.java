package com.example.seleniumdemodcv.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement loginemailInput = $("[data-qa='login-email']");
    public SelenideElement loginPasswordInput= $("[data-qa='login-password']");
    public SelenideElement loginButton = $("[data-qa='login-button']");
    public SelenideElement signUpEmailInput = $("[data-qa='signup-email']");
    public SelenideElement signUpNameInput = $("[data-qa='signup-name']");
    public SelenideElement signUpButton = $("[data-qa='signup-button']");
}
