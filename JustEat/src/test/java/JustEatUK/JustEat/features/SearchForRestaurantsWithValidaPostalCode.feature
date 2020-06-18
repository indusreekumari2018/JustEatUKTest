Feature: Use website to find restaurants
So that I can order food
As a hungry customer
I want to be able to find restaurants in my area

Scenario Outline: Search for restaurants in an area
Given I navigate to "<url>"
When  I want food in "<postalcode>"
And   I search for restaurants
Then  I should see some restaurants in "<expectedPostalCode>"

Examples:
 |url                       |   |postalcode |    |expectedPostalCode|
 |http://www.just-eat.co.uk/|   |AR51 1AA   |    |AR51 1AA          |
 |http://www.just-eat.co.uk/|   |AR511AA    |    |AR51 1AA          |
 |http://www.just-eat.co.uk/|   |ar511aa    |    |AR51 1AA          |