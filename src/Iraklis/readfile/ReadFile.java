package iraklis.readfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author herth
 */
public class ReadFile {

    private static final String FILEPATH = "C:\\Users\\herth\\OneDrive\\Έγγραφα\\";
    private static final String FILEIDENTIFIER = ".txt";
    private static String fileName = null;
    private static BufferedReader buffer = null;
    private static FileReader file = null;

    public ReadFile() {
    }

    public static char[][] setFileName(String name) throws IOException {
        fileName = ReadFile.FILEPATH + name + ReadFile.FILEIDENTIFIER;
        return ReadFile.readFile();
    }

    public static char[][] readFile() throws IOException {
        file = new FileReader(ReadFile.fileName);
        buffer = new BufferedReader(file);
        String line = buffer.readLine();
        String[] a = line.split(" ");
        int row = Integer.parseInt(a[0]);
        int column = Integer.parseInt(a[1]);
        char[][] maze = new char[row][column];
        for (int i = 0; i < row; i++) {
            line = buffer.readLine();
            for (int j = 0; j < column; j++) {
                maze[i][j] = line.charAt(j);
            }
        }
        ReadFile.closeFile();
        return maze;
    }

    private static void closeFile() throws IOException {
        buffer.close();
        file.close();
    }
}
