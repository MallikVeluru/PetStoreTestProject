Feature: As a user i should be able to search for given word in wikipedia and same time i can view result in different language

  Scenario Outline:  Search for given word in Wikipedia
    Given the user navigated to wikipedia
    When the user search for a '<Given_word>' in english
    Then the user validate '<Given_word>' in search result
    And the user change to '<Other_language>' and validate '<Give_word_in_other_language>'
  Examples:
    |Given_word| Other_language  | Give_word_in_other_language|
    | Apple    | Welsh (Cymraeg) | Afal                       |
    | Rose     | Welsh (Cymraeg) | Rhosyn                     |