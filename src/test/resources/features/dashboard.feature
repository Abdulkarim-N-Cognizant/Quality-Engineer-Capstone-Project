@login
@dashboard
Feature: Dashboard Navigation

  Background:
    Given the user is on the login page
    When the user enters username "Admin" on the login page
    And the user enters password "admin123" on the login page
    And the user clicks the login button
    Then the dashboard should be displayed

  @smoke @regression
  Scenario Outline: Verify dashboard quick launch navigation
    When the user clicks "<dashboardOption>" on the dashboard
    Then the user should be redirected to "<dashboardOption>"

    Examples:
      | dashboardOption |
      | ASSIGN_LEAVE    |
      | LEAVE_LIST      |
      | TIMESHEET       |
      | APPLY_LEAVE     |
      | MY_LEAVE        |
      | MY_TIMESHEET    |