Feature: Login

Scenario: Successful login with valid credential
Given User launch chrome browser
When User open  URL "https://admin-demo.nopcommerce.com/login"
And User enter email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then Page title should be "Dashboard / nopCommerce administration"
When User click on Logout link
Then Page title should be "Your store. Login"
And Close browser

@Sanity
Scenario Outline: Successful login with valid credential
Given User launch chrome browser
When User open  URL "https://admin-demo.nopcommerce.com/login"
And User enter email as "<email>" and password as "<password>"
And Click on Login
Then Page title should be "Dashboard / nopCommerce administration"
When User click on Logout link
Then Page title should be "Your store. Login"
And Close browser

Examples:
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|admin|
