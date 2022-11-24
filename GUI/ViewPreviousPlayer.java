package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ViewPreviousPlayer extends JFrame {
    public static ImageIcon imageIcon = new ImageIcon("GUI/additionalFiles/GameIcon.png"); //game icon

    public ViewPreviousPlayer(){
        this.setTitle("Tetris 2.0");
        JPanel colorBg = new JPanel();
        colorBg.setBackground(Color.black);
        this.setContentPane(colorBg);
        JButton backBtn = new BackBtn();
        this.add(backBtn);
        JButton view = new JButton("View last Player");
        view.setToolTipText("See last player that played the game");
        view.setBounds(100,150,200,50);
        view.setBackground(new Color(90,89,79));
        view.setForeground(Color.white);
        view.setFont(new Font("Monospaced",Font.PLAIN,30));
        view.addActionListener(new ViewPlayer());
        this.add(view);
        this.setIconImage(imageIcon.getImage());
        this.setSize(500, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

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

            ViewPreviousPlayer.this.dispose();
        }
    }

    public class ViewPlayer implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                File myObj = new File("GUI/additionalFiles/LastPlayer.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    JOptionPane.showMessageDialog(null,
                            "This is the 5 previous player that played Tetris 2.0:\n"+data,"Tetris 2.0",
                            JOptionPane.INFORMATION_MESSAGE,imageIcon);
                }
                myReader.close();
            } catch (FileNotFoundException exception) {
                System.out.println("An error occurred.");
                exception.printStackTrace();
            }
        }
    }
}
