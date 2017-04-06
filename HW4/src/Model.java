/**
 * Maintains and manages the data. Stores and retrieves passwords. Match username to username entered...
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Model {

    /**
     * gets the username and password from the database
     * @return an array containing the username and password
     */
    public static String[] getUserAndPass() {
        Connection con;
        String[] info = new String[2]; //initializes the array containing the username and password
        try {
            Properties settings = new Properties(); //initializes new properties
            InputStream inputStream = Model.class.getClassLoader().getResourceAsStream("agent.properties"); //access the properties file
            settings.load(inputStream); // loads the properties file
            String driver = settings.getProperty("driver"); //gets the driver from the properties file
            String url = settings.getProperty("url"); //gets the url of the database from the properties file
            Class.forName(driver); //checks to see if the driver is downloaded
            con = DriverManager.getConnection(url, "root", "root"); //logs into the database
            Statement st = con.createStatement(); //connects to database
            String query = "SELECT * FROM users"; //searches database for usernames
            ResultSet rs = st.executeQuery(query); // stores the results of the search
            while (rs.next()) {
                info[0] = rs.getString("username"); //adds username to the array
                info[1] = rs.getString("password"); //adds password to the array
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return info; //returns array
    }
}