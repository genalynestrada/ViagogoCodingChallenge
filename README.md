# ViagogoCodingChallenge
You are required to write a program which accepts a user location as a pair of co-ordinates, and returns a list of the five closest events, along with the cheapest ticket price for each event.

Scenario
- Your program should randomly generate seed data
- Your program should operate in a world that ranges from -10 to +10 (Y axis), and -10 to +10 (X axis)
- Your program should assume that each co-ordinate can hold a maximum of one event
- Each event has a unique numeric identifier (e.g. 1, 2, 3)
- Each event has zero or more tickets
- Each ticket has a non-zero price, expressed in US Dollars
- The distance between two points should be computed as the Manhattan distance

## Usage

### Clone and Build

    git clone git@github.com:genalynestrada/ViagogoCodingChallenge.git
    mvn package    

### Execute

    java -jar /target/ClosestEvents-1.0-SNAPSHOT.jar
