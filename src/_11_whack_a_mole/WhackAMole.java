package _11_whack_a_mole;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	int score = 0;
	Date d;
	int missedCount = 0;

	public static void main(String[] args) {
		WhackAMole wam = new WhackAMole();
		wam.run();
	}

	void run() {
	
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 500);
		drawButtons();
		d = new Date();
	}

	void drawButtons() {
		Random r = new Random();
		int button = r.nextInt(24);
		for (int i = 0; i < 24; i++) {
			JButton b = new JButton();
			b.addActionListener(this);
			panel.add(b);
			if (i == button) {
				JButton specialbutton = new JButton("MOLE");
				specialbutton.addActionListener(this);
			panel.add(specialbutton);
			}
		}
	frame.add(panel);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressed = (JButton) e.getSource();
		if (pressed.getText().equals("MOLE")) {
			score = score + 1;
			playSound("beep.wav");
		} else {
			speak("You missed you pathetic scumbag Open your eyes you blind bat You're a disgrace to humanity.");
			missedCount = missedCount + 1;
		}
		frame.dispose();
		drawButtons();
		if (score == 10) {
			endGame(d, 10);
		}
		if (missedCount == 5) {
			JOptionPane.showMessageDialog(null, "You lost");
			System.exit(0);
		}
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource("beep.wav"));
		sound.play();
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}
}
