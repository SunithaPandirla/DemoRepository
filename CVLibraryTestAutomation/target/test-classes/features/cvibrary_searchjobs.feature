@tag
Feature: Job Search

  @singleData
  Scenario: Job Search functionality to run with single data
    Given I launch cv library application
    And I enter job title as "Java"
    And I enter location as "London"
    And I select distance as "up to 15 miles"
    Then I click find jobs button 
    And I should see the search results
    
  @multipleData
  Scenario Outline: Job Search functionality to run with single data
    Given I launch cv library application
    And I enter job title as <jobTitle>
    And I enter location as <location>
    And I select distance as <distance>
    Then I click find jobs button 
    And I should see the search results

    Examples: 
      | jobTitle  | location | distance       |
      | Java 			|  London  | up to 15 miles |
      | c# 				|  Swindon | up to 25 miles |
      | python 		|  Belfast | up to 10 miles |
      
    