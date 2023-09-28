Feature: Fill meeting with a json from a bucket S3

Scenario: Get json file from a bucket S3 and fill a StartSharp meeting

  Given a bucket S3
  And a json file in the bucket
  When i login
  And try to create a meeting with the json data
  Then the meeting should be created