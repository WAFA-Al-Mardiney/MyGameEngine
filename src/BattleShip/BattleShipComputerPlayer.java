package BattleShip;

import gameengine.*;
import Misc.Coordinates;

public class BattleShipComputerPlayer extends BattleShipPlayer
{
    public BattleShipComputerPlayer(String name)
    {
        super(name);
    }
    @Override
    public void DistributeShips(BattleShipGame game)
    {
        try
        {
            ((BattleShipGame) game).DistributeShipsRandomly(false);
        } catch (GameException ex)
        {
        }
    }
    @Override
    public void AttackOpponent(Game game) throws GameException
    {
        super.AttackOpponent(game);
        Coordinates randomCoordinate = ((BattleShipGame) game).GetRandomTargetCoordinates();
        SetTargetCoordinates(randomCoordinate);
    }
    @Override
    public void AcceptAttackResult(Game game)
    {
        EShipState newState = game.GetAttackResult().equals(EBattleShipAttackResult.Missed) ? EShipState.DamagedWater : EShipState.DamagedShip;
        OpponentGrid.SetStateAt(((BattleShipAttack) game.GetAttack()).GetTargetCoordinates(), newState);
    }
}
