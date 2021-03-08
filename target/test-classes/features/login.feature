@Login
Feature: Verify the login functionality in the Flipkart application

  @Login_ValidCredential @smoke
  Scenario:Verify the use able to login through valid credential
    Given the user launch the flipkart application
    When user enter the Username and Password
      | UserName   | Password   |
      | 9629913995 | sWADIKA123 |
    And user click on login button
    Then verify the user able to view the Home screen