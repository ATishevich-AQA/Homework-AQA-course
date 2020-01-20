@MoveToSpam
Feature: Test move email into spam;

  Scenario: Test move email into SpamBox and otherwise)
    Given I am on main page
    When Move email into spambox and otherwise
    Then Message is moved to spambox