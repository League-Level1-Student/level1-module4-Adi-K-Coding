package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener{
	 JButton jokebutton = new JButton("Joke");
		JButton punchlinebutton = new JButton("Punchline");
	public static void main(String[] args) {
		ChuckleClicker cc= new ChuckleClicker();
		cc.makeButton();

	}
   void makeButton() {
	JFrame frame=new JFrame();
	frame.setVisible(true);
	JPanel panel= new JPanel();
	frame.add(panel);
	panel.add(jokebutton);
	panel.add(punchlinebutton);
	jokebutton.addActionListener(this);
	punchlinebutton.addActionListener(this);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.pack();
   }
 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jokebutton) {
			JOptionPane.showMessageDialog(null, "A blind man walks into a bar.");
		}else if(e.getSource()==punchlinebutton){
			JOptionPane.showMessageDialog(null, "And a table, and a chair.");
		}
		
	}
}