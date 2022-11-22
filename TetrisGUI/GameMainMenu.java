package TetrisGUI;

import javax.swing.*;
import java.awt.*;

public class GameMainMenu extends JFrame {
    ImageIcon imageIcon = new ImageIcon("TetrisGUI/additionalFiles/GameIcon.png"); //game icon

    public GameMainMenu() {
        this.setTitle("Tetris 2.0");
        JLabel title = new titleLabel();
        JPanel bg = new JPanel();
        bg.setBackground(Color.black);
        JPanel titlePic = new TitlePanel();
        JButton start = new JButton("Start");
        start.setBounds(150,200,175,50);
        start.setBackground(Color.black);
        start.setForeground(Color.white);
        start.setFont(new Font("comic sans ms",Font.PLAIN,30));
        this.setContentPane(bg);
        this.setIconImage(imageIcon.getImage());
        this.add(title);
        this.add(titlePic);
        this.add(start);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    private static class TitlePanel extends JPanel
    {
        Image image;
        public TitlePanel()
        {
            this.setBounds(186,0,128,128);
            this.setBackground(new Color(0f,0f,0f,0.5f));
            try
            {
                image = Toolkit.getDefaultToolkit().createImage("TetrisGUI/additionalFiles/GameTitlePic.png");
            }
            catch (Exception e) { /*handled in paintComponent()*/ }
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if (image != null)
                g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
        }
    }
    private static class titleLabel extends JLabel{
        public titleLabel(){
            this.setText("<html><font color='#FD1C03'>T</font><font color='#FF6700'>e</font><font color='FFFF33'>t</font>" +
                    "<font color='#16F529'>r</font><font color='#1589FF'>i</font>" +
                    "<font color='7B00FF'>s</font> <font color='9D00FF'>2.0</font></html>");
            this.setBounds(65,108,470,100);
            this.setFont(new Font("comic sans ms",Font.BOLD+Font.ITALIC,70));

        }
    }
}
