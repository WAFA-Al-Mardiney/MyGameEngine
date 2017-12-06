package BattleShip;

import gameengine.Attack;
import Misc.Coordinates;

public class BattleShipAttack extends Attack
{
    private Coordinates targetCoordinates;
    public BattleShipAttack(BattleShipGame game)
    {
        super(game.CurrentPlayer, game.OpponentPlayer);
        this.targetCoordinates = game.Players[game.CurrentPlayer].GetTargetCoordinates();
    }
    public Coordinates GetTargetCoordinates()
    {
        return this.targetCoordinates;
    }
}
