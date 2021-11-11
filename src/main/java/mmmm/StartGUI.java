package mmmm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//THIS IS THE STARTING GUI WHEN YOU LAUNCH THE PROGRAM
public class StartGUI {
	
	public JFrame frame;
	private JPanel mp, panel1, panel2, panel3, panel4, panel5;
	private JLabel title, labelChoose;
	private JButton snapchat, instagram, reddit, linkedin, close;
	
	public StartGUI() {
//		INITIALIZE VARIABLES
        frame = new JFrame("Multi Media Marketing Menu");
        mp = new JPanel();
        panel1 = new JPanel();  
        panel2 = new JPanel();  
        panel3 = new JPanel();  
        panel4 = new JPanel();  
        panel5 = new JPanel();  
        JButton snapchat = new JButton("Snapchat");  
        JButton instagram = new JButton("Instagram");  
        JButton reddit = new JButton("Reddit");  
        JButton linkedin = new JButton("LinkedIn");  
        JButton close = new JButton("Close");  
        JLabel title = new JLabel("4M");  
        JLabel labelChoose = new JLabel("Choose Platform");
        
//        ORGANIZE
        JPanel[] panelArr = {mp, panel1, panel2, panel3, panel4, panel5};
        JLabel[] labelArr = {title, labelChoose};
        JButton[] buttonArr = {snapchat, instagram, reddit, linkedin, close};
        
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
        
//		SETUP BUTTON ACTION LISTENERS
        snapchat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("test1");
				RunnableThread verifySnap = new RunnableThread("verifysnap");
				verifySnap.run();
			}

        });
        
//        PANEL MAKEUP
        panel1.add(title);  
        panel2.add(labelChoose);
        panel3.add(snapchat);
        panel3.add(instagram);
        panel4.add(reddit);
        panel4.add(linkedin);  
        panel5.add(close);  
        
//        MAIN PANEL MAKEUP
        mp.add(panel1);
        mp.add(panel2);
        mp.add(panel3);
        mp.add(panel4);
        mp.add(panel5);
        
//        FRAME MAKEUP
        frame.add(mp);  
        frame.setSize(300, 250);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  
        title.requestFocus();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StartGUI();
	}

}
