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

/**
 * Order class.
 */
public class Order implements SimpleKey {
	
	private String number;
	private Customer customer;
	private Address address;
	private Product product;
	private double price;
	private int[] quantities;
	private int startDate;
	private int endDate;
	private OrderStatus status;
	
	/**
	 * Default constructor.
	 * 
	 * @param number
	 * @param customer
	 * @param address
	 * @param product
	 * @param quantities
	 */
	public Order(String number,
		Customer customer,
		Address address,
		Product product,
		int[] quantities,
		int startDate,
		int endDate,
		OrderStatus status) {
		
		/*
		 * Assuming that all parameters are not null. No error handling is made for simplicity. 
		 */
		this.number = number;
		this.customer = customer;
		this.address = address;
		this.product = product;
		this.quantities = quantities;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	/**
	 * @return number
	 */
	public String getNumber() {
		
		return number;
	}
	
	/**
	 * @param number
	 */
	public void setNumber(String number) {
		
		this.number = number;
	}
	
	/**
	 * @return customer
	 */
	public Customer getCustomer() {
		
		return customer;
	}
		
	/**
	 * Abstract method getKey() in SimpleKey
	 * 
	 * @return number
	 */
	public String getKey() {
		
		return number;
	}
	
	/**
	 * @return a string description
	 */
	public String toString() {
		
		String desc;
		
		desc = "Order[number: " + number + ", customer:" + customer.getID() + ", items: [" ;
		desc += "Item[number: " + product.getNumber() + ", quantity: " + product.getQuantity() +
				" quantities: " + quantities.length + ", startDate: " + startDate + ", endDate: " + endDate +
				", status: " + status.toString() + "]";
		desc += "\b]";
		
		return desc;
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
	 * @return the product
	 */
	public Product getProduct() {
		
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		
		this.product = product;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		
		this.price = price;
	}

	/**
	 * @return the quantities
	 */
	public int[] getQuantities() {
		
		return quantities;
	}

	/**
	 * @param quantities the quantities to set
	 */
	public void setQuantities(int[] quantities) {
		
		this.quantities = quantities;
	}

	/**
	 * @return the startDate
	 */
	public int getStartDate() {
		
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(int startDate) {
		
		this.startDate = startDate;
	}

	/**
	 * @return the status
	 */
	public OrderStatus getStatus() {
		
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(OrderStatus status) {
		
		this.status = status;
	}

	/**
	 * @return the endDate
	 */
	public int getEndDate() {
		
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(int endDate) {
		
		this.endDate = endDate;
	}
}
