Feature: Horizontal slider
    As a user
    I want to move the slider
    So that the displayed value changes

    # Test design technique: Boundary Value Analysis (BVA)
    # The slider accepts values from 0 to 5 in steps of 0.5, so the boundaries
    # under test are the minimum (0), the maximum (5) and the values just inside
    # and just outside them.

    Background:
        Given the user is on the horizontal slider page

    Scenario: The slider starts at its minimum value
        Then the slider value should be "0"

    Scenario Outline: Moving the slider to values inside the allowed range
        When the user moves the slider <steps> steps to the right
        Then the slider value should be "<value>"

        Examples: Boundaries and values next to them
            | steps | value |
            | 1     | 0.5   |
            | 9     | 4.5   |
            | 10    | 5     |

    Scenario: The slider does not go above its maximum value
        When the user moves the slider 13 steps to the right
        Then the slider value should be "5"

    Scenario: The slider does not go below its minimum value
        When the user moves the slider 3 steps to the left
        Then the slider value should be "0"

    Scenario: Extra check on going left
            When the user moves the slider 10 steps to the right
            When the user moves the slider 3 steps to the left
            Then the slider value should be "3.5"