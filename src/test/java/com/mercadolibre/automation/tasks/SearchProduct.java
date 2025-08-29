package com.mercadolibre.automation.tasks;

import com.mercadolibre.automation.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchProduct implements Task {
    private final String product;

    public SearchProduct(String product) {
        this.product = product;
    }

    public static SearchProduct called(String product) {
        return instrumented(SearchProduct.class, product);
    }

    @Step("{0} searches for #product")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(product).into(HomePage.SEARCH_BAR),
                Click.on(HomePage.SEARCH_BUTTON)
        );
    }
}
