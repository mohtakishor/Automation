This testing framework is designed using the Page Object Model (POM) combined with Page Factory. This approach enhances the maintainability and readability of the test scripts, promoting a clear separation of concerns between test logic and UI interactions.

Key Features
Page Object Model (POM):
Each page of the application is represented by a separate class. This encapsulates the elements and methods related to that page, allowing for easier updates and reuse across tests.
Page Factory:
Utilizes Selenium's Page Factory to initialize web elements in a more efficient manner. This allows for lazy loading of elements, which can improve performance and reduce memory usage.
Tech Stack Used :- 
Java – Programming language
Selenium WebDriver – For UI automation
TestNG – Test management and execution framework
Maven – Dependency management and build tool
Rest-Assured – For API testing
Extent Reports – For reporting

Structure :-

/src
├── main
│    └── java
│         └── Utils
│              └── BaseTest.java
│         └── modules
│              └── HomePage.java
└── test
└── java
└── HomePageTest
└── HomePageTest.java

/pom.xml             # Maven dependencies
/target              # Reports and build outputs

To run the UI tests, use the following Maven command: -

mvn test -Dtest=HomePageTest

To run the API tests, use the following Maven command: -

mvn test -Dtest=ApiTestClassName

You can also execute all tests in the suite:

mvn clean test