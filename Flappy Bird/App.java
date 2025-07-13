package Project.FlappyBird;
import javax.swing.*;
public class App extends JFrame
{
    public static void main(String[] args) 
    {
        int boardWidth=360; 
        int boardHeight=640;

        JFrame frame = new JFrame("Flappy Bird By Manu Sharma");
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FB flappybird = new FB();
        frame.add(flappybird);
        frame.pack(); //Used this not to include the title bar of the window
        flappybird.requestFocus();
        frame.setVisible(true);


    }
}
