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
import java.text.DecimalFormat;
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
final class Driver {
		
	/**
	 * Abstract class CelestialObject holds two shared variables:
	 * - type, and
	 * - name.
	 * 
	 * Classes extending CelestialObject include other variables according to their definition.
	 */
	private abstract class CelestialObject implements Serializable {
		
		/*
		 * Generated serialization ID.
		 */
		private static final long serialVersionUID = 399214390980759121L;

		protected DecimalFormat formatter;
	
		protected String type; // Celestial type.
		protected String name; // Celestial name.
		protected double radius; // Celestial radius.
	
		/**
		 * Default constructor.
		 * 
		 * @param type (a CelestialObject type, i.e. Star, Planet, or Moon)
		 * @param name (name of that CelestialObject)
		 */
		public CelestialObject(String type, String name, double radius) {
		
			setType(type);
			setName(name);
			setRadius(radius);
		
			/*
			 * Real numbers are output to 2 decimal places using this DecimalFormat instance.
			 */
			this.formatter = new DecimalFormat(".00");
		}
	
		/**
		 * Abstract method toString() declaration.
		 * 
		 * Implemented in all instances (extensions) of CelestialObject.
		 *  
		 * @return description (a String description of the CelestialObject instance)
		 */
		public abstract String toString();
		
		/**
		 * @return type
		 */
		public String getType() {
		
			return this.type;
		}
	
		/**
		 * @param type
		 */
		public void setType(String type) {
		
			this.type = type;
		}
	
		/**
		 * @return name
		 */
		public String getName() {
		
			return this.name;
		}
	
		/**
		 * @param name
		 */
		public void setName(String name) {
		
			this.name = name;
		}
	
		/**
		 * @return radius
		 */
		public double getRadius() {
		
			return this.radius;
		}

		/**
		 * @param radius
		 */
		public void setRadius(double radius) {
		
			this.radius = radius;
		}
	}
	
	/**
	 * Class implementation of a generic node in a collection data structure.
	 */
	private class Node implements Serializable {

		/*
		 * Generated serialization ID. 
		 */
		private static final long serialVersionUID = -3630135668746642577L;
	
		private CelestialObject celestialObject; // Actual node representation.
		private Node next; // Next node in the list.
		private Node previous; // Previous node in the list.

		/**
		 * Default constructor.
		 */
		public Node(CelestialObject celestialObject) {
		
			setCelestialObject(celestialObject);
	
			setNext(null);
			setPrevious(null);
		}

		/**
		 * @return celestialObject
		 */
		public CelestialObject getCelestialObject() {
		
			return this.celestialObject;
		}

		/**
		 * @param celestialObject
		 */
		public void setCelestialObject(CelestialObject celestialObject) {
		
			this.celestialObject = celestialObject;
		}

		/**
		 * @return next
		 */
		public Node getNext() {
		
			return this.next;
		}

		/**
		 * @param next
		 */
		public void setNext(Node next) {
		
			this.next = next;
		}

		/**
		 * @return previous
		 */
		public Node getPrevious() {
		
			return this.previous;
		}

		/**
		 * @param previous
		 */
		public void setPrevious(Node previous) {
		
			this.previous = previous;
		}
	}
	
	/**
	 * Class implementation of a collection in space data structure.
	 */
	private class CollectionInSpace {

		private int size;
	
		private Node front;
		private Node back;

		/**
		 * Default constructor.
		 */
		public CollectionInSpace() {
		
			setSize(0);
		
			setFront(null);
			setBack(null);		
		}
	
		/**
		 * Check whether CollectionInSpace is empty.
		 * 
		 * @return true/false
		 */
		public boolean isEmpty() {
		
			return (this.getFront() == null ||
					this.getSize() == 0);
		}
	
		/**
		 * @return front
		 */
		public Node getFront() {
		
			return this.front;
		}

		/**
		 * @param front
		 */
		public void setFront(Node front) {
		
			this.front = front;
		}

		/**
		 * @return back
		 */
		public Node getBack() {
		
			return this.back;
		}

		/**
		 * @param back
		 */
		public void setBack(Node back) {
		
			this.back = back;
		}

		/**
		 * @return size
		 */
		public int getSize() {
		
			return this.size;
		}

		/**
		 * @param size
		 */
		public void setSize(int size) {
		
			this.size = size;
		}
	
		/**
		 * Add (add in front of the collection) a new CelestialObject instance.
		 * 
		 * @param object
		 * 
		 * @return true/false
		 */
		public boolean add(CelestialObject object) {
		
			if (object == null)
				return false;
		
			Node node = new Node(object);
	    
			/*
			 * If collection is not empty, add to back. Otherwise add to front.
			 */
			if (this.isEmpty()) {
			
				setBack(node);
			}
			else {
		
				front.setPrevious(node);
	    	  
				node.setNext(this.front);
			}
	    
			setFront(node);
		
			this.size++;
		
			return true;
		}
	
		/**
		 * Append (add to the back of the collection) a new CelestialObject instance.
		 * 
		 * @param object
		 * 
		 * @return true/false
		 */
		public boolean append(CelestialObject object) {
		
			if (object == null)
				return false;

			Node node = new Node(object);
		
			/*
			 * If collection is empty, add as front. Otherwise add to back.
			 */
			if (this.isEmpty()) {

				setFront(node);
			}
			else {
			
				back.setNext(node);

				node.setPrevious(this.back);
			}

			setBack(node);
		
			this.size++;
		
			return true;
		}
	
		/**
		 * Remove the front Node instance in the collection.
		 * 
		 * @return true/false
		 */
		public boolean removeFirst() {
		
			if (this.getFront() == null)
				return false;
		
			setFront(this.front.getNext());
		
			this.size--;
		
			return true;
		}
	
		/**
		 * Remove the back Node instance in the collection.
		 * 
		 * @return true/false
		 */
		public boolean removeLast() {
		
			if (this.getFront() == null)
				return false;
		
			if (this.getFront().getNext() == null) {
			
				setFront(null);
			
				return true;
			}
		
			Node node = this.getFront();
		
			while (node.getNext().getNext() != null) {
			
				node = node.getNext();
			}
		
			node.setNext(null);
		
			this.size--;
		
			return true;
		}
	
		/**
		 * Remove a specific Node from the collection, provided that a CelestialObject instance is passed.
		 * 
		 * @param object
		 * 
		 * @return true/false
		 */
		public boolean removeNode(CelestialObject object) {
		
			if (object == null)
				return false;
		
			if (this.getFront() == null)
				return false;
		
			if (this.getFront().getCelestialObject().getName().equalsIgnoreCase(object.getName())) {
			
				setFront(this.getFront().getNext());
			
				this.size--;
			
				return true;
			}
		
			return false;
		}
	
		/**
		 * Attempt to remove all objects. If no data exists, do nothing.
		 * 
		 * @return
		 */
		public boolean removeAllNodes() {
		
			/*
			 * If nothing is to be removed, then nothing is yet to be done.
			 */
			if (this.isEmpty())
				return false;
		
			/*
			 * Start purging/popping nodes from back to front.
			 */
			Node current = this.getBack();
		
			do {
			
				this.removeLast();
			
				current = current.getPrevious();
			
			} while (current != null);
				
			return true;
		}
	
		/**
		 * Print all CelestialObject instances in ascending order (from back to front).
		 */
		public void printAscending() {
		
			Node current = this.getFront();
		
			while (current != null) {
			
				System.out.println(current.getCelestialObject().toString());
			
				current = current.getNext();
			}
		}
	
		/**
		 * Print all CelestialObject instances in descending order (from front to back).
		 */
		public void printDescending() {
		
			Node current = this.getBack();
		
			while (current != null) {
			
				System.out.println(current.getCelestialObject().toString());
			
				current = current.getPrevious();
			}
		}
	}
	
	/**
	 * Class representing the Mass data structure.
	 */
	private class Mass implements Serializable {

		/*
		 * Generated serialization ID.
		 */
		private static final long serialVersionUID = 8106409273070603331L;
	
		private double mantissa;
		private int exponent;
	
		/**
		 * Default constructor.
		 * 
		 * @param this
		 */
		public Mass(double mantissa, int exponent) {
		
			setMantissa(mantissa);
			setExponent(exponent);
		}

		/**
		 * @return mantissa
		 */
		public double getMantissa() {
		
			return this.mantissa;
		}

		/**
		 * @param mantissa
		 */
		public void setMantissa(double mantissa) {
		
			this.mantissa = mantissa;
		}

		/**
		 * @return exponent
		 */
		public int getExponent() {
		
			return this.exponent;
		}

		/**
		 * @param exponent
		 */
		public void setExponent(int exponent) {
		
			this.exponent = exponent;
		}
	}
	
	/*
	 * Star class.
	 */
	private class Star extends CelestialObject implements Serializable {
	
		/*
		 * Generated serialization ID.
		 */
		private static final long serialVersionUID = 7386362710231711089L;
	
		private char spectrum; // Spectrum level, defined as one char.
		private String brightness; // Brightness level, defined in Greek letters.
		private double distance; // Distance from the Sun.

		/**
		 * Default constructor.
		 * 
		 * @param type (type of the space body (in this case Star))
		 * @param name (name of the star)
		 * @param radius (radius of the star (in solar radius units where 1 solar radius = 695,500km))
		 * @param spectrum (a letter (a character) representing the spectrum (color of the star))
		 * @param brightness (luminosity (brightness) of the star)
		 * @param distance (how far away the star is (in light years))
		 */
		public Star(String type,
				String name,
				double radius,
				char spectrum,
				String brightness,
				double distance) {
		
			super(type, name, radius);
		
			setSpectrum(spectrum);
			setBrightness(brightness);
			setDistance(distance);
		}

		/* (non-Javadoc)
		 * @see CelestialObject#toString()
		 */
		@Override
		public String toString() {
		
			String specDescription = null;
		
			switch (this.getSpectrum()) {
		
			case 'o':
			case 'O':
				specDescription = "blue";
				break;

			case 'b':
			case 'B':
				specDescription = "blue-white";
				break;

			case 'a':
			case 'A':
				specDescription = "white";
				break;

			case 'f':
			case 'F':
				specDescription = "white-yellow";
				break;

			case 'g':
			case 'G':
				specDescription = "yellow";
				break;

			case 'k':
			case 'K':
				specDescription = "orange";
				break;

			case 'm':
			case 'M':
				specDescription = "red";
				break;

			default:
				specDescription = "nil";
				break;
			}
		
			String luminosity = null;
		
			if (this.getBrightness().equalsIgnoreCase("I"))
				luminosity = "supergiant";
		
			else if (this.getBrightness().equalsIgnoreCase("II"))
				luminosity = "bright giant";

			else if (this.getBrightness().equalsIgnoreCase("III"))
				luminosity = "normal giant";

			else if (this.getBrightness().equalsIgnoreCase("IV"))
				luminosity = "subgiant";

			else if (this.getBrightness().equalsIgnoreCase("V"))
				luminosity = "dwarf";

			else if (this.getBrightness().equalsIgnoreCase("VI"))
				luminosity = "subdwarf";

			else if (this.getBrightness().equalsIgnoreCase("VII"))
				luminosity = "white dwarf";

			return this.getType() + ": " + this.getName() + "\n  " +
					"radius = " + this.formatter.format(this.getRadius()) + " solar radii\n  " +
					"spectrum = " + this.getSpectrum() + " (" + specDescription + ")\n  " +
					"brightness = " + this.getBrightness() + " (" + luminosity +")\n  " +
					"distance = " + this.formatter.format(this.getDistance()) + " ly";
		}

		/**
		 * @return spectrum
		 */
		public char getSpectrum() {
		
			return this.spectrum;
		}

		/**
		 * @param spectrum
		 */
		public void setSpectrum(char spectrum) {
		
			this.spectrum = spectrum;
		}

		/**
		 * @return brightness
		 */
		public String getBrightness() {
		
			return this.brightness;
		}

		/**
		 * @param brightness
		 */
		public void setBrightness(String brightness) {
		
			this.brightness = brightness;
		}

		/**
		 * @return distance
		 */
		public double getDistance() {
		
			return this.distance;
		}

		/**
		 * @param distance
		 */
		public void setDistance(double distance) {
		
			this.distance = distance;
		}
	}
	
	/*
	 * Planet class.
	 */
	private class Planet extends CelestialObject implements Serializable {
	
		/*
		 * Generated serialization ID.
		 */
		private static final long serialVersionUID = 8734081843816872971L;

		private Mass mass;
		private double orbitalPeriod;
		private int temperature;
	
		/**
		 * Default constructor.
		 * 
		 * @param type (type of the space body (in this case Planet))
		 * @param name (name of the planet (may be more than one word))
		 * @param radius (radius of the planet (in kilometers))
		 * @param mass (mass of the planet in kilograms -
		 * 	contains the mantissa (a real number) and exponent (an integer) of the planet's mass expressed in scientific notation)
		 * @param orbitalPeriod (orbital period of the planet in days (how long it takes for the planet to orbit their star))
		 * @param temperature (temperature of the planet in degrees Kelvin (an integer))
		 */
		public Planet(String type,
				String name,
				double radius,
				Mass mass,
				double orbitalPeriod,
				int temperature) {
		
			super(type, name, radius);
				
			this.mass = new Mass(mass.getMantissa(), mass.getExponent());
		
			setOrbitalPeriod(orbitalPeriod);
			setTemperature(temperature);
		}

		/* (non-Javadoc)
		 * @see CelestialObject#toString()
		 */
		@Override
		public String toString() {
		
			return this.getType() + ": " + this.getName() + "\n  " +
					"radius = " + this.formatter.format(this.getRadius()) + " km\n  " +
					"mass = " + this.formatter.format(this.mass.getMantissa()) + " X 10^" +
						this.mass.getExponent() + " kg\n  " +
					"temp = " + this.getTemperature() + " degrees K\n  " +
					"orbital period = " + this.formatter.format(this.getOrbitalPeriod()) + " days";
		}

		/**
		 * @return mass
		 */
		public Mass getMass() {
		
			return this.mass;
		}

		/**
		 * @param mass
		 */
		public void setMass(Mass mass) {
		
			this.mass = mass;
		}

		/**
		 * @return orbitalPeriod
		 */
		public double getOrbitalPeriod() {
		
			return this.orbitalPeriod;
		}

		/**
		 * @param orbitalPeriod
		 */
		public void setOrbitalPeriod(double orbitalPeriod) {
		
			this.orbitalPeriod = orbitalPeriod;
		}

		/**
		 * @return temperature
		 */
		public int getTemperature() {
		
			return this.temperature;
		}

		/**
		 * @param temperature
		 */
		public void setTemperature(int temperature) {
		
			this.temperature = temperature;
		}
	}
	
	/**
	 * Moon class.
	 */
	private class Moon extends CelestialObject implements Serializable {

		/*
		 * Generated serialization ID.
		 */
		private static final long serialVersionUID = -1258286635960628041L;
	
		private Mass mass;
		private String orbit;
		private int temperature;
	
		/**
		 * Default constructor.
		 * 
		 * @param type (type of the space body (in this case Moon))
		 * @param name (name of the moon (may be more than one word))
		 * @param radius (radius of the moon (in kilometers))
		 * @param mass (mass of the moon in kilograms -
		 * 	contains the mantissa (a real number) and exponent (an integer) of the moon's mass expressed in scientific notation)
		 * @param orbit (name of the planet that the moon orbits (i.e. the moon is a satellite of this planet))
		 * @param temperature (temperature of the moon in degrees Kelvin (an integer))
		 */
		public Moon(String type,
				String name,
				double radius,
				Mass mass,
				String orbit,
				int temperature) {
		
			super(type, name, radius);
				
			this.mass = new Mass(mass.getMantissa(), mass.getExponent());
		
			setOrbit(orbit);
			setTemperature(temperature);
		}

		/* (non-Javadoc)
		 * @see CelestialObject#toString()
		 */
		@Override
		public String toString() {
		
			return this.getType() + ": " + this.getName() + "\n  " +
					"radius = " + this.formatter.format(this.getRadius()) + " km\n  " +
					"mass = " + this.formatter.format(this.mass.getMantissa()) + " X 10^" +
						this.mass.getExponent() + " kg\n  " +
					"temp = " + this.getTemperature() + " degrees K\n  " +
					"satellite of " + this.getOrbit();
		}

		/**
		 * @return mass
		 */
		public Mass getMass() {
		
			return this.mass;
		}

		/**
		 * @param mass
		 */
		public void setMass(Mass mass) {
		
			this.mass = mass;
		}

		/**
		 * @return orbit
		 */
		public String getOrbit() {
		
			return this.orbit;
		}

		/**
		 * @param orbit
		 */
		public void setOrbit(String orbit) {
		
			this.orbit = orbit;
		}

		/**
		 * @return temperature
		 */
		public int getTemperature() {
		
			return this.temperature;
		}

		/**
		 * @param temperature
		 */
		public void setTemperature(int temperature) {
		
			this.temperature = temperature;
		}
	}

	/**
	 * Properties.
	 */
	private static final boolean DEBUG = true;
	private static final String INFILE = "Driver.in";
	private static final String OUTFILE = "Driver.out";
	
	private static File inFile;
	private static File outFile;
	private static PrintWriter printWriter;
	private static Scanner scanner;
	private static CollectionInSpace collection;
	
	/**
	 * Default constructor.
	 */
	public Driver() {
		
		collection = new CollectionInSpace();
	}
	
	/**
	 * Read form a text file. User input is NOT required.
	 */
	private void importData() {
		
		try {
			
			inFile = new File(INFILE);
			FileInputStream fis = new FileInputStream(inFile);
			
			scanner = new Scanner(fis);
			scanner.useLocale(Locale.US);

			/*
			 * Checksum: see whether the collection object is already loaded with data from the
			 * text file as per assignment requirements.
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
				
				System.out.print("Loading... ");
				
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
							
						} else if (type.equalsIgnoreCase("Planet")) {
														
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
							
						} else if (type.equalsIgnoreCase("Moon")) {
							
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
					
					System.out.println("Complete.");
					
					if (DEBUG)
						System.out.println("Collection size after importation " +
							collection.getSize() + ".");
					
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
	 * Write to a data file. Filename is required by the user.
	 */
	private void exportData() {
		
		try {
			
			outFile = new File(OUTFILE);
			printWriter = new PrintWriter(new FileWriter(outFile));

			/*
			 * Save collection data to the file.
			 */
			if (!collection.isEmpty()) {

				if (DEBUG)
					System.out.println("Processing " +
							collection.getSize() +
							" records...");

				Node current = collection.getFront();
				
				int index;
				for (index = 0;
					index <= collection.getSize() && current != null;
					current = current.getNext()) {
					
					printWriter.println(current.getCelestialObject().getName() +
						" (" +
						current.getCelestialObject().getType() +
						")");
				}
				
				current = null;
				
			} else {

				System.err.println("Warning: error while saving " +
					collection.getSize() + " records!");
			}
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			
			e.printStackTrace();
		}
		finally {
			
			if (outFile != null)
				outFile = null;
			
			if (printWriter != null)
				printWriter.close();
			printWriter = null;
		}
	}
	
	/*
	 * Enumeration used for printing collection data (order) to screen.
	 */
	private static enum PrintOrder {
		
		ascending,
		descending;
	};
	
	/**
	 * Print collection content. Ordered by either ascending or descending matter.
	 * 
	 * @param order
	 */
	private void print(PrintOrder order) {
		
		switch (order) {
		
		case ascending:
			System.out.println("Printing in Ascending order...");
			collection.printAscending();
			break;
			
		case descending:
			System.out.println("Printing in Descending order...");
			collection.printDescending();
			break;
			
		default:
			break;
		}
	}
			
	/**
	 * @param args (arguments passed via command prompt)
	 */
	public static void main(String[] args) {
				
		Driver driver = new Driver();
		
		/*
		 * Read from INFILE.
		 */
		driver.importData();

		/**
		 * Print collection content.
		 */
		// driver.print(PrintOrder.ascending);
		// driver.print(PrintOrder.descending);

		/**
		 * Write to OUTFILE.
		 */
		driver.exportData();
	}
}
