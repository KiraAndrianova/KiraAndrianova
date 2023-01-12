package com.epam.tc.hw4;

import static java.util.Arrays.asList;

import com.epam.tc.hw4.homepage.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageNegativeTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    @Description(value = "Home Page negative checks")
    @Epic("Home page elements check")
    public void homePageNegativeTest() {

        HomePage homePage = PageFactory
                .initElements(webDriver, HomePage.class);

        List<String> expectedHeaderMenu = asList("home", "CONTACT FORM", "SERVICE", "METALS & COLORS");

        softAssertions.assertThat(homePage.getHeader())
                .containsExactlyElementsOf(expectedHeaderMenu);

        softAssertions.assertThat(homePage.getWebElementListImages())
                .allMatch(WebElement::isDisplayed)
                .hasSize(4);

        List<String> expectedListTexts = asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base"
                        + "\n(about 20 internal and"
                        + "\nsome external projects),"
                        + "\nwish to get more…");

        softAssertions.assertThat(homePage.getListTexts())
                .hasSize(4)
                .containsExactlyElementsOf(expectedListTexts);

        //Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(homePage.getFrame().isDisplayed()).isTrue();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(homePage.getFrame());

        softAssertions.assertThat(homePage.getFrameButton().isDisplayed()).isTrue();

        //Switch to original window back
        webDriver.switchTo().defaultContent();

        softAssertions.assertAll();
    }

}
