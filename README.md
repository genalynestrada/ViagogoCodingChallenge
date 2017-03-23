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

## Notes and Assumptions Made
- The current searching algorithm does not have a very good time complextiy. I would have liked to look into better algorithms for searching through nearest events in the world. On such a small world size, the difference is miniscule but as the wolrd size grows it would be quite apparent. Due to time constraints, I unfortunately could not do this. 
- I assumed that the user's main goal is to print the values instead of manipulate the data therefore in the main method, the user is only given strings to print out. However there are getters and setters within all classes to allow for data manipulation.
- I assumed that multiple events within a location could be a possible feature so I have added it into the system, however generateRandomData function does not create multiple events. 

## Usage

### Clone and Build

    git clone git@github.com:genalynestrada/ViagogoCodingChallenge.git
    mvn clean package    

Make sure you are within ViagogoCodingChallenge before running the mvn command.

### Execute

    java -jar target/ClosestEvents-1.0-SNAPSHOT.jar

