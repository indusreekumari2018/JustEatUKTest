Feature: Validate error messages

Scenario Outline: Search for restaurants in an area with invalid postal code
Given user navigates to the website "<url>"
When  user want food with "<invalidPostalcode>"
And   user perform search for restaurants
Then  user should see appropriate error message "<errorMessage>"

Examples:
 |url                       |   |invalidPostalcode |    |errorMessage                       |
 |http://www.just-eat.co.uk/|   |ABCDE             |    |Please enter a full, valid postcode|
 |http://www.just-eat.co.uk/|   |                  |    |Please enter a postcode            |
