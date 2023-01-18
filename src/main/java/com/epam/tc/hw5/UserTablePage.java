package com.epam.tc.hw5;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage {

    @FindBy(xpath = "//*[contains(@class,'m-l8')]/li/a/span")
    private WebElement serviceMenu;

    @FindBy(xpath = ".//a[text() = 'User Table ']")
    private WebElement menuUserTableElements;

    @FindBy(className = "main-content")
    private WebElement mainContent;

    @FindBy(css = "ul.panel-body-list.logs")
    private WebElement logs;

    @FindBy(xpath = "//*[@id='user-table']/tbody/tr/td/select")
    private List<WebElement> numberTypeDropdownsList;

    @FindBy(xpath = "//a[contains(text(), 'Roman')]/preceding::select/option")
    private List<WebElement> typeOfUsersList;

    @FindBy(xpath = "//*[@id='user-table']/tbody/tr/td[1]")
    private List<WebElement> numberOfUsers;

    @FindBy(xpath = "//*[@id='user-table']/tbody/tr/td/a")
    private List<WebElement> numberOfUsernamesList;

    @FindBy(xpath = "//*[contains(@class, 'user-descr')]/span")
    private List<WebElement> numberOfDescriptionsList;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> numberOfCheckboxesList;

    @FindBy(id = "ivan")
    private WebElement userIvanCheckbox;



    public void openServiceMenu(String string) {
        serviceMenu.click();
    }

    public void openUserTablePage(String string) {
        serviceMenu.click();
        menuUserTableElements.click();
    }

    public WebElement getMainContent() {
        return mainContent;
    }

    public void userIvanCheckboxClick(String string) {
        userIvanCheckbox.click();
    }

    public List<WebElement> getNumberOfTypeDropdownsList() {
        return numberTypeDropdownsList;
    }

    public List<WebElement> getNumberOfUsernamesList() {
        return numberOfUsernamesList;
    }

    public List<WebElement> getNumberOfDescriptionsList() {
        return numberOfDescriptionsList;
    }

    public List<WebElement> getNumberOfCheckboxesList() {
        return numberOfCheckboxesList;
    }

    public List<String> getNumberOfUsersList() {
        return numberOfUsers.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getDropdownsList() {
        return numberTypeDropdownsList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getUsernamesList() {
        return numberOfUsernamesList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getDescriptionsList() {
        return numberOfDescriptionsList.stream().map(t -> t.getText().replace('\n', ' ')).collect(Collectors.toList());
    }

    public List<String> getCheckboxesList() {
        return numberOfCheckboxesList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTypeOfUsersList() {
        return typeOfUsersList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getLogs() {
        return logs.getText();
    }

}
