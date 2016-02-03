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

import java.lang.String;
import java.util.Vector;
import java.util.Iterator;

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
public class ClusteringAlgorithm {
	
	/**
	 * Variables.
	 */
	private int numberOfClusters;
	private Cluster[] clusters;
	private int numberOfIterations;
	private Vector dataPoints;
	private double sumOfWCSS;
	
	/**
	 * Default constructor for the k-Means Clustering algorithm.
	 *
	 * @param numberOfClusters
	 * @param numberOfIterations
	 * @param dataPoints
	 */
	public ClusteringAlgorithm(
		int numberOfClusters,
		int numberOfIterations,
		Vector dataPoints) {
		
		// Init the clusters array based on numberOfClusters (or parameter "k").
		this.clusters = new Cluster[numberOfClusters];
		
		for (int i = 0; i < numberOfClusters; ++i) {
			
			clusters[i] = new Cluster("Cluster[" + i + "]");
		}
		
		// Set the other parameters.
		this.numberOfIterations = numberOfIterations;
		this.dataPoints = dataPoints;
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
	 *  Sets the starting (Initial) Centroid (x, y) coordinates - start of step 1.
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
	 * @return numberOfIterations
	 */
	public int getNumberOfIterations() {
		
		return this.numberOfIterations;
	}
	
	/**
	 * @return dataPoints
	 */
	public Vector getDataPoints() {
		
		return this.dataPoints;
	}
	
	/**
	 * @return getNumberOfDataPoints
	 */
	public int getNumberOfDataPoints() {
		
		return getDataPoints().size();
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
		for (int i = 0; i < getNumberOfIterations(); ++i) {
			
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
							
						} // For (l) looping through different Clusters for matching a DataPoint.
						
					} //for variable 'l' - Looping between different Clusters for matching a Data Point.

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
		
		// TODO: Write code here that opens the file ClusteringAlgorithm.in, and print the Cluster output.
		
		/*
		 * HINT: Replace the code in lines 380-394 with code that reads from file...
		 */
		
		Vector dataPoints = new Vector();
		
		// Add dummy points.
		dataPoints.add(new DataPoint(10.0, 10.0, "P1"));
		dataPoints.add(new DataPoint(-10.0, -1.0, "Q1"));
		dataPoints.add(new DataPoint(15.0, 12.0, "P2"));
		dataPoints.add(new DataPoint(-5.0, -10.0, "Q2"));
		dataPoints.add(new DataPoint(9.0, 30.0, "P3"));
		dataPoints.add(new DataPoint(-7.5, -12.5, "Q3"));
		
		/*
		 * At this stage we may expect two clusters:
		 * - One for DataPoints with the identifier (P), and
		 * - One for DataPoints with the identifier (Q)."
		 */
		
		// Init the k-Means Clustering algorithm.
		ClusteringAlgorithm kMeans = new ClusteringAlgorithm(2, 100, dataPoints);
		
		// Invoke k-Means.
		kMeans.invoke();
		
		// Establish the current Cluster instances.
		Vector[] clusters = kMeans.getClusters();
		
		// Loop through all the Clusters.
		for (int i = 0; i < clusters.length; ++i){
			
			Vector _clusters = clusters[i];
			
			System.out.println("-- Cluster[" + i + "]:");
			
			Iterator iterator = _clusters.iterator();
			
			while (iterator.hasNext()){
				
				DataPoint point = (DataPoint)iterator.next();
				
				System.out.println(point.getIdentifier() + " (" +
					point.getX() + ", " +
					point.getY() + ")");
			}
		}
	}
}
