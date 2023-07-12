Feature: Login Functionality
User should be able to login to application of the account

Scenario Outline: User should be able to login with valid credentials
Given User is navigated to the login page
When User enters valid email address <username>
And User enters valid password <password>
And User clicks on login button
Then User should be successfully logged in

Examples:
|username              |password|
|amotooricap1@gmail.com|12345   |
|amotooricap2@gmail.com|12345   |
|amotooricap3@gmail.com|12345   |

Scenario: User should login with invalid credentials
Given User is navigated to the login page
When User enters invalid email address 
And User enters invalid password "6543121"
And User clicks on login button
Then User should not be able to log in 
And User should receive warning message


Scenario: User should login with valid email and invalid password
Given User is navigated to the login page
When User enters valid email address "admin@123.gmail.com"
And User enters invalid password "6543121"
And User clicks on login button
Then User should not be able to log in 
And User should receive warning message


Scenario: User should login with invalid email and valid password
Given User is navigated to the login page
When User enters invalid email address
And User enters invalid password "12345"
And User clicks on login button
Then User should not be able to log in 
And User should receive warning message


Scenario: User should login without any credentials
Given User is navigated to the login page
When User do not enter any credentials
And User clicks on login button
Then User should not be able to log in 
And User should receive warning message