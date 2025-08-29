package com.mercadolibre.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class SearchResult implements Question<Boolean> {
    private final String keyword;

    public SearchResult(String keyword) {
        this.keyword = keyword;
    }

    public static SearchResult contains(String keyword) {
        return new SearchResult(keyword);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String pageSource = BrowseTheWeb.as(actor).getDriver().getPageSource();
        return pageSource != null && pageSource.toLowerCase().contains(keyword.toLowerCase());
    }
}
