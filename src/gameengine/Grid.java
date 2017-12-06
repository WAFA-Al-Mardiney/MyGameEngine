package gameengine;
import Misc.*;
import BattleShip.EShipState;
public class Grid
{
    private final Square[][] Squares;
    public void SetStateAt(int x, int y, EShipState state)
    {
        Squares[y][x].SetState(state);
    }
    public void SetStateAt(Coordinates coordinate, EShipState state)
    {
        SetStateAt(coordinate.X, coordinate.Y, state);
    }
    public EShipState GetStateAt(int x, int y)
    {
        return Squares[y][x].GetState();
    }
    public EShipState GetStateAt(Coordinates coordinate)
    {
        return GetStateAt(coordinate.X, coordinate.Y);
    }
    public Grid(int RowsCount , int ColumnsCount ,EShipState state)
    {
        Squares = new Square[RowsCount][ColumnsCount];
        for (int y = 0; y < RowsCount; y++)
            for (int x = 0; x < ColumnsCount; x++)
                this.Squares[y][x] = new Square(x, y, state);
    }
}
