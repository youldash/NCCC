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

/**
 * A Centroid is calculated using an equation,
 * which in turn divides the sample space for each dimension into equal parts.
 * depending on the "numberOfClusters" parameter (as predetermined in ClusteringAlgorithm.java).
 *
 * Class Centroid holds three variables:
 * - two Cartesian (spacial) coordinates (x, y), and
 * - cluster (reference).
 */
public class Centroid {
	
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
				
		// System.out.println("(" + this.mCx + ", " + this.mCy +" )");
		
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
	public double getCluster() {
		
		return this.cluster;
	}
	
	/**
	 * @param cluster
	 */
	public void setCluster(Cluster cluster) {
		
		this.cluster = cluster;
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
