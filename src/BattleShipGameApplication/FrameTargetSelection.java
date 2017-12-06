package BattleShipGameApplication;

import Misc.*;
import BattleShip.*;
import BattleShip.EShipState;
import gameengine.GameException;
import java.awt.*;
import java.awt.event.*;

public class FrameTargetSelection extends javax.swing.JFrame
{
    public Cell[][] CurrentGrid;
    public Cell[][] OpponentGrid;
    public void Reset()
    {
        btnFinishTurn.setEnabled(false);
    }
    public void SetCurrentCellAt(int x, int y, Cell cell)
    {
        CurrentGrid[y][x] = cell;
    }
    public void SetCurrentCellAt(Coordinates coordinates, Cell cell)
    {
        SetCurrentCellAt(coordinates.X, coordinates.Y, cell);
    }
    public Cell GetCurrentCellAt(int x, int y)
    {
        return CurrentGrid[y][x];
    }
    public Cell GetCurrentCellAt(Coordinates coordinates)
    {
        return GetCurrentCellAt(coordinates.X, coordinates.Y);
    }
    public void SetOpponentCellAt(int x, int y, Cell cell)
    {
        OpponentGrid[y][x] = cell;
    }
    public void SetOpponentCellAt(Coordinates coordinates, Cell cell)
    {
        SetOpponentCellAt(coordinates.X, coordinates.Y, cell);
    }
    public Cell GetOpponentCellAt(int x, int y)
    {
        return OpponentGrid[y][x];
    }
    public Cell GetOpponentCellAt(Coordinates coordinates)
    {
        return GetOpponentCellAt(coordinates.X, coordinates.Y);
    }
    public void SetCurrentCellStateAt(int x, int y, EShipState state)
    {
        CurrentGrid[y][x].SetState(state);
    }
    public void SetCurrentCellStateAt(Coordinates coordinates, EShipState state)
    {
        SetCurrentCellStateAt(coordinates.X, coordinates.Y, state);
    }
    public EShipState GetCurrentCellStateAt(int x, int y)
    {
        return CurrentGrid[y][x].GetState();
    }
    public EShipState GetCurrentCellStateAt(Coordinates coordinates)
    {
        return GetCurrentCellStateAt(coordinates.X, coordinates.Y);
    }
    public void SetOpponentCellStateAt(int x, int y, EShipState cell)
    {
        OpponentGrid[y][x].SetState(cell);
    }
    public void SetOpponentCellStateAt(Coordinates coordinates, EShipState state)
    {
        SetOpponentCellStateAt(coordinates.X, coordinates.Y, state);
    }
    public EShipState GetOpponentCellStateAt(int x, int y)
    {
        return OpponentGrid[y][x].GetState();
    }
    public EShipState GetOpponentCellStateAt(Coordinates coordinates)
    {
        return GetOpponentCellStateAt(coordinates.X, coordinates.Y);
    }
    public FrameTargetSelection()
    {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pnlOpponent = new javax.swing.JPanel();
        lblCurrentPlayer = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        scpStatus = new javax.swing.JScrollPane();
        txaStatus = new javax.swing.JTextArea();
        btnFinishTurn = new javax.swing.JButton();
        pnlCurrent = new javax.swing.JPanel();
        lblOpponentgrid = new javax.swing.JLabel();
        lblCurrentGrid = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("MainFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        pnlOpponent.setPreferredSize(new Dimension((int) GameEngine.game.GetSetting(BattleShipConstants.ColumnsCountKey)  * (int) GameEngine.game.GetSetting(BattleShipConstants.CellWidthKey), (int) GameEngine.game.GetSetting(BattleShipConstants.RowsCountKey) * (int) GameEngine.game.GetSetting(BattleShipConstants.CellHeightKey)));
        pnlOpponent.setLayout(new java.awt.GridBagLayout());

        lblCurrentPlayer.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        lblCurrentPlayer.setText("Current Player : ");

        lblStatus.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        lblStatus.setText("Status :");

        txaStatus.setEditable(false);
        txaStatus.setColumns(20);
        txaStatus.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        txaStatus.setRows(5);
        scpStatus.setViewportView(txaStatus);

        btnFinishTurn.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        btnFinishTurn.setText("Finish turn");
        btnFinishTurn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFinishTurnActionPerformed(evt);
            }
        });

        pnlCurrent.setPreferredSize(new Dimension((int) GameEngine.game.GetSetting(BattleShipConstants.ColumnsCountKey)  * (int) GameEngine.game.GetSetting(BattleShipConstants.CellWidthKey), (int) GameEngine.game.GetSetting(BattleShipConstants.RowsCountKey) * (int) GameEngine.game.GetSetting(BattleShipConstants.CellHeightKey)));
        pnlCurrent.setLayout(new java.awt.GridBagLayout());

        lblOpponentgrid.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        lblOpponentgrid.setText("Opponent player grid");

        lblCurrentGrid.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        lblCurrentGrid.setText("Current player grid");

        btnExit.setBackground(new java.awt.Color(255, 0, 0));
        btnExit.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("X");
        btnExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlOpponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurrentPlayer))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurrentGrid)
                            .addComponent(pnlCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFinishTurn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 725, Short.MAX_VALUE)
                                .addComponent(btnExit))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOpponentgrid)
                                    .addComponent(lblStatus))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(scpStatus))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurrentPlayer)
                            .addComponent(btnFinishTurn)))
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpponentgrid)
                    .addComponent(lblCurrentGrid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlOpponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("MainFrame");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        int RowsCount = (int) GameEngine.game.GetSetting(BattleShipConstants.RowsCountKey);
        int ColumnsCount = (int) GameEngine.game.GetSetting(BattleShipConstants.ColumnsCountKey);
        int CellWidth = (int) GameEngine.game.GetSetting(BattleShipConstants.CellWidthKey);
        int CellHeight = (int) GameEngine.game.GetSetting(BattleShipConstants.CellHeightKey);
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        pnlCurrent.setPreferredSize(new Dimension(ColumnsCount * CellWidth, RowsCount * CellHeight));
        pack();
        ChangeCurrentPlayerLabel();
        UpdateStatus("Select a target in your opponent's field to attack");
        InitializeGrids(RowsCount, ColumnsCount);
        RefreshFrame();
    }//GEN-LAST:event_formWindowOpened

    private void btnFinishTurnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFinishTurnActionPerformed
    {//GEN-HEADEREND:event_btnFinishTurnActionPerformed
        btnFinishTurn.setEnabled(false);
        GameEngine.Step6LoopIfGameShouldNotClose();
    }//GEN-LAST:event_btnFinishTurnActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExitActionPerformed
    {//GEN-HEADEREND:event_btnExitActionPerformed
        GameEngine.CloseGame();
    }//GEN-LAST:event_btnExitActionPerformed
    private void OnOpponentCellClick(ActionEvent e)
    {
        try
        {
            Cell cell = ((Cell) e.getSource());
            Coordinates coordinates = cell.square.Position;
            if (GameEngine.game.Players[GameEngine.game.CurrentPlayer].GetTargetCoordinates() != null)
                throw new InvalidAttackException("You've already selected a cell, click finish turn button");
            if (!GameEngine.game.ReadyToAttack(coordinates))
                return;
            btnFinishTurn.setEnabled(true);
            //TODO try to comment the next line
            btnFinishTurn.validate();
            GameEngine.game.Players[GameEngine.game.CurrentPlayer].SetTargetCoordinates(coordinates);
            GameEngine.Step4AcceptAttack();
        } catch (GameException ex)
        {
            if (!GameEngine.game.IsComputerTurn())
                UpdateStatus(ex.getMessage());
        }
    }
    public void UpdateStatus(String line)
    {
        this.txaStatus.setText((this.txaStatus.getText() + "\n" + line).trim());
    }
    public void ChangeCurrentPlayerLabel()
    {
        this.lblCurrentPlayer.setText("Current Player : " + (GameEngine.game.Players[GameEngine.game.CurrentPlayer]).GetName());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFinishTurn;
    private javax.swing.JLabel lblCurrentGrid;
    private javax.swing.JLabel lblCurrentPlayer;
    private javax.swing.JLabel lblOpponentgrid;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlCurrent;
    private javax.swing.JPanel pnlOpponent;
    private javax.swing.JScrollPane scpStatus;
    private javax.swing.JTextArea txaStatus;
    // End of variables declaration//GEN-END:variables
    private void InitializeGrids(int rowsCount, int columnsCount)
    {
        OpponentGrid = new Cell[rowsCount][columnsCount];
        CurrentGrid = new Cell[rowsCount][columnsCount];
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        for (int y = 0; y < rowsCount; y++)
            for (int x = 0; x < columnsCount; x++)
            {
                gbc.gridx=x;
                gbc.gridy=y;
                Cell[] cells =
                {
                    new Cell(x, y),
                    new Cell(x, y)
                };
                for (Cell cell : cells)
                {
                    cell.setText(Coordinates.CoordinateToString(x, y));
                    cell.setFont(new Font("Comic sans MS", 0, 16));
                    cell.setMargin(new Insets(0, 0, 0, 0));
                    cell.setForeground(Color.white);
                    cell.setPreferredSize(new Dimension((int) GameEngine.game.GetSetting(BattleShipConstants.CellWidthKey), (int) GameEngine.game.GetSetting(BattleShipConstants.CellHeightKey)));
                    SetCurrentCellAt(x, y, cell);
                }
                cells[0].SetState(EShipState.Water);
                cells[1].SetState(EShipState.Unknown);
                SetCurrentCellAt(x, y, cells[0]);
                pnlCurrent.add(cells[0],gbc);
                cells[1].addActionListener((ActionEvent e) ->
                {
                    OnOpponentCellClick(e);
                    btnFinishTurn.requestFocus();
                });
                cells[1].addMouseListener(new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {
                        if (e.getButton() == 3)
                        {
                            cells[1].setBackground(Color.gray);
                            GameEngine.game.Players[GameEngine.game.CurrentPlayer].OpponentGrid.SetStateAt(cells[1].square.Position, EShipState.Flagged);
                        }
                    }
                });
                SetOpponentCellAt(x, y, cells[1]);
                pnlOpponent.add(cells[1],gbc);
            }
    }
    public void RefreshFrame()
    {
        if (CurrentGrid != null && OpponentGrid != null)
        {
            for (int y = 0; y < (int) GameEngine.game.GetSetting(BattleShipConstants.RowsCountKey); y++)
                for (int x = 0; x < (int) GameEngine.game.GetSetting(BattleShipConstants.ColumnsCountKey); x++)
                {
                    SetCurrentCellStateAt(x, y, GameEngine.game.Players[GameEngine.game.CurrentPlayer].CurrentGrid.GetStateAt(x, y));
                    SetOpponentCellStateAt(x, y, GameEngine.game.Players[GameEngine.game.CurrentPlayer].OpponentGrid.GetStateAt(x, y));
                }
        }
        Reset();
    }
}
