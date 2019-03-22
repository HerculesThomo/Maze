package Iraklis.mainclasses;

import Iraklis.Exceptions.MazeExceptions;

/**
 *
 * @author herth
 */
public class Maze {

    private char[][] grid;
    private Position EndingBlock;
    private Position StartingBlock;
    private static final char BLOCK = 'X';
    private static final char START = 'S';
    private static final char END = 'T';
    private static final char OPEN = '*';

    public Maze() {
    }

    public Maze(char[][] grid) throws MazeExceptions {
        this.grid = grid;
        startingEndingPoint();
    }

    private void startingEndingPoint() throws MazeExceptions {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == START) {
                    StartingBlock = new Position(row, column);
                } else if (grid[row][column] == END) {
                    EndingBlock = new Position(row, column);
                }
            }
        }
        if (StartingBlock == null || EndingBlock == null) {
            throw new MazeExceptions("There is no starting point or ending point");
        }
    }

    private boolean withinBounds(Position position) {
        if (position.getX() >= 0 && position.getX() < grid.length) {
            if (position.getY() >= 0 && position.getY() < grid[0].length) {
                if (grid[position.getX()][position.getY()] != BLOCK) {
                    return true;
                }
            }
        }
        return false;
    }

//    Recursive Backtracker algorithm
    private boolean execute(Position position) {
        if (withinBounds(position)) {
            if (grid[position.getX()][position.getY()] == END) {
                grid[position.getX()][position.getY()] = 'E';
                return true;
            }
            if (grid[position.getX()][position.getY()] == START || grid[position.getX()][position.getY()] == OPEN) {
                grid[position.getX()][position.getY()] = '_';
                if (execute(position.left())) {
                    return true;
                }
                if (execute(position.right())) {
                    return true;
                }
                if (execute(position.forward())) {
                    return true;
                }
                if (execute(position.backwards())) {
                    return true;
                }
                grid[position.getX()][position.getY()] = 'X';
                return false;
            }
        }
        return false;
    }

    public void run() {
        System.out.println((execute(StartingBlock) ? "The maze solved" : "No avaliable path found"));
    }
}
