package mmmm;

import mmmm.vars.OrderType;

//ORDER OBJECT THAT HOLDS THE TYPE OF ORDER, USER DETAILS, AND A STATUS STRING
public class Order {
	
	private UserDetails userDetails;
	private OrderType orderType;
	private int count;
	private String status;
	
	public Order(UserDetails userDetails, OrderType orderType, int count) {
		this.userDetails = userDetails;
		this.orderType = orderType;
		this.count = count;
		this.status = "Not started yet";
	}
	
	public String getStatus() {
		return status;
	}
	
	public OrderType getOrderType() {
		return orderType;
	}
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public int getCount() {
		return count;
	}

}
