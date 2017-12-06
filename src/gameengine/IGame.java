package gameengine;

public interface IGame
{
    Attack GetAttack();
    void SetAttack(Attack attack);
    void SetAttackResult(Object attackResult);
    Object GetAttackResult();
    void ChangePlayerTurns();
}
