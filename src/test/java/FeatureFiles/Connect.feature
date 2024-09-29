Feature: Connect to people

  Background:
    Given Navigate to website
    When Enter the data/datas
      | email    | yumrutepemustafa44@gmail.com |
      | password | Mstf51..                     |
    Then Click on the element/elements
      | loginButton |



  Scenario Outline: Connect with people
    When Enter the datas and press KeysENTER
      | searchButton | <search> |
    Then Click on the element/elements
      | people |
    And Connect to people
      | status           |
      | barInfo          |
      | connect1         |
      | sendWithoutANote |
      | connect          |
      | more             |
      | connectInMore    |



    Examples:
      | search            |
      | engineer          |
      | test              |
      | sdet              |
      | software          |
      | mühendis          |
      | qa                |
      | kalite            |
      | quality assurance |
      | automation test   |
      | tester            |
      | developer         |
      | bussines analys   |
      | product owner     |
      | scrum master      |
      | agile             |
      | yazılım           |
      | test mühendisi    |
      | software engineer |
      | test engineer     |
      | quality engineer  |

