package Iraklis.View;

import Iraklis.mainclasses.Position;

/**
 *
 * @author herth
 */
public class ViewMaze {

    public ViewMaze() {
    }

    public void printStartEndPoint(Position position) {
        System.out.println(position.getX() + ", " + position.getY());
    }

    public void printMaze(char[][] grid) {
        for (char[] row : grid) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }

    }

}
