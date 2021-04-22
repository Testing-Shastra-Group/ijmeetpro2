Feature: User Sign Up in Ijmeet site

Scenario Outline: Create a new user
Given I've a valid set of data and access to sign up page
When Sign Up page Displayed
Then user enters "<Full Name>","<Company Name>","<Email Id>","<Mobile Number>","<Password>" on sign up page
Then user clicks sign up button
Examples:
|Full Name    |Company Name|Email Id       |Mobile Number|Password  |
|Crystal Jonas|Test        |abc11@gmail.com|8975463510   |Admin@|
