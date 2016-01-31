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

import java.lang.String;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Locale;
import java.util.StringTokenizer;
import java.io.*;

/**
 * Application's driver class.
 *
 * Created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */
public class BinaryIO implements Menu {
	
	private static final boolean DEBUG = true;
	private static final String BINARYFILE = "data.bin";
	
	private static File inFile;
	private static File outFile;
	private static FileInputStream fis;
	private static PrintWriter printWriter;
	private static Scanner scanner;
	private static ArrayList<String> collection;
	
	/**
	 * Default constructor.
	 */
	public BinaryIO() {
		
		collection = new ArrayList<String>();
	}
	
	/**
	 * Read form a text file. User input is NOT required.
	 */
	private void importData() {
		
		try {
			inFile = new File("in.txt");
			fis = new FileInputStream(inFile);
			
			scanner = new Scanner(fis);
			scanner.useLocale(Locale.US);

			/*
			 * Checksum: see whether the collection object is already loaded with data from the
			 * binary file as per assignment requirements.
			 * If this is the case, then it is better that we reset the collection.
			 */
			if (!collection.isEmpty()) {
				
				collection.removeAllNodes();
				collection = null;
				collection = new CollectionInSpace();
				
				if (DEBUG)
					System.out.println("Collection reset occurred (" +
							collection.getSize() + " records).");
			}
			
			if (fis != null) {
				
				System.out.print("\nLoading... ");
				
				try {
					
					while (scanner.hasNextLine()) {
						
						/*
						 * Reading data file.
						 * 
						 * First-ordered expectation is to be of Star type.
						 * Second-ordered expectation is to be of Planet type.
						 * Third-ordered expectation is to be of Moon type.
						 */
						String type = scanner.nextLine().trim();
						
						if (type.equalsIgnoreCase("Star")) {
							
							CelestialObject star = new Star(
									"Star",
									scanner.nextLine().trim(),
									Double.parseDouble(scanner.nextLine().trim()),
									scanner.nextLine().trim().charAt(0),
									scanner.nextLine().trim(),
									Double.parseDouble(scanner.nextLine().trim()));
							
							collection.append(star);
							
							star = null;
						}
						else if (type.equalsIgnoreCase("Planet")) {
														
							String name = scanner.nextLine().trim();
							double radius = Double.parseDouble(scanner.nextLine().trim());
							
							StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine().trim());
							
							double mantissa = 0.0;
							int exponent = 0;
							
							while (tokenizer.hasMoreTokens()) {
								
								mantissa = Double.parseDouble(tokenizer.nextToken().trim());
								exponent = Integer.parseInt(tokenizer.nextToken().trim());
							}
							
							double orbitalPeriod = Double.parseDouble(scanner.nextLine().trim());
							int temperature = Integer.parseInt(scanner.nextLine().trim());
							
							CelestialObject planet = new Planet(
									"Planet",
									name,
									radius,
									new Mass(mantissa, exponent),
									orbitalPeriod,
									temperature);
							
							collection.append(planet);
							
							planet = null;
						}
						else if (type.equalsIgnoreCase("Moon")) {
							
							String name = scanner.nextLine().trim();
							double radius = Double.parseDouble(scanner.nextLine().trim());
							
							StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine().trim());
							
							double mantissa = 0.0;
							int exponent = 0;
							
							while (tokenizer.hasMoreTokens()) {
								
								mantissa = Double.parseDouble(tokenizer.nextToken().trim());
								exponent = Integer.parseInt(tokenizer.nextToken().trim());
							}
							
							String orbit = scanner.nextLine().trim();
							int temperature = Integer.parseInt(scanner.nextLine().trim());
							
							CelestialObject moon = new Moon(
									"Moon",
									name,
									radius,
									new Mass(mantissa, exponent),
									orbit,
									temperature);
							
							collection.append(moon);
							
							moon = null;
						}	
					}
				}
				catch (NoSuchElementException e) {
					
					e.printStackTrace();
				}
				catch (NumberFormatException e) {
					
					e.printStackTrace();
				}
				finally {
					
					System.out.println("Complete.\n");
					
					if (DEBUG)
						System.out.println("Collection size = " + collection.getSize());
					
					if (fis != null)
						fis.close();
					fis = null;
					
					if (scanner != null)
						scanner.close();
					scanner = null;
				}
			}			
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (EOFException e) {
			
			e.printStackTrace();							
		}
		catch (StreamCorruptedException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Read collection data from the binary fine "warp.bin", if exists.
	 * 
	 * @return true/false
	 * 
	 * @throws IOException
	 * @throws EOFException
	 * @throws FileNotFoundException
	 */
	private boolean importBinaryData()
			throws IOException, EOFException, FileNotFoundException {
		
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		
		/*
		 * First attempt is to find out whether BINARYFILE exists or not.
		 */
		fileInputStream = new FileInputStream(new File(BINARYFILE));
		objectInputStream = new ObjectInputStream(fileInputStream);
		
		/*
		 * Import old collection data from the BINARYFILE (collection override).
		 */
		if (DEBUG)
			System.out.println("Loading binary data...");
						
		/*
		 * If old data exists, try purging it first for more consistency.
		 */
		if (!collection.isEmpty())
			collection.removeAllNodes();
			
		collection = null;
		collection = new CollectionInSpace();
			
		try {
			
			while (objectInputStream.available() != 0) {
				
				/*
				 * Reading binary data file.
				 */
				Object object = objectInputStream.readObject();
				
				if (collection.add((CelestialObject)object) == false)
					break;
			}
		}
		catch (Exception e) {
				
			e.printStackTrace();
		}
		finally {
			
			/*
			 * Terminate both fileInputStream and objectInputStream objects.
			 */
			if (fileInputStream != null)
				fileInputStream.close();
			fileInputStream = null;
			
			if (objectInputStream != null)
				objectInputStream.close();
			objectInputStream = null;
		}
				
		/*
		 * Checksum: if the import process was not successful, throw a warning message.
		 */
		if (collection.isEmpty()) {
			
			System.err.println("Warning: still can't import from (" + BINARYFILE + ")!");
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * Save new collection content to the binary fine "warp.bin".
	 * 
	 * @return true/false
	 * 
	 * @throws IOException
	 * @throws EOFException
	 * @throws FileNotFoundException
	 */
	private boolean exportBinaryData()
			throws IOException,	EOFException, FileNotFoundException, NotSerializableException {
		
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		/*
		 * Save, if possible, collection data to the binary file. Depending on type.
		 */
		if (!collection.isEmpty()) {
			
			if (DEBUG)
				System.out.println("Processing " + collection.getSize() +
						" records... Saving data to (" + BINARYFILE + ")...");
			
			/*
			 * Set up the output stream objects.
			 */
			fileOutputStream = new FileOutputStream(new File(BINARYFILE));
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
						 
			Node current = collection.getFront();
			
			int index;
			for (index = 0;
					index <= collection.getSize() && current != null;
					current = current.getNext()) {
				
				/*
				 * Save (add) the CelestialObject instance to the BINARYFILE.
				 */
				objectOutputStream.writeObject(current.getCelestialObject());
				
				index++;
			}
			
			current = null;
			
			if (DEBUG)
				System.out.println("Done exporting " + index +
					" records to " + BINARYFILE + ".");
		}
		else {
			
			System.err.println("Warning: something went wrong while exporting " +
					collection.getSize() + " records to " + BINARYFILE + "!");
			
			return false;
		}

		/*
		 * Finally, close all object streams.
		 */
	    if (fileOutputStream != null)
	    	fileOutputStream.close();
	    fileOutputStream = null;
	    
	    if (objectOutputStream != null)
	    	objectOutputStream.close();
	    objectOutputStream = null;
	    
	    return true;
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
		System.out.println("L) Largest: Celestial Object");
		System.out.println("A) All Moons: Planet");
		System.out.println("R) Range: Degrees");
		System.out.println("E) Exit: Submenu");
		System.out.println("**********************");
		System.out.print("Make your choice: ");
	}
	
	/**
	 * @param args (arguments passed via command prompt)
	 */
	public static void main(String[] args) {
				
		BinaryIO binaryIO = new BinaryIO();
		
		/*
		 * Checksum: if the binary file exists or not.
		 */
		try {
			
			if (binaryIO.importBinaryData())
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
		binaryIO.runMenu();

		/*
		 * Update the binary file with new, if so, collection data.
		 */
		try {
			
			binaryIO.exportBinaryData();
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
