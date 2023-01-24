package com.epam.tc.hw4.leftmenu;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage {

    @FindBy(xpath = "//*[contains(@class,'sidebar-menu')]/li/a/span")
    private List<WebElement> leftMenu;

    @Step("Check left menu items")
    public List<String> getLeftMenu() {
        return leftMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
