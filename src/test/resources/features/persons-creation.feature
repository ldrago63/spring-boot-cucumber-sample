Feature: Persons create

  Scenario: Create a person
    When I create the person with first name 'Lucas', last name 'DRAGO' and birth date '1990-06-11'.
    Then A person is returned with first 'Lucas', last name 'DRAGO' and birth date '1990-06-11'.
    Then Person 'Lucas' 'DRAGO' is found in database with returned object id.
