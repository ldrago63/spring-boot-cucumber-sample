Feature: Persons view in web browser

  @webui
  Scenario: Display a person
    Given I create the person with first name 'Lucas', last name 'DRAGO' and birth date '1990-06-11'.
    When I open the web browser to display last created user.
    Then The person page displays :
      | User found | Lucas | DRAGO |


  @webui
  Scenario: Display a person
    When I open the web browser to display the person with id '545454545454'
    Then The person page displays :
      | User not found |  |  |
