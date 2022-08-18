Feature: Accounts Page feature
  
Background:
Given User has already logged in to application
|username|password|
|affaqhyder@gmail.com|Test123|

 Scenario: Accounts Page Title
    Given User is on Accounts Page
    When User gets the title of the page
    Then Page Title should be "My Account - My Store"

Scenario: Accounts section count
    Given User is on Accounts Page
    Then user gets account section
    |Order history and details|
    |My credit slips|
    |My addresses|
    |My personal information|
    |My wishlists|
    |Home|
    And accounts section count should be 5