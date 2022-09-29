Feature: Account Page Feature

Background:
Given user has already logged into application
|username|password|
|sep292022@gmail.com|Dummy@12345|

Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

@Regression @Skip
Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And Accounts section count should be 6
