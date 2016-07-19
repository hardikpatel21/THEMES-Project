package testcodes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class AwtCloseButtonEvent{
	public static void main(String[] args){
		Frame frame = new Frame("Close Operation Frame");
		Label lbl = new Label("Welcom in Roseindia.net Tutorial",Label.CENTER);
		Panel panel = new Panel();
		List lst = new List();
		lst.addItem("Chandan");
		lst.addItem("Rinku");
		lst.addItem("Sushil");
		frame.add(panel, BorderLayout.NORTH);
		frame.add(lbl);
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
                            JOptionPane.showMessageDialog(null, "closed");
				System.exit(0);
			}
		});
	}
}
