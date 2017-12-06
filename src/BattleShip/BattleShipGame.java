package BattleShip;

import Misc.Constants;
import Misc.Coordinates;
import Misc.Utilities;
import gameengine.*;
import java.util.*;

public class BattleShipGame extends Game 
{
    public BattleShipPlayer[] Players;
    public int CurrentPlayer;
    public int OpponentPlayer;
    private EBattleShipGameType gameType;
    private EBattleShipAttackResult attackResult;
    private EBattleShipAttackResult lastAttackResult;
    public BattleShipGame(HashMap<String, Object> settings, BattleShipPlayer player1, BattleShipPlayer player2, EBattleShipGameType gameType)
    {
        super(settings);
        Players = new BattleShipPlayer[2];
        Players[0] = player1;
        Players[1] = player2;
        this.gameType = gameType;
        CurrentPlayer = 0;
        OpponentPlayer = 1;
    }
    public boolean IsComputerTurn()
    {
        return GetGameType() == gameType.SinglePlayer && Players[CurrentPlayer].GetName().equals(Constants.ComputerName);
    }
    public EBattleShipAttackResult GetLastAttackResult()
    {
        return this.lastAttackResult;
    }
    public EBattleShipGameType GetGameType()
    {
        return this.gameType;
    }
    @Override
    public void ChangePlayerTurns()
    {
        CurrentPlayer = (CurrentPlayer + 1) % 2;
        OpponentPlayer = (OpponentPlayer + 1) % 2;
    }
    public Ship TryToAddShipAt(Coordinates coordinate, Ship ship, ERotation rotation, boolean canThrowException) throws GameException
    {
        Ship CurrentShip = ship;
        try
        {
            CurrentShip.SetPosition(coordinate);
            CurrentShip.SetRotation(rotation);
            if (!ReadyToAdd(CurrentShip))
                return null;
            CurrentShip.FillSquares();
            Players[CurrentPlayer].AddShip(CurrentShip);
            for (Square square : CurrentShip._squares)
                Players[CurrentPlayer].CurrentGrid.SetStateAt(square.Position, EShipState.Ship);
        } catch (GameException ex)
        {
            if (canThrowException)
                throw ex;
        }
        return CurrentShip;
    }
    public Ship TryToDeleteAt(Coordinates coordinate, boolean canThrowException) throws GameException
    {
        Ship ship = null;
        try
        {
            if (!ReadyToDelete(coordinate, canThrowException))
                return null;
            if (Players[CurrentPlayer].CurrentGrid.GetStateAt(coordinate) == EShipState.Ship)
            {
                int shipIndex = Players[CurrentPlayer].GetShipIndexAt(coordinate, this);
                if (shipIndex == -1)
                    return null;
                ship = Players[CurrentPlayer].GetShipAt(shipIndex);
                for (Square square : ship._squares)
                    Players[CurrentPlayer].CurrentGrid.SetStateAt(square.Position, EShipState.Water);
                Players[CurrentPlayer].RemoveShipAt(shipIndex);
            }
        } catch (GameException ex)
        {
            if (canThrowException)
                throw ex;
        }
        return ship;
    }
    public boolean ReadyToDelete(Coordinates coordinate, boolean canThrowException) throws InvalidDeletionException
    {
        boolean IsNotReadyToDelete = true;
        try
        {
            if (IsNotReadyToDelete = (Players[CurrentPlayer].CurrentGrid.GetStateAt(coordinate) != EShipState.Ship))
                throw new InvalidDeletionException("Please select a ship to delete not a blank cell");
        } catch (InvalidDeletionException ex)
        {
            if (canThrowException)
                throw ex;
        }
        return !IsNotReadyToDelete;
    }
    public ArrayList<Ship> DistributeShipsRandomly(boolean canThrowException) throws GameException
    {
        ArrayList<Ship> ships = new ArrayList<>();
        while (!IsDistributionFinished())
        {
            Ship randomShip = GetRandomDistributionShip();
            randomShip = TryToAddShipAt(randomShip.GetPosition(), randomShip, randomShip.GetRotation(), canThrowException);
            if (randomShip != null)
                ships.add(randomShip);
        }
        return ships;
    }
    public boolean IsDistributionFinished()
    {
        return Players[CurrentPlayer].GetShipsCount() == (int) GetSetting(BattleShipConstants.RequiredShipsCountKey);
    }
    public boolean ReadyToAdd(Ship ship) throws GameException
    {
        boolean IsNotReadyToAdd = true;
        if (IsNotReadyToAdd = !Players[CurrentPlayer].CanAddShips(this))
            throw new InvalidAdditionException("Can't put more than " + (int) GetSetting(BattleShipConstants.RequiredShipsCountKey) + " ships");
        else if (IsNotReadyToAdd = ((ship.GetRotation() == ERotation.Horizontal && ship.X + ship.Width > (int) GetSetting(BattleShipConstants.ColumnsCountKey)))
                || (ship.GetRotation() == ERotation.Vertical && ship.Y + ship.Height > (int) GetSetting(BattleShipConstants.RowsCountKey)))
            throw new InvalidAdditionException("Can't fit in the selected position");
        boolean allCellsAreFree = true;
        Coordinates coordinate = ship.GetPosition();
        if (ship.GetRotation() == ERotation.Vertical)
        {
            for (int i = coordinate.Y; i < ship.Height + coordinate.Y && allCellsAreFree; i++)
                if (Players[CurrentPlayer].CurrentGrid.GetStateAt(coordinate.X, i) != EShipState.Water)
                    allCellsAreFree = false;
        } else if (ship.GetRotation() == ERotation.Horizontal)
            for (int i = coordinate.X; i < ship.Width + coordinate.X && allCellsAreFree; i++)
                if (Players[CurrentPlayer].CurrentGrid.GetStateAt(i, coordinate.Y) != EShipState.Water)
                    allCellsAreFree = false;
        if (IsNotReadyToAdd = (!allCellsAreFree))
            if (!IsComputerTurn())
                throw new InvalidAdditionException("The body of the ship is colliding with another ship, please try another cell");
        return !IsNotReadyToAdd;
    }
    public boolean ReadyToAttack(Coordinates coordinate) throws GameException
    {
        boolean IsNotReadyToAttack = true;
        if (IsNotReadyToAttack = (Players[CurrentPlayer].OpponentGrid.GetStateAt(coordinate) != EShipState.Unknown
                && Players[CurrentPlayer].OpponentGrid.GetStateAt(coordinate) != EShipState.Flagged))
            throw new InvalidAttackException("You've tried this one already, try another one");
        return !IsNotReadyToAttack;
    }
    public Ship GetRandomDistributionShip()
    {
        ArrayList<Ship> ships = new ArrayList<>();
        int RowsCount = (int) GetSetting(BattleShipConstants.RowsCountKey);
        int ColumnsCount = (int) GetSetting(BattleShipConstants.ColumnsCountKey);
        for (int y = 0; y < RowsCount; y++)
            for (int x = 0; x < ColumnsCount; x++)
            {
                int randomShipTypeIndex = Utilities.GetRandomNumberWithWeightingArray(new int[]
                {
                    15, 50, 80, 100
                });
                ERotation randomRotation = new Random().nextInt(5000) % 2 == 0 ? ERotation.Vertical : ERotation.Horizontal;
                Ship ship = new Ship(BattleShipConstants.ShipTypes[randomShipTypeIndex]);
                ship.SetRotation(randomRotation);
                ship.SetPosition(new Coordinates(x, y));
                try
                {
                    if (Players[CurrentPlayer].CurrentGrid.GetStateAt(x, y) == EShipState.Water && ReadyToAdd(ship))
                        ships.add(ship);
                } catch (GameException ex)
                {
                    //Do nothing because its automated process
                }
            }
        return ships.get(new Random().nextInt(ships.size() - 1));
    }
    public Coordinates GetRandomTargetCoordinates()
    {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        int rowsCount = (int) GetSetting(BattleShipConstants.RowsCountKey);
        int columnsCount = (int) GetSetting(BattleShipConstants.ColumnsCountKey);
        for (int y = 0; y < rowsCount; y++)
            for (int x = 0; x < columnsCount; x++)
                if (Players[CurrentPlayer].OpponentGrid.GetStateAt(x, y) == EShipState.Unknown)
                    coordinates.add(new Coordinates(x, y));
        return coordinates.get(new Random().nextInt(coordinates.size() - 1));
    }
    @Override
    public Attack GetAttack()
    {
        return this.attack;
    }
    @Override
    public void SetAttack(Attack attack)
    {
        this.attack = attack;
    }
    @Override
    public EBattleShipAttackResult GetAttackResult()
    {
        return this.attackResult;
    }
    @Override
    public void SetAttackResult(Object attackResult)
    {
        this.lastAttackResult = this.attackResult = (EBattleShipAttackResult) attackResult;
    }
}
