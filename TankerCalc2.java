
//Import Layout, Listeners, and Controls
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TankerCalc2 {
	// Controls for App
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JPanel buttonPanel;
	private JButton calculate;
	private JTextField ouncesEntry, yearsEntry, nameEntry, bdayYEntry,bdayMEntry,bdayDEntry;

	// Constructor
	public TankerCalc2() {
		prepareGUI();
	}

	// Entry Point
	public static void main(String[] args) {
		TankerCalc2 swingTankerCalc = new TankerCalc2();
		swingTankerCalc.showTextField();
	}

	// Setup the GUI environment
	private void prepareGUI() {
		// Setup App Frame
		mainFrame = new JFrame("Tanker CALC");
		mainFrame.setSize(800, 400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Setup Labels
		headerLabel = new JLabel("Welcome to TANKER CALC 2.0", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 150);
		ouncesEntry = new JTextField(4);
		yearsEntry = new JTextField(4);
		nameEntry = new JTextField(4);
		bdayYEntry = new JTextField(4);
		bdayMEntry = new JTextField(4);
		bdayDEntry = new JTextField(4);
		JLabel ounceText = new JLabel("Enter amount of water (ounces): ");
		JLabel yearsText = new JLabel("Enter the lifespan you want to calculate: ");
		JLabel nameText = new JLabel("Enter your first name: ");
		JLabel bdayYText = new JLabel("Enter your birth year: ");
		JLabel bdayMText = new JLabel("Enter your birth month: ");
		JLabel bdayDText = new JLabel("Enter your birth day: ");
		calculate = new JButton("Calculate");

		// Setup Layout
		mainFrame.setLayout(new GridLayout(4, 1));

		// Add Interactables
		controlPanel = new JPanel();
		controlPanel.add(ounceText);
		controlPanel.add(ouncesEntry);
		controlPanel.add(yearsText);
		controlPanel.add(yearsEntry);
		controlPanel.add(nameText);
		controlPanel.add(nameEntry);
		controlPanel.add(bdayYText);
		controlPanel.add(bdayYEntry);
		controlPanel.add(bdayMText);
		controlPanel.add(bdayMEntry);
		controlPanel.add(bdayDText);
		controlPanel.add(bdayDEntry);
		buttonPanel = new JPanel();
		buttonPanel.add(calculate);

	}

	// Display Controls
	private void showTextField() {
		// Action listener for button click
		calculate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent click) {
				float ounces = (float) Float.valueOf(ouncesEntry.getText());
				String name = nameEntry.getText();
				float age = (float) Float.valueOf(yearsEntry.getText());
				Day bday = new Day(Integer.parseInt(bdayYEntry.getText()),Integer.parseInt(bdayMEntry.getText()),Integer.parseInt(bdayDEntry.getText()));
				Day ageDay = new Day();
				ageDay = bday.addDays((int)age*365);
				int totalDays = ageDay.daysFrom(bday);
				double result = totalDays;
				result *= ounces;
				result /= 128;
				result /= 8000;
				statusLabel.setText(name + ", You will drink an estimated " + result
						+ " Tankers (each with a capacity of about 8,000 gallons) of water in your lifetime.");
				mainFrame.setVisible(true);
			}
		});
		// Place controls on panels

		// Don't forget to set visibility
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(buttonPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);

	}
}
