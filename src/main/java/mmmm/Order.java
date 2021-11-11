package mmmm;

import mmmm.vars.OrderType;

//ORDER OBJECT THAT HOLDS THE TYPE OF ORDER, USER DETAILS, AND A STATUS STRING
public class Order {
	
	private UserDetails userDetails;
	private OrderType orderType;
	private String status;
	
	public Order(UserDetails userDetails, OrderType snapOrderType) {
		this.userDetails = userDetails;
		this.orderType = snapOrderType;
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

}
