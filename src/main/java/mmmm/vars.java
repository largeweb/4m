package mmmm;

import java.awt.Color;

//THIS IS A GLOBAL VARIABLE CLASS
public class vars {
	
	public static Color panelBGColor, panelFGColor, labelBGColor, labelFGColor, btnBGColor, btnFGColor, tfBGColor, tfFGColor;
	public enum OrderType {SNAPLOGINQA, SNAPMAKEACCOUNT, SNAPMESSAGEALL, SNAPUNLOCKACCT};
	
	public static void setup() {
		
		panelBGColor = Color.DARK_GRAY;
		panelFGColor = null;
		labelBGColor = null;
		labelFGColor = Color.YELLOW;
		btnBGColor = Color.BLACK;
		btnFGColor = Color.YELLOW;
		tfBGColor = Color.GRAY;
		tfFGColor = Color.ORANGE;
		
	}
	
}
