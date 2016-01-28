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
 * (NCCC skeleton code) package created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */
package skeleton;

import java.lang.String;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Locale;
import java.util.StringTokenizer;
import java.io.*;

/**
 * Application's driver class.
 */
public class Driver implements Menu {

	/*
	 * Enumeration used for printing collection data (order) to screen.
	 */
	private static enum PrintOrder {
		
		ascending,
		descending;
	};
	
	private static final boolean DEBUG = true;
	private static final String BINARYFILE = "data.bin";
	
	private static File inFile;
	private static File outFile;
	private static FileInputStream fis;
	private static PrintWriter printWriter;
	private static Scanner scanner;
	private static Scanner keyboard;
	private static CollectionInSpace collection;
	
	/**
	 * Default constructor.
	 */
	public Driver() {
		
		collection = new CollectionInSpace();

		try {
						
			keyboard = new Scanner(System.in);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Read form a text file. User input is required.
	 */
	private void importData() {
		
	}
	
	/**
	 * Read collection data from the binary fine "data.bin", if exists.
	 * 
	 * @return true/false
	 * 
	 * @throws IOException
	 * @throws EOFException
	 * @throws FileNotFoundException
	 */
	private boolean importBinaryData()
			throws IOException, EOFException, FileNotFoundException {
		
	}

	/**
	 * Write to a data file. Filename is required by the user.
	 */
	private void exportData() {
		
	}
	
	/**
	 * Save new collection content to the binary fine "data.bin".
	 * 
	 * @return true/false
	 * 
	 * @throws IOException
	 * @throws EOFException
	 * @throws FileNotFoundException
	 */
	private boolean exportBinaryData()
			throws IOException,	EOFException, FileNotFoundException, NotSerializableException {
				
	}
		
	/**
	 * Print collection content. Ordered by either ascending or descending matter.
	 * 
	 * @param order
	 */
	private void print(PrintOrder order) {
		
	}
	
	/**
	 * Assume user add to the front of the collection.
	 * 
	 * @param celestialObject
	 * 
	 * @return true/false
	 */
	private boolean add(CelestialObject celestialObject) {
		
	}
	
	/**
	 * Add a new CelestialObject instance.
	 */
	private void addCelestialObject() {
		
	}
	
	/**
	 * Sub menu option 'F'. Assuming there are no ties.
	 * 
	 * @return true/false
	 */
	private boolean printFarthestStar() {
		
	}
	
	/**
	 * Print all largest space bodies.
	 * 
	 * @return true/false
	 */
	private boolean printLargestSpaceBodies() {
		
	}
	
	/**
	 * Print all moons orbiting around a planet.
	 */
	private void printAllMoons() {
		
	}
	
	/**
	 * Print all space bodies that comply with the range.
	 */
	private void printRange() {
		
	}
	
	/**
	 * Run the menu.
	 */
	public void runMenu() {
		
		char input;
	
		do {
			
			mainMenu();
			input = keyboard.next().trim().toUpperCase().charAt(0);
			keyboard.nextLine();
			
			switch (input) {
			
				case 'E':
					/*
					 * Export/write to a data file specified by user input.
					 */
					exportData();
					break;
					
				case 'A':
					/*
					 * Add a new celestial object (CelestialObject instance).
					 */
					addCelestialObject();
					break;
					
				case 'I':
					/*
					 * Imoport/read a data file specified by user input.
					 */
					importData();
					break;
					
				case 'E':
					/*
					 * Invoke the runSubMenu() routine.
					 */
					runSubMenu();
					break;
					
				case 'D':
					/*
					 * Print according to given order. 
					 */
					System.out.print("in which order: ascending or descending [A or D]? ");
					String order = keyboard.nextLine().trim().toUpperCase();
					
					if (order.equalsIgnoreCase("A"))
						print(PrintOrder.ascending);
					else
						print(PrintOrder.descending);
					break;
					
				case 'Q':
					System.out.println("Taking off...");
					break;
					
				default:
					System.out.println("That was not a valid choice!");
			}
			
		} while (input != 'Q');
	}
	
	/**
	 * Application main menu.
	 */
	public void mainMenu() {
		
		System.out.println("******************");
		System.out.println(" NCCC Application ");
		System.out.println("******************");
		System.out.println("E) Export to a file");
		System.out.println("A) Add a celestial object");
		System.out.println("I) Import from a file");
		System.out.println("S) Submenu");
		System.out.println("D) Display collection");
		System.out.println("Q) Quit");
		System.out.println("******************");
		System.out.print("Make your choice: ");
	}
	
	/**
	 * Run sub-menu.
	 */
	public void runSubMenu() {
		
		char input;
		
		do {
			subMenu();
			input = keyboard.next().trim().toUpperCase().charAt(0);
			keyboard.nextLine();
			
			switch (input) {
			
				case 'F':
					if (!printFarthestStar())
						System.err.println("Warning: searching through an empty collection!");
					
					break;
					
				case 'L':
					if (!printLargestSpaceBodies())
						System.err.println("Warning: searching through an empty collection!");
					
					break;
					
				case 'A':
					printAllMoons();
					break;
					
				case 'R':
					printRange();
					break;
					
				case 'E':
					System.out.println("Finishing up...");
					break;
					
				default:
					System.out.println("That was not a valid choice!");
					break;
			}
		}
		
		while (input != 'E');
	}
	
	/**
	 * Sub-menu.
	 */
	public void subMenu() {
		
		System.out.println();
		System.out.println("****** SUBMENU *******");
		System.out.println("F) Furthest: Star");
		System.out.println("L) Largest: bodies");
		System.out.println("A) All Moons: Planet");
		System.out.println("R) Range: degrees");
		System.out.println("E) Exit: submenu");
		System.out.println("**********************");
		System.out.print("Make your choice: ");
	}
	
	/**
	 * @param args (arguments passed via command prompt)
	 */
	public static void main(String[] args) {
				
		Driver driver = new Driver();
		
		/*
		 * Checksum: if the binary file exists or not.
		 */
		try {
			
			if (driver.importBinaryData())
				if (DEBUG)
					System.out.println("Ready to read data from (" + BINARYFILE + ").");
		}
		catch (Exception e) {
			
			System.err.println("Initial run: file (" + BINARYFILE + ") not found!");
		}
		finally {
			
			if (DEBUG)
				System.out.println("Initial run: collection has " +
					collection.getSize() + " records.");
		}

		/*
		 * Execute the remaining tasks as per requirements.
		 * Routines are made through the main menu.
		 */
		driver.runMenu();

		/*
		 * Update the binary file with new, if so, collection data.
		 */
		try {
			
			driver.exportBinaryData();
		}
		catch (Exception e) {
			
			System.err.println("Final run: something went wrong while saving to (" +
				BINARYFILE + ")!");
		}
		finally {
			
			if (DEBUG)
				System.out.println("Termination: collection updated with " +
					collection.getSize() + " records.");
		}
	}
}
