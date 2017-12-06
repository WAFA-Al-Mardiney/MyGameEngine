package BattleShip;

import Misc.*;
import gameengine.*;

public abstract class BattleShipPlayer extends Player implements IPlayer
{
    private Ship[] _ships;
    private int _shipsCount;
    public Grid CurrentGrid;
    public Grid OpponentGrid;
    private Coordinates _targetCoordinates;
    public void SetTargetCoordinates(Coordinates coordinates)
    {
        _targetCoordinates = coordinates;
    }
    public Coordinates GetTargetCoordinates()
    {
        return _targetCoordinates;
    }
    public abstract void DistributeShips(BattleShipGame game);
    public void AttackOpponent(Game game) throws GameException
    {
        SetTargetCoordinates(null);
    }
    @Override
    public String GetName()
    {
        return this._name;
    }
    public int GetShipsCount()
    {
        return _shipsCount;
    }
    private void IncreaseShipsCount()
    {
        _shipsCount++;
    }
    private void DecreaseShipsCount()
    {
        _shipsCount--;
    }
    public void RemoveShipAt(int ShipIndex)
    {
        this._ships[ShipIndex] = null;
        DecreaseShipsCount();
    }
    public Ship GetShipAt(int index) throws GameException
    {
        return _ships[index];
    }
    private void SetShipAt(int index, Ship ship) throws GameException
    {
        _ships[index] = ship;
    }
    public BattleShipPlayer(String name)
    {
        super(name);
    }
    public void Init(BattleShipGame game)
    {
        _shipsCount = 0;
        _ships = new Ship[(int) game.GetSetting(BattleShipConstants.RequiredShipsCountKey)];
        CurrentGrid = new Grid((int) game.GetSetting(BattleShipConstants.RowsCountKey), (int) game.GetSetting(BattleShipConstants.ColumnsCountKey), EShipState.Water);
        OpponentGrid = new Grid((int) game.GetSetting(BattleShipConstants.RowsCountKey), (int) game.GetSetting(BattleShipConstants.ColumnsCountKey), EShipState.Unknown);
    }
    public void AddShip(Ship ship) throws GameException
    {
        for (int i = 0; i < _ships.length; i++)
            if (GetShipAt(i) == null)
            {
                IncreaseShipsCount();
                SetShipAt(i, ship);
                break;
            }
    }
    @Override
    public void AcceptAttack(Game game) throws GameException
    {
        Coordinates targetCoordinates = ((BattleShipAttack) game.GetAttack()).GetTargetCoordinates();
        EShipState TargetState = CurrentGrid.GetStateAt(targetCoordinates);
        EBattleShipAttackResult attackResult = null;
        EShipState newState = null;
        switch (TargetState)
        {
            case Water:
                attackResult = EBattleShipAttackResult.Missed;
                newState = EShipState.DamagedWater;
                break;
            case Ship:
                int shipIndex = GetShipIndexAt(targetCoordinates, (BattleShipGame) game);
                _ships[shipIndex].DamageSquareAt(targetCoordinates);
                if (IsTheLastShipDestroyed())
                    attackResult = EBattleShipAttackResult.LastShipDestruction;
                else if (_ships[shipIndex].IsFullyDestroyed())
                    attackResult = EBattleShipAttackResult.ShipDestruction;
                else
                    attackResult = EBattleShipAttackResult.PartialDamage;
                newState = EShipState.DamagedShip;
                break;
        }
        CurrentGrid.SetStateAt(targetCoordinates, newState);
        game.SetAttackResult(attackResult);
    }
    public boolean CanAddShips(BattleShipGame game)
    {
        return GetShipsCount() < (int) game.GetSetting(BattleShipConstants.RequiredShipsCountKey);
    }
    public int GetShipIndexAt(Coordinates targetCoordinate, BattleShipGame game) throws GameException
    {
        int ShipIndex = 0;
        boolean ShipNotFound = true;
        for (; ShipIndex < (int) game.GetSetting(BattleShipConstants.RequiredShipsCountKey) && ShipNotFound; ShipIndex++)
        {
            Ship ship = GetShipAt(ShipIndex);
            if (ship == null)
                continue;
            for (Square square : ship.GetSquares())
                if (square.Position.equals(targetCoordinate))
                    ShipNotFound = false;
        }
        return ShipNotFound ? -1 : ShipIndex - 1;
    }
    public boolean IsTheLastShipDestroyed()
    {
        for (Ship ship : _ships)
            if (!ship.IsFullyDestroyed())
                return false;
        return true;
    }
}
