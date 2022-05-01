Feature: Api endpoint to recover user by id
  Background:
    Given the following users:
      | id                                   | email           |
      | 00000000-0000-0000-0000-000000000001 | test@email.com  |

  Scenario: Get user
    When I send GET to "/users/00000000-0000-0000-0000-000000000001"
    Then the response status should be "200 OK" with body:
      """
      {"id":"00000000-0000-0000-0000-000000000001","email":"test@email.com"}
      """

  Scenario: Get user not found
    When I send GET to "/users/00000000-0000-0000-0000-000000000002"
    Then the response status should be "404 NOT_FOUND" with body:
      """
      {"error":"User with id '00000000-0000-0000-0000-000000000002' not found."}
      """