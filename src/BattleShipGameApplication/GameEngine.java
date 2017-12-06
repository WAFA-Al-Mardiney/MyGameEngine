package BattleShipGameApplication;

import BattleShip.BattleShipAttack;
import BattleShip.BattleShipConstants;
import BattleShip.BattleShipGame;
import BattleShip.EBattleShipAttackResult;
import BattleShip.EShipState;
import Misc.Constants;
import Misc.Coordinates;
import Misc.MessageBox;
import gameengine.GameException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class GameEngine
{
    public static BattleShipGame game;
    public static FrameMainMenu mainMenuFrame;
    public static FrameShipsDistribution shipsDistributionFrame;
    public static FrameTargetSelection targetSelectionFrame;
    private static int ShipsDistributionFinishTimes;
    public static HashMap<String, Object> settings;
    static void Init()
    {
        shipsDistributionFrame = null;
        GameEngine.targetSelectionFrame = null;
        game.Players[game.CurrentPlayer].Init(game);
        game.Players[game.OpponentPlayer].Init(game);
        ShipsDistributionFinishTimes = 0;
    }
    public static void InitSettings()
    {
        int RowsCount = BattleShipConstants.SmallRowsCount;
        int ColumnsCount = BattleShipConstants.SmallColumnsCount;
        int CellWidth = BattleShipConstants.SmallCellWidth;
        int CellHeight = BattleShipConstants.SmallCellHeight;
        int RequiredShipsCount = BattleShipConstants.SmallRequiredShipsCount;
        String Player1Name = Constants.Player1Name;
        String Player2Name = Constants.Player2Name;
        String ComputerName = Constants.ComputerName;
        settings = new HashMap<>();
        settings.put(BattleShipConstants.Player1NameKey, Player1Name);
        settings.put(BattleShipConstants.Player2NameKey, Player2Name);
        settings.put(BattleShipConstants.ComputerNameKey, ComputerName);
        settings.put(BattleShipConstants.RowsCountKey, RowsCount);
        settings.put(BattleShipConstants.ColumnsCountKey, ColumnsCount);
        settings.put(BattleShipConstants.RequiredShipsCountKey, RequiredShipsCount);
        settings.put(BattleShipConstants.CellWidthKey, CellWidth);
        settings.put(BattleShipConstants.CellHeightKey, CellHeight);
    }
    private static void NotifyChanges()
    {
        String message;
        switch (game.GetAttackResult())
        {
            case LastShipDestruction:
                message = "All " + game.Players[game.GetAttack().GetOpponentPlayer()].GetName() + "'s ships have been destroyed";
                NotifyChanges(message);
                break;
            case PartialDamage:
                message = game.Players[game.GetAttack().GetOpponentPlayer()].GetName() + " has a damaged ship";
                NotifyChanges(message);
                break;
            case ShipDestruction:
                message = game.Players[game.GetAttack().GetOpponentPlayer()].GetName() + "'s ship has been destroyed";
                NotifyChanges(message);
                break;
            case Missed:
                message = game.Players[game.GetAttack().GetCurrentPlayer()].GetName() + " has missed";
                NotifyChanges(message);
                break;
        }
    }
    private static void NotifyChanges(String message)
    {
        GameEngine.targetSelectionFrame.UpdateStatus(message);
    }
    private static void DisplayTargetSelectionFrame()
    {
        if (targetSelectionFrame == null)
        {
            targetSelectionFrame = new FrameTargetSelection();
            targetSelectionFrame.setVisible(true);
        } else
            targetSelectionFrame.RefreshFrame();
    }
    private static void DisplayShipsDistributionFrame()
    {
        if (shipsDistributionFrame == null)
        {
            shipsDistributionFrame = new FrameShipsDistribution();
            shipsDistributionFrame.setVisible(true);
        } else
            shipsDistributionFrame.Reset();
    }
    private static boolean GameShouldClose()
    {
        return game.GetLastAttackResult() == EBattleShipAttackResult.LastShipDestruction;
    }
    public static void CloseGame()
    {
        if (GameEngine.shipsDistributionFrame != null)
            GameEngine.shipsDistributionFrame.dispose();
        if (GameEngine.targetSelectionFrame != null)
            GameEngine.targetSelectionFrame.dispose();
        GameEngine.mainMenuFrame.DisplayMainPanel1();
    }
    public static void PrintGrid(String message, int player, int gridIndex)
    {
        System.out.println(message);
        for (int y = 0; y < Constants.RowsCount; y++)
        {
            for (int x = 0; x < Constants.ColumnsCount; x++)
            {
                String cellName = Coordinates.CoordinateToString(x, y);
                EShipState cellState;
                if (gridIndex == 0)
                    cellState = game.Players[player].CurrentGrid.GetStateAt(x, y);
                else
                    cellState = game.Players[player].OpponentGrid.GetStateAt(x, y);
                switch (cellState)
                {
                    case DamagedShip:
                        System.out.print("*");
                        break;
                    case Ship:
                        System.out.print("#");
                        break;
                    case Unknown:
                        System.out.print(".");
                        break;
                    case Water:
                        System.out.print("~");
                        break;
                }
                System.out.print(cellName);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void DisplaySwitchPlayerScreen()
    {
        javax.swing.JFrame f = new javax.swing.JFrame();
        f.setBounds(GameEngine.targetSelectionFrame.getBounds());
        f.setUndecorated(true);
        javax.swing.JButton j = new javax.swing.JButton(new javax.swing.ImageIcon("Assets\\ChangePlayer.jpg"));
        j.setBounds(f.getBounds());
        j.setBackground(Color.white);
        f.add(j);
        j.setVisible(true);
        j.addActionListener((ActionEvent e) ->
        {
            targetSelectionFrame.setVisible(true);
            targetSelectionFrame.RefreshFrame();
            f.setVisible(false);
            Step3SelectTarget();
        });
        f.setVisible(true);
        targetSelectionFrame.setVisible(false);
    }
    public static void Step1DistributeShips()
    {
        game.Players[game.CurrentPlayer].DistributeShips(game);
        if (game.IsComputerTurn())
            Step2FinishShipsDistribution();
        else
            DisplayShipsDistributionFrame();
    }
    public static void Step2FinishShipsDistribution()
    {
        ShipsDistributionFinishTimes++;
        game.ChangePlayerTurns();
        if (ShipsDistributionFinishTimes == Constants.PlayersCount)
        {
            shipsDistributionFrame.dispose();
            DisplayTargetSelectionFrame();
            Step3SelectTarget();
        } else
        {
            if (game.IsComputerTurn())
                Step1DistributeShips();
            else
                DisplayShipsDistributionFrame();
        }
    }
    public static void Step3SelectTarget()
    {
        try
        {
            game.Players[game.CurrentPlayer].AttackOpponent(game);
            if (game.IsComputerTurn())
                Step4AcceptAttack();
            else
                DisplayTargetSelectionFrame();
        } catch (GameException ex)
        {
            if (!game.IsComputerTurn())
                targetSelectionFrame.UpdateStatus(ex.getMessage());
        }
    }
    public static void Step4AcceptAttack() throws GameException
    {
        game.SetAttack(new BattleShipAttack(game));
        game.Players[game.OpponentPlayer].AcceptAttack(game);
        Step5AcceptAttackResultAndNotifyChanges();
    }
    public static void Step5AcceptAttackResultAndNotifyChanges() throws GameException
    {
        game.Players[game.CurrentPlayer].AcceptAttackResult(game);
        EShipState newState = game.GetAttackResult().equals(EBattleShipAttackResult.Missed) ? EShipState.DamagedWater : EShipState.DamagedShip;
        Coordinates targetCoordinates = game.Players[game.CurrentPlayer].GetTargetCoordinates();
        if (game.IsComputerTurn())
        {
            targetSelectionFrame.SetCurrentCellStateAt(targetCoordinates, newState);
            DisplayTargetSelectionFrame();
            Step6LoopIfGameShouldNotClose();
        } else
            targetSelectionFrame.SetOpponentCellStateAt(targetCoordinates, newState);
        NotifyChanges();
    }
    public static void Step6LoopIfGameShouldNotClose()
    {
        if (GameShouldClose())
            MessageBox.Show(targetSelectionFrame, "Game has finished", game.Players[game.CurrentPlayer].GetName() + " has won", (ActionEvent e) -> CloseGame());
        else
        {
            game.Players[game.CurrentPlayer].SetTargetCoordinates(null);
            game.Players[game.OpponentPlayer].SetTargetCoordinates(null);
            game.ChangePlayerTurns();
            switch (game.GetGameType())
            {
                case SinglePlayer:
                    Step3SelectTarget();
                    break;
                case MultiPlayer:
                    DisplaySwitchPlayerScreen();
                    break;
            }
        }
    }
    public static void main(String[] args)
    {
        mainMenuFrame = new FrameMainMenu();
        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setVisible(true);
    }
}
