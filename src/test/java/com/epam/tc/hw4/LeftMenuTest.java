package com.epam.tc.hw4;

import com.epam.tc.hw4.testdata.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class LeftMenuTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    @Description(value = "Left Menu checks")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Left menu elements check")
    public void leftMenuTest() {

        softAssertions.assertThat(leftMenu.getLeftMenu())
                .containsExactlyElementsOf(TestData.expectedElems);

        softAssertions.assertAll();
    }
}
