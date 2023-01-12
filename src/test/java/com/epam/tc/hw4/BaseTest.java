package com.epam.tc.hw4;

import com.epam.tc.hw4.attachmentutils.AttachmentUtils;
import com.epam.tc.hw4.driverutils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void prepareToTest(ITestContext context) {
        webDriver = DriverManager.setupDriver();
        context.setAttribute("driver", webDriver);
        String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.navigate().to(baseURL);
    }

    @AfterClass
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
