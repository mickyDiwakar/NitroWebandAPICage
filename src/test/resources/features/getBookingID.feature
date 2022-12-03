@api
Feature: get bookingid
@getbooking
 Scenario: getbooking
   Given I will hit the post request
   Given I will hit the get request
   Then I will verify the respose
@testcon
  Scenario: first
  Given I will hit the head request
  Then I will verify the respose

  @testcon
  Scenario: second
    Given I will hit the put request
    Then I will verify the respose