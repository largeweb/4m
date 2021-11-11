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
	private JLabel labelTitle, checkApmLab, label, label2, labelx, labelNeac, labelVald, labelPh, orderS, runLog, dvnLab, savePLab, loadPLab, mainLog, leftTDLab;
	private JButton bigTest, savePBtn, loadPBtn, instructBtn, findSnapBtn, openApnBtn, closeApmBtn, checkApmBtn, clrBtn, emlBtn, rphBtn, unlkBtn, loqaBtn, addPicBtn, locpBtn, mkacBtn, valdBtn, FEBtn, getLogBtn, back;
	private JTextField tF1, tF2, tF3, tFPh, tFN, dvnTF, savePTF;
	private JComboBox loadBox;
	
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
		        JLabel labelTitle = new JLabel("Snapchat Menu");  
		        final JLabel label = new JLabel("Username");  
		        JLabel label2 = new JLabel("   Password");  
		        JLabel leftTDLab = new JLabel("<html>Plans:   Add realtime log   |   Finalize Make Acct   |   Add Instructions<br>Get rid of emu/phone buttons   |   Fix Upload Pic button   |   Do testing with everything<br>Add bitmoji to acct button   |   Tag someone in story post   |   blue arrow image/username/more<br>Get support for multiple appium servers & emulators   |   Get everything hosted on web server</html>");  
		        JLabel labelx = new JLabel("x");  
		        JLabel labelNeac = new JLabel("NEW ACCOUNT:      Name:");  
		        JLabel labelPh = new JLabel("     Phone #:");  
		        JLabel dvnLab = new JLabel("     Device Name:");  
		        final JLabel orderS = new JLabel("Orders (first to last) : ");
//		        final JLabel currentTask = new JLabel("Currently doing: ");
		        final JLabel emptySpace = new JLabel("       |       ");
		        final JLabel mainLog = new JLabel("");
		        JLabel savePLab = new JLabel("Save Properties:");
		        JLabel loadPLab = new JLabel("Load Properties:");
//		        final JLabel runLog = new JLabel("LOG: ");
//		        JLabel labelVald = new JLabel("     Validate Code");  
		        final JButton emlBtn = new JButton("Emulator");  
		        final JButton rphBtn = new JButton("Phone");  
		        final JButton openApmBtn = new JButton("Start Appium");  
		        final JButton getLogBtn = new JButton("Get Log");  
		        JButton savePBtn = new JButton("Save");  
		        JButton loadPBtn = new JButton("Load");  
		        JButton closeApmBtn = new JButton("Close Appium");  
		        JButton findSnapBtn = new JButton("Find Snapchat Apk");  
		        JButton checkApmBtn = new JButton("Check Appium Status");  
		        JButton clrBtn = new JButton("Colors");  
		        JButton unlkBtn = new JButton("Unlock with Browser");  
		        JButton loqaBtn = new JButton("Login & Quick Add");  
		        JButton mkacBtn = new JButton("Make Account");  
		        JButton addPicBtn = new JButton("Add Pic to CRoll");  
		        JButton locpBtn = new JButton("Login & Post Last CRoll");  
//		        JButton valdBtn = new JButton("Send");  
		        JButton clearOBtn = new JButton("Clear Orders");  
		        JButton FEBtn = new JButton("Open Folder");  
		        JButton back = new JButton("Back");
		        JButton bigTest = new JButton("TEST BUTTON");
		        final JButton runBtn = new JButton("RUN ORDERS");  
		        JButton instructBtn = new JButton("?");  
		        tF1 = new JTextField();
		        tF2 = new JTextField();
		        tF3 = new JTextField("1");
		        tFPh = new JTextField();
		        tFN = new JTextField();
		        dvnTF = new JTextField();
		        savePTF = new JTextField();
//		        valdBox = new JTextField();
		        loadBox = new JComboBox();
		        
		        
//		        ORGANIZE
		        JPanel[] panelArr = {mp, panelTop, panelInfo1, panelInfo2, panelInfo3, panelAction1, panelAction2, panelAction3, panelOrder1, panelOrder2};
		        JLabel[] labelArr = {mainLog, savePLab, loadPLab, labelTitle, label, dvnLab, label2, labelx, labelNeac, labelPh, orderS, emptySpace};
		        JButton[] buttonArr = {getLogBtn, addPicBtn, locpBtn, FEBtn, savePBtn, loadPBtn, openApmBtn, closeApmBtn, instructBtn, clrBtn, emlBtn, rphBtn, unlkBtn, loqaBtn, mkacBtn, clearOBtn, runBtn, back};
		        final JTextField[] tFArr = {savePTF, tF1, tF2, tF3, tFPh, tFN, dvnTF};
		        
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
		        for(int i=0;i<tFArr.length;i++) {
		        	tFArr[i].setBackground(vars.tfBGColor);
		        	tFArr[i].setForeground(vars.tfFGColor);
		        };
		        mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));
		        labelTitle.setForeground(Color.YELLOW);
		        labelTitle.setFont(new Font(null, Font.BOLD, 22));
		        tF1.setPreferredSize(new Dimension(120, 30));
		        tF2.setPreferredSize(new Dimension(120, 30));
		        dvnTF.setPreferredSize(new Dimension(120, 30));
		        tF3.setPreferredSize(new Dimension(30, 30));
		        tFPh.setPreferredSize(new Dimension(90, 30));
		        tFN.setPreferredSize(new Dimension(90, 30));
		        savePTF.setPreferredSize(new Dimension(90, 30));
		        loadBox.setPreferredSize(new Dimension(90, 30));
				emlBtn.setForeground(labelTitle.getForeground());
				emlBtn.setFont(new Font(null, Font.BOLD, 13));
				rphBtn.setForeground(null);
				runBtn.setForeground(Color.RED);
				getLogBtn.setEnabled(false);
				loadBox.setBackground(vars.tfBGColor);
				loadBox.setForeground(vars.tfFGColor);
		        
//		        BUTTON ACTIONS
		        back.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						new MainSnapGUI();
						frame.dispose();
					}

		        });
		        bigTest.addActionListener(new ActionListener() {

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
		        panelTop.add(back);  
		        panelTop.add(bigTest);
		        
		        panelInfo1.add();
		        panelInfo2.add();
		        panelInfo3.add();
		        
		        panelAction1.add();
		        panelAction2.add();
		        panelAction3.add();
		        
		        panelOrder1.add();
		        panelOrder2.add();
		        
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
				mainLog.setText(text);
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
