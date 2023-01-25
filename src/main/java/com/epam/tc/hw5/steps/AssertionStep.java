package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.DifferentElementsPage;
import com.epam.tc.hw5.UserTablePage;
import com.epam.tc.hw5.context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Then("I see page title as {string}")
    public void iSeePageTitleAsHomePage(String pageTitle) {
        WebDriver driver = TestContext.getContext().getObject("driver", WebDriver.class);
        softAssertions.assertThat(driver.getTitle()).contains(pageTitle);
        softAssertions.assertAll();
    }

    @Then("user name is {string}")
    public void userNameIsCorrect(String expectedName) {
        softAssertions.assertThat(loginPage.getUserName())
                .isEqualTo(expectedName);
        softAssertions.assertAll();
    }

    @Then("I see appropriate log record for {string}, {string}, {string}, {string}")
    public void iSeeAppropriateLogRecord(String string, String string2, String string3, String string4) {
        softAssertions.assertThat(differentElementsPage.getLogs())
                .contains(string)
                .contains(string2)
                .contains(string3)
                .contains(string4);
        softAssertions.assertAll();
    }

    @Then("{string} page should be opened")
    public void pageIsOpened(String title) {
        WebDriver driver = TestContext.getContext().getObject("driver", WebDriver.class);

        softAssertions.assertThat(driver.getTitle()).isEqualTo(title);
        softAssertions.assertAll();
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsDisplayedOnUserTable() {
        softAssertions.assertThat(userTablePage.getNumberOfTypeDropdownsList())
                .allMatch(WebElement::isDisplayed)
                .hasSize(6);
        softAssertions.assertAll();
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void numberOfUsernamesDisplayedOnUsersTable() {
        softAssertions.assertThat(userTablePage.getNumberOfUsernamesList())
                .allMatch(WebElement::isDisplayed)
                .hasSize(6);
        softAssertions.assertAll();
    }


    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void numberOfDescriptionsDisplayedOnUsersTable() {
        softAssertions.assertThat(userTablePage.getNumberOfDescriptionsList())
                .allMatch(WebElement::isDisplayed)
                .hasSize(6);
        softAssertions.assertAll();
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void numberOfCheckboxesDisplayedOnUsersTable() {
        softAssertions.assertThat(userTablePage.getNumberOfCheckboxesList())
                .allMatch(WebElement::isDisplayed)
                .hasSize(6);
        softAssertions.assertAll();
    }

    @Then("User table should contain following values:")
    public void userTableContainsFollowingValues(DataTable dataTable) {
        List<String> expectedNumber = dataTable.asMaps().stream().map(t -> t.get("Number"))
                .collect(Collectors.toList());
        List<String> expectedUserColumn = dataTable.asMaps().stream().map(t -> t.get("User"))
                .collect(Collectors.toList());
        List<String> expectedDesc = dataTable.asMaps().stream().map(t -> t.get("Description"))
                .collect(Collectors.toList());

        softAssertions.assertThat(userTablePage.getNumberOfUsersList()).containsExactlyElementsOf(expectedNumber);
        softAssertions.assertThat(userTablePage.getUsernamesList()).containsExactlyElementsOf(expectedUserColumn);
        softAssertions.assertThat(userTablePage.getDescriptionsList()).containsExactlyElementsOf(expectedDesc);
        softAssertions.assertAll();
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void dropdownShouldContainValuesInType(DataTable dataTable) {
        List<String> expectedDropdownItems = dataTable.asMaps().stream().map(t -> t.get("Dropdown Values"))
                .collect(Collectors.toList());

        softAssertions.assertThat(userTablePage.getTypeOfUsersList()).containsExactlyElementsOf(expectedDropdownItems);
        softAssertions.assertAll();
    }

    @Then("1 log row has {string} text in log section")
    public void logRowHasVipValue(String string) {
        softAssertions.assertThat(userTablePage.getLogs())
                .contains(string);
        softAssertions.assertAll();
    }
}
