package com.epam.tc.hw7;

import static com.epam.tc.hw7.HomePage.loginForm;
import static com.epam.tc.hw7.HomePage.navigation;
import static com.epam.tc.hw7.HomePage.userIcon;
import static com.epam.tc.hw7.JdiSite.metalColorsPage;
import static com.epam.tc.hw7.MetalColorsPage.checkListElements;
import static com.epam.tc.hw7.MetalColorsPage.colorsSelectDropdown;
import static com.epam.tc.hw7.MetalColorsPage.lastLogEntry;
import static com.epam.tc.hw7.MetalColorsPage.metalsSelectDropdown;
import static com.epam.tc.hw7.MetalColorsPage.radioGroup;
import static com.epam.tc.hw7.MetalColorsPage.results;
import static com.epam.tc.hw7.MetalColorsPage.saladDropdown;
import static com.epam.tc.hw7.MetalColorsPage.submitButton;
import static org.hamcrest.CoreMatchers.containsString;

import com.epam.tc.hw7.jsonparser.JsonReadFromTheFile;
import com.epam.tc.hw7.jsonparser.TestDataClass;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MetalColorsTest implements TestsInit {

    JsonReadFromTheFile jsonReadFromTheFile = new JsonReadFromTheFile();

    @BeforeClass
    public void openMetalColors() {
        userIcon.click();
        loginForm.loginAs(ROMAN);
    }

    @Test
    public void metalColorsFormOpenTest() {
        navigation.select("Metals & Colors");
        metalColorsPage.checkOpened();
    }

    @Test(dataProvider = "dataFromJsonFile")
    public void metalColorsFulfillTest(TestDataClass dataClass) {
        navigation.select("Metals & Colors");

        saladDropdown.select("Vegetables");

        checkListElements.select(dataClass.getElements().toArray(new String[0]));
        radioGroup.select(dataClass.getSummary().toArray(new String[0]));
        colorsSelectDropdown.select(dataClass.getColor());
        metalsSelectDropdown.select(dataClass.getMetals());

        saladDropdown.select(dataClass.getVegetables().toArray(new String[0]));

        submitButton.click();

        String expectedResult = "Summary: " + dataClass.getSummary().stream().map(Integer::parseInt)
                .mapToInt(Integer::intValue).sum()
                + "\n"
                + "Elements: " + String.join(", ", dataClass.getElements())
                + "\n"
                + "Color: " + dataClass.getColor()
                + "\n"
                + "Metal: " + dataClass.getMetals()
                + "\n"
                + "Vegetables: " + String.join(", ", dataClass.getVegetables());

        results.is().text(expectedResult);
    }

    @Test
    public void metalColorsSubmitTest() {
        navigation.select("Metals & Colors");
        submitButton.click();
        lastLogEntry.assertThat()
                .text(containsString("submit-button:button clicked"));
    }

    @DataProvider(name = "dataFromJsonFile")
    public Object[] listOfData() throws IOException {
        return jsonReadFromTheFile.parseJson().toArray();
    }
}
