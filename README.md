This framework provides automated test coverage for the UI and API functionalities of the LivelyRoot e-commerce website, where users can explore and purchase plants. It includes Selenium-based UI tests and API tests using Rest-Assured, with test execution reports generated through Extent Reports.

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