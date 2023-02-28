import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Project4 extends JFrame implements ActionListener {
	private JLabel nameLabel;     // Label for user's name
	private JLabel vowelLabel;      // Label for number of vowels
        private JLabel consLabel; // Label for number of consonants
	private JTextField nameField;  // Displays user's name 
	private JTextField vowelField; // Displays number of vowels
	private JTextField consField; // Displays number of consonants

	Project4() {
		GridBagConstraints layoutConst = null;

		setTitle("Vowel and Consonant Counter");

		nameLabel = new JLabel("Enter your name:");
		vowelLabel = new JLabel("Amount of vowels:");
		consLabel = new JLabel("Amount of consonants:");

		nameField = new JTextField(15);
		nameField.setEditable(true);
		nameField.setText("default");
		nameField.addActionListener(this);

      		vowelField = new JTextField(15);
      		vowelField.setEditable(false);

		consField = new JTextField(15);
		consField.setEditable(false);

      		setLayout(new GridBagLayout());
      		layoutConst = new GridBagConstraints();

      		layoutConst.gridx = 0;
      		layoutConst.gridy = 0;

      		layoutConst.insets = new Insets(10, 10, 10, 10);

      		add(nameLabel, layoutConst);

      		layoutConst = new GridBagConstraints();
      		layoutConst.gridx = 1;
      		layoutConst.gridy = 0;
      		layoutConst.insets = new Insets(10, 10, 10, 10);
      		add(nameField, layoutConst);

      		layoutConst = new GridBagConstraints();
      		layoutConst.gridx = 0;
      		layoutConst.gridy = 1;
      		layoutConst.insets = new Insets(10, 10, 10, 10);
      		add(vowelLabel, layoutConst);

      		layoutConst = new GridBagConstraints();
      		layoutConst.gridx = 1;
      		layoutConst.gridy = 1;
      		layoutConst.insets = new Insets(10, 10, 10, 10);
      		add(vowelField, layoutConst);

		layoutConst = new GridBagConstraints();
      		layoutConst.gridx = 0;
      		layoutConst.gridy = 2;
      		layoutConst.insets = new Insets(10, 10, 10, 10);
      		add(consLabel, layoutConst);

      		layoutConst = new GridBagConstraints();
      		layoutConst.gridx = 1;
      		layoutConst.gridy = 2;
      		layoutConst.insets = new Insets(10, 10, 10, 10);
      		add(consField, layoutConst);

   }

   	@Override
	public void actionPerformed(ActionEvent event) {
      		String userInput;      // User specified name/string

      		userInput = nameField.getText();

		int i, vowels, consonants;
		vowels = consonants = 0;


		for(i = 0; i < userInput.length(); i++)	{
			char ch = userInput.charAt(i);
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
				vowels++;
			}
			else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
				consonants++;
			}
		}		

      		vowelField.setText(Integer.toString(vowels));
		consField.setText(Integer.toString(consonants));
   }

	public static void main(String[] args) {

      		Project4 myFrame = new Project4();

      		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      		myFrame.pack();
      		myFrame.setVisible(true);
   }
}
