# Clean Architecture Blueprint

A brief implementation of Clean Architecture in a Spring Boot project

## Table of Contents

- [Introduction](#introduction)
- [Clean Architecture](#clean-architecture)

## Introduction

The purpose of this repo is to implement clean architecture principles in a Spring Boot project. Clean architecture helps us build a structured and adaptable application by organizing our code into layers, ensuring separation of concerns and flexibility.

## Clean Architecture

### Overview

Clean architecture is a software design approach that emphasizes separation of concerns and independence of external frameworks and libraries. It divides an application into distinct layers, each with its own responsibilities and dependencies, allowing for easier maintenance, testing, and flexibility.

### Principles

1. **Separation of Concerns**: Divide your application into layers (e.g., domain, application, infrastructure) with clear responsibilities, ensuring that each layer has a single, well-defined purpose.

2. **Dependency Rule**: Dependencies should always point inward toward higher-level policies or abstractions. Inner layers should not depend on outer layers, promoting loose coupling and flexibility.

3. **Isolation of Frameworks and Libraries**: Keep external frameworks, libraries, and implementation details isolated from the core business logic of your application, allowing for easier adaptation to changes in the environment.

### Application Structure

Here's how you can organize your application structure to adhere to clean architecture principles:

```
├── application
│   ├── dto
│   └── service
├── domain
│   └── model
├── infrastructure
│   ├── config
│   ├── persistence
│   └── external
└── presentation
    └── resource
```


- **domain**: Contains the core business logic and entities of your application.
- **application**: Contains the use cases or application-specific business logic.
- **infrastructure**: Contains the implementation details and infrastructure-specific code.
- **presentation**: Contains components responsible for handling interactions with the outside world, such as REST controllers.

### Benefits

- Modular and maintainable codebase
- Better testability and flexibility
- Adaptability to changes in technology and requirements
