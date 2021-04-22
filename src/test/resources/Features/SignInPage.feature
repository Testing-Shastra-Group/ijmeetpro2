Feature: Sign in
   
  Scenario: User is successfully Sign in with valid credentials
    Given User launch browser 
    When User opens URL of IJMeet 
    And User enters Email as valid and password as valid
    And User click on sign in
    Then Page Title should be "https://ijmeet.com/dashboard"  
    When user click logout link 
    Then close browser
   