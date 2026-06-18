package com.epam.tc.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/")
    public static HomePage homePage;

    @Url("/metals-colors")
    public static MetalColorsPage metalColorsPage;

}
