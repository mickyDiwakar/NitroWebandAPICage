Feature: demo feature

  Scenario Outline: login to application
    Given I will login to the application with "http://demo.automationtesting.in/"
    When I will enter the deatils
      | Data     |  |
      | testdata |  |
    Then Verfiy few "<Value>" links
    Examples:
      | Value |  |
      | test  |  |