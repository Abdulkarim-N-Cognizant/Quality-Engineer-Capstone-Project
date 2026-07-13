@passwordreset
Feature: Password Reset

    @regression @positive
    Scenario: Forgot Password
        Given the user is on the password reset page
        When the user enters username "Admin" on the password reset page
        And the user clicks the Reset Password Button
        Then a Password Reset Request is sent

    @regression @positive
    Scenario: Cancelling Password Reset
        Given the user is on the password reset page
        When the user clicks the cancel button on the password reset page
        Then the user is sent to the Login Page