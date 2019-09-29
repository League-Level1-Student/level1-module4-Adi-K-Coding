package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	char currentLetter;
	JFrame frame = new JFrame("Typing Tutor");
	JPanel panel= new JPanel();
	JLabel label = new JLabel();
	public static void main(String[] args) {
		TypingTutor tt = new TypingTutor();
		tt.run();
	}

	void run() {
		currentLetter = generateRandomLetter();
	frame.setVisible(true);	
	label.setText(currentLetter+"");
	label.setFont(label.getFont().deriveFont(28.0f));
	label.setHorizontalAlignment(JLabel.CENTER);
	frame.addKeyListener(this);
	frame.add(panel);
	panel.add(label);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("You pressed:"+e.getKeyChar());
		if(e.getKeyChar()==currentLetter) {
			panel.setBackground(new Color(0,255,0));
		}else {
			panel.setBackground(new Color(255,0,0));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentLetter = generateRandomLetter();
		label.setText(currentLetter+"");
	panel.setBackground(new Color(255,255,255));
	}
}
