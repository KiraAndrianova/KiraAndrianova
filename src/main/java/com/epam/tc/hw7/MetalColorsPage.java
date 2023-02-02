package com.epam.tc.hw7;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.MultiDropdown;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class MetalColorsPage extends WebPage {

    @UI("input[type=radio]") public static RadioButtons radioGroup;

    @UI("#elements-checklist input[type=checkbox]") public static Checklist checkListElements;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colorsSelectDropdown;

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metalsSelectDropdown;

    @UI("#salad-dropdown") public static MultiDropdown saladDropdown;

    @UI(".form") public static Form metalsColorsForm;

    @UI("#submit-button") public static Button submitButton;

    @UI(".panel-body-list.logs>li") public static Text lastLogEntry;

    @UI(".panel-body-list.results") public static Text results;

}
