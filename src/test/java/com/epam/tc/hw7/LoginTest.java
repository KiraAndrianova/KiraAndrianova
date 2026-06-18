package com.epam.tc.hw7;

import static com.epam.tc.hw7.HomePage.loginForm;
import static com.epam.tc.hw7.HomePage.userIcon;
import static com.epam.tc.hw7.HomePage.userName;

import org.testng.annotations.Test;

public class LoginTest implements TestsInit {

    @Test
    public void loginTest() {
        userIcon.click();
        loginForm.loginAs(ROMAN);
        userName.is().displayed();
    }
}
