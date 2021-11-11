package mmmm;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class OrderManager {

	private ArrayList<Order> orderList;
	private ArrayList<String> orderStatusList;
	private Emulator emu;
	
	public OrderManager() {
		this.orderList = new ArrayList<Order>();
		this.orderStatusList = new ArrayList<String>();
		try {
			this.emu = new Emulator("emu");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR CREATING EMULATOR IN ORDER MANAGER");
			e.printStackTrace();
		}
	}
	
	public void addOrder(Order order) {
		orderList.add(order);
		orderStatusList.add("Not started");
	}
	
//	Get back an arraylist of strings that represent the current order statuses
	public ArrayList<String> getLog() {
		ArrayList<String> statusList = new ArrayList<String>();
		for(int i=0; i<orderList.size(); i++) {
			String orderStatus = orderList.get(i).getOrderType().toString();
			orderStatus += "   ===>   ";
			orderStatus += orderList.get(i).getStatus();
			statusList.add(orderStatus);
		}
		return statusList;
	}
	
}
