package Misc;
public class Coordinates
{
    public int X;
    public int Y;
    public Coordinates(int x, int y)
    {
        this.X = x;
        this.Y = y;
    }
    public static Coordinates StringToCoordinate(String cellName)
    {
        int Column = cellName.charAt(cellName.length() - 1) - 'A';
        int Row = Integer.parseInt(cellName.substring(0, cellName.length() - 1)) - 1;
        return new Coordinates(Column, Row);
    }
    public static String CoordinateToString(Coordinates coordinate)
    {
        return CoordinateToString(coordinate.X, coordinate.Y);
    }
    public static String CoordinateToString(int x, int y)
    {
        return (y + 1) + "" + (char) (x + 'A');
    }
    public boolean equals(Coordinates coordinate)
    {
        return X == coordinate.X && Y == coordinate.Y;
    }
}
