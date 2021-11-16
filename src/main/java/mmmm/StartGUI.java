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
	private JPanel mp, panel1, panel2, panel3, panel4, panel5, panel6;
	private JLabel title, labelChoose;
	private JButton snapchat, instagram, reddit, linkedin, facebook, twitter, quora, discord, youtube, close;
	
	public StartGUI() {
//		INITIALIZE VARIABLES
        frame = new JFrame("Multi Media Marketing Menu");
        mp = new JPanel();
        panel1 = new JPanel();  
        panel2 = new JPanel();  
        panel3 = new JPanel();  
        panel4 = new JPanel();  
        panel5 = new JPanel();  
        panel6 = new JPanel();  
        JButton snapchat = new JButton("Snapchat");  
        JButton instagram = new JButton("Instagram");  
        JButton reddit = new JButton("Reddit");  
        JButton linkedin = new JButton("LinkedIn");  
        JButton facebook = new JButton("Facebook");  
        JButton twitter = new JButton("Twitter");  
        JButton quora = new JButton("Quora");  
        JButton discord = new JButton("Discord");  
        JButton youtube = new JButton("YouTube");  
        JButton close = new JButton("Close");  
        JLabel title = new JLabel("4M");  
        JLabel labelChoose = new JLabel("Choose Platform");
        
//        ORGANIZE
        JPanel[] panelArr = {mp, panel1, panel2, panel3, panel4, panel5, panel6};
        JLabel[] labelArr = {title, labelChoose};
        JButton[] buttonArr = {snapchat, instagram, reddit, linkedin,facebook, twitter, quora, discord, youtube, close};
        
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
        close.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Closing!");
				System.exit(0);
			}

        });
        
//        PANEL MAKEUP
        panel1.add(title);  
        panel2.add(labelChoose);
        panel3.add(snapchat);
        panel3.add(instagram);
        panel3.add(reddit);
        panel4.add(linkedin);
        panel4.add(facebook);
        panel4.add(twitter);  
        panel5.add(quora);
        panel5.add(discord);
        panel5.add(youtube);
        panel6.add(close);  
        
//        MAIN PANEL MAKEUP
        mp.add(panel1);
        mp.add(panel2);
        mp.add(panel3);
        mp.add(panel4);
        mp.add(panel5);
        mp.add(panel6);
        
//        FRAME MAKEUP
        frame.add(mp);  
        frame.setSize(400, 300);  
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
