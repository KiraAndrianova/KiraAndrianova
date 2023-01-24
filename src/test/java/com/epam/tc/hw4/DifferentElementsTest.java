package com.epam.tc.hw4;

import com.epam.tc.hw4.driverutils.WebDriverActions;
import com.epam.tc.hw4.testdata.TestData;
import io.qameta.allure.Epic;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class DifferentElementsTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test(description = "Different Elements page check")
    @Epic("Different Elements page check")
    public void differentElementsTest() {

        loginPage.login(TestData.login, TestData.password);
        differentElementsPage.openDifferentElementsPage();

        WebDriverActions.switchToOpenedWindow(webDriver);

        //step 6 - Select checkboxes Water, Wind
        differentElementsPage.tickCheckbox(TestData.waterCheckbox);
        differentElementsPage.tickCheckbox(TestData.windCheckbox);

        //Select radio Selen
        differentElementsPage.tickRadios(TestData.selenRadioButton);

        //Select in dropdown Yellow
        differentElementsPage.tickDropDownItem(TestData.yellowDropdownItem);

        softAssertions.assertThat(differentElementsPage.getLogs())
                .contains(TestData.waterLogItem)
                .contains(TestData.windLogItem)
                .contains(TestData.selenLogItem)
                .contains(TestData.yellowLogItem);

        softAssertions.assertAll();

    }

}
