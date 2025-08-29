package com.mercadolibre.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target SEARCH_BAR = Target.the("search bar")
            .located(By.name("as_word"));

    public static final Target SEARCH_BUTTON = Target.the("search button")
            .located(By.cssSelector(".nav-search-btn"));
}
