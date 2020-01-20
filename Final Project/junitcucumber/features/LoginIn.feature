@Login
Feature: Login with valid credentials;

 Scenario: Login to mail
    Given I on mail.ru page
    When I input valid credentials
    Then I see logout link

