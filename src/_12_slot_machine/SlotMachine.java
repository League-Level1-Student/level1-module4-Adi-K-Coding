package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Spin");
	int r1;
	int r2;
	int r3;
	JLabel l1;
	JLabel l2;
	JLabel l3;

	public static void main(String[] args) {
		SlotMachine sl = new SlotMachine();
		sl.run();
	}

	void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(button);
		button.addActionListener(this);
	}

	void random() {
		panel.removeAll();
		panel.add(button);
		Random rand = new Random();
		r1 = rand.nextInt(2);
		r2 = rand.nextInt(2);
		r3 = rand.nextInt(2);
		try {
			if (r1 == 0) {
				l1 = createLabelImage("cherries.jpg");
			} else if (r1 == 1) {
				l1 = createLabelImage("grapes.jpg");
			} else if (r1 == 2) {
				l1 = createLabelImage("seven.jpg");
			}
			if (r2 == 0) {
				l2 = createLabelImage("cherries.jpg");
			} else if (r2 == 1) {
				l2 = createLabelImage("grapes.jpg");
			} else if (r2 == 2) {
				l2 = createLabelImage("seven.jpg");
			}
			if (r3 == 0) {
				l3 = createLabelImage("cherries.jpg");
			} else if (r3 == 1) {
				l3 = createLabelImage("grapes.jpg");
			} else if (r3 == 2) {
				l3 = createLabelImage("seven.jpg");
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	panel.add(l1);
	panel.add(l2);
	panel.add(l3);
	checkWhen();
	}

	void checkWhen() {
		if(r1==r2 && r2==r3) {
			JOptionPane.showMessageDialog(null, "You Win!!");
		}
	}
	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		random();
	}
}
