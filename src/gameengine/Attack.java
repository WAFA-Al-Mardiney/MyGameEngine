package gameengine;
public class Attack
{
    private final int currentPlayer;
    private final int opponentPlayer;
    public Attack(int currentPlayer, int opponentPlayer)
    {
        this.currentPlayer = currentPlayer;
        this.opponentPlayer = opponentPlayer;
    }
    public int GetCurrentPlayer()
    {
        return this.currentPlayer;
    }
    public int GetOpponentPlayer()
    {
        return this.opponentPlayer;
    }
}
