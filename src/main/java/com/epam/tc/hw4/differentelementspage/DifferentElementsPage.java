package com.epam.tc.hw4.differentelementspage;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage {

    @FindBy(xpath = "//*[contains(@class,'m-l8')]/li/a/span")
    private WebElement serviceMenu;

    @FindBy(xpath = ".//a[text() = 'Different elements']")
    private WebElement menuItemDifferentElements;

    @FindBy(className = "main-content")
    private WebElement mainContent;

    @FindBy(css = "label.label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(css = "label.label-radio")
    private List<WebElement> radios;

    @FindBy(css = "select.uui-form-element")
    private WebElement dropDownItem;

    @FindBy(css = "ul.panel-body-list.logs")
    private WebElement logs;

    public void openDifferentElementsPage() {
        serviceMenu.click();
        menuItemDifferentElements.click();
    }

    public WebElement getMainContent() {
        return mainContent;
    }

    @Step("Select checkbox {0}")
    public void tickCheckbox(String word) {
        for (WebElement w : checkboxes) {
            if (w.getText().contains(word)) {
                w.click();
            }
        }
    }

    @Step("Select radios {0}")
    public void tickRadios(String word) {
        radios.stream().filter(x -> x.getText().contains(word))
                .findAny()
                .ifPresent(WebElement::click);
    }

    @Step("Select value {0} in dropdown")
    public void tickDropDownItem(String word) {
        Select dropDown = new Select(dropDownItem);
        dropDown.selectByVisibleText(word);
    }

    public String getLogs() {
        return logs.getText();
    }

}
