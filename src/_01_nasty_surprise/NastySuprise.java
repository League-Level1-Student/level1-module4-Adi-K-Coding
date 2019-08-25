package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySuprise implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton treatbutton = new JButton("treat");
	JButton trickbutton = new JButton("trick");

	public static void main(String[] args) {
		NastySuprise ns = new NastySuprise();
		ns.setup();
	}

	void setup() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(treatbutton);
		panel.add(trickbutton);
		trickbutton.addActionListener(this);
		treatbutton.addActionListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressed = (JButton) e.getSource();
		if (pressed== trickbutton) {
			showPictureFromTheInternet("https://www.thelabradorsite.com/wp-content/uploads/2019/03/Cute-puppy-Names-Over-200-Adorable-Ideas-LS-long.jpg");
		}else if (pressed == treatbutton) {
			showPictureFromTheInternet("http://images1.fanpop.com/images/photos/1500000/SCARY-BABY-horror-world-1571400-640-480.jpg");
		}
	}
	private void showPictureFromTheInternet(String imageUrl) {
	     try {
	          URL url = new URL(imageUrl);
	          Icon icon = new ImageIcon(url);
	          JLabel imageLabel = new JLabel(icon);
	          JFrame frame = new JFrame();
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (MalformedURLException e) {
	          e.printStackTrace();
	     }
	}
}