package opnsrc.fcih.trainrsys.backend;

import javax.swing.JOptionPane;

public class Error {

    public static void show(Exception e) {
        e.printStackTrace();
        Data.log(e.toString(), true);
        JOptionPane.showMessageDialog(null, e.toString() + "\n \nPlease contanct the Administrator.", "Error", 0);

    }

    public static void display(String err) {
        System.err.println(err);
        Data.log("Displaied Error to the user is " + err, true);
        JOptionPane.showMessageDialog(null, err, "Error", 0);
    }
}
