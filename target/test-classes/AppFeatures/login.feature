Feature: Login Page feature

Scenario: Login Page Title
Given User is on Login Page
When User gets the title of the page
Then Page Title should be "Login - My Store"

Scenario: Forgot Password Link
Given User is on Login Page
Then Forgot Password link should be displayed

Scenario: Login with correct credentials
Given User is on Login Page
When User enters username "affaqhyder@gmail.com"
And User enters password "Test123"
And User clicks on login button
Then User gets the title of the page
And Page Title should be "My Account - My Store"