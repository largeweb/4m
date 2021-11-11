package mmmm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//THIS IS THE GUI WITH THE SNAP GUI VIA FILE ORDER
public class SnapFileGUI {
	
	private JFrame frame;
	public JPanel mp, panelTop, panel1, panel2, panel3, panel4, panelBottom;
	private JLabel title, labelOrderByFile, labelOrderList;
	private JButton btnBack, btnClearOrders, btnRunOrders, btnGetLog;
	
	public SnapFileGUI() {
		
//		INITIALIZE VARIABLES
        frame = new JFrame("MMMM: Snapchat Text Order");
        mp = new JPanel();
        panelTop = new JPanel();  
        panel1 = new JPanel();  
        panel2 = new JPanel();  
        panel3 = new JPanel();  
        panel4 = new JPanel();  
        panelBottom = new JPanel();  
        JLabel title = new JLabel("SNAPCHAT TEXT ORDER");  
        JLabel labelOrderByFile = new JLabel("Choose a file: .txt ...");
        JLabel labelOrderList = new JLabel("Orders: ");
        JButton btnBack = new JButton("Back");  
        JButton btnFileOrder = new JButton("Select File");  
        JButton btnClearOrders = new JButton("Clear Orders");
        JButton btnRunOrders = new JButton("Run Orders");
        JButton btnGetLog = new JButton("Get Log");
        JTextField tf1 = new JTextField("TEXT ORDER FORMAT");
        
//        ORGANIZE
        JPanel[] panelArr = {mp, panelTop, panel1, panel2, panel3, panel4, panelBottom};
        JLabel[] labelArr = {title, labelOrderByFile, labelOrderList};
        JButton[] buttonArr = {btnBack, btnFileOrder, btnClearOrders, btnRunOrders, btnGetLog};
        
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
        tf1.setBackground(vars.tfBGColor);
        tf1.setForeground(vars.tfFGColor);
        tf1.setPreferredSize(new Dimension(400, 200));
        btnRunOrders.setForeground(Color.RED);
        mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));
        title.setForeground(Color.YELLOW);
        title.setFont(new Font(null, Font.BOLD, 22));
        
//		SETUP BUTTON ACTION LISTENERS
//        menuOrder.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//
//			}
//
//        });
//        
//        fileOrder.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//
//			}
//
//        });
        
        btnFileOrder.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
        		// TODO Auto-generated method stub
        	}
        	
        });
        btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new MainSnapGUI();
				frame.dispose();
			}

        });
        
//        PANEL MAKEUP
        panelTop.add(title);  
        panel1.add(labelOrderByFile);
        panel2.add(btnFileOrder);
        panel3.add(labelOrderList);
        panel4.add(btnClearOrders);
        panel4.add(btnRunOrders);
        panel4.add(btnGetLog);
        panelBottom.add(btnBack);
        
//        MAIN PANEL MAKEUP
        mp.add(panelTop);
        mp.add(panel1);
        mp.add(panel2);
        mp.add(panel3);
        mp.add(panel4);
        mp.add(panelBottom);
        
//        FRAME MAKEUP
        frame.add(mp);  
        frame.setSize(400, 300);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  
        title.requestFocus();
		
	}

}
