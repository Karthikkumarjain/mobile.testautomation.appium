package com.saucelab.tests;

import com.saucelab.base.BaseTest;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeTest
    public void set() {

        homePage = new HomePage();
        loginPage = new LoginPage();
    }


    @Test
    void navigateToLoginPageSuccesfullyTest() {
        homePage.goToLoginPage();
        String actualResult = loginPage.getText();
        Assertions.assertThat(actualResult).isEqualTo("Login");

    }
}
