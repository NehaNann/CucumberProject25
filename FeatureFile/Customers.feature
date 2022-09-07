Feature: Customer

#Scenario: Add new customer
#Given User launch chrome browser
#When User open  URL "https://admin-demo.nopcommerce.com/login"
#And User enter email as "admin@yourstore.com" and password as "admin"
#And Click on Login
#Then User can view dashboard
#When User clicks on Customer Menu
#And Clicks on Customer menu item
#And Click on Add new button
#Then User can view add new customer page
#When User enter customers info
#And Click on Save button
#Then User can view confirmation message as "The new customer has been added successfully."
#And Close browser	



Scenario: Search user by email
Given User launch chrome browser
When User open  URL "https://admin-demo.nopcommerce.com/login"
And User enter email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then User can view dashboard
When User clicks on Customer Menu
And Clicks on Customer menu item
And Enter Customer email
And Click on search button
Then User should found email in search table
And Close browser
	