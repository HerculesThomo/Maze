package Iraklis.mainclasses;

/**
 *
 * @author herth
 */
public class Position {

    private int x;
    private int y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position left() {
        return new Position(x - 1, y);
    }

    public Position right() {
        return new Position(x + 1, y);
    }

    public Position forward() {
        return new Position(x, y + 1);
    }

    public Position backwards() {
        return new Position(x, y - 1);
    }

    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y + '}';
    }

}
