package com.epam.tc.hw5.hook;

import com.epam.tc.hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {

    private WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        TestContext.getContext().setObject("driver", driver);
        String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.getContext().cleanContext();
    }
}
