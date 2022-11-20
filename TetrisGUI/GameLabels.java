package TetrisGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class GameLabels extends JPanel {
    private JLabel scoreLabel;
    private JLabel modeLabel;
    private JComboBox<String> modeTypes;
    public GameLabels(){
        this.setBounds(650,50,200,150);
        this.setBackground(Color.white);
        Border borderLine = BorderFactory.createLineBorder(Color.black);
        this.setBorder(borderLine);
        this.setLayout(null);

        setScoreLabel(new JLabel());
        this.add(scoreLabel);
        setModeLabel(new JLabel());
        this.add(modeLabel);


    }

    public JComboBox<String> getModeTypes() {
        return modeTypes;
    }

    public void setModeTypes(JComboBox<String> modeTypes) {
        String[] choices = {"Too easy!","Weak","U a GOD!"};
        modeTypes = new JComboBox<>(choices);
        this.modeTypes = modeTypes;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        scoreLabel.setText("Score: 0");
        scoreLabel.setBounds(40,40,100,20);
        scoreLabel.setFont(new Font("Princetown LET",Font.BOLD,15));
        this.scoreLabel = scoreLabel;
    }

    public void setModeLabel(JLabel modeLabel) {
        modeLabel.setText("Mode: ");//too easy!  weak!  u a GOD!!!
        modeLabel.setFont(new Font("Princetown LET",Font.BOLD,15));
        modeLabel.setBounds(40,70,70,20);
        this.modeLabel = modeLabel;

    }
}
