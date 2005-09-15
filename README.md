## AMaze :sparkles:

## Description

This project is an example of the Constraint-satisfaction problem. The purpose was to find the best path of a maze while taking energy points into consideration.

My code reads in the maze from the text file and Stores it into a temp char array.

Then it takes the char array and creates a tree from the 'positions'.

Once the tree has been compiled it sends the data to the MazeSolver class which finds every path and stores the paths in a seeker class. After all unique paths have been found the energy points is determined for each path and the paths are compaired. The path with the optimal loss or gain of energy is then returned to the MazeBuilder class which then writes it to the console and the maze_out.dat file.

To run this project simply double-click the JonRohanMaze.jar file. Be shure that the `maze_in.dat` file and `maze_out.dat` file are in the same directory as the jar file.

## Problem Description:

In this constraint-satisfaction problem you are to implement the chronological backtracking algorithm to search through a maze for an optimal path from a given start position to the exit (goal) position. The start position will be somewhere on the leftmost wall and the goal position will be somewhere on the rightmost wall of the maze. You will start with a given number of energy units and you will spend least amount possible of energy units to arrive at the goal position. As you take different paths through the maze you will come across some sluggish spots where you will loose significant energy units. Similarly you will also come across spots where you will gain some energy units. Any upward move will cost you one energy unit and a downward move will cost you no energy units. Going horizontal left or right will not cost you any energy units. In the maze the spots where you will gain or loose significant energy units will be marked by symbols '$', '*', '#', and '^'. Here is the meaning of these symbols: '$' = gain of 10 energy units, '*' = gain of 5 energy units, '#' = loss of 10 energy units, '^' = loss of 5 energy units. You will determine the optimum path to the goal that satisfies the given constrains. If it is not possible to arrive at the goal given the constraints the program must say so. The input for this program will be from an input file named maze_in.dat and the output will be to a file named maze_out.dat. Make valid assumptions if necessary but make sure to state them clearly. The description of the input and output files are given below:

## Input file:

The maze will be represented in a text file by a 2-dimensional matrix of characters, with ' ' (the space character) representing open space or corridors (places that can be occupied) and '1' (the number one) representing walls (places that cannot be occupied). The first line in the input file will contain the dimensions of the maze where the first number (an integer) in the line will indicate the number of rows and the second will indicate the number of columns. Followed by the maze dimension will be another integer on the same line which will specify the starting energy unit. All the numbers in this line will be separated by space characters. The maximum size of the maze will be limited to 40x40. Following these numbers will be lines comprising '1', ' ', '$', '*', '#', or '^' characters. Here is an example input file:

```
8 16 30
1111111111111111
1      11    111
1 1111 11 11#111
1^11 1 11 11#111
1 #  1111 11
1 11 11 11^111
  11      #    1
1111111111111111
```

## Output file:

The output file will be a text file where the first line will show the number of energy units remaining to arrive at the goal. Following that line will be original maze on which you will show the optimum path to the goal using the character ‘X’. For example an output may look like the following:

```
1
1111111111111111
1      11    111
1 1111 11 11#111
1^11 1 11 11#111
1X#XX1111 11XXXX
1X11X11   11^111
XX11XXXXXX#XX  1
1111111111111111
```

If there is no solution, you should return a no-solution maze_out.dat which will contain the original maze preceded by the remaining energy units to be the same as the starting energy units.