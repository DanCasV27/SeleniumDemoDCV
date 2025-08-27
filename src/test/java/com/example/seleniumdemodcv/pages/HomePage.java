package com.example.seleniumdemodcv.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private SelenideElement loggedUserContainer = $("a:has(i.fa-user)");

    public void verifyLoggedUser() {
        loggedUserContainer.shouldBe(Condition.visible);
        loggedUserContainer.shouldHave(text("Logged in as"));
        loggedUserContainer.shouldHave(text("DanielDemoUser"));

    }


    
    
}
