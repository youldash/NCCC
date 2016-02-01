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

import java.util.Set;
import java.util.HashSet;
import java.lang.String;

/**
 * Application's driver class.
 */
public class OrderEntrySystemTester {
	
   private static int testCount;
   private static OrderEntrySystem oes;

   /**
    * @param args
    * @throws Exception
    */
   public static void main(String[] args) throws Exception {
	   
	   /*
	    * Begin the program.
	    */
	   init();
	   
	   /*
	    * UC1 Add a new product.
	    */
	   testUC1_valid();
	   testUC1_invalid();

	   /*
	    * UC2 Add a new customer.
	    */
	   testUC2_valid();
	   testUC2_invalid();
	   
	   /*
	    * UC3 Add a delivery address to an existing customer. 
	    */
	   testUC3_valid();
	   testUC3_invalid();

	   /*
	    * UC4 Add a standing order to an existing customer.
	    */
	   testUC4_valid();
	   testUC4_invalid();

	   /*
	    * UC5 List standing orders that need to be filled for a particular date,
		* sorted by customer name and, within a name, by the customer id. 
	    */
	   testUC5_valid();
	   testUC5_invalid();

	   /*
	    * UC6 Add a delivery.
	    */
	   testUC6_valid();
	   testUC6_invalid();

	   /*
	    * UC7 Generate a delivery docket.
	    */
	   testUC7_valid();
	   testUC7_invalid();

	   /*
	    * UC8 List all the customers who have any deliveries for a particular week,
		* given the ending date of the week.
	    */
	   testUC8_valid();
	   testUC8_invalid();

	   /*
	    * UC9 Add an invoice for a customer.
	    */
	   testUC9_valid();
	   testUC9_invalid();

	   /*
	    * UC10 Generate an invoice document, given the invoice number.
	    */
	   testUC10_valid();
	   testUC10_invalid();
	   
	   System.out.println(testCount + " tests have been conducted.");
	}
   
   /**
    * Initialize testers.
    */
	private static void init() {
		
		System.out.println("Initializing order entry system testers...");
		
		/*
		 * Initialize the test counter and the OrderEntrySystem instance.
		 */
		testCount = 0;
		
		oes = new OrderEntrySystem();
		
		System.out.println(oes);
	}

	/**
	 * UC1 Add a new product (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC1_valid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Valid Add Product - [TEST: " + testCount + "] - UC1");

		/*
		 * Add a new product with product id p01.
		 */
		oes.addProduct("p01", "Coffee Grains", 17, 20);
		
		/*
		 * Add a new product with product id p02.
		 */
		
		// address check with the same id //
		// when add customer add address as well//
		
		
		oes.addProduct("p02", "Frozen Bagel - 24pk", 9, 30);
		
		System.out.println(oes);
		System.out.println("---------------- End of valid UC1 ----------------");
		System.out.println();
	}

	/**
	 * UC1 Add a new product (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC1_invalid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Invalid Add Product - [TEST: " + testCount + "] - UC1");

		/*
		 * Add a new product with product id p03.
		 */
		oes.addProduct("p03", "MacBook Pro 17, Transparent cover", 34, 5);

		/*
		 * Add a new product with product id p03.
		 * Same id as previously added product; should throw error, hence the try/catch block.
		 */ 
		try  {
			
			oes.addProduct("p03", "Pen with Advertising rollout", 2, 200);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

		System.out.println(oes);
		System.out.println("---------------- End of invalid UC1 ----------------");
		System.out.println();
	}

	/**
	 * UC2 Add a new customer (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC2_valid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Valid Add Customer - [TEST: " + testCount + "] - UC2");

		/*
		 * Add a new customer with customer id c01.
		 */
		oes.addCustomer("c01", "Foo");
		
		/*
		 * Then add an address to that customer.
		 */
		oes.addAddressToCustomer("c01",
			new Address("a01", "1 Main St", "Melbourne", "Andrew", "555-555-5555"));
		
		/*
		 * Add a new customer with customer id c02.
		 */
		oes.addCustomer("c02", "John Appleseed");
		
		/*
		 * Then add an address to that customer.
		 */
		oes.addAddressToCustomer("c01",
			new Address("a02", "1 Part St", "Melbourne", "Jeff", "544-444-4444"));
		
		System.out.println(oes);
		System.out.println("---------------- End of valid UC2 ----------------");
		System.out.println();
	}
	
	/**
	 * UC2 Add a new customer (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC2_invalid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Invalid Add Customer - [TEST: " + testCount + "] - UC2");

		/*
		 * Add a customer with customer id c03.
		 * Add an address a02 to existing customer c03.
		 * Same id as previously added product; should throw error, hence the try/catch block.
		 */ 
		try {
			
			/*
			 * Add a new customer with customer id c03.
			 */
			oes.addCustomer("c03", "BeBe");
			
			/*
			 * Then add an address to that customer.
			 */
			oes.addAddressToCustomer("c03",
				new Address("a01", "2 City Pl", "Melbourne", "Someone", "500-000-0000"));
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

		System.out.println(oes);
		System.out.println("---------------- End of invalid UC2 ----------------");
		System.out.println(); 
	}
	
	/**
	 * UC3 Add a delivery address to an existing customer (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC3_valid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Valid Add Address to Customer - [TEST: " + testCount + "] - UC3");
		
		/*
		 * Add an address a03 to an existing customer c03.
		 */
		oes.addAddressToCustomer("c03",
			new Address("a03", "1 Main St", "Melbourne", "FoFo", "522-123-1234"));
		
		System.out.println(oes);
		System.out.println("---------------- End of valid UC3 ----------------");
		System.out.println();
	}
	
	/**
	 * UC3 Add a delivery address to an existing customer (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC3_invalid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Invalid Add Address to Customer - [TEST: " + testCount + "] - UC3");
		
		/*
		 * Add an address a03 to an existing customer c03.
		 */
		try {
			
			oes.addAddressToCustomer("c03",
					new Address("a03", "10 Small St", "Sydney", "FoFo", "522-123-1234"));
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		System.out.println(oes);
		System.out.println("---------------- End of invalid UC3 ----------------");
		System.out.println();
	}

	/**
	 * UC4 Add a standing order to an existing customer (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC4_valid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Valid Add Order to Customer - [TEST: " + testCount + "] - UC4");
		
		/*
		 * Add new order o01 to an existing customer c01.
		 */
		oes.addOrder("o01", "c01", "a01", "p01",
				new int[50], 1, 10, OrderStatus.active);
		
		/*
		 * Add another order o02 to an existing customer c02.
		 */
		oes.addOrder("o02", "c02", "a01", "p03",
				new int[100], 3, 30, OrderStatus.active);

		System.out.println(oes);
		System.out.println("---------------- End of valid UC4 ----------------");
		System.out.println();
	}
	
	/**
	 * UC4 Add a standing order to an existing customer (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC4_invalid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Invalid Add Order to Customer - [TEST: " + testCount + "] - UC4");
		
		/*
		 * Add an order o01 to an existing customer c01.
		 * Same id as previously added order; should throw error, hence the try/catch block.
		 */
		try {
			
			oes.addOrder("o01", "c02", "a02", "p02",
					new int[75], 2, 8, OrderStatus.active);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		System.out.println("---------------- End of Invalid UC4 ----------------");
		System.out.println();
	}

	/**
	 * UC5 List standing orders that need to be filled for a particular date,
	 * sorted by customer name and, within a name, by the customer id (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC5_valid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Valid List Standing Orders - [TEST: " + testCount + "] - UC5");
		
		/*
		 * List standing orders, which are made on a Tuesday (day 1). 
		 */
		oes.listStandingOrders(1);
		
		/*
		 * List standing orders, which are made on a Thursday (day 3). 
		 */
		oes.listStandingOrders(3);

		System.out.println("---------------- End of Valid UC5 ----------------");
		System.out.println();
	}
	
	/**
	 * UC5 List standing orders that need to be filled for a particular date,
	 * sorted by customer name and, within a name, by the customer id (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC5_invalid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Invalid List Standing Orders - [TEST: " + testCount + "] - UC5");
		
		/*
		 * List standing orders, which are made on a Monday (day 0).
		 * Should throw error, hence the try/catch block.
		 */
		try {
			
			oes.listStandingOrders(0);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

		System.out.println("---------------- End of Invalid UC5 ----------------");
		System.out.println();
	}
	
	/**
	 * UC6 Add a delivery (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC6_valid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Valid Add Delivery - [TEST: " + testCount + "] - UC6");
		
		/*
		 * Add a new delivery d01 for customer c01 to address a01. 
		 */
		oes.addDelivery(
			new Delivery("d01",
				(Customer)Helper.search(oes.customerList, "c01"),
				(Address)Helper.search(oes.addressList, "a01"),
				4, DayOfWeek.Friday),
				new DeliveryItem((Order)Helper.search(oes.orderList, "o01"), 10, 0)
		);
		
		/*
		 * Add another delivery d02 for customer c01 to address a01. 
		 */
		oes.addDelivery(
			new Delivery("d02",
				(Customer)Helper.search(oes.customerList, "c01"),
				(Address)Helper.search(oes.addressList, "a01"),
				4, DayOfWeek.Friday),
				new DeliveryItem(
					(Order)Helper.search(oes.orderList, "o01"), 10, 0)
		);

		System.out.println(oes);
		System.out.println("---------------- End of Valid UC6 ----------------");
		System.out.println();
	}
	
	/**
	 * UC6 Add a delivery (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC6_invalid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Invalid Add Delivery - [TEST: " + testCount + "] - UC6");
		
		try {
			
			/*
			 * Add another delivery d03 for customer c04 to address a01. 
			 */
			oes.addDelivery(
				new Delivery("d03",
					(Customer)Helper.search(oes.customerList, "c04"),
					(Address)Helper.search(oes.addressList, "a01"),
					4, DayOfWeek.Friday),
					new DeliveryItem(
						(Order)Helper.search(oes.orderList, "o01"), 10, 0)
			);
			
		} catch (Exception e) {
			
			System.out.println(e.getLocalizedMessage());
		}

		System.out.println(oes);
		System.out.println("---------------- End of Invalid UC6 ----------------");
		System.out.println();
	}
	
	/**
	 * UC7 Generate a delivery docket (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC7_valid() throws Exception {
		
		/*
		 * Same as previous UC. Docket is made in one string line containing delivery info + delivery items.
		 */
		testCount++;
		
		System.out.println("---------------- Valid Delivery Docket - [TEST: " + testCount + "] - UC7");
		
		System.out.println(oes);
		System.out.println("---------------- End of Valid UC7 ----------------");
		System.out.println();
	}
	
	/**
	 * UC7 Generate a delivery docket (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC7_invalid() throws Exception {
		
		/*
		 * Same as previous invalid UC.
		 * Docket is made in one string line containing delivery info + delivery items.
		 */
		testCount++;
		
		System.out.println("---------------- Invalid Delivery Docket - [TEST: " + testCount + "] - UC7");
		
		System.out.println(oes);
		System.out.println("---------------- End of Invalid UC7 ----------------");
		System.out.println();
	}

	/**
	 * UC8 List all the customers who have any deliveries for a particular week,
	 * given the ending date of the week (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC8_valid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Valid List Customers - [TEST: " + testCount + "] - UC8");
		
		oes.listCustomers(6);
		
		System.out.println("---------------- End of Valid UC8 ----------------");
		System.out.println();
	}
	
	/**
	 * UC8 List all the customers who have any deliveries for a particular week,
	 * given the ending date of the week (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC8_invalid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Invalid List Customers - [TEST: " + testCount + "] - UC8");
		
		/*
		 * Not fully functional. 
		 */
		oes.listCustomers(-1);
		
		System.out.println("---------------- End of Invalid UC8 ----------------");
		System.out.println();
	}
	
	/**
	 * UC9 Add an invoice for a customer (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC9_valid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Valid Add Invoice - [TEST: " + testCount + "] - UC9");
		
		/*
		 * Add an invoice i01 for delivery d01.
		 */
		oes.addInvoice("i01", 1, 30,
			new Delivery("d01",
				(Customer)Helper.search(oes.customerList, "c01"),
				(Address)Helper.search(oes.addressList, "a01"),
				1, DayOfWeek.Monday),
				100, 30);
		
		System.out.println("---------------- End of Valid UC9 ----------------");
		System.out.println();
	}
	
	/**
	 * UC9 Add an invoice for a customer (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC9_invalid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Invalid Add Invoice - [TEST: " + testCount + "] - UC9");
		
		/*
		 * Not fully functional. 
		 */
		oes.listCustomers(-1);
		
		System.out.println("---------------- End of Invalid UC9 ----------------");
		System.out.println();
	}
	
	/**
	 * UC10 Generate an invoice document, given the invoice number (VALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC10_valid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Valid Generate Invoice - [TEST: " + testCount + "] - UC10");
		
		System.out.println("---------------- End of Valid UC10 ----------------");
		System.out.println();
	}
	
	/**
	 * UC10 Generate an invoice document, given the invoice number (INVALID).
	 * 
	 * @throws Exception
	 */
	private static void testUC10_invalid() throws Exception {
		
		testCount++;
		
		System.out.println("---------------- Invalid Add Invoice - [TEST: " + testCount + "] - UC10");
		
		/*
		 * Not tested properly.
		 */
		
		System.out.println("---------------- End of Invalid UC10 ----------------");
		System.out.println();
	}
}
