Feature: Login Test
  To validate login functionality

  @regression @critical
  Scenario: login with valid credentials
    Given the user opens "https://ep-core.eccountplatform-omnio-sit-omnicore-epcore.com/login"
    When the user enters "Tux001", "London", "jjeganathan", "*JPsep2021"
    Then the user is in dashboard page

  @regression
  Scenario: login with Invalid credentials
    Given the user opens "https://ep-core.eccountplatform-omnio-sit-omnicore-epcore.com/login"
    And dataTableTest
      | Name | Age |
      | JJ   |  30 |
      | JK   |   6 |
    When the user enters "Tux001", "London", "jjeganathan", "*******"
    Then the user is in login page
