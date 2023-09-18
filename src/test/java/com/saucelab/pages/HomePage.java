package com.saucelab.pages;

import com.saucelab.base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseTest {

    @AndroidFindBy(accessibility = "open menu")
    private WebElement openMenu;

    @AndroidFindBy(accessibility = "menu item log in")
    private WebElement loginOptn;


    public LoginPage goToLoginPage() {
        clickOnElement(openMenu);
       clickOnElement(loginOptn);
        return new LoginPage();

    }
}
