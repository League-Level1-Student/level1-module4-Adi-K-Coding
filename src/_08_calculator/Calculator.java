package _08_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	int inputOne;
	int inputTwo;
	int answer;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JButton add = new JButton("Add");
	JButton subtract = new JButton("Subtract");
	JButton multiply = new JButton("Multiply");
	JButton divide = new JButton("Divide");

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.run();
	}

	void run() {
		frame.setVisible(true);
		frame.setSize(200, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		tf1.setPreferredSize(new Dimension(80,30));
		tf2.setPreferredSize(new Dimension(80,30));
		panel.add(tf1);
		panel.add(tf2);
		panel.add(add);
		panel.add(subtract);
		panel.add(multiply);
		panel.add(divide);
		panel.add(label);
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int inputOne=Integer.parseInt(tf1.getText());
		int inputTwo=(Integer.parseInt(tf2.getText()));
		if (e.getSource().equals(add)) {
			label.setText("" +(inputOne+inputTwo));
		}else if (e.getSource().equals(subtract)) {
			label.setText(""+(inputOne-inputTwo));
		}else if (e.getSource().equals(multiply)) {
			label.setText(""+(inputOne*inputTwo));
		}else if (e.getSource().equals(divide)) {
			label.setText(""+((double)inputOne/(double)inputTwo));
		}

	}

}
