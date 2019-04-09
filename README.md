Classes model for:

Entities, Interactions 

Used 
Value Objects,
Entities,
Aggregates

Design patterns
Strategy - because the test types can add new behavior to the Calculator Operation, it works as a family of algorithms

Factory Method - to decide what object will perform the operation (it is a creational)

Abstract factory - because there are many different operations with test type, a huge family of objects tend to be created (microbiology can have different behavior for operation1, operation2, operation3...), it is responsible for getting the right strategy behavior

SOLID
Single responsibility,
Open Closed,
Dependency Inversion


Structure 

Hexagonal architecture(uses domain and if we add infrastructure and controller layer we have our thin layers). 

The system set the domain by bounded contexts and share the domain object, but bearing in mind that the objects eventually could not be the same (ex: TestType for Order can be different for TestOperation domain), and some future domain model refactoring is not discarded.

High level refactoring strategy

BE CLOSE TO BUSINESS ANALYSTS/POS/ARCHITECTS who understands the system

Agile involved before, during and after (extreme programming, scrum/scrumban/kanban, what fits better), devops culture

Before 

1. understand the system
2. who is coupled to it? 
3. Have a picture of the system, write it down (UML, CRC)
4. how plug the current legacy system to the new one and start shutting down the old one?

During
1. Acceptance test (black and white box)
2. Unit test
3. Continuous integration

After
1. Acceptance test (black and white box)
2. Unit Test
3. continuous integration

Refactoring Strategy

Before, during and after: TDD through out the refactoring, without exception (even when the code
is still procedural, fail pass refactor cycle, included for black box acceptance test

Before

1. Are there well defined APIs? If the answer is yes, why not start from the APIs the refactoring?

   1.1  Test from the API, testing the features by using BDD (close to the business analyst, to the PO or whoever has the business understanding) - already works as accepetance test

   1.2 After ensuring the output after inputting data, we can start refactoring by following refactoring patterns, extracting variables, names, classes, start writing CRC(Class Responsibility Collaborator down to understand what classes do and know)

2. the old api is not equals to the new (and is coupled to the clients)

   2.1 be close to people that understand the system (business, po, developers, or whoevent who understands the domain), Write CRC to understand the classes (what they do and know)

   2.2 Continue using the current input objects and convert them into new objects creating some "adapter"(not for interface, but object) or anti corruption layer(if micro services is the new player)

   2.3 Shutdown the old system step by step, while developing the services (the well defined service contratcs)

   2.4 Acceptance test for java apis

3. Is the system entirely new?

   3.1 be close to people that understand the system (business, po, developers, or whoevent who understands the domain), Write CRC to understand the classes (what they do and know)

   3.2 is API Coupled to the old system and its client? Anti corruption layer to send the right object to the new system without changing the api, without deprecating it for the moment

   3.3 Acceptance test for java apis

During

The steps follow TDD principles

1. Starting from acceptance test (with well defined user stories and therefore, given/when/then for all the cases) - it takes us to have good apis and become easy to be tested
2. Unit test (fail pass refactor)

After
1. Refactor what brings value, not only because you just like refactoring, but on what you are working on.
2. be deveops since the system conception and after

Assumption

Repository was not required at this moment, there is only its own interface (for order) to be unit tested when testing the order service

It is possible to orchestrate the two "subsystem(order/testoperations)" with a facade or even using an Application Layer, if we follow DDD, in case of needing a coordenation and getting order from some specific user and carrying out the tests. 

The package is broken in a manner that turns out to be easy to create microservices, if required, and a gateway (would create a regular object) could orchestrate external systems to some internal use (order and test operation).

TestOperationCalculatorFactory is called only on tests, but it is part of application/facade in order to inject into the TestOperationService the type of calculator by using a factory and has been created in order to test the creation of TestOperationCalculator object


FURTHER INFORMATION

I did not test the abstract factory and not even the strategy, the idea here was to show how I would
design... but even though I created unit test for some components(one factory, order service, test operation service) following TDD, in order to show how I decouple the objects and test them.

As we should not extend a lot the design, I miss creating more components to be able to test many
of the command operations through acceptance test, as command operations does not return any thing, some acceptance test could verify the whole feature by accessing query methods




