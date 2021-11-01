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

//THIS IS THE MANUAL SNAP GUI
public class SnapManualGUI implements ActionListener {
	
	static JFrame frame;
//			private JFrame frameV;
	private JPanel mp;
//			private JPanel mpV;
	private JPanel panel0_5;
	private JPanel panel0_6;
	private JPanel panel0_8;
	private JPanel panel;
	private JPanel panel1_5;
//			private JPanel panelV;
	private JPanel panel2;
	private JPanel panel2_3;
	private JPanel panel2_5;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JLabel labelTitle;
	private JLabel checkApmLab;
	private JLabel label;
	private JLabel label2;
	private JLabel labelx;
	private JLabel labelNeac;
	private JLabel labelVald;
	private JLabel labelPh;
	private JLabel orderS;
	private JLabel runLog;
	private JLabel dvnLab;
	private JLabel savePLab;
	private JLabel loadPLab;
	private JLabel mainLog;
	private JLabel leftTDLab;
	private JButton savePBtn;
	private JButton loadPBtn;
	private JButton instructBtn;
	private JButton findSnapBtn;
	private JButton openApnBtn;
	private JButton closeApmBtn;
	private JButton checkApmBtn;
	private JButton clrBtn;
	private JButton emlBtn;
	private JButton rphBtn;
	private JButton unlkBtn;
	private JButton loqaBtn;
	private JButton addPicBtn;
	private JButton locpBtn;
	private JButton mkacBtn;
	private JButton valdBtn;
	private JButton FEBtn;
	private JButton getLogBtn;
	private JTextField tF1;
	private JTextField tF2;
	private JTextField tF3;
	private JTextField tFPh;
	private JTextField tFN;
	private JTextField dvnTF;
	private JTextField savePTF;
//			private JTextField valdBox;
	private JComboBox loadBox;
	private String os = "";
	private String dvN;
//			private String currentTask = "";
//			private order[] orders;
//	private ArrayList<order> orderList = new ArrayList<order>();
	private boolean emulated = true;
	private Runtime rt;
	private String fileString = "/SCNconfigs/";
//			private String fileString = "src\\test\\java\\appiumtests\\configs\\";
	private File picFile;
	private File configFolder = new File(fileString);
	private File[] listOfFiles = configFolder.listFiles();
	
//			public String lastLog = "";
	static Color panelBGColor = Color.DARK_GRAY;
	static Color panelFGColor = null;
	static Color labelBGColor = null;
	static Color labelFGColor = Color.YELLOW;
	static Color btnBGColor = Color.BLACK;
	static Color btnFGColor = Color.YELLOW;
	static Color tfBGColor = Color.GRAY;
	static Color tfFGColor = Color.ORANGE;
	static JPanel[] panelArr;
//		    static JComponent[][] mainColorArr;
	
	
	
	
	
	static JFrame frameV;
	private JPanel mpV;
	private JPanel panelV;
	private JTextField valdBox;
	
	public SnapManualGUI() {

//				INITIALIZE VARIABLES
		        frame = new JFrame("MMMM: Snapchat Menu");
		        mp = new JPanel();
		        panel0_5 = new JPanel();  
		        panel0_6 = new JPanel();  
		        panel0_8 = new JPanel();  
		        panel = new JPanel(); 
		        panel1_5 = new JPanel();  
		        panel2 = new JPanel();  
		        panel2_3 = new JPanel();  
		        panel2_5 = new JPanel();  
		        panel3 = new JPanel();
		        panel4 = new JPanel();
		        panel5 = new JPanel();
		        final JLabel labelTitle = new JLabel("Snapchat Networker");  
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
		        JPanel[] panelArr = {mp, panel0_5, panel0_6, panel0_8, panel, panel1_5, panel2, panel2_3, panel2_5, panel3, panel4};
		        JLabel[] labelArr = {mainLog, savePLab, loadPLab, labelTitle, label, dvnLab, label2, labelx, labelNeac, labelPh, orderS, emptySpace};
		        JButton[] buttonArr = {getLogBtn, addPicBtn, locpBtn, FEBtn, savePBtn, loadPBtn, openApmBtn, closeApmBtn, instructBtn, clrBtn, emlBtn, rphBtn, unlkBtn, loqaBtn, mkacBtn, clearOBtn, runBtn};
		        final JTextField[] tFArr = {savePTF, tF1, tF2, tF3, tFPh, tFN, dvnTF};
//				JComponent[][] mainColorArr = {panelArr, panelArr, labelArr, labelArr, buttonArr, buttonArr, tFArr, tFArr};
//				Color[] mainColorArr = {panelBGColor, panelFGColor, labelBGColor, labelFGColor, btnBGColor, btnFGColor, tfBGColor, tfFGColor};
		        
//		        SET PROPERTIES
		        for(int i=0;i<panelArr.length;i++) {
		        	panelArr[i].setBackground(panelBGColor);
		        	panelArr[i].setForeground(panelFGColor);
		        };
		        for(int i=0;i<labelArr.length;i++) {
		        	labelArr[i].setBackground(labelBGColor);
		        	labelArr[i].setForeground(labelFGColor);
		        };
		        for(int i=0;i<buttonArr.length;i++) {
		        	buttonArr[i].setBackground(btnBGColor);
		        	buttonArr[i].setForeground(btnFGColor);
		        };
		        for(int i=0;i<tFArr.length;i++) {
		        	tFArr[i].setBackground(tfBGColor);
		        	tFArr[i].setForeground(tfFGColor);
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
				loadBox.setBackground(tfBGColor);
				loadBox.setForeground(tfFGColor);
//				for(int i=0;i<listOfFiles.length;i++) {
//					loadBox.addItem(listOfFiles[i].getName());
//				}
//		        valdBox.setPreferredSize(new Dimension(60, 30));
		        
////		        BUTTON ACTIONS
//				instructBtn.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						new instructionGUI();
//					}
//				});
//				savePBtn.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						Properties p = new Properties();
//						String fileName = savePTF.getText();
//						File saveFile = new File(fileString + fileName + ".properties");
////						File saveFile = new File("src\\test\\java\\appiumtests\\configs\\" + fileName + ".properties");
//						try {
//							saveFile.createNewFile();
//							loadBox.addItem(fileName+".properties");
//							InputStream in = new FileInputStream(saveFile);
//							p.load(in);
//							for(int i=0;i<tFArr.length;i++) {
//								p.setProperty(Integer.toString(i), tFArr[i].getText());
//							}
//							p.store(new FileOutputStream(saveFile), fileName);
//							mainLog.setText(fileName+".properties has been saved");
//							mainLog.setForeground(Color.GREEN);   
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
//				});
//				loadPBtn.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						Properties p = new Properties();
//						String fileName = (String) loadBox.getSelectedItem();
//						File loadFile = new File(fileString + fileName);
//						try {
//							InputStream in = new FileInputStream(loadFile);
//							p.load(in);
//							for(int i=0;i<tFArr.length;i++) {
//								tFArr[i].setText(p.getProperty(Integer.toString(i)).trim());
//							}
//							mainLog.setText(fileName+".properties has been loaded");
//							mainLog.setForeground(Color.GREEN);   
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
//				});
////				instructBtn.addActionListener(new ActionListener() {
////					public void actionPerformed(ActionEvent e) {
////						
////					}
////				});
//		        unlkBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		String username = tF1.getText();
//		        		String password = tF2.getText();
//		        		if(tF1.getText().length() == 0 || tF2.getText().length() == 0) {        			
//		        			mainLog.setText("Fill in username and password");
//		        			mainLog.setForeground(Color.RED);
//		        		} else {
//		        			mainLog.setText("Order added");
//		        			mainLog.setForeground(Color.GREEN);        			
//		        			os += "UNLK "+username.charAt(0)+".../"+password.charAt(0)+"... "+"    |    ";
//		        			orderList.add(new order(1, os, 1, username, password, "", ""));
//		        			orderS.setText("Orders (first to last) : " + os);
//		        		}
//		        	}
//		        });
//		        clrBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		new colorPickGUI();
//		        	}
//		        });
//		        emlBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		emulated = true;
//		        		emlBtn.setForeground(labelTitle.getForeground());
//		        		emlBtn.setFont(new Font(null, Font.BOLD, 13));
//		        		rphBtn.setForeground(null);
//		    			mainLog.setText("Emulator Selected");
//		    			mainLog.setForeground(Color.GREEN); 
//		        	}
//		        });
//		        rphBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		emulated = false;
//		        		emlBtn.setForeground(null);
//		        		emlBtn.setFont(label.getFont());
//		        		rphBtn.setForeground(labelTitle.getForeground());
//		        		rphBtn.setFont(new Font(null, Font.BOLD, 13));
//		    			mainLog.setText("Phone Selected");
//		    			mainLog.setForeground(Color.GREEN); 
//		        	}
//		        });
//		        loqaBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		String username = tF1.getText();
//		        		String password = tF2.getText();
//		        		if(tF1.getText().length() == 0 || tF2.getText().length() == 0) {        			
//		        			mainLog.setText("Fill in username and password");
//		        			mainLog.setForeground(Color.RED);
//		        		} else {
//		        			mainLog.setText("Order added");
//		        			mainLog.setForeground(Color.GREEN);        			
//		        		}
//		        		int count = Integer.parseInt(tF3.getText());
//		        		os += "LOQA "+username.charAt(0)+".../"+password.charAt(0)+"... "+"(x"+count+")    |    ";
//		        		orderList.add(new order(2, os, count, username, password, "", ""));
//		        		orderS.setText("Orders (first to last) : " + os);
//		        	}
//		        });
//		        locpBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		String username = tF1.getText();
//		        		String password = tF2.getText();
//		        		if(tF1.getText().length() == 0 || tF2.getText().length() == 0) {        			
//		        			mainLog.setText("Fill in username and password");
//		        			mainLog.setForeground(Color.RED);
//		        		} else {
//		        			mainLog.setText("Order added");
//		        			mainLog.setForeground(Color.GREEN);        			
//		        		}
//		        		os += "LOCP "+username.charAt(0)+".../"+password.charAt(0)+"... "+"    |    ";
//		        		orderList.add(new order(4, os, 1, username, password, "", ""));
//		        		orderS.setText("Orders (first to last) : " + os);
//		        	}
//		        });
//		        addPicBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		try
//		        		{
//		        		JFileChooser jfc = new JFileChooser();
//		        	    jfc.showDialog(null,"Please Select the PIC");
//		        	    jfc.setVisible(true);
//		        	    picFile = jfc.getSelectedFile();
//		        	    System.out.println("File name "+picFile.getName());
//		    			os += "ADDP "+picFile.getName().charAt(0)+picFile.getName().charAt(1)+picFile.getName().charAt(2)+"..."+"    |    ";
//		    			orderList.add(new order(5, os, 1, "", "", "", ""));
//		    			orderS.setText("Orders (first to last) : " + os);
//		    			mainLog.setText(picFile.getName()+" to add to device is added to order queue");
//		    			mainLog.setForeground(Color.GREEN);
//		        		} catch(Exception ee) {
//		        			mainLog.setText("No order added - please select a file");
//		        			mainLog.setForeground(Color.RED);
//		        		}
//		        	}
//		        });
//		        mkacBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		String username = tF1.getText();
//		        		String password = tF2.getText();
//		        		String number = tFPh.getText();
//		        		String name = tFN.getText();
//		        		if(tF1.getText().length() == 0 || tF2.getText().length() == 0 || tFPh.getText().length() == 0) {        			
//		        			mainLog.setText("Fill in username, password, and phone");
//		        			mainLog.setForeground(Color.RED);
//		        		} else {
//		        			mainLog.setText("Order added");
//		        			mainLog.setForeground(Color.GREEN);        			
//		        		}
//		        		os += "MKAC "+username.charAt(0)+".../"+password.charAt(0)+"... "+"    |    ";
//		        		orderList.add(new order(3, os, 1, username, password, number, name));
//		        		orderS.setText("Orders (first to last) : " + os);
////		        		new valdGUI();
//		        	}
//		        });
////		        valdBtn.addActionListener(new ActionListener() {
////		        	public void actionPerformed(ActionEvent e) {
////		        		valdCode = valdBox.getText();
////		        	}
////		        });
//		        openApmBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		rt = Runtime.getRuntime();
//		        		try {
//							rt.exec("cmd.exe /c start /MIN cmd.exe /k appium");
//							openApmBtn.setEnabled(false);
//							openApmBtn.setText("<html><font color=yellow>Appium Opened</font></html>");
//							runBtn.setEnabled(false);
//							Thread.sleep(3000);
//							runBtn.setEnabled(true);
//		        			mainLog.setText("<html>Appium opened as a minimized task.<br><font color=orange>NOTE** appium is a separate process and does not automatically close with this program.<br>You can view this process in your taskbar.</font></html>");
//		        			mainLog.setForeground(Color.GREEN); 
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						} catch (InterruptedException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//		        	}
//		        });
////		        closeApmBtn.addActionListener(new ActionListener() {
////		        	public void actionPerformed(ActionEvent e) {
////						rt.exit(0);
////		        	}
////		        });
//		        clearOBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		orderList.removeAll(orderList);
//		        		os = "";
//		        		orderS.setText("Orders (first to last) : ");
//		    			mainLog.setText("Orders Cleared");
//		    			mainLog.setForeground(Color.GREEN); 
//		        	}
//		        });
//		        FEBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		File f = new File(fileString);
//		        		try {
//							Runtime.getRuntime().exec("explorer.exe /select," + f);
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//		        	}
//		        });
//		        getLogBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		if(RunnableTest.errorB == true) {
//		        			mainLog.setText("THERE WAS AN ERROR - IS APPIUM AND EMULATOR OPEN?");
//		        			mainLog.setForeground(Color.red);        	
//		        			getLogBtn.setEnabled(false);
//		        		} else {        			
//		        			mainLog.setText(openSnap.taskLog);
//		        		}
//		        	}
//		        });
//		        runBtn.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		getLogBtn.setEnabled(true);
//		        		String username = tF1.getText();
//		        		String password = tF2.getText();
//		        		String name = tFN.getText();
//		        		if(orderList.size()==0) {
//		        			mainLog.setText("No orders are queued");
//		        			mainLog.setForeground(Color.RED); 
//		        		}
//		        		if(openApmBtn.isEnabled()) {
//		        			mainLog.setText("Orders will not run if appium isn't opened");
//		        			mainLog.setForeground(Color.ORANGE); 
//		        		}
//		        		for(int i=0;i<orderList.size();i++) {
//		        			if(orderList.get(i).actionID == 1) {
////		                		try {
//		                			mainLog.setText("Running Orders");
//		                			mainLog.setForeground(Color.GREEN); 
//		                    		RunnableTest R1 = new RunnableTest("Thread-1");
//		                    		R1.start("openBrowser", orderList.get(i).username, orderList.get(i).password, null, null, dvN, 1);
////		                			openSnap.openBrowser(orderList.get(i).username, orderList.get(i).password, dvN, emulated);
//////		                			currentTask.setText("Finished: "+orderList.get(i).oString);
////		                		} catch (MalformedURLException e1) {
////		                			currentTask.setText("Failed: "+orderList.get(i).oString);
//		                			// TODO Auto-generated cat/ch block
////		                			e1.printStackTrace();
////		                		} catch (InterruptedException e1) {
////									// TODO Auto-generated catch block
////									e1.printStackTrace();
////								}
//		        			}
//		        			if(orderList.get(i).actionID == 2) {
//		        				for(int j=0;j<orderList.get(i).count;j++) {        					
////		        					try {
//		        						RunnableTest R1 = new RunnableTest("Thread-1");
//		                        		R1.start("quickAdd", orderList.get(i).username, orderList.get(i).password, null, null, dvN, orderList.get(i).count);
////		        						openSnap.quickAdd(openSnap.loginSnap(orderList.get(i).username, orderList.get(i).password, dvN, emulated), emulated, 5);
////		        					} catch (Throwable e1) {
////		        						mainLog.setText("WAS UNABLE TO RUN - CHECK IF APPIUM AND EMULATOR ARE OPEN");
////		        						mainLog.setForeground(Color.red);
//		        						// TODO Auto-generated catch block
////		        						e1.printStackTrace();
////		        					} catch (InterruptedException e1) {
//		        						// TODO Auto-generated catch block
////		        						e1.printStackTrace();
////		        					} catch (Throwable e1) {
//		        						// TODO Auto-generated catch block
////		        						e1.printStackTrace();
////		        					}
//		        				}
//		        			}
//		        			if(orderList.get(i).actionID == 3) { 
//		        				String number = tFPh.getText();
////								try {
//									RunnableTest R1 = new RunnableTest("Thread-1");
//		                    		R1.start("makeAcct", orderList.get(i).username, orderList.get(i).password, orderList.get(i).number, orderList.get(i).name, dvN, 1);
////									openSnap.makeAcct(orderList.get(i).username, orderList.get(i).password, orderList.get(i).number, orderList.get(i).name, dvN, emulated);
////								} catch (Throwable e1) {
//									// TODO Auto-generated catch block
////									e1.printStackTrace();
////								}
//		        			}
//		        			if(orderList.get(i).actionID == 4) { 
//		        				String number = tFPh.getText();
////		        				try {
//		        					RunnableTest R1 = new RunnableTest("Thread-1");
//		                    		R1.start("camSPost", orderList.get(i).username, orderList.get(i).password, null, null, dvN, 1);
////		        					openSnap.camSPost(orderList.get(i).username, orderList.get(i).password, dvN, emulated);
////		        				} catch (Throwable e1) {
//		        					// TODO Auto-generated catch block
////		        					e1.printStackTrace();
////		        				}
//		        			}
//		        			if(orderList.get(i).actionID == 5) { 
////		        				picFile;
//		        				try {
////		        					openSnap.pushPic(dvN, picFile);
//		        				} catch (Throwable e1) {
//		        					// TODO Auto-generated catch block
//		        					e1.printStackTrace();
//		        				}
//		        			}
//		        		}
//		        	}
//		        });
		        
//		        PANEL MAKEUP
		        panel0_5.add(labelTitle);  
		        panel0_5.add(instructBtn);  
//		        panel0_5.add(clrBtn);  

		        panel0_6.add(mainLog);  
		        
		        panel0_8.add(savePLab);  
		        panel0_8.add(savePTF);  
		        panel0_8.add(savePBtn);  
		        panel0_8.add(loadPLab);  
		        panel0_8.add(loadBox);  
		        panel0_8.add(loadPBtn);  
		        panel0_8.add(FEBtn);  
//		        panel0_8.add(checkApmBtn);  
//		        panel0_8.add(checkApmLab);  

		        panel.add(label);  
		        panel.add(tF1);
		        panel.add(label2);  
		        panel.add(tF2);
		        panel.add(emlBtn);
		        panel.add(rphBtn);
		        
		        panel1_5.add(dvnLab);
		        panel1_5.add(dvnTF);
		        
		        panel2.add(unlkBtn);
		        panel2.add(emptySpace);
		        panel2.add(loqaBtn);
		        panel2.add(labelx);
		        panel2.add(tF3);
		        
		        panel2_3.add(addPicBtn);
		        panel2_3.add(locpBtn);
		        
		        panel2_5.add(labelNeac);
		        panel2_5.add(tFN);
		        panel2_5.add(labelPh);
		        panel2_5.add(tFPh);
		        panel2_5.add(mkacBtn);
//		        panel2_5.add(labelVald);
//		        panel2_5.add(valdBox);
//		        panel2_5.add(valdBtn);
		        
		        panel3.add(orderS);
		        
		        panel4.add(openApmBtn);  
//		        panel4.add(closeApmBtn);  
		        panel4.add(clearOBtn);
		        panel4.add(runBtn);
		        panel4.add(getLogBtn);
		        
//		        panel5.add(currentTask);
//		        panel5.add(emptySpace);
//		        panel5.add(runLog);
		        panel5.add(leftTDLab);
		        
//		        MAIN PANEL MAKEUP
		        mp.add(panel0_5);
		        mp.add(panel0_6);
		        mp.add(panel0_8);
		        mp.add(panel);
//		        mp.add(panel1_5);
		        mp.add(panel2);
		        mp.add(panel2_3);
		        mp.add(panel2_5);
		        mp.add(panel3);
		        mp.add(panel4);
		        mp.add(panel5);
		        
//		        FRAME MAKEUP
		        frame.add(mp);  
//		        frame.add(panel2);
		        frame.setSize(700, 450);  
//		        frame.setPreferredSize(new Dimension(400, 400));
		        frame.setLocationRelativeTo(null);  
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setVisible(true);  
		        labelTitle.requestFocus();

		        
		        
//		        TRY TO ADD DECORATION/COLOR
		        
		        
		        
			}
			
			public void setMainLog(String text) {
				mainLog.setText(text);
			}
			
			public static void main(String[] args) {
				// TODO Auto-generated method stub
//				File f = new File("/SCNconfigs/");
////				File f = new File("src\\test\\java\\appiumtests\\configs");
//				if (!f.exists()){
//				    f.mkdirs();
//				}
//				RunnableTest R1 = new RunnableTest("Thread-1");
//				R1.start();
//				RunnableTest R2 = new RunnableTest("Thread-2");
//				R2.start();
//				new valdGUI();
			}

			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
//				label.setText("test");
			}
			
		//TESTING
//			protected void paintComponent(Graphics g) {
		//
//			    super.paintComponent(g);
//			        g.drawImage(bgImage, 0, 0, null);
//			}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
