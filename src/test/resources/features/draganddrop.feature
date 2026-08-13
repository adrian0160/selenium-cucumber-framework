Feature: Drag and drop columns
    As a user
    I want to drag one column onto another
    So that their contents are swapped

    # The columns are referred to by position (left / right)
    # The column contain A and B

    Background:
        Given the user is on the drag and drop page

    Scenario: Drag A to B
        When the user drags the left column onto the right column
        Then the left column should contain "B" and the right column should contain "A"

    Scenario: Drag B to A
            When the user drags the right column onto the left column
            Then the left column should contain "B" and the right column should contain "A"

    Scenario: Drag A to B twice
        When the user drags the left column onto the right column
        And the user drags the right column onto the left column
        Then the left column should contain "A" and the right column should contain "B"

    Scenario: Drag A to itself
        When the user drags the left column onto itself
        Then the left column should contain "A" and the right column should contain "B"

    Scenario: A to B and B to A
            When the user drags the left column onto the right column
            And the user drags the left column onto the right column
            Then the left column should contain "A" and the right column should contain "B"