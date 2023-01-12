package com.epam.tc.hw4;

import com.epam.tc.hw4.loginpage.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    @Description(value = "Login Test Checks")
    @Epic("Login")
    @Feature("User login")
    @Story("AAA-1234")
    public void loginTest() {

        LoginPage loginPage = PageFactory
                .initElements(webDriver, LoginPage.class);

        loginPage.login("Roman", "Jdi1234");

        //step 2 - assert browser title
        softAssertions.assertThat(webDriver.getTitle()).contains("Home Page");

        //step 4 - Assert Username is loggined
        softAssertions.assertThat(loginPage.getUserName())
                .isEqualTo("ROMAN IOVLEV");

        softAssertions.assertAll();
    }
}
