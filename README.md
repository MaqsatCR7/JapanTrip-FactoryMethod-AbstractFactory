# Japan Trip Booking System Assignment 2

**Course:** Software Design Patterns  
**Type:** Individual Assignment  
**Domain:** Japan Tourism, Transport & Hotel Booking System  
**Implemented Patterns:** Factory Method & Abstract Factory  

---

##  Project Overview

This project demonstrates the practical implementation of two creational design patterns: **Factory Method** and **Abstract Factory**, applied to a Japan Trip Booking domain.

- **Part A (Factory Method):** Manages the dynamic creation of individual tour transportation objects (e.g., Shinkansen Bullet Train, Kyoto Tour Bus) without coupling the client code to concrete transport classes.
- **Part B (Abstract Factory):** Manages the consistent creation of related product families (e.g., Traditional Japan Trip vs. Modern Tokyo Trip) consisting of a matched `TransportTicket` and `HotelAccommodation`.

---

##  Architecture & Design Patterns

### Part A: Factory Method
- **Product (`JapanTourTransport`):** Common interface for all tour transport options declaring `startTour()`.
- **Concrete Products (`ShinkansenTrain`, `KyotoTourBus`):** Specific implementations of tour transports.
- **Creator (`TourLogistics`):** Abstract class declaring the factory method `createTransport()`.
- **Concrete Creators (`RailTourLogistics`, `BusTourLogistics`):** Overrides the factory method to instantiate concrete transports.

### Part B: Abstract Factory
- **Abstract Products (`TransportTicket`, `HotelAccommodation`):** Interfaces declaring behavior for tickets and hotel bookings.
- **Concrete Products:**
  - *Traditional Family:* `ShinkansenPass` + `TraditionalRyokan`
  - *Modern Family:* `TokyoMetroPass` + `CapsuleHotel`
- **Abstract Factory (`JapanTripFactory`):** Declares creation methods for each product type in the trip family (`createTransportTicket()`, `createAccommodation()`).
- **Concrete Factories (`TraditionalJapanTripFactory`, `ModernTokyoTripFactory`):** Produces a consistent, matching set of trip products for a specific theme.
- **Client (`JapanTripClient`):** Interacts exclusively via `JapanTripFactory` and Abstract Product interfaces.

---

##  Clean Code Principles Applied

In accordance with Section 3 of the assignment requirements, the following Clean Code principles were explicitly implemented and justified:

### 1. Meaningful & Intention-Revealing Names
- **Before:** `class T implements TT { void u() {} }`
- **After:** `class ShinkansenPass implements TransportTicket { void useTicket() {} }`
- **Justification:** Class and method names clearly reflect domain-specific concepts, making the codebase self-documenting without needing excessive comments.

### 2. Program to Interfaces, Not Implementations
- **Before:** `ShinkansenPass pass = new ShinkansenPass();`
- **After:** `TransportTicket ticket = factory.createTransportTicket();`
- **Justification:** The `JapanTripClient` relies strictly on abstract interfaces rather than concrete classes, enabling loose coupling and easy extensibility.

### 3. Validated Construction (Fail Fast)
- **Code Snippet:**
  ```java
  public JapanTripClient(JapanTripFactory factory) {
      if (factory == null) {
          throw new IllegalArgumentException("Trip factory cannot be null!");
      }
      this.ticket = factory.createTransportTicket();
      this.accommodation = factory.createAccommodation();
  }
  --
