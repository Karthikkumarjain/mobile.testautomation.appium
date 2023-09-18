package com.saucelab.pages;

import com.saucelab.base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {


    @AndroidFindBy(xpath = "android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")
    private WebElement openMenu;

    @AndroidFindBy(accessibility = "menu item log in")
    private WebElement loginOptn;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    private WebElement headingOfPage;
    @AndroidFindBy(accessibility = "Username input field")
    private WebElement userName;

    @AndroidFindBy(accessibility = "Password input field")
    private WebElement password;

    @AndroidFindBy(accessibility = "Login button")
    private WebElement loginBtn;

    public String getText(){
    return getAttribute(headingOfPage);
    }

    //android.view.ViewGroup[@content-desc="open menu"]/android.widget.ImageView
    //menu item log in
   // Username input field
    //Password input field
    //Login button



}
