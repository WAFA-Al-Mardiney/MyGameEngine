package BattleShipGameApplication;

import Misc.*;
import BattleShip.*;
import static BattleShipGameApplication.GameEngine.game;
import gameengine.GameException;
import gameengine.Square;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class FrameShipsDistribution extends javax.swing.JFrame
{
    private boolean Delete;
    Cell[][] MainGrid;
    public FrameShipsDistribution()
    {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        cbxShips.removeAllItems();
        for (Ship s : BattleShipConstants.ShipTypes)
            cbxShips.addItem(s.toString());
        Reset();
    }
    public void Reset()
    {
        Delete = false;
        txaStatus.setText("");
        UpdateStatus("Starting Game...");
        CheckFinish();
        ChangeCurrentPlayerLabel();
        txaStatus.setText(game.Players[game.CurrentPlayer].GetName() + "'s turn");
        cbxShipRotation.setSelectedIndex(0);
        cbxShips.setSelectedIndex(0);
        InitializeMainGrid();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlMain = new javax.swing.JPanel();
        pnlGridPanel = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        scpStatus = new javax.swing.JScrollPane();
        txaStatus = new javax.swing.JTextArea();
        lblDistributeShipsHint = new javax.swing.JLabel();
        cbxShips = new javax.swing.JComboBox<>();
        btnAddShip = new javax.swing.JButton();
        btnDistributeRandomly = new javax.swing.JButton();
        cbxShipRotation = new javax.swing.JComboBox<>();
        btnDeleteShip = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        lblCurrentPlayer = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("MainFrame"); // NOI18N
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlMain.setLayout(new java.awt.GridBagLayout());

        pnlGridPanel.setBackground(new java.awt.Color(255, 255, 255));
        pnlGridPanel.setCursor(GetCorrectCursor());
        pnlGridPanel.setMinimumSize(new java.awt.Dimension(50, 50));
        pnlGridPanel.setPreferredSize(new Dimension((int) GameEngine.game.GetSetting(BattleShipConstants.ColumnsCountKey)  * (int) GameEngine.game.GetSetting(BattleShipConstants.CellWidthKey), (int) GameEngine.game.GetSetting(BattleShipConstants.RowsCountKey) * (int) GameEngine.game.GetSetting(BattleShipConstants.CellHeightKey)));
        pnlGridPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlMain.add(pnlGridPanel, gridBagConstraints);

        lblStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        lblStatus.setText("Status :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnlMain.add(lblStatus, gridBagConstraints);

        txaStatus.setEditable(false);
        txaStatus.setColumns(20);
        txaStatus.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        txaStatus.setRows(5);
        scpStatus.setViewportView(txaStatus);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlMain.add(scpStatus, gridBagConstraints);

        lblDistributeShipsHint.setBackground(new java.awt.Color(255, 255, 255));
        lblDistributeShipsHint.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        lblDistributeShipsHint.setText("Select ship type then its top left cell in the grid :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 50);
        pnlMain.add(lblDistributeShipsHint, gridBagConstraints);

        cbxShips.setBackground(Color.white);
        cbxShips.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlMain.add(cbxShips, gridBagConstraints);

        btnAddShip.setBackground(new java.awt.Color(95, 153, 255));
        btnAddShip.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        btnAddShip.setForeground(new java.awt.Color(255, 255, 255));
        btnAddShip.setText("Add ship");
        btnAddShip.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddShipActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlMain.add(btnAddShip, gridBagConstraints);

        btnDistributeRandomly.setBackground(new java.awt.Color(95, 153, 255));
        btnDistributeRandomly.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        btnDistributeRandomly.setForeground(new java.awt.Color(255, 255, 255));
        btnDistributeRandomly.setText("Distribute randomly");
        btnDistributeRandomly.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDistributeRandomlyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlMain.add(btnDistributeRandomly, gridBagConstraints);

        cbxShipRotation.setBackground(Color.white
        );
        cbxShipRotation.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        cbxShipRotation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vertical", "Horizontal" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 50);
        pnlMain.add(cbxShipRotation, gridBagConstraints);

        btnDeleteShip.setBackground(new java.awt.Color(95, 153, 255));
        btnDeleteShip.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        btnDeleteShip.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteShip.setText("Delete ship");
        btnDeleteShip.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteShipActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 50);
        pnlMain.add(btnDeleteShip, gridBagConstraints);

        btnReset.setBackground(new java.awt.Color(95, 153, 255));
        btnReset.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Remove distribution");
        btnReset.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnResetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 50);
        pnlMain.add(btnReset, gridBagConstraints);

        btnFinish.setBackground(new java.awt.Color(95, 153, 255));
        btnFinish.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        btnFinish.setForeground(new java.awt.Color(255, 255, 255));
        btnFinish.setText("Finish");
        btnFinish.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFinishActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 50);
        pnlMain.add(btnFinish, gridBagConstraints);

        lblCurrentPlayer.setBackground(new java.awt.Color(255, 255, 255));
        lblCurrentPlayer.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        lblCurrentPlayer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCurrentPlayer.setText("Current Player : ");
        lblCurrentPlayer.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnlMain.add(lblCurrentPlayer, gridBagConstraints);

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
                        .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExit))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("MainFrame");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        Reset();
    }//GEN-LAST:event_formWindowOpened
    private void OnCellClick(ActionEvent e)
    {
        try
        {
            Coordinates coordinate = ((Cell) e.getSource()).square.Position;
            Ship ship;
            if (Delete)
                ship = game.TryToDeleteAt(coordinate, true);
            else
                ship = game.TryToAddShipAt(coordinate, new Ship(BattleShipConstants.ShipTypes[cbxShips.getSelectedIndex()]), "Vertical".equals(cbxShipRotation.getSelectedItem().toString()) ? ERotation.Vertical : ERotation.Horizontal, true);
            EShipState shipState = Delete ? EShipState.Water : EShipState.Ship;
            if (ship != null && !game.IsComputerTurn())
                for (Square square : ship.GetSquares())
                    GameEngine.shipsDistributionFrame.SetCellStateAt(square.Position, shipState);
            CheckFinish();
        } catch (GameException ex)
        {
            UpdateStatus(ex.getMessage());
        }
    }
    private void btnDeleteShipActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteShipActionPerformed
    {//GEN-HEADEREND:event_btnDeleteShipActionPerformed
        Delete = true;
        RefreshCursor();
    }//GEN-LAST:event_btnDeleteShipActionPerformed

    private void btnAddShipActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddShipActionPerformed
    {//GEN-HEADEREND:event_btnAddShipActionPerformed
        Delete = false;
        RefreshCursor();
    }//GEN-LAST:event_btnAddShipActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFinishActionPerformed
    {//GEN-HEADEREND:event_btnFinishActionPerformed
        GameEngine.Step2FinishShipsDistribution();
    }//GEN-LAST:event_btnFinishActionPerformed
    private void btnDistributeRandomlyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDistributeRandomlyActionPerformed
    {//GEN-HEADEREND:event_btnDistributeRandomlyActionPerformed
        try
        {
            RemoveAllShips();
            ArrayList<Ship> newAddedShips = GameEngine.game.DistributeShipsRandomly(false);
            for (Ship ship : newAddedShips)
                for (Square square : ship.GetSquares())
                    if (!game.IsComputerTurn())
                        GameEngine.shipsDistributionFrame.SetCellStateAt(square.Position, EShipState.Ship);
            CheckFinish();
        } catch (GameException ex)
        {
            //Do nothing because its automated process
        }

    }//GEN-LAST:event_btnDistributeRandomlyActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnResetActionPerformed
    {//GEN-HEADEREND:event_btnResetActionPerformed
        try
        {
            RemoveAllShips();
        } catch (GameException ex)
        {
            UpdateStatus(ex.getMessage());
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExitActionPerformed
    {//GEN-HEADEREND:event_btnExitActionPerformed
        GameEngine.CloseGame();
    }//GEN-LAST:event_btnExitActionPerformed
    private void RemoveAllShips() throws GameException
    {
        int ShipsCount = game.Players[game.CurrentPlayer].GetShipsCount();
        for (int i = 0; i < ShipsCount; i++)
        {
            Ship ship = game.Players[game.CurrentPlayer].GetShipAt(i);
            if (ship == null)
                continue;
            for (Square square : ship.GetSquares())
            {
                SetCellStateAt(square.Position, EShipState.Water);
                game.Players[game.CurrentPlayer].CurrentGrid.SetStateAt(square.Position, EShipState.Water);
            }
            game.Players[game.CurrentPlayer].RemoveShipAt(i);
        }
    }
    public Cursor GetCorrectCursor()
    {
        return Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("Assets\\Pointers\\" + (Delete ? "Delete" : "New") + ".gif").getImage(),
                new Point(0, 0), "custom cursor");
    }
    public void RefreshCursor()
    {
        pnlGridPanel.setCursor(GetCorrectCursor());
    }
    public void UpdateStatus(String line)
    {
        this.txaStatus.setText((this.txaStatus.getText() + "\n" + line).trim());
    }
    public void ChangeCurrentPlayerLabel()
    {
        this.lblCurrentPlayer.setText("Current Player : " + game.Players[game.CurrentPlayer].GetName());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddShip;
    private javax.swing.JButton btnDeleteShip;
    private javax.swing.JButton btnDistributeRandomly;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbxShipRotation;
    private javax.swing.JComboBox<String> cbxShips;
    private javax.swing.JLabel lblCurrentPlayer;
    private javax.swing.JLabel lblDistributeShipsHint;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlGridPanel;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JScrollPane scpStatus;
    private javax.swing.JTextArea txaStatus;
    // End of variables declaration//GEN-END:variables
    private void CheckFinish()
    {
        if (GameEngine.game.IsDistributionFinished())
        {
            btnFinish.setEnabled(true);
            btnFinish.setText("Finish");
        } else
        {
            btnFinish.setEnabled(false);
            btnFinish.setText("(Finish) please add " + ((int) game.GetSetting(BattleShipConstants.RequiredShipsCountKey) - game.Players[game.CurrentPlayer].GetShipsCount()) + " ships to continue");
        }
    }
    public void InitializeMainGrid()
    {
        int RowsCount = (int) game.GetSetting(BattleShipConstants.RowsCountKey);
        int ColumnsCount = (int) game.GetSetting(BattleShipConstants.ColumnsCountKey);
        int CellWidth = (int) game.GetSetting(BattleShipConstants.CellWidthKey);
        int CellHeight = (int) game.GetSetting(BattleShipConstants.CellHeightKey);
        MainGrid = new Cell[RowsCount][ColumnsCount];
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        pnlGridPanel.removeAll();
        for (int y = 0; y < RowsCount; y++)
            for (int x = 0; x < ColumnsCount; x++)
            {
                gbc.gridx = x;
                gbc.gridy = y;
                gbc.weightx = 1;
                gbc.weighty = 1;
                Cell cell = new Cell(x, y);
                cell.setPreferredSize(new Dimension(CellWidth, CellHeight));
                cell.setText(Coordinates.CoordinateToString(x, y));
                cell.setFont(new Font("Comic sans MS", 0, 16));
                cell.setMargin(new Insets(0, 0, 0, 0));
                cell.setForeground(Color.white);
                cell.SetState(EShipState.Water);
                cell.addActionListener((ActionEvent e) ->                
                {
                    OnCellClick(e);
                });
                SetCellAt(x, y, cell);
                pnlGridPanel.add(cell, gbc);
            }
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension d = new Dimension(ColumnsCount * CellWidth, RowsCount * CellHeight);
        pnlGridPanel.setMinimumSize(d);
        pnlGridPanel.setMaximumSize(d);
    }
    public Cell GetCellAt(Coordinates coordinate)
    {
        return GetCellAt(coordinate.X, coordinate.Y);
    }
    public Cell GetCellAt(int x, int y)
    {
        return MainGrid[y][x];
    }
    public void SetCellAt(Coordinates coordinate, Cell cell)
    {
        SetCellAt(coordinate.X, coordinate.Y, cell);
    }
    public void SetCellAt(int x, int y, Cell cell)
    {
        MainGrid[y][x] = cell;
    }
    public void SetCellStateAt(Coordinates coordinate, EShipState state)
    {
        SetCellStateAt(coordinate.X, coordinate.Y, state);
    }
    public void SetCellStateAt(int x, int y, EShipState state)
    {
        MainGrid[y][x].SetState(state);
    }
    public EShipState GetCellStateAt(Coordinates coordinate)
    {
        return GetCellStateAt(coordinate.X, coordinate.Y);
    }
    public EShipState GetCellStateAt(int x, int y)
    {
        return MainGrid[y][x].GetState();
    }
}
