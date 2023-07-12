Feature: Register Functionality
User should be able to Register to application of the account

Scenario: User should be able to register with mandatory fields

Given User is navigated to the Regsitration page
When User enters the details below in the filed
|firstname|Admin                |
|lastname |Manager              |
|phone    |1234567890           | 
|password |123456               |
And User should click on Terms and Conditions check-box option
And User should click on Continue button
Then User should be successfully registered in the account


Scenario: User should register with all fields

Given User is navigated to the Regsitration page
When User enters the details below in the filed
|firstname|Admin             |
|lastname |ManagerA          |
|phone    |1234567890        | 
|password |54321             |
And User should select Yes for Newsletter subscription
And User should click on Terms and Conditions check-box option
And User should click on Continue button
Then User should be successfully registered in the account


Scenario: User should regsiter without providing mandatory fields

Given User is navigated to the Regsitration page
When User do not enters any details
And User should click on Continue button
Then User should be displayed with Warning messages


Scenario: User should register with existing email address

Given User is navigated to the Regsitration page
When User enters the details below in the filed with duplicate email
|firstname |Admin                |
|lastname  |Manager21            |
|email     |admin@123.gmail.com  | 
|phone     |123456               |  
|password  |12345                |
And User should select Yes for Newsletter subscription
And User should click on Terms and Conditions check-box option
And User should click on Continue button
Then User should be displayed with warning message saying email is already registered









