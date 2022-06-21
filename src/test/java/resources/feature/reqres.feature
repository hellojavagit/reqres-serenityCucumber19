Feature: Verify API automation on reqres website

  @SMOKE
  Scenario: To verify Rest service - GET method
    When I submit the GET request at list endpoint
    Then I should get response 200 success status code

  @SMOKE
  Scenario: To verify Rest service for single user

    When I submit the get request for single user at Single user endpoint by sending "userId"
    Then I should get response 200 success status code

  @SMOKE
  Scenario: To verify Rest service for create user endpoint
    Given I want to execute createSingleUser endpoint on reqres website
    When I submit the POST request  for create single user with name and job
    Then I should get 201 success  status code along with response body

  @SMOKE
  Scenario: To verify Rest service for update user endpoint
    Given I want to execute update User  endpoint
    When I submit the put request for  to update  user
    Then I should get 200 success status  code along with updated response body


  @SMOKE
  Scenario: To verify Rest service for delete user endpoint
    Given I want to execute delete User  endpoint
    When I submit the delete request for  to delete  user
    Then I should get 200 success status  code along with updated response body

  @SMOKE
  Scenario: To verify Rest service for login endpoint
    Given I want to execute login User  endpoint
    When I submit the POST request for login
    Then I should get 200 success status
