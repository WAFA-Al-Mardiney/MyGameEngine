package BattleShip;

import gameengine.Game;
import gameengine.GameException;

public class BattleShipHumanPlayer extends BattleShipPlayer
{
    public BattleShipHumanPlayer(String name)
    {
        super(name);
    }
    @Override
    public void AttackOpponent(Game game) throws GameException
    {
        super.AttackOpponent(game);
    }
    @Override
    public void DistributeShips(BattleShipGame game)
    {
    }
    @Override
    public void AcceptAttackResult(Game game)
    {
        EShipState newState = game.GetAttackResult().equals(EBattleShipAttackResult.Missed) ? EShipState.DamagedWater : EShipState.DamagedShip;
        OpponentGrid.SetStateAt(((BattleShipAttack) game.GetAttack()).GetTargetCoordinates(), newState);
    }
}
