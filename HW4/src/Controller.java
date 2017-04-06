import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that manages interaction between model and view classes
 */
public class Controller {

    /**
     * checks to see if the username entered by the user and the username saved in the database match
     * @param input the users input
     * @param info the actual username
     * @return true if the usernames match, else return false
     */
    public static boolean userNameChecker(String input,String[] info) {
        if (input.equals(info[0]))
            return true;
        else
            return false;
    }

    /**
     * checks to see if the password entered by the user and the password saved in the database match
     * @param input the user's input
     * @param info the actual password
     * @return true if the passwords match, else return false
     */
    public static boolean passWordChecker(String input, String[] info) {
        if (input.equals(info[1]))
            return true;
        else
            return false;
    }

    public static void main(String[] args) { //main method
        View myView = new View("Login"); //creates a new view object
        myView.userSubmitButton.addActionListener(new ActionListener() { //waits until the submit button is pressed on the username screen
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userNameChecker(myView.inputUser,Model.getUserAndPass())) { //if the username is correct
                    myView.userFrame.setVisible(false); //set the first frame to invisible
                    myView.createPassScreen(); // create the password input screen
                    myView.passSubmitButton.addActionListener(new ActionListener() { // wait until the submit button is pressed on the password screen
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (passWordChecker(myView.inputPass,Model.getUserAndPass())) { //if the password is correct
                                myView.passFrame.setVisible(false);
                            }
                            else
                                System.out.println("Access Denied");
                        }
                    });
                }
                else
                    System.out.println("User does not exist");
            }
        });
    }
}
