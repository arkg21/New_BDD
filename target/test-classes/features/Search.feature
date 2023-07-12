Feature: Search Functionality

Scenario: User should be able to search for products in search text field

Given User opens the application
When User enters valid product "HP" in search text field
And User clicks on search button
Then User should be seeing valid product in search results


Scenario: User should searches for an invalid products in search text field

Given User opens the application
When User enters invalid product "Honda" in search text field
And User clicks on search button
Then User should be displayed with warning text saying the no product matches


Scenario: User should search for product without entering any products in search text filed

Given User opens the application
When User do not enter the product in search text field
And User clicks on search button 
Then User should be displayed with warning text saying the no product matches