package com.epam.tc.hw4;

import com.epam.tc.hw4.differentelementspage.DifferentElementsPage;
import com.epam.tc.hw4.driverutils.DriverManager;
import com.epam.tc.hw4.homepage.HomePage;
import com.epam.tc.hw4.leftmenu.LeftMenuPage;
import com.epam.tc.hw4.loginpage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    static WebDriver webDriver;
    public static LoginPage loginPage;
    public static DifferentElementsPage differentElementsPage;
    public static HomePage homePage;
    public static LeftMenuPage leftMenu;

    @BeforeClass
    public static void prepareToTest(ITestContext context) {
        webDriver = DriverManager.setupDriver();
        context.setAttribute("driver", webDriver);
        String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";
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

    @AfterClass
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
