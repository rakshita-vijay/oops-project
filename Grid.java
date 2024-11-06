import java.awt.*;
import javax.swing.*;

public class Grid extends JFrame{
    Grid(){
        this.setTitle("Grid");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(40,40,400,400);
        this.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(30,60));
        panel.setBounds(150, 75, 1000, 500);
        for(int i = 1; i <= 1800; i++){
            JButton button = new JButton();
            panel.add(button);
        }
        this.add(panel, BorderLayout.CENTER);
    }

    public static void main(String args[]){
        new Grid();
    }
}
