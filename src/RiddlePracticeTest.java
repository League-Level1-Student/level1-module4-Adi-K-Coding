import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RiddlePracticeTest implements ActionListener {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JLabel label = new JLabel();
JButton submitButton = new JButton("Submit");
JButton hintButton = new JButton("Hint");
JTextField input = new JTextField();

public static void main(String[] args) {
	RiddlePracticeTest r= new RiddlePracticeTest();
	r.run();
}

void run() {
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	panel.add(label);
	panel.add(input);
	panel.add(hintButton);
	panel.add(submitButton);
	label.setText("What goes up but never comes down?");
	hintButton.addActionListener(this);
	submitButton.addActionListener(this);
input.setPreferredSize(new Dimension(100,30));
	frame.pack();
}

@Override
public void actionPerformed(ActionEvent e) {
	JButton pressed = (JButton) e.getSource();
	if(pressed==submitButton) {
		if(input.getText().equalsIgnoreCase("Age")) {
			JOptionPane.showMessageDialog(null, "Good Job!");
		}else {
			JOptionPane.showMessageDialog(null,"Try submitting another guess");
		}
	}else if(pressed==hintButton) {
		JOptionPane.showMessageDialog(null, "Happy Birthday to You!");
	}
}




}
