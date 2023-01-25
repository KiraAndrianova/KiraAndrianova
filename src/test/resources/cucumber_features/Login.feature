Feature: As a user I want to login

  Scenario: User logs in
    Given I open JDI GitHub site
    When I login as user "Roman Iovlev"
    Then I see page title as "Home Page"
    And user name is "ROMAN IOVLEV"

  Scenario: Verify selected checkboxes on Different Elements page
    Given I am on Different Elements page
    When I select values "Water", "Wind", "Selen", "Yellow"
    Then I see appropriate log record for "Water: condition changed to true", "Wind: condition changed to true", " metal: value changed to Selen", "Colors: value changed to Yellow"

  Scenario: User Table Page test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    Then "User Table" page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 Usernames should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description             |
    And droplist should contain values in column Type for user Roman
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |

  Scenario: User Table Page test with selected checkbox
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section
