package TetrisGame.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class GameLabels extends JPanel {
    private JLabel scoreLabel;
    private JLabel modeLabel;

    public GameLabels() {
        this.setBounds(650, 50, 200, 75);
        this.setBackground(Color.black);
        Border borderLine = BorderFactory.createLineBorder(Color.white);
        this.setBorder(borderLine);
        this.setLayout(null);

        setScoreLabel(new JLabel());
        this.add(scoreLabel);
        setModeLabel(new JLabel());
        this.add(modeLabel);


    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getModeLabel() {
        return modeLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        scoreLabel.setText("Score: 0");
        scoreLabel.setForeground(Color.white);
        scoreLabel.setBounds(10, 10, 200, 30);
        scoreLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        this.scoreLabel = scoreLabel;
    }

    public void setModeLabel(JLabel modeLabel) {
        modeLabel.setText("Mode: ");//too weak!  Basic~  WOW!  u a GOD!!!
        modeLabel.setForeground(Color.white);
        modeLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        modeLabel.setBounds(10, 35, 200, 30);
        this.modeLabel = modeLabel;
    }
}
