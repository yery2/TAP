# TAP Java Exam 1st Call (27/10/2025)

This folder contains the TAP Java Exam.

This `README` provides the assignment description, while the `src` folder and its subfolders define the project’s file structure.
Additional files required for some exercises may also be included in the `src` folder.

- **Exercises**:
The exam includes three exercises, each consisting of multiple tasks.
The code for each exercise will be contained at , in addition to the required code and files, include a `Main` file that demonstrates the completion of each task.
- **Evaluation**:
Each exercise will be graded independently.
Whenever possible, each task within an exercise will be evaluated separately.
- **Submission instructions**:
To submit your work, compress the entire folder into a ZIP file named using the following convention:
`[Surname(s)]_[Name].zip` (e.g., `JSimpson_Homer.zip`).
    
    *Note*: Do not include the TAP repository itself in your submission. If you need to use any code from that repository, copy only the necessary files into the appropriate folder.
    

## Exercise 1 — Functional Java `(src/exam/ex1)`

For this exercise, we will use a dataset similar to the public GitHub events available from the GitHub Archive. A subset with 200 events is provided in `github-events.json`.

Each event follows this structure:

| Field | Description |
| --- | --- |
| **id** | Unique event ID |
| **type** | Event type (PushEvent, IssuesEvent, WatchEvent, etc.) |
| **repo** | Repository name |
| **actor** | User who triggered the event |
| **timestamp** | ISO-8601 timestamp |
| **commits** | Number of commits (only for PushEvent) |

Load the `github-events.json` file into a github event objects. For this action, you only need to use the `loadFromDataset` method.

### Tasks

1. Sort the list of github events by timestamp (*ascendent order*).
2. Implement a filtering method that uses a `Predicate<GitHubEvent>`:
    
    ```java
    List<GitHubEvent> filterEvents(List<GitHubEvent> events, Predicate<GitHubEvent> condition);
    ```
    
    Using this filter method, implement:
    
    - `filterByType`: returns all events of a specific type (e.g., `"PushEvent"`).
    - `filterByActor`: returns all events performed by a specific actor (e.g., `"alice"`).
3. Implement a method to group all events by type using streams.
4. Implement a method that calculates, for each repository, the average number of commits among its PushEvents. Events of other types should be ignored.

**Topics**: PREDICATE, FUNCTION, CLOSURE, STREAMS

## Exercise 2 — Design Patterns `(src/exam/ex2)`

### Tasks

In the context of repositories management, imagine a platform with different `Organization` , which can have got as children different other `Organization` or `Repository`, which are the leaf nodes in this structure. Each repository store a counter with events.

Define the Composite structure to 1) represent the tree data structure and 2) group events.

Create `getEventCount()`, an its call on an `Organization` must recursively sum the counts of all its children.
Demonstrate this is working from the `MainComposite` file.

**Topics**: OBSERVER

## Exercise 3 — Reflection `(src/exam/ex3)`

### Tasks

Create a class `MemoizationHandler` that uses **Java Dynamic Proxy** to cache (memoize) the results of method calls.

When a method is called with the same arguments as a previous invocation, the result should be retrieved from the cache instead of executing the method again.

Use the `java.lang.reflect.Proxy` and `java.lang.reflect.InvocationHandler` classes.

You have the Calculator interface, and a SlowCalculator implementation that simulates a heavy computation. Then demonstrate that the proxy correctly caches results.

**Topics**: REFLECTION → DYNAMIC PROXY
