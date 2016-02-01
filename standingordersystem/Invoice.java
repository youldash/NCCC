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
import java.util.Set;
import java.util.HashSet;

/**
 * Invoice class.
 */
public class Invoice {

	private String id;
	private int fromDate;
	private int toDate;
	private Customer customer;
	private Set<Delivery> deliveries;
	private double totalCost;
	private int payDate;
	private InvoiceStatus status;
	
	/**
	 * Default constructor.
	 * 
	 * @param id
	 * @param fromDate
	 * @param toDate
	 * @param customer
	 * @param totalCost
	 * @param payDate
	 */
	public Invoice(String id, int fromDate, int toDate, Customer customer,
	double totalCost, int payDate) {
		
		/*
		 * Assuming that all parameters are not null. No error handling is made for simplicity. 
		 */
		setId(id);
		setFromDate(fromDate);
		setToDate(toDate);
		setCustomer(customer);
		setDeliveries(new HashSet<Delivery>());
		setTotalCost(totalCost);
		setPayDate(payDate);
		setStatus(InvoiceStatus.issued);
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
	 * @return the fromDate
	 */
	public int getFromDate() {
		
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(int fromDate) {
		
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public int getToDate() {
		
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(int toDate) {
		
		this.toDate = toDate;
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
	 * @return the deliveries
	 */
	public Set<Delivery> getDeliveries() {
		
		return deliveries;
	}

	/**
	 * @param deliveries the deliveries to set
	 */
	public void setDeliveries(Set<Delivery> deliveries) {
		
		if (deliveries != null) {
			
			this.deliveries = deliveries;
			
		} else {
			
			this.deliveries = new HashSet<Delivery>();
		}	
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		
		this.totalCost = totalCost;
	}

	/**
	 * @return the payDate
	 */
	public int getPayDate() {
		
		return payDate;
	}

	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(int payDate) {
		
		this.payDate = payDate;
	}

	/**
	 * @return the status
	 */
	public InvoiceStatus getStatus() {
		
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(InvoiceStatus status) {
		
		this.status = status;
	}
	
	/**
	 * Add a delivery.
	 * 
	 * @param delivery
	 */
	public void addDelivery(Delivery delivery) {
		
		if (delivery != null) {
			
			this.deliveries.add(delivery);
		}
	}
	
	/**
	 * @return a string description
	 */
	public String toString() {
				
		return "Invoice[id: " + getId() +
			", fromDate: " + getFromDate() +
			", toDate: " + getToDate() +
			", customer: " + getCustomer().toString() +
			", deliveries: " + getDeliveries().toString() +
			", totalCost: " + getTotalCost() +
			", payDate: " + getPayDate() +
			", status: " + getStatus() + "]";
	}
}
