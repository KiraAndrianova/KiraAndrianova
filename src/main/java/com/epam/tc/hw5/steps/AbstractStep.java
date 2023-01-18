package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.DifferentElementsPage;
import com.epam.tc.hw5.LoginPage;
import com.epam.tc.hw5.UserTablePage;
import com.epam.tc.hw5.context.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractStep {

    public final LoginPage loginPage;
    public final UserTablePage userTablePage;
    public final DifferentElementsPage differentElementsPage;

    public AbstractStep() {
        WebDriver driver = TestContext.getContext().getObject("driver", WebDriver.class);

        loginPage = PageFactory
                .initElements(driver, LoginPage.class);
        userTablePage = PageFactory
                .initElements(driver, UserTablePage.class);
        differentElementsPage = PageFactory
                .initElements(driver, DifferentElementsPage.class);

    }
}
