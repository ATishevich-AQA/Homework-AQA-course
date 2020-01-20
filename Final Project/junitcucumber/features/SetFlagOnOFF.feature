
Feature: Set flag;
  Scenario: Test move email into SpamBox and otherwise)
        Given I am on main page
        When Move email into spambox and otherwise
        Then Message is moved to spambox

  Scenario: Set Flag On/OFF
        Given I passed authorization successfully
        When I set flag ON for first three emails from the list
        When I set flag OFF for first three emails from the list
        Then No emails with flag ON

  Scenario: Login to mail
        Given I on mail.ru page
        When I input valid credentials
        Then I see logout link

  Scenario: Send message to group of users
        Given I logged successfully
        When I Click new message
        When I Input valid summary and email addresses
        When I click sent message
        Then Message is sent

