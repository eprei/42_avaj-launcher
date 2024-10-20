# Avaj Launcher

## Java Aircraft Simulation Project

This project is an introduction to the Java world at 42, focusing on Object-Oriented Programming and UML class diagrams.

### Project Overview

Implement a minimal aircraft simulation program based on a given UML class diagram. The simulation involves different types of aircraft that react to various weather conditions.

### Key Components

- UML Class Diagram implementation
- Weather generation
- Aircraft behavior simulation
- Scenario file parsing

### Requirements

- Java (compliant with latest LTS version)
- No external libraries, build tools, or code generators allowed
- Must follow Java package naming conventions

### Building the Project

Compile the project using the following commands in the root of your project folder:

```
find * -name "*.java" > sources.txt
javac @sources.txt
```

### Running the Simulation

```
java com.yourpackage.avaj.Simulator scenario.txt
```

Replace `com.yourpackage` with your actual package structure.

### Scenario File

The first line contains the number of times the simulation is run. Each subsequent line describes an aircraft in the format:

```
TYPE NAME LONGITUDE LATITUDE HEIGHT
```

### Output

The simulation generates a file named `simulation.txt` that describes the outcome of the simulation.

### Note

This project is designed to teach the basics of Java programming, UML interpretation, and object-oriented design patterns. It's not intended for real-world aircraft simulation.
