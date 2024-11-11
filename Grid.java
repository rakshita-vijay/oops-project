import java.awt.*;
import javax.swing.*;

public class Grid extends JFrame {
  Grid() {
    this.setTitle("Grid"); // title of the JFrame
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // swing does not have close by default, so cross button definition
    this.setLayout(null); // dunno what happens, supposed to be there
    this.setBounds(0, 20, 1400, 950); // x,y of screen; h,w of JFrame

    int rows = 40;
    int columns = 80;

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(rows, columns));
    panel.setBounds(30, 160, 1400, 700); // x,y WRT JFrame; h,w of entire JPanel (button / boxes)

    for (int i = 1; i <= (rows * columns); i++) { // i <= x, where x is the number of buttons needed
      JButton button = new JButton();
      panel.add(button);
    }
    this.add(panel, BorderLayout.CENTER); // BorderLayout.CENTER does not matter here

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // top strips

    JLayeredPane topStrip = new JLayeredPane();
    topStrip.setBounds(0, 0, 1500, 150);

    JPanel menuPanel = new JPanel();
    menuPanel.setBackground(Color.black);
    // menuPanel.setBackground(new Color(0, 0, 0, 128)); // 50% opacity
    menuPanel.setBounds(0, 40, 1500, 110);
    // this.add(menuPanel);
    topStrip.add(menuPanel);

    JPanel nameStrip = new JPanel();
    nameStrip.setBackground(Color.blue);
    nameStrip.setBounds(0, 0, 1500, 40);
    // this.add(nameStrip);
    topStrip.add(nameStrip);

    // logo and name

    JLabel nameText = new JLabel("Heim & Leben");
    nameText.setFont(new Font("Times New Roman", Font.BOLD, 20));
    nameText.setForeground(Color.WHITE);
    nameText.setBounds(50, 10, 200, 20);
    // this.add(nameText);
    topStrip.add(nameText, new Integer(1));

    ImageIcon logo = new ImageIcon("./images/image.png");
    JLabel logoLabel = new JLabel(logo);
    logoLabel.setBounds(10, 10, 20, 20);
    // this.add(logoLabel);
    topStrip.add(logoLabel, new Integer(1));

    this.add(topStrip);

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // bottom strip

    // JLayeredPane bottomStrip = new JLayeredPane();
    // bottomStrip.setBounds(0, 860, 1500, 35);

    // JPanel bottomBlueStrip = new JPanel();
    // bottomBlueStrip.setBounds(0, 860, 1500, 35);
    // bottomBlueStrip.setBackground(Color.blue);
    // bottomStrip.add(bottomBlueStrip);

    // JLabel copyrightText = new JLabel("Copyright ©VARS");
    // copyrightText.setFont(new Font("Times New Roman", Font.BOLD, 12));
    // copyrightText.setForeground(Color.WHITE);
    // copyrightText.setBounds(10, 860, 200, 20);
    // bottomStrip.add(copyrightText, new Integer(1));

    // this.add(bottomStrip);

    JPanel bottomBlueStrip = new JPanel();
    bottomBlueStrip.setBounds(0, 860, 1500, 35);
    bottomBlueStrip.setBackground(Color.blue);
    // bottomBlueStrip.setOpaque(false);
    this.add(bottomBlueStrip);

    JLabel copyrightText = new JLabel("Copyright ©VARS"); // not showing up - why??????
    copyrightText.setFont(new Font("Times New Roman", Font.BOLD, 12));
    copyrightText.setForeground(Color.pink);
    copyrightText.setBounds(10, 865, 500, 20);
    this.add(copyrightText, new Integer(1));

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // JButton menuBar = new JButton();

    this.setVisible(true);
  }
}
