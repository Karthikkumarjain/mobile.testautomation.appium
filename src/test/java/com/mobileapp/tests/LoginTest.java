package com.mobileapp.tests;

import com.mobileapp.base.BaseTest;
import com.mobileapp.pages.HomePage;
import com.mobileapp.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {
    HomePage homePage;

private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
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
        logger.info("Login page is displayed");

    }


}
