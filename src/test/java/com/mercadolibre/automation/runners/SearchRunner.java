package com.mercadolibre.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/search",
        glue = "com.mercadolibre.automation.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SearchRunner {
}
