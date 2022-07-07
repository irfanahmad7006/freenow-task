Feature: Verify All User Operations

  Scenario: Search for the user
    Given search for the username "Samantha" with url "/users" for "userName" queryParam
    Then I verify response with status code 200
