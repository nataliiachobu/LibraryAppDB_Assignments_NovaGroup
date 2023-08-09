#Adding my initials to differentiate from other US
@AndrewBalint @db
Feature: As a data consumer, I want to know genre of books are being borrowed the most

  Scenario: verify the the common book genre that’s being borrowed AB
    Given Establish the database connection AB
    When I execute query to find most popular book genre AB
    Then verify "Fantasy" is the most popular book genre. AB