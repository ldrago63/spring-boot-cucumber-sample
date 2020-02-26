Feature: Persons management

  Scenario: Create a person
    When I create the person with first name 'Lucas', last name 'DRAGO' and birth date '1990-06-11'.
    Then Http code is '201'
    Then A person is returned with first 'Lucas', last name 'DRAGO' and birth date '1990-06-11'.
    Then Person 'Lucas' 'DRAGO' is found in database with returned object id.

  Scenario: Create a person with blank first name
    When I create the person with first name '', last name 'DRAGO' and birth date '1990-06-11'.
    Then Http code is '400'

  Scenario: Create a person with blank last name
    When I create the person with first name 'Lucas', last name '' and birth date '1990-06-11'.
    Then Http code is '400'

  Scenario: Get a person a nominal case
    Given I create the person with first name 'Thomas', last name 'SAMTER' and birth date '1990-01-01'.
    When I get the last created person by her id.
    Then Http code is '200'
    Then A person is returned with first 'Thomas', last name 'SAMTER' and birth date '1990-01-01'.


  Scenario: Get a person a not found person
    When I get a person with id '350553505460546546'.
    Then Http code is '404'
