Feature: Persons view in web browser

  @webui
  Scenario: Display a person
    Given I create the person with first name 'Lucas', last name 'DRAGO' and birth date '1990-06-11'.
    When I open the web browser to display last created user.
    Then The person page displays :
      | Lucas | DRAGO |
