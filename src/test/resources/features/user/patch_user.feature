Feature: Api endpoint to update users
  Background:
    Given the following users:
      | id                                   | email           |
      | 00000000-0000-0000-0000-000000000001 | test@email.com  |

  Scenario: Update user email
    When I send PUT to "/users/00000000-0000-0000-0000-000000000001" with body:
    """
    {"email":"other@email.com"}
    """
    Then the response status should be "202 ACCEPTED"
    And the following users should exists:
      | id                                   | email           |
      | 00000000-0000-0000-0000-000000000001 | other@email.com |

  Scenario: User not found
    When I send PUT to "/users/00000000-0000-0000-0000-000000000002" with body:
    """
    {"email":"other@email.com"}
    """
    Then the response status should be "404 NOT_FOUND" with body:
    """
    {"error":"User with id '00000000-0000-0000-0000-000000000002' not found."}
    """