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
 * Skeleton code created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */

import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Iterator;
import java.io.*;
import java.lang.String;
import java.lang.Math;

/**
 * A class is the entry point for constructing clusters of DataPoint instances (using k-Means).
 * Each algorithm instance is associated with one or more Cluster instances.
 *
 * Class ClusteringAlgorithm holds five variables:
 * - numberOfClusters,
 * - clusters (as an array),
 * - dataPoints (as a Vector),
 * - numberOfIterations (denoting the parameter "k" in the Cluster Analysis literature), and
 * - sumOfWCSS (or the Sum of Within-Cluster Sums of Squares).
 */
class ClusteringAlgorithm {
	
	/**
	 * Class DataPoint holds five variables:
	 * - identifier (or name),
	 * - two Cartesian (spacial) coordinates (x, y),
	 * - Cluster (reference), and
	 * - Euclidean distance (from Centroid).
	 */
	private static class DataPoint {
	
		/**
		 * Variables.
		 */
		private double x, y;
		private String identifier;
		private Cluster cluster;
		private double euclideanDistance;
		
		/*
		 * Real numbers are output to 2 decimal places using this DecimalFormat instance.
		 */
		protected static DecimalFormat formatter = new DecimalFormat(".00");
		
		/**
		 * Default constructor.
		 */
		public DataPoint() {
		
			// Set the parameters.
			this.x = 0.0;
			this.y = 0.0;
			this.identifier = null;
			this.cluster = null;
		}
	
		/**
		 * @param x
		 * @param y
		 * @param identifier
		 */
		public DataPoint(double x, double y, String identifier) {
		
			// Pass the parameters.
			this.x = x;
			this.y = y;
			this.identifier = identifier;
			this.cluster = null;
		}
	
		/* (non-Javadoc)
		 * @see CelestialObject#toString()
		 */
		@Override
		public String toString() {
	
			return getIdentifier() + " (" +
				formatter.format(getX()) + ", " +
				formatter.format(getY()) + ")";
		}
	
		/**
		 * @param x
		 */
		public void setX(double x) {
		
			this.x = x;
		}
	
		/**
		 * @param y
		 */
		public void setY(double y) {
		
			this.y = y;
		}
	
		/**
		 * @param identifier
		 */
		public void setIdentifier(String identifier) {
		
			this.identifier = identifier;
		}
	
		/**
		 * @param cluster
		 */
		public void setCluster(Cluster cluster) {
		
			this.cluster = cluster;
		
			calculateEuclideanDistance();
		}
	
		/**
		 * @return x
		 */
		public double getX() {
		
			return this.x;
		}

		/**
		 * @return y
		 */
		public double getY() {
		
			return this.y;
		}

		/**
		 * @return identifier
		 */
		public String getIdentifier() {
		
			return this.identifier;
		}

		/**
		 * @return cluster
		 */
		public Cluster getCluster() {
		
			return this.cluster;
		}

		/**
		 * @return euclideanDistance
		 */
		public double getEuclideanDistance() {
		
			return this.euclideanDistance;
		}
	
		/**
		 * Calculate the Euclidean distance.
		 * Called when a new DataPoint instance is added to a Cluster,
		 * or when the Centroid is recalculated.
		 */
		public void calculateEuclideanDistance() {
		
			euclideanDistance = Math.sqrt(
				Math.pow((getX() - getCluster().getCentroid().getX()), 2.0) +
				Math.pow((getY() - getCluster().getCentroid().getY()), 2.0));
		}

		/**
		 * Test the Euclidean distance calculation method.
		 *
	   	 * @param centroid
	   	 * @return euclideanDistance
		 */
		public double testEuclideanDistance(Centroid centroid) {
		
			return Math.sqrt(
				Math.pow((getX() - centroid.getX()), 2.0) +
				Math.pow((getY() - centroid.getY()), 2.0));
		}
	}
	
	/**
	 * A Cluster (in the Cluster Analysis domain) relates to more than one DataPoint, and one Centroid.
	 *
	 * Class Cluster holds four variables:
	 * - identifier (or name),
	 * - centroid (reference),
	 * - sumOfSquares, and
	 * - dataPoints (as a collection or an array).
	 */
	private static class Cluster {
	
		/**
		 * Variables.
		 */
		private String identifier;
		private Centroid centroid;
		private double sumOfSquares;
		private Vector dataPoints;
	
		/**
		 * Default constructor.
		 *
		 * @param identifier
		 */
		public Cluster(String identifier) {
		
			// Pass the parameters.
			this.identifier = identifier;
			this.centroid = null; /* Will be set later via setCentroid(). */
			this.dataPoints = new Vector();
		}
	
		/**
		 * @param identifier
		 */
		public void setIdentifier(String identifier) {
		
			this.identifier = identifier;
		}
	
		/**
		 * @param centroid
		 */
		public void setCentroid(Centroid centroid) {
		
			this.centroid = centroid;
		}
		
		/**
		 * @return identifier
		 */
		public String getIdentifier() {
		
			return this.identifier;
		}
		
		/**
		 * @return sumOfSquares
		 */
		public double getSumOfSquares() {
		
			return this.sumOfSquares;
		}

		/**
		 * @return centroid
		 */
		public Centroid getCentroid() {
		
			return this.centroid;
		}
	
		/**
		 * @return dataPoints
		 */
		public Vector getDataPoints() {
		
			return this.dataPoints;
		}
	
		/**
		 * @return dataPoints (size)
		 */
	    public int getNumberOfDataPoints() {
		
			return getDataPoints().size();
	    }
	
		/**
		 * Calculate the Sum of Squares.
		 * Called from Centroid.
		 */
		public void calculateSumOfSquares() {
		
			// Establish the Sum of Squares.
			double _sumOfSquares = 0.0;
	
			// Establish the Sum of Squares.
			int size = getDataPoints().size();
		
			// Loop through existing DataPoint instances within this Cluster.
			for (int i = 0; i < size; ++i) {
		
				// Accumulate it.
				_sumOfSquares += ((DataPoint)getDataPoints().elementAt(i)).getEuclideanDistance();
			}
	
			// Save it.
			this.sumOfSquares = _sumOfSquares;
		}
	
		/**
		 * Get a reference to a DataPoint instance in the dataPoints collection (if it exists).
		 *
		 * @param index
		 */
		public DataPoint getDataPoint(int index) {
		
			/* Cast it first! */
			return (DataPoint)this.dataPoints.elementAt(index);
		}
	
		/**
		 * Add a new DataPoint instance to the dataPoints collection.
		 *
		 * @param dataPoint
		 */
		public void addDataPoint(DataPoint dataPoint) {
		
			/* This will trigger a call to calculateEuclideanDistance() in (DataPoint.java). */
			dataPoint.setCluster(this);
		
			/* Add it locally. */
			getDataPoints().addElement(dataPoint);
		
			/* Update sumOfSquares. */
			calculateSumOfSquares();
		}
	
		/**
		 * Remove a DataPoint instance from the dataPoints collection (if it exists).
		 *
		 * @param dataPoint
		 */
		public void removeDataPoint(DataPoint dataPoint) {
		
			/* Remove it. */
			getDataPoints().removeElement(dataPoint);
		
			/* Update sumOfSquares. */
			calculateSumOfSquares();
		}
	}
	
	/**
	 * A Centroid is calculated using an equation,
	 * which in turn divides the sample space for each dimension into equal parts.
	 * depending on the "numberOfClusters" parameter (as predetermined in ClusteringAlgorithm.java).
	 *
	 * Class Centroid holds three variables:
	 * - two Cartesian (spacial) coordinates (x, y), and
	 * - cluster (reference).
	 */
	private static class Centroid {
	
		/**
		 * Variables.
		 */
		private double x, y;
		private Cluster cluster;
	
		/**
		 * Default constructor.
		 *
		 * @param x
		 * @param y
		 */
		public Centroid(double x, double y) {
		
			// Pass the parameters.
			this.x = x;
			this.y = y;
			this.cluster = null; /* Set later. */
		}
	
		/**
		 * Calculates/recalculates the Centroid's position within a Cluster.
		 * Called from ClusteringAlgorithm.java.
		 */
		public void calculate() {
		
			// Get a reference to the current number of Cluster points.
			int numberOfDataPoints = getCluster().getNumberOfDataPoints();
		
			double _x = 0.0;
			double _y = 0.0;
		
			// Reset the positions array.
			for (int i = 0; i < numberOfDataPoints; ++i) {
		
				// Update the current x value.
				_x += getCluster().getDataPoint(i).getX();

				// Update the current x value.
				_y += getCluster().getDataPoint(i).getY();
			}
		
			// Update the coordinates.
			setX(_x / numberOfDataPoints);
			setY(_y / numberOfDataPoints);
				
			for (int i = 0; i < numberOfDataPoints; ++i) {
			
				// Calculate the new Euclidean Distance for each DataPoint instance in the Cluster reference.
			    getCluster().getDataPoint(i).calculateEuclideanDistance();
			}
			
			// Recalculate SumOfSquares for the Cluster reference.
			getCluster().calculateSumOfSquares();
		}
	
		/**
		 * @return cluster
		 */
		public Cluster getCluster() {
		
			return this.cluster;
		}
	
		/**
		 * @param cluster
		 */
		public void setCluster(Cluster cluster) {
		
			this.cluster = cluster;
		}
	
		/**
		 * @return x
		 */
		public double getX() {
		
			return this.x;
		}

		/**
		 * @return y
		 */
		public double getY() {
		
			return this.y;
		}
	
		/**
		 * @param x
		 */
		public void setX(double x) {
		
			this.x = x;
		}
		
		/**
		 * @param y
		 */
		public void setY(double y) {
		
			this.y = y;
		}
	}
	
	/**
	 * Variables.
	 */
	private Cluster[] clusters;
	private Vector dataPoints = new Vector();
	private double sumOfWCSS;
	
	/**
	 * Additional properties.
	 */
	private static final boolean DEBUG = true;
	private static final String INFILE = "ClusteringAlgorithm.in";
	private static final String OUTFILE = "ClusteringAlgorithm.ans";
	
	private static int numberOfIterations = 0;
	private static int numberOfDataPoints = 0;
	private static int numberOfClusters = 0;
	
	private static File inFile;
	private static File outFile;
	private static PrintWriter printWriter;
	private static Scanner scanner;
			
	/**
	 * Default constructor for the k-Means Clustering algorithm.
	 */
	public ClusteringAlgorithm() {
		
		try {
			
			// Print the class name.
			// System.out.println(this.getClass().getName());
			
			inFile = new File(INFILE);
			FileInputStream fis = new FileInputStream(inFile);
			
			scanner = new Scanner(fis);
			scanner.useLocale(Locale.US);

			// Used for keeping track of the current line number.
			int lineNumber = 1;

			/*
			 * Checksum: see whether the collection object is already loaded with data from the
			 * text file as per assignment requirements.
			 * If this is the case, then it is better that we reset the collection.
			 */
			if (!dataPoints.isEmpty()) {
			
				dataPoints.clear();
				dataPoints = null;
				dataPoints = new Vector();
		
				if (DEBUG)
					System.out.println("Collection (dataPoints) initialized with (" +
						dataPoints.size() + " records).");				
			}
			
			/*
			 * Read the data file.
			 */
			if (fis != null) {
				
				if (DEBUG)
					System.out.print("Loading... ");
				
				try {
					
					while (scanner.hasNextLine()) {
					
						/*
						 * Line 1 defines the "size" of the dataPoint collection.
						 */
						if (lineNumber == 1) {
						
							// Establish numberOfDataPoints.
							numberOfDataPoints = Integer.parseInt(scanner.nextLine().trim());
						
							// Move on.
							++lineNumber;
						
						} else if (lineNumber == 2) { /* Line 2 defines numberOfClusters. */
						
							// Establish numberOfClusters.
							numberOfClusters = Integer.parseInt(scanner.nextLine().trim());
						
							// Move on.
							++lineNumber;
						
						} else if (lineNumber == 3) { /* Line 3 defines numberOfIterations. */
						
							// Establish numberOfIterations.
							numberOfIterations = Integer.parseInt(scanner.nextLine().trim());
						
							// Move on.
							++lineNumber;
							
						} else { /* Lines 4-9 define DataPoint entries. */
							
							StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine().trim());
							
							double x = 0.0;
							double y = 0.0;
							String identifier = null;
							
							while (tokenizer.hasMoreTokens()) {
								
								identifier = tokenizer.nextToken().trim();
								x = Double.parseDouble(tokenizer.nextToken().trim());
								y = Double.parseDouble(tokenizer.nextToken().trim());
							}
							
							dataPoints.add(new DataPoint(x, y, identifier));
							
							// Move on.
							++lineNumber;
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
						System.out.println("Collection (dataPoints) size after importation " +
							dataPoints.size() + ".");
					
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
		
		// Init the clusters array based on numberOfClusters (or parameter "k").
		this.clusters = new Cluster[numberOfClusters];
		
		for (int i = 0; i < numberOfClusters; ++i) {
			
			clusters[i] = new Cluster("Cluster[" + i + "]");
		}
	}
	
	/**
	 * Calculate the Sum of Within-Cluster Sums of Squares.
	 */
	private void calculateSumOfWCSS() {
		
		// Establish a Sum of Within-Cluster Sums of Squares temp value.
		double _sumOfWCSS = 0.0;
				
		// Loop through existing Cluster instances.
		for (int i = 0; i < this.clusters.length; ++i) {
		
			// Accumulate it.
			_sumOfWCSS += this.clusters[i].getSumOfSquares();
		}
	
		// Save it.
		setSumOfWCSS(_sumOfWCSS);
	}
	
	/**
	 * @return clusters (as a Vector instance)
	 */
	public Vector[] getClusters() {
		
		// Establish a temporal "clusters" collection.
		Vector _clusters[] = new Vector[this.clusters.length];
		
		for (int i = 0; i < clusters.length; ++i) {
			
			// Copy each dataPoints from each Cluster instance.
			_clusters[i] = clusters[i].getDataPoints();
		}
		
		// Return it as an array of Vector.
		return _clusters;
	}
	
	/**
	 * @param sumOfWCSS
	 */
	public void setSumOfWCSS(double sumOfWCSS) {
		
		this.sumOfWCSS = sumOfWCSS;
	}
	
	/**
	 *  Sets the starting (initial) Centroid (x, y) coordinates - start of step 1.
	 */
	private void initializeCentroids() {
		
		/*
		 * kn = (round((max - min) / k) * n) + min; where (n) = 0 to k - 1.
		 */
		double x = 0.0, y = 0.0;
		
		// Loop through each Cluster index in this Clustering Algorithm instance.
		for (int idx = 1; idx <= clusters.length; ++idx) {
			
			// Recalculate both (x, y).
			x = (((getXMAX() - getXMIN()) / (clusters.length + 1)) * idx) + getXMIN();
			y = (((getYMAX() - getYMIN()) / (clusters.length + 1)) * idx) + getYMIN();
			
			// Establish a new Centroid.
			Centroid centroid = new Centroid(x, y);
			
			// Update the Centroid (circular reference).
			this.clusters[idx - 1].setCentroid(centroid);
			
			// Update its number to reflect the current Cluster number.
			centroid.setCluster(this.clusters[idx - 1]);
		}
	}
	
	/**
	 * @param index
	 *
	 * @return cluster
	 */
	public Cluster getCluster(int index) {
		
		return this.clusters[index];
	}
		
	/**
	 * @return dataPoints
	 */
	public Vector getDataPoints() {
		
		return this.dataPoints;
	}
		
	/**
	 * @return sumOfWCSS
	 */
	public double getSumOfWCSS() {
		
		return this.sumOfWCSS;
	}
	
	/**
	 * @return x (MAX)
	 */
	public double getXMAX() {
		
		double x = ((DataPoint)getDataPoints().elementAt(0)).getX();
		
		for (int i = 0; i < getDataPoints().size(); ++i) {
			
			DataPoint point = (DataPoint)getDataPoints().elementAt(i);
			
			x = (point.getX() > x) ? point.getX() : x;
		}
		
		return x;
	}
	
	/**
	 * @return y (MAX)
	 */
	public double getYMAX() {
		
		double y = ((DataPoint)getDataPoints().elementAt(0)).getY();
		
		for (int i = 0; i < getDataPoints().size(); ++i) {
			
			DataPoint point = (DataPoint)getDataPoints().elementAt(i);
			
			y = (point.getY() > y) ? point.getY() : y;
		}
		
		return y;
	}

	/**
	 * @return x (MIN)
	 */
	public double getXMIN() {
		
		double x = ((DataPoint)getDataPoints().elementAt(0)).getX();
		
		for (int i = 0; i < getDataPoints().size(); ++i) {
			
			DataPoint point = (DataPoint)getDataPoints().elementAt(i);
			
			x = (point.getX() < x) ? point.getX() : x;
		}
		
		return x;
	}

	/**
	 * @return y (MIN)
	 */
	public double getYMIN() {
		
		double y = ((DataPoint)getDataPoints().elementAt(0)).getY();
		
		for (int i = 0; i < getDataPoints().size(); ++i) {
			
			DataPoint point = (DataPoint)getDataPoints().elementAt(i);
			
			y = (point.getY() < y) ? point.getY() : y;
		}
		
		return y;
	}

	/**
	 * Invoke (or call) the k-Means Clustering algorithm.
	 */
	private void invoke() {
		
		// Set the starting (initial) Centroid (x, y) coordinates - start of step 1.
		initializeCentroids();
		
		// Establish a DataPoint index.
		int idx = 0;
		
		// Add a DataPoint instance to this cluster.
		loop: while (true) {
			
			for (int i = 0; i < clusters.length; ++i) {
				
				// Add a DataPoint at (idx) to this Cluster.
				clusters[i].addDataPoint((DataPoint)getDataPoints().elementAt(idx));
				
				// Move on.
				idx++;
				
				// If we have reached capacity.
				if (idx >= getDataPoints().size()) {
					
					break loop;
				}
			}
		}
		
		// Calculate (E) for all the Cluster instances.
		calculateSumOfWCSS();
		
		// Recalculate Cluster Centroids - start of step 2.
		for (int i = 0; i < this.clusters.length; ++i) {
			
			this.clusters[i].getCentroid().calculate();
		}
		
		// Recalculate (E) for all the clusters.
		calculateSumOfWCSS();

		// For each numberOfIterations.
		for (int i = 0; i < numberOfIterations; ++i) {
			
			// Enter the loop for each Cluster instance.
			for (int j = 0; j < clusters.length; ++j) {
				
				// Pick the first element of the first cluster.
				for (int k = 0; k < this.clusters[j].getNumberOfDataPoints(); ++k) {
				
					// Get the current Euclidean/Manhattan distance for Cluster[j].
					double distance = this.clusters[j].getDataPoint(k).getEuclideanDistance();
					
					Cluster cluster = null;
					boolean found = false;
					
					// Call the testEuclideanDistance() method for all Cluster instances.
					for (int l = 0; l < clusters.length; l++) {
						
						// Check whether the last distance is > the present distance.
						if (distance >
							this.clusters[j].getDataPoint(k).testEuclideanDistance(this.clusters[l].getCentroid())) {
							
							// Record the Euclidean distance.
							distance = this.clusters[j].getDataPoint(k).testEuclideanDistance(this.clusters[l].getCentroid());
							
							// Found!
							cluster = clusters[l];
							found = true;
						} 
						
					} // For (l) looping through different Clusters for matching a DataPoint.

					// Add a DataPoint to the Cluster and execute calculateSumOfWCSS().
					if (found) {
						
						cluster.addDataPoint(this.clusters[j].getDataPoint(k));
						
						this.clusters[j].removeDataPoint(clusters[j].getDataPoint(k));
						
						for (int m = 0; m < this.clusters.length; ++m) {
							
							this.clusters[m].getCentroid().calculate();
							
						} // For (m) recalculating centroids for all clusters.
						
						// Recalculate (E) for all the Clusters.
						calculateSumOfWCSS();
						
					} // A DataPoint is found: is eligible for transfer between Clusters.
					
				} // For (k) looping through all DataPoint instances of the current Cluster.
				
			} // For (j) looping through all Clusters.
			
		} // For (i) numberOfIterations.
	}
		
	/**
	 * @param args (arguments passed via command prompt)
	 */
	public static void main(String[] args) {
		
		// Init the k-Means Clustering algorithm.
		ClusteringAlgorithm kMeans = new ClusteringAlgorithm();
		
		// Invoke k-Means.
		kMeans.invoke();
				
		// Establish the current Clusters (as an array of Vector).
		Vector[] clusters = kMeans.getClusters();
		
		// Loop through all the Cluster sets.
		for (int i = 0; i < clusters.length; ++i){
			
			// Establish the current Cluster instances (as a Vector of Clusters).
			Vector _clusters = clusters[i];
			
			// Display (print) all Cluster identifiers.
			System.out.println("---- " + kMeans.getCluster(i).getIdentifier());
			
			// Display (print) all Cluster DataPoints.
			Iterator iterator = _clusters.iterator();
			
			while (iterator.hasNext()){
				
				// Get the current DataPoint.
				DataPoint point = (DataPoint)iterator.next();
				
				// Display it.
				System.out.println(point.toString());
			}
		}
	}
}
