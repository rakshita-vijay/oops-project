import javax.swing.;
import java.awt.;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
//Updated on 22nd November, 18:04
public class Grid extends JFrame{
JFrame project = new JFrame();
public boolean Overlap(JPanel room1, JPanel room2) {
    Rectangle bounds1 = room1.getBounds();
    Rectangle bounds2 = room2.getBounds();

    return bounds1.intersects(bounds2);
}

public boolean Overlap(JLabel furniture1, JLabel furniture2) {

    Rectangle bounds1 = furniture1.getBounds();
    Rectangle bounds2 = furniture2.getBounds();

    return bounds1.intersects(bounds2);
}

public boolean Overlap(JPanel room, JLabel furniture) {
    if (furniture.getX() > room.getX() && furniture.getX() < room.getX() + room.getWidth() &&
            furniture.getX() + furniture.getWidth() > room.getX() && furniture.getX() + furniture.getWidth() < room.getX() + room.getWidth() &&
            furniture.getY() > room.getY() && furniture.getY() < room.getY() + room.getHeight() &&
            furniture.getY() + furniture.getHeight() > room.getY() && furniture.getY() + furniture.getHeight() < room.getY() + room.getHeight()) {
        return false;
    } else {
        return ((furniture.getX() < room.getX() + room.getWidth() && furniture.getX() > room.getX() &&
                furniture.getY() < room.getY() + room.getHeight() && furniture.getY() > room.getY()) ||
                (furniture.getX() + furniture.getWidth() > room.getX() && furniture.getX() + furniture.getWidth() < room.getX() + room.getWidth() &&
                        furniture.getY() + furniture.getHeight() > room.getY() && furniture.getY() + furniture.getHeight() < room.getY() + room.getHeight()) ||
                (furniture.getX() < room.getX() + room.getWidth() && furniture.getX() > room.getX() &&
                        furniture.getY() + furniture.getHeight() < room.getY() + room.getHeight() && furniture.getY() + furniture.getHeight() > room.getY()) ||
                (furniture.getX() + furniture.getWidth() < room.getX() + room.getWidth() && furniture.getX() + furniture.getWidth() > room.getX() &&
                        furniture.getY() < room.getY() + room.getHeight() && furniture.getY() > room.getY()) ||
                (furniture.getX() < room.getX() && furniture.getX() + furniture.getWidth() > room.getX() + room.getWidth() &&
                        furniture.getY() > room.getY() && furniture.getY() + furniture.getHeight() < room.getY() + room.getHeight()) ||
                (furniture.getX() > room.getX() && furniture.getX() + furniture.getWidth() < room.getX() + room.getWidth() &&
                        furniture.getY() < room.getY() && furniture.getY() + furniture.getHeight() > room.getY() + room.getHeight()) ||
                (furniture.getX() < room.getX() && furniture.getX() + furniture.getWidth() > room.getX() + room.getWidth() &&
                        furniture.getY() < room.getY() && furniture.getY() + furniture.getHeight() > room.getY() + room.getHeight())
        );
    }
}

public boolean forHoriWindow(JLabel window,ArrayList<Point[]>setOfBorders){
    boolean isOn = false;
    System.out.println(setOfBorders.size());
    for(int i=0;i<setOfBorders.size();i++){
        System.out.println(setOfBorders.get(i)[0].toString() + "and " + setOfBorders.get(i)[1].toString() );
        if(window.getX()>setOfBorders.get(i)[0].getX() && (window.getX() + window.getWidth())<setOfBorders.get(i)[1].getX() && window.getY() == setOfBorders.get(i)[0].getY() && setOfBorders.get(i)[0].getY() == setOfBorders.get(i)[1].getY()){
            isOn = true;
            System.out.println("horiwin");
            break;
        }
    }
    return isOn;
}

public boolean forVertiWindow(JLabel window,ArrayList<Point[]>setOfBorders ){
    boolean isOn = false;
    for(int i=0;i<setOfBorders.size();i++){
        System.out.println(setOfBorders.get(i)[0].toString() + "and " + setOfBorders.get(i)[1].toString() );
        if(window.getY()>setOfBorders.get(i)[1].getY() && (window.getY()+window.getHeight())<setOfBorders.get(i)[0].getY()&& window.getX()==setOfBorders.get(i)[0].getX() && setOfBorders.get(i)[0].getX()==setOfBorders.get(i)[1].getX()){
            isOn=true;
            break;
        }
    }
    return isOn;
}

public boolean forHoriDoor(JLabel door,ArrayList<Point[]> setOfEdges){
    boolean isOn = false;
    for(int i=0;i<setOfEdges.size();i++){
        if(door.getX()>setOfEdges.get(i)[0].getX() && (door.getX()+door.getWidth())<setOfEdges.get(i)[1].getX() && door.getY()==setOfEdges.get(i)[0].getY() && setOfEdges.get(i)[0].getY() == setOfEdges.get(i)[1].getY() ){
            isOn =true;
        }
    }
    return isOn;
}

public boolean forVertiDoor(JLabel door,ArrayList<Point[]> setOfEdges){
    boolean isOn = false;
    for(int i=0;i<setOfEdges.size();i++){
        if(door.getY()>setOfEdges.get(i)[1].getY() && (door.getY()+ door.getWidth())<setOfEdges.get(i)[0].getY() && door.getX()==setOfEdges.get(i)[0].getX()&& setOfEdges.get(i)[0].getY()==setOfEdges.get(i)[1].getY()){
            isOn = true;
        }
    }
    return isOn;
}



Grid() {
    project.setTitle("Grid"); // title of the JFrame
    project.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // swing does not have close by default, so cross button definition
    project.setLayout(null); // dunno what happens, supposed to be there
    project.setBounds(0, 20, 1400, 950); // x,y of screen; h,w of JFrame

    JLayeredPane finalLayer = new JLayeredPane();
    finalLayer.setBounds(0, 0, 1550, 950);

    JLayeredPane basicGrid = new JLayeredPane();
    basicGrid.setBounds(30, 160, 1400, 700);

    int rows = 30;
    int columns = 75;
    ArrayList<JPanel> rooms = new ArrayList<>();
    ArrayList<JLabel> furnitures = new ArrayList<>();

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(rows, columns));
    panel.setBounds(0, 0, 1500, 600); // x,y WRT JFrame; h,w of entire JPanel (button / boxes)

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
    topStrip.add(nameText, Integer.valueOf(1));

    ImageIcon logo = new ImageIcon("images/image_blue.png");
    JLabel logoLabel = new JLabel(logo);
    logoLabel.setBounds(10, 10, 20, 20);
    // this.add(logoLabel);
    topStrip.add(logoLabel, Integer.valueOf(1));

    // room, opening, furniture, and fixture buttons
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

    JLayeredPane setOfRooms = new JLayeredPane();
    setOfRooms.setBounds(30, 160, 1400, 700);
    JLayeredPane setOfFurniture = new JLayeredPane();
    setOfFurniture.setBounds(30, 160, 1400, 700);
    JLayeredPane setOfFixtures = new JLayeredPane();
    setOfFixtures.setBounds(30, 160, 1400, 700);

    JLayeredPane setOfOpenings = new JLayeredPane();
    setOfOpenings.setBounds(30, 160, 1400, 700);

    Point[] cornersOfOneRoom = new Point[4];
    ArrayList<Point[]> setOfCornersOfAllRooms = new ArrayList<Point[]>();
    ArrayList<Point[]> setOfEdges = new ArrayList<Point[]>();
    ArrayList<Point[]>setOfBorders = new ArrayList<Point[]>();
    Point [][] setOfRoomEdges = new Point[4][2];

    roomLogo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] roomList = {"Living room", "Bedroom", "Kitchen", "Bathroom"};
            //Dialog box for the user to choose what type of room he's adding
            int selection = JOptionPane.showOptionDialog(project, "Select the room you would like to add", "Room selector", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, roomList, roomList[0]);
            Color color = new Color(0, 100, 0, 128);
            //Setting the color of the room depending on what is selected by the user
            switch (selection){
                case 0:
                    break;
                case 1:
                    color = new Color(100, 0, 0, 128);
                    break;
                case 2:
                    color = new Color(100, 100, 0, 128);
                    break;
                case 3:
                    color = new Color(0, 0, 100, 128);
                    break;
            }
            //Dialog box for the coordinates of the room
            if (selection >= 0 && selection <= 3){
                JTextField xCoord = new JTextField(5);
                xCoord.setSize(50, 30);
                JTextField yCoord = new JTextField(5);
                yCoord.setSize(50, 30);
                JTextField height = new JTextField(5);
                height.setSize(50, 30);
                JTextField width = new JTextField(5);
                width.setSize(50, 30);
                JPanel dialogPanel = new JPanel();
                dialogPanel.add(new JLabel("x: "));
                dialogPanel.add(xCoord);
                dialogPanel.add(Box.createHorizontalStrut(15));
                dialogPanel.add(new JLabel("y: "));
                dialogPanel.add(yCoord);
                dialogPanel.add(Box.createHorizontalStrut(15));
                dialogPanel.add(new JLabel("Height: "));
                dialogPanel.add(height);
                dialogPanel.add(Box.createHorizontalStrut(15));
                dialogPanel.add(new JLabel("Width: "));
                dialogPanel.add(width);
                int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter coordinates of your room", JOptionPane.OK_CANCEL_OPTION);
                JPanel newRoom = new JPanel();
                int xCoordinate = Integer.parseInt(xCoord.getText());
                int yCoordinate = Integer.parseInt(yCoord.getText());
                int intWidth = Integer.parseInt(width.getText());
                int intHeight = Integer.parseInt(height.getText());
                if (option == JOptionPane.OK_OPTION){
                    try {
                        newRoom.setBounds(Integer.parseInt(xCoord.getText()), Integer.parseInt(yCoord.getText()), Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
                        newRoom.setBackground(color);
                        newRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                        boolean overlaps = false;
                        //Iterates over every already existing room and checks for overlaps
                        for(JPanel i : rooms){
                            if (Overlap(i, newRoom)){
                                overlaps = true;
                                break;
                            }
                        }
                        if (overlaps){
                            JOptionPane.showMessageDialog(project, "This room overlaps with an already existing room", "Alert", JOptionPane.WARNING_MESSAGE);
                        } else {
                            for (JLabel i : furnitures){
                                if (Overlap(newRoom, i)){
                                    overlaps = true;
                                    break;
                                }
                            }
                            if (overlaps) {
                                JOptionPane.showMessageDialog(project, "This room overlaps with an already existing furniture item", "Alert", JOptionPane.WARNING_MESSAGE);
                            } else if (newRoom.getX() < 0 || newRoom.getY() < 0 || newRoom.getX() + newRoom.getWidth() > 1500 || newRoom.getY() + newRoom.getHeight() > 600){
                                JOptionPane.showMessageDialog(project, "This room exceeds the bounds of the floor ((0, 0) to (1500, 600))", "Alert", JOptionPane.WARNING_MESSAGE);
                            } else {
                                setOfRooms.add(newRoom);
                                rooms.add(newRoom);
                                finalLayer.add(setOfRooms, Integer.valueOf(3));
                                cornersOfOneRoom[0]= new Point(xCoordinate,yCoordinate);
                                cornersOfOneRoom[1]= new Point(xCoordinate + intWidth, yCoordinate);
                                cornersOfOneRoom[2]= new Point(xCoordinate + intWidth,yCoordinate+intHeight);
                                cornersOfOneRoom[3]= new Point(xCoordinate,yCoordinate+intHeight);
                                setOfCornersOfAllRooms.add(cornersOfOneRoom);//adding the corners of one room to the larger array


                                //Edges and borders go from left to right and down to up(in the conventional coordinate system)
                                Point[] edge1 =  {cornersOfOneRoom[0],cornersOfOneRoom[1]};
                                setOfEdges.add(edge1);

                                setOfRoomEdges[0] = edge1;
                                Point[] edge2 =  {cornersOfOneRoom[2],cornersOfOneRoom[1]};
                                setOfEdges.add(edge2);
                                setOfRoomEdges[1] = edge2;
                                Point[] edge3 =  {cornersOfOneRoom[3],cornersOfOneRoom[2]};
                                setOfEdges.add(edge3);
                                setOfRoomEdges[2] = edge3;
                                Point[] edge4 =  {cornersOfOneRoom[3],cornersOfOneRoom[0]};
                                setOfEdges.add(edge4);
                                setOfRoomEdges[3] = edge4;


                                if(setOfBorders.size()==0){
                                    for(int i=0;i<4;i++){
                                        setOfBorders.add(setOfRoomEdges[i]);
                                    }
                                }



                                else{
                                    for(int edgeInRoom=0;edgeInRoom<4;edgeInRoom++){
                                        for(int border=0;border<setOfBorders.size();border++){
                                          if(setOfRoomEdges[edgeInRoom][0].getY()==setOfBorders.get(border)[0].getY() &&
                                          setOfRoomEdges[edgeInRoom][0].getY()==setOfRoomEdges[edgeInRoom][1].getY() && setOfBorders.get(border)[0].getY()==setOfBorders.get(border)[1].getY() ){//The edge and the border are both horizontal, on the same level
                                              System.out.println("Entered case where both are horizontal, on the same line");
                                              if(setOfRoomEdges[edgeInRoom][0].getX()<setOfBorders.get(border)[0].getX() && setOfRoomEdges[edgeInRoom][1].getX()>setOfBorders.get(border)[1].getX()){
                                                  System.out.println("Entered case where edge is completely inside border ");
                                                  setOfBorders.remove(border);
                                                  Point[] tempbord1 = {setOfRoomEdges[edgeInRoom][0],setOfBorders.get(border)[0]};
                                                  setOfBorders.add(tempbord1);
                                                  Point[] tempbord2 = {setOfBorders.get(border)[1],setOfRoomEdges[edgeInRoom][1]};
                                                  setOfBorders.add(tempbord2);

                                              }
                                              //2
                                              else if(setOfRoomEdges[edgeInRoom][0].getX()==setOfBorders.get(border)[1].getX() || setOfRoomEdges[edgeInRoom][1].getX()==setOfBorders.get(border)[0].getX()){//attached to each other at the vertices
                                                  System.out.println("Entered case where they are continuing from each other");
                                                  setOfBorders.add(setOfRoomEdges[edgeInRoom]);
                                              }
                                              //3
                                              else if(setOfRoomEdges[edgeInRoom][0].getX()<setOfBorders.get(border)[0].getX() && setOfRoomEdges[edgeInRoom][1].getX()<setOfBorders.get(border)[1].getX()){
                                                  System.out.println("Entered case where they are discongrous");
                                                  setOfBorders.remove(border);
                                                  Point[] tempbord1 = {setOfRoomEdges[edgeInRoom][0],setOfBorders.get(border)[0]};
                                                  Point[] tempbord2 = {setOfRoomEdges[edgeInRoom][1],setOfBorders.get(border)[1]};

                                                  setOfBorders.add(tempbord1);
                                                  setOfBorders.add(tempbord2);
                                              }
                                              //4
                                              else if(setOfRoomEdges[edgeInRoom][0].getX()>setOfBorders.get(border)[0].getX() && setOfRoomEdges[edgeInRoom][1].getX()>setOfBorders.get(border)[1].getX()){
                                                  System.out.println("Bhaad me ja laude");
                                                  Point[] tempbord1 = {setOfBorders.get(border)[0],setOfRoomEdges[edgeInRoom][0]};
                                                  Point[] tempbord2 = {setOfBorders.get(border)[1],setOfRoomEdges[edgeInRoom][1]};
                                                  setOfBorders.add(tempbord1);
                                                  setOfBorders.add(tempbord2);


                                              }
                                              //5
                                              else{//The edges are just completely apart; so the new edge will become a border, too// or do i just leave it alone, because we're not sure if there's another border that's overlapping
                                                  setOfBorders.add(setOfRoomEdges[edgeInRoom]);
                                                  System.out.println("Entered case where both are separate");
                                              }
                                          }

                                          else if(setOfRoomEdges[edgeInRoom][0].getX()==setOfBorders.get(border)[0].getX()&& setOfRoomEdges[edgeInRoom][0].getX()==setOfRoomEdges[edgeInRoom][1].getX() && setOfBorders.get(border)[0].getX()==setOfBorders.get(border)[1].getX()){//border and edge on the same vertical line
                                              //1
                                              System.out.println("second main case entered");
                                              if(setOfRoomEdges[edgeInRoom][0].getY()<=setOfBorders.get(border)[0].getY() && setOfRoomEdges[edgeInRoom][1].getY()>setOfBorders.get(border)[1].getY()){
                                                  setOfBorders.remove(border);
                                                  Point[] tempbord1 = {setOfRoomEdges[edgeInRoom][0],setOfBorders.get(border)[0]};
                                                  setOfBorders.add(tempbord1);
                                                  Point[] tempbord2 = {setOfBorders.get(border)[1],setOfRoomEdges[edgeInRoom][1]};
                                                  setOfBorders.add(tempbord2);
                                              }
                                              //2
                                              else if(setOfRoomEdges[edgeInRoom][0].getY()==setOfBorders.get(border)[1].getY() || setOfRoomEdges[edgeInRoom][1].getY()==setOfBorders.get(border)[0].getY()){//attached to each other at the vertices
                                                  setOfBorders.add(setOfRoomEdges[edgeInRoom]);
                                              }
                                              //3
                                              else if(setOfRoomEdges[edgeInRoom][0].getY()<setOfBorders.get(border)[0].getY() && setOfRoomEdges[edgeInRoom][1].getY()<setOfBorders.get(border)[1].getY()){
                                                  Point[] tempbord1 = {setOfRoomEdges[edgeInRoom][0],setOfBorders.get(border)[0]};
                                                  Point[] tempbord2 = {setOfRoomEdges[edgeInRoom][1],setOfBorders.get(border)[1]};

                                                  setOfBorders.add(tempbord1);
                                                  setOfBorders.add(tempbord2);

                                              }
                                              //4
                                              else if(setOfRoomEdges[edgeInRoom][0].getY()>setOfBorders.get(border)[0].getY() && setOfRoomEdges[edgeInRoom][1].getY()>setOfBorders.get(border)[1].getY()){
                                                  Point[] tempbord1 = {setOfBorders.get(border)[0],setOfRoomEdges[edgeInRoom][0]};
                                                  Point[] tempbord2 = {setOfBorders.get(border)[1],setOfRoomEdges[edgeInRoom][1]};
                                                  setOfBorders.add(tempbord1);
                                                  System.out.println(setOfBorders);
                                                  setOfBorders.add(tempbord2);
                                                  System.out.println(setOfBorders);

                                              }

                                              else{//The edges are just completely apart; so the new edge will become a border, too.
                                                  setOfBorders.add(setOfRoomEdges[edgeInRoom]);
                                              }

                                          }


                                          else{
                                              setOfBorders.add(setOfRoomEdges[edgeInRoom]);
                                              System.out.println("Main Case 3 entered");
                                          }


                                        }

                                    }
                                }






                                if (selection == 0 || selection == 2){
                                    int a = JOptionPane.showConfirmDialog(project, "Would you like to add a door from this room?");
                                    if (a == JOptionPane.YES_OPTION){
                                        //door adding code goes here
                                    }
                                }
                            }//biggest else ends here
                        }
                    } catch (NumberFormatException ex){
                        //Shows a warning dialog box if the values entered aren't numeric
                        JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                    Point[] initialClick = {null};
                    final Point[] initialLocation = new Point[1];
                    newRoom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            initialClick[0] = e.getPoint();
                            initialLocation[0] = newRoom.getLocation();
                        }

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            String[] options = {"Delete", "Add a room relative"};
                            int selection = JOptionPane.showOptionDialog(project, "What would you like to do with this room?", "Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if (selection == 0){
                                setOfRooms.remove(newRoom);
                                finalLayer.add(setOfRooms, Integer.valueOf(3));
                            }
                            if (selection == 1){
                                JPanel newerRoom = new JPanel();
                                String[] directions = {"North", "East", "South", "West"};
                                int a = JOptionPane.showOptionDialog(project, "Select the direction of the new room", "Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, directions, directions[0]);
                                if (a == 0){
                                    JTextField height = new JTextField(5);
                                    height.setSize(50, 30);
                                    JPanel dialogPanel = new JPanel();
                                    dialogPanel.add(new JLabel("Height: "));
                                    dialogPanel.add(height);
                                    int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter the height of your room", JOptionPane.OK_CANCEL_OPTION);
                                    if (option == JOptionPane.OK_OPTION){
                                        try {
                                            newerRoom.setBounds(newRoom.getX(), newRoom.getY() - Integer.parseInt(height.getText()), newRoom.getWidth(), Integer.parseInt(height.getText()));
                                            newerRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                                        } catch (NumberFormatException ex){
                                            //Shows a warning dialog box if the values entered aren't numeric
                                            JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                }
                                else if (a == 1){
                                    JTextField width = new JTextField(5);
                                    width.setSize(50, 30);
                                    JPanel dialogPanel = new JPanel();
                                    dialogPanel.add(new JLabel("Width: "));
                                    dialogPanel.add(width);
                                    int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter the width of your room", JOptionPane.OK_CANCEL_OPTION);
                                    if (option == JOptionPane.OK_OPTION){
                                        try {
                                            newerRoom.setBounds(newRoom.getX() + newRoom.getWidth(), newRoom.getY(), Integer.parseInt(width.getText()), newRoom.getHeight());
                                            newerRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                                        } catch (NumberFormatException ex){
                                            //Shows a warning dialog box if the values entered aren't numeric
                                            JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                }
                                else if (a == 2){
                                    JTextField height = new JTextField(5);
                                    height.setSize(50, 30);
                                    JPanel dialogPanel = new JPanel();
                                    dialogPanel.add(new JLabel("Height: "));
                                    dialogPanel.add(height);
                                    int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter the height of your room", JOptionPane.OK_CANCEL_OPTION);
                                    if (option == JOptionPane.OK_OPTION){
                                        try {
                                            newerRoom.setBounds(newRoom.getX(), newRoom.getY() + newRoom.getHeight(), newRoom.getWidth(), Integer.parseInt(height.getText()));
                                            newerRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                                        } catch (NumberFormatException ex){
                                            //Shows a warning dialog box if the values entered aren't numeric
                                            JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                }
                                else if (a == 3){
                                    JTextField width = new JTextField(5);
                                    width.setSize(50, 30);
                                    JPanel dialogPanel = new JPanel();
                                    dialogPanel.add(new JLabel("Width: "));
                                    dialogPanel.add(width);
                                    int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter the width of your room", JOptionPane.OK_CANCEL_OPTION);
                                    if (option == JOptionPane.OK_OPTION){
                                        try {
                                            newerRoom.setBounds(newRoom.getX() - Integer.parseInt(width.getText()), newRoom.getY(), Integer.parseInt(width.getText()), newRoom.getHeight());
                                            newerRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                                        } catch (NumberFormatException ex){
                                            //Shows a warning dialog box if the values entered aren't numeric
                                            JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                }
                                String[] roomList = {"Living room", "Bedroom", "Kitchen", "Bathroom"};
                                int c = JOptionPane.showOptionDialog(project, "Select the room you would like to add", "Room selector", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, roomList, roomList[0]);
                                Color color = new Color(0, 100, 0, 128);
                                //Setting the color of the room depending on what is selected by the user
                                switch (c){
                                    case 0:
                                        break;
                                    case 1:
                                        color = new Color(100, 0, 0, 128);
                                        break;
                                    case 2:
                                        color = new Color(100, 100, 0, 128);
                                        break;
                                    case 3:
                                        color = new Color(0, 0, 100, 128);
                                        break;
                                }
                                newerRoom.setBackground(color);
                                boolean overlaps = false;
                                //Iterates over every already existing room and checks for overlaps
                                for(JPanel i : rooms){
                                    if (Overlap(i, newerRoom)){
                                        overlaps = true;
                                        break;
                                    }
                                }
                                if (overlaps){
                                    JOptionPane.showMessageDialog(project, "This room overlaps with an already existing room", "Alert", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    for (JLabel i : furnitures){
                                        if (Overlap(newerRoom, i)){
                                            overlaps = true;
                                            break;
                                        }
                                    }
                                    if (overlaps) {
                                        JOptionPane.showMessageDialog(project, "This room overlaps with an already existing furniture item", "Alert", JOptionPane.WARNING_MESSAGE);
                                    } else if (newerRoom.getX() < 0 || newerRoom.getY() < 0 || newerRoom.getX() + newerRoom.getWidth() > 1500 || newerRoom.getY() + newerRoom.getHeight() > 600){
                                        JOptionPane.showMessageDialog(project, "This room exceeds the bounds of the floor ((0, 0) to (1500, 600))", "Alert", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        setOfRooms.add(newerRoom);
                                        rooms.add(newerRoom);
                                        finalLayer.add(setOfRooms, Integer.valueOf(3));
                                    }
                                }
                            }
                        }
                    });

                    newRoom.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            if (initialClick[0] == null) return;

                            // Get the panel's current location
                            Point panelLocation = newRoom.getLocation();

                            // Calculate the new location
                            int newX = panelLocation.x + e.getX() - initialClick[0].x;
                            int newY = panelLocation.y + e.getY() - initialClick[0].y;

                            // Move the panel to the new location
                            newRoom.setLocation(newX, newY);
                        }
                    });

                    newRoom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            boolean overlaps = false;
                            for(JPanel i : rooms){
                                if (Overlap(i, newRoom)){
                                    overlaps = true;
                                    break;
                                }
                            }
                            if (overlaps){
                                JOptionPane.showMessageDialog(project, "You cannot move your room here", "Alert", JOptionPane.WARNING_MESSAGE);
                                newRoom.setLocation(initialLocation[0]);
                            } else {
                                for (JLabel i : furnitures){
                                    if (Overlap(newRoom, i)){
                                        overlaps = true;
                                        break;
                                    }
                                }
                                if (overlaps) {
                                    JOptionPane.showMessageDialog(project, "This room overlaps with an already existing furniture item", "Alert", JOptionPane.WARNING_MESSAGE);
                                    newRoom.setLocation(initialLocation[0]);
                                } else if (newRoom.getX() < 0 || newRoom.getY() < 0 || newRoom.getX() + newRoom.getWidth() > 1500 || newRoom.getY() + newRoom.getHeight() > 600){
                                    JOptionPane.showMessageDialog(project, "This room exceeds the bounds of the floor ((0, 0) to (1500, 600))", "Alert", JOptionPane.WARNING_MESSAGE);
                                    newRoom.setLocation(initialLocation[0]);
                                }
                            }
                        }
                    });
                }
            }
        }
    });

    topStrip.add(roomLogo, Integer.valueOf(2));

    JButton furnitureLogo = new JButton();
    furnitureLogo.setBounds(110, 60, 70, 70);

    JLabel wl = new JLabel("F");
    wl.setFont(new Font("Times New Roman", Font.BOLD, 50));
    wl.setForeground(Color.black);
    wl.setBounds(70, 10, 50, 50);
    furnitureLogo.add(wl, BorderLayout.CENTER);

    JLabel wn = new JLabel("FURNITURE");
    wn.setFont(new Font("Times New Roman", Font.BOLD, 10));
    wn.setForeground(Color.black);
    wn.setBounds(5, 70, 70, 20);
    furnitureLogo.add(wn, BorderLayout.CENTER);

    topStrip.add(furnitureLogo, Integer.valueOf(2));

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

    topStrip.add(openingsLogo, Integer.valueOf(2));

    furnitureLogo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] furnitureList = {"Table", "Couch", "Chair", "Bed", "Dining Set"};
            ImageIcon imageIcon = new ImageIcon("images/table.png");
            int selection = JOptionPane.showOptionDialog(project, "Select the type of furniture you would like to add", "Furniture selector", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, furnitureList, furnitureList[0]);
            imageIcon = switch (selection) {
                case 0 -> new ImageIcon("images/table.png");
                case 1 -> new ImageIcon("images/couch.png");
                case 2 -> new ImageIcon("images/chair.png");
                case 3 -> new ImageIcon("images/bed.png");
                case 4 -> new ImageIcon("images/dining_set.png");
                default -> imageIcon;
            };
            int width = switch (selection) {
                case 0 -> 65;
                case 1 -> 85;
                case 2 -> 20;
                case 3 -> 65;
                case 4 -> 55;
                default -> 65;
            };
            int height = switch (selection) {
                case 0 -> 40;
                case 1 -> 35;
                case 2 -> 25;
                case 3 -> 80;
                case 4 -> 70;
                default -> 40;
            };
            JTextField xCoord = new JTextField(5);
            xCoord.setSize(50, 30);
            JTextField yCoord = new JTextField(5);
            yCoord.setSize(50, 30);
            JPanel dialogPanel = new JPanel();
            dialogPanel.add(new JLabel("x: "));
            dialogPanel.add(xCoord);
            dialogPanel.add(Box.createHorizontalStrut(15));
            dialogPanel.add(new JLabel("y: "));
            dialogPanel.add(yCoord);
            int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter coordinates of your furniture", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION){
                /*Image image = imageIcon.getImage();
                Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                JLabel furniture = new JLabel(resizedIcon);
                furniture.setBounds(Integer.parseInt(xCoord.getText()), Integer.parseInt(yCoord.getText()), width, height);
                setOfFurniture.add(furniture);
                finalLayer.add(setOfFurniture, Integer.valueOf(3));*/
                try {
                    Image image = imageIcon.getImage();
                    Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    JLabel furniture = new JLabel(resizedIcon);
                    furniture.setBounds(Integer.parseInt(xCoord.getText()), Integer.parseInt(yCoord.getText()), width, height);
                    boolean overlaps = false;
                    //Iterates over every already existing room and checks for overlaps
                    for(JPanel i : rooms){
                        if (Overlap(i, furniture)){
                            overlaps = true;
                            break;
                        }
                    }
                    if (overlaps){
                        JOptionPane.showMessageDialog(project, "This furniture item overlaps with the walls of an already existing room", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        for (JLabel i : furnitures){
                            if (Overlap(i, furniture)){
                                overlaps = true;
                                break;
                            }
                        }
                        if (overlaps){
                            JOptionPane.showMessageDialog(project, "This furniture item overlaps with an already existing furniture item or fixture", "Alert", JOptionPane.WARNING_MESSAGE);
                        } else if (furniture.getX() < 0 || furniture.getY() < 0 || furniture.getX() + furniture.getWidth() > 1500 || furniture.getY() + furniture.getX() > 600){
                            JOptionPane.showMessageDialog(project, "This furniture item exceeds the bounds of the floor ((0, 0) to (1500, 600))", "Alert", JOptionPane.WARNING_MESSAGE);
                        } else {
                            setOfFurniture.add(furniture);
                            furnitures.add(furniture);
                            furniture.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    int a = JOptionPane.showConfirmDialog(project, "Would you like to delete this item?");
                                    if (a == JOptionPane.YES_OPTION){
                                        setOfFurniture.remove(furniture);
                                        furnitures.remove(furniture);
                                        finalLayer.add(setOfFurniture, Integer.valueOf(3));
                                    }
                                }
                            });
                            finalLayer.add(setOfFurniture, Integer.valueOf(3));
                        }
                    }
                } catch (NumberFormatException ex){
                    //Shows a warning dialog box if the values entered aren't numeric
                    JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    });

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

    topStrip.add(fixturesLogo, Integer.valueOf(2));

    fixturesLogo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] fixtureList = {"Sink", "Commode", "Bathtub", "Stove", "Wash basin"};
            ImageIcon imageIcon = new ImageIcon("images/sink.png");
            int selection = JOptionPane.showOptionDialog(project, "Select the type of fixture you would like to add", "Fixture selector", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, fixtureList, fixtureList[0]);
            imageIcon = switch (selection) {
                case 0 -> new ImageIcon("images/sink.png");
                case 1 -> new ImageIcon("images/commode.png");
                case 2 -> new ImageIcon("images/bathtub.png");
                case 3 -> new ImageIcon("images/stove.png");
                case 4 -> new ImageIcon("images/washbasin.png");
                default -> imageIcon;
            };
            int width = switch (selection) {
                case 0 -> 30;
                case 1 -> 35;
                case 2 -> 60;
                case 3 -> 40;
                case 4 -> 30;
                default -> throw new IllegalStateException("Unexpected value: " + selection);
            };
            int height = switch (selection) {
                case 0 -> 30;
                case 1 -> 45;
                case 2 -> 80;
                case 3 -> 40;
                case 4 -> 35;
                default -> throw new IllegalStateException("Unexpected value: " + selection);
            };
            JTextField xCoord = new JTextField(5);
            xCoord.setSize(50, 30);
            JTextField yCoord = new JTextField(5);
            yCoord.setSize(50, 30);
            JPanel dialogPanel = new JPanel();
            dialogPanel.add(new JLabel("x: "));
            dialogPanel.add(xCoord);
            dialogPanel.add(Box.createHorizontalStrut(15));
            dialogPanel.add(new JLabel("y: "));
            dialogPanel.add(yCoord);
            int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter coordinates of your fixture", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION){
                try {
                    Image image = imageIcon.getImage();
                    Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    JLabel fixture = new JLabel(resizedIcon);
                    fixture.setBounds(Integer.parseInt(xCoord.getText()), Integer.parseInt(yCoord.getText()), width, height);
                    boolean overlaps = false;
                    //Iterates over every already existing room and checks for overlaps
                    for(JPanel i : rooms){
                        if (Overlap(i, fixture)){
                            overlaps = true;
                            break;
                        }
                    }
                    if (overlaps){
                        JOptionPane.showMessageDialog(project, "This fixture overlaps with the walls of an already existing room", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        for (JLabel i : furnitures){
                            if (Overlap(i, fixture)){
                                overlaps = true;
                                break;
                            }
                        }
                        if (overlaps){
                            JOptionPane.showMessageDialog(project, "This furniture item overlaps with an already existing furniture item or fixture", "Alert", JOptionPane.WARNING_MESSAGE);
                        } else if (fixture.getX() < 0 || fixture.getY() < 0 || fixture.getX() + fixture.getWidth() > 1500 || fixture.getY() + fixture.getX() > 600){
                            JOptionPane.showMessageDialog(project, "This fixture exceeds the bounds of the floor ((0, 0) to (1500, 600))", "Alert", JOptionPane.WARNING_MESSAGE);
                        } else {
                            setOfFurniture.add(fixture);
                            furnitures.add(fixture);
                            fixture.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    int a = JOptionPane.showConfirmDialog(project, "Would you like to delete this item?");
                                    if (a == JOptionPane.YES_OPTION){
                                        setOfFurniture.remove(fixture);
                                        furnitures.remove(fixture);
                                        finalLayer.add(setOfFurniture, Integer.valueOf(3));
                                    }
                                }
                            });
                            finalLayer.add(setOfFurniture, Integer.valueOf(3));
                        }
                    }
                } catch (NumberFormatException ex){
                    //Shows a warning dialog box if the values entered aren't numeric
                    JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    });

    openingsLogo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] openingList = {"Door(Horizontal)", "Door(Vertical)","Window(Horizontal)","Window(Vertical)"};
            ImageIcon imageIcon = new ImageIcon("./images/window.png");
            int selection = JOptionPane.showOptionDialog(project, "Select the type of opening you would like to add", "opening selector", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, openingList, openingList[0]);
            imageIcon = switch (selection) {
                case 0 -> new ImageIcon("./images/horizontalDoor.png");
                case 1 -> new ImageIcon("./images/verticalDoor.png");
                case 2 -> new ImageIcon("./images/horizontalWindow.png");
                case 3 -> new ImageIcon("./images/verticalWindow.png");
                default -> imageIcon;
            };
            int width = switch (selection) {
                case 0 -> 20;
                case 1 -> 4;
                case 2 -> 20;
                case 3 -> 4;
                default -> throw new IllegalStateException("Unexpected value: " + selection);
            };
            int height = switch (selection) {
                case 0 -> 4;
                case 1 -> 20;
                case 2 -> 4;
                case 3 -> 20;
                default -> throw new IllegalStateException("Unexpected value: " + selection);
            };

            JTextField xCoord = new JTextField(5);
            xCoord.setSize(50, 30);
            JTextField yCoord = new JTextField(5);
            yCoord.setSize(50, 30);
            JPanel dialogPanel = new JPanel();
            dialogPanel.add(new JLabel("x: "));
            dialogPanel.add(xCoord);
            dialogPanel.add(Box.createHorizontalStrut(15));
            dialogPanel.add(new JLabel("y: "));
            dialogPanel.add(yCoord);
            int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter coordinates of your opening(only coordinates on the edges will be allowed)", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION){
                try {
                    Image image = imageIcon.getImage();
                    Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    JLabel opening = new JLabel(resizedIcon);
                    opening.setBounds(Integer.parseInt(xCoord.getText()), Integer.parseInt(yCoord.getText()), width, height);
                    boolean isValid = switch (selection){
                        case 0 -> forHoriDoor(opening,setOfEdges);
                        case 1 -> forVertiDoor(opening,setOfEdges);
                        case 2 -> forHoriWindow(opening,setOfBorders);
                        case 3 -> forVertiWindow(opening,setOfBorders);
                        default ->forHoriWindow(opening,setOfBorders);
                    };

                    System.out.println(isValid);
                    //Iterates over every already existing room and checks for overlaps
                    if (opening.getX() < 0 || opening.getY() < 0 || opening.getX() + opening.getWidth() > 1500 || opening.getY() + opening.getHeight() > 600){
                        JOptionPane.showMessageDialog(project, "This opening exceeds the bounds of the floor ((0, 0) to (1500, 600))", "Alert", JOptionPane.WARNING_MESSAGE);
                    }

                    else if(isValid){
                        setOfOpenings.add(opening);
                        opening.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                int a = JOptionPane.showConfirmDialog(project, "Would you like to delete this item?");
                                if (a == JOptionPane.YES_OPTION){
                                    setOfOpenings.remove(opening);
                                    furnitures.remove(opening);
                                    finalLayer.add(setOfOpenings, Integer.valueOf(5));
                                }
                            }
                        });
                    }
                    else {
                        JOptionPane.showMessageDialog(project, "Invalid placement of opening!", "Alert", JOptionPane.WARNING_MESSAGE);
                     }
                        finalLayer.add(setOfOpenings, Integer.valueOf(5));
                    }
                 catch (NumberFormatException ex){
                    //Shows a warning dialog box if the values entered aren't numeric
                    JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
            }
        }
    });

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
    finalLayer.add(copyrightText, Integer.valueOf(1));

    project.add(finalLayer);

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    JPanel room1 = new JPanel();
    room1.setBounds(0, 0, 100, 100);
    room1.setBackground(Color.red);
    room1.setBackground(new Color(100, 0, 0, 128));
    room1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    setOfRooms.add(room1);
    rooms.add(room1);
    room1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String[] options = {"Delete", "Add a room relative"};
            int selection = JOptionPane.showOptionDialog(project, "What would you like to do with this room?", "Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (selection == 0){
                setOfRooms.remove(room1);
                finalLayer.add(setOfRooms, Integer.valueOf(3));
            }
            if (selection == 1){
                JPanel newRoom = new JPanel();
                String[] directions = {"North", "East", "South", "West"};
                int a = JOptionPane.showOptionDialog(project, "Select the direction of the new room", "Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, directions, directions[0]);
                if (a == 0){
                    JTextField height = new JTextField(5);
                    height.setSize(50, 30);
                    JPanel dialogPanel = new JPanel();
                    dialogPanel.add(new JLabel("Height: "));
                    dialogPanel.add(height);
                    int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter the height of your room", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION){
                        try {
                            newRoom.setBounds(room1.getX(), room1.getY() - Integer.parseInt(height.getText()), room1.getWidth(), Integer.parseInt(height.getText()));
                            newRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                        } catch (NumberFormatException ex){
                            //Shows a warning dialog box if the values entered aren't numeric
                            JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                else if (a == 1){
                    JTextField width = new JTextField(5);
                    width.setSize(50, 30);
                    JPanel dialogPanel = new JPanel();
                    dialogPanel.add(new JLabel("Width: "));
                    dialogPanel.add(width);
                    int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter the width of your room", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION){
                        try {
                            newRoom.setBounds(room1.getX() + room1.getWidth(), room1.getY(), Integer.parseInt(width.getText()), room1.getHeight());
                            newRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                        } catch (NumberFormatException ex){
                            //Shows a warning dialog box if the values entered aren't numeric
                            JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                else if (a == 2){
                    JTextField height = new JTextField(5);
                    height.setSize(50, 30);
                    JPanel dialogPanel = new JPanel();
                    dialogPanel.add(new JLabel("Height: "));
                    dialogPanel.add(height);
                    int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter the height of your room", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION){
                        try {
                            newRoom.setBounds(room1.getX(), room1.getY() + room1.getHeight(), room1.getWidth(), Integer.parseInt(height.getText()));
                            newRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                        } catch (NumberFormatException ex){
                            //Shows a warning dialog box if the values entered aren't numeric
                            JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                else if (a == 3){
                    JTextField width = new JTextField(5);
                    width.setSize(50, 30);
                    JPanel dialogPanel = new JPanel();
                    dialogPanel.add(new JLabel("Width: "));
                    dialogPanel.add(width);
                    int option = JOptionPane.showConfirmDialog(null, dialogPanel, "Please enter the width of your room", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION){
                        try {
                            newRoom.setBounds(room1.getX() - Integer.parseInt(width.getText()), room1.getY(), Integer.parseInt(width.getText()), room1.getHeight());
                            newRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                        } catch (NumberFormatException ex){
                            //Shows a warning dialog box if the values entered aren't numeric
                            JOptionPane.showMessageDialog(project, "Please enter numeric values!", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                String[] roomList = {"Living room", "Bedroom", "Kitchen", "Bathroom"};
                int c = JOptionPane.showOptionDialog(project, "Select the room you would like to add", "Room selector", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, roomList, roomList[0]);
                Color color = new Color(0, 100, 0, 128);
                //Setting the color of the room depending on what is selected by the user
                switch (c){
                    case 0:
                        break;
                    case 1:
                        color = new Color(100, 0, 0, 128);
                        break;
                    case 2:
                        color = new Color(100, 100, 0, 128);
                        break;
                    case 3:
                        color = new Color(0, 0, 100, 128);
                        break;
                }
                newRoom.setBackground(color);
                boolean overlaps = false;
                //Iterates over every already existing room and checks for overlaps
                for(JPanel i : rooms){
                    if (Overlap(i, newRoom)){
                        overlaps = true;
                        break;
                    }
                }
                if (overlaps){
                    JOptionPane.showMessageDialog(project, "This room overlaps with an already existing room", "Alert", JOptionPane.WARNING_MESSAGE);
                } else {
                    for (JLabel i : furnitures){
                        if (Overlap(newRoom, i)){
                            overlaps = true;
                            break;
                        }
                    }
                    if (overlaps) {
                        JOptionPane.showMessageDialog(project, "This room overlaps with an already existing furniture item", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else if (newRoom.getX() < 0 || newRoom.getY() < 0 || newRoom.getX() + newRoom.getWidth() > 1500 || newRoom.getY() + newRoom.getHeight() > 600){
                        JOptionPane.showMessageDialog(project, "This room exceeds the bounds of the floor ((0, 0) to (1500, 600))", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        setOfRooms.add(newRoom);
                        rooms.add(newRoom);
                        finalLayer.add(setOfRooms, Integer.valueOf(3));
                    }
                }
            }
        }
    });

    finalLayer.add(setOfRooms, Integer.valueOf(3));

    ImageIcon imageIcon = new ImageIcon("images/dining_set.png");
    Image image = imageIcon.getImage();
    Image resizedImage = image.getScaledInstance(55, 75, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon = new ImageIcon(resizedImage);
    JLabel furniture1 = new JLabel(resizedIcon);
    furniture1.setBounds(0, 0, 55, 75);
    setOfFurniture.add(furniture1);
    furnitures.add(furniture1);

    finalLayer.add(setOfFurniture, Integer.valueOf(3));

    furniture1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int a = JOptionPane.showConfirmDialog(project, "Would you like to delete this item?");
            if (a == JOptionPane.YES_OPTION){
                setOfFurniture.remove(furniture1);
                furnitures.remove(furniture1);
                finalLayer.add(setOfFurniture, Integer.valueOf(3));
            }
            /*else if (selection == 1){
            RotatedLabel rotatedLabel = new RotatedLabel(resizedIcon, 90);
            setOfFurniture.remove(furniture1);
            setOfFurniture.add(rotatedLabel);
            finalLayer.add(setOfFurniture, Integer.valueOf(3));
            project.add(finalLayer);
            }*/
        }
    });

    //this.add(finalLayer);

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // JButton menuBar = new JButton();

    project.setVisible(true);
}

public static void main(String[] args) {
    new Grid();
}
