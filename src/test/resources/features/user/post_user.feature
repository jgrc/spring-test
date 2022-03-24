Feature: Api endpoint to create users

  Scenario: Create user
    When I send POST to "/users" with body:
    """
      {
        "id" : "00000000-0000-0000-0000-000000000001",
        "email" : "test@email.com"
      }
    """
    Then the response status should be "201 CREATED"
    And the following users should exists:
      | id                                   | email          |
      | 00000000-0000-0000-0000-000000000001 | test@email.com |

  Scenario: Create user fails
    When I send POST to "/users" with body:
    """
      {
        "id" : "00000000-0000-0000-0000-000000000001",
        "email" : "not-email"
      }
    """
    Then the response status should be "400 BAD_REQUEST" with body:
    """
      {
        "error" : "Value 'not-email' is not a valid email"
      }
    """
