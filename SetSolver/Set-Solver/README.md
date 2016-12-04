# Set Solver
This is a Java command line implementation of a Set Solver.

##Set
Set is a real-time card game where players attempt to find sets.
A set consists of three cards which satisfy all of these conditions:
- They all have the same number, or they have three different numbers.
- They all have the same symbol, or they have three different symbols.
- They all have the same color, or they have three different colors.

In other words, if a group of three cards can be sorted to "two of __ and one of __", then the group is not a set.

##Usage
The program lets the user input three cards, and checks if the three cards belong to a set.
- If the cards satisfy the conditions as stated above, it will print "SET!".
- Otherwise, it will print "Not a set...""

## Executing the Build
You can execute the build using one of the following commands from the root of the project:

- ./gradlew -q <task> (on Unix-like platforms such as Linux and Mac OS X)
- gradlew -q <task> (on Windows using the gradlew.bat batch file)


##Task List
1. Given two cards, find a third card that will form a set
2. Given a list of cards, find all sets

