Feature: HTTP status codes of links
    As a QA engineer
    I want to check the HTTP status returned by the links on the page
    So that broken links can be identified

    # The status of a link is checked with a HEAD request
    # Links answering with 4xx or 5xx are treated as broken.

    Background:
        Given the user is on the status codes page

    Scenario Outline: Each link returns the HTTP status same as its name
        Then the "<link>" link should return HTTP status <status>

        Examples:
            | link | status |
            | 200  | 200    |
            | 301  | 301    |
            | 404  | 404    |
            | 500  | 500    |

    Scenario: A client error link is reported as broken
        Then the "404" link should be reported as broken

    Scenario: A server error link is reported as broken
        Then the "500" link should be reported as broken

    Scenario: A successful link is not reported as broken
        Then the "200" link should not be reported as broken

    Scenario Outline: Following a link opens the page for that status code
        When the user clicks the "<link>" status code link
        Then the page should state that it returned status "<link>"

        Examples:
            | link |
            | 200  |
            | 301  |
            | 404  |
            | 500  |
