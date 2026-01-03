import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BAIFrame extends JFrame {
    // labels text box for hip circumference input
    private JLabel hipLabel;
    // allows user to enter their hip circumference (in centimeters)
    private JTextField hipValue;

    // labels text box for height input
    private JLabel heightLabel;
    // allows user to enter their height (in meters)
    private JTextField heightValue;

    // button user will click to calculate and show their BAI value
    private JButton calcButton;

    // displays the calculated BAI value
    private JLabel baiValue;

    // panel for adding components to
    private JPanel panel;

    // defining the width and height of the frame
    private static final int FRAME_WIDTH = 250;
    private static final int FRAME_HEIGHT = 150;

    public BAIFrame() {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
    }


    // helper method to create and set up all GUI components
    private void createComponents() {
        // creating the components
        hipLabel = new JLabel("Hip Circumference (cm): ");
        hipValue = new JTextField(5); // width of field

        heightLabel = new JLabel("Height (m): ");
        heightValue = new JTextField(5); // width of field

        calcButton = new JButton("Calculate");

        baiValue = new JLabel();

        // adding the components to the panel
        panel = new JPanel();
        panel.setBackground(new Color(166, 195, 238));

        panel.add(hipLabel);
        panel.add(hipValue);

        panel.add(heightLabel);
        panel.add(heightValue);

        panel.add(calcButton);

        panel.add(baiValue);

        add(panel);

        // attaching a listener to the button to calculate the BAI value
        ActionListener listener = new ClickListener();
        calcButton.addActionListener(listener);
    }

    // inner listener class to handle button clicks
    // also calculates the BAI value, rounds it, and displays the result in the label
    public class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                double userHip = Double.parseDouble(hipValue.getText()); // get user hip circumference
                double userHeight = Double.parseDouble(heightValue.getText()); // get user height

                double baiFormula = (userHip / Math.pow(userHeight, 1.5)) - 18; // calculate BAI
                double roundedFormula = Math.round(baiFormula * 10.0) / 10.0; // round to 1 decimal place

                baiValue.setText("BAI: " + roundedFormula + "%"); // display result
            } catch (NumberFormatException e) {
                baiValue.setText("Please enter valid numerical values!");
            }
        }
    }
}