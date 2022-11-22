package TetrisGUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class GameMainMenu extends JFrame {
    public GameMainMenu(){
        this.setTitle("Tetris 2.0");
        JPanel bgFrame = new BGPanel();
        this.add(new titleFonts());
        this.setContentPane(bgFrame);
        this.setSize(600,600);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private static class BGPanel extends JPanel
    {
        Image image;
        public BGPanel()
        {
            try
            {
                image = Toolkit.getDefaultToolkit().createImage("TetrisGUI/additionalFiles/GameMainMenuBG.jpg");
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
    //creating a font package for title
    //https://stackoverflow.com/questions/21081586/using-a-custom-font-for-a-jlabel
    private static class titleFonts extends JPanel {
        public titleFonts() {
            setLayout(null);
            this.setBounds(150,150,300,100);
            this.setBackground(new Color(0f,0f,0f,0.5f));
            try {
                Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("TetrisGUI/additionalFiles/TitleFont.ttf"));
                JLabel title = new JLabel("Tetris 2.0");
                title.setFont(font.deriveFont(Font.BOLD, 48f));
                title.setBounds(0,0,250,90);
                title.setBackground(new Color(0f,0f,0f,0.5f));
                this.add(title);
            } catch (FontFormatException | IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
