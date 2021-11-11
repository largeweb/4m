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

//THE MAIN SNAP GUI MENU CLASS
public class MainSnapGUI {

	private JFrame frame;
	public JPanel mp, panel1, panel2, panel3;
	private JLabel title;
	private JButton menuOrder, fileOrder, back;
	
	public MainSnapGUI() {
//		INITIALIZE VARIABLES
        frame = new JFrame("MMMM: Snapchat");
        mp = new JPanel();
        panel1 = new JPanel();  
        panel2 = new JPanel();  
        panel3 = new JPanel();  
        JLabel title = new JLabel("SNAPCHAT NETWORKER");  
        JButton menuOrder = new JButton("Order With Menu");  
        JButton fileOrder = new JButton("Order With Text");  
        JButton back = new JButton("Back");
        
//        ORGANIZE
        JPanel[] panelArr = {mp, panel1, panel2, panel3};
        JLabel[] labelArr = {title};
        JButton[] buttonArr = {menuOrder, fileOrder, back};
        
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
        menuOrder.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SnapManualGUI();
				frame.dispose();
			}

        });
        
        fileOrder.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SnapFileGUI();
				frame.dispose();
			}

        });
        
        back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main.startGUI = new StartGUI();
				frame.dispose();
			}

        });
        
//        PANEL MAKEUP
        panel1.add(title);  
        panel2.add(menuOrder);  
        panel2.add(fileOrder);  
        panel3.add(back);
        
//        MAIN PANEL MAKEUP
        mp.add(panel1);
        mp.add(panel2);
        mp.add(panel3);
        
//        FRAME MAKEUP
        frame.add(mp);  
        frame.setSize(400, 200);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  
        title.requestFocus();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainSnapGUI();
	}

}
