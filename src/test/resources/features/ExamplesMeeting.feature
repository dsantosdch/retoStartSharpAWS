Feature: fill the meeting fields using data from examples

  Background:
  Given i login

  Scenario Outline: fill the meeting fields

    When entry the "<meeting_name>" and "<meeting_number>" of the meeting
    Then i should see the meeting created

    Examples:
    |meeting_name|meeting_number|
    |reunionExample|0129383     |
    |Dummy Text    |85738682    |
    |Prueba 1      |99489483984 |
