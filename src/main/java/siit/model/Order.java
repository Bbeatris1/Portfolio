package siit.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
	private int id;
	
	private Map<Product, Integer> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Product, Integer> getProducts() {
		if (products == null){
			products = new HashMap<>();
		}
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", products=" + products + "]";
	}
	
	
	
}
