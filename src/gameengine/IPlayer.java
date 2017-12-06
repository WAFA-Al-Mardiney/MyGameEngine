package gameengine;

public interface IPlayer
{
    void AcceptAttackResult(Game game) throws GameException;
    void AcceptAttack(Game game) throws GameException;
    String GetName();
}
