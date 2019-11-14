Feature: As a user i should be able to make API call for pets status from petsstore

  Scenario Outline:  User calls webservice to find pet status
    Given the user checks for pet store
    When the user request to find the '<Pets_status>'
    Then the user validate '<Number>' of '<Pets_status>' and '<Pet_name>'
    Examples:
      |Number| Pets_status| Pet_name|
      | 3059 | available  | doggie  |

