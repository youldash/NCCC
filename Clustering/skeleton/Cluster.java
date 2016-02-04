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
 * A Cluster (in the Cluster Analysis domain) relates to more than one DataPoint, and one Centroid.
 *
 * Class Cluster holds four variables:
 * - identifier (or name),
 * - centroid (reference of this Cluster),
 * - sumOfSquares, and
 * - dataPoints (as a collection or an array).
 */
public class Cluster {
	
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
		this.centroid = null; /* Will be set via setCentroid() at this stage. */
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
