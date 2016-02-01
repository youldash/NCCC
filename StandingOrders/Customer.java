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

import java.lang.String;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer class.
 */
public class Customer implements SimpleKey {
	
	private String id;
	private String name;
	private Set<Address> addresses;
	private Set<Order> orders;
	
	/**
	 * Default constructor.
	 * 
	 * @param id
	 * @param name
	 */
	public Customer(String id, String name) {
		
		setId(id);
		setName(name);
		
		this.addresses = new HashSet<Address>();
		this.orders = new HashSet<Order>();
	}
	
	/**
	 * @return the id
	 */
	public String getID() {
		
		return id;
	}
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		
		this.name = name;
	}

	/**
	 * @return a string description
	 */
	public String toString() {
		
		return "Customer[id: " + id + ", name: " + name + "]";
	}
		
	/**
	 * Abstract method getKey() in SimpleKey
	 * 
	 * @return number
	 */
	@Override
	public String getKey() {
		
		return id;
	}

	/**
	 * @return the addresses
	 */
	public Set<Address> getAddresses() {
		
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(Set<Address> addresses) {
		
		this.addresses = addresses;
	}

	/**
	 * @return the orders
	 */
	public Set<Order> getOrders() {
		
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Order> orders) {
		
		this.orders = orders;
	}
}
