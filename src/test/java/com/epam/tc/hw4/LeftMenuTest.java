package com.epam.tc.hw4;

import static java.util.Arrays.asList;

import com.epam.tc.hw4.leftmenu.LeftMenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LeftMenuTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    @Description(value = "Left Menu checks")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Left menu elements check")
    public void leftMenuTest() {

        LeftMenuPage leftMenu = PageFactory
                .initElements(webDriver, LeftMenuPage.class);

        List<String> expectedElems = asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        softAssertions.assertThat(leftMenu.getLeftMenu())
                .containsExactlyElementsOf(expectedElems);

        softAssertions.assertAll();
    }
}
