Feature: Search product on Mercado Libre
  As a user
  I want to search a product
  So that I can see the search results

  Scenario Outline: Search for a product
    Given the user is on the Mercado Libre home page
    When they search for "<product>"
    Then they should see results related to "<product>"

    Examples:
      | product     |
      | iPhone 13   |
      | PlayStation |
      | Samsung S24 |
