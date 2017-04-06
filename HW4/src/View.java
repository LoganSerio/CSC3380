import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that creates the GUI for the login system. The user will interact with this class and the class will record the user's interactions
 */
public class View implements ActionListener {
    public JFrame userFrame;
    public JFrame passFrame;
    JPanel userButtonPanel;
    JPanel passButtonPanel;
    public Button userSubmitButton;
    public Button passSubmitButton;
    JTextField userTF;
    JTextField passTF;
    Label userLoginLabel;
    Label passLoginLabel;
    public String inputUser;
    public String inputPass;

    /**
     * The constructor of the view object. Makes the frame for the user to input their username
     * @param title the title of the frame
     */
    public View(String title) {
        userFrame = prepareFrame(title); //get a frame
        userTF = new JTextField("",20); // make the textfield for the frame
        userLoginLabel = new Label("Username",Label.RIGHT); //creates the login label for the textfield of the username frame
        userLoginLabel.setForeground(Color.BLUE); //sets the foreground color of the login label to blue
        userButtonPanel = prepareContainer(); //get a button panel
        userSubmitButton = prepareButton("Submit","Input Username"); //get a button labeled "Submit" and has an action listener of "Input Username"
        userButtonPanel.add(userLoginLabel); //adds the user login label to the button panel
        userButtonPanel.add(userTF); //adds the textfield to the button panel
        userButtonPanel.add(userSubmitButton); //adds the Submit button to the button panel
        userFrame.add("Center",userButtonPanel); //adds the button panel to the frame
        userFrame.setVisible(true); //makes the frame visible
        userFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //closes the frame when the x button is pressed
    }

    /**
     * prepares the button before it is added to the frame
     * @param title the name of the button
     * @param actionCommand //the action command of the button
     * @return the prepared button
     */
    private Button prepareButton(String title, String actionCommand) {
        userSubmitButton = new Button(title); //initializes a new button
        userSubmitButton.setBackground(Color.RED); //sets the background color of the button to red
        userSubmitButton.setActionCommand(actionCommand); //sets the action command of the button
        userSubmitButton.addActionListener(this); //adds an action listener to the button
        return userSubmitButton;
    }

    /**
     * prepares a button panel before it is added to the frame
     * @return the prepared button panel
     */
    private JPanel prepareContainer() {
        JPanel buttonPanel = new JPanel(); //initializes a new button panel
        buttonPanel.setBounds(10,10,200,200); //sets the bounds for the button panel
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //checks the size of the screen
        int x = Math.max((screenSize.width /2 - userFrame.getSize().width / 2), 0); //sets the x component for size of the panel
        int y = Math.max((screenSize.height /2 - userFrame.getSize().height / 2), 0); //sets the y component for size of the panel
        buttonPanel.setLocation(x,y); //sets the location of the button panel
        return buttonPanel; //returns the button panel
    }

    /**
     * Prepares the frame before the components are added to it
     * @param title the title of the frame
     * @return a prepared frame
     */
    private JFrame prepareFrame(String title) {
        Rectangle r = new Rectangle(10,10,500,500); //sets the size and shape of the frame
        userFrame = new JFrame(title); //initializes a new frame
        userFrame.setSize(950,500); //sets the size of the frame
        userFrame.setLayout(new BorderLayout()); //sets the layout type of the frame
        userFrame.setMaximizedBounds(r); //sets the max bounds of the frame
        userFrame.setExtendedState(userFrame.MAXIMIZED_BOTH); //sets the state of the frame
        return userFrame; //returns the prepared frame
    }

    /**
     * Creates the password input window
     */
    public void createPassScreen() {
        String title = "Welcome " + inputUser; //the title of the frame
        passFrame = prepareFrame(title); //prepares the frame for the password screen
        passTF = new JTextField("",20); //initializes the textfield
        passLoginLabel = new Label("Please enter your password",Label.RIGHT); //initializes a new label called "please enter your password"
        passLoginLabel.setForeground(Color.BLUE); //sets the foreground color to blue
        passButtonPanel = prepareContainer(); //gets a button panel
        passButtonPanel.add(passLoginLabel); //adds the label to the frame
        passButtonPanel.add(passTF); //adds the textfield to the frame
        passSubmitButton = prepareButton("Submit","Input Password"); //gets the submit button with the action listener "Input Password"
        passButtonPanel.add(passSubmitButton); //adds the submit button to the button panel
        passFrame.add("Center",passButtonPanel); //adds the button panel to the center of the frame
        passFrame.setVisible(true); //makes the frame visible
        userFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //allows the window to exit when the x button is pressed
    }

    /**
     * a listener that waits for a button to be pressed
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String submitPressed = e.getActionCommand(); //saves the action command
        if (submitPressed.equals("Input Username")) { // if the action listener is for the username screen then save what's in the text box as the user name
            inputUser = userTF.getText();
        }
        else if (submitPressed.equals("Input Password")) { //else save what's in the text box as a password
            inputPass = passTF.getText();
        }
    }
}