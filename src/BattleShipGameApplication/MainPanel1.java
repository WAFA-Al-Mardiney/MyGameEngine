/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleShipGameApplication;

import BattleShip.BattleShipComputerPlayer;
import BattleShip.BattleShipConstants;
import BattleShip.BattleShipGame;
import BattleShip.BattleShipHumanPlayer;
import BattleShip.BattleShipPlayer;
import BattleShip.EBattleShipGameType;
import Misc.Constants;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author WAFA
 */
public class MainPanel1 extends javax.swing.JPanel
{
    /**
     * Creates new form MainPanel1
     */
    public MainPanel1()
    {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlMainPanel1 = new javax.swing.JPanel();
        btnSinglePlayer = new javax.swing.JButton(new ImageIcon("Assets\\ButtonBackground.jpg"));
        btnMultiplayer = new javax.swing.JButton(new ImageIcon("Assets\\ButtonBackground.jpg"));
        btnSettings = new javax.swing.JButton(new ImageIcon("Assets\\ButtonBackground.jpg"));
        btnExit = new javax.swing.JButton(new ImageIcon("Assets\\ButtonBackground.jpg"));

        pnlMainPanel1.setBackground(new Color(0,0,0,0));
        pnlMainPanel1.setLayout(new java.awt.GridBagLayout());

        btnSinglePlayer.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        btnSinglePlayer.setForeground(new java.awt.Color(255, 255, 255));
        btnSinglePlayer.setText("New single player game");
        btnSinglePlayer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSinglePlayer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSinglePlayer.setIconTextGap(0);
        btnSinglePlayer.setPreferredSize(new java.awt.Dimension(250, 50));
        btnSinglePlayer.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSinglePlayerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMainPanel1.add(btnSinglePlayer, gridBagConstraints);

        btnMultiplayer.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        btnMultiplayer.setForeground(new java.awt.Color(255, 255, 255));
        btnMultiplayer.setText("New multi-player game");
        btnMultiplayer.setToolTipText("");
        btnMultiplayer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMultiplayer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMultiplayer.setIconTextGap(0);
        btnMultiplayer.setPreferredSize(new java.awt.Dimension(250, 50));
        btnMultiplayer.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnMultiplayerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMainPanel1.add(btnMultiplayer, gridBagConstraints);

        btnSettings.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        btnSettings.setForeground(new java.awt.Color(255, 255, 255));
        btnSettings.setText("Settings");
        btnSettings.setToolTipText("");
        btnSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSettings.setIconTextGap(0);
        btnSettings.setPreferredSize(new java.awt.Dimension(250, 50));
        btnSettings.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSettingsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMainPanel1.add(btnSettings, gridBagConstraints);

        btnExit.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.setToolTipText("");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setIconTextGap(0);
        btnExit.setPreferredSize(new java.awt.Dimension(250, 50));
        btnExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlMainPanel1.add(btnExit, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMainPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExitActionPerformed
    {//GEN-HEADEREND:event_btnExitActionPerformed
        GameEngine.mainMenuFrame.Exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSettingsActionPerformed
    {//GEN-HEADEREND:event_btnSettingsActionPerformed
        GameEngine.mainMenuFrame.DisplayMainPanel2();
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnMultiplayerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMultiplayerActionPerformed
    {//GEN-HEADEREND:event_btnMultiplayerActionPerformed
        BattleShipHumanPlayer player1 = new BattleShipHumanPlayer(GameEngine.settings.get(BattleShipConstants.Player1NameKey).toString());
        BattleShipHumanPlayer player2 = new BattleShipHumanPlayer(GameEngine.settings.get(BattleShipConstants.Player2NameKey).toString());
        StartGame(player1, player2, EBattleShipGameType.MultiPlayer);
    }//GEN-LAST:event_btnMultiplayerActionPerformed

    private void btnSinglePlayerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSinglePlayerActionPerformed
    {//GEN-HEADEREND:event_btnSinglePlayerActionPerformed
        GameEngine.settings.replace(BattleShipConstants.Player2NameKey, BattleShipConstants.ComputerNameKey);
        BattleShipHumanPlayer player1 = new BattleShipHumanPlayer(GameEngine.settings.get(BattleShipConstants.Player1NameKey).toString());
        BattleShipComputerPlayer player2 = new BattleShipComputerPlayer(GameEngine.settings.get(BattleShipConstants.ComputerNameKey).toString());
        StartGame(player1, player2, EBattleShipGameType.SinglePlayer);
    }//GEN-LAST:event_btnSinglePlayerActionPerformed
    private void StartGame(BattleShipPlayer player1, BattleShipPlayer player2, EBattleShipGameType gameType)
    {
        GameEngine.mainMenuFrame.setVisible(false);
        GameEngine.game = new BattleShipGame(GameEngine.settings, player1, player2, gameType);
        GameEngine.Init();
        GameEngine.Step1DistributeShips();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnMultiplayer;
    public javax.swing.JButton btnSettings;
    public javax.swing.JButton btnSinglePlayer;
    public javax.swing.JPanel pnlMainPanel1;
    // End of variables declaration//GEN-END:variables
}
