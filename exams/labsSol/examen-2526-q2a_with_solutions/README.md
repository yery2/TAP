# TAP Java Exam 2nd Call (05/02/2026)
This `README` provides the assignment description for the exam, while the `src` folder and its subfolders define the project’s file structure. Additional files required for some exercises may also be included in the `src` folder.

* **Exercises**:
  The exam includes three exercises, each consisting of multiple tasks. 
  The code for each exercise will be contained at `src/ex[Number]`. The folder should include, at least, a `Main` file that demonstrates the completion of each task.

* **Evaluation**:
  Each exercise will be graded independently.
  Whenever possible, each task within an exercise will be evaluated separately.

* **Submission instructions**:
  To submit your work, compress the entire folder into a ZIP file named using the following convention:
  `[Surname(s)]_[Name].zip` (e.g., `JSimpson_Homer.zip`).  
  *Note*: Do not include the TAP repository itself in your submission. If you need to use any code from that repository, copy only the necessary files into the appropriate folder.

---

## Exercise 1 — Functional Java `(src/ex1)`

### Dataset
This exercise employs a subset of the [Mountains](https://github.com/APonce73/Mountains) dataset, contained in the `mountains.csv` file.

The data is stored in CSV format, where each row corresponds to a mountain with the following fields:
| Field         | Description                                      |
| ------------- |--------------------------------------------------|
| **Name**      | Unique name (string)                             |
| **Height**    | Height in meters (integer)                       |
| **Country**   | Name of the country containing it (string)       |
| **Continent** | Name of the continent containing it (string)     |

The `Mountain` class, along with the method responsible for loading the dataset (i.e., `loadDataset`), are provided.

### Tasks
1. Sort the list of mountains by `height` (*descending order*).
2. Implement a `filter` method using a `Predicate<Mountain>` and streams:
    ```java
    List<Mountain> filter(List<Mountain> mountain, Predicate<Mountain> condition);
    ```
   Using this method, implement a new one named `filterByHeight` that returns the mountains over a certain height.
3. Implement a method to group all mountains by continent using streams.
4. Implement a method that calculates the **average height** for mountains in a specific country.

**Topics**: PREDICATE, FUNCTION, STREAMS, COLLECTORS

---

## Exercise 2 — Design Patterns `(src/ex2)`

### Tasks
We aim to create a simple trip system that calculates travel duration based on distance and movement method. As starting point, we provide the `Trip` class, which considers the trip distance in kilometers, and an empty `MovementStrategy` interface.

1. Implement the **Strategy pattern** to allow duration calculation based on the movement strategy. Modify/expand the provided code.
2. Develop the following strategies, each with a unique way of computing trip duration:
- `WalkStrategy`: 12 minutes per kilometer.
- `CarStrategy`: 1 minute per kilometer + 5 minutes for parking.
- `BusStrategy`: 1 minute per kilometer + 2 minutes every 5 kilometers (bus stop). *Note*: If the distance is a multiple of 5, considering or not the last stop is completely optional.
3. Demostrate each strategy working for different trips in `Main`.

**Topics**: STRATEGY PATTERN

---

## Exercise 3 — Reflection `(src/ex3)`

### Tasks
Create a class called `NoSettersHandler` that uses **Java Dynamic Proxy** to skip setter method invocations. The proxy checks each method’s name when it’s called. If the name starts with `"set"`, the proxy skips the method and prints a message like "Setter [methodName] canceled". For any other method, the proxy invokes it normally, without any message.

Demonstrate this functionality using the provided `ProductInterface` interface and `Product` class. In the `Main` class, show how getters and setters work for both a regular product and one wrapped in the proxy.

**Topics**: REFLECTION → DYNAMIC PROXY
