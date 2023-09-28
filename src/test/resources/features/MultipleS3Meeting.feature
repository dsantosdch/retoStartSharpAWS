Feature: Fill meeting with a json from a bucket S3

  Background:
    Given a bucket S3
    And a json file in the bucket
    When i login

  Scenario: Fill the fileds with multiple data from a json file

    When i try to enter the "<meeting_name>" and "<meeting_number>"
    Then the meeting should be created with the data from the json