Feature: To validate Loan Functionality of Bank Management System Application

  Scenario Outline: Verification of Loan by giving valid inputs "<scenario>"

    Given open the browser and launch the Bank Management home page
    When user is able to login by using username as “<username>” and password as “<password>”
    And click on login button
    And user is able to apply loan by selecting loan section "<loanRequestType>" "<interestType>" "<loanAmount>"
    Then user is able to see their applied loan details page

    Examples:
      | scenario                   | username   | password       | loanRequestType | interestType | loanAmount |
      | valid_inputs_to_apply_loan | "34567832" | "paSSword@123" | Personal        | Fixed        | 400000     |
      | apply_loan_for_Education   | "34567832" | "paSSword@123" | Education       | Fixed        | 200000     |
      | apply_loan_for_Car         | "34567832" | "paSSword@123" | Car             | Variable     | 500000     |
      | apply_loan_for_Home        | "34567832" | "paSSword@123" | Home            | Fixed        | 2500000    |
