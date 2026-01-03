import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // create an instance of the BAI calculator frame
        BAIFrame frame = new BAIFrame();

        // set location of pop-up window on screen
        frame.setLocation(200, 200);

        // set the title of the pop-up window
        frame.setTitle("BAI Calculator");

        // make sure the program exits after pop-up is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make pop-up visible to user
        frame.setVisible(true);
    }
}