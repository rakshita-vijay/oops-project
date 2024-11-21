import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Grid extends JFrame {
  Grid() {
    this.setTitle("Grid"); // title of the JFrame
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // swing does not have close by default, so cross button definition
    this.setLayout(null); // dunno what happens, supposed to be there
    this.setBounds(0, 20, 1400, 950); // x,y of screen; h,w of JFrame

    JLayeredPane finalLayer = new JLayeredPane();
    finalLayer.setBounds(0, 0, 1550, 950);

    JLayeredPane basicGrid = new JLayeredPane();
    basicGrid.setBounds(30, 160, 1400, 700);

    int rows = 35;
    int columns = 70;

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(rows, columns));
    panel.setBounds(0, 0, 1400, 700); // x,y WRT JFrame; h,w of entire JPanel (button / boxes)

    for (int i = 1; i <= (rows * columns); i++) { // i <= x, where x is the number of buttons needed
      JButton button = new JButton();
      panel.add(button);
    }

    basicGrid.add(panel, BorderLayout.CENTER);
    finalLayer.add(basicGrid);  // BorderLayout.CENTER does not matter here

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

    // room, window, furniture, and fixture buttons

    JButton roomLogo = new JButton();
    roomLogo.setBounds(20, 60, 70, 70);

    JLabel rl = new JLabel("R");
    rl.setFont(new Font("Times New Roman", Font.BOLD, 50));
    rl.setForeground(Color.black);
    rl.setBounds(70, 10, 50, 50);
    roomLogo.add(rl, BorderLayout.CENTER);

    JLabel rn = new JLabel("ROOM");
    rn.setFont(new Font("Times New Roman", Font.BOLD, 10));
    rn.setForeground(Color.black);
    rn.setBounds(5, 70, 70, 20);
    roomLogo.add(rn, BorderLayout.CENTER);

    topStrip.add(roomLogo, new Integer(2));

    JButton windowLogo = new JButton();
    windowLogo.setBounds(110, 60, 70, 70);

    JLabel wl = new JLabel("W");
    wl.setFont(new Font("Times New Roman", Font.BOLD, 50));
    wl.setForeground(Color.black);
    wl.setBounds(70, 10, 50, 50);
    windowLogo.add(wl, BorderLayout.CENTER);

    JLabel wn = new JLabel("WINDOW");
    wn.setFont(new Font("Times New Roman", Font.BOLD, 10));
    wn.setForeground(Color.black);
    wn.setBounds(5, 70, 70, 20);
    windowLogo.add(wn, BorderLayout.CENTER);

    topStrip.add(windowLogo, new Integer(2));

    JButton openingsLogo = new JButton();
    openingsLogo.setBounds(200, 60, 70, 70);

    JLabel ol = new JLabel("O");
    ol.setFont(new Font("Times New Roman", Font.BOLD, 50));
    ol.setForeground(Color.black);
    ol.setBounds(70, 10, 50, 50);
    openingsLogo.add(ol, BorderLayout.CENTER);

    JLabel on = new JLabel("OPENINGS");
    on.setFont(new Font("Times New Roman", Font.BOLD, 10));
    on.setForeground(Color.black);
    on.setBounds(5, 70, 70, 20);
    openingsLogo.add(on, BorderLayout.CENTER);

    topStrip.add(openingsLogo, new Integer(2));

    JButton fixturesLogo = new JButton();
    fixturesLogo.setBounds(290, 60, 70, 70);

    JLabel fl = new JLabel("F");
    fl.setFont(new Font("Times New Roman", Font.BOLD, 50));
    fl.setForeground(Color.black);
    fl.setBounds(70, 10, 50, 50);
    fixturesLogo.add(fl, BorderLayout.CENTER);

    JLabel fn = new JLabel("FIXTURES");
    fn.setFont(new Font("Times New Roman", Font.BOLD, 10));
    fn.setForeground(Color.black);
    fn.setBounds(5, 70, 70, 20);
    fixturesLogo.add(fn, BorderLayout.CENTER);

    topStrip.add(fixturesLogo, new Integer(2));

    finalLayer.add(topStrip);

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

    // finalLayer.add(bottomStrip);

    JPanel bottomBlueStrip = new JPanel();
    bottomBlueStrip.setBounds(0, 860, 1500, 35);
    bottomBlueStrip.setBackground(Color.blue);
    // bottomBlueStrip.setOpaque(false);
    finalLayer.add(bottomBlueStrip);

    JLabel copyrightText = new JLabel("Copyright ©VARS"); // not showing up - why??????
    copyrightText.setFont(new Font("Times New Roman", Font.BOLD, 12));
    copyrightText.setForeground(Color.WHITE);
    copyrightText.setBounds(10, 865, 500, 20);
    finalLayer.add(copyrightText, new Integer(1));

    this.add(finalLayer);

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    JLayeredPane setOfRooms = new JLayeredPane();
    setOfRooms.setBounds(30, 160, 1400, 700);

    JPanel room1 = new JPanel();
    room1.setBounds(50, 50, 100, 100);
    room1.setBackground(Color.red);
    room1.setBackground(new Color(100, 0, 0, 128));
    setOfRooms.add(room1);

    finalLayer.add(setOfRooms, new Integer(3));
    this.add(finalLayer);

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // JButton menuBar = new JButton();

    this.setVisible(true);
  }
}
