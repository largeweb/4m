package mmmm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//THE "NOT IMPLMENTED YET" SCREEN
public class NIYGUI {

	private JFrame frame;
	public JPanel mp, panel1, panel2, panel3;
	private JLabel title, title2;
	private JButton back;
	
	public NIYGUI() {
//		INITIALIZE VARIABLES
        frame = new JFrame("MMMM: NOT IMPLEMENTED YET");
        mp = new JPanel();
        panel1 = new JPanel();  
        panel2 = new JPanel();  
        panel3 = new JPanel();  
        JLabel title = new JLabel("THIS FEATURE HAS NOT");  
        JLabel title2 = new JLabel("BEEN IMPLEMENTED YET");  
        JButton back = new JButton("Back");
        
//        ORGANIZE
        JPanel[] panelArr = {mp, panel1, panel2, panel3};
        JLabel[] labelArr = {title, title2};
        JButton[] buttonArr = {back};
        
//        SET PROPERTIES
        for(int i=0;i<panelArr.length;i++) {
        	panelArr[i].setBackground(vars.panelBGColor);
        	panelArr[i].setForeground(vars.panelFGColor);
        };
        for(int i=0;i<labelArr.length;i++) {
        	labelArr[i].setBackground(vars.labelBGColor);
        	labelArr[i].setForeground(vars.labelFGColor);
        };
        for(int i=0;i<buttonArr.length;i++) {
        	buttonArr[i].setBackground(vars.btnBGColor);
        	buttonArr[i].setForeground(vars.btnFGColor);
        };
        mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));
        title.setForeground(Color.YELLOW);
        title.setFont(new Font(null, Font.BOLD, 22));
        title2.setForeground(Color.YELLOW);
        title2.setFont(new Font(null, Font.BOLD, 22));
        
//		SETUP BUTTON ACTION LISTENERS
        back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main.startGUI = new StartGUI();
				frame.dispose();
			}

        });
        
//        PANEL MAKEUP
        panel1.add(title);  
        panel2.add(title2);  
        panel3.add(back);
        
//        MAIN PANEL MAKEUP
        mp.add(panel1);
        mp.add(panel2);
        mp.add(panel3);
        
//        FRAME MAKEUP
        frame.add(mp);  
        frame.setSize(450, 150);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  
        title.requestFocus();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NIYGUI();
	}

}
