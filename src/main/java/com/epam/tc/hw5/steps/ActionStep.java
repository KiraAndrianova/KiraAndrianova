package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.DifferentElementsPage;
import com.epam.tc.hw5.UserTablePage;
import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.driverutils.WebDriverActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void iOpenLoginDropdown() {
        TestContext.getContext().getObject("driver", WebDriver.class).get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @When("I login as user \"Roman Iovlev\"")
    public void iInputUserNameAndPassword() {
        loginPage.login("Roman", "Jdi1234");
    }

    @Given("I am on Different Elements page")
    public void iAmOnDifferentElementsPage() {
        WebDriver driver = TestContext.getContext().getObject("driver", WebDriver.class);
        loginPage.login("Roman", "Jdi1234");

        DifferentElementsPage differentElementsPage = PageFactory
                .initElements(driver, DifferentElementsPage.class);

        differentElementsPage.openDifferentElementsPage();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(differentElementsPage
                .getMainContent()));
    }

    @When("I select values {string}, {string}, {string}, {string}")
    public void iSelectCheckboxes(String string, String string2, String string3, String string4) {
        WebDriver driver = TestContext.getContext().getObject("driver", WebDriver.class);
        DifferentElementsPage differentElementsPage = PageFactory
                .initElements(driver, DifferentElementsPage.class);

        differentElementsPage.tickCheckbox(string);
        differentElementsPage.tickCheckbox(string2);
        differentElementsPage.tickRadios(string3);
        differentElementsPage.tickDropDownItem(string4);
    }

    @When("I click on {string} button in Header")
    public void iClickOnButtonInHeader(String string) {
        WebDriver driver = TestContext.getContext().getObject("driver", WebDriver.class);

        UserTablePage userTablePage = PageFactory
                .initElements(driver, UserTablePage.class);

        userTablePage.openServiceMenu(string);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userTablePage
                .getMainContent()));

    }

    @When("I click on {string} button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(String string) {
        WebDriver driver = TestContext.getContext().getObject("driver", WebDriver.class);

        UserTablePage userTablePage = PageFactory
                .initElements(driver, UserTablePage.class);

        userTablePage.openServiceMenu(string);
        userTablePage.openUserTablePage(string);

        WebDriverActions webDriverActions = new WebDriverActions(driver);
        webDriverActions.waitUntilCondition(ExpectedConditions.elementToBeClickable(userTablePage
                .getMainContent()));

        webDriverActions.switchToOpenedWindow(driver);

    }

    @When("I select 'vip' checkbox for {string}")
    public void iSelectCheckboxForUser(String string) {
        WebDriver driver = TestContext.getContext().getObject("driver", WebDriver.class);

        UserTablePage userTablePage = PageFactory
                .initElements(driver, UserTablePage.class);

        userTablePage.userIvanCheckboxClick(string);
    }

}
