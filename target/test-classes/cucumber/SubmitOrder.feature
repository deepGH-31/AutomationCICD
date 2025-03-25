
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

 Background:
 Given I landed on ECommerce Page
 
  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with userName <name> and Password <password>
    
    When I add product <prodName> to cart
    When Checkout<prodName> and submit the order
    
    Then "THANKYOU FOR THE ORDER." message is displayed on the ConfirmationPage
    

    Examples: 
      | name  | password | prodName  |
      | deepfw@gmail.com |     deepFW@1 | ADIDAS ORIGINAL |
     
