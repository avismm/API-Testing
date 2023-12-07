Feature: syntax api testing

  Background:
    Given a JWT is generated

  @test
  Scenario: create an employee and verify that the employee is created
    Given a request is prepared to create an Employee
    When a POST call is made to the endpoint
    Then the status code is 201
    And the employee id "Employee.employee_id" is stored as a global variable
    And we verify that the value for key "Message" is "Employee Created"