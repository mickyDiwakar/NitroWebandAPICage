Feature: login test
  Background:
    Given  I will enter the url
     @smoke
    Scenario: verify the homepage
     # When I will enter the "username"

      Then I will verify the home page title
       And I will click on "thread1" login btn

  @smoke
  Scenario: verify the homepage2
     # When I will enter the "username"
    And I will click on "thread2" login btn
    Then I will verify the home page title



