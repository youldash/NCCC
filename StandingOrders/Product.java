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
 * Standing Orders created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */

/**
 * Product class.
 */
import java.lang.String;

public class Product implements SimpleKey {
	
	private String number;
	private String name;
	private double price;
	private int quantity;
	
	/**
	 * Default constructor.
	 * 
	 * @param number
	 * @param name
	 * @param price
	 * @param quantity
	 */
	public Product(String number, String name, double price, int quantity) {
		
		/*
		 * Assuming that all parameters are not null. No error handling is made for simplicity. 
		 */
		setNumber(number);
		setName(name);
		setPrice(price);
		setQuantity(quantity);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		
		this.name = name;
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
	 * @return price
	 */
	public double getPrice() {
		
		return price;
	}
	
	/**
	 * @param price
	 */
	public void setPrice(double price) {
		
		this.price = price;
	}

	/**
	 * @return quantity
	 */
	public int getQuantity() {
		
		return quantity;
	}
	
	/**
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
	}
	
	/**
	 * @return a string description
	 */
	public String toString() {
		
		return "Product[number: " + getNumber() +
			", name: " + getName() +
			", price: " + getPrice() +
			", quantity: " + getQuantity() + "]";
	}

	/**
	 * Abstract method getKey() in SimpleKey
	 * 
	 * @return number
	 */
	@Override
	public String getKey() {
		
		return number;
	}
	
	/**
	 * Update (deduct) the current quantity. 
	 * 
	 * @param numberOfProductItems
	 */
	public void removeStock(int numberOfProductItems) {
		
		setQuantity(getQuantity() - numberOfProductItems);
	}
}
