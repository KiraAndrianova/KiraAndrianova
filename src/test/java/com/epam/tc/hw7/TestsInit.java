package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.tc.hw7.JdiSite.homePage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface TestsInit {

    User ROMAN = new User().set(c -> {
        c.name = "Roman";
        c.password = "Jdi1234";
    });

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initElements(JdiSite.class);
        homePage.open();
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
