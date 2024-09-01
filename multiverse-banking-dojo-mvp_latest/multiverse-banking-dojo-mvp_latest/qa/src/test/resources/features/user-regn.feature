Feature: To validate Registration Functionality of Bank Management System Application

  Scenario Outline: Verification of Registration by giving valid inputs "<scenario>"
    Given open the browser and launch the Bank Management home page
    And click on register button
    When enter details to register "<First Name>", "<Last Name>", "<Password>", "<Account Type>", "<PAN>", "<Mobile Num>", "<Email>", "<Amount>"
    And click on submit
    Then user should be reach on Account details page

    Examples:
      | scenario                       | First Name | Last Name | Password      | Account Type | PAN        | Mobile Num | Email                       | Amount |
      | user details with valid inputs | Ram        | Kumar     | UserTest@2023 | Savings      | ABCDE1234F | 9876543210 | ramkumardojomvp01@gmail.com | 5000   |

  Scenario Outline: Verification of Registration by giving invalid inputs <scenario>
    Given open the browser and launch the Bank Management home page
    And click on register button
    When enter details to register "<First Name>", "<Last Name>", "<Password>", "<Account Type>", "<PAN>", "<Mobile Num>", "<Email>", "<Amount>"
    And click on submit
    Then user should be receive error warning while entering invalid values "<error>"

    Examples:
      | scenario                                      | First Name | Last Name | Password         | Account Type | PAN        | Mobile Num | Email              | Amount | error                                                                               |
      | user details with invalid inputs_firstName    | 123        | Kumar     | User@123         | Savings      | MNBDX2154A | 9765432817 | ramkumardojomvp01@ | 5000   | Please enter only alphabet characters, special characters not allowed               |
      | user details with invalid inputs_lastName     | Ravi       | 9790      | ravi@19873A      | Current      | KJLDF90873 | 8709812438 | ramkumardojomvp01@ | 7000   | Please enter only alphabet characters, special characters not allowed               |
      | user details with invalid inputs_pan          | Mani       | Kandan    | ManiKandan@94389 | Savings      | abcd       | 7893409862 | ramkumardojomvp01@ | 5000   | Please enter only alphanumeric with capital letters, special characters not allowed |
      | user details with invalid inputs_MobileNumber | Harish     | Mohan     | HarishMohan@415  | Savings      | OILDF90873 | xzvsj12309 | ramkumardojomvp01@ | 7000   | Please enter a valid number                                                         |