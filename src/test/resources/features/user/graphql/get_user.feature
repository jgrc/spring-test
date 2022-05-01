Feature: Api endpoint to recover user by id
  Background:
    Given the following users:
      | id                                   | email           |
      | 00000000-0000-0000-0000-000000000001 | test@email.com  |

  Scenario: Get user
    When I send POST to "/graphql" with body:
      """
      {
        "query": "query {
          user(id: \"00000000-0000-0000-0000-000000000001\") {
            id
            email
          }
        }"
      }
      """
    Then the response status should be "200 OK" with body:
      """
      {
      }
      """
