package BattleShip;

import Misc.Constants;
import gameengine.Square;
import java.awt.Color;
import javax.swing.JButton;

public class Cell extends JButton
{
    public Square square;
    public Cell(int x, int y)
    {
        square = new Square(x, y, EShipState.Unknown);

        setSize(Constants.CellWidth, Constants.CellHeight);
        setLocation(x * Constants.CellWidth, y * Constants.CellHeight);

        setBorderPainted(true);
        setFocusPainted(false);
    }
    public void SetState(EShipState state)
    {
        switch (state)
        {
            case Water:
                setBackground(Color.blue);
                break;
            case DamagedWater:
                setBackground(Color.orange);
                break;
            case Ship:
                setBackground(Color.green);
                break;
            case DamagedShip:
                setBackground(Color.red);
                break;
            case Flagged:
                setBackground(Color.gray);
                break;
            case Unknown:
                setBackground(Color.black);
                break;
        }
        this.square.SetState(state);
    }
    public EShipState GetState()
    {
        return square.state;
    }
}
