package gameengine;

import Misc.Coordinates;
import BattleShip.EShipState;

public class Square
{

    public Coordinates Position;
    public EShipState state;

    public Square(int x, int y, EShipState state)
    {
        this.Position = new Coordinates(x, y);
        this.state = state;
    }

    public Square(Coordinates coordinate, EShipState state)
    {
        this.Position = coordinate;
        this.state = state;
    }

    public void SetState(EShipState state)
    {
        this.state = state;
    }
    public EShipState GetState()
    {
        return this.state;
    }
}
