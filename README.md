# OOAD Summer 21 Project 3 
Alex Mazur and Ryan Oliva


## Assumptions
This project was developed in IntelliJ. There are files in this directory that are relevant only to IntelliJ.

The main method initializes the simulation and triggers the work in the simulation each "day". It collects a number of days from the user, adds vehicles to the garage, and then loops for how many days the user entered.

## How to compile and run
This section is assuming you are on a CLI with a JDK installed.
1. Navigate to the `src` directory
2. To compile type `javac Project3.java`
3. To run type `java Project3` 

## Project Structure
All of our code is located under the `src` directory. The program entry point, or main method, is located directly under `src` and is called `Project3.java`. 

`src` contains the following sub-directories and files:
- `Vehicles`: This directory contains all java classes related to vehicles, it also contains the VehicleFactory class, VehicleType enum, and CrashStrategies.
- `Garage`: This directory contains the Garage class. It manages the "day to day" happenings of a garage. The class contains many vehicles, one mechanic, one GarageAnnoucer, and one GarageClock. This directory also contains a class called `HiringPool` that fetches a name for a new mechanic.
- `Employees`: Contains the Mechanic class, GarageEmployee class, and GarageAnnouncer class.
- `util`: Contains a class called LicensePlate. This is a static class that the VehicleFactory uses to generate license plates that are guaranteed to be program-wide unique.
- `Project3.java`: Program entry point.
- `garage_actions.out`: Program output after running the simulation for 10 days.

## UML
Below is a picture of our UML diagrams for our project. You can find a pdf of this in the root directory of this repo.
![UML diagram](https://github.com/bouldercoder9/OOADProject3/blob/main/Project3_UML.png)
