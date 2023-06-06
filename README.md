# EasyBotTest

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine.
2. Make sure you have JDK and Maven installed on your system.
3. Create database H2 with parameters:
  - Driver class: org.h2.Driver
  - JDBC URL: jdbc:h2:mem:test
  - login: marina
  - password: 28052000
4. Assign Data Source in your IDE.
5. Navigate to the project root directory and run `mvn clean install` to build the project.
6. Run the application using `mvn spring-boot:run` or by executing the main class `com.example.easybottest.EasyBotTestApplication` in your IDE.
7. Access the application on `http://localhost:8080/`.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a branch with a descriptive name that represents the changes you want to make.
3. Commit your changes to the branch and push them to your fork.
4. Open a pull request to merge your changes into the main repository.
