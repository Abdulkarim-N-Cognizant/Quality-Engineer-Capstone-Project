@login
Feature: Login

  @smoke @regression
  Scenario Outline: Login Validation
    Given the user is on the login page
    When the user enters username "<username>" on the login page
    And the user enters password "<password>" on the login page
    And the user clicks the login button
    Then the <result> should be displayed

    Examples:
      | username | password      | result              |
      | Admin    | admin123      | dashboard           |
      | Admin    | wrongpassword | Invalid Credentials Alert |

  @regression @positive
  Scenario: Forgot your password
    Given the user is on the login page
    When the user clicks the Forgot your Password? hyperlink
    Then the user is directed to the password reset page
