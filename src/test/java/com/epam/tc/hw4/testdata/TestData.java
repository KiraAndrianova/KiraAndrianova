package com.epam.tc.hw4.testdata;

import static java.util.Arrays.asList;

import java.util.List;

public class TestData {

    public static List<String> expectedHeaderMenu = asList("home", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    public static List<String> expectedElems = asList("Home", "Contact form", "Service",
            "Metals & Colors", "Elements packs");
    public static List<String> expectedListTexts = asList("To include good practices"
                    + "\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base"
                    + "\n(about 20 internal and"
                    + "\nsome external projects),"
                    + "\nwish to get more…");

    public static String login = "Roman";
    public static String password = "Jdi1234";
    public static String expectedIndexPageTitle = "Home Page";
    public static String expectedUserName = "ROMAN IOVLEV";
    public static String waterCheckbox = "Water";
    public static String windCheckbox = "Wind";
    public static String selenRadioButton = "Selen";
    public static String yellowDropdownItem = "Yellow";
    public static String waterLogItem = "Water: condition changed to true";
    public static String windLogItem = "Wind: condition changed to true";
    public static String selenLogItem = " metal: value changed to Selen";
    public static String yellowLogItem = "Colors: value changed to Yellow";
}
