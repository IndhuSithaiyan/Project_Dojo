Feature: To validate Login Functionality of Bank Management System Application

  Scenario Outline: Verification of Login by giving valid inputs "<scenario>"

    Given open the browser and launch the Bank Management home page
    When user is able to login by using username as “<username>” and password as “<password>”
    And click on login button
    Then user logged in successfully and navigated to page

    Examples:
      | scenario                | username   | password       |
      | login_with_valid_inputs | "34567832" | "paSSword@123" |

  Scenario Outline: Verification of Login by giving invalid inputs "<scenario>"

    Given open the browser and launch the Bank Management home page
    When user is able to login by using username as “<username>” and password as “<password>”
    And click on login button
    Then user is getting error <error>

    Examples:
      | scenario                  | username   | password   | error                               |
      | login_with_invalid_inputs | "00000000" | "password" | "Username or Password is invalid!!" |
