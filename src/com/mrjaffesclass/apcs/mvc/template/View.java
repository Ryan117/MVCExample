/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrjaffesclass.apcs.mvc.template;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author 
 */
public class View extends JFrame implements MessageHandler {

    private final int numOfButtons = 8;
    private final int BUTTON_SIZE = 25;
    private final JPanel panel = new JPanel();
    private final JPanel panel2 = new JPanel();
    private int lives = 5;
    private final int BOARD_SIZE;
    private final Messenger messenger;
    private final Square[][] squares = new Square[numOfButtons][numOfButtons];
   
    private int score = 0;
    private final JLabel lifeAmount = new JLabel(lives + "");
    private final JLabel scoreAmount = new JLabel(score + "");

    GridLayout layout1 = new GridLayout(0, 2);
    GridLayout layout2;

    public View(Messenger messenger) {
        super("Landmine");
        this.layout2 = new GridLayout(numOfButtons, numOfButtons);
        this.BOARD_SIZE = BUTTON_SIZE * numOfButtons;
        this.messenger = messenger;
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel.setLayout(layout1);
        panel.setLayout(layout2);
        panel.setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        addSquares();

        panel2.add(new Label("Score:"));
        panel2.add(scoreAmount);
        panel2.add(new Label("Health:"));
        panel2.add(lifeAmount);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel, BorderLayout.NORTH);
        add(new JSeparator(), BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        pack();

        setVisible(true);

    }


    private void addSquares() {
        int counter = 0;
        for (int y = 0; y < numOfButtons; y++) {
            for (int x = 0; x < numOfButtons; x++) {
                squares[x][y] = new Square(x, y, messenger);
                panel.add(squares[x][y].getButton());

            }
        }
    }

    private void loseALife() {
        lives--;
        lifeAmount.setText(lives + "");
        if (lives <= 0) {
            messenger.notify("View:GameOver", false);
            
            setVisible(false);
        }
    }

    private void reset() {
        score = 0;
        lives = 3;
        scoreAmount.setText(score + "");
        lifeAmount.setText(lives + "");
        setVisible(true);
    }

    public void init() {
        messenger.subscribe("Model:ScoreAPoint", this);
        messenger.subscribe("Model:LoseALife", this);
        messenger.subscribe("GameOver:Reset", this);
    }
    
    @Override
    public void messageHandler(String messageName, Object messagePayload) {
        switch (messageName) {
            case "Model:LoseALife":
                loseALife();
                break;
            case "Model:ScoreAPoint":
                
            case "GameOver:Reset":
                reset();
                break;
        }
    }
}

          .addComponent(upButton1)
          .addComponent(downButton1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel9)
          .addComponent(jLabel10)
          .addComponent(upButton2)
          .addComponent(downButton2)))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void clickMeButtonbuttonClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickMeButtonbuttonClickActionPerformed
    // Send a message to the controller!
    mvcMessaging.notify("view:buttonClick", null, true);
  }//GEN-LAST:event_clickMeButtonbuttonClickActionPerformed

  private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
    // Send a message to the controller!
    mvcMessaging.notify("view:toggleButtonClick", null, true);
  }//GEN-LAST:event_jToggleButton1ActionPerformed

  private void noClickMeButtonbuttonClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noClickMeButtonbuttonClickActionPerformed
    // Send a message to the controller!
    mvcMessaging.notify("view:buttonClick", null, true);
  }//GEN-LAST:event_noClickMeButtonbuttonClickActionPerformed

  private void fillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillButtonActionPerformed
    fillButton.setText(textField.getText());
  }//GEN-LAST:event_fillButtonActionPerformed

  /**
   * Handler for the up button for field 1
   * @param evt 
   */
  private void upButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButton1ActionPerformed
    // Increment the 1st data field
    mvcMessaging.notify("view:changeButton", createPayload(1, Constants.UP), true);
  }//GEN-LAST:event_upButton1ActionPerformed

  private void upButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButton2ActionPerformed
    // Increment the 2nd data field
    mvcMessaging.notify("view:changeButton", createPayload(2, Constants.UP), true);
  }//GEN-LAST:event_upButton2ActionPerformed

  private void downButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButton1ActionPerformed
    // Decrement the first data field
    mvcMessaging.notify("view:changeButton", createPayload(1, Constants.DOWN), true);
  }//GEN-LAST:event_downButton1ActionPerformed

  private void downButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButton2ActionPerformed
    // Decrement the second data field
    mvcMessaging.notify("view:changeButton", createPayload(2, Constants.DOWN), true);
  }//GEN-LAST:event_downButton2ActionPerformed

  /**
   * @param args the command line arguments
   */

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton clickMeButton;
  private javax.swing.JButton downButton1;
  private javax.swing.JButton downButton2;
  private javax.swing.JButton fillButton;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JToggleButton jToggleButton1;
  private javax.swing.JButton noClickMeButton;
  private javax.swing.JTextField textField;
  private javax.swing.JButton upButton1;
  private javax.swing.JButton upButton2;
  // End of variables declaration//GEN-END:variables
}
