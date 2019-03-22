package iraklis.mazeimplementation;

import Iraklis.Exceptions.MazeExceptions;
import Iraklis.View.ViewMaze;
import Iraklis.mainclasses.Maze;
import iraklis.readfile.ReadFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author herth
 */
public class MazeImplementation {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        try {
            System.out.println("Give the name of the file");
            Scanner scan = new Scanner(System.in);
            String fileName = scan.next();
            char[][] maze = ReadFile.setFileName(fileName);
            Maze grid = new Maze(maze);
            ViewMaze view = new ViewMaze();
            view.printMaze(maze);
            grid.run();
            System.out.println();
            view.printMaze(maze);
        } catch (MazeExceptions ex) {
            System.out.println("Something is going wrong with the starting or ending point");
        } catch (FileNotFoundException ex) {
            System.out.println("This file does not exist");
        }
    }
}
