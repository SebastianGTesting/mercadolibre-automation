package com.mercadolibre.automation.stepdefinitions;

import com.mercadolibre.automation.questions.SearchResult;
import com.mercadolibre.automation.tasks.SearchProduct;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchStepDefinitions {

    static {
        // Ensure ChromeDriver is available before WebDriver is created
        WebDriverManager.chromedriver().setup();
    }

    @Managed(driver = "chrome")
    WebDriver driver;

    Actor user = Actor.named("User");

    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("the user is on the Mercado Libre home page")
    public void openHomePage() {
        user.attemptsTo(Open.url("https://www.mercadolibre.com.co/"));
    }

    @When("they search for {string}")
    public void searchProduct(String product) {
        user.attemptsTo(SearchProduct.called(product));
    }

    @Then("they should see results related to {string}")
    public void validateResults(String product) {
        assertThat("The search results page should contain the product keyword",
                user.asksFor(SearchResult.contains(product)), is(true));
    }
}
