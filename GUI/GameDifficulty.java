package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class GameDifficulty extends JFrame {
    public static ImageIcon imageIcon = new ImageIcon("GUI/additionalFiles/GameIcon.png"); //game icon

    public GameDifficulty(){
        this.setTitle("Tetris 2.0");
        JPanel colorBg = new JPanel();
        colorBg.setBackground(Color.black);
        this.setContentPane(colorBg);
        JButton backBtn = new BackBtn();
        this.add(backBtn);
        JPanel mainPanel = new ChoicePanel();
        this.add(mainPanel);
        this.setIconImage(imageIcon.getImage());
        this.setSize(500, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private class ChoicePanel extends JPanel{
        public ChoicePanel(){
            this.setBounds(50,50,400,400);
            this.setBackground(Color.black);
            this.setLayout(null);
            JLabel select = new JLabel();
            select.setText("SELECT MODE");
            select.setForeground(Color.white);
            select.setFont(new Font("comic sans ms",Font.BOLD+Font.ITALIC,40));
            select.setBounds(50,0,350,50);
            this.add(select);
            JButton easy = new JButton();
            easy.setText("Too easy!");
            easy.setToolTipText("Easy mode");
            easy.setBounds(100,80,200,50);
            easy.setBackground(new Color(190,179,148));
            easy.setForeground(Color.white);
            easy.setFont(new Font("Monospaced",Font.PLAIN,30));
            easy.addActionListener(new gameModeEasy());
            JButton medium = new JButton();
            medium.setText("Weak!");
            medium.setToolTipText("Normal mode");
            medium.setBounds(100,150,200,50);
            medium.setBackground(new Color(175,220,235));
            medium.setForeground(Color.white);
            medium.setFont(new Font("Monospaced",Font.PLAIN,30));
            medium.addActionListener(new gameModeMedium());
            JButton hard = new JButton();
            hard.setText("U a GOD!");
            hard.setToolTipText("Hard mode");
            hard.setBounds(100,220,200,50);
            hard.setBackground(new Color(241,21,20));
            hard.setForeground(Color.white);
            hard.setFont(new Font("Monospaced",Font.PLAIN,30));
            hard.addActionListener(new gameModeHard());
            this.add(easy);
            this.add(medium);
            this.add(hard);
        }
    }

    public class BackBtn extends JButton{
        ImageIcon img = new ImageIcon("GUI/additionalFiles/BackBtnIcon.png");
        public BackBtn(){
            this.setIcon(img);
            this.setBounds(0,10,50,50);
            this.setBackground(new Color(0f,0f,0f,0.5f));
            this.setFont(new Font("Monospaced",Font.PLAIN,6));
            this.setBorder(new LineBorder(Color.white));
            this.addActionListener(new BackToMainMenu());
        }
    }

    public class BackToMainMenu implements ActionListener
    {
        //@SuppressWarnings("deprecation")
        public void actionPerformed(ActionEvent action)
        {
            GameMainMenu gameMainMenu = new GameMainMenu();
            gameMainMenu.setVisible(true);

            GameDifficulty.this.dispose();
        }
    }

    public class gameModeEasy implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameThread gameThread = new GameThread(new GameArea());
            gameThread.setSpeed(1000);
            GameFrame gameFrame = new GameFrame();
            gameFrame.gameStart();

            GameDifficulty.this.dispose();
        }
    }

    public class gameModeMedium implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameThread gameThread = new GameThread(new GameArea());
            gameThread.setSpeed(400);
            GameFrame gameFrame = new GameFrame();
            gameFrame.gameStart();

            GameDifficulty.this.dispose();
        }
    }

    public class gameModeHard implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameThread gameThread = new GameThread(new GameArea());
            gameThread.setSpeed(50);
            GameFrame gameFrame = new GameFrame();
            gameFrame.gameStart();

            GameDifficulty.this.dispose();
        }
    }
}
