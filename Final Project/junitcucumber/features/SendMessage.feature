@SendMessage
Feature: Send message;

 Scenario: Send message to group of users
    Given I logged successfully
    When I Click new message
    When I Input valid summary and email addresses
    When I click sent message
    Then Message is sent
