/**
 * @author Mustafa Youldash <mmyouldash@uqu.edu.sa>.
 * @copyright (c) 2016 Umm Al-Qura University. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * * Neither the name of the author nor the names of its contributors may be used
 * to endorse or promote products derived from this software without specific
 * prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * Standing Order System package created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */
package standingordersystem;

import java.lang.String;
import java.util.HashSet;
import java.util.Set;

/**
 * Delivery class.
 */
public class Delivery {

	private String id;
	private Customer customer;
	private Address address;
	private int date;
	private DayOfWeek day;
	private Set<DeliveryItem> deliveryItems;
	
	/**
	 * Default constructor.
	 * 
	 * @param id
	 * @param customer
	 * @param address
	 * @param date
	 * @param day
	 * @param deliveryItems
	 */
	public Delivery(String id, Customer customer, Address address, int date, DayOfWeek day) {
		
		/*
		 * Assuming that all parameters are not null. No error handling is made for simplicity. 
		 */
		setId(id);
		setCustomer(customer);
		setAddress(address);
		setDate(date);
		setDayOfWeek(day);
		setDeliveryItems(new HashSet<DeliveryItem>());
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		
		this.id = id;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		
		this.customer = customer;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		
		this.address = address;
	}

	/**
	 * @return the date
	 */
	public int getDate() {
		
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(int date) {
		
		this.date = date;
	}

	/**
	 * @return the dayOfWeek
	 */
	public DayOfWeek getDayOfWeek() {
		
		return day;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(DayOfWeek day) {
		
		this.day = day;
	}

	/**
	 * @return the deliveryItems
	 */
	public Set<DeliveryItem> getDeliveryItems() {
		
		return deliveryItems;
	}

	/**
	 * @param the deliveryItems
	 */
	public void setDeliveryItems(Set<DeliveryItem> deliveryItems) {
		
		this.deliveryItems = deliveryItems;
	}
	
	/**
	 * Add a delivery item.
	 * 
	 * @param deliveryItem
	 */
	public void addDeliveryItem(DeliveryItem deliveryItem) {
		
		/*
		 * If the order status is still active, create and add the new item
		 */
		if (deliveryItem.getOrder().getStatus() == OrderStatus.active) {
			
			this.deliveryItems.add(deliveryItem);
			
		} else {
			
			System.out.println("ERROR addDeliveryItem: OrderStatus.closed!");
		}
	}
	
	/**
	 * Add a delivery item.
	 * 
	 * @param order
	 * @param quantity
	 * @param difference
	 * @throws Exception
	 */
	public void addDeliveryItem(Order order, int quantity, int difference) {
		
		/*
		 * If the order status is still active, create and add the new item
		 */
		if (order.getStatus() == OrderStatus.active) {
			
			this.deliveryItems.add(new DeliveryItem(order, quantity, difference));
			
		} else {
			
			System.out.println("ERROR addDeliveryItem: OrderStatus.closed!");
		}
	}
	
	/**
	 * @return a string description
	 */
	public String toString() {
		
		return "Delivery[id: " + getId() +
			", customer: " + getCustomer().toString() +
			", address: " + getAddress().toString() +
			", date: " + getDate() +
			", dayOfWeek: " + getDayOfWeek() +
			", date: " + getDate() +
			", deliveryItems: " + getDeliveryItems().toString() + "]";
	}
}
