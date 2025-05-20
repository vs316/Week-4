
# Week 4: Advanced Java Features

Welcome to Week 4! This week we’ll cover Java’s more advanced capabilities: generics, the collections framework, functional-style programming with streams, robust exception handling, regular expressions and unit testing, plus key Java 8 enhancements.

## Table of Contents

1. [Overview](#overview)
2. [Topics Covered](#topics-covered)

   * [Day 1: Generics](#day-1-generics)
   * [Day 2: Java Collections](#day-2-java-collections)
   * [Day 3: Java Streams](#day-3-java-streams)
   * [Day 4: Exception Handling](#day-4-exception-handling)
   * [Day 5: Regular Expressions & JUnit](#day-5-regular-expressions--junit)
   * [Day 6: Java 8 Features & Functional Interfaces](#day-6-java-8-features--functional-interfaces)
3. [Prerequisites](#prerequisites)
4. [Repository Structure](#repository-structure)
5. [Getting Started](#getting-started)

---

## Overview

In Week 4, you'll master Java generics for type-safe code, dive deep into the Collections API, process data declaratively with Streams, handle errors gracefully, write powerful regular expressions, create unit tests with JUnit, and leverage Java 8’s functional interfaces and lambda expressions. These skills will elevate your code’s robustness and readability.

## Topics Covered

### Day 1: Generics

* Generic classes and methods
* Bounded type parameters (`extends`, `super`)
* Wildcards and variance

### Day 2: Java Collections

* List, Set, Map, and Queue interfaces
* Choosing appropriate implementations (`ArrayList` vs. `LinkedList`, `HashSet` vs. `TreeSet`, etc.)
* Iteration and bulk operations

### Day 3: Java Streams

* Creating streams from collections and arrays
* Intermediate operations (`map`, `filter`, `sorted`)
* Terminal operations (`collect`, `forEach`, `reduce`)

### Day 4: Exception Handling

* Checked vs. unchecked exceptions
* Custom exception classes
* Best practices with `try`/`catch`/`finally` and try‑with‑resources

### Day 5: Regular Expressions & JUnit

* Building and applying regex patterns with `java.util.regex`
* Writing unit tests using JUnit 5 annotations (`@Test`, `@BeforeEach`, etc.)
* Assertions and test organization

### Day 6: Java 8 Features & Functional Interfaces

* Lambda expressions and method references
* Built‑in functional interfaces (`Function`, `Consumer`, `Predicate`, `Supplier`)
* Default and static methods in interfaces

## Prerequisites

* Java Development Kit (JDK 8 or later)
* Completed Weeks 1–3
* An IDE or code editor with JUnit support

## Repository Structure

```
week-4-advanced-java-features/
├── Day1(Java Generics)/
│   └── L1/
│       └── GenericsDemo.java
├── Day2(JavaCollections)/
│   └── L1/
│       └── CollectionsDemo.java
├── Day3(JavaStreams)/
│   └── L1/
│       └── StreamsDemo.java
├── Day4(ExceptionHandling)/
│   └── L1/
│       └── ExceptionHandlingDemo.java
├── Day5(RegexAndJUnit)/
│   └── L1/
│       └── RegexAndJUnitDemo.java
└── Day6(Java8FeaturesAndFunctionalInterfaces)/
    └── L1/
        └── Java8FeaturesDemo.java
```

## Getting Started

1. **Clone this repo**

   ```bash
   git clone https://github.com/yourusername/week-4-advanced-java-features.git
   cd week-4-advanced-java-features
   ```
2. **Compile & Run an example**

   ```bash
   javac Day1(Java Generics)/L1/GenericsDemo.java
   java -cp Day1(Java Generics)/L1 GenericsDemo
   ```
3. **Dive In:** Browse each `L1` folder, run the examples, and modify them to experiment with advanced Java features.


