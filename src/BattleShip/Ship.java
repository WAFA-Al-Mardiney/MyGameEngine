package BattleShip;

import Misc.Coordinates;
import gameengine.Square;

public class Ship
{

    public int Width;
    public int Height;
    private ERotation RotationValue;
    public int X;
    public int Y;
    public Square[] _squares;
    public int DamagedSquares;

    public Ship(int width, int height, ERotation rotation)
    {
        this.Width = width;
        this.Height = height;
        this.RotationValue = rotation;
        this.DamagedSquares = 0;
    }

    public Ship(Ship s)
    {
        this.Width = s.Width;
        this.Height = s.Height;
        this.RotationValue = s.RotationValue;
        this.X = s.X;
        this.Y = s.Y;
        this.DamagedSquares = 0;
    }
    public Square[] GetSquares()
    {
        return this._squares;
    }

    public ERotation GetRotation()
    {
        return this.RotationValue;
    }

    public void SetRotation(ERotation rotation)
    {
        if (this.RotationValue == rotation)
            return;
        switch (rotation)
        {
            case Horizontal:
                if (Width == 1)
                {
                    int temp = Width;
                    Width = Height;
                    Height = temp;
                }
                break;
            case Vertical:
                if (Width != 1)
                {
                    int temp = Width;
                    Width = Height;
                    Height = temp;
                }
                break;
        }
        this.RotationValue = rotation;
    }

    @Override
    public String toString()
    {
        return Width + "x" + Height;
    }

    public void SetPosition(Coordinates coordinate)
    {
        this.X = coordinate.X;
        this.Y = coordinate.Y;
    }
    public Coordinates GetPosition()
    {
        return new Coordinates(X, Y);
    }
    public void FillSquares()
    {
        if (RotationValue == ERotation.Horizontal)
        {
            _squares = new Square[Width];
            int SquareIndex = 0;
            for (int i = X; i < X + Width; i++, SquareIndex++)
                _squares[SquareIndex] = new Square(i, Y, EShipState.Ship);
        } else //Vertical
        {
            _squares = new Square[Height];
            int SquareIndex = 0;
            for (int i = Y; i < Y + Height; i++, SquareIndex++)
                _squares[SquareIndex] = new Square(X, i, EShipState.Ship);
        }
    }

    private void IncreaseDamagedSquares()
    {
        this.DamagedSquares++;
    }

    public boolean IsFullyDestroyed()
    {
        return this.DamagedSquares == _squares.length;
    }

    public void DamageSquareAt(Coordinates targetCoordinate)
    {
        IncreaseDamagedSquares();
        for (Square Square : _squares)
            if (Square.Position == targetCoordinate)
                Square.SetState(EShipState.DamagedShip);
    }
}
