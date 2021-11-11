package mmmm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

//THIS IS THE MANUAL SNAP GUI
public class SnapManualGUI implements ActionListener {
	
	private JFrame frame;
	private JPanel mp, panelTop, panelInfo1, panelInfo2, panelInfo3, panelAction1, panelAction2, panelAction3, panelOrder1, panelOrder2;
	private JLabel labelTitle, labelInfo1, labelInfo2, labelInfo3, labelInfo4, labelInfo5, labelInfo6;
	private JTextField tfInfo1, tfInfo2, tfInfo3, tfInfo4, tfInfo5, tfInfo6;
	private JButton btnBigTest, btnBack, btnMakeAccount, btnUnlockWithBrowser, btnLoginQA, btnStartAppium, btnClearOrders, btnRunOrders, btnGetLog;
	private ArrayList<Order> orderList;
	
	public SnapManualGUI() {

//				INITIALIZE FRAME + PANELS
		        frame = new JFrame("MMMM: Snapchat Menu");
		        mp = new JPanel();
		        panelTop = new JPanel();  
		        panelInfo1 = new JPanel();  
		        panelInfo2 = new JPanel();  
		        panelInfo3 = new JPanel(); 
		        panelAction1 = new JPanel();  
		        panelAction2 = new JPanel();  
		        panelAction3 = new JPanel();  
		        panelOrder1 = new JPanel();  
		        panelOrder2 = new JPanel();
		        
//		        INITIALIZE LABELS
		        JLabel labelTitle = new JLabel("SNAPCHAT MENU");  
		        JLabel labelInfo1 = new JLabel("Username");  
		        JLabel labelInfo2 = new JLabel("Password");  
		        JLabel labelInfo3 = new JLabel("Name");  
		        JLabel labelInfo4 = new JLabel("Phone Number");  
		        JLabel labelInfo5 = new JLabel("Email"); 
		        JLabel labelInfo6 = new JLabel("Repeat Order");  
		        JLabel labelOrderList = new JLabel("Orders: ");
		        
//		        INITIALIZE BUTTONS
		        JButton btnBigTest = new JButton("BIG TEST BUTTON");
		        JButton btnBack = new JButton("Back");
		        JButton btnMakeAccount = new JButton("Back");
		        JButton btnUnlockWithBrowser = new JButton("Back");
		        JButton btnLoginQA = new JButton("Back");
		        JButton btnStartAppium = new JButton("Back");
		        JButton btnClearOrders = new JButton("Back");
		        JButton btnRunOrders = new JButton("Back");
		        JButton btnGetLog = new JButton("Back");
		        
//		        INITIALIZE TEXT FIELDS
		        JTextField tfInfo1 = new JTextField("TF1");
		        
//		        ORGANIZE
		        JPanel[] panelArr = {mp, panelTop, panelInfo1, panelInfo2, panelInfo3, panelAction1, panelAction2, panelAction3, panelOrder1, panelOrder2};
		        JLabel[] labelArr = {labelTitle, labelInfo1, labelInfo2, labelInfo3, labelInfo4, labelInfo5, labelInfo6};
		        JButton[] buttonArr = {btnBigTest, btnBack, btnMakeAccount, btnUnlockWithBrowser, btnLoginQA, btnStartAppium, btnClearOrders, btnRunOrders, btnGetLog};
		        JTextField[] tfArr = {tfInfo1,tfInfo2, tfInfo3, tfInfo4, tfInfo5, tfInfo6};
		        
//		        SET PROPERTIES
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
		        for(int i=0;i<tfArr.length;i++) {
		        	tFArr[i].setBackground(vars.tfBGColor);
		        	tFArr[i].setForeground(vars.tfFGColor);
		        };
		        this.orderList = new ArrayList<Order>();
		        mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));
		        labelTitle.setForeground(Color.YELLOW);
		        labelTitle.setFont(new Font(null, Font.BOLD, 22));
		        tfInfo1.setPreferredSize(new Dimension(120, 30));
		        tfInfo2.setPreferredSize(new Dimension(120, 30));
		        tfInfo3.setPreferredSize(new Dimension(120, 30));
		        tfInfo4.setPreferredSize(new Dimension(120, 30));
		        tfInfo5.setPreferredSize(new Dimension(120, 30));
		        tfInfo6.setPreferredSize(new Dimension(120, 30));
				btnRunOrders.setForeground(Color.RED);
				btnGetLog.setEnabled(false);
		        
//		        BUTTON ACTIONS
		        btnBack.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new MainSnapGUI();
						frame.dispose();
					}

		        });
		        btnBigTest.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
//						// TODO Auto-generated method stub
//						try {
//							emu = new Emulator("p4a");
//						} catch (MalformedURLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
////						try {
////							testemu = new Emulator("testemu");
////						} catch (MalformedURLException e) {
////							// TODO Auto-generated catch block
////							e.printStackTrace();
////						}
//						emu.getDriver().findElementById("com.android.chrome:id/send_report_checkbox").click();
					}

		        });
		        
//		        PANEL MAKEUP
		        panelTop.add(labelTitle); 
		        panelTop.add(btnBack);  
		        panelTop.add(btnBigTest);

		        panelInfo1.add(labelInfo1);
		        panelInfo1.add(tfInfo1);
		        panelInfo1.add(labelInfo2);
		        panelInfo1.add(tfInfo2);
		        panelInfo1.add(labelInfo3);
		        panelInfo1.add(tfInfo3);
		        panelInfo1.add(labelInfo4);
		        panelInfo1.add(tfInfo4);
		        panelInfo1.add(labelInfo5);
		        panelInfo1.add(tfInfo5);
		        panelInfo1.add(labelInfo6);
		        panelInfo1.add(tfInfo6);
		        
		        panelAction1.add(btnMakeAccount);
		        panelAction2.add(btnUnlockWithBrowser);
		        panelAction3.add(btnLoginQA);
		        
		        panelOrder1.add(labelOrderList);
		        panelOrder2.add(btnStartAppium);
		        panelOrder2.add(btnClearOrders);
		        panelOrder2.add(btnRunOrders);
		        panelOrder2.add(btnGetLog);
		        
//		        MAIN PANEL MAKEUP
		        mp.add(panelTop);
		        mp.add(panelInfo1);
		        mp.add(panelInfo2);
		        mp.add(panelInfo3);
		        mp.add(panelAction1);
		        mp.add(panelAction2);
		        mp.add(panelAction3);
		        mp.add(panelOrder1);
		        mp.add(panelOrder2);
		        
//		        FRAME MAKEUP
		        frame.add(mp);  
		        frame.setSize(700, 450);  
		        frame.setLocationRelativeTo(null);  
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setVisible(true);  
		        labelTitle.requestFocus();

			}
			
			public void setMainLog(String text) {
//				mainLog.setText(text);
			}
			
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				vars.setup();
				new SnapManualGUI();
			}

			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
			}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
