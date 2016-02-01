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

import java.util.Set;
import java.util.HashSet;
import java.lang.String;

/**
 * OrderEntrySystem class.
 */
public class OrderEntrySystem {
	
	protected Set<Customer> customerList;
	protected Set<Product> productList;
	protected Set<Order> orderList;
	protected Set<Delivery> deliveryList;
	protected Set<Invoice> invoiceList;
	protected Set<Address> addressList;

	/**
	 * Default constructor.
	 */
	public OrderEntrySystem() {
		
		/*
		 * Initialize all collections for later use.
		 */
		this.customerList = new HashSet<Customer>();
     	this.productList = new HashSet<Product>();
     	this.orderList = new HashSet<Order>();
     	this.deliveryList = new HashSet<Delivery>();
     	this.invoiceList = new HashSet<Invoice>();
     	this.addressList = new HashSet<Address>();
	}

	/**
	 * @return a string description
	 */
	public String toString() {
		
		/*
		 * Retrieve all existing customers.
		 */
		String customers = new String();
		
		for (Customer customer : customerList) {
			
			customers = customers + "\n\t" + customer;
		}

		/*
		 * Retrieve all existing addresses.
		 */
		String addresses = new String();
		
		for (Address address : addressList) {
			
			addresses = addresses + "\n\t" + address;
		}
		
		/*
		 * Retrieve all existing products.
		 */
		String products = new String();
		
		for (Product product: productList) {
			
			products = products + "\n\t" + product;
		}

		/*
		 * Retrieve all existing orders.
		 */
		String orders = new String();
		
		for (Order order : orderList) {
			
			orders = orders + "\n\t" + order;
		}
		
		/*
		 * Retrieve all deliveries.
		 */
		String deliveries = new String();
		
		for (Delivery delivery : deliveryList) {
			
			deliveries = deliveries + "\n\t" + delivery;
		}
		
		/*
		 * Concatenate all data into a single string and then return it.
		 */
		return "OrderEntrySystem[" +
			"\ncustomerList: " + customers +
			"\naddressList: " + addresses +
			"\nproductList: " + products +
			"\norderList: " + orders +
			"\ndeliveryList: " + deliveries + "\n]";
	}
	
	/**
	 * Add a new customer.
	 * 
	 * @param id
	 * @param name
	 * @throws Exception
	 */
	public void addCustomer(String id, String name) throws Exception {
		
		Customer customer = (Customer)Helper.search(customerList, id);
     	
     	boolean pre = (customer == null);
     	
     	if (!pre) {
			
     		String message = "ERROR: Customer ID is not unique!";
     		     		
     		throw new Exception(message);
     	}
     	
     	customer = new Customer(id, name);
      
     	customerList.add(customer);
	}

	/**
	 * Add an address.
	 * 
	 * @param id
	 * @param line1
	 * @param line2
	 * @param contactPerson
	 * @param contactPhone
	 * @throws Exception
	 */
	public void addAddress(String id,
		String line1,
		String line2,
		String contactPerson,
		String contactPhone) throws Exception {
		
		String message;
		
		/*
		 * Address checking.
		 */
		Address address = (Address)Helper.search(addressList, id);
		
		boolean pre = (address == null);
		
		if (!pre) {
			
			message = "ERROR addAddress: Cannot add Customer; Address Id is not unique!";
			         
			throw new Exception(message);
		}
		
		/*
		 * Finally, create the new address, and add it to the appropriate list.
		 */
		address = new Address(id, line1, line2, contactPerson, contactPhone);
		
		addressList.add(address);
	}
	
	/**
	 * Add an address to an existing customer.
	 * 
	 * @param customerId
	 * @param address
	 * @throws Exception
	 */
	public void addAddressToCustomer(String customerId, Address address) throws Exception {
		
		String message;
		
		/*
		 * Customer checking.
		 */
		Customer customer = (Customer)Helper.search(customerList, customerId);
     	
     	boolean pre1 = (customer != null);
     	
     	if (!pre1) {
			
     		message = "ERROR addAddressToCustomer: Customer ID does not exist!";
     		     		
     		throw new Exception(message);
     	}
     	
     	/*
		 * Address checking.
		 */
		boolean pre2 = ((Address)Helper.search(addressList, address.getId()) == null);
		
		if (!pre2) {
			
			message = "ERROR addAddressToCustomer: Cannot add Address; Address Id is not unique!";
         
			throw new Exception(message);
		}
		
		/*
		 * Finally, create the new address, and add it to the appropriate list.
		 */
		addressList.add(address);
		
		/*
		 * Also add the address to that customer.
		 */
		customer.getAddresses().add(address);
	}
	
	/**
	 * Add a new product.
	 * 
	 * @param number
	 * @param name
	 * @param price
	 * @param quantity
	 * @throws Exception
	 */
	public void addProduct(String number, String name, double price, int quantity) throws Exception {
		
		Product product = (Product)Helper.search(productList, number);
	
		boolean pre = (product == null);
	
		if (!pre)
		{
			String message = "ERROR addProduct: Product Number is not unique!";
			         
			throw new Exception(message);
		}

		product = new Product(number, name, price, quantity);
	
		productList.add(product);
	}
	
	/**
	 * Add a standing order to an existing customer.
	 * 
	 * @param number
	 * @param customerId
	 * @param addressId
	 * @param productId
	 * @param quantities
	 * @throws Exception
	 */
	public void addOrder(
		String number,
		String customerId,
		String addressId,
		String productId,
		int[] quantities,
		int startDate,
		int endDate,
		OrderStatus status)
		throws Exception {
		
		/*
		 * Assume two arrays are of of the same length. In fact,
		 * we should check that this condition is satisfied (as another precondition).
		 */
		String message;
		
		/*
		 * Order checking.
		 */
		Order order = (Order)Helper.search(orderList, number);
		
		boolean pre1 = (order == null);
		
		if (!pre1) {
			
			message = "ERROR addOrder: Order Number is not unique!";
			
			throw new Exception(message);
		}

		/*
		 * Order checking.
		 */
		Customer customer = (Customer)Helper.search(customerList, customerId);
		
		boolean pre2 = (customer != null);
		
		if (!pre2) {
			
			message = "ERROR addOrder: Cannot add Order; Customer does not exist!";
			         
			throw new Exception(message);
		}
		
		/*
		 * Product checking.
		 */
		Product product = (Product)Helper.search(productList, productId);
		
		boolean pre3 = (product != null);
		
		if (!pre3) {
			
			message = "ERROR addOrder: Cannot add Order; Product does not exist!";
			         
			throw new Exception(message);
		}
		
		/*
		 * Address checking.
		 */
		Address address = (Address)Helper.search(addressList, addressId);
		
		boolean pre4 = (address != null);
		
		if (!pre4) {
			
			message = "ERROR addOrder: Cannot add Order; Address does not exist!";
			         
			throw new Exception(message);
		}
		
		/*
		 * Quantity checking.
		 */
		boolean pre5 = true;
		
		for (int quantity : quantities) {
			
			if (quantity < 0) {
				
				pre5 = false;
				
				break;
			}
		}
		
		if (!pre5) {
			
			message = "ERROR addOrder: Cannot add Order; Quantities entered are invalid!";
			         
			throw new Exception(message);
		}		
		
		/*
		 * Finally, create the new order, and add it to the appropriate lists.
		 */
		order = new Order(number, customer, address, product, quantities, startDate, endDate, status);
	
		orderList.add(order);
		
		customer.getOrders().add(order);
	}

	/**
	 * Print any standing orders according to a given date.
	 * Informs whether the print found any orders or not.
	 * 
	 * @param date
	 */
	public void listStandingOrders(int date) throws Exception {
		
		String message;
		
		/*
		 * Orders checking.
		 */
		boolean pre1 = (!orderList.isEmpty());
		
		if (!pre1) {
			
			message = "ERROR listStandingOrders: Cannot list Orders; List is empty!";
			
			throw new Exception(message);
		}
		
		/*
		 * Print standing orders according to a given date, listed by customers.
		 */
		int ordersCount = 0;
				
		for (Customer customer : customerList) {
			
			System.out.println("Standing Orders for Customer " + customer.getID() + ":");

			for (Order order : customer.getOrders()) {
				
				if (order.getStartDate() == date) {
					
					System.out.println(order.toString());
					
					ordersCount++;
				}
			}
		}
		
		/*
		 * Order match checking.
		 */
		if (ordersCount == 0) {
			
			message = "ERROR listStandingOrders: Cannot list Orders; No match found!";
			
			throw new Exception(message);
		}
	}
	
	/**
	 * Add a new delivery.
	 * 
	 * @param deliveryId
	 * @param customerId
	 * @param addressId
	 * @param date
	 * @param dayOfWeek
	 * @throws Exception
	 */
	public void addDelivery(Delivery delivery, DeliveryItem deliveryItem) throws Exception {
		
		String message;

		/*
		 * Customer checking. // Pass the delivery object.
		 */
		Customer customer = (Customer)Helper.search(customerList, delivery.getCustomer().getID());
		
		boolean pre1 = (customer != null);
		
		if (!pre1) {
			
			message = "ERROR addDelivery: Cannot add Delivery; Customer does not exist!";
			
			throw new Exception(message);
		}
		
		/*
		 * Customer address checking.
		 */
		Address address = (Address)Helper.search(addressList, delivery.getAddress().getId());
		
		boolean pre2 = (address != null);
		
		if (!pre2) {
			
			message = "ERROR addDelivery: Cannot add Delivery; Customer does not exist!\n";
			         
			throw new Exception(message);
		}
		
		/*
		 * Add the new delivery.
		 */
		delivery.addDeliveryItem(deliveryItem);
		
		deliveryList.add(delivery);
	}
	
	/**
	 * List existing customers.
	 * 
	 * @param endDate
	 * @throws Exception
	 */
	public void listCustomers(int endDate) throws Exception {
		
		String message;
		
		/*
		 * Delivery checking.
		 */
		for (Delivery delivery : deliveryList) {
			
			Customer customer = (Customer)Helper.search(customerList, delivery.getCustomer().getID());
			
			boolean pre1 = (customer != null);
			
			if (!pre1) {
				
				message = "ERROR listCustomers: Customer does not exist!";
				
				throw new Exception(message);
			}
			
			/*
			 * Order checking.
			 */
			for (Order order : customer.getOrders()) {
				
				if (endDate <= order.getEndDate()) {
					
					System.out.println("listCustomers: " + customer.toString());
				}
			}
		}
	}
	
	/**
	 * Add a new invoice for an existing customer.
	 * 
	 * @param customer
	 * @throws Exception 
	 */
	public void addInvoice(
		String id,
		int fromDate,
		int toDate,
		Delivery delivery,
		double totalCost,
		int payDate) throws Exception {
		
		String message;

		/*
		 * Customer checking.
		 */
		Customer customer = (Customer)Helper.search(customerList, delivery.getCustomer().getID());
		
		boolean pre1 = (customer != null);
		
		if (!pre1) {
			
			message = "ERROR addDelivery: Cannot add Delivery; Customer does not exist!";
			
			throw new Exception(message);
		}
		
		/*
		 * Add the invoice, then add the delivery.
		 */
		Invoice invoice = new Invoice(id, fromDate, toDate, customer, totalCost, payDate);
		
		invoice.addDelivery(delivery);
		
		this.invoiceList.add(invoice);
	}
}
