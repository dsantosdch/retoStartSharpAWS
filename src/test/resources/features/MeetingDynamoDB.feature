Feature: Use a DynamoDB Table to fill fields for a meeting

  Background:
    Given i login

  Scenario: Get items from a DynamoDB table to create a meeting

    Given a dynamoDB table
    When i get the data from the table
    And fill the meeting fields
    Then i should see the meeting