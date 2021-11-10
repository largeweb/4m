package mmmm;

import java.util.ArrayList;

public class OrderManager {

	private ArrayList<Order> orderList;
	private ArrayList<String> orderStatusList;
	
	public OrderManager() {
		this.orderList = new ArrayList<Order>();
		this.orderStatusList = new ArrayList<String>();
	}
	
//	Get back an arraylist of strings that represent the current order statuses
	public ArrayList<String> getStatus() {
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
