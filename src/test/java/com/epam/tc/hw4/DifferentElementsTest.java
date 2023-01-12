package com.epam.tc.hw4;

import com.epam.tc.hw4.differentelementspage.DifferentElementsPage;
import com.epam.tc.hw4.driverutils.WebDriverActions;
import com.epam.tc.hw4.loginpage.LoginPage;
import io.qameta.allure.Epic;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DifferentElementsTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test(description = "Different Elements page check")
    @Epic("Different Elements page check")
    public void differentElementsTest() {

        LoginPage loginPage = PageFactory
                .initElements(webDriver, LoginPage.class);

        loginPage.login("Roman", "Jdi1234");

        DifferentElementsPage differentElementsPage = PageFactory
                .initElements(webDriver, DifferentElementsPage.class);

        differentElementsPage.openDifferentElementsPage();

        WebDriverActions webDriverActions = new WebDriverActions(webDriver);
        webDriverActions.waitUntilCondition(ExpectedConditions.elementToBeClickable(differentElementsPage
                .getMainContent()));

        webDriverActions.switchToOpenedWindow(webDriver);

        //step 6 - Select checkboxes Water, Wind
        differentElementsPage.tickCheckbox("Water");
        differentElementsPage.tickCheckbox("Wind");

        //Select radio Selen
        differentElementsPage.tickRadios("Selen");

        //Select in dropdown Yellow
        differentElementsPage.tickDropDownItem("Yellow");

        softAssertions.assertThat(differentElementsPage.getLogs())
                .contains("Water: condition changed to true")
                .contains("Wind: condition changed to true")
                .contains(" metal: value changed to Selen")
                .contains("Colors: value changed to Yellow");

        softAssertions.assertAll();

    }

}
