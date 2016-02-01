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

import java.util.Collection;
import java.util.ArrayList;

/**
 * DeliveryItem class.
 */
public class DeliveryItem {

	private Order order;
	private int quantity;
	private int difference;
	
	/**
	 * Default constructor.
	 * 
	 * @param order
	 * @param quantity
	 * @param difference
	 */
	public DeliveryItem(Order order, int quantity, int difference) {
		
		/*
		 * Assuming that all parameters are not null. No error handling is made for simplicity. 
		 */
		setOrder(order);
		setQuantity(quantity);
		setDifference(difference);
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		
		this.order = order;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
	}

	/**
	 * @return the difference
	 */
	public int getDifference() {
		
		return difference;
	}

	/**
	 * @param difference the difference to set
	 */
	public void setDifference(int difference) {
		
		this.difference = difference;
	}
	
	/**
	 * @return a string description
	 */
	public String toString() {
		
		return "DeliveryItem[order: " + getOrder().toString() +
			", quantity: " + getQuantity() +
			", difference: " + getDifference() + "]";
	}
}
