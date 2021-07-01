# OOAD Summer 21 Project 4 
Alex Mazur and Ryan Oliva


## Assumptions
This project was developed in IntelliJ. There are files in this directory that are relevant only to IntelliJ.

Only runs for one day and every hour the program will wait for the user to enter input on what activity they would like to do. The program will act accordingly until the end of the work day or the user chooses to close the garage.

## How to compile and run
This section is assuming you are on a CLI with a JDK installed.
1. Navigate to the `src` directory
2. To compile type `javac Project4.java`
3. To run type `java Project4` 

## Project Structure
All of our code is located under the `src` directory. The program entry point, or main method, is located directly under `src` and is called `Project4.java`. 

`src` contains the following sub-directories and files:
- `Vehicles`: This directory contains all java classes related to vehicles, it also contains the VehicleFactory class, VehicleType enum, and CrashStrategies.
- `Garage`: This directory contains the Garage class. It manages the happenings of a garage throughout the course of the day. The class contains one of each vehicle, one mechanic, and one GarageClock. 
- `Employees`: Contains the Mechanic class, GarageEmployee class, and GarageAnnouncer class.
- `util`: Contains classes called LicensePlate, Command, and User. LicensePlate is a static class that the VehicleFactory uses to generate license plates that are guaranteed to be program-wide unique. User generates and stores the user input through use of a singelton. Command is for command pattern interface.
- `Project4.java`: Program entry point.
- `garage_actions.out`: Program output after running the simulation for 10 days.
- `tests`: Contains 10 JUnit tests testing varying functionality. 
