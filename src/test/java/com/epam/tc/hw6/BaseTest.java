package com.epam.tc.hw6;

import com.epam.tc.hw6.attachmentutils.AttachmentUtils;
import com.epam.tc.hw6.driverfabric.DriverFabric;
import com.epam.tc.hw6.driverutils.DriverManager;
import com.epam.tc.hw6.pages.DifferentElementsPage;
import com.epam.tc.hw6.pages.HomePage;
import com.epam.tc.hw6.pages.LeftMenuPage;
import com.epam.tc.hw6.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    static WebDriver webDriver;
    public static LoginPage loginPage;
    public static DifferentElementsPage differentElementsPage;
    public static HomePage homePage;
    public static LeftMenuPage leftMenu;

    @BeforeClass
    @Parameters({"isLocal", "hub", "browser"})
    public static void prepareToTest(@Optional("false") final boolean isLocal, final String hub, String browser) {
        webDriver = DriverFabric.getWebDriver(isLocal, hub, browser);

        String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.manage().window().maximize();
        webDriver.navigate().to(baseURL);

        loginPage = PageFactory
                .initElements(webDriver, LoginPage.class);
        differentElementsPage = PageFactory
                .initElements(webDriver, DifferentElementsPage.class);
        homePage = PageFactory
                .initElements(webDriver, HomePage.class);
        leftMenu = PageFactory
                .initElements(webDriver, LeftMenuPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            AttachmentUtils.makeScreenshotAttachment("screenshot on failure", screenshot);
        }
    }

    @AfterClass
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
