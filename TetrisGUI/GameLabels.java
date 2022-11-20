package TetrisGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class GameLabels extends JPanel {
    private JLabel scoreLabel = new JLabel("Score: 0");
    private JLabel modeLabel = new JLabel("Mode: "); //too easy!  weak!  u a GOD!!!
    public GameLabels(){
        this.setBounds(650,50,200,150);
        this.setBackground(Color.white);
        Border borderLine = BorderFactory.createLineBorder(Color.black);
        this.setBorder(borderLine);
        this.setLayout(null);

        setScoreLabel(scoreLabel);
        this.add(modeLabel);




        //scoreLabel.setFont(new Font(""));

    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
        scoreLabel.setBounds(40,40,100,20);
    }

    public JLabel getModeLabel() {
        return modeLabel;
    }

    public void setModeLabel(JLabel modeLabel) {
        this.modeLabel = modeLabel;
        modeLabel.setBounds(40,80,100,20);
    }
}
