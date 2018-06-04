Feature:

  Scenario: direct search for a good article
    Given Enter search term 'Samsung'
    When Do search
    Then Multiple results shown for 'Samsung'
    And There are many good articles