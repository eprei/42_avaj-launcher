# Avaj-Launcher 🛩️

![Java](https://img.shields.io/badge/Java-21-blue)
![Status](https://img.shields.io/badge/Status-Completed-success)

A Java-based aircraft simulation program implementing the Observer and Singleton design patterns. This project serves as an introduction to Java development at 42 school, focusing on Object-Oriented Programming principles and UML class diagram implementation.

## Overview

The Avaj-Launcher simulates aircraft behavior under different weather conditions at Frankfurt airport. The program reads scenario files containing aircraft specifications and simulates their behavior based on weather changes, implementing various design patterns and following a strict UML class structure.

## Features

- Weather-based aircraft behavior simulation
- Implementation of Observer, Singleton, and Factory design patterns
- Custom exception handling
- Scenario file parsing
- Weather generation system
- Aircraft registration/unregistration system
- Logging system with file output

## Project Structure

```
├── airtraffic_control/     # Core aircraft and control systems
├── exceptions/             # Custom exception handling
├── log/                    # Logging functionality
├── simulator/              # Main simulation logic
└── weather/               # Weather generation system
```

## Requirements

- Java 21 or higher
- No external libraries or build tools
- Clean code structure following Java naming conventions

## Building and Running

1. Compile the project:
```bash
find * -name "*.java" > sources.txt
javac @sources.txt
```

2. Run the simulation:
```bash
java simulator.Simulator scenario.txt
```

## Input File Format

The scenario file should follow this structure:
```
25              # Number of simulation cycles
TYPE NAME LONGITUDE LATITUDE HEIGHT
```

Example:
```
25
Balloon B1 2 3 20
JetPlane J1 23 44 32
Helicopter H1 654 33 20
```

## Aircraft Types and Behavior

The simulation includes three types of aircraft:
- **Helicopter**: Sensitive to all weather conditions
- **JetPlane**: Primarily affected by latitude changes
- **Balloon**: Highly sensitive to height changes

Each aircraft type responds differently to four weather conditions:
- SUN
- RAIN
- FOG
- SNOW

## Key Learning Objectives

- Object-Oriented Programming in Java
- UML class diagram implementation
- Design patterns (Observer, Singleton, Factory)
- Custom exception handling
- File I/O operations
- Clean code principles

## Implementation Details

- Custom exceptions for robust error handling
- Coordinate system with validation
- Weather generation based on coordinates
- Logging system with file output
- Factory pattern for aircraft creation
- Observer pattern for weather updates

## Output

The simulation generates a `simulation.txt` file containing detailed logs of:
- Aircraft registration/unregistration
- Weather condition changes
- Aircraft movements and status updates
- Landing events
