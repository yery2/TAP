# TAP Java Exam 2nd Call (03/02/2026)

This folder contains the TAP Java Exam (Second Call).

This `README` provides the assignment description. The `src` folder contains the project skeleton.

- **Exercises**:
  The exam includes three exercises. Include a `Main` file for each exercise demonstrating the completion of the tasks.
- **Evaluation**:
  Each exercise is graded independently.
- **Submission**:
  Compress the folder into `[Surname(s)]_[Name].zip`.

## Exercise 1 — Functional Java `(src/exam/ex1)`

We will use the **NYC Taxi Trip** dataset. A subset is provided in `nyc-trips.json`.

Each trip follows this structure:

| Field | Description                                      |
| --- |--------------------------------------------------|
| **id** | Unique trip ID (int)                             |
| **vendorId** | Code indicating the TPEP provider (1 or 2) (int) |
| **pickupTime** | ISO-8601 timestamp (load as string)              |
| **passengerCount** | Number of passengers (float)                     |
| **tripDistance** | Distance in miles (float)                        |
| **totalAmount** | Total cost of the trip (float)                   |

Load the dataset using the provided `loadFromDataset` method.

### Tasks

1. Sort the list of trips by `totalAmount` (*descending order*).
2. Implement a filtering method that uses a `Predicate<TaxiTrip>`:
    ```java
    List<TaxiTrip> filterTrips(List<TaxiTrip> trips, Predicate<TaxiTrip> condition);
    ```
   Using this filter method, implement:
    - `filterByVendor`: returns trips from a specific vendor ID.
3. Implement a method to group all trips by `passengerCount` using streams.
4. Implement a method that calculates the **average total amount** for trips managed by a specific `vendorId`.

Demonstrate in `MainEx1` the functionality of each task.

**Topics**: PREDICATE, FUNCTION, STREAMS, COLLECTORS

## Exercise 2 — Design Patterns `(src/exam/ex2)`

### Tasks

In a Fleet Management System, we have different types of vehicles in a hierarchical structure: `Car`, `Bus`, and `ElectricScooter`. All of them implement a common `Vehicle` element interface.

We need to perform different operations on these vehicles without modifying their classes (Open/Closed Principle).

1. Define the **Visitor Pattern** structure to represent operations on the fleet.
2. Implement a `MaintenanceCostVisitor` that calculates the maintenance cost differently for each vehicle:
    - `Car`: $50 flat rate.
    - `Bus`: $100 + $5 per capacity seat.
    - `ElectricScooter`: $15 flat rate.
3. Demonstrate the visitor working on a list of mixed vehicles in `MainVisitor`.

**Topics**: VISITOR PATTERN

## Exercise 3 — Reflection `(src/exam/ex3)`

### Tasks

Create a class `AuditHandler` that uses **Java Dynamic Proxy** to log the execution of methods in a service.

Unlike simple memoization, this handler must act as an Auditor:
1. Print a log message *before* the method executes: `[AUDIT] Starting execution of: methodName`.
2. Execute the actual method.
3. Print a log message *after* the method executes: `[AUDIT] Finished execution of: methodName. Time taken: X ms`.

You have a `PaymentService` interface and a `StripePaymentService` implementation. Create the proxy instance and demonstrate that calls are correctly logged in the console.

**Topics**: REFLECTION → DYNAMIC PROXY
