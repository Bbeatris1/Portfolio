package siit.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int id;
	
	private String name;
	
	private String phone;
	
	private List<Order> orders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Order> getOrders() {
		if (orders == null){
			orders = new ArrayList<>();
		}
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", orders=" + orders + "]";
	}
	
	
	
}
