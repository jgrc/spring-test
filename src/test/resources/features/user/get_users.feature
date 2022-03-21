Feature: Api endpoint to recover user list

  Scenario: User list
    Given the following users:
      | id                                   | email           |
      | 00000000-0000-0000-0000-000000000001 | test@email.com  |
      | 00000000-0000-0000-0000-000000000002 | other@email.com |
    When I send GET to "/users"
    Then the response status should be "200 OK" with body:
      """
      [
        {"id":"00000000-0000-0000-0000-000000000001","email":"test@email.com"},
        {"id":"00000000-0000-0000-0000-000000000002","email":"other@email.com"}
      ]
      """
