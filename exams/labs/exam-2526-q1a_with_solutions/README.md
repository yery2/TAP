# TAP Java Exam 1st Call (27/10/2025)
This folder contains the TAP Java Exam.  
This `README` provides the assignment description, while the `src` folder and its subfolders define the project’s file structure.
Additional files required for some exercises may also be included in the `src` folder.

* **Exercises**:
  The exam includes three exercises, each consisting of multiple tasks. 
  The code for each exercise will be contained at , in addition to the required code and files, include a `Main` file that demonstrates the completion of each task.

* **Evaluation**:
  Each exercise will be graded independently.
  Whenever possible, each task within an exercise will be evaluated separately.

* **Submission instructions**:
  To submit your work, compress the entire folder into a ZIP file named using the following convention:
  `[Surname(s)]_[Name].zip` (e.g., `JSimpson_Homer.zip`).  
  *Note*: Do not include the TAP repository itself in your submission. If you need to use any code from that repository, copy only the necessary files into the appropriate folder.

---

## Background for exercises 1 and 2
We obtained data from *URVoltage Racing*, a team competing in the *MotoStudent* international motorbike competition. 
This dataset contains measurements recorded by various sensors (e.g., temperature, current, etc.) during the first driving test of the 2025 bike prototype.
The data is stored in CSV format, where each row represents a message with the following attributes:
1. **Timestamp**: The exact time when the measurement was received.  
   *Do not* convert this value into a date object; it can remain as a string.
2. **Sensor name**: A short string identifying the measurement.
3. **Sensor value**: The numerical value measured by the sensor.

The `Measurement` class, along with the method responsible for loading the `measurements.csv` file into a list of `Measurement` objects, is already provided within the `utils` package.
The `Main` class for Exercise 1 already calls this method to load the measurements.

---

## Exercise 1: Functional Java

Using the list of measurements, in `src/ex1/Main`:
1. Sort the list by timestamp.
2. Create a `query` method that returns a list of measurements matching a condition provided as a parameter.
   Then, implement a `queryBySensorName` method, that internally calls `query` for returning measurements for a specific *sensor name*.
   For example, get all measurements for *Inv_RPM*.
3. Create a `sensorValuesOverThreshold` method that returns the values from a specific sensor that are greater than a given threshold.  
   For instance, values of *Inv_Current_Battery* greater than 110.
   **Return only the values, not the measurements.**
   *Do not* use any of the previously defined methods for this one.
4. Create a `measuresBySensorName` method that returns a data structure grouping measurements by *sensor name*.
   In other words, all measurements corresponding to *Inv_RPM* should be grouped together, all measurements for *Inv_Current_Battery* should be placed in a separate group, and so on.

**Topics**: PREDICATE, FUNCTION, CLOSURE, STREAMS

---

## Exercise 2: Design Patterns

The goal is to simulate a simplified version of the *receive an display* system integrated into the motorbike.
In `src/ex2`:
1. Create a `Receiver` class that reads the `measurements.csv` file line by line, thereby simulating the reception of messages from a communication bus. 
   That is, each measurement read from the file is assumed to be received from the bus.
   The code in `utils/Utils` can be used as a template.
   Then, implement an *Observer* pattern into the `Receiver` class, so that observers are notified of each received measurement.
   Create a `Display` class, registered as an observer, that prints each measurement to the console.

**Topics**: OBSERVER

---

## Exercise 3: Reflection
We want to track how many times each method of an instance from an unknown class is called.  

In `src/ex3`:
1. Create a `MethodInvocationCountProxy` class that serves as a *Dynamic Proxy* responsible for maintaining a *map* that records the number of invocations for each method.  
   In addition, upon every method invocation, the proxy must display the current contents of the *map*. Each printed line should begin with the `\t` character to clearly distinguish these outputs from the standard behavior prints.  
   For testing purposes, the files from `TAP3/solutions/filesystem` have been copied into the `src/ex3Solution` directory (with minor modifications).  
   Implement and utilize the `MethodInvocationCountProxy` within `src/ex3Solution/Main` for two arbitrary instances of `AComponent` (for example, *f1* and *f4*).

**Topics**: REFLECTION → DYNAMIC PROXY