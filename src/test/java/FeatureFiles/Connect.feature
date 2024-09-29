Feature: Connect to people

  Background:
    Given Navigate to website
    When Enter the data/datas
      |email      |yumrutepemustafa44@gmail.com|
      |password   |Mstf51..                    |
    Then Click on the element/elements
      |loginButton|

    Scenario: Connect with people
      When Enter the datas and press KeysENTER
      |searchButton|software|
      Then Click on the element/elements
      |people|
      And Connect to people
      |status|
      |barInfo|
      |connect1|
      |sendWithoutANote|
      |connect|

