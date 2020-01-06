Feature: Set flag;

  Scenario: Set Flag On/OFF
    Given I passed authorization successfully
    When I set flag ON for first three emails from the list
    When I set flag OFF for first three emails from the list
    Then No emails with flag ON