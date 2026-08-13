Feature: JavaScript alerts handling
    As a user
    I want to interact with JavaScript dialogs (alert, confirm, prompt)
    So that the application reacts correctly to my choices

    # Test design: coverage per dialog type (alert / confirm / prompt)

    Background:
        Given the user is on the JavaScript alerts page

    Scenario: Accept a JS alert
        When the user triggers the JS alert
        And the user accepts the dialog
        Then the result should be "You successfully clicked an alert"

    Scenario: Accept a JS confirm
        When the user triggers the JS confirm
        And the user accepts the dialog
        Then the result should be "You clicked: Ok"

    Scenario: Dismiss a JS confirm
        When the user triggers the JS confirm
        And the user dismisses the dialog
        Then the result should be "You clicked: Cancel"

    Scenario: Enter text in a JS prompt and accept
        When the user triggers the JS prompt
        And the user enters "Hello QA" in the prompt and accepts
        Then the result should be "You entered: Hello QA"

    Scenario: Enter empty text in a JS prompt and accept
        When the user triggers the JS prompt
        And the user enters "" in the prompt and accepts
        Then the result should be "You entered:"

    Scenario: Dismiss a JS prompt
        When the user triggers the JS prompt
        And the user dismisses the dialog
        Then the result should be "You entered: null"
