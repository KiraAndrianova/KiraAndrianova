package com.epam.tc.hw4;

import com.epam.tc.hw4.testdata.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    @Description(value = "Login Test Checks")
    @Epic("Login")
    @Feature("User login")
    @Story("AAA-1234")
    public void loginTest() {

        loginPage.login(TestData.login, TestData.password);

        //step 2 - assert browser title
        softAssertions.assertThat(webDriver.getTitle()).contains(TestData.expectedIndexPageTitle);

        //step 4 - Assert Username is loggined
        softAssertions.assertThat(loginPage.getUserName())
                .isEqualTo(TestData.expectedUserName);

        softAssertions.assertAll();
    }

}
