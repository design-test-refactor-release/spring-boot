Feature: Check status

  Scenario: Check status of service
    Given server is started
    When user checks the status of the server
    Then 200 is returned
