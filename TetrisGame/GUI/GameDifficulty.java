package TetrisGame.GUI;

import javax.swing.*;

import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameDifficulty extends JFrame {
    public static ImageIcon imageIcon = new ImageIcon("TetrisGame/GUI/additionalFiles/GameIcon.png"); //game icon
    private GameThread gameThread;
    private GameFrame gameFrame;
    private GameArea gameArea;

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
            easy.setText("Too weak!");
            easy.setToolTipText("Easy mode");
            easy.setBounds(100,80,200,50);
            easy.setBackground(new Color(190,179,148));
            easy.setForeground(Color.white);
            easy.setFont(new Font("Monospaced",Font.PLAIN,30));
            easy.addActionListener(new gameModeEasy());
            JButton medium = new JButton();
            medium.setText("Basic~");
            medium.setToolTipText("Normal mode");
            medium.setBounds(100,150,200,50);
            medium.setBackground(new Color(175,220,235));
            medium.setForeground(Color.white);
            medium.setFont(new Font("Monospaced",Font.PLAIN,30));
            medium.addActionListener(new gameModeMedium());
            JButton hard = new JButton();
            hard.setText("WOW!");
            hard.setToolTipText("Hard mode");
            hard.setBounds(100,220,200,50);
            hard.setBackground(new Color(241,21,20));
            hard.setForeground(Color.white);
            hard.setFont(new Font("Monospaced",Font.PLAIN,30));
            hard.addActionListener(new gameModeHard());
            JButton god = new JButton();
            god.setText("U a GOD!");
            god.setToolTipText("GOD mode");
            god.setBounds(100,290,200,50);
            god.setBackground(Color.black);
            god.setForeground(Color.white);
            god.setFont(new Font("Monospaced",Font.PLAIN,30));
            god.addActionListener(new gameModeGod());
            this.add(easy);
            this.add(medium);
            this.add(hard);
            this.add(god);
        }
    }

    public class BackBtn extends JButton{
        ImageIcon img = new ImageIcon("TetrisGame/GUI/additionalFiles/BackBtnIcon.png ");
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
            gameThread = new GameThread(gameArea,gameFrame);
            gameThread.setSpeed(500);
            GameFrame gameFrame = new GameFrame();
            gameFrame.gameStart();
            GameFrame.modes("Too weak!");

            GameDifficulty.this.dispose();
        }
    }

    public class gameModeMedium implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameThread = new GameThread(gameArea,gameFrame);
            gameThread.setSpeed(250);
            GameFrame gameFrame = new GameFrame();
            gameFrame.gameStart();
            GameFrame.modes("Basic~");

            GameDifficulty.this.dispose();
        }
    }

    public class gameModeHard implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameThread = new GameThread(gameArea,gameFrame);
            gameThread.setSpeed(50);
            GameFrame gameFrame = new GameFrame();
            gameFrame.gameStart();
            GameFrame.modes("WOW!");

            GameDifficulty.this.dispose();
        }
    }

    private class gameModeGod implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            GameDifficulty.this.dispose();
            gameThread = new GameThread(gameArea,gameFrame);
            gameThread.setSpeed(25);
            GameFrame gameFrame = new GameFrame();
            gameFrame.gameStart();
            GameFrame.modes("U a GOD!");
//            Timer timer = new Timer(3000,e -> {
//                gameFrame.dispose();
//                System.out.println("You win!");
//            });
//            timer.start();
//            timer.setRepeats(false);
        }
    }
}
