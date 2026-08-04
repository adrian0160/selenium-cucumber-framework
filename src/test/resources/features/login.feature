Feature: Login authentication
    As a registered user
    I want to log in with my credentials
    So that I can access the secure area

    Background:
        Given the user is on the login page

    Scenario Outline: Login with valid and invalid credential partitions
        When the user enters username "<username>" and password "<password>"
        And the user clicks the login button
        Then the displayed message should be "<result>"

        Examples: Valid and invalid partitions
            | username | password             | result                         |
            | tomsmith | SuperSecretPassword! | You logged into a secure area! |
            | tomsmith | wrongpass            | Your password is invalid!      |
            | invalid  | SuperSecretPassword! | Your username is invalid!      |
            | invalid  | wrongpass            | Your username is invalid!      |

        Examples: Empty fields (robustness / negative)
            | username | password             | result                         |
            |          | SuperSecretPassword! | Your username is invalid!      |
            | tomsmith |                      | Your password is invalid!      |
