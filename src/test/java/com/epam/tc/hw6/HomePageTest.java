package com.epam.tc.hw6;

import com.epam.tc.hw6.testdata.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    @Description(value = "Home Page checks")
    @Epic("Home page elements check")
    public void homePageTest() {

        softAssertions.assertThat(homePage.getHeader())
                .containsExactlyElementsOf(TestData.expectedHeaderMenu);

        softAssertions.assertThat(homePage.getWebElementListImages())
                .allMatch(WebElement::isDisplayed)
                .hasSize(4);

        softAssertions.assertThat(homePage.getListTexts())
                .hasSize(4)
                .containsExactlyElementsOf(TestData.expectedListTexts);

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
